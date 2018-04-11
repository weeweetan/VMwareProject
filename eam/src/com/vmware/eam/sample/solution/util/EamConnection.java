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

import org.apache.log4j.Logger;

import com.vmware.vsphere.EamPortType;
import com.vmware.vsphere.EamService;
import com.vmware.vsphere.ManagedObjectReference;

/**
 *
 * Class wraps everything concerning the connection to EAM. This means it is
 * able to login and query for objects.
 *
 */
public class EamConnection {

   // logger for the EAM connection
   private final Logger _log = Logger.getLogger(EamConnection.class.getName());

   // State of EAM connection
   private boolean _isConnected;

   // EAM connection info
   private final String _vcHost;
   private final int _vcHttpsProxyPort;
   private final String _sessionCookie;

   private EamPortType _stub;

   private final ManagedObjectReference _eamRef;

   /**
    * Constructor creates a connection to EAM.
    *
    * @param vcHost The host of the vCenter server
    * @param vcHttpsProxyPort The port of the vCenter server proxy
    * @param sessionCookie vc session cookie
    */
   public EamConnection(String vcHost, int vcHttpsProxyPort, String sessionCookie) {
      _vcHost = vcHost;
      _vcHttpsProxyPort = vcHttpsProxyPort;
      _sessionCookie = sessionCookie;
      _isConnected = false;

      _eamRef = new ManagedObjectReference();
      _eamRef.setType("EsxAgentManager");
      _eamRef.setValue("EsxAgentManager");
   }

   /**
    * @return true if connected to EAM, false if not
    */
   public boolean isConnected() {
      return _isConnected;
   }

   /**
    * Set EAM connection to disconnected
    */
   public void lostConnection() {
      _isConnected = false;
   }

   /**
    * Connect to EAM
    */
   public void connect() {
      if (_isConnected) {
         return;
      }

      try {
         URL wsdlURL = null;
         // This is the base url which either will be the jar file or the bin
         // directory
         URL baseURL = EamService.class.getProtectionDomain()
                                       .getCodeSource()
                                       .getLocation();

         if (baseURL.toString().endsWith(".jar")) {
            String jarPath = "jar:"
                  + EamService.class.getProtectionDomain().getCodeSource().getLocation()
                  + "!/wsdl/eam/eamService.wsdl";
            wsdlURL = new URL(jarPath);
         } else {
            wsdlURL = new URL(baseURL, "..\\wsdl\\eam\\eamService.wsdl");
         }

         EamService locator = new EamService(wsdlURL, new QName("urn:eamService",
                                                                "EamService"));

         String eamUrl = "https://" + _vcHost + ":" + _vcHttpsProxyPort + "/eam/sdk/";

         _log.info("Connecting to EAM: " + eamUrl);

         _stub = locator.getEamPort();
         ((BindingProvider) _stub).getRequestContext()
                                  .put(BindingProvider.SESSION_MAINTAIN_PROPERTY,
                                       Boolean.TRUE);
         ((BindingProvider) _stub).getRequestContext()
                                  .put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, eamUrl);

         /*
          * We set the cookie from our vCenter session (where we are logged in
          * as an extension) to our connection the ESX Agent Manager. This is
          * the way we authorize against the ESX Agent Manager.
          */
         Map<String, List<String>> map = new HashMap<String, List<String>>();
         map.put("Cookie", Collections.singletonList(_sessionCookie));
         ((BindingProvider) _stub).getRequestContext()
                                  .put(MessageContext.HTTP_REQUEST_HEADERS, map);

         _isConnected = true;
      } catch (Exception e) {
         _log.error(e, e);
      }
   }

   /**
    * Disconnect from EAM
    */
   public void disconnect() {
      if (_isConnected) {
         _isConnected = false;
      }
   }

   /**
    * @return The EAM stub.
    */
   public EamPortType getStub() {
      return _stub;
   }

   /**
    * @return Returns the ESX Agent Manager mo-ref.
    */
   public ManagedObjectReference getEsxAgentManager() {
      return _eamRef;
   }

}
