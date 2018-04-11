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

import com.vmware.vim25.ArrayOfManagedObjectReference;
import com.vmware.vim25.ArrayOfVirtualDevice;
import com.vmware.vim25.DatastoreSummary;
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
import com.vmware.vim25.ResourceAllocationInfo;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.SharesInfo;
import com.vmware.vim25.SharesLevel;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VirtualCdrom;
import com.vmware.vim25.VirtualCdromRemoteAtapiBackingInfo;
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDeviceConfigSpec;
import com.vmware.vim25.VirtualDeviceConfigSpecFileOperation;
import com.vmware.vim25.VirtualDeviceConfigSpecOperation;
import com.vmware.vim25.VirtualDisk;
import com.vmware.vim25.VirtualDiskFlatVer2BackingInfo;
import com.vmware.vim25.VirtualEthernetCard;
import com.vmware.vim25.VirtualEthernetCardNetworkBackingInfo;
import com.vmware.vim25.VirtualIDEController;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualPCNet32;
import com.vmware.vim25.VirtualSCSIController;

/**
 * <pre>
 * VMReconfig
 * 
 * Reconfigures a virtual machine, which include reconfiguring the disk size, disk mode, etc.
 * 
 * <b>Parameters:</b>
 * url            [required] : url of the web service
 * username       [required] : username for the authentication
 * password       [required] : password for the authentication
 * vmname         [required] : name of the virtual machine
 * device         [required] : cpu|memory|disk|cd|nic
 * operation      [required] : add|remove|update
 * update operation is only possible for cpu and memory, add|remove are not allowed for cpu and memory
 * value          [required] : high|low|normal|numeric value, label of device when removing
 * disksize       [optional] : Size of virtual disk
 * diskmode       [optional] : persistent|independent_persistent,independent_nonpersistent
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.vm.VMReconfig --url [URLString] --username [User] --password [Password]
 * --vmname [VMName] --operation [Operation] --device [Devicetype] --value [Value]
 * --disksize [Virtualdisksize] --diskmode [VDiskmode]
 * </pre>
 */
public class VMReconfig {

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
   private static ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();
   private static ManagedObjectReference virtualMachine = null;

   /*
      Connection input parameters
    */
   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
   private static String vmName = null;
   private static String operation = null;
   private static String device = null;
   private static String value = null;
   private static String disksize = null;
   private static String diskmode = null;
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
         } else if (param.equalsIgnoreCase("--device") && !val.startsWith("--")
               && !val.isEmpty()) {
            device = val;
         } else if (param.equalsIgnoreCase("--value") && !val.startsWith("--")
               && !val.isEmpty()) {
            value = val;
         } else if (param.equalsIgnoreCase("--disksize")
               && !val.startsWith("--") && !val.isEmpty()) {
            disksize = val;
         } else if (param.equalsIgnoreCase("--diskmode")
               && !val.startsWith("--") && !val.isEmpty()) {
            diskmode = val;
         }
         val = "";
         ai += 2;
      }
      if (vmName == null || operation == null || value == null) {
         throw new IllegalArgumentException("Expected --vmname,"
               + " --operation or --value arguments.");
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
    * Gets the controller key and the next available free unit number on the
    * SCSI controller
    * 
    * @param vmMor
    * @return
    * @throws InvalidPropertyFaultMsg
    * @throws RuntimeFaultFaultMsg
    */
   private static List<Integer> getControllerKey(ManagedObjectReference vmMor)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
      List<Integer> retVal = new ArrayList<Integer>();
   
      List<VirtualDevice> listvd =
            ((ArrayOfVirtualDevice) getEntityProps(vmMor,
                  new String[] { "config.hardware.device" }).get(
                  "config.hardware.device")).getVirtualDevice();
   
      Map<Integer, VirtualDevice> deviceMap =
            new HashMap<Integer, VirtualDevice>();
      for (VirtualDevice virtualDevice : listvd) {
         deviceMap.put(virtualDevice.getKey(), virtualDevice);
      }
      boolean found = false;
      for (VirtualDevice virtualDevice : listvd) {
         if (virtualDevice instanceof VirtualSCSIController) {
            VirtualSCSIController vscsic =
                  (VirtualSCSIController) virtualDevice;
            int[] slots = new int[16];
            slots[7] = 1;
            List<Integer> devicelist = vscsic.getDevice();
            for (Integer deviceKey : devicelist) {
               if (deviceMap.get(deviceKey).getUnitNumber() != null) {
                  slots[deviceMap.get(deviceKey).getUnitNumber()] = 1;
               }
            }
            for (int i = 0; i < slots.length; i++) {
               if (slots[i] != 1) {
                  retVal.add(vscsic.getKey());
                  retVal.add(i);
                  found = true;
                  break;
               }
            }
            if (found) {
               break;
            }
         }
      }
   
      if (!found) {
         throw new RuntimeException(
               "The SCSI controller on the vm has maxed out its "
                     + "capacity. Please add an additional SCSI controller");
      }
      return retVal;
   }

   /**
    * Method to retrieve properties of a {@link ManagedObjectReference}
    * 
    * @param entityMor
    *           {@link ManagedObjectReference} of the entity
    * @param props
    *           Array of properties to be looked up
    * @return Map of the property name and its corresponding value
    * 
    * @throws InvalidPropertyFaultMsg
    *            If a property does not exist
    * @throws RuntimeFaultFaultMsg
    */
   private static Map<String, Object> getEntityProps(
         ManagedObjectReference entityMor, String[] props)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
   
      HashMap<String, Object> retVal = new HashMap<String, Object>();
   
      // Create Property Spec
      PropertySpec propertySpec = new PropertySpec();
      propertySpec.setAll(Boolean.FALSE);
      propertySpec.setType(entityMor.getType());
      propertySpec.getPathSet().addAll(Arrays.asList(props));
   
      // Now create Object Spec
      ObjectSpec objectSpec = new ObjectSpec();
      objectSpec.setObj(entityMor);
   
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
         List<DynamicProperty> dps = oc.getPropSet();
         if (dps != null) {
            for (DynamicProperty dp : dps) {
               retVal.put(dp.getName(), dp.getVal());
            }
         }
      }
      return retVal;
   }

   private static boolean customValidation() throws Exception {
      boolean flag = true;
      if (device.equalsIgnoreCase("disk")) {
         if (operation.equalsIgnoreCase("add")) {
            if ((disksize == null) || (diskmode == null)) {
               System.out.println("For add disk operation, disksize "
                     + "and diskmode are the Mandatory options");
               flag = false;
            }
            if (disksize != null && Integer.parseInt(disksize) <= 0) {
               System.out.println("Disksize must be a greater than zero");
               flag = false;
            }
         }
         if (operation.equalsIgnoreCase("remove")) {
            if (value == null) {
               System.out
                     .println("Please specify a label in value field to remove the disk");
            }
         }
      }
      if (device.equalsIgnoreCase("nic")) {
         if (operation == null) {
            System.out.println("For add nic operation is the Mandatory option");
            flag = false;
         }
      }
      if (device.equalsIgnoreCase("cd")) {
         if (operation == null) {
            System.out.println("For add cd operation is the Mandatory options");
            flag = false;
         }
      }
      if (operation != null) {
         if (operation.equalsIgnoreCase("add")
               || operation.equalsIgnoreCase("remove")
               || operation.equalsIgnoreCase("update")) {
            if (device.equals("cpu") || device.equals("memory")) {
               if (operation != null && operation.equals("update")) {
               } else {
                  System.out
                        .println("Invalid operation specified for device cpu or memory");
                  flag = false;
               }
            }
         } else {
            System.out
                  .println("Operation must be either add, remove or update");
            flag = false;
         }
      }
      return flag;
   }

   private static ResourceAllocationInfo getShares() {
      ResourceAllocationInfo raInfo = new ResourceAllocationInfo();
      SharesInfo sharesInfo = new SharesInfo();
      if (value.equalsIgnoreCase(SharesLevel.HIGH.toString())) {
         sharesInfo.setLevel(SharesLevel.HIGH);
      } else if (value.equalsIgnoreCase(SharesLevel.NORMAL.toString())) {
         sharesInfo.setLevel(SharesLevel.NORMAL);
      } else if (value.equalsIgnoreCase(SharesLevel.LOW.toString())) {
         sharesInfo.setLevel(SharesLevel.LOW);
      } else {
         sharesInfo.setLevel(SharesLevel.CUSTOM);
         sharesInfo.setShares(Integer.parseInt(value));
      }
      raInfo.setShares(sharesInfo);
      return raInfo;
   }

   private static String getDatastoreNameWithFreeSpace(int minFreeSpace)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
      String dsName = null;
      List<ManagedObjectReference> datastores =
            ((ArrayOfManagedObjectReference) getEntityProps(virtualMachine,
                  new String[] { "datastore" }).get("datastore"))
                  .getManagedObjectReference();
      for (ManagedObjectReference datastore : datastores) {
         DatastoreSummary ds =
               (DatastoreSummary) getEntityProps(datastore,
                     new String[] { "summary" }).get("summary");
         if (ds.getFreeSpace() > minFreeSpace) {
            dsName = ds.getName();
            break;
         }
      }
      return dsName;
   }

   private static VirtualDeviceConfigSpec getDiskDeviceConfigSpec()
         throws Exception {
      String ops = operation;
      VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec();

      if (ops.equalsIgnoreCase("Add")) {
         VirtualDisk disk = new VirtualDisk();
         VirtualDiskFlatVer2BackingInfo diskfileBacking =
               new VirtualDiskFlatVer2BackingInfo();
         String dsName =
               getDatastoreNameWithFreeSpace(Integer.parseInt(disksize));

         int ckey = 0;
         int unitNumber = 0;
         List<Integer> getControllerKeyReturnArr =
               getControllerKey(virtualMachine);
         if (!getControllerKeyReturnArr.isEmpty()) {
            ckey = getControllerKeyReturnArr.get(0);
            unitNumber = getControllerKeyReturnArr.get(1);
         }
         String fileName = "[" + dsName + "] " + vmName + "/" + value + ".vmdk";
         diskfileBacking.setFileName(fileName);
         diskfileBacking.setDiskMode(diskmode);

         disk.setControllerKey(ckey);
         disk.setUnitNumber(unitNumber);
         disk.setBacking(diskfileBacking);
         int size = 1024 * (Integer.parseInt(disksize));
         disk.setCapacityInKB(size);
         disk.setKey(-1);

         diskSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);
         diskSpec.setFileOperation(VirtualDeviceConfigSpecFileOperation.CREATE);
         diskSpec.setDevice(disk);
      } else if (ops.equalsIgnoreCase("Remove")) {
         VirtualDisk disk = null;
         List<VirtualDevice> deviceList =
               ((ArrayOfVirtualDevice) getEntityProps(virtualMachine,
                     new String[] { "config.hardware.device" }).get(
                     "config.hardware.device")).getVirtualDevice();
         for (VirtualDevice device : deviceList) {
            if (device instanceof VirtualDisk) {
               if (value.equalsIgnoreCase(device.getDeviceInfo().getLabel())) {
                  disk = (VirtualDisk) device;
                  break;
               }
            }
         }
         if (disk != null) {
            diskSpec.setOperation(VirtualDeviceConfigSpecOperation.REMOVE);
            diskSpec
                  .setFileOperation(VirtualDeviceConfigSpecFileOperation.DESTROY);
            diskSpec.setDevice(disk);
         } else {
            System.out.println("No device found " + value);
            return null;
         }
      }
      return diskSpec;
   }

   private static VirtualDeviceConfigSpec getCDDeviceConfigSpec()
         throws Exception {
      String ops = operation;
      VirtualDeviceConfigSpec cdSpec = new VirtualDeviceConfigSpec();
      List<VirtualDevice> listvd =
            ((ArrayOfVirtualDevice) getEntityProps(virtualMachine,
                  new String[] { "config.hardware.device" }).get(
                  "config.hardware.device")).getVirtualDevice();

      if (ops.equalsIgnoreCase("Add")) {
         cdSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);

         VirtualCdrom cdrom = new VirtualCdrom();

         VirtualCdromRemoteAtapiBackingInfo vcrabi =
               new VirtualCdromRemoteAtapiBackingInfo();
         vcrabi.setDeviceName("");
         vcrabi.setUseAutoDetect(true);

         Map<Integer, VirtualDevice> deviceMap =
               new HashMap<Integer, VirtualDevice>();
         for (VirtualDevice virtualDevice : listvd) {
            deviceMap.put(virtualDevice.getKey(), virtualDevice);
         }
         int controllerKey = 0;
         int unitNumber = 0;
         boolean found = false;
         for (VirtualDevice virtualDevice : listvd) {
            if (virtualDevice instanceof VirtualIDEController) {
               VirtualIDEController vscsic =
                     (VirtualIDEController) virtualDevice;
               int[] slots = new int[2];
               List<Integer> devicelist = vscsic.getDevice();
               for (Integer deviceKey : devicelist) {
                  if (deviceMap.get(deviceKey).getUnitNumber() != null) {
                     slots[deviceMap.get(deviceKey).getUnitNumber()] = 1;
                  }
               }
               for (int i = 0; i < slots.length; i++) {
                  if (slots[i] != 1) {
                     controllerKey = vscsic.getKey();
                     unitNumber = i;
                     found = true;
                     break;
                  }
               }
               if (found) {
                  break;
               }
            }
         }

         if (!found) {
            throw new RuntimeException(
                  "The IDE controller on the vm has maxed out its "
                        + "capacity. Please add an additional IDE controller");
         }

         cdrom.setBacking(vcrabi);
         cdrom.setControllerKey(controllerKey);
         cdrom.setUnitNumber(unitNumber);
         cdrom.setKey(-1);

         cdSpec.setDevice(cdrom);
         return cdSpec;
      } else {
         VirtualCdrom cdRemove = null;
         cdSpec.setOperation(VirtualDeviceConfigSpecOperation.REMOVE);
         for (VirtualDevice device : listvd) {
            if (device instanceof VirtualCdrom) {
               if (value.equalsIgnoreCase(device.getDeviceInfo().getLabel())) {
                  cdRemove = (VirtualCdrom) device;
                  break;
               }
            }
         }
         if (cdRemove != null) {
            cdSpec.setDevice(cdRemove);
         } else {
            System.out.println("No device available " + value);
            return null;
         }
      }
      return cdSpec;
   }

   private static VirtualDeviceConfigSpec getNICDeviceConfigSpec()
         throws Exception {
      String ops = operation;
      VirtualDeviceConfigSpec nicSpec = new VirtualDeviceConfigSpec();
      if (ops.equalsIgnoreCase("Add")) {
         nicSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);
         VirtualEthernetCard nic = new VirtualPCNet32();
         VirtualEthernetCardNetworkBackingInfo nicBacking =
               new VirtualEthernetCardNetworkBackingInfo();
         nicBacking.setDeviceName(value);
         nic.setAddressType("generated");
         nic.setBacking(nicBacking);
         nic.setKey(-1);
         nicSpec.setDevice(nic);
      } else if (ops.equalsIgnoreCase("Remove")) {
         VirtualEthernetCard nic = null;
         nicSpec.setOperation(VirtualDeviceConfigSpecOperation.REMOVE);
         List<VirtualDevice> listvd =
               ((ArrayOfVirtualDevice) getEntityProps(virtualMachine,
                     new String[] { "config.hardware.device" }).get(
                     "config.hardware.device")).getVirtualDevice();
         for (VirtualDevice device : listvd) {
            if (device instanceof VirtualEthernetCard) {
               if (value.equalsIgnoreCase(device.getDeviceInfo().getLabel())) {
                  nic = (VirtualEthernetCard) device;
                  break;
               }
            }
         }
         if (nic != null) {
            nicSpec.setDevice(nic);
         } else {
            System.out.println("No device available " + value);
            return null;
         }
      }
      return nicSpec;
   }

   private static void reConfig() throws Exception {
      String deviceType = device;
      VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();

      if (deviceType.equalsIgnoreCase("memory") && operation.equals("update")) {
         System.out
               .println("Reconfiguring The Virtual Machine For Memory Update "
                     + vmName);
         try {
            vmConfigSpec.setMemoryAllocation(getShares());
         } catch (NumberFormatException nfe) {
            System.out.println("Value of Memory update must "
                  + "be one of high|low|normal|[numeric value]");
            return;
         }
      } else if (deviceType.equalsIgnoreCase("cpu")
            && operation.equals("update")) {
         System.out.println("Reconfiguring The Virtual Machine For CPU Update "
               + vmName);
         try {
            vmConfigSpec.setCpuAllocation(getShares());
         } catch (SOAPFaultException sfe) {
            printSoapFaultException(sfe);
         } catch (NumberFormatException nfe) {
            System.out.println("Value of CPU update must "
                  + "be one of high|low|normal|[numeric value]");
            return;
         }
      } else if (deviceType.equalsIgnoreCase("disk")
            && !operation.equals("update")) {
         System.out
               .println("Reconfiguring The Virtual Machine For Disk Update "
                     + vmName);
         VirtualDeviceConfigSpec vdiskSpec = getDiskDeviceConfigSpec();
         if (vdiskSpec != null) {
            List<VirtualDeviceConfigSpec> vdiskSpecArray =
                  new ArrayList<VirtualDeviceConfigSpec>();
            vdiskSpecArray.add(vdiskSpec);
            vmConfigSpec.getDeviceChange().addAll(vdiskSpecArray);
         } else {
            return;
         }
      } else if (deviceType.equalsIgnoreCase("nic")
            && !operation.equals("update")) {
         System.out.println("Reconfiguring The Virtual Machine For NIC Update "
               + vmName);
         VirtualDeviceConfigSpec nicSpec = getNICDeviceConfigSpec();
         if (nicSpec != null) {
            List<VirtualDeviceConfigSpec> nicSpecArray =
                  new ArrayList<VirtualDeviceConfigSpec>();
            nicSpecArray.add(nicSpec);
            vmConfigSpec.getDeviceChange().addAll(nicSpecArray);
         } else {
            return;
         }
      } else if (deviceType.equalsIgnoreCase("cd")
            && !operation.equals("update")) {
         System.out.println("Reconfiguring The Virtual Machine For CD Update "
               + vmName);
         VirtualDeviceConfigSpec cdSpec = getCDDeviceConfigSpec();
         if (cdSpec != null) {
            List<VirtualDeviceConfigSpec> cdSpecArray =
                  new ArrayList<VirtualDeviceConfigSpec>();
            cdSpecArray.add(cdSpec);
            vmConfigSpec.getDeviceChange().addAll(cdSpecArray);
         } else {
            return;
         }
      } else {
         System.out.println("Invalid device type [memory|cpu|disk|nic|cd]");
         return;
      }

      ManagedObjectReference tmor =
            vimPort.reconfigVMTask(virtualMachine, vmConfigSpec);
      if (getTaskResultAfterDone(tmor)) {
         System.out.println("Virtual Machine reconfigured successfully");
      } else {
         System.out.println("Virtual Machine reconfigur failed");
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
      System.out.println("Reconfigures a virtual machine, which include "
            + "reconfiguring the disk size, disk mode, etc.");
      System.out.println("url            [required]: url of the web service.");
      System.out
            .println("username       [required]: username for the authentication");
      System.out
            .println("Password       [required]: password for the authentication");
      System.out
            .println("vmname         [required]: name of the virtual machine");
      System.out.println("device         [required]: cpu|memory|disk|cd|nic");
      System.out.println("operation      [required]: add|remove|update");
      System.out
            .println("update operation is only possible for cpu and memory, add|remove are not allowed for cpu and memory");
      System.out
            .println("value          [required]: high|low|normal|numeric value, label of device when removing");
      System.out.println("disksize       [optional]: Size of virtual disk");
      System.out.println("diskmode       [optional]: "
            + "persistent|independent_persistent|independent_nonpersistent");
      System.out
            .println("run.bat com.vmware.scheduling.VMReconfig "
                  + "--url [URLString] --username [User] --password [Password] --vmname [VMName] "
                  + "--operation [Operation] --device [Devicetype] --value [Value] "
                  + "--disksize [VirtualdiskSize] --diskmode [VDiskmode]");
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
         if (customValidation()) {
            connect();
            virtualMachine =
                  getMOREFsInContainerByType(serviceContent.getRootFolder(),
                        "VirtualMachine").get(vmName);
            if (virtualMachine != null) {
               reConfig();
            } else {
               System.out.println("Virtual Machine " + vmName + " Not Found");
            }
         }
      } catch (IllegalArgumentException e) {
         printUsage();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println("Exception encountered " + e);
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
