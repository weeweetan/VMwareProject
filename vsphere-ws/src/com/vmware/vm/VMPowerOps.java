package com.vmware.vm;

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
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;


/**
 * <pre>
 * VMPowerOps
 * 
 * Demonstrates VirtualMachine Power operations
 * 
 * <b>Parameters:</b>
 * url              [required] : url of the web service
 * username         [required] : username for the authentication
 * password         [required] : password for the authentication
 * operation        [required] : type of the operation
 *                               [poweron | poweroff | reset | suspend |
 *                                reboot | shutdown | standby]
 * datacentername   [optional] : name of the datacenter
 * guestid          [optional] : guest id of the vm
 * hostname         [optional] : name of the host
 * vmname           [optional] : name of the virtual machine
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.vm.VMPowerOps --url [URLString] --username [User] --password [Password]
 * --operation [Operation] --datacenter [DatacenterName]--guestid [GuestId] --hostname [HostName]
 * --vmname [VMName]
 * </pre>
 */

public class VMPowerOps {

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
   private static final String SVC_INST_NAME = "ServiceInstance";
   private static final ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();
   private static VimService vimService = null;
   private static VimPortType vimPort = null;
   private static ServiceContent serviceContent = null;


   /*
      Connection input parameters
    */
   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
   private static String vmName = null;
   private static String operation = null;
   private static String datacenter = null;
   private static String guestId = null;
   private static String host = null;
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
            vmName = val;
         } else if (param.equalsIgnoreCase("--operation")
               && !val.startsWith("--") && !val.isEmpty()) {
            operation = val;
         } else if (param.equalsIgnoreCase("--datacentername")
               && !val.startsWith("--") && !val.isEmpty()) {
            datacenter = val;
         } else if (param.equalsIgnoreCase("--guestid")
               && !val.startsWith("--") && !val.isEmpty()) {
            guestId = val;
         } else if (param.equalsIgnoreCase("--hostname")
               && !val.startsWith("--") && !val.isEmpty()) {
            host = val;
         }
         val = "";
         ai += 2;
      }
      if (operation == null) {
         throw new IllegalArgumentException("Expected --operation argument.");
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

   private static void validate() throws IllegalArgumentException {
      if (!(operation.equalsIgnoreCase("poweron"))
            && !(operation.equalsIgnoreCase("poweroff"))
            && !(operation.equalsIgnoreCase("reset"))
            && !(operation.equalsIgnoreCase("standby"))
            && !(operation.equalsIgnoreCase("shutdown"))
            && !(operation.equalsIgnoreCase("reboot"))
            && !(operation.equalsIgnoreCase("suspend"))) {

         System.out.println("Invalid Operation name ' " + operation
               + "' valid operations are poweron, standby,"
               + " poweroff, standby, reboot, shutdown, suspend");
         throw new IllegalArgumentException("Invalid Operation Type Or Name");
      }
   }

   /**
    * Returns all the MOREFs of the specified type that are present under the
    * container
    * 
    * @param folder
    *           {@link ManagedObjectReference} of the container to begin the
    *           search from
    * @param morefType
    *           Type of the managed entity that needs to be searched
    * 
    * @return Map of name and MOREF of the managed objects present. If none
    *         exist then empty Map is returned
    * 
    * @throws InvalidPropertyFaultMsg
    * @throws RuntimeFaultFaultMsg
    */
   private static Map<String, ManagedObjectReference> getMOREFsInContainerByType(
         ManagedObjectReference folder, String morefType)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
      String PROP_ME_NAME = "name";
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
   
      RetrieveResult rslts =
            vimPort.retrievePropertiesEx(serviceContent.getPropertyCollector(),
                  propertyFilterSpecs, new RetrieveOptions());
      List<ObjectContent> listobjcontent = new ArrayList<ObjectContent>();
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
               vimPort.continueRetrievePropertiesEx(
                     serviceContent.getPropertyCollector(), token);
         token = null;
         if (rslts != null) {
            token = rslts.getToken();
            if (rslts.getObjects() != null && !rslts.getObjects().isEmpty()) {
               listobjcontent.addAll(rslts.getObjects());
            }
         }
      }
      for (ObjectContent oc : listobjcontent) {
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
      return tgtMoref;
   }

   /**
    * Method to retrieve properties of list of {@link ManagedObjectReference}
    * 
    * @param entityMors
    *           List of {@link ManagedObjectReference} for which the properties
    *           needs to be retrieved
    * @param props
    *           Common properties that need to be retrieved for all the
    *           {@link ManagedObjectReference} passed
    * @return Map of {@link ManagedObjectReference} and their corresponding name
    *         value pair of properties
    * @throws InvalidPropertyFaultMsg
    * @throws RuntimeFaultFaultMsg
    */
   private static Map<ManagedObjectReference, Map<String, Object>> getEntityProps(
         List<ManagedObjectReference> entityMors, String[] props)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
   
      Map<ManagedObjectReference, Map<String, Object>> retVal =
            new HashMap<ManagedObjectReference, Map<String, Object>>();
      // Create PropertyFilterSpec
      PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
      Map<String, String> typesCovered = new HashMap<String, String>();
   
      for (ManagedObjectReference mor : entityMors) {
         if (!typesCovered.containsKey(mor.getType())) {
            // Create Property Spec
            PropertySpec propertySpec = new PropertySpec();
            propertySpec.setAll(Boolean.FALSE);
            propertySpec.setType(mor.getType());
            propertySpec.getPathSet().addAll(Arrays.asList(props));
            propertyFilterSpec.getPropSet().add(propertySpec);
            typesCovered.put(mor.getType(), "");
         }
         // Now create Object Spec
         ObjectSpec objectSpec = new ObjectSpec();
         objectSpec.setObj(mor);
         propertyFilterSpec.getObjectSet().add(objectSpec);
      }
      List<PropertyFilterSpec> propertyFilterSpecs =
            new ArrayList<PropertyFilterSpec>();
      propertyFilterSpecs.add(propertyFilterSpec);
   
      RetrieveResult rslts =
            vimPort.retrievePropertiesEx(serviceContent.getPropertyCollector(),
                  propertyFilterSpecs, new RetrieveOptions());
      List<ObjectContent> listobjcontent = new ArrayList<ObjectContent>();
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
               vimPort.continueRetrievePropertiesEx(
                     serviceContent.getPropertyCollector(), token);
         token = null;
         if (rslts != null) {
            token = rslts.getToken();
            if (rslts.getObjects() != null && !rslts.getObjects().isEmpty()) {
               listobjcontent.addAll(rslts.getObjects());
            }
         }
      }
      for (ObjectContent oc : listobjcontent) {
         List<DynamicProperty> dps = oc.getPropSet();
         Map<String, Object> propMap = new HashMap<String, Object>();
         if (dps != null) {
            for (DynamicProperty dp : dps) {
               propMap.put(dp.getName(), dp.getVal());
            }
         }
         retVal.put(oc.getObj(), propMap);
      }
      return retVal;
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
    *           MOR of the Object to wait for
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

   private static Map<String, ManagedObjectReference> getVms() throws Exception {
      Map<String, ManagedObjectReference> vmList =
            new HashMap<String, ManagedObjectReference>();

      // Start from the root folder
      ManagedObjectReference container = serviceContent.getRootFolder();
      if (datacenter != null) {
         ManagedObjectReference dcMoref =
               getMOREFsInContainerByType(container, "Datacenter").get(
                     datacenter);
         if (dcMoref == null) {
            System.out.println("No datacenter by the name " + datacenter
                  + " found!");
            return vmList;
         }
         container = dcMoref;
      }

      if (host != null) {
         ManagedObjectReference hostMoref =
               getMOREFsInContainerByType(container, "HostSystem").get(host);
         if (hostMoref == null) {
            System.out.println("No host by the name " + host + " found!");
            return vmList;
         }
         container = hostMoref;
      }

      Map<String, ManagedObjectReference> vms =
            getMOREFsInContainerByType(container, "VirtualMachine");

      if (vmName != null) {
         if (vms.containsKey(vmName)) {
            vmList.put(vmName, vms.get(vmName));
         }
         return vmList;
      }

      if (guestId != null) {
         Map<ManagedObjectReference, Map<String, Object>> vmListProp =
               getEntityProps(
                     new ArrayList<ManagedObjectReference>(vms.values()),
                     new String[] { "summary.config.guestId", "name" });
         for (ManagedObjectReference vmRef : vmListProp.keySet()) {
            if (guestId.equalsIgnoreCase((String) vmListProp.get(vmRef).get(
                  "summary.config.guestId"))) {
               vmList.put((String) vmListProp.get(vmRef).get("name"), vmRef);
            }
         }
         return vmList;
      }
      // If no filters are there then just the container based containment is used.
      vmList = vms;

      return vmList;
   }

   private static void runOperation() throws Exception {
      Map<String, ManagedObjectReference> vmMap = getVms();
      if (vmMap == null || vmMap.isEmpty()) {
         System.out.println("No Virtual Machine found matching "
               + "the specified criteria");
         return;
      } else {
         if (operation.equalsIgnoreCase("poweron")) {
            powerOnVM(vmMap);
         } else if (operation.equalsIgnoreCase("poweroff")) {
            powerOffVM(vmMap);
         } else if (operation.equalsIgnoreCase("reset")) {
            resetVM(vmMap);
         } else if (operation.equalsIgnoreCase("suspend")) {
            suspendVM(vmMap);
         } else if (operation.equalsIgnoreCase("reboot")) {
            rebootVM(vmMap);
         } else if (operation.equalsIgnoreCase("shutdown")) {
            shutdownVM(vmMap);
         } else if (operation.equalsIgnoreCase("standby")) {
            standbyVM(vmMap);
         }
      }
   }

   private static void powerOnVM(Map<String, ManagedObjectReference> vmMap) {
      for (String vmname : vmMap.keySet()) {
         ManagedObjectReference vmMor = vmMap.get(vmname);
         try {
            System.out.println("Powering on virtual machine : " + vmname + "["
                  + vmMor.getValue() + "]");
            ManagedObjectReference taskmor = vimPort.powerOnVMTask(vmMor, null);
            if (getTaskResultAfterDone(taskmor)) {
               System.out.println(vmname + "[" + vmMor.getValue()
                     + "] powered on successfully");
            }
         } catch (Exception e) {
            System.out.println("Unable to poweron vm : " + vmname + "["
                  + vmMor.getValue() + "]");
            System.err.println("Reason :" + e.getLocalizedMessage());
         }
      }
   }

   private static void powerOffVM(Map<String, ManagedObjectReference> vmMap) {
      for (String vmname : vmMap.keySet()) {
         ManagedObjectReference vmMor = vmMap.get(vmname);
         try {
            System.out.println("Powering off virtual machine : " + vmname + "["
                  + vmMor.getValue() + "]");
            ManagedObjectReference taskmor = vimPort.powerOffVMTask(vmMor);
            if (getTaskResultAfterDone(taskmor)) {
               System.out.println(vmname + "[" + vmMor.getValue()
                     + "] powered off successfully");
            }
         } catch (Exception e) {
            System.out.println("Unable to poweroff vm : " + vmname + "["
                  + vmMor.getValue() + "]");
            System.err.println("Reason :" + e.getLocalizedMessage());
         }
      }
   }

   private static void resetVM(Map<String, ManagedObjectReference> vmMap) {
      for (String vmname : vmMap.keySet()) {
         ManagedObjectReference vmMor = vmMap.get(vmname);
         try {
            System.out.println("Reseting virtual machine : " + vmname + "["
                  + vmMor.getValue() + "]");
            ManagedObjectReference taskmor = vimPort.resetVMTask(vmMor);
            if (getTaskResultAfterDone(taskmor)) {
               System.out.println(vmname + "[" + vmMor.getValue()
                     + "] reset successfully");
            }
         } catch (Exception e) {
            System.out.println("Unable to reset vm : " + vmname + "["
                  + vmMor.getValue() + "]");
            System.err.println("Reason :" + e.getLocalizedMessage());
         }
      }
   }

   private static void suspendVM(Map<String, ManagedObjectReference> vmMap) {
      for (String vmname : vmMap.keySet()) {
         ManagedObjectReference vmMor = vmMap.get(vmname);
         try {
            System.out.println("Suspending virtual machine : " + vmname + "["
                  + vmMor.getValue() + "]");
            ManagedObjectReference taskmor = vimPort.suspendVMTask(vmMor);
            if (getTaskResultAfterDone(taskmor)) {
               System.out.println(vmname + "[" + vmMor.getValue()
                     + "] suspended successfully");
            }
         } catch (Exception e) {
            System.out.println("Unable to suspend vm : " + vmname + "["
                  + vmMor.getValue() + "]");
            System.err.println("Reason :" + e.getLocalizedMessage());
         }
      }
   }

   private static void rebootVM(Map<String, ManagedObjectReference> vmMap) {
      for (String vmname : vmMap.keySet()) {
         ManagedObjectReference vmMor = vmMap.get(vmname);
         try {
            System.out.println("Rebooting guest os in virtual machine : "
                  + vmname + "[" + vmMor.getValue() + "]");
            vimPort.rebootGuest(vmMor);
            System.out.println("Guest os in vm : " + vmname + "["
                  + vmMor.getValue() + "]" + " rebooted");
         } catch (Exception e) {
            System.out.println("Unable to reboot guest os in vm : " + vmname
                  + "[" + vmMor.getValue() + "]");
            System.err.println("Reason :" + e.getLocalizedMessage());
         }
      }
   }

   private static void shutdownVM(Map<String, ManagedObjectReference> vmMap) {
      for (String vmname : vmMap.keySet()) {
         ManagedObjectReference vmMor = vmMap.get(vmname);
         try {
            System.out.println("Shutting down guest os in virtual machine : "
                  + vmname + "[" + vmMor.getValue() + "]");
            vimPort.shutdownGuest(vmMor);
            System.out.println("Guest os in vm : " + vmname + "["
                  + vmMor.getValue() + "]" + " shutdown");
         } catch (Exception e) {
            System.out.println("Unable to shutdown guest os in vm : " + vmname
                  + "[" + vmMor.getValue() + "]");
            System.err.println("Reason :" + e.getLocalizedMessage());
         }
      }
   }

   private static void standbyVM(Map<String, ManagedObjectReference> vmMap) {
      for (String vmname : vmMap.keySet()) {
         ManagedObjectReference vmMor = vmMap.get(vmname);
         try {
            System.out.println("Putting the guest os in virtual machine : "
                  + vmname + "[" + vmMor.getValue() + "] in standby mode");
            vimPort.standbyGuest(vmMor);
            System.out.println("Guest os in vm : " + vmname + "["
                  + vmMor.getValue() + "]" + " in standby mode");
         } catch (Exception e) {
            System.out.println("Unable to put the guest os in vm : " + vmname
                  + "[" + vmMor.getValue() + "] to standby mode");
            System.err.println("Reason :" + e.getLocalizedMessage());
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
      System.out.println("This sample Performs power ops(on|off etc.) "
            + "operations on the virtual machines");
      System.out.println("\nParameters:");
      System.out
            .println("url              [required] : url of the web service.");
      System.out
            .println("username         [required] : username for the authentication");
      System.out
            .println("password         [required] : password for the authentication");
      System.out
            .println("vmname           [optional] : name of the virtual machine");
      System.out.println("operation        [required] : type of the operation");
      System.out
            .println("                              [poweron | poweroff | reset | suspend |");
      System.out
            .println("                               reboot | shutdown | standby]");
      System.out.println("foldername       [optional] : name of the folder");
      System.out
            .println("datacentername   [optional] : name of the datacenter");
      System.out
            .println("respoolname      [optional] : name of the resource pool");
      System.out.println("ipaddress        [optional] : ipaddress of the vm");
      System.out.println("guestid          [optional] : guest id of the vm");
      System.out.println("hostname         [optional] : name of the host");
      System.out.println("\nCommand:");
      System.out
            .println("run.bat com.vmware.vm.VMPowerOps "
                  + "--url [URLString] --username [User] --password [Password] --vmname [VMName] "
                  + "--operation [Operation] --folder [FolderName] --datacenter [DatacenterName] "
                  + "--pool [ResourcePool] --ipaddress [IpAddress] --guestid [GuestId] --host [HostName]");
   }

   /**
    * @param args
    */
   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         getInputParameters(args);
         if (help) {
            printUsage();
            return;
         }
         validate();
         connect();
         runOperation();
      } catch (IllegalArgumentException iae) {
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
