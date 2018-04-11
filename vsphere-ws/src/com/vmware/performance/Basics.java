package com.vmware.performance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.ArrayOfPerfCounterInfo;
import com.vmware.vim25.ArrayOfPerfInterval;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.ElementDescription;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PerfCounterInfo;
import com.vmware.vim25.PerfInterval;
import com.vmware.vim25.PerfMetricId;
import com.vmware.vim25.PerfProviderSummary;
import com.vmware.vim25.PerfSummaryType;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * Basics
 * 
 * This sample displays available performance counters or other data
 * for an requested ESX system. Output is in following report style:
 * 
 * Performance Interval:
 *    Interval Name
 *    Interval Period
 *    Interval Length
 *    Performance counters:
 *    Host perf capabilities:
 *    Summary supported
 *    Current supported
 *    Current refresh rate
 * 
 * <b>Parameters:</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 * info         [required] : requested info - [interval|counter|host]
 * hostname     [optional] : required when 'info' is 'host'
 * 
 * <b>Command Line:</b>
 * Display name and description of all perf counters on VCenter
 * run.bat com.vmware.performance.Basics --url [webserviceurl]
 * --username [username] --password [password]
 * --info [interval|counter|host] --hostname [VC hostname]
 * 
 * Display counter names, sampling period, length of all intervals
 * run.bat com.vmware.performance.Basics --url [webserviceurl]
 * --username [username] --password [password]
 * --info interval --hostname [VC or ESX hostname]
 * 
 * Display name and description of all perf counters on ESX
 *  run.bat com.vmware.performance.Basics --url [webserviceurl]
 *  --username [username] --password [password]
 * --info counter --hostname [ESX hostname]
 * 
 * Display name, description and metrics of all perf counters on ESX
 * run.bat com.vmware.performance.Basics --url [webserviceurl]
 * --username [username] --password [password]
 * --info host  --hostname [ESX hostname]
 * </pre>
 */

public class Basics {

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

   private static ManagedObjectReference propCollectorRef;
   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;
   private static Boolean isConnected = false;

   private static String url;
   private static String userName;
   private static String password;
   private static boolean help = false;
   private static ManagedObjectReference perfManager;
   private static String info;
   private static String hostname;

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
         if (param.equalsIgnoreCase("--info") && !val.startsWith("--")
               && !val.isEmpty()) {
            info = val;
         } else if (param.equalsIgnoreCase("--hostname")
               && !val.startsWith("--") && !val.isEmpty()) {
            hostname = val;
         }
         val = "";
         ai += 2;
      }
      if (info == null) {
         throw new IllegalArgumentException("Expected --info argument.");
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
      perfManager = serviceContent.getPerfManager();
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

   private static boolean validateTheInput() {
      if (info.equalsIgnoreCase("host")) {
         if (hostname == null) {
            System.out.println("Must specify the --hostname"
                  + " parameter when --info is host");
            return false;
         }
      }
      return true;
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

   /**
    * 
    * @return TraversalSpec specification to get to the HostSystem managed
    *         object.
    */
   private static TraversalSpec getHostSystemTraversalSpec() {
      // Create a traversal spec that starts from the 'root' objects
      // and traverses the inventory tree to get to the Host system.
      // Build the traversal specs bottoms up
      SelectionSpec ss = new SelectionSpec();
      ss.setName("VisitFolders");

      // Traversal to get to the host from ComputeResource
      TraversalSpec computeResourceToHostSystem = new TraversalSpec();
      computeResourceToHostSystem.setName("computeResourceToHostSystem");
      computeResourceToHostSystem.setType("ComputeResource");
      computeResourceToHostSystem.setPath("host");
      computeResourceToHostSystem.setSkip(false);
      computeResourceToHostSystem.getSelectSet().add(ss);

      // Traversal to get to the ComputeResource from hostFolder
      TraversalSpec hostFolderToComputeResource = new TraversalSpec();
      hostFolderToComputeResource.setName("hostFolderToComputeResource");
      hostFolderToComputeResource.setType("Folder");
      hostFolderToComputeResource.setPath("childEntity");
      hostFolderToComputeResource.setSkip(false);
      hostFolderToComputeResource.getSelectSet().add(ss);

      // Traversal to get to the hostFolder from DataCenter
      TraversalSpec dataCenterToHostFolder = new TraversalSpec();
      dataCenterToHostFolder.setName("DataCenterToHostFolder");
      dataCenterToHostFolder.setType("Datacenter");
      dataCenterToHostFolder.setPath("hostFolder");
      dataCenterToHostFolder.setSkip(false);
      dataCenterToHostFolder.getSelectSet().add(ss);

      //TraversalSpec to get to the DataCenter from rootFolder
      TraversalSpec traversalSpec = new TraversalSpec();
      traversalSpec.setName("VisitFolders");
      traversalSpec.setType("Folder");
      traversalSpec.setPath("childEntity");
      traversalSpec.setSkip(false);

      List<SelectionSpec> sSpecArr = new ArrayList<SelectionSpec>();
      sSpecArr.add(ss);
      sSpecArr.add(dataCenterToHostFolder);
      sSpecArr.add(hostFolderToComputeResource);
      sSpecArr.add(computeResourceToHostSystem);
      traversalSpec.getSelectSet().addAll(sSpecArr);
      return traversalSpec;
   }

   /**
    * Retrieves the MOREF of the host.
    * 
    * @param hostName
    *           :
    * @return
    */
   private static ManagedObjectReference getHostByHostName(String hostName) {
      ManagedObjectReference retVal = null;
      ManagedObjectReference rootFolder = serviceContent.getRootFolder();
      try {
         TraversalSpec tSpec = getHostSystemTraversalSpec();
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add("name");
         propertySpec.setType("HostSystem");

         // Now create Object Spec
         ObjectSpec objectSpec = new ObjectSpec();
         objectSpec.setObj(rootFolder);
         objectSpec.setSkip(Boolean.TRUE);
         objectSpec.getSelectSet().add(tSpec);

         // Create PropertyFilterSpec using the PropertySpec and ObjectPec
         // created above.
         PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
         propertyFilterSpec.getPropSet().add(propertySpec);
         propertyFilterSpec.getObjectSet().add(objectSpec);
         List<PropertyFilterSpec> listpfs =
               new ArrayList<PropertyFilterSpec>(1);
         listpfs.add(propertyFilterSpec);
         List<ObjectContent> listobjcont =
               retrievePropertiesAllObjects(listpfs);

         if (listobjcont != null) {
            for (ObjectContent oc : listobjcont) {
               ManagedObjectReference mr = oc.getObj();
               String hostnm = null;
               List<DynamicProperty> listDynamicProps = oc.getPropSet();
               DynamicProperty[] dps =
                     listDynamicProps
                           .toArray(new DynamicProperty[listDynamicProps.size()]);
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     hostnm = (String) dp.getVal();
                  }
               }
               if (hostnm != null && hostnm.equals(hostName)) {
                  retVal = mr;
                  break;
               }
            }
         } else {
            System.out.println("The Object Content is Null");
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return retVal;
   }

   private static void displayBasics() throws RuntimeFaultFaultMsg,
         DatatypeConfigurationException, InvalidPropertyFaultMsg, Exception {

      if (info.equalsIgnoreCase("interval")) {
         getIntervals(perfManager, vimPort);
      } else if (info.equalsIgnoreCase("counter")) {
         getCounters(perfManager, vimPort);
      } else if (info.equalsIgnoreCase("host")) {
         ManagedObjectReference hostmor = getHostByHostName(hostname);
         if (hostmor == null) {
            System.out.println("Host " + hostname + " not found");
            return;
         }
         getQuerySummary(perfManager, hostmor, vimPort);
         getQueryAvailable(perfManager, hostmor, vimPort);
      } else {
         System.out.println("Invalid info argument [host|counter|interval]");
      }
   }

   private static void getIntervals(ManagedObjectReference perfMgr,
         VimPortType service) throws InvalidPropertyFaultMsg,
         RuntimeFaultFaultMsg, Exception {
      Object property = getProperty(service, perfMgr, "historicalInterval");
      ArrayOfPerfInterval arrayInterval = (ArrayOfPerfInterval) property;
      List<PerfInterval> intervals = arrayInterval.getPerfInterval();
      System.out.println("Performance intervals (" + intervals.size() + "):");
      System.out.println("---------------------");

      int count = 0;
      for (PerfInterval interval : intervals) {
         System.out.print((++count) + ": " + interval.getName());
         System.out.print(" -- period = " + interval.getSamplingPeriod());
         System.out.println(", length = " + interval.getLength());
      }
      System.out.println();
   }

   private static void getCounters(ManagedObjectReference perfMgr,
         VimPortType service) throws InvalidPropertyFaultMsg,
         RuntimeFaultFaultMsg, Exception {
      Object property = getProperty(service, perfMgr, "perfCounter");
      ArrayOfPerfCounterInfo arrayCounter = (ArrayOfPerfCounterInfo) property;
      List<PerfCounterInfo> counters = arrayCounter.getPerfCounterInfo();
      System.out.println("Performance counters (averages only):");
      System.out.println("-------------------------------------");
      for (PerfCounterInfo counter : counters) {
         if (counter.getRollupType() == PerfSummaryType.AVERAGE) {
            ElementDescription desc = counter.getNameInfo();
            System.out.println(desc.getLabel() + ": " + desc.getSummary());
         }
      }
      System.out.println();
   }

   private static void getQuerySummary(ManagedObjectReference perfMgr,
         ManagedObjectReference hostmor, VimPortType service)
         throws RuntimeFaultFaultMsg, Exception {
      PerfProviderSummary summary =
            service.queryPerfProviderSummary(perfMgr, hostmor);
      System.out.println("Host perf capabilities:");
      System.out.println("----------------------");
      System.out
            .println("  Summary supported: " + summary.isSummarySupported());
      System.out
            .println("  Current supported: " + summary.isCurrentSupported());
      if (summary.isCurrentSupported()) {
         System.out.println("  Current refresh rate: "
               + summary.getRefreshRate());
      }
      System.out.println();
   }

   private static void getQueryAvailable(ManagedObjectReference perfMgr,
         ManagedObjectReference hostmor, VimPortType service)
         throws DatatypeConfigurationException, RuntimeFaultFaultMsg, Exception {

      PerfProviderSummary perfProviderSummary =
            service.queryPerfProviderSummary(perfMgr, hostmor);
      List<PerfMetricId> pmidlist =
            service.queryAvailablePerfMetric(perfMgr, hostmor, null, null,
                  perfProviderSummary.getRefreshRate());

      List<Integer> idslist = new ArrayList<Integer>();

      for (int i = 0; i != pmidlist.size(); ++i) {
         idslist.add(pmidlist.get(i).getCounterId());
      }

      List<PerfCounterInfo> pcinfolist =
            service.queryPerfCounter(perfMgr, idslist);
      System.out.println("Available real-time metrics for host ("
            + pmidlist.size() + "):");
      System.out.println("--------------------------");
      for (int i = 0; i != pmidlist.size(); ++i) {
         String label = pcinfolist.get(i).getNameInfo().getLabel();
         String instance = pmidlist.get(i).getInstance();
         System.out.print("   " + label);
         if (instance.length() != 0) {
            System.out.print(" [" + instance + "]");
         }
         System.out.println();
      }
      System.out.println();
   }

   private static List<Object> getProperties(VimPortType service,
         ManagedObjectReference moRef, List<String> properties)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, Exception {
      PropertySpec pSpec = new PropertySpec();
      pSpec.setType(moRef.getType());
      pSpec.getPathSet().addAll(properties);
      ObjectSpec oSpec = new ObjectSpec();
      oSpec.setObj(moRef);
      PropertyFilterSpec pfSpec = new PropertyFilterSpec();
      pfSpec.getPropSet().addAll(Arrays.asList(new PropertySpec[] { pSpec }));
      pfSpec.getObjectSet().addAll(Arrays.asList(new ObjectSpec[] { oSpec }));
      List<PropertyFilterSpec> listpfs = new ArrayList<PropertyFilterSpec>();
      listpfs.add(pfSpec);
      List<ObjectContent> listobjcont = retrievePropertiesAllObjects(listpfs);
      List<Object> ret = new ArrayList<Object>();
      if (listobjcont != null) {
         for (int i = 0; i < listobjcont.size(); ++i) {
            ObjectContent oc = listobjcont.get(i);
            List<DynamicProperty> listdps = oc.getPropSet();
            if (listdps != null) {
               for (int j = 0; j < listdps.size(); ++j) {
                  DynamicProperty dp = listdps.get(j);
                  for (int p = 0; p < properties.size(); ++p) {
                     if (properties.get(p).equals(dp.getName())) {
                        ret.add(dp.getVal());
                     }
                  }
               }
            }
         }
      }
      return ret;
   }

   private static Object getProperty(VimPortType service,
         ManagedObjectReference moRef, String prop)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg, Exception {
      List<String> property = new ArrayList<String>();
      property.add(prop);
      List<Object> props = getProperties(service, moRef, property);
      if (props.size() > 0) {
         return props.get(0);
      } else {
         return null;
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
            .println("This sample displays available performance counters or other data");
      System.out
            .println("for an requested ESX system. Output is in following report style:");
      System.out.println("Perfomance Interval:");
      System.out.println("   Interval Name ");
      System.out.println("   Interval Period");
      System.out.println("   Interval Length");
      System.out.println("   Performance counters:");
      System.out.println("   Host perf capabilities:");
      System.out.println("   Summary supported");
      System.out.println("   Current supported");
      System.out.println("   Current refresh rate");
      System.out.println("\nParameters:");
      System.out.println("url          [required] : url of the web service.");
      System.out
            .println("username     [required] : username for the authentication");
      System.out
            .println("password     [required] : password for the authentication");
      System.out
            .println("info         [required] : requested info - [interval|counter|host]");
      System.out
            .println("hostname     [optional] : required when 'info' is 'host'");
      System.out.println("\nCommand:");
      System.out
            .println("Display name and description of all perf counters on VCenter");
      System.out
            .println("run.bat com.vmware.performance.Basics --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out
            .println("--info [interval|counter|host] --hostname [VC hostname]");
      System.out
            .println("Display counter names, sampling period, length of all intervals");
      System.out
            .println("run.bat com.vmware.performance.Basics --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--info interval --hostname [VC or ESX hostname]");
      System.out
            .println("Display name and description of all perf counters on ESX");
      System.out
            .println(" run.bat com.vmware.performance.Basics --url [webserviceurl]");
      System.out.println(" --username [username] --password [password]");
      System.out.println("--info counter --hostname [ESX hostname]");
      System.out
            .println("Display name, description and metrics of all perf counters on VC or ESX");
      System.out
            .println("run.bat com.vmware.performance.Basics --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--info host  --hostname [VC / ESX hostname]");
   }

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         getInputParameters(args);
         if (help) {
            printUsage();
            return;
         }
         if (!validateTheInput()) {
            printUsage();
            return;
         }
         connect();
         displayBasics();
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