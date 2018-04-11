package com.vmware.general;

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
 * SearchIndex
 * 
 * This sample demonstrates the SearchIndex API
 * 
 * <b>Parameters:</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 * dcname       [required] : name of the datacenter
 * vmdnsname    [optional] : Dns of a virtual machine
 * hostdnsname  [optional] : Dns of the ESX host
 * vmpath       [optional] : Inventory path of a virtual machine
 * vmip         [optional] : IP Address of a virtual machine
 * 
 * <b>Command Line:</b>
 * Run the search index with dcName myDatacenter
 * run.bat com.vmware.general.SearchIndex --url [webserviceurl]
 * --username [username] --password [password] --dcName myDatacenter
 * 
 * Run the search index with dcName myDatacenter and vmpath to virtual machine named Test
 * run.bat com.vmware.general.SearchIndex --url [webserviceurl]
 * --username [username] --password [password] --dcName myDatacenter
 * --vmpath //DatacenterName//vm//Test
 * 
 * Run the search index with dcName myDatacenter and hostdns 'abc.bcd.com'
 * run.bat com.vmware.general.SearchIndex --url [webserviceurl]
 * --username [username] --password [password]
 * --dcName myDatacenter --hostDns abc.bcd.com
 * 
 * Run the search index with dcName myDatacenter and ip of the vm as 111.123.155.21
 * run.bat com.vmware.general.SearchIndex --url [webserviceurl]
 * --username [username] --password [password]
 * --dcName myDatacenter --vmIP 111.123.155.21
 * </pre>
 */

public class SearchIndex {

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
   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;
   private static final String SVC_INST_NAME = "ServiceInstance";
   private static final String PROP_ME_NAME = "name";

   private static String url;
   private static String userName;
   private static String password;
   private static boolean help = false;
   private static boolean isConnected = false;
   private static String dcName;
   private static String vmDnsName;
   private static String vmPath;
   private static String hostDnsName;
   private static String vmIP;

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
      if (url == null || userName == null || password == null) {
         throw new IllegalArgumentException(
               "Expected --url, --username, --password arguments.");
      }
   }

   //get input parameters to run the sample
   private static void getInputParameters(String[] args) {
      int ai = 0;
      String param = "";
      String val = "";
      while (ai < args.length) {
         param = args[ai].trim();
         if (ai + 1 < args.length) {
            val = args[ai + 1].trim();
         }
         if (param.equalsIgnoreCase("--dcName") && !val.startsWith("--")
               && !val.isEmpty()) {
            dcName = val;
         } else if (param.equalsIgnoreCase("--vmdnsname")
               && !val.startsWith("--") && !val.isEmpty()) {
            vmDnsName = val;
         } else if (param.equalsIgnoreCase("--vmpath") && !val.startsWith("--")
               && !val.isEmpty()) {
            vmPath = val;
         } else if (param.equalsIgnoreCase("--hostDns")
               && !val.startsWith("--") && !val.isEmpty()) {
            hostDnsName = val;
         } else if (param.equalsIgnoreCase("--vmIP") && !val.startsWith("--")
               && !val.isEmpty()) {
            vmIP = val;
         }
         val = "";
         ai += 2;
      }
      if (dcName == null) {
         throw new IllegalArgumentException("Expected --dcName argument.");
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

   /**
    * Returns all the MOREFs of the specified type that are present under the
    * folder
    * 
    * @param folder
    *           {@link ManagedObjectReference} of the folder to begin the search
    *           from
    * @param morefType
    *           Type of the managed entity that needs to be searched
    * 
    * @return Map of name and MOREF of the managed objects present. If none
    *         exist then empty Map is returned
    * 
    * @throws InvalidPropertyFaultMsg
    * @throws RuntimeFaultFaultMsg
    */
   private static Map<String, ManagedObjectReference> getMOREFsInFolderByType(
         ManagedObjectReference folder, String morefType)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
      ManagedObjectReference viewManager = serviceContent.getViewManager();
      ManagedObjectReference containerView =
            vimPort.createContainerView(viewManager, folder,
                  Arrays.asList(morefType), true);

      Map<String, ManagedObjectReference> tgtMoref =
            new HashMap<String, ManagedObjectReference>();

      // Create Property Spec
      PropertySpec propertySpec = new PropertySpec();
      propertySpec.setAll(Boolean.FALSE);
      propertySpec.setType(morefType);
      propertySpec.getPathSet().add(PROP_ME_NAME);

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
            ManagedObjectReference mr = oc.getObj();
            String entityNm = null;
            List<DynamicProperty> dps = oc.getPropSet();
            if (dps != null) {
               for (DynamicProperty dp : dps) {
                  entityNm = (String) dp.getVal();
               }
            }
            tgtMoref.put(entityNm, mr);
         }
      }
      return tgtMoref;
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
      System.out.println("This sample demonstrates the SearchIndex API");
      System.out.println("\nParameters:");
      System.out.println("url          [required] : url of the web service");
      System.out
            .println("username     [required] : username for the authentication");
      System.out
            .println("password     [required] : password for the authentication");
      System.out.println("dcname       [required] : name of the datacenter");
      System.out.println("vmdnsname    [optional] : Dns of a virtual machine");
      System.out.println("hostdnsname  [optional] : Dns of the ESX host");
      System.out
            .println("vmpath       [optional] : Inventory path of a virtual machine");
      System.out
            .println("vmip         [optional] : IP Address of a virtual machine");
      System.out.println("\nCommand:");
      System.out.println("Run the search index with dcname myDatacenter");
      System.out
            .println("run.bat com.vmware.general.SearchIndex --url [webserviceurl]");
      System.out
            .println("--username [username] --password [password] --dcname myDatacenter");
      System.out
            .println("Run the search index with dcname myDatacenter and vmpath");
      System.out.println("to virtual machine named Test");
      System.out
            .println("run.bat com.vmware.general.SearchIndex --url [webserviceurl] ");
      System.out.println("--username [username] --password [password]");
      System.out
            .println(" --dcname [myDatacenter] --vmpath //DatacenterName//vm//Test");
      System.out
            .println("Run the search index with dcname myDatacenter and hostdnsname "
                  + "'abc.bcd.com'");
      System.out
            .println("run.bat com.vmware.general.SearchIndex --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--dcname myDatacenter --hostdnsname abc.bcd.com");
      System.out.println("Run the search index with "
            + "dcname myDatacenter and vmip of 111.123.155.21");
      System.out
            .println("run.bat com.vmware.general.SearchIndex --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--dcname myDatacenter --vmip 111.123.155.21");
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
         Map<String, ManagedObjectReference> entities =
               getMOREFsInFolderByType(serviceContent.getRootFolder(),
                     "Datacenter");
         ManagedObjectReference dcMoRef = entities.get(dcName);

         if (dcMoRef != null) {
            System.out.println("Found Datacenter with name: " + dcName
                  + ", MoRef: " + dcMoRef.getValue());
         } else {
            System.out.println("Datacenter not Found with name: " + dcName);
            return;
         }

         if (vmDnsName != null) {

            ManagedObjectReference vmMoRef = null;
            try {
               vmMoRef =
                     vimPort.findByDnsName(serviceContent.getSearchIndex(),
                           dcMoRef, vmDnsName, true);
            } catch (SOAPFaultException sfe) {
               printSoapFaultException(sfe);
            } catch (RuntimeFaultFaultMsg ex) {
               System.out.println("Error Encountered: " + ex);
            }
            if (vmMoRef != null) {
               System.out.println("Found VirtualMachine with DNS name: "
                     + vmDnsName + ", MoRef: " + vmMoRef.getValue());
            } else {
               System.out.println("VirtualMachine not Found with DNS name: "
                     + vmDnsName);
            }
         }
         if (vmPath != null) {
            ManagedObjectReference vmMoRef = null;
            try {
               vmMoRef =
                     vimPort.findByInventoryPath(
                           serviceContent.getSearchIndex(), vmPath);
            } catch (SOAPFaultException sfe) {
               printSoapFaultException(sfe);
            } catch (RuntimeFaultFaultMsg ex) {
               System.out.println("Error Encountered: " + ex);
            }
            if (vmMoRef != null) {
               System.out.println("Found VirtualMachine with Path: " + vmPath
                     + ", MoRef: " + vmMoRef.getValue());

            } else {
               System.out.println("VirtualMachine not found with vmPath "
                     + "address: " + vmPath);
            }
         }
         if (vmIP != null) {
            ManagedObjectReference vmMoRef = null;
            try {
               vmMoRef =
                     vimPort.findByIp(serviceContent.getSearchIndex(), dcMoRef,
                           vmIP, true);
            } catch (SOAPFaultException sfe) {
               printSoapFaultException(sfe);
            } catch (RuntimeFaultFaultMsg ex) {
               System.out.println("Error Encountered: " + ex);
            }
            if (vmMoRef != null) {
               System.out.println("Found VirtualMachine with IP " + "address "
                     + vmIP + ", MoRef: " + vmMoRef.getValue());
            } else {
               System.out.println("VirtualMachine not found with IP "
                     + "address: " + vmIP);
            }
         }
         if (hostDnsName != null) {
            ManagedObjectReference hostMoRef = null;
            try {
               hostMoRef =
                     vimPort.findByDnsName(serviceContent.getSearchIndex(),
                           null, hostDnsName, false);
            } catch (SOAPFaultException sfe) {
               printSoapFaultException(sfe);
            } catch (RuntimeFaultFaultMsg ex) {
               System.out.println("Error Encountered: " + ex);
            }
            if (hostMoRef != null) {
               System.out.println("Found HostSystem with DNS name "
                     + hostDnsName + ", MoRef: " + hostMoRef.getValue());
            } else {
               System.out.println("HostSystem not Found with DNS name:"
                     + hostDnsName);
            }
         }
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
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
