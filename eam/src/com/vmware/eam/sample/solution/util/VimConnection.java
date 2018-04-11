/* **********************************************************
 * Copyright 2011 VMware, Inc.  All rights reserved.
 *      -- VMware Confidential
 * **********************************************************/

package com.vmware.eam.sample.solution.util;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vmware.eam.sample.solution.health.VimHealthProvider;
import com.vmware.vsphere.Extension;
import com.vmware.vsphere.InvalidPropertyFaultMsg;
import com.vmware.vsphere.ManagedObjectReference;
import com.vmware.vsphere.ObjectContent;
import com.vmware.vsphere.ObjectSpec;
import com.vmware.vsphere.OptionValue;
import com.vmware.vsphere.PropertyFilterSpec;
import com.vmware.vsphere.PropertySpec;
import com.vmware.vsphere.RetrieveOptions;
import com.vmware.vsphere.RetrieveResult;
import com.vmware.vsphere.RuntimeFaultFaultMsg;
import com.vmware.vsphere.ServiceContent;
import com.vmware.vsphere.VimPortType;
import com.vmware.vsphere.VimService;

/**
 * This class represents a VIM-API connection to the vCenter server
 */
public class VimConnection implements VimHealthProvider {

   private static Log _logger = LogFactory.getLog(VimConnection.class);

   private final int CONSERVATIVE_VCENTER_TIMEOUT = 60;
   private final Long SECOND_IN_NANOSECONDS = 1000L * 1000L * 1000L;

   public static final String SDK_URI = "https://sdkTunnel:8089/sdk";

   private String _username;
   private String _password;
   private String _extensionKey;
   private int _connectionTimeout;

   private VimPortType _stub;
   private ServiceContent _sc;

   private long _lastVcCallTimestamp;
   private String _sessionId;
   private String _sessionCookie;

   enum ConnectionStatus {
      NotConnected, Connected, LoginFailed, ConnectionFailed;
   }

   private ConnectionStatus _connectionStatus;

   private final ManagedObjectReference _siRef;

   private final String _host;

   private final int _port;

   private int _httpsPort;

   /**
    * Creates a VC connection object. The host and port properties must be
    * configured through the setters (using e.g. spring)
    */
   public VimConnection(String host, int port) {
      _host = host;
      _port = port;

      // This is the default proxy URL. It is unlikely that this will change.
      _lastVcCallTimestamp = 0;
      _connectionTimeout = CONSERVATIVE_VCENTER_TIMEOUT;
      _connectionStatus = ConnectionStatus.NotConnected;

      _siRef = new ManagedObjectReference();
      _siRef.setType("ServiceInstance");
      _siRef.setValue("ServiceInstance");
   }

   /**
    * @return the host
    */
   public String getHost() {
      return _host;
   }

   public int getHttpsPort() {
      return _httpsPort;
   }

   /**
    * @return Returns the password we used to log into VC.
    */
   public String getPassword() {
      return _password;
   }

   /**
    * @param password the password to use
    */
   public void setPassword(String password) {
      _password = password;
   }

   /**
    * @return the user name
    */
   public String getUsername() {
      return _username;
   }

   /**
    * @param username the username to use
    */
   public void setUsername(String username) {
      _username = username;
   }

   /**
    * @return the connectionTimeout
    */
   public int getConnectionTimeout() {
      return _connectionTimeout;
   }

   /**
    * @param connectionTimeout the vcConnectionTimeout to set
    */
   public void setConnectionTimeout(int connectionTimeout) {
      _connectionTimeout = connectionTimeout;
   }

   /**
    * @return returns the session cookie used for the vCenter connection
    */
   public String getSessionCookie() {
      assert !_sessionCookie.isEmpty();
      return _sessionCookie;
   }

   /**
    * Logs in as a user
    *
    * @param username for the session
    * @param password for authentication
    */
   public synchronized void loginAsUser(String username, String password) {
      logout();
      _username = username;
      _password = password;
      _extensionKey = null;
      connect();
   }

   /**
    * Logs in as an extension
    *
    * @param extensionKey
    */
   public synchronized void loginAsExtension(String extensionKey) {
      logout();
      _username = null;
      _password = null;
      _extensionKey = extensionKey;
      connect();
   }

   /**
    * Logs out from the current session.
    */
   public synchronized void logout() {
      if (_sc == null) {
         return;
      }

      try {
         _stub.logout(_sc.getSessionManager());
      } catch (Throwable e) {
         /*
          * We just ignore that - it is not that important that logout failed.
          * It could be because the session has already terminated.
          */
         _logger.error("Failed to logout", e);
      }

      _lastVcCallTimestamp = 0;
      _sc = null;
   }

   /**
    * This foces a logout and a relogin with the given login credentials.
    */
   public void relogin() {
      logout();
      connect();
   }

   /**
    * Re-authenticates to vCenter if needed (a connection can time out)
    */
   public void ensureConnection() {
      // calculate the time span in seconds since last call to vCenter
      long timeSpan = Math.abs(System.nanoTime() - _lastVcCallTimestamp)
            / SECOND_IN_NANOSECONDS;

      // Only re-authenticate ever so often
      if (timeSpan < _connectionTimeout) {
         return;
      }

      if (_sc == null) {
         connect();
         return;
      }

      try {
         _logger.debug("Checking if the session is still valid");
         _stub.currentTime(_siRef);
      } catch (Exception e) {
         _logger.debug("Current vCenter session invalid");
         connect();
      }
   }

   /**
    * @param moRef
    * @param path
    * @return
    * @throws RuntimeFaultFaultMsg
    */
   @SuppressWarnings("unchecked")
   public <T> T getProperty(final ManagedObjectReference moRef, final String path)
      throws RuntimeFaultFaultMsg {
      ObjectSpec objectSpec = new ObjectSpec();
      objectSpec.setObj(moRef);
      objectSpec.setSkip(false);

      PropertySpec propertySpec = new PropertySpec();
      propertySpec.getPathSet().add(path);
      propertySpec.setType(moRef.getType());
      propertySpec.setAll(false);

      PropertyFilterSpec pfs = new PropertyFilterSpec();
      pfs.getObjectSet().add(objectSpec);
      pfs.getPropSet().add(propertySpec);

      RetrieveOptions retrieveOptions = new RetrieveOptions();
      retrieveOptions.setMaxObjects(1);
      try {
         RetrieveResult retrievePropertiesEx = _stub.retrievePropertiesEx(_sc.getPropertyCollector(),
                                                                          Collections.singletonList(pfs),
                                                                          retrieveOptions);
         List<ObjectContent> objects = retrievePropertiesEx.getObjects();
         return (T) objects.get(0).getPropSet().get(0).getVal();
      } catch (InvalidPropertyFaultMsg e) {
         _logger.error(e, e);
      }
      return null;
   }

   private synchronized void connect() {
      if (getHost() == null || getHost().isEmpty()) {
         throw new RuntimeException("vcHost is not configured. Check your beans.xml");
      }
      _logger.info("Connecting to vCenter through proxy at: " + _host + ":" + _port
            + " as " + (_extensionKey == null ? _username : _extensionKey));

      try {
         URL wsdlURL = null;
         // This is the base url which either will be the jar file or the bin
         // directory
         URL baseURL = VimService.class.getProtectionDomain()
                                       .getCodeSource()
                                       .getLocation();

         if (baseURL.toString().endsWith(".jar")) {
            String jarPath = "jar:"
                  + VimService.class.getProtectionDomain().getCodeSource().getLocation()
                  + "!/wsdl/vim25/vimService.wsdl";
            wsdlURL = new URL(jarPath);
         } else {
            wsdlURL = new URL(baseURL, "..\\wsdl\\vim25\\vimService.wsdl");
         }

         VimService locator = new VimService(wsdlURL, new QName("urn:vim25Service",
                                                                "VimService"));

         _stub = locator.getVimPort();
         ((BindingProvider) _stub).getRequestContext()
                                  .put(BindingProvider.SESSION_MAINTAIN_PROPERTY,
                                       Boolean.TRUE);
         ((BindingProvider) _stub).getRequestContext()
                                  .put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                                       SDK_URI);

         _sc = _stub.retrieveServiceContent(_siRef);
         extractSessionCookie();
         ManagedObjectReference sessionManager = _sc.getSessionManager();
         if (_extensionKey == null) {
            _stub.login(sessionManager, _username, _password, null);
         } else {
            _stub.loginExtensionByCertificate(sessionManager, _extensionKey, null);
         }

         List<OptionValue> queryOptions = _stub.queryOptions(_sc.getSetting(),
                                                             "WebService.Ports.https");
         if (queryOptions.size() == 0 || queryOptions.get(0) == null
               || queryOptions.get(0).getValue() == null) {
            _httpsPort = 443;
         } else {
            _httpsPort = (Integer) queryOptions.get(0).getValue();
         }

         _connectionStatus = ConnectionStatus.Connected;
      } catch (Exception e) {
         _logger.error(e, e);
      }
   }

   /**
    * Extracts the session cookie if any from the last HTTP request made through
    * VIM client stub
    */
   private void extractSessionCookie() {
      Map<String, List<String>> headers = getLastResponseHeaders();
      List<String> cookies = headers.get("Set-cookie");
      if (cookies != null && !cookies.isEmpty()) {
         _sessionCookie = cookies.get(0); // get the value of the cookie
         Map<String, List<String>> map = new HashMap<String, List<String>>();
         map.put("Cookie", Collections.singletonList(_sessionCookie));
         ((BindingProvider) _stub).getRequestContext()
                                  .put(MessageContext.HTTP_REQUEST_HEADERS, map);
      } else {
         Map<String, Object> requestContents = new HashMap<String, Object>();
         requestContents.putAll(((BindingProvider) _stub).getRequestContext());
         _logger.warn("No cookies in response to " + requestContents);
      }
   }

   /**
    * Returns the HTTP headers from the last SOAP request via the VIM stub
    * @return map {header name -> list of values}, not null, but may be empty
    */
   @SuppressWarnings("unchecked")
   private Map<String, List<String>> getLastResponseHeaders() {
      assert _stub instanceof BindingProvider;
      Map<String, Object> responseContext = ((BindingProvider) _stub).getResponseContext();
      Object headers = responseContext.get(MessageContext.HTTP_RESPONSE_HEADERS);
      if (headers != null) {
         return (Map<String, List<String>>)headers;
      } else {
         _logger.warn("No headers found in " + _stub);
         return Collections.emptyMap();
      }
   }

   /**
    * Register an extension
    *
    * @param ex - The extension to register
    */
   public void registerExtension(Extension ex) {
      try {
         Extension findExtension = _stub.findExtension(_sc.getExtensionManager(),
                                                       ex.getKey());
         if (findExtension == null) {
            _stub.registerExtension(_sc.getExtensionManager(), ex);
         } else {
            _stub.updateExtension(_sc.getExtensionManager(), ex);
         }
         _stub.setExtensionCertificate(_sc.getExtensionManager(), ex.getKey(), null);
      } catch (Exception e) {
         _logger.error(e, e);
      }
   }

   /**
    * Gets the ID of the vCenter server session.
    *
    * @return The session ID
    */
   public String getSessionId() {
      ensureConnection();
      return _sessionId;
   }

   private final VimHealth _loginOkHealth = new VimHealth(LEVEL_INFO, "ok");
   private final VimHealth _loginBadHealth = new VimHealth(LEVEL_ALERT,
                                                           "Unable to authenticate with vCenter server (not registered?)");
   private final VimHealth _noConnectionHealth = new VimHealth(LEVEL_ALERT,
                                                               "vCenter server is not responding");

   /**
    * @return true, if we got an active connection to vCenter
    */
   public boolean isConnected() {
      return (_connectionStatus == ConnectionStatus.Connected);
   }

   @Override
   public VimHealth getVimHealth() {
      switch (_connectionStatus) {
      case ConnectionFailed:
         return _noConnectionHealth;
      case LoginFailed:
         return _loginBadHealth;
      }
      return _loginOkHealth; // No login yet - is also good health
   }

   /**
    * @return vCenter root folder
    */
   public ManagedObjectReference getRootFolder() {
      return _sc.getRootFolder();
   }

   public ServiceContent getServiceContent() {
      return _sc;
   }

   public VimPortType getStub() {
      return _stub;
   }

   public ManagedObjectReference getExtensionManager() {
      return _sc.getExtensionManager();
   }

}
