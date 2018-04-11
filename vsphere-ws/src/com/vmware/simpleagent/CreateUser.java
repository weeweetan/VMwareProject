package com.vmware.simpleagent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.security.credstore.CredentialStore;
import com.vmware.security.credstore.CredentialStoreFactory;
import com.vmware.vim25.HostAccountSpec;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.Permission;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * CreateUser
 * 
 * The CreateUser class creates a user account and password stores them the local  credential store.
 * CreateUser should be used in conjunction with the  {@link SimpleAgent} sample application only.
 * CreateUser generates an arbitrary user name (Usernnnn, where nnnn is  a psuedo-randomly generated number)
 * and password and stores them in the credential store on the local machine.
 * CreateUser works with ESX or ESXi only (not vCenter)
 * 
 * <b>Parameters:</b>
 * url              [required] : url of the web service
 * username         [required] : username for the authentication
 * password         [required] : password for the authentication
 * server           [optional] : server for which username and password are to be added
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.simpleagent.CreateUser --server [myServerName] --url [URLString]
 * --username [User] --password [Password]
 * </pre>
 */
public class CreateUser {

   private static class TrustAllTrustManager implements
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

   /* Start Server Connection and common code */
   private static final String SVC_INST_NAME = "ServiceInstance";
   private static final ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();
   private static ServiceContent serviceContent = null;
   private static VimService vimService = null;
   private static VimPortType vimPort = null;

   /*
   Connection input parameters
    */
   private static String url = null;
   private static boolean help = false;
   private static String userName = null;
   private static String password = null;
   private static String server = null;
   private static boolean isConnected = false;

   private static void trustAllHttpsCertificates() throws Exception {

      javax.net.ssl.TrustManager[] trustAllCerts =
            new javax.net.ssl.TrustManager[1];
      javax.net.ssl.TrustManager tm = new TrustAllTrustManager();
      trustAllCerts[0] = tm;
      javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
      javax.net.ssl.SSLSessionContext sslsc = sc.getServerSessionContext();
      sslsc.setSessionTimeout(0);
      sc.init(null, trustAllCerts, null);
      HttpsURLConnection.setDefaultSSLSocketFactory(sc
            .getSocketFactory());
   }

   // get common parameters
   private static void getConnectionParameters(String[] args)
         throws IllegalArgumentException {
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
      if (userName == null || password == null) {
         throw new IllegalArgumentException(
               "Expected --url, --username, --password arguments.");
      }
   }

   // get imput parameters to run the sample
   private static void getInputParameters(String[] args) {
      int ai = 0;
      String param = "";
      String val = "";
      while (ai < args.length) {
         param = args[ai].trim();
         if (ai + 1 < args.length) {
            val = args[ai + 1].trim();
         }
         if (param.equalsIgnoreCase("--server") && !val.startsWith("--")
               && !val.isEmpty()) {
            server = val;
         }
         val = "";
         ai += 2;
      }
   }

   /**
    * Establishes session with the virtual center server.
    * 
    * @throws Exception
    *            the exception
    */
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
   }

   /**
    * Disconnects the user session.
    * 
    * @throws Exception
    */
   private static void disconnect() throws Exception {
      if (isConnected) {
         vimPort.logout(serviceContent.getSessionManager());
      }
      isConnected = false;
   }

   private static String generateUserName() {
      int rawRandomNumber = (int) (Math.random() * (256 - 32 + 1)) + 32;
      String user = "user" + Integer.toString(rawRandomNumber);
      return user;
   }


   private static String generatePassword() {
      int rawRandomNumber = (int) (Math.random() * (256 - 32 + 1)) + 32;
      String passwd = "passwd" + Integer.toString(rawRandomNumber);
      return passwd;
   }

   private static String getServerName() {
      if (server != null) {
         return server;
      } else {
         String urlString = url;
         if (urlString.indexOf("https://") != -1) {
            int sind = 8;
            int lind = urlString.indexOf("/sdk");
            return urlString.substring(sind, lind);
         } else if (urlString.indexOf("http://") != -1) {
            int sind = 7;
            int lind = urlString.indexOf("/sdk");
            return urlString.substring(sind, lind);
         } else {
            return urlString;
         }
      }
   }

   private static void createUser() throws Exception {
      ManagedObjectReference hostLocalAccountManager =
            serviceContent.getAccountManager();


      ManagedObjectReference hostAuthorizationManager =
            serviceContent.getAuthorizationManager();
      userName = generateUserName();
      password = generatePassword();


      HostAccountSpec hostAccountSpec = new HostAccountSpec();
      hostAccountSpec.setId(userName);
      hostAccountSpec.setPassword(password);
      hostAccountSpec.setDescription("User Description");
      vimPort.createUser(hostLocalAccountManager, hostAccountSpec);

      ManagedObjectReference rootFolder = serviceContent.getRootFolder();

      /* For demonstration purposes only, the account is granted
         the 'administrator' role (-1) on the rootFolder of the inventory.
        Never give users more privileges than absolutely necessary.
       */

      Permission per = new Permission();
      per.setGroup(false);
      per.setPrincipal(userName);
      per.setRoleId(-1);
      per.setPropagate(true);
      per.setEntity(rootFolder);
      List<Permission> permissions = new ArrayList<Permission>();
      permissions.add(per);
      vimPort.setEntityPermissions(hostAuthorizationManager, rootFolder,
            permissions);


      CredentialStore csObj = CredentialStoreFactory.getCredentialStore();
      csObj.addPassword(getServerName(), userName, password.toCharArray());
      System.out.println("Successfully created user and populated the "
            + "credential store");
   }

   private static void customValidate() throws Exception {
      String apiType = serviceContent.getAbout().getApiType();
      if (apiType.equalsIgnoreCase("VirtualCenter")) {
         System.out.println("CreateUser works with ESX and ESXi only.");
         throw new IllegalArgumentException(
               "CreateUser does not run on vCenter Server");
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

   // method to print help on how to run the sample
   private static void printUsage() {
      System.out.println("The CreateUser class creates a user account and "
            + "password stores them the local  credential store");
      System.out.println("\nParameters:");
      System.out
            .println("url              [required] : url of the web service.");
      System.out
            .println("username         [required] : username for the authentication");
      System.out
            .println("password         [required] : password for the authentication");
      System.out
            .println("server           [optional] : server for which username and password are to be added");
      System.out.println("\nCommand:");
      System.out.println("run.bat com.vmware.simpleagent.CreateUser "
            + "--server myServerName --url [URLString] "
            + "--username [User] --password [Password]");
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
         CreateUser.customValidate();
         CreateUser.createUser();
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
