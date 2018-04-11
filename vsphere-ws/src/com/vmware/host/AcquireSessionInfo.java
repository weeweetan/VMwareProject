package com.vmware.host;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.HostServiceTicket;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * AcquireSessionInfo
 * 
 * This sample will acquire a session with VC or ESX
 * and print a cim service ticket and related
 * session information to a file
 * 
 * <b>Parameters:</b>
 * url         [required] : url of the web service
 * username    [required] : username for the authentication
 * password    [required] : password for the authentication
 * host        [required] : Name of the host
 * info        [optional] : Type of info required
 *                          only [cimticket] for now
 * file        [optional] : Full path of the file to save data to
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.general.Browser --url [webserviceurl]
 * --username [username] --password [password]
 * --host [hostname] --info [password] --file [path_to_file]
 * </pre>
 */

public class AcquireSessionInfo {

   private static class TrustAllTrustManager1 implements
         javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
      @Override
      public java.security.cert.X509Certificate[] getAcceptedIssuers() {
         return null;
      }

      @Override
      public void checkServerTrusted(
            java.security.cert.X509Certificate[] certs, String authType)
            throws java.security.cert.CertificateException {
         return;
      }

      @Override
      public void checkClientTrusted(
            java.security.cert.X509Certificate[] certs, String authType)
            throws java.security.cert.CertificateException {
         return;
      }
   }

   private static final ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();
   private static final String SVC_INST_NAME = "ServiceInstance";
   private static VimPortType vimPort;
   private static VimService vimService;
   private static ServiceContent serviceContent;

   private static String url;
   private static String userName;
   private static String password;
   private static Boolean help = false;
   private static Boolean isConnected = false;
   private static String hostname = null;
   private static String info;
   private static String filename;
   private static ManagedObjectReference propCollectorRef = null;

   private static void trustAllHttpsCertificates() throws Exception {
      javax.net.ssl.TrustManager[] trustAllCerts =
            new javax.net.ssl.TrustManager[1];
      javax.net.ssl.TrustManager tm = new TrustAllTrustManager1();
      trustAllCerts[0] = tm;
      javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
      javax.net.ssl.SSLSessionContext sslsc = sc.getServerSessionContext();
      sslsc.setSessionTimeout(0);
      sc.init(null, trustAllCerts, null);
      HttpsURLConnection.setDefaultSSLSocketFactory(sc
            .getSocketFactory());
   }

   private static void getConnectionParameters(String[] args) {
      int ai = 0;
      String param = "";
      String val = "";
      while (ai < args.length) {
         param = args[ai].trim();
         if (ai + 1 < args.length) {
            val = args[ai + 1].trim();
         }
         if (param.equalsIgnoreCase("--help")) {
            help = true;
            break;
         } else if (param.equalsIgnoreCase("--url") && !val.startsWith("--")
               && !val.isEmpty()) {
            url = val;
         } else if (param.equalsIgnoreCase("--username")
               && !val.startsWith("--") && !val.isEmpty()) {
            userName = val;
         } else if (param.equalsIgnoreCase("--password")
               && !val.startsWith("--") && !val.isEmpty()) {
            password = val;
         }
         val = "";
         ai += 2;
      }
      if (url == null || userName == null || password == null) {
         throw new IllegalArgumentException(
               "Expected --url, --username, --password arguments.");
      }
   }

   private static void getInputParameters(String[] args) {

      int ai = 0;
      String param = "";
      String val = "";
      while (ai < args.length) {
         param = args[ai].trim();
         if (ai + 1 < args.length) {
            val = args[ai + 1].trim();
         }
         if (param.equalsIgnoreCase("--host") && !val.startsWith("--")
               && !val.isEmpty()) {
            hostname = val;
         }
         if (param.equalsIgnoreCase("--info") && !val.startsWith("--")
               && !val.isEmpty()) {
            info = val;
         }
         if (param.equalsIgnoreCase("--file") && !val.startsWith("--")
               && !val.isEmpty()) {
            filename = val;
         }
         val = "";
         ai += 2;
      }
      if (hostname == null) {
         throw new IllegalArgumentException("Expected --host argument properly");
      }
   }

   private static void connect() throws Exception {
      HostnameVerifier hv = new HostnameVerifier() {
         @Override
         public boolean verify(String urlHostName, SSLSession session) {
            return true;
         }
      };
      trustAllHttpsCertificates();
      HttpsURLConnection.setDefaultHostnameVerifier(hv);

      SVC_INST_REF.setType(SVC_INST_NAME);
      SVC_INST_REF.setValue(SVC_INST_NAME);

      vimService = new VimService();
      vimPort = vimService.getVimPort();
      Map<String, Object> ctxt =
            ((BindingProvider) vimPort).getRequestContext();

      ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
      ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

      serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF);
      vimPort.login(serviceContent.getSessionManager(), userName, password,
            null);
      isConnected = true;
      propCollectorRef = serviceContent.getPropertyCollector();
   }

   private static void disconnect() throws Exception {
      if (isConnected) {
         vimPort.logout(serviceContent.getSessionManager());
      }
      isConnected = false;
   }

   /**
    * 
    * @return TraversalSpec specification to get to the HostSystem managed
    *         object.
    */
   private static TraversalSpec getHostSystemTraversalSpec() {
      // Create a traversal spec that starts from the 'root' objects
      // and traverses the inventory tree to get to the Host system.
      // Build the traversal specs bottoms up
      SelectionSpec ss = new SelectionSpec();
      ss.setName("VisitFolders");

      // Traversal to get to the host from ComputeResource
      TraversalSpec computeResourceToHostSystem = new TraversalSpec();
      computeResourceToHostSystem.setName("computeResourceToHostSystem");
      computeResourceToHostSystem.setType("ComputeResource");
      computeResourceToHostSystem.setPath("host");
      computeResourceToHostSystem.setSkip(false);
      computeResourceToHostSystem.getSelectSet().add(ss);

      // Traversal to get to the ComputeResource from hostFolder
      TraversalSpec hostFolderToComputeResource = new TraversalSpec();
      hostFolderToComputeResource.setName("hostFolderToComputeResource");
      hostFolderToComputeResource.setType("Folder");
      hostFolderToComputeResource.setPath("childEntity");
      hostFolderToComputeResource.setSkip(false);
      hostFolderToComputeResource.getSelectSet().add(ss);

      // Traversal to get to the hostFolder from DataCenter
      TraversalSpec dataCenterToHostFolder = new TraversalSpec();
      dataCenterToHostFolder.setName("DataCenterToHostFolder");
      dataCenterToHostFolder.setType("Datacenter");
      dataCenterToHostFolder.setPath("hostFolder");
      dataCenterToHostFolder.setSkip(false);
      dataCenterToHostFolder.getSelectSet().add(ss);

      //TraversalSpec to get to the DataCenter from rootFolder
      TraversalSpec traversalSpec = new TraversalSpec();
      traversalSpec.setName("VisitFolders");
      traversalSpec.setType("Folder");
      traversalSpec.setPath("childEntity");
      traversalSpec.setSkip(false);

      List<SelectionSpec> sSpecArr = new ArrayList<SelectionSpec>();
      sSpecArr.add(ss);
      sSpecArr.add(dataCenterToHostFolder);
      sSpecArr.add(hostFolderToComputeResource);
      sSpecArr.add(computeResourceToHostSystem);
      traversalSpec.getSelectSet().addAll(sSpecArr);
      return traversalSpec;
   }

   /**
    * Uses the new RetrievePropertiesEx method to emulate the now deprecated
    * RetrieveProperties method
    * 
    * @param listpfs
    * @return list of object content
    * @throws Exception
    */

   private static List<ObjectContent> retrievePropertiesAllObjects(
         List<PropertyFilterSpec> listpfs) throws Exception {

      RetrieveOptions propObjectRetrieveOpts = new RetrieveOptions();

      List<ObjectContent> listobjcontent = new ArrayList<ObjectContent>();

      try {
         RetrieveResult rslts =
               vimPort.retrievePropertiesEx(propCollectorRef, listpfs,
                     propObjectRetrieveOpts);
         if (rslts != null && rslts.getObjects() != null
               && !rslts.getObjects().isEmpty()) {
            listobjcontent.addAll(rslts.getObjects());
         }
         String token = null;
         if (rslts != null && rslts.getToken() != null) {
            token = rslts.getToken();
         }
         while (token != null && !token.isEmpty()) {
            rslts =
                  vimPort.continueRetrievePropertiesEx(propCollectorRef, token);
            token = null;
            if (rslts != null) {
               token = rslts.getToken();
               if (rslts.getObjects() != null && !rslts.getObjects().isEmpty()) {
                  listobjcontent.addAll(rslts.getObjects());
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println(" : Failed Getting Contents");
         e.printStackTrace();
      }
      return listobjcontent;
   }

   /**
    * Retrieves the MOREF of the host.
    * 
    * @param hostName
    * 
    * @return
    */
   private static ManagedObjectReference getHostByHostName(String hostName) {
      ManagedObjectReference retVal = null;
      ManagedObjectReference rootFolder = serviceContent.getRootFolder();
      try {
         TraversalSpec tSpec = getHostSystemTraversalSpec();
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add("name");
         propertySpec.setType("HostSystem");

         // Now create Object Spec
         ObjectSpec objectSpec = new ObjectSpec();
         objectSpec.setObj(rootFolder);
         objectSpec.setSkip(Boolean.TRUE);
         objectSpec.getSelectSet().add(tSpec);

         // Create PropertyFilterSpec using the PropertySpec and ObjectPec
         // created above.
         PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
         propertyFilterSpec.getPropSet().add(propertySpec);
         propertyFilterSpec.getObjectSet().add(objectSpec);
         List<PropertyFilterSpec> listpfs =
               new ArrayList<PropertyFilterSpec>(1);
         listpfs.add(propertyFilterSpec);
         List<ObjectContent> listobjcont =
               retrievePropertiesAllObjects(listpfs);

         if (listobjcont != null) {
            for (ObjectContent oc : listobjcont) {
               ManagedObjectReference mr = oc.getObj();
               String hostnm = null;
               List<DynamicProperty> listDynamicProps = oc.getPropSet();
               DynamicProperty[] dps =
                     listDynamicProps
                           .toArray(new DynamicProperty[listDynamicProps.size()]);
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     hostnm = (String) dp.getVal();
                  }
               }
               if (hostnm != null && hostnm.equals(hostName)) {
                  retVal = mr;
                  break;
               }
            }
         } else {
            System.out.println("The Object Content is Null");
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return retVal;
   }

   private static String stringToWrite(HostServiceTicket serviceTicket) {
      String sslThumbprint = "undefined";
      String host = "undefined";
      String port = "undefined";
      String service = serviceTicket.getService();
      String serviceVersion = serviceTicket.getServiceVersion();
      String serviceSessionId = serviceTicket.getSessionId();

      if (serviceTicket.getSslThumbprint() != null) {
         sslThumbprint = serviceTicket.getSslThumbprint();

      }
      if (serviceTicket.getHost() != null) {
         host = serviceTicket.getHost();

      }
      if (serviceTicket.getPort() != null) {
         port = Integer.toString(serviceTicket.getPort());

      }
      StringBuilder datatowrite = new StringBuilder("");
      datatowrite.append("CIM Host Service Ticket Information\n");
      datatowrite.append("Service        : ");
      datatowrite.append(service);
      datatowrite.append("\n");
      datatowrite.append("Service Version: ");
      datatowrite.append(serviceVersion);
      datatowrite.append("\n");
      datatowrite.append("Session Id     : ");
      datatowrite.append(serviceSessionId);
      datatowrite.append("\n");
      datatowrite.append("SSL Thumbprint : ");
      datatowrite.append(sslThumbprint);
      datatowrite.append("\n");
      datatowrite.append("Host           : ");
      datatowrite.append(host);
      datatowrite.append("\n");
      datatowrite.append("Port           : ");
      datatowrite.append(port);
      datatowrite.append("\n");
      System.out.println("CIM Host Service Ticket Information\n");
      System.out.println("Service           : " + service);
      System.out.println("Service Version   : " + serviceVersion);
      System.out.println("Session Id        : " + serviceSessionId);
      System.out.println("SSL Thumbprint    : " + sslThumbprint);
      System.out.println("Host              : " + host);
      System.out.println("Port              : " + port);
      return datatowrite.toString();
   }

   private static void acquireSessionInfo() throws Exception {
      ManagedObjectReference hostmor = getHostByHostName(hostname);

      if (hostmor == null) {
         String msg = "Failure: Host [ " + hostname + "] not found";
         throw new Exception(msg);
      }

      if ((info == null) || (info.equalsIgnoreCase("cimticket"))) {

         HostServiceTicket serviceTicket =
               vimPort.acquireCimServicesTicket(hostmor);

         if (serviceTicket != null) {
            String datatoWrite = stringToWrite(serviceTicket);
            writeToFile(datatoWrite, filename);
         }
      } else {
         System.out.println("Support for " + info + " not implemented.");
      }
   }

   private static void writeToFile(String data, String fileName)
         throws IOException {
      fileName = fileName == null ? "cimTicketInfo.txt" : fileName;
      File cimFile = new File(fileName);
      FileOutputStream fop = new FileOutputStream(cimFile);
      if (cimFile.exists()) {
         String str = data;
         fop.write(str.getBytes());
         fop.flush();
         fop.close();
         System.out.println("Saved session information at "
               + cimFile.getAbsolutePath());
      }
   }

   private static void printSoapFaultException(SOAPFaultException sfe) {
      System.out.println("SOAP Fault -");
      if (sfe.getFault().hasDetail()) {
         System.out.println(sfe.getFault().getDetail().getFirstChild()
               .getLocalName());
      }
      if (sfe.getFault().getFaultString() != null) {
         System.out.println("\n Message: " + sfe.getFault().getFaultString());
      }
   }

   private static void printUsage() {
      System.out.println("This sample will acquire a session with VC or ESX"
            + "and print a cim service ticket and related "
            + "session information to a file.");
      System.out.println("\nParameters:");
      System.out.println("url         [required] : url of the web service");
      System.out
            .println("username    [required] : username for the authentication");
      System.out
            .println("password    [required] : password for the authentication");
      System.out.println("host        [required] : Name of the host");
      System.out.println("info        [optional] : Type of info required");
      System.out.println("                         only [cimticket] for now");
      System.out
            .println("file        [optional] : Location of file to save data to");
      System.out.println("\nCommand:");
      System.out
            .println("run.bat com.vmware.general.Browser --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out
            .println("--host [hostname] --info [password] --file [path_to_file]");
   }

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         getInputParameters(args);
         if (help) {
            printUsage();
            return;
         }
         connect();
         acquireSessionInfo();
      } catch (IllegalArgumentException iae) {
         printUsage();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            disconnect();
         } catch (SOAPFaultException sfe) {
            printSoapFaultException(sfe);
         } catch (Exception e) {
            System.out.println("Failed to disconnect - " + e.getMessage());
            e.printStackTrace();
         }
      }
   }
}
