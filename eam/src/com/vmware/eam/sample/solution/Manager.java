/* **********************************************************
 * Copyright 2011 VMware, Inc.  All rights reserved.
 *      -- VMware Confidential
 * **********************************************************/

package com.vmware.eam.sample.solution;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ProxySelector;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import com.vmware.eam.sample.solution.util.CustomProxySelector;
import com.vmware.eam.sample.solution.util.EamConnection;
import com.vmware.eam.sample.solution.util.KeepConnectionAlive;
import com.vmware.eam.sample.solution.util.VimConnection;
import com.vmware.vsphere.Description;
import com.vmware.vsphere.ExtExtendedProductInfo;
import com.vmware.vsphere.ExtSolutionManagerInfo;
import com.vmware.vsphere.ExtSolutionManagerInfoTabInfo;
import com.vmware.vsphere.Extension;
import com.vmware.vsphere.ExtensionHealthInfo;
import com.vmware.vsphere.ExtensionResourceInfo;
import com.vmware.vsphere.KeyValue;
import com.vmware.vsphere.NotFoundFaultMsg;
import com.vmware.vsphere.RuntimeFaultFaultMsg;

/**
 * Main manager class in the sample solution. This class initializes and sets up
 * all the objects.
 */
public class Manager implements InitializingBean {

   /** Ping solution's extension key */
   public final String EXTENSION_KEY;

   /** Logger */
   private static Logger _logger = Logger.getLogger(Manager.class.getName());

   /** Single ping manager instance */
   private static Manager _instance;

   /** Agent Handler, takes care of agent deployment and monitoring */
   private final AgentHandler _agentHandler;

   /** VC connection */
   private final VimConnection _vimConnection;

   /** EAM connection */
   private EamConnection _eamConnection;

   private final String _vcUsername;

   private final String _vcPassword;

   private final String _url;

   public Manager(String extensionKey,
                  String selfUrl,
                  String selfIp,
                  String vcUsername,
                  String vcPassword,
                  String vcProxyHost,
                  int vcProxyPort,
                  AgentHandler agentHandler,
                  VimConnection vimConnection) throws Exception {
      synchronized (this) {
         if (_instance != null) {
            throw new Exception("Manager already initialized!");
         }
         _instance = this;
      }

      EXTENSION_KEY = extensionKey;

      initializeSsl();
      initializeProxySelector(vcProxyHost, vcProxyPort);

      // Expand "*" to own ip in passed in url.
      _url = expandUrl(selfUrl, selfIp);

      _vcUsername = vcUsername;
      _vcPassword = vcPassword;
      _agentHandler = agentHandler;
      _vimConnection = vimConnection;
   }

   public static String expandUrl(String selfUrl, String selfIp) {
      try {
         URL url = new URL(selfUrl);
         String host = url.getHost().equals("*") ? selfIp : url.getHost();
         return new URL(url.getProtocol(), host, url.getPort(), url.getFile()).toString();
      } catch (MalformedURLException e) {
         _logger.error("Invalid self URL", e);
      } catch (Exception e) {
         _logger.error("Invalid self URL2", e);
      }
      return "";
   }

   private void initializeSsl() throws KeyStoreException, UnrecoverableKeyException,
      NoSuchAlgorithmException, IOException, CertificateException {
      /**
       * The following makes sure we do not do any certificate validation when
       * we create a HTTPS connection.
       */
      TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
         public X509Certificate[] getAcceptedIssuers() {
            return null;
         }

         public void checkClientTrusted(X509Certificate[] certs, String authType)
            throws CertificateException {
         }

         public void checkServerTrusted(X509Certificate[] certs, String authType)
            throws CertificateException {
         }
      } };

      KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
      char[] password = "password".toCharArray();
      InputStream is = getClass().getClassLoader().getResourceAsStream("/eam.keystore");
      ks.load(is, password);
      is.close();

      KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");

      try {
         kmf.init(ks, password);
      } finally {
         Arrays.fill(password, '\0');
      }

      try {
         SSLContext sc = SSLContext.getInstance("TLS");
         sc.init(kmf.getKeyManagers(), trustAllCerts, null);
         HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
         HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String paramString, SSLSession paramSSLSession) {
               return true;
            }
         });
      } catch (Exception e) {
      }
   }

   private void initializeProxySelector(String host, int port) {
      ProxySelector.setDefault(new CustomProxySelector(host, port));
   }

   /**
    * Initialize the sample solution, called after all spring initialization is
    * done
    *
    * 1. Register as vCenter Extension 2. Connect to EAM 3. Create agency (setup
    * agent handler)
    */
   @Override
   public void afterPropertiesSet() throws Exception {
      _vimConnection.loginAsUser(_vcUsername, _vcPassword);
      Extension extension = createExtensionObject();
      _vimConnection.registerExtension(extension);
      _vimConnection.loginAsExtension(extension.getKey());

      /*
       * We do this asynchronously, since we need to be able to serve OVF files
       * while we are creating the agency. (Tomcat will block HTTP requests
       * until all beans have been initialized).
       */
      new Thread() {
         @Override
         public void run() {
            try {
               connectEam();
            } catch (Exception e) {
               e.printStackTrace();
            }

            assert _eamConnection != null;
            _agentHandler.setup(_eamConnection);

            // Start background thread to keep the connection alive.
            new KeepConnectionAlive(_vimConnection, _eamConnection).start();
         }
      }.start();
   }

   /**
    *
    * @return
    */
   private Extension createExtensionObject() {
      Extension extension = new Extension();
      extension.setKey(EXTENSION_KEY);

      Description description = new Description();
      description.setLabel("EAM Sample Solution");
      description.setSummary("This extension provides the EAM Sample Solution.");
      extension.setDescription(description);
      extension.setVersion("0.1");

      ExtensionHealthInfo healthInfo = new ExtensionHealthInfo();
      healthInfo.setUrl(_url.toString() + "/health/health.xml");
      extension.setHealthInfo(healthInfo);

      ExtensionResourceInfo extensionResourceInfo = new ExtensionResourceInfo();
      extensionResourceInfo.setLocale("en");
      extensionResourceInfo.setModule("extension");
      KeyValue keyValue = new KeyValue();
      keyValue.setKey(EXTENSION_KEY + ".label");
      keyValue.setValue("EAM Sample Solution");
      extensionResourceInfo.getData().add(keyValue);

      extension.getResourceList().add(extensionResourceInfo);

      ExtExtendedProductInfo extExtendedProductInfo = new ExtExtendedProductInfo();
      extExtendedProductInfo.setCompanyUrl("http://www.vmware.com");
      extExtendedProductInfo.setProductUrl("http://www.vmware.com");
      extension.setExtendedProductInfo(extExtendedProductInfo);

      ExtSolutionManagerInfo extSolutionManagerInfo = new ExtSolutionManagerInfo();

      ExtSolutionManagerInfoTabInfo extSolutionManagerInfoTabInfo = new ExtSolutionManagerInfoTabInfo();
      extSolutionManagerInfoTabInfo.setLabel("Configuration");
      extSolutionManagerInfoTabInfo.setUrl(_url.toString() + "/config.html");
      extSolutionManagerInfo.getTab().add(extSolutionManagerInfoTabInfo);

      extSolutionManagerInfoTabInfo = new ExtSolutionManagerInfoTabInfo();
      extSolutionManagerInfoTabInfo.setLabel("Management");
      extSolutionManagerInfoTabInfo.setUrl("https://" + _vimConnection.getHost() + ":"
            + _vimConnection.getHttpsPort() + "/eam/management/ui/?solution="
            + EXTENSION_KEY);
      extSolutionManagerInfo.getTab().add(extSolutionManagerInfoTabInfo);

      extension.setSolutionManagerInfo(extSolutionManagerInfo);
      extension.setShownInSolutionManager(true);

      GregorianCalendar c = (GregorianCalendar) Calendar.getInstance();
      try {
         extension.setLastHeartbeatTime(DatatypeFactory.newInstance()
                                                       .newXMLGregorianCalendar(c));
      } catch (DatatypeConfigurationException e) {
      }

      return extension;
   }

   /**
    * log out from EAM and unregister from VC. The latter will also
    * automatically destroy the agency and all the agents
    *
    * @throws RuntimeFaultFaultMsg
    * @throws NotFoundFaultMsg
    */
   public void cleanup() throws NotFoundFaultMsg, RuntimeFaultFaultMsg {
      // Logout from EAM
      if (_eamConnection != null) {
         _eamConnection.disconnect();
      }

      _vimConnection.getStub().unregisterExtension(_vimConnection.getExtensionManager(),
                                                   EXTENSION_KEY);
   }

   public String getURL() {
      return _url;
   }

   /**
    * @return the solution's manager object
    */
   public static Manager getInstance() {
      return _instance;
   }

   /**
    * Connect to EAM by first looking up the EAM VC extension to find out what
    * EAM endpoint to connect to.
    *
    * @throws Exception
    */
   private void connectEam() throws Exception {
      /*
       * We know that eam is always running at same url as vCenter under the eam
       * namespace.
       */

      assert _eamConnection == null;
      _eamConnection = new EamConnection(_vimConnection.getHost(),
                                         _vimConnection.getHttpsPort(),
                                         _vimConnection.getSessionCookie());
      _eamConnection.connect();
   }

}
