package com.vmware.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.ArrayOfLicenseFeatureInfo;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.LicenseAssignmentManagerLicenseAssignment;
import com.vmware.vim25.LicenseFeatureInfo;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * LicenseManager
 * 
 * Demonstrates uses of the Licensing API using License Manager
 * Reference.
 * 
 * <b>Parameters:</b>
 * url         [required] : url of the web service
 * username    [required] : username for the authentication
 * password    [required] : password for the authentication
 * action      [required] : action to be performed
 *                          [browse|setserver|setedition|featureinfo]
 * feature     [optional] : Licensed feature
 * licensekey  [optional] : License key for KL servers
 * 
 * <b>Command Line:</b>
 * Display all license information
 * run.bat com.vmware.general.LicenseManager --url [webserviceurl]
 * --username [username] --password [password] --action[browse]
 * 
 * Retrieve the feature information
 * run.bat com.vmware.general.LicenseManager --url [webserviceurl]
 * --username [username] --password [password] --action[featureinfo] --feature [drs]
 * 
 * run.bat com.vmware.general.LicenseManager --url [webserviceurl]
 * --username [username] --password [password] --action[setserver] --licensekey [key]
 * </pre>
 */

public class LicenseManager {

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

   private static VimService vimService = null;
   private static VimPortType vimPort = null;
   private static ServiceContent serviceContent = null;
   private static final String SVC_INST_NAME = "ServiceInstance";
   private static final ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();
   private static ManagedObjectReference propCollector = null;

   /*
    *Connection input parameters
    */
   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
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

   private static void getConnectionParameters(String[] args) {
      String param = "";
      if (args.length != 0) {
         if (args.length < 2) {
            param = args[0].trim();
            if (param.equalsIgnoreCase("--help")) {
               help = true;
               return;
            } else {
               throw new IllegalArgumentException("Expected --url,"
                     + " --username, --password arguments.");
            }
         }
      }
      int ai = 0;
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
      propCollector = serviceContent.getPropertyCollector();
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

   /* End Server Connection and common code */

   /* Start Sample functional code */

   private static String action = null;
   private static String feature = null;
   private static String licenseKey = null;
   private static ManagedObjectReference licManagerRef = null;
   private static ManagedObjectReference licenseAssignmentManagerRef = null;
   private static ArrayOfLicenseFeatureInfo featureInfo;

   private static void getInputParameters(String[] args) {
      int ai = 0;
      String param = "";
      String val = "";
      while (ai < args.length) {
         param = args[ai].trim();
         if (ai + 1 < args.length) {
            val = args[ai + 1].trim();
         }
         if (param.equalsIgnoreCase("--action") && !val.startsWith("--")
               && !val.isEmpty()) {
            action = val;
         } else if (param.equalsIgnoreCase("--feature")
               && !val.startsWith("--") && !val.isEmpty()) {
            feature = val;
         } else if (param.equalsIgnoreCase("--licensekey")
               && !val.startsWith("--") && !val.isEmpty()) {
            licenseKey = val;
         }
         val = "";
         ai += 2;
      }
      if (action == null) {
         throw new IllegalArgumentException("Expected --action argument.");
      }
   }

   private static void initLicManagerRef() {
      if (serviceContent != null) {
         licManagerRef = serviceContent.getLicenseManager();
      }
   }

   private static void initLicAssignmentManagerRef() throws Exception {
      try {
         ArrayList<PropertyFilterSpec> listpfspec =
               new ArrayList<PropertyFilterSpec>();
         listpfspec.add(createEventFilterSpec("licenseAssignmentManager"));
         List<ObjectContent> listobjcont =
               retrievePropertiesAllObjects(listpfspec);
         if (listobjcont != null) {
            for (ObjectContent oc : listobjcont) {
               List<DynamicProperty> dps = oc.getPropSet();
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     licenseAssignmentManagerRef =
                           (ManagedObjectReference) dp.getVal();
                  }
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         throw e;
      }
   }

   private static void initfeatureInfoRef() throws Exception {
      try {
         ArrayList<PropertyFilterSpec> listpfspec =
               new ArrayList<PropertyFilterSpec>();
         listpfspec.add(createEventFilterSpec("featureInfo"));
         List<ObjectContent> listobjcont =
               retrievePropertiesAllObjects(listpfspec);
         if (listobjcont != null) {
            for (ObjectContent oc : listobjcont) {
               List<DynamicProperty> dps = oc.getPropSet();
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     featureInfo = (ArrayOfLicenseFeatureInfo) dp.getVal();
                  }
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         throw e;
      }
   }

   private static void useLicenseManager() throws Exception {
      if (action.equalsIgnoreCase("browse")) {
         System.out.println("Display the license usage. "
               + "It gives details of license features " + "like license key "
               + " edition key and entity id.");
         displayLicenseUsage();
      } else if (action.equalsIgnoreCase("setserver")) {
         System.out.println("Adding the license key.");
         setLicenseServer();
      } else if (action.equalsIgnoreCase("featureinfo")) {
         if (feature != null) {
            displayFeatureInfo();
         } else {
            throw new IllegalArgumentException("Expected --feature argument.");
         }
      } else {
         System.out.println("Invalid Action ");
         System.out.println("Valid Actions [browse|setserver|featureinfo]");
      }
   }

   private static PropertyFilterSpec createEventFilterSpec(String property) {
      PropertySpec propSpec = new PropertySpec();
      propSpec.setAll(new Boolean(false));
      propSpec.getPathSet().add(property);
      propSpec.setType(licManagerRef.getType());

      ObjectSpec objSpec = new ObjectSpec();
      objSpec.setObj(licManagerRef);
      objSpec.setSkip(new Boolean(false));

      PropertyFilterSpec spec = new PropertyFilterSpec();
      spec.getPropSet().add(propSpec);
      spec.getObjectSet().add(objSpec);
      return spec;
   }

   /**
    * Uses the new RetrievePropertiesEx method to emulate the now deprecated
    * RetrieveProperties method.
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
               vimPort.retrievePropertiesEx(propCollector, listpfs,
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
            rslts = vimPort.continueRetrievePropertiesEx(propCollector, token);
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

   private static void displayLicenseUsage() throws Exception {
      try {
         List<LicenseAssignmentManagerLicenseAssignment> avail =
               vimPort.queryAssignedLicenses(licenseAssignmentManagerRef, null);
         print(avail);
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         throw e;
      }
   }

   private static void setLicenseServer() throws Exception {
      boolean flag = true;
      if (licenseKey == null) {
         System.out
               .println("Error:: For KL servers licensekey is a mandatory option");
         flag = false;
      }
      if (flag) {
         try {
            String apitype = serviceContent.getAbout().getApiType();
            if (apitype.equalsIgnoreCase("VirtualCenter")) {
               String entity = serviceContent.getAbout().getInstanceUuid();
               vimPort.updateAssignedLicense(licenseAssignmentManagerRef,
                     entity, licenseKey, null);
               System.out.println("License key set for VC server");
            } else if (apitype.equalsIgnoreCase("HostAgent")) {
               vimPort.decodeLicense(licManagerRef, licenseKey);
               vimPort.updateLicense(licManagerRef, licenseKey, null);
               System.out.println("License key set for ESX server");
            }
         } catch (SOAPFaultException sfe) {
            printSoapFaultException(sfe);
         } catch (Exception e) {
            throw e;
         }
      }
   }

   private static void displayFeatureInfo() throws Exception {
      List<LicenseFeatureInfo> feaTure = new ArrayList<LicenseFeatureInfo>();
      feaTure = featureInfo.getLicenseFeatureInfo();
      if (feaTure != null) {
         for (LicenseFeatureInfo featureinfo : feaTure) {
            if (featureinfo.getKey().equalsIgnoreCase(feature)) {
               System.out.println("Name       " + featureinfo.getFeatureName());
               System.out.println("Unique Key " + featureinfo.getKey());
               System.out.println("State      " + featureinfo.getState());
               System.out.println("Cost Unit  " + featureinfo.getCostUnit());
            }
         }
      } else if (feaTure == null) {
         System.out.println("Feature Not Available");
      }
   }

   private static void print(
         List<LicenseAssignmentManagerLicenseAssignment> licAssignment) {
      if (licAssignment != null) {
         for (LicenseAssignmentManagerLicenseAssignment la : licAssignment) {
            String entityId = la.getEntityId();
            String editionKey = la.getAssignedLicense().getEditionKey();
            String licensekey = la.getAssignedLicense().getLicenseKey();
            String name = la.getAssignedLicense().getName();
            System.out.println("\nName of the license: " + name
                  + "\n License Key:  " + licensekey + "\n Edition Key: "
                  + editionKey + "\n EntityID: " + entityId + "\n\n");
         }
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
      System.out.println("Demonstrates uses of the Licensing API using "
            + "License Manager");
      System.out.println("\nParameters:");
      System.out.println("url        [required] : url of the web service.");
      System.out
            .println("username   [required] : username for the authentication");
      System.out
            .println("password   [required] : password for the authentication");
      System.out.println("action     [required] : action to be performed");
      System.out
            .println("                        [browse|setserver|setedition|featureinfo]");
      System.out.println("feature    [optional] : Licensed feature");
      System.out.println("licensekey [optional] : License key for KL servers");
      System.out.println("\nCommand:");
      System.out.println("Display all license information");
      System.out
            .println("run.bat com.vmware.general.LicenseManager --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--action[browse]");
      System.out.println("To retrieve the feature information ");
      System.out
            .println("run.bat com.vmware.general.LicenseManager --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--action[featureinfo] --feature [drs]");
      System.out
            .println("run.bat com.vmware.general.LicenseManager --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--action[setserver] --licensekey [key]");
   }

   /* End Sample functional code */

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         if (help) {
            printUsage();
            return;
         }
         getInputParameters(args);
         connect();
         initLicManagerRef();
         initLicAssignmentManagerRef();
         initfeatureInfoRef();
         useLicenseManager();
      } catch (IllegalArgumentException iae) {
         System.out.println(iae.getMessage());
         printUsage();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println("Failed - " + e.getMessage());
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
