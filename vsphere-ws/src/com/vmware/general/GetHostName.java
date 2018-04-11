package com.vmware.general;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.InvalidLocaleFaultMsg;
import com.vmware.vim25.InvalidLoginFaultMsg;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * GetHostName
 * 
 * This sample gets the hostname and additional details of the ESX Servers 
 * in the inventory
 * 
 * <b>Parameters:</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.general.GetHostName
 * --url [webservicesurl] --username [username] --password [password]
 * </pre>
 */

public class GetHostName {

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
   private static final List<String> hostSystemAttributesArr =
         new ArrayList<String>();

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

   /**
    * Returns all the MOREFs of the specified type that are present under the
    * container
    * 
    * @param container
    *           {@link ManagedObjectReference} of the container to begin the
    *           search from
    * @param morefType
    *           Type of the managed entity that needs to be searched
    * 
    * @param morefProperties
    *           Array of properties to be fetched for the moref
    * @return Map of MOREF and Map of name value pair of properties requested of
    *         the managed objects present. If none exist then empty Map is
    *         returned
    * 
    * @throws InvalidPropertyFaultMsg
    * @throws RuntimeFaultFaultMsg
    */
   private static Map<ManagedObjectReference, Map<String, Object>> getMOREFsInContainerByType(
         ManagedObjectReference container, String morefType,
         String[] morefProperties) throws InvalidPropertyFaultMsg,
         RuntimeFaultFaultMsg {
      ManagedObjectReference viewManager = serviceContent.getViewManager();
      ManagedObjectReference containerView =
            vimPort.createContainerView(viewManager, container,
                  Arrays.asList(morefType), true);

      Map<ManagedObjectReference, Map<String, Object>> tgtMoref =
            new HashMap<ManagedObjectReference, Map<String, Object>>();

      // Create Property Spec
      PropertySpec propertySpec = new PropertySpec();
      propertySpec.setAll(Boolean.FALSE);
      propertySpec.setType(morefType);
      propertySpec.getPathSet().addAll(Arrays.asList(morefProperties));

      TraversalSpec ts = new TraversalSpec();
      ts.setName("view");
      ts.setPath("view");
      ts.setSkip(false);
      ts.setType("ContainerView");

      // Now create Object Spec
      ObjectSpec objectSpec = new ObjectSpec();
      objectSpec.setObj(containerView);
      objectSpec.setSkip(Boolean.TRUE);
      objectSpec.getSelectSet().add(ts);

      // Create PropertyFilterSpec using the PropertySpec and ObjectPec
      // created above.
      PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
      propertyFilterSpec.getPropSet().add(propertySpec);
      propertyFilterSpec.getObjectSet().add(objectSpec);

      List<PropertyFilterSpec> propertyFilterSpecs =
            new ArrayList<PropertyFilterSpec>();
      propertyFilterSpecs.add(propertyFilterSpec);

      List<ObjectContent> oCont =
            vimPort.retrieveProperties(serviceContent.getPropertyCollector(),
                  propertyFilterSpecs);
      if (oCont != null) {
         for (ObjectContent oc : oCont) {
            Map<String, Object> propMap = new HashMap<String, Object>();
            List<DynamicProperty> dps = oc.getPropSet();
            if (dps != null) {
               for (DynamicProperty dp : dps) {
                  propMap.put(dp.getName(), dp.getVal());
               }
            }
            tgtMoref.put(oc.getObj(), propMap);
         }
      }
      return tgtMoref;
   }


   private static void setHostSystemAttributesList() {
      hostSystemAttributesArr.add("name");
      hostSystemAttributesArr.add("config.product.productLineId");
      hostSystemAttributesArr.add("summary.hardware.cpuMhz");
      hostSystemAttributesArr.add("summary.hardware.numCpuCores");
      hostSystemAttributesArr.add("summary.hardware.cpuModel");
      hostSystemAttributesArr.add("summary.hardware.uuid");
      hostSystemAttributesArr.add("summary.hardware.vendor");
      hostSystemAttributesArr.add("summary.hardware.model");
      hostSystemAttributesArr.add("summary.hardware.memorySize");
      hostSystemAttributesArr.add("summary.hardware.numNics");
      hostSystemAttributesArr.add("summary.config.name");
      hostSystemAttributesArr.add("summary.config.product.osType");
      hostSystemAttributesArr.add("summary.config.vmotionEnabled");
      hostSystemAttributesArr.add("summary.quickStats.overallCpuUsage");
      hostSystemAttributesArr.add("summary.quickStats.overallMemoryUsage");
   }

   /**
    * Prints the Host names.
    */
   private static void printHostProductDetails() {
      try {
         setHostSystemAttributesList();
         Map<ManagedObjectReference, Map<String, Object>> hosts =
               getMOREFsInContainerByType(serviceContent.getRootFolder(),
                     "HostSystem",
                     hostSystemAttributesArr.toArray(new String[] {}));

         for (ManagedObjectReference host : hosts.keySet()) {
            Map<String, Object> hostprops = hosts.get(host);
            for (String prop : hostprops.keySet()) {
               System.out.println(prop + " : " + hostprops.get(prop));
            }
            System.out
                  .println("\n\n***************************************************************");
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static void printUsage() {
      System.out
            .println("This sample gets the hostname and additional details of the ESX "
                  + "Servers in the inventory");
      System.out.println("\nParameters:");
      System.out.println("url          [required] : url of the web service");
      System.out
            .println("username     [required] : username for the authentication");
      System.out
            .println("password     [required] : password for the authentication");
      System.out.println("\nCommand:");
      System.out.println("run.bat com.vmware.general.GetHostName");
      System.out
            .println("--url [webservicesurl] --username [username] --password [password]");
   }

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         if (help) {
            printUsage();
            return;
         }
         connect();
         printHostProductDetails();
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