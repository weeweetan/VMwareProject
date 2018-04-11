package com.vmware.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.HostListSummaryQuickStats;
import com.vmware.vim25.HostRuntimeInfo;
import com.vmware.vim25.InvalidCollectorVersionFaultMsg;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.LocalizedMethodFault;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.ObjectUpdate;
import com.vmware.vim25.ObjectUpdateKind;
import com.vmware.vim25.PropertyChange;
import com.vmware.vim25.PropertyChangeOp;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertyFilterUpdate;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualMachineQuickStats;
import com.vmware.vim25.VirtualMachineRuntimeInfo;
import com.vmware.vim25.WaitOptions;

/**
 * <pre>
 * PropertyCollector
 * 
 * This sample illustrates the property collector features added in version 4.1
 * 
 * <b>Parameters:</b>
 * url            [required] : url of the web service.");
 * username       [required] : username for the authentication");
 * password       [required] : password for the authentication");
 * extension      [required] : Extension to be demonstrated [retrieveproperties |
 *                             updates | filterspec | propertycollector]
 * vmname         [optional] : Name of the virtual machine
 * maxobjects     [optional] : The maximum number of ObjectContent data objects
 *                             that should be returned in a single result
 * updatetype     [optional] : waitforupdates | checkforupdates| extension
 * nooftasks      [optional] : Number of tasks to be created
 * 
 * <b>Command Line:</b>
 * Retrieve Properties Extension
 * run.bat com.vmware.general.PropertyCollector --url [webserviceurl]
 * --username [username] --password [password] --extension retrieveproperties
 * --maxobjects  [maxobjects]
 * 
 * Updates Extension
 * run.bat com.vmware.general.PropertyCollector --url [webserviceurl]
 * --username [username] --password [password] --extension updates
 * --vmname [vm name] --updatetype  [waitforupdates | checkforupdates| extension]
 * 
 * Filter Spec Extension
 * run.bat com.vmware.general.PropertyCollector --url [webserviceurl]
 * --username [username] --password [password] --extension filterspec
 * --vmname [vm name] --noofTasks  [Number of tasks to be created]
 * 
 * Property Collector Extension
 * run.bat com.vmware.general.PropertyCollector --url [webserviceurl]
 * --username [username] --password [password] --extension propertycollector
 * </pre>
 */

public class PropertyCollector {

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
   private static ManagedObjectReference rootFolderRef = null;
   private static ManagedObjectReference propCollectorRef = null;

   /*
   Connection input parameters
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
      if (args != null && args.length != 0) {
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

      rootFolderRef = serviceContent.getRootFolder();
      propCollectorRef = serviceContent.getPropertyCollector();
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

   private static String extension = null;
   private static String vmName = null;
   private static String maxObjects = null;
   private static String updateType = null;
   private static String noofTasks = null;

   private static void getInputParameters(String[] args)
         throws IllegalArgumentException {
      int ai = 0;
      String param = "";
      String val = "";
      while (ai < args.length) {
         param = args[ai].trim();
         if (ai + 1 < args.length) {
            val = args[ai + 1].trim();
         }
         if (param.equalsIgnoreCase("--extension") && !val.startsWith("--")
               && !val.isEmpty()) {
            extension = val;
         } else if (param.equalsIgnoreCase("--vmname") && !val.startsWith("--")
               && !val.isEmpty()) {
            vmName = val;
         } else if (param.equalsIgnoreCase("--maxobjects")
               && !val.startsWith("--") && !val.isEmpty()) {
            maxObjects = val;
         } else if (param.equalsIgnoreCase("--updatetype")
               && !val.startsWith("--") && !val.isEmpty()) {
            updateType = val;
         } else if (param.equalsIgnoreCase("--nooftasks")
               && !val.startsWith("--") && !val.isEmpty()) {
            noofTasks = val;
         }
         val = "";
         ai += 2;
      }
      if (extension == null) {
         throw new IllegalArgumentException("Expected --extension argument.");
      }

      if (extension != null) {
         if (!extension.equalsIgnoreCase("retrieveproperties")
               && !extension.equalsIgnoreCase("updates")
               && !extension.equalsIgnoreCase("filterspec")
               && !extension.equalsIgnoreCase("propertycollector")) {
            throw new IllegalArgumentException(
                  "Invalid value for option extension."
                        + " Possible values [retrieveproperties | updates | filterspec |"
                        + " propertycollector]");
         }
         if (extension.equalsIgnoreCase("updates")
               && (vmName == null || updateType == null)) {
            throw new IllegalArgumentException(
                  "For update extension. vmname and"
                        + " updatetype are mandatory argument");
         }
         if (extension.equalsIgnoreCase("filterspec")
               && ((vmName == null) || (noofTasks == null))) {
            throw new IllegalArgumentException(
                  "For update extension. vmname and"
                        + " nooftasks are mandatory argument");
         }
      }
      if (updateType != null) {
         if (!updateType.equalsIgnoreCase("waitforupdates")
               && !updateType.equalsIgnoreCase("checkforupdates")
               && !updateType.equalsIgnoreCase("extension")) {
            throw new IllegalArgumentException(
                  "Invalid value for option updatetype."
                        + " Possible values [waitforupdates | checkforupdates | extension]");
         }
      }
   }

   private static void doOperations() throws Exception {

      if (extension.equalsIgnoreCase("retrieveproperties")) {
         if (maxObjects == null) {
            // Call to API RetrievePropertiesEx Without Setting "MaxObjects" property.
            callRetrievePropertiesEx(null);
         } else {
            // Call to API RetrievePropertiesEx by Setting "MaxObjects" property.
            callRetrievePropertiesEx(maxObjects);
         }
      } else if (extension.equalsIgnoreCase("updates")) {
         if (updateType.equalsIgnoreCase("waitforupdates")) {
            // Call to API WaitForUpdatesEx, as equivalent for "WaitForUpdates"
            callWaitForUpdatesEx(null, null);
         } else if (updateType.equalsIgnoreCase("checkforupdates")) {
            // Call to API WaitForUpdatesEx, as equivalent for "CheckForUpdates"
            callWaitForUpdatesEx("60", null);
         } else if (updateType.equalsIgnoreCase("extension")) {
            // New Feature
            callWaitForUpdatesEx("60", "1");
         }
      } else if (extension.equalsIgnoreCase("filterspec")) {
         int taskLength = Integer.parseInt(noofTasks);
         List<ManagedObjectReference> taskArr = createTasks(taskLength);
         // Create a FilterSpec by setting the new property
         // "ReportMissingObjectsInResults"
         List<String> vals = new ArrayList<String>();
         vals.add("info.state");
         vals.add("info.error");
         callCreateFilterSpecEx(taskArr, vals);
      } else if (extension.equalsIgnoreCase("propertycollector")) {
         // Create, use and delete "PropertyCollector"
         callCreatePropertyCollectorEx();
      }
   }

   /*
    * Illustrating how to create, use and destroy additional property collectors
    * This allows multiple modules to create their own property filter and process
    * updates independently.
    * Also applies to get time-sensitive updated being monitored on one collector,
    * while a large updated being monitored by another.
    */
   private static void callCreatePropertyCollectorEx() throws Exception {
      ManagedObjectReference propCol =
            vimPort.createPropertyCollector(propCollectorRef);

      PropertySpec myPropSpec = new PropertySpec();
      myPropSpec.setAll(false);
      myPropSpec.getPathSet().add("name");
      myPropSpec.setType("VirtualMachine");

      List<PropertySpec> pSpecArr = new ArrayList<PropertySpec>();
      pSpecArr.add(myPropSpec);

      ObjectSpec myObjSpec = new ObjectSpec();
      myObjSpec.setObj(rootFolderRef);
      myObjSpec.setSkip(false);
      myObjSpec.getSelectSet().addAll(buildFullTraversal());

      List<ObjectSpec> oSpecArr = new ArrayList<ObjectSpec>(0);
      oSpecArr.add(myObjSpec);

      PropertyFilterSpec pSpec = new PropertyFilterSpec();
      pSpec.getPropSet().addAll(pSpecArr);
      pSpec.getObjectSet().addAll(oSpecArr);

      List<PropertyFilterSpec> pFilterSpecArr =
            new ArrayList<PropertyFilterSpec>();
      pFilterSpecArr.add(pSpec);

      RetrieveOptions rOptions = new RetrieveOptions();

      RetrieveResult retrieveResult =
            vimPort.retrievePropertiesEx(propCol, pFilterSpecArr, rOptions);
      List<ObjectContent> objContentArrayList = retrieveResult.getObjects();
      for (int i = 0; i < objContentArrayList.size(); i++) {
         System.out.println("VM : "
               + objContentArrayList.get(i).getObj().getValue());
      }
      vimPort.destroyPropertyCollector(propCol);
   }


   private static void callCreateFilterSpecEx(
         List<ManagedObjectReference> taskArr, List<String> filterProps)
         throws Exception {
      PropertyFilterSpec spec = new PropertyFilterSpec();
      List<ObjectSpec> objSpecArr = new ArrayList<ObjectSpec>();
      List<PropertySpec> propSpecArr = new ArrayList<PropertySpec>();

      for (int i = 0; i < taskArr.size(); i++) {
         PropertySpec temp = new PropertySpec();
         temp.getPathSet().addAll(filterProps);
         temp.setType("Task");
         propSpecArr.add(temp);
         ObjectSpec temp1 = new ObjectSpec();
         temp1.setObj(taskArr.get(i));
         temp1.getSelectSet().add(null);
         temp1.setSkip(false);
         objSpecArr.add(temp1);
      }
      spec.getPropSet().addAll(propSpecArr);
      spec.getObjectSet().addAll(objSpecArr);

      /* Illustrating the usage of property "ReportMissingObjectsInResults"
       * Property is useful in the scenario when monitoring large number of
       * managed objectsform where some didn't exists by the time filter is created.
       */
      spec.setReportMissingObjectsInResults(true);

      ManagedObjectReference filterSpecRef =
            vimPort.createFilter(propCollectorRef, spec, false);
      UpdateSet updateset = null;
      try {
         updateset = vimPort.waitForUpdates(propCollectorRef, "");
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         throw e;
      }
      List<PropertyFilterUpdate> update = updateset.getFilterSet();
      if (update.get(0).getMissingSet() != null
            && update.get(0).getMissingSet().size() > 0) {
         for (int i = 0; i < update.get(0).getMissingSet().size(); i++) {
            System.out.println("Managed Object Reference "
                  + update.get(0).getMissingSet().get(i).getObj().getValue()
                  + " Not Found");
         }
      }
      System.out.println("FilterSpec created successfully");
      vimPort.destroyPropertyFilter(filterSpecRef);
   }

   private static List<ManagedObjectReference> createTasks(int taskLength)
         throws Exception {
      List<ManagedObjectReference> taskArr =
            new ArrayList<ManagedObjectReference>();

      ManagedObjectReference vmMor = getVMByVMname(vmName);
      if (vmMor == null) {
         System.out.println("Virtual Machine " + vmName + " Not Found");
         return null;
      }
      for (int i = 0; i < taskLength; i++) {
         String tempString = "Temp";
         VirtualMachineConfigSpec spec = new VirtualMachineConfigSpec();
         spec.setAnnotation(tempString);
         taskArr.add(vimPort.reconfigVMTask(vmMor, spec));
         getTaskResultAfterDone(taskArr.get(i));
      }
      return taskArr;
   }

   private static void callWaitForUpdatesEx(String maxWaitSeconds,
         String maxOjectUpdates) throws Exception {
      ManagedObjectReference vmMor = getVMByVMname(vmName);
      if (vmMor == null) {
         System.out.println("Virtual Machine " + vmName + " Not Found");
         return;
      }

      String[][] typeInfo =
            { new String[] { "VirtualMachine", "name", "summary.quickStats",
                  "runtime" } };

      List<PropertySpec> pSpecs = buildPropertySpecArray(typeInfo);
      List<ObjectSpec> oSpecs = new ArrayList<ObjectSpec>();
      boolean oneOnly = vmMor != null;
      ObjectSpec oSpec = new ObjectSpec();
      oSpec.setObj(oneOnly ? vmMor : rootFolderRef);
      oSpec.setSkip(new Boolean(!oneOnly));
      if (!oneOnly) {
         oSpec.getSelectSet().addAll(buildFullTraversal());
      }
      oSpecs.add(oSpec);
      PropertyFilterSpec pSpec = new PropertyFilterSpec();

      pSpec.getPropSet().addAll(pSpecs);
      pSpec.getObjectSet().addAll(oSpecs);
      pSpec.setReportMissingObjectsInResults(false);
      ManagedObjectReference propColl = propCollectorRef;

      ManagedObjectReference propFilter =
            vimPort.createFilter(propColl, pSpec, false);

      WaitOptions wOptions = new WaitOptions();
      if (maxWaitSeconds == null && maxOjectUpdates == null) {
         // DO Nothing
      } else if (maxWaitSeconds != null) {
         wOptions.setMaxWaitSeconds(Integer.parseInt(maxWaitSeconds));
      } else if (maxOjectUpdates != null) {
         wOptions.setMaxObjectUpdates(Integer.parseInt(maxOjectUpdates));
      }

      UpdateSet update =
            vimPort.waitForUpdatesEx(propCollectorRef, null, wOptions);

      if (update.isTruncated() != null && update.isTruncated()) {
         callWaitForUpdatesEx(maxWaitSeconds, maxOjectUpdates);
      } else {
         if (update != null && update.getFilterSet() != null) {
            handleUpdate(update);
         } else {
            System.out.println("No update is present!");
         }
      }
      vimPort.destroyPropertyFilter(propFilter);
   }

   private static void callRetrievePropertiesEx(String maxObjs)
         throws Exception {
      PropertySpec myPropSpec = new PropertySpec();
      myPropSpec.setAll(false);
      myPropSpec.getPathSet().add("name");
      myPropSpec.setType("VirtualMachine");
      List<PropertySpec> pSpecArr = new ArrayList<PropertySpec>(1);
      pSpecArr.add(myPropSpec);

      ObjectSpec myObjSpec = new ObjectSpec();
      myObjSpec.setObj(rootFolderRef);
      myObjSpec.setSkip(false);
      myObjSpec.getSelectSet().addAll(buildFullTraversal());

      List<ObjectSpec> oSpecArr = new ArrayList<ObjectSpec>();
      oSpecArr.add(myObjSpec);

      PropertyFilterSpec pSpec = new PropertyFilterSpec();
      pSpec.getPropSet().addAll(pSpecArr);
      pSpec.getObjectSet().addAll(oSpecArr);

      List<PropertyFilterSpec> pFilterSpecArr =
            new ArrayList<PropertyFilterSpec>();
      pFilterSpecArr.add(pSpec);

      RetrieveOptions rOptions = new RetrieveOptions();
      if (maxObjs != null) {
         rOptions.setMaxObjects(Integer.parseInt(maxObjs));
      }

      RetrieveResult retrieveResult =
            vimPort.retrievePropertiesEx(propCollectorRef, pFilterSpecArr,
                  rOptions);
      List<ObjectContent> objContentArrayList = retrieveResult.getObjects();
      if (retrieveResult.getToken() != null && maxObjs == null) {
         callContinueRetrieveProperties(retrieveResult.getToken());
      }
      for (int i = 0; i < objContentArrayList.size(); i++) {
         System.out.println("VM Managed Object Reference Value: "
               + objContentArrayList.get(i).getObj().getValue());
      }
   }

   private static void callContinueRetrieveProperties(String token)
         throws Exception {
      List<ObjectContent> objContentArr;
      RetrieveResult retrieveResult =
            vimPort.continueRetrievePropertiesEx(propCollectorRef, token);
      objContentArr = retrieveResult.getObjects();
      if (retrieveResult.getToken() != null) {
         callContinueRetrieveProperties(retrieveResult.getToken());
      }
      for (int i = 0; i < objContentArr.size(); i++) {
         System.out.println("VM Managed Object Reference Value : "
               + objContentArr.get(i).getObj().getValue());
      }
   }

   private static void handleUpdate(UpdateSet update) {
      ArrayList<ObjectUpdate> vmUpdates = new ArrayList<ObjectUpdate>();
      ArrayList<ObjectUpdate> hostUpdates = new ArrayList<ObjectUpdate>();
      List<PropertyFilterUpdate> pfus = update.getFilterSet();
      for (int pfui = 0; pfui < pfus.size(); ++pfui) {
         List<ObjectUpdate> ous = pfus.get(pfui).getObjectSet();
         for (int oui = 0; oui < ous.size(); ++oui) {
            if (ous.get(oui).getObj().getType().equals("VirtualMachine")) {
               vmUpdates.add(ous.get(oui));
            } else if (ous.get(oui).getObj().getType().equals("HostSystem")) {
               hostUpdates.add(ous.get(oui));
            }
         }
      }
      if (vmUpdates.size() > 0) {
         System.out.println("Virtual Machine updates:");
         for (Iterator<ObjectUpdate> vmi = vmUpdates.iterator(); vmi.hasNext();) {
            handleObjectUpdate(vmi.next());
         }
      }
      if (hostUpdates.size() > 0) {
         System.out.println("Host updates:");
         for (Iterator<ObjectUpdate> vmi = hostUpdates.iterator(); vmi
               .hasNext();) {
            handleObjectUpdate(vmi.next());
         }
      }
   }

   private static void handleObjectUpdate(ObjectUpdate oUpdate) {
      List<PropertyChange> pc = oUpdate.getChangeSet();
      if (oUpdate.getKind() == ObjectUpdateKind.ENTER) {
         System.out.println(" New Data:");
         handleChanges(pc);
      } else if (oUpdate.getKind() == ObjectUpdateKind.LEAVE) {
         System.out.println(" Removed Data:");
         handleChanges(pc);
      } else if (oUpdate.getKind() == ObjectUpdateKind.MODIFY) {
         System.out.println(" Changed Data:");
         handleChanges(pc);
      }

   }

   private static void handleChanges(List<PropertyChange> changes) {
      for (int pci = 0; pci < changes.size(); ++pci) {
         String name = changes.get(pci).getName();
         Object value = changes.get(pci).getVal();
         PropertyChangeOp op = changes.get(pci).getOp();
         if (op != PropertyChangeOp.REMOVE) {
            System.out.println("  Property Name: " + name);
            if ("summary.quickStats".equals(name)) {
               if (value instanceof VirtualMachineQuickStats) {
                  VirtualMachineQuickStats vmqs =
                        (VirtualMachineQuickStats) value;
                  String cpu =
                        vmqs.getOverallCpuUsage() == null ? "unavailable"
                              : vmqs.getOverallCpuUsage().toString();
                  String memory =
                        vmqs.getHostMemoryUsage() == null ? "unavailable"
                              : vmqs.getHostMemoryUsage().toString();
                  System.out.println("   Guest Status: "
                        + vmqs.getGuestHeartbeatStatus().toString());
                  System.out.println("   CPU Load %: " + cpu);
                  System.out.println("   Memory Load %: " + memory);
               } else if (value instanceof HostListSummaryQuickStats) {
                  HostListSummaryQuickStats hsqs =
                        (HostListSummaryQuickStats) value;
                  String cpu =
                        hsqs.getOverallCpuUsage() == null ? "unavailable"
                              : hsqs.getOverallCpuUsage().toString();
                  String memory =
                        hsqs.getOverallMemoryUsage() == null ? "unavailable"
                              : hsqs.getOverallMemoryUsage().toString();
                  System.out.println("   CPU Load %: " + cpu);
                  System.out.println("   Memory Load %: " + memory);
               }
            } else if ("runtime".equals(name)) {
               if (value instanceof VirtualMachineRuntimeInfo) {
                  VirtualMachineRuntimeInfo vmri =
                        (VirtualMachineRuntimeInfo) value;
                  System.out.println("   Power State: "
                        + vmri.getPowerState().toString());
                  System.out.println("   Connection State: "
                        + vmri.getConnectionState().toString());
                  XMLGregorianCalendar bTime = vmri.getBootTime();
                  if (bTime != null) {
                     System.out.println("   Boot Time: " + bTime.toString());
                  }
                  Long mOverhead = vmri.getMemoryOverhead();
                  if (mOverhead != null) {
                     System.out.println("   Memory Overhead: " + mOverhead);
                  }
               } else if (value instanceof HostRuntimeInfo) {
                  HostRuntimeInfo hri = (HostRuntimeInfo) value;
                  System.out.println("   Connection State: "
                        + hri.getConnectionState().toString());
                  XMLGregorianCalendar bTime = hri.getBootTime();
                  if (bTime != null) {
                     System.out.println("   Boot Time: " + bTime.toString());
                  }
               }
            } else if ("name".equals(name)) {
               System.out.println("   " + value);
            } else {
               System.out.println("   " + value.toString());
            }
         } else {
            System.out.println("Property Name: " + name + " value removed.");
         }
      }
   }

   /*
    * @return An array of SelectionSpec covering VM, Host, Resource pool,
    * Cluster Compute Resource and Datastore.
    */
   private static List<SelectionSpec> buildFullTraversal() {
      // Terminal traversal specs

      // RP -> VM
      TraversalSpec rpToVm = new TraversalSpec();
      rpToVm.setName("rpToVm");
      rpToVm.setType("ResourcePool");
      rpToVm.setPath("vm");
      rpToVm.setSkip(Boolean.FALSE);

      // vApp -> VM
      TraversalSpec vAppToVM = new TraversalSpec();
      vAppToVM.setName("vAppToVM");
      vAppToVM.setType("VirtualApp");
      vAppToVM.setPath("vm");

      // HostSystem -> VM
      TraversalSpec hToVm = new TraversalSpec();
      hToVm.setType("HostSystem");
      hToVm.setPath("vm");
      hToVm.setName("hToVm");
      hToVm.getSelectSet().add(getSelectionSpec("VisitFolders"));
      hToVm.setSkip(Boolean.FALSE);

      // DC -> DS
      TraversalSpec dcToDs = new TraversalSpec();
      dcToDs.setType("Datacenter");
      dcToDs.setPath("datastore");
      dcToDs.setName("dcToDs");
      dcToDs.setSkip(Boolean.FALSE);

      // Recurse through all ResourcePools
      TraversalSpec rpToRp = new TraversalSpec();
      rpToRp.setType("ResourcePool");
      rpToRp.setPath("resourcePool");
      rpToRp.setSkip(Boolean.FALSE);
      rpToRp.setName("rpToRp");
      rpToRp.getSelectSet().add(getSelectionSpec("rpToRp"));

      TraversalSpec crToRp = new TraversalSpec();
      crToRp.setType("ComputeResource");
      crToRp.setPath("resourcePool");
      crToRp.setSkip(Boolean.FALSE);
      crToRp.setName("crToRp");
      crToRp.getSelectSet().add(getSelectionSpec("rpToRp"));

      TraversalSpec crToH = new TraversalSpec();
      crToH.setSkip(Boolean.FALSE);
      crToH.setType("ComputeResource");
      crToH.setPath("host");
      crToH.setName("crToH");

      TraversalSpec dcToHf = new TraversalSpec();
      dcToHf.setSkip(Boolean.FALSE);
      dcToHf.setType("Datacenter");
      dcToHf.setPath("hostFolder");
      dcToHf.setName("dcToHf");
      dcToHf.getSelectSet().add(getSelectionSpec("VisitFolders"));

      TraversalSpec vAppToRp = new TraversalSpec();
      vAppToRp.setName("vAppToRp");
      vAppToRp.setType("VirtualApp");
      vAppToRp.setPath("resourcePool");
      vAppToRp.getSelectSet().add(getSelectionSpec("rpToRp"));

      TraversalSpec dcToVmf = new TraversalSpec();
      dcToVmf.setType("Datacenter");
      dcToVmf.setSkip(Boolean.FALSE);
      dcToVmf.setPath("vmFolder");
      dcToVmf.setName("dcToVmf");
      dcToVmf.getSelectSet().add(getSelectionSpec("VisitFolders"));

      // For Folder -> Folder recursion
      TraversalSpec visitFolders = new TraversalSpec();
      visitFolders.setType("Folder");
      visitFolders.setPath("childEntity");
      visitFolders.setSkip(Boolean.FALSE);
      visitFolders.setName("VisitFolders");
      List<SelectionSpec> sspecarrvf = new ArrayList<SelectionSpec>();
      sspecarrvf.add(getSelectionSpec("crToRp"));
      sspecarrvf.add(getSelectionSpec("crToH"));
      sspecarrvf.add(getSelectionSpec("dcToVmf"));
      sspecarrvf.add(getSelectionSpec("dcToHf"));
      sspecarrvf.add(getSelectionSpec("vAppToRp"));
      sspecarrvf.add(getSelectionSpec("vAppToVM"));
      sspecarrvf.add(getSelectionSpec("dcToDs"));
      sspecarrvf.add(getSelectionSpec("hToVm"));
      sspecarrvf.add(getSelectionSpec("rpToVm"));
      sspecarrvf.add(getSelectionSpec("VisitFolders"));

      visitFolders.getSelectSet().addAll(sspecarrvf);

      List<SelectionSpec> resultspec = new ArrayList<SelectionSpec>();
      resultspec.add(visitFolders);
      resultspec.add(crToRp);
      resultspec.add(crToH);
      resultspec.add(dcToVmf);
      resultspec.add(dcToHf);
      resultspec.add(vAppToRp);
      resultspec.add(vAppToVM);
      resultspec.add(dcToDs);
      resultspec.add(hToVm);
      resultspec.add(rpToVm);
      resultspec.add(rpToRp);

      return resultspec;
   }

   private static SelectionSpec getSelectionSpec(String name) {
      SelectionSpec genericSpec = new SelectionSpec();
      genericSpec.setName(name);
      return genericSpec;
   }

   /**
    * Gets the VM TraversalSpec.
    * 
    * @return the VM TraversalSpec
    */
   private static TraversalSpec getVMTraversalSpec() {
      TraversalSpec vAppToVM = new TraversalSpec();
      vAppToVM.setName("vAppToVM");
      vAppToVM.setType("VirtualApp");
      vAppToVM.setPath("vm");

      TraversalSpec vAppToVApp = new TraversalSpec();
      vAppToVApp.setName("vAppToVApp");
      vAppToVApp.setType("VirtualApp");
      vAppToVApp.setPath("resourcePool");

      SelectionSpec vAppRecursion = new SelectionSpec();
      vAppRecursion.setName("vAppToVApp");

      SelectionSpec vmInVApp = new SelectionSpec();
      vmInVApp.setName("vAppToVM");

      List<SelectionSpec> vAppToVMSS = new ArrayList<SelectionSpec>();
      vAppToVMSS.add(vAppRecursion);
      vAppToVMSS.add(vmInVApp);
      vAppToVApp.getSelectSet().addAll(vAppToVMSS);

      SelectionSpec sSpec = new SelectionSpec();
      sSpec.setName("VisitFolders");

      TraversalSpec dataCenterToVMFolder = new TraversalSpec();
      dataCenterToVMFolder.setName("DataCenterToVMFolder");
      dataCenterToVMFolder.setType("Datacenter");
      dataCenterToVMFolder.setPath("vmFolder");
      dataCenterToVMFolder.setSkip(false);
      dataCenterToVMFolder.getSelectSet().add(sSpec);

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
    * Gets VM by Name.
    * 
    * @param vmname
    *           the VMName
    * @return ManagedObjectReference of the VM
    */
   private static ManagedObjectReference getVMByVMname(String vmname) {
      ManagedObjectReference retVmRef = null;
      try {
         TraversalSpec tSpec = getVMTraversalSpec();

         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add("name");
         propertySpec.setType("VirtualMachine");

         ObjectSpec objectSpec = new ObjectSpec();
         objectSpec.setObj(rootFolderRef);
         objectSpec.setSkip(Boolean.TRUE);
         objectSpec.getSelectSet().add(tSpec);

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
               if (vmnm != null && vmnm.equals(vmname)) {
                  retVmRef = mr;
                  break;
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return retVmRef;
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

   private static List<PropertySpec> buildPropertySpecArray(String[][] typeinfo) {
      // Eliminate duplicates
      HashMap<String, Set<String>> tInfo = new HashMap<String, Set<String>>();
      for (int ti = 0; ti < typeinfo.length; ++ti) {
         Set<String> props = tInfo.get(typeinfo[ti][0]);
         if (props == null) {
            props = new HashSet<String>();
            tInfo.put(typeinfo[ti][0], props);
         }
         boolean typeSkipped = false;
         for (int pi = 0; pi < typeinfo[ti].length; ++pi) {
            String prop = typeinfo[ti][pi];
            if (typeSkipped) {
               props.add(prop);
            } else {
               typeSkipped = true;
            }
         }
      }
      // Create PropertySpecs
      ArrayList<PropertySpec> pSpecs = new ArrayList<PropertySpec>();
      for (Iterator<String> ki = tInfo.keySet().iterator(); ki.hasNext();) {
         String type = ki.next();
         PropertySpec pSpec = new PropertySpec();
         Set<?> props = tInfo.get(type);
         pSpec.setType(type);
         pSpec.setAll(props.isEmpty() ? Boolean.TRUE : Boolean.FALSE);
         //pSpec.setPathSet(new String[props.size()]);
         int index = 0;
         for (Iterator<?> pi = props.iterator(); pi.hasNext();) {
            String prop = (String) pi.next();
            pSpec.getPathSet().add(index++, prop);
         }
         pSpecs.add(pSpec);
      }
      List<PropertySpec> res = new ArrayList<PropertySpec>();
      res.addAll(pSpecs);
      return res;
   }

   /**
    * This method returns a boolean value specifying whether the Task is
    * succeeded or failed.
    * 
    * @param task
    *           ManagedObjectReference representing the Task.
    * 
    * @return boolean value representing the Task result.
    * @throws InvalidCollectorVersionFaultMsg
    * @throws RuntimeFaultFaultMsg
    * @throws InvalidPropertyFaultMsg
    */
   private static boolean getTaskResultAfterDone(ManagedObjectReference task)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg,
         InvalidCollectorVersionFaultMsg {

      boolean retVal = false;

      // info has a property - state for state of the task
      Object[] result =
            waitForValues(task, new String[] { "info.state", "info.error" },
                  new String[] { "state" }, new Object[][] { new Object[] {
                        TaskInfoState.SUCCESS, TaskInfoState.ERROR } });

      if (result[0].equals(TaskInfoState.SUCCESS)) {
         retVal = true;
      }
      if (result[1] instanceof LocalizedMethodFault) {
         throw new RuntimeException(
               ((LocalizedMethodFault) result[1]).getLocalizedMessage());
      }
      return retVal;
   }

   /**
    * Handle Updates for a single object. waits till expected values of
    * properties to check are reached Destroys the ObjectFilter when done.
    * 
    * @param objmor
    *           MOR of the Object to wait for</param>
    * @param filterProps
    *           Properties list to filter
    * @param endWaitProps
    *           Properties list to check for expected values these be properties
    *           of a property in the filter properties list
    * @param expectedVals
    *           values for properties to end the wait
    * @return true indicating expected values were met, and false otherwise
    * @throws RuntimeFaultFaultMsg
    * @throws InvalidPropertyFaultMsg
    * @throws InvalidCollectorVersionFaultMsg
    */
   private static Object[] waitForValues(ManagedObjectReference objmor,
         String[] filterProps, String[] endWaitProps, Object[][] expectedVals)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg,
         InvalidCollectorVersionFaultMsg {
      // version string is initially null
      String version = "";
      Object[] endVals = new Object[endWaitProps.length];
      Object[] filterVals = new Object[filterProps.length];

      PropertyFilterSpec spec = new PropertyFilterSpec();
      ObjectSpec oSpec = new ObjectSpec();
      oSpec.setObj(objmor);
      oSpec.setSkip(Boolean.FALSE);
      spec.getObjectSet().add(oSpec);

      PropertySpec pSpec = new PropertySpec();
      pSpec.getPathSet().addAll(Arrays.asList(filterProps));
      pSpec.setType(objmor.getType());
      spec.getPropSet().add(pSpec);

      ManagedObjectReference filterSpecRef =
            vimPort.createFilter(serviceContent.getPropertyCollector(), spec,
                  true);

      boolean reached = false;

      UpdateSet updateset = null;
      List<PropertyFilterUpdate> filtupary = null;
      List<ObjectUpdate> objupary = null;
      List<PropertyChange> propchgary = null;
      while (!reached) {
         updateset =
               vimPort.waitForUpdates(serviceContent.getPropertyCollector(),
                     version);
         if (updateset == null || updateset.getFilterSet() == null) {
            continue;
         }
         version = updateset.getVersion();

         // Make this code more general purpose when PropCol changes later.
         filtupary = updateset.getFilterSet();

         for (PropertyFilterUpdate filtup : filtupary) {
            objupary = filtup.getObjectSet();
            for (ObjectUpdate objup : objupary) {
               // TODO: Handle all "kind"s of updates.
               if (objup.getKind() == ObjectUpdateKind.MODIFY
                     || objup.getKind() == ObjectUpdateKind.ENTER
                     || objup.getKind() == ObjectUpdateKind.LEAVE) {
                  propchgary = objup.getChangeSet();
                  for (PropertyChange propchg : propchgary) {
                     updateValues(endWaitProps, endVals, propchg);
                     updateValues(filterProps, filterVals, propchg);
                  }
               }
            }
         }

         Object expctdval = null;
         // Check if the expected values have been reached and exit the loop
         // if done.
         // Also exit the WaitForUpdates loop if this is the case.
         for (int chgi = 0; chgi < endVals.length && !reached; chgi++) {
            for (int vali = 0; vali < expectedVals[chgi].length && !reached; vali++) {
               expctdval = expectedVals[chgi][vali];

               reached = expctdval.equals(endVals[chgi]) || reached;
            }
         }
      }

      // Destroy the filter when we are done.
      vimPort.destroyPropertyFilter(filterSpecRef);
      return filterVals;
   }

   private static void updateValues(String[] props, Object[] vals,
         PropertyChange propchg) {
      for (int findi = 0; findi < props.length; findi++) {
         if (propchg.getName().lastIndexOf(props[findi]) >= 0) {
            if (propchg.getOp() == PropertyChangeOp.REMOVE) {
               vals[findi] = "";
            } else {
               vals[findi] = propchg.getVal();
            }
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
      // To Be Implemented
      System.out
            .println("\nThis sample illustrates the property collector features"
                  + " added in version 4.1");
      System.out.println("\nParameters:");
      System.out.println("url            [required] : url of the web service.");
      System.out
            .println("username       [required] : username for the authentication");
      System.out
            .println("password       [required] : password for the authentication");
      System.out
            .println("extension      [required] : Extension to be demonstrated ");
      System.out
            .println("                            "
                  + "[retrieveproperties | updates | filterspec | propertycollector]");
      System.out
            .println("vmname         [optional] : Name of the virtual machine");
      System.out
            .println("maxobjects     [optional] : The maximum number of ObjectContent data objects");
      System.out
            .println("                            that should be returned in a single result");
      System.out
            .println("updatetype     [optional] : waitforupdates | checkforupdates| extension");
      System.out
            .println("nooftasks      [optional] : Number of tasks to be created");
      System.out.println("\nCommand:");
      System.out.println("\nRetrieve Properties Extension");
      System.out
            .println("run.bat com.vmware.general.PropertyCollector --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out
            .println("--extension retrieveproperties --maxobjects  [maxobjects]");
      System.out.println("\nUpdates Extension");
      System.out
            .println("run.bat com.vmware.general.PropertyCollector --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--extension updates --vmname [vm name]");
      System.out
            .println("--updatetype  [waitforupdates | checkforupdates| extension]");
      System.out.println("\nFilter Spec Extension");
      System.out
            .println("run.bat com.vmware.general.PropertyCollector --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--extension filterspec --vmname [vm name]");
      System.out.println("--noofTasks  [Number of tasks to be created]");
      System.out.println("\nProperty Collector Extension");
      System.out
            .println("run.bat com.vmware.general.PropertyCollector --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println(" --extension propertycollector");
   }

   /* End Sample functional code */

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         if (help) {
            printUsage();
            return;
         }
         connect();
         getInputParameters(args);
         doOperations();
      } catch (IllegalArgumentException iae) {
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
