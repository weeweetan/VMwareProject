package com.vmware.security.credstore;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Implementation class for CredentialStoreAdmin.
 */
class CredentialStoreImpl implements CredentialStore {
   private File cachePath;
   private boolean defaultCachePath;

   private String vmwareDirName = ".vmware";
   private String credstoreDirName = "credstore";
   private String credstoreFileName = "vicredentials.xml";

   private File getDefaultFilePath() {
      String path;
      if (File.separatorChar == '/') {
         // Linux
         path = System.getenv("HOME");
         if (path == null) {
            throw new IllegalStateException("HOME not set.");
         }
         path +=
               "/" + vmwareDirName + "/" + credstoreDirName + "/"
                     + credstoreFileName;
      } else if (File.separatorChar == '\\') {
         // Windows
         path = System.getenv("APPDATA");
         if (path == null) {
            throw new IllegalStateException("APPDATA not set.");
         }
         path += "\\VMware\\credstore\\vicredentials.xml";
      } else {
         throw new IllegalStateException("Unknown Operating System");
      }
      return new File(path);
   }

   public CredentialStoreImpl() {
      synchronized (this) {
         cachePath = getDefaultFilePath();
         defaultCachePath = true;
      }
   }

   public CredentialStoreImpl(File file) {
      synchronized (this) {
         if (file == null) {
            cachePath = getDefaultFilePath();
            defaultCachePath = true;
         } else {
            cachePath = file;
            defaultCachePath = false;
         }
      }
   }

   /**
    * Gets the password for a given host and username.
    * 
    * @return the password, or {@code null} if none is found
    */
   public synchronized char[] getPassword(String host, String username)
         throws IOException {
      CredentialStoreStorage store =
            new CredentialStoreStorage(cachePath, defaultCachePath);

      char[] pwd = store.getPassword(host, username);

      if (pwd == null) {
         return null;
      }
      return CredentialStoreObfuscate.deObfuscate(host, username, pwd);
   }

   /**
    * Stores the password for a given host and username. If a password already
    * exists for that host and username, it is overwritten.
    * 
    * @return {@code true} if a password for this host and username did not
    *         already exist
    */
   public synchronized boolean addPassword(String host, String username,
         char[] password) throws IOException {
      CredentialStoreStorage store =
            new CredentialStoreStorage(cachePath, defaultCachePath);

      return store.addEntry(host, username,
            CredentialStoreObfuscate.obfuscate(host, username, password));
   }

   /**
    * Removes the password for a given host and username. If no such password
    * exists, this method has no effect.
    * 
    * @return {@code true} if the password existed and was removed
    */
   public synchronized boolean removePassword(String host, String username)
         throws IOException {
      CredentialStoreStorage store =
            new CredentialStoreStorage(cachePath, defaultCachePath);

      return store.deleteEntry(host, username);
   }

   /**
    * Removes all passwords.
    */
   public synchronized void clearPasswords() throws IOException {
      CredentialStoreStorage store =
            new CredentialStoreStorage(cachePath, defaultCachePath);

      store.clearPasswords();
   }

   /**
    * Returns all hosts that have entries in the credential store.
    */
   public synchronized Set<String> getHosts() throws IOException {
      CredentialStoreStorage store =
            new CredentialStoreStorage(cachePath, defaultCachePath);

      return store.getHosts();
   }

   /**
    * Returns all usernames that have passwords stored for a given host.
    */
   public synchronized Set<String> getUsernames(String host) throws IOException {
      CredentialStoreStorage store =
            new CredentialStoreStorage(cachePath, defaultCachePath);

      return store.getUserNames(host);
   }

   /**
    * Closes this credential store and frees all resources associated with it.
    * No further {@code CredentialStore} methods may be invoked on this object.
    */
   public synchronized void close() {
      cachePath = null;
   }
}
