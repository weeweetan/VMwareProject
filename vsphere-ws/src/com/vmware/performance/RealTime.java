package com.vmware.performance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.ArrayOfPerfCounterInfo;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PerfCounterInfo;
import com.vmware.vim25.PerfEntityMetric;
import com.vmware.vim25.PerfEntityMetricBase;
import com.vmware.vim25.PerfMetricId;
import com.vmware.vim25.PerfMetricIntSeries;
import com.vmware.vim25.PerfMetricSeries;
import com.vmware.vim25.PerfQuerySpec;
import com.vmware.vim25.PerfSampleInfo;
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
 * RealTime
 * 
 * This sample displays performance measurements from the current time 
 * at the console
 *   
 * <b>Parameters:</b>
 * url        [required] : url of the web service
 * username   [required] : username for the authentication
 * password   [required] : password for the authentication
 * vmname     [required] : name of the vm
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.performance.RealTime
 * --url [webservice url]  --username [user] --password [password]
 * --vmname [name of the vm]
 * </pre>
 */
public class RealTime {

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
   private static String virtualmachinename;

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
         if (param.equalsIgnoreCase("--vmname") && !val.startsWith("--")
               && !val.isEmpty()) {
            virtualmachinename = val;
         }
         val = "";
         ai += 2;
      }
      if (virtualmachinename == null) {
         throw new IllegalArgumentException("Expected --vmname argument.");
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

   private static void displayValues(List<PerfEntityMetricBase> values,
         Map<Integer, PerfCounterInfo> counters) {

      for (int i = 0; i < values.size(); ++i) {
         List<PerfMetricSeries> listpems =
               ((PerfEntityMetric) values.get(i)).getValue();
         List<PerfSampleInfo> listinfo =
               ((PerfEntityMetric) values.get(i)).getSampleInfo();

         System.out.println("Sample time range: "
               + listinfo.get(0).getTimestamp().toString() + " - "
               + listinfo.get(listinfo.size() - 1).getTimestamp().toString());
         for (int vi = 0; vi < listpems.size(); ++vi) {
            PerfCounterInfo pci =
                  counters.get(new Integer(listpems.get(vi).getId()
                        .getCounterId()));
            if (pci != null) {
               System.out.println(pci.getNameInfo().getSummary());
            }
            if (listpems.get(vi) instanceof PerfMetricIntSeries) {
               PerfMetricIntSeries val = (PerfMetricIntSeries) listpems.get(vi);
               List<Long> lislon = val.getValue();
               for (Long k : lislon) {
                  System.out.print(k + " ");
               }
               System.out.println();
            }
         }
      }
   }

   /**
    * This method initializes all the performance counters available on the
    * system it is connected to. The performance counters are stored in the
    * hashmap counters with group.counter.rolluptype being the key and id being
    * the value.
    */
   private static List<PerfCounterInfo> getPerfCounters() {
      List<PerfCounterInfo> pciArr = null;

      try {
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add("perfCounter");
         propertySpec.setType("PerformanceManager");
         List<PropertySpec> propertySpecs = new ArrayList<PropertySpec>();
         propertySpecs.add(propertySpec);

         // Now create Object Spec
         ObjectSpec objectSpec = new ObjectSpec();
         objectSpec.setObj(perfManager);
         List<ObjectSpec> objectSpecs = new ArrayList<ObjectSpec>();
         objectSpecs.add(objectSpec);

         // Create PropertyFilterSpec using the PropertySpec and ObjectPec
         // created above.
         PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
         propertyFilterSpec.getPropSet().add(propertySpec);
         propertyFilterSpec.getObjectSet().add(objectSpec);

         List<PropertyFilterSpec> propertyFilterSpecs =
               new ArrayList<PropertyFilterSpec>();
         propertyFilterSpecs.add(propertyFilterSpec);

         List<PropertyFilterSpec> listpfs =
               new ArrayList<PropertyFilterSpec>(1);
         listpfs.add(propertyFilterSpec);
         List<ObjectContent> listobjcont =
               retrievePropertiesAllObjects(listpfs);

         if (listobjcont != null) {
            for (ObjectContent oc : listobjcont) {
               List<DynamicProperty> dps = oc.getPropSet();
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     List<PerfCounterInfo> pcinfolist =
                           ((ArrayOfPerfCounterInfo) dp.getVal())
                                 .getPerfCounterInfo();
                     pciArr = pcinfolist;
                  }
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return pciArr;
   }

   /**
    * 
    * @return TraversalSpec specification to get to the VirtualMachine managed
    *         object.
    */
   private static TraversalSpec getVMTraversalSpec() {
      // Create a traversal spec that starts from the 'root' objects
      // and traverses the inventory tree to get to the VirtualMachines.
      // Build the traversal specs bottoms up

      // Traversal to get to the VM in a VApp
      TraversalSpec vAppToVM = new TraversalSpec();
      vAppToVM.setName("vAppToVM");
      vAppToVM.setType("VirtualApp");
      vAppToVM.setPath("vm");

      // Traversal spec for VApp to VApp
      TraversalSpec vAppToVApp = new TraversalSpec();
      vAppToVApp.setName("vAppToVApp");
      vAppToVApp.setType("VirtualApp");
      vAppToVApp.setPath("resourcePool");
      // SelectionSpec for VApp to VApp recursion
      SelectionSpec vAppRecursion = new SelectionSpec();
      vAppRecursion.setName("vAppToVApp");
      // SelectionSpec to get to a VM in the VApp
      SelectionSpec vmInVApp = new SelectionSpec();
      vmInVApp.setName("vAppToVM");
      // SelectionSpec for both VApp to VApp and VApp to VM
      List<SelectionSpec> vAppToVMSS = new ArrayList<SelectionSpec>();
      vAppToVMSS.add(vAppRecursion);
      vAppToVMSS.add(vmInVApp);
      vAppToVApp.getSelectSet().addAll(vAppToVMSS);

      // This SelectionSpec is used for recursion for Folder recursion
      SelectionSpec sSpec = new SelectionSpec();
      sSpec.setName("VisitFolders");

      // Traversal to get to the vmFolder from DataCenter
      TraversalSpec dataCenterToVMFolder = new TraversalSpec();
      dataCenterToVMFolder.setName("DataCenterToVMFolder");
      dataCenterToVMFolder.setType("Datacenter");
      dataCenterToVMFolder.setPath("vmFolder");
      dataCenterToVMFolder.setSkip(false);
      dataCenterToVMFolder.getSelectSet().add(sSpec);

      // TraversalSpec to get to the DataCenter from rootFolder
      TraversalSpec traversalSpec = new TraversalSpec();
      traversalSpec.setName("VisitFolders");
      traversalSpec.setType("Folder");
      traversalSpec.setPath("childEntity");
      traversalSpec.setSkip(false);
      List<SelectionSpec> sSpecArr = new ArrayList<SelectionSpec>();
      sSpecArr.add(sSpec);
      sSpecArr.add(dataCenterToVMFolder);
      sSpecArr.add(vAppToVM);
      sSpecArr.add(vAppToVApp);
      traversalSpec.getSelectSet().addAll(sSpecArr);
      return traversalSpec;
   }

   /**
    * Get the MOR of the Virtual Machine by its name.
    * 
    * @param vmName
    *           The name of the Virtual Machine
    * @return The Managed Object reference for this VM
    */
   private static ManagedObjectReference getVmByVMname(String vmName) {
      ManagedObjectReference retVal = null;
      ManagedObjectReference rootFolder = serviceContent.getRootFolder();
      try {
         TraversalSpec tSpec = getVMTraversalSpec();
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add("name");
         propertySpec.setType("VirtualMachine");

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
               String vmnm = null;
               List<DynamicProperty> dps = oc.getPropSet();
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     vmnm = (String) dp.getVal();
                  }
               }
               if (vmnm != null && vmnm.equals(vmName)) {
                  retVal = mr;
                  break;
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return retVal;
   }

   private static void doRealTime() throws Exception {
      ManagedObjectReference vmmor = getVmByVMname(virtualmachinename);

      if (vmmor != null) {
         List<PerfCounterInfo> cInfo = getPerfCounters();
         List<PerfCounterInfo> vmCpuCounters = new ArrayList<PerfCounterInfo>();
         for (int i = 0; i < cInfo.size(); ++i) {
            if ("cpu".equalsIgnoreCase(cInfo.get(i).getGroupInfo().getKey())) {
               vmCpuCounters.add(cInfo.get(i));
            }
         }
         Map<Integer, PerfCounterInfo> counters =
               new HashMap<Integer, PerfCounterInfo>();
         while (true) {
            int i = 0;
            for (Iterator<PerfCounterInfo> it = vmCpuCounters.iterator(); it
                  .hasNext();) {
               PerfCounterInfo pcInfo = it.next();
               System.out.println(++i + " - "
                     + pcInfo.getNameInfo().getSummary());
            }
            System.out.println("Please select a counter from"
                  + " the above list" + "\nEnter 0 to end: ");
            BufferedReader reader =
                  new BufferedReader(new InputStreamReader(System.in));
            i = Integer.parseInt(reader.readLine());
            if (i > vmCpuCounters.size()) {
               System.out.println("*** Value out of range!");
            } else {
               --i;
               if (i < 0) {
                  return;
               }
               PerfCounterInfo pcInfo = vmCpuCounters.get(i);
               counters.put(new Integer(pcInfo.getKey()), pcInfo);
               break;
            }
         }
         List<PerfMetricId> listpermeid =
               vimPort.queryAvailablePerfMetric(perfManager, vmmor, null, null,
                     new Integer(20));
         List<PerfMetricId> mMetrics = new ArrayList<PerfMetricId>();
         if (listpermeid != null) {
            for (int index = 0; index < listpermeid.size(); ++index) {
               if (counters.containsKey(new Integer(listpermeid.get(index)
                     .getCounterId()))) {
                  mMetrics.add(listpermeid.get(index));
               }
            }
         }
         monitorPerformance(perfManager, vmmor, mMetrics, counters);
      } else {
         System.out.println("Virtual Machine " + virtualmachinename
               + " not found");
      }
   }

   /**
    * 
    * @param pmRef
    * @param vmRef
    * @param mMetrics
    * @param counters
    * @throws Exception
    */
   private static void monitorPerformance(ManagedObjectReference pmRef,
         ManagedObjectReference vmRef, List<PerfMetricId> mMetrics,
         Map<Integer, PerfCounterInfo> counters) throws Exception {
      PerfQuerySpec qSpec = new PerfQuerySpec();
      qSpec.setEntity(vmRef);
      qSpec.setMaxSample(new Integer(10));
      qSpec.getMetricId().addAll(mMetrics);
      qSpec.setIntervalId(new Integer(20));

      List<PerfQuerySpec> qSpecs = new ArrayList<PerfQuerySpec>();
      qSpecs.add(qSpec);
      while (true) {
         List<PerfEntityMetricBase> listpemb = vimPort.queryPerf(pmRef, qSpecs);
         List<PerfEntityMetricBase> pValues = listpemb;
         if (pValues != null) {
            displayValues(pValues, counters);
         }
         System.out.println("Sleeping 10 seconds...");
         Thread.sleep(10 * 1000);
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
      System.out.println("This sample displays performance measurements from "
            + "the current time at the console.");
      System.out.println("\nParameters:");
      System.out.println("url        [required] : url of the web service.");
      System.out
            .println("username   [required] : username for the authentication");
      System.out
            .println("password   [required] : password for the authentication");
      System.out.println("vmname     [required] : name of the vm");
      System.out.println("\nCommand:");
      System.out.println("run.bat com.vmware.performance.RealTime");
      System.out
            .println("--url [webservice url]  --username [user] --password [password]");
      System.out.println("--vmname [name of the vm]");
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
         doRealTime();
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
