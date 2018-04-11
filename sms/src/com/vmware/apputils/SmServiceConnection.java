package com.vmware.apputils;

import com.vmware.vim25.*;
import com.vmware.vim.sms.*;

import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.*;
import javax.xml.ws.handler.MessageContext;

import com.sun.xml.internal.ws.developer.WSBindingProvider;
import com.sun.xml.internal.ws.api.message.Headers;

/**
 * <pre>
 * 
 * SmServiceConnection.java
 *
 * Connection management utility for the Storage Monitoring Service.
 */

public class SmServiceConnection {

   private static class TrustAllTrustManager
                       implements javax.net.ssl.TrustManager,
                                  javax.net.ssl.X509TrustManager {

      public java.security.cert.X509Certificate[] getAcceptedIssuers() {
         return null;
      }

      public boolean isServerTrusted(
                     java.security.cert.X509Certificate[] certs) {
         return true;
      }

      public boolean isClientTrusted(
                     java.security.cert.X509Certificate[] certs) {
         return true;
      }

      public void checkServerTrusted(
                  java.security.cert.X509Certificate[] certs,
                  String authType)
                     throws java.security.cert.CertificateException {
         return;
      }

      public void checkClientTrusted(
                  java.security.cert.X509Certificate[] certs,
                  String authType)
                     throws java.security.cert.CertificateException {
         return;
      }
   }

   private final ManagedObjectReference VIM_SVC_INST_REF = new ManagedObjectReference();
   private final ManagedObjectReference SMS_SVC_INST_REF = new ManagedObjectReference();

   private final String VIM_SVC_INST_NAME = "ServiceInstance";
   private final String SMS_SVC_INST_NAME = "ServiceInstance";
   private final String SMS_SVC_INST_TYPE = "SmsServiceInstance";

   private VimService vimService;
   private VimPortType vimPort;
   private SmsService smsService;
   private SmsPortType smsPort;
   private ServiceContent vimServiceContent;

   private String vimHost;
   private String userName;
   private String password;
   private String sessionCookie;

   /*
    * Set the managed object reference type, and value to
    * ServiceInstance.
    */
   private void initSvcInstRef() {
      VIM_SVC_INST_REF.setType(VIM_SVC_INST_NAME);
      VIM_SVC_INST_REF.setValue(VIM_SVC_INST_NAME);

      SMS_SVC_INST_REF.setType(SMS_SVC_INST_TYPE);
      SMS_SVC_INST_REF.setValue(SMS_SVC_INST_NAME);
   }

   /**
    * Establishes connection with the web service port on the vCenter
    * server.
    * 
    * @param url URL of the vCenter Server (https://<Server IP / host name>/sdk)
    */
   private void initVimPort(String url) throws Exception {
      vimService = new VimService();
      vimPort = vimService.getVimPort();
      java.util.Map<String, Object> ctxt = ((BindingProvider) vimPort).getRequestContext();
      ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
      ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
   }

   /**
    * Establishes connection with the web service port on the SMS
    * server.
    * 
    * @param url URL of the vCenter Server (https://<Server IP / host name>/sdk)
    */
   private void initSmsPort(String vimUrl) throws Exception {
      String smsUrl = vimUrl.replace("/sdk", "/sms/sdk");

      smsService = new SmsService();
      smsPort = smsService.getSmsPort();
      java.util.Map<String, Object> ctxt = ((BindingProvider) smsPort).getRequestContext();
      ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, smsUrl);
      ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
      
      WSBindingProvider bp = (WSBindingProvider) smsPort;
      bp.setOutboundHeaders(
         Headers.create(new javax.xml.namespace.QName("vcSessionCookie"), sessionCookie));
   }

   /*
    * Invbokes all the initialization methods required in order.
    */
   private void initAll() throws Exception {
      //These following methods have to be called in this order.
      initSvcInstRef();
      initVimPort(vimHost);
      initVimServiceContent();
      connect(vimHost, userName, password);
      initSmsPort(vimHost);
   }

   /*
    * Inits the vCenter ServiceContent.
    */
   private void initVimServiceContent() throws Exception {
      if (vimServiceContent == null) {
         vimServiceContent = vimPort.retrieveServiceContent(VIM_SVC_INST_REF);
         if (vimServiceContent == null) {
            throw new Exception("Could not get Service Content");
         }

         java.util.Map<String, Object> ctxt = ((BindingProvider) vimPort).getResponseContext();
         java.util.Map<String, List> headers =
            (java.util.Map<String, List>) ctxt.get(MessageContext.HTTP_RESPONSE_HEADERS);

         if(headers == null) {
            System.out.println("WARNING: Failed to read HTTP headers for connection");
            return;
         }
         List cookies = headers.get("Set-cookie");
         if(cookies == null) {
            System.out.println("WARNING: Failed to read cookie header for connection");
            return;
         }
         String cookieStr = (String) cookies.get(0);

         String[] tokens = cookieStr.split(";");
         tokens = tokens[0].split("=");

         sessionCookie = tokens[1];
      }
   }

   /**
    * Establishes session with the vCenter server
    *
    * @param url The URL of the vCenter server
    * @param uname The user name for the session
    * @param pword The password for the user
    *
    * @throws Exception
    */
   private void connect(String url, String uname, String pword) throws Exception {
      vimPort.login(vimServiceContent.getSessionManager(), uname, pword, null);
   }

   /*
    * Disconnects the user session.
    *
    * @throws Exception
    */
   private void disconnect() throws Exception {
      vimPort.logout(vimServiceContent.getSessionManager());
   }

   private void trustAllHttpsCertificates() throws Exception {

      // Create a trust manager that does not validate certificate chains:

      javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
      javax.net.ssl.TrustManager tm = new TrustAllTrustManager();
      trustAllCerts[0] = tm;
      javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
      javax.net.ssl.SSLSessionContext sslsc = sc.getServerSessionContext();
      sslsc.setSessionTimeout(0);
      sc.init(null, trustAllCerts, null);
      HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
   }

   public SmServiceConnection(String url, String username, String password) throws Exception {
     vimHost = url;
     userName = username;
     this.password = password;

     HostnameVerifier hv = new HostnameVerifier() {
        public boolean verify(String urlHostName, SSLSession session) {
           return true;
        }
     };
     trustAllHttpsCertificates();
     HttpsURLConnection.setDefaultHostnameVerifier(hv);

     initAll();
   }

   /**
    * Returns vCenter service stub
    * 
    * @return VimPortType
    */
   public VimPortType getVimPort() {
      return vimPort;
   }

   /**
    * Returns SMS service stub
    * 
    * @return VimPortType
    */
   public SmsPortType getSmsPort() {
      return smsPort;
   }

   /**
    * Returns vCenter service content
    * 
    * @return VimPortType
    */
   public ServiceContent getVimServiceContent() {
      return vimServiceContent;
   }

   /**
    * Wrapper for SMS queryList method.
    * 
    * @param contextEntity entity to query on
    * @param queryEntityType related entity type
    * @param querySpec filter/sort constraints for the query
    * 
    * @return QueryResult
    */
   public QueryResult queryList(
      EntityReference contextEntity,
      EntityReferenceEntityType queryEntityType,
      QuerySpec querySpec) throws Exception {
      return smsPort.queryList(SMS_SVC_INST_REF,
                               contextEntity,
                               queryEntityType,
                               querySpec);
   }

   /**
    * Wrapper for SMS queryTopology method.
    * @param entity entity to query on
    * 
    * @return Map topology map
    */
   public Map queryTopology(EntityReference entity) throws Exception {
      return smsPort.queryTopology(SMS_SVC_INST_REF, entity);
   }

   /**
    * Wrapper for SMS sync method.
    */
   public void sync() throws Exception {
      smsPort.sync(SMS_SVC_INST_REF);
   }

   /**
    * Wrapper for SMS configureSyncInterval method.
    * @param interval sync interval
    */
   public void configureSyncInterval(int interval) throws Exception {
      smsPort.configureSyncInterval(SMS_SVC_INST_REF, interval);
   }

   /**
    * Wrapper for SMS updateVcDbConnectionInfo method.
    * @param spec DB connection spec
    */
   public void updateVcDbConnectionInfo(DbConnectionSpec spec) throws Exception {
      smsPort.updateVcDbConnectionInfo(SMS_SVC_INST_REF, spec);
   }
}

