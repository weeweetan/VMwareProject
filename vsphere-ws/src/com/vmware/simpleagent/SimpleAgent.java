package com.vmware.simpleagent;

import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.security.credstore.CredentialStore;
import com.vmware.security.credstore.CredentialStoreAdmin;
import com.vmware.security.credstore.CredentialStoreFactory;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * SimpleAgent
 * 
 * The SimpleAgent class uses the local credential store to obtain user account
 * and password information, for automated logon to the target host system.
 * SimpleAgent can be used with {@link CreateUser}, to
 * demonstrate using the {@link CredentialStore} client API.
 * SimpleAgent accesses the local credential store to obtain a single user
 * account to login to the specified server (--hostName is the only command-line
 * argument). If more than one user account exists in the credential store,
 * an error message displays.
 * To create user accounts and store them in the local credential store, use
 * the {@link CredentialStoreAdmin} client utility.
 * 
 * <b>Parameters:</b>
 * hostName           [optional] : The fully-qualified domain name of the server
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.simpleagent.SimpleAgent --hostName [myServerName]
 * </pre>
 */
public class SimpleAgent {

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

   private static boolean isConnected = false;

   /*
    *Connection input parameters
    */

   private static String hostName = null;

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

   // get input parameters to run the sample
   private static void getInputParameters(String[] args) {
      int ai = 0;
      String param = "";
      String val = "";
      while (ai < args.length) {
         param = args[ai].trim();
         if (ai + 1 < args.length) {
            val = args[ai + 1].trim();
         }
         if (param.equalsIgnoreCase("--hostname") && !val.startsWith("--")
               && !val.isEmpty()) {
            hostName = val;
         }
         if (hostName == null) {
            throw new IllegalArgumentException("Expected --hostname arguments.");
         }
         val = "";
         ai += 2;
      }
   }

   private static void connectAndLogin() throws Exception {

      CredentialStore csObj = CredentialStoreFactory.getCredentialStore();

      String userName = "";
      Set<String> userNames = csObj.getUsernames(hostName);
      if (userNames.size() == 0) {
         System.out.println("No user found in this host");
         return;
      } else if (userNames.size() > 1) {
         System.out.println("Found two users for this host");
         return;
      } else {
         Object[] names = userNames.toArray();
         userName = (String) names[0];
      }

      String url = "https://" + hostName + "/sdk/vimService";
      char[] arr = csObj.getPassword(hostName, userName);
      String password = new String(arr);

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

      System.out.println("Connected Successfully "
            + serviceContent.getAbout().getFullName());
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
      System.out
            .println("The SimpleAgent class uses the local credential store to obtain "
                  + "user account and password information, for automated logon to the target host system");
      System.out.println("\nParameters:");
      System.out
            .println("hostname         [required] : The fully-qualified domain name of the server.");
      System.out.println("\nCommand:");
      System.out
            .println("run.bat com.vmware.simpleagent.SimpleAgent --hostName targetserver");
   }

   /**
    * @param args
    */
   public static void main(String[] args) {
      try {
         getInputParameters(args);
         if (hostName == null) {
            printUsage();
            return;
         }
         SimpleAgent.connectAndLogin();
      } catch (IllegalArgumentException ex) {
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
