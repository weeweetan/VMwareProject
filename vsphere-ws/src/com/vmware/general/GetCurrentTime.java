package com.vmware.general;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.InvalidLocaleFaultMsg;
import com.vmware.vim25.InvalidLoginFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * GetCurrentTime
 * 
 * This sample gets the current time of the vSphere Server
 * 
 * <b>Parameters:</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.general.GetCurrentTime
 * --url [webservicesurl] --username [Username] --password [password]
 * </pre>
 */

public class GetCurrentTime {

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

   private static final ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();
   private static final String SVC_INST_NAME = "ServiceInstance";
   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;

   private static String url;
   private static String userName;
   private static String password;
   private static boolean help = false;
   private static boolean isConnected = false;

   private static void trustAllHttpsCertificates() {
      try {
         // Create a trust manager that does not validate certificate chains
         javax.net.ssl.TrustManager[] trustAllCerts =
               new javax.net.ssl.TrustManager[1];
         javax.net.ssl.TrustManager tm = new TrustAllTrustManager();
         trustAllCerts[0] = tm;
         javax.net.ssl.SSLContext sc =
               javax.net.ssl.SSLContext.getInstance("SSL");
         javax.net.ssl.SSLSessionContext sslsc = sc.getServerSessionContext();
         sslsc.setSessionTimeout(0);
         sc.init(null, trustAllCerts, null);
         HttpsURLConnection.setDefaultSSLSocketFactory(sc
               .getSocketFactory());
      } catch (KeyManagementException e) {
         throw new RuntimeException(e);
      } catch (NoSuchAlgorithmException e) {
         throw new RuntimeException(e);
      } catch (IllegalArgumentException e) {
         throw new RuntimeException(e);
      }
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
      if (url == null || userName == null || password == null) {
         throw new IllegalArgumentException(
               "Expected --url, --username, --password arguments.");
      }
   }

   /**
    * Establishes session with the vCenter server.
    * 
    * @throws RuntimeFaultFaultMsg
    * @throws InvalidLoginFaultMsg
    * @throws InvalidLocaleFaultMsg
    * 
    * @throws Exception
    *            the exception
    */
   private static void connect() throws RuntimeFaultFaultMsg,
         InvalidLocaleFaultMsg, InvalidLoginFaultMsg {

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
    * @throws RuntimeFaultFaultMsg
    * 
    * @throws Exception
    */
   private static void disconnect() throws RuntimeFaultFaultMsg {
      if (isConnected) {
         vimPort.logout(serviceContent.getSessionManager());
      }
      isConnected = false;
   }

   /**
    * This method retrieves the current time from the server and prints it.
    */
   private static void getCurrentTime() {
      try {
         XMLGregorianCalendar ct = vimPort.currentTime(SVC_INST_REF);
         SimpleDateFormat sdf =
               new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss.SSSZ");
         System.out.println("Server current time: "
               + sdf.format(ct.toGregorianCalendar().getTime()));
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
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
      System.out
            .println("This sample gets the current time of the vSphere Server");
      System.out.println("\nParameters:");
      System.out.println("url          [required] : url of the web service");
      System.out
            .println("username     [required] : username for the authentication");
      System.out
            .println("password     [required] : password for the authentication");
      System.out.println("\nCommand:");
      System.out.println("run.bat com.vmware.general.GetCurrentTime");
      System.out
            .println("--url [webservicesurl] --username [Username] --password [password]");
   }

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         if (help) {
            printUsage();
            return;
         }
         connect();
         getCurrentTime();
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
         printUsage();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println(" Connect Failed ");
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