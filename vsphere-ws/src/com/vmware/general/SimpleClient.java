package com.vmware.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * SimpleClient
 * 
 * This sample lists the inventory contents (managed entities)
 * 
 * <b>Parameters:</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.general.SimpleClient
 * --url [webserviceurl] --username [username] --password [password]
 * </pre>
 */

public class SimpleClient {

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
   private static ManagedObjectReference propCollectorRef;
   private static ManagedObjectReference rootRef;
   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;
   private static final String SVC_INST_NAME = "ServiceInstance";

   private static String url;
   private static String userName;
   private static String password;
   private static boolean help = false;
   private static boolean isConnected = false;

   private static void trustAllHttpsCertificates() throws Exception {
      // Create a trust manager that does not validate certificate chains:
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

      propCollectorRef = serviceContent.getPropertyCollector();
      rootRef = serviceContent.getRootFolder();
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
    * Uses the new RetrievePropertiesEx method to emulate the now deprecated
    * RetrieveProperties method
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
               vimPort.retrievePropertiesEx(propCollectorRef, listpfs,
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
            rslts =
                  vimPort.continueRetrievePropertiesEx(propCollectorRef, token);
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

   private static void getAndPrintInventoryContents() throws Exception {
      TraversalSpec resourcePoolTraversalSpec = new TraversalSpec();
      resourcePoolTraversalSpec.setName("resourcePoolTraversalSpec");
      resourcePoolTraversalSpec.setType("ResourcePool");
      resourcePoolTraversalSpec.setPath("resourcePool");
      resourcePoolTraversalSpec.setSkip(Boolean.FALSE);
      SelectionSpec rpts = new SelectionSpec();
      rpts.setName("resourcePoolTraversalSpec");
      resourcePoolTraversalSpec.getSelectSet().add(rpts);

      TraversalSpec computeResourceRpTraversalSpec = new TraversalSpec();
      computeResourceRpTraversalSpec.setName("computeResourceRpTraversalSpec");
      computeResourceRpTraversalSpec.setType("ComputeResource");
      computeResourceRpTraversalSpec.setPath("resourcePool");
      computeResourceRpTraversalSpec.setSkip(Boolean.FALSE);
      SelectionSpec rptss = new SelectionSpec();
      rptss.setName("resourcePoolTraversalSpec");
      computeResourceRpTraversalSpec.getSelectSet().add(rptss);

      TraversalSpec computeResourceHostTraversalSpec = new TraversalSpec();
      computeResourceHostTraversalSpec
            .setName("computeResourceHostTraversalSpec");
      computeResourceHostTraversalSpec.setType("ComputeResource");
      computeResourceHostTraversalSpec.setPath("host");
      computeResourceHostTraversalSpec.setSkip(Boolean.FALSE);

      TraversalSpec datacenterHostTraversalSpec = new TraversalSpec();
      datacenterHostTraversalSpec.setName("datacenterHostTraversalSpec");
      datacenterHostTraversalSpec.setType("Datacenter");
      datacenterHostTraversalSpec.setPath("hostFolder");
      datacenterHostTraversalSpec.setSkip(Boolean.FALSE);
      SelectionSpec ftspec = new SelectionSpec();
      ftspec.setName("folderTraversalSpec");
      datacenterHostTraversalSpec.getSelectSet().add(ftspec);

      TraversalSpec datacenterVmTraversalSpec = new TraversalSpec();
      datacenterVmTraversalSpec.setName("datacenterVmTraversalSpec");
      datacenterVmTraversalSpec.setType("Datacenter");
      datacenterVmTraversalSpec.setPath("vmFolder");
      datacenterVmTraversalSpec.setSkip(Boolean.FALSE);
      SelectionSpec ftspecs = new SelectionSpec();
      ftspecs.setName("folderTraversalSpec");
      datacenterVmTraversalSpec.getSelectSet().add(ftspecs);

      TraversalSpec folderTraversalSpec = new TraversalSpec();
      folderTraversalSpec.setName("folderTraversalSpec");
      folderTraversalSpec.setType("Folder");
      folderTraversalSpec.setPath("childEntity");
      folderTraversalSpec.setSkip(Boolean.FALSE);
      SelectionSpec ftrspec = new SelectionSpec();
      ftrspec.setName("folderTraversalSpec");
      List<SelectionSpec> ssarray = new ArrayList<SelectionSpec>();
      ssarray.add(ftrspec);
      ssarray.add(datacenterHostTraversalSpec);
      ssarray.add(datacenterVmTraversalSpec);
      ssarray.add(computeResourceRpTraversalSpec);
      ssarray.add(computeResourceHostTraversalSpec);
      ssarray.add(resourcePoolTraversalSpec);

      folderTraversalSpec.getSelectSet().addAll(ssarray);
      PropertySpec props = new PropertySpec();
      props.setAll(Boolean.FALSE);
      props.getPathSet().add("name");
      props.setType("VirtualMachine");
      List<PropertySpec> propspecary = new ArrayList<PropertySpec>();
      propspecary.add(props);

      PropertyFilterSpec spec = new PropertyFilterSpec();
      spec.getPropSet().addAll(propspecary);

      spec.getObjectSet().add(new ObjectSpec());
      spec.getObjectSet().get(0).setObj(rootRef);
      spec.getObjectSet().get(0).setSkip(Boolean.FALSE);
      spec.getObjectSet().get(0).getSelectSet().add(folderTraversalSpec);

      List<PropertyFilterSpec> listpfs = new ArrayList<PropertyFilterSpec>(1);
      listpfs.add(spec);
      List<ObjectContent> listobjcont = retrievePropertiesAllObjects(listpfs);

      // If we get contents back. print them out.
      if (listobjcont != null) {
         ObjectContent oc = null;
         ManagedObjectReference mor = null;
         DynamicProperty pc = null;
         for (int oci = 0; oci < listobjcont.size(); oci++) {
            oc = listobjcont.get(oci);
            mor = oc.getObj();

            List<DynamicProperty> listdp = oc.getPropSet();
            System.out.println("Object Type : " + mor.getType());
            System.out.println("Reference Value : " + mor.getValue());

            if (listdp != null) {
               for (int pci = 0; pci < listdp.size(); pci++) {
                  pc = listdp.get(pci);
                  System.out.println("   Property Name : " + pc.getName());
                  if (pc != null) {
                     if (!pc.getVal().getClass().isArray()) {
                        System.out
                              .println("   Property Value : " + pc.getVal());
                     } else {
                        List<Object> ipcary = new ArrayList<Object>();
                        ipcary.add(pc.getVal());
                        System.out.println("Val : " + pc.getVal());
                        for (int ii = 0; ii < ipcary.size(); ii++) {
                           Object oval = ipcary.get(ii);
                           if (oval.getClass().getName()
                                 .indexOf("ManagedObjectReference") >= 0) {
                              ManagedObjectReference imor =
                                    (ManagedObjectReference) oval;

                              System.out.println("Inner Object Type : "
                                    + imor.getType());
                              System.out.println("Inner Reference Value : "
                                    + imor.getValue());
                           } else {
                              System.out.println("Inner Property Value : "
                                    + oval);
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         System.out.println("No Managed Entities retrieved!");
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
            .println("This sample lists inventory contents (managed entities)");
      System.out.println("\nParameters:");
      System.out.println("url          [required] : url of the web service");
      System.out
            .println("username     [required] : username for the authentication");
      System.out
            .println("password     [required] : password for the authentication");
      System.out.println("\nCommand:");
      System.out
            .println("run.bat com.vmware.general.SimpleClient "
                  + "--url [webserviceurl] --username [username] --password [password]");
   }

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         if (help) {
            printUsage();
            return;
         }
         connect();
         getAndPrintInventoryContents();
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
