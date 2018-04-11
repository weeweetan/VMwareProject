package com.vmware.security.credstore;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/*
 *  This class provides the same functionality as FileInputStream, except that
 *  the close() method is overridden so that FileInputStream class close() do
 *  not get called.
 *  This behavior is need as DocumentBuilder.parse() closes the FD that is passed to it,
 *  once the parsing of XML is over. If that happens, the file whose FD we have passed will
 *  be closed and it will be unlocked.
 */

/**
 * The Class FileInputStreamNoClose.
 */
class FileInputStreamNoClose extends FileInputStream {
   public FileInputStreamNoClose(FileDescriptor fd) {
      super(fd);
   }

   @Override
   public void close() {
      // Do not close the FD.
   }
}

/**
 * The Class CredentialStoreStorage.
 */
class CredentialStoreStorage {
   private final String docRoot = "viCredentials";
   private final String versionTag = "version";
   private final String cacheEntryTag = "passwordEntry";
   private final String hostnameTag = "host";
   private final String usernameTag = "username";
   private final String passwordTag = "password";

   /**
    * The Class Key.
    */
   private static class Key implements Comparable<Key> {
      String hostname;
      String username;

      Key(String hostname, String username) {
         this.hostname = hostname;
         this.username = username;
      }

      @Override
      public int compareTo(Key other) {
         int comp = hostname.compareToIgnoreCase(other.hostname);
         if (comp == 0) {
            comp = username.compareTo(other.username);
         }
         return comp;
      }
   }

   private Map<Key, String> cacheData;
   private String cacheVersion;
   private int entryCount;

   private final File cachePath;
   private final boolean defaultCachePath;
   private FileLock lock;
   private RandomAccessFile inoutFile;

   public CredentialStoreStorage(File path, boolean defaultPath)
         throws IOException {
      if (path == null) {
         throw new IOException("Store not initialised.");
      }
      cachePath = path;
      defaultCachePath = defaultPath;
   }

   private void getReadLock() throws IOException {
      inoutFile = new RandomAccessFile(cachePath, "r");
      FileChannel channel = inoutFile.getChannel();
      lock = channel.tryLock(0, 1, true);
      int cnt = 1;
      while (lock == null) {
         try {
            // Sleep for cnt number of seconds.
            // Increment the wait by 1 second in each iteration.
            Thread.sleep(cnt * 1000);
         } catch (InterruptedException e) {
         }
         lock = channel.tryLock(0, 1, true);
         ++cnt;
         if (cnt == 12) {
            // Total wait will be around 1 minute.
            break;
         }
      }
      if (lock == null) {
         throw new IOException("Unable to acquire a read lock");
      }
   }

   private void getWriteLock() throws IOException {
      inoutFile = new RandomAccessFile(cachePath, "rw");
      FileChannel channel = inoutFile.getChannel();
      lock = channel.tryLock();
      int cnt = 1;
      while (lock == null) {
         try {
            // Sleep for cnt number of seconds.
            // Increment the wait by 1 second in each iteration.
            Thread.sleep(cnt * 1000);
         } catch (InterruptedException e) {
         }
         lock = channel.tryLock();
         ++cnt;
         if (cnt == 12) {
            // Total wait will be around 1 minute.
            break;
         }
      }
      if (lock == null) {
         throw new IOException("Unable to acquire a write lock");
      }
   }

   private void releaseLock() throws IOException {
      // Need to check for null as lock will be released in "finally" and that
      // will execute even if we failed to acquire the lock.
      if (lock != null) {
         lock.release();
      }
      inoutFile.close();
      inoutFile = null;
   }

   private void storeCache() throws IOException {
      try {
         DocumentBuilderFactory domFactory =
               DocumentBuilderFactory.newInstance();
         DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
         Document doc = domBuilder.newDocument();

         Element root = doc.createElement(docRoot);
         doc.appendChild(root);

         if (cacheVersion == null) {
            throw new IOException(
                  "Empty credentials store state. Nothing to write");
         }

         Element verNode = doc.createElement(versionTag);
         Text verText = doc.createTextNode(cacheVersion);
         verNode.appendChild(verText);
         root.appendChild(verNode);

         if (cacheData != null) {
            for (Key key : cacheData.keySet()) {
               Element cacheEntry = doc.createElement(cacheEntryTag);

               Element hostnameEntry = doc.createElement(hostnameTag);
               hostnameEntry.appendChild(doc.createTextNode(key.hostname));
               cacheEntry.appendChild(hostnameEntry);

               Element usernameEntry = doc.createElement(usernameTag);
               usernameEntry.appendChild(doc.createTextNode(key.username));
               cacheEntry.appendChild(usernameEntry);

               Element passwordEntry = doc.createElement(passwordTag);
               passwordEntry.appendChild(doc.createTextNode(cacheData
                     .get(new Key(key.hostname, key.username))));
               cacheEntry.appendChild(passwordEntry);

               root.appendChild(cacheEntry);
            }
         }

         TransformerFactory transFact = TransformerFactory.newInstance();
         Transformer trans = transFact.newTransformer();
         // For pretty output. It doesn't work in jdk1.5
         trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount",
               "4");
         trans.setOutputProperty(OutputKeys.INDENT, "yes");

         StringWriter sw = new StringWriter();
         StreamResult result = new StreamResult(sw);
         DOMSource source = new DOMSource(doc);
         trans.transform(source, result);
         String xmlString = sw.toString();

         // Truncate the file else the data will be appended to the existing one.
         inoutFile.setLength(0);
         inoutFile.write(xmlString.getBytes("UTF-8"));
      } catch (ParserConfigurationException e) {
         throw (IOException) new IOException(e.toString()).initCause(e);
      } catch (TransformerConfigurationException e) {
         throw (IOException) new IOException(e.toString()).initCause(e);
      } catch (TransformerException e) {
         throw (IOException) new IOException(e.toString()).initCause(e);
      }
   }

   private void loadCache() throws IOException {
      try {
         DocumentBuilderFactory domFactory =
               DocumentBuilderFactory.newInstance();
         DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
         // Pass the FileInputStreamNoClose object to parse() so that the function
         // do not close the fd, as thats what it will do otherwise.
         FileInputStream inStream =
               new FileInputStreamNoClose(inoutFile.getFD());
         Document doc = domBuilder.parse(inStream);

         // Verify the document root.
         if (doc.getDocumentElement().getNodeName() != docRoot) {
            throw new IOException("Invalid document root: "
                  + doc.getDocumentElement().getNodeName());
         }

         // Get the Cache Version.
         NodeList versionList = doc.getElementsByTagName(versionTag);
         if (versionList.getLength() != 1) {
            throw new IOException(
                  "Missing/too many credentials store version entry");
         }
         Node versionNode = versionList.item(0);
         cacheVersion = versionNode.getFirstChild().getNodeValue();

         // Load all the cache entries.
         NodeList entryList = doc.getElementsByTagName(cacheEntryTag);
         entryCount = entryList.getLength();
         cacheData = new TreeMap<Key, String>();
         for (int i = 0; i < entryCount; ++i) {
            String hostname = null;
            String username = null;
            String password = null;

            Node entryNode = entryList.item(i);
            NodeList childList = entryNode.getChildNodes();

            for (int j = 0; j < childList.getLength(); ++j) {
               Node childElem = childList.item(j);

               if (childElem.getNodeName() == hostnameTag) {
                  hostname = childElem.getFirstChild().getNodeValue();
               } else if (childElem.getNodeName() == usernameTag) {
                  username = childElem.getFirstChild().getNodeValue();
               } else if (childElem.getNodeName() == passwordTag) {
                  password = childElem.getFirstChild().getNodeValue();
               }
            }
            if ((hostname == null) || (username == null) || (password == null)) {
               throw new IOException("Missing element(s) in credentials store.");
            }
            cacheData.put(new Key(hostname, username), password);
         }
      } catch (ParserConfigurationException e) {
         throw (IOException) new IOException(e.toString()).initCause(e);
      } catch (SAXException e) {
         throw (IOException) new IOException(e.toString()).initCause(e);
      }
   }

   public char[] getPassword(String hostname, String username)
         throws IOException {
      if (cachePath.isDirectory()) {
         throw new IOException(
               "Credentials store file path do not contain filename.");
      }

      if (!cachePath.exists()) {
         return null;
      }

      try {
         getReadLock();
         loadCache();
      } finally {
         releaseLock();
      }

      Key compareKey = new Key(hostname, username);
      if (cacheData != null) {
         for (Key key : cacheData.keySet()) {
            if (key.compareTo(compareKey) == 0) {
               return cacheData.get(key).toCharArray();
            }
         }
      }

      // Entry in cache not found.
      return null;
   }

   public boolean deleteEntry(String hostname, String username)
         throws IOException {
      if (cachePath.isDirectory()) {
         throw new IOException(
               "Credentials store file path do not contain filename.");
      }

      if (!cachePath.exists()) {
         return false;
      }

      try {
         getWriteLock();
         loadCache();

         Key compareKey = new Key(hostname, username);
         if (cacheData != null) {
            boolean removed = cacheData.keySet().remove(compareKey);
            if (removed) {
               System.out.println("Removing entry from the credstore...");
               storeCache();
            }
            return removed;
         }
      } finally {
         releaseLock();
      }

      // Entry not present.
      return false;
   }

   public boolean addEntry(String hostname, String username, char[] password)
         throws IOException {
      if (cachePath.isDirectory()) {
         throw new IOException(
               "Credentials store file path do not contain filename.");
      }

      if (!cachePath.exists()) {
         String pathStr = cachePath.getParent();

         File path;
         if (pathStr != null) {
            // The path string contains parent directories.
            path = new File(pathStr);

            if (!path.exists()) {
               // Cache path do not exists.
               if (defaultCachePath) {
                  // Go ahead and create.
                  path.mkdirs();
                  if (File.separatorChar == '/') {
                     // For Linux
                     Runtime rtObj = Runtime.getRuntime();
                     rtObj.exec("chmod 0700 " + path.getPath());
                     cachePath.createNewFile();
                     rtObj.exec("chmod 0600 " + cachePath.getPath());
                  } else {
                     // Windows: The default permissions assigned under Windows is sufficiently restrictive. Hence, do nothing.
                  }
               } else {
                  throw new IOException(
                        "Credentials store file path do not exist.");
               }
            } else {
               // File is to be created in the current directory only.
               // Go ahead and create.
               cachePath.createNewFile();
               if (File.separatorChar == '/') {
                  // For Linux only
                  Runtime rtObj = Runtime.getRuntime();
                  rtObj.exec("chmod 0600 " + cachePath.getPath());
               }
            }
         }
      }

      try {
         getWriteLock();
         if (inoutFile.length() > 0) {
            // File was not created above but it already existed and contain some data, so try to read it.
            loadCache();
         }

         if (cacheData != null) {
            boolean replaced =
                  cacheData.put(new Key(hostname, username), new String(
                        password)) != null;
            storeCache();
            return !replaced;
         } else {
            cacheData = new TreeMap<Key, String>();
            cacheVersion = "1.0";
            entryCount = 0;
         }

         // Add new username, password entry.
         cacheData.put(new Key(hostname, username), new String(password));

         storeCache();
      } finally {
         releaseLock();
      }
      return true;
   }

   public void clearPasswords() throws IOException {
      if (cachePath.isDirectory()) {
         throw new IOException(
               "Credentials store file path do not contain filename.");
      }

      if (!cachePath.exists()) {
         return;
      }

      try {
         getWriteLock();
         // Set the cache to empty state.
         cacheData = null;
         cacheVersion = "1.0";
         entryCount = 0;
         System.out.println("Clearing all entries from the credstore...");
         storeCache();
      } finally {
         releaseLock();
      }
   }

   public Set<String> getHosts() throws IOException {
      if (cachePath.isDirectory()) {
         throw new IOException(
               "Credentials store file path do not contain filename.");
      }

      if (!cachePath.exists()) {
         return new HashSet<String>();
      }

      try {
         getReadLock();
         loadCache();
      } finally {
         releaseLock();
      }

      HashSet<String> set = new HashSet<String>();

      for (Key key : cacheData.keySet()) {
         set.add(key.hostname);
      }

      return set;
   }

   public Set<String> getUserNames(String hostname) throws IOException {
      if (cachePath.isDirectory()) {
         throw new IOException(
               "Credentials store file path do not contain filename.");
      }

      if (!cachePath.exists()) {
         return new HashSet<String>();
      }

      try {
         getReadLock();
         loadCache();
      } finally {
         releaseLock();
      }

      HashSet<String> set = new HashSet<String>();

      if (cacheData != null) {
         for (Key key : cacheData.keySet()) {
            if (hostname.compareToIgnoreCase(key.hostname) == 0) {
               set.add(key.username);
            }
         }
      }

      return set;
   }
}
