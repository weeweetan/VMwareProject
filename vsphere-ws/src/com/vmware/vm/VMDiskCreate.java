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

import com.vmware.vim25.ArrayOfVirtualDevice;
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
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDeviceConfigSpec;
import com.vmware.vim25.VirtualDeviceConfigSpecFileOperation;
import com.vmware.vim25.VirtualDeviceConfigSpecOperation;
import com.vmware.vim25.VirtualDeviceConnectInfo;
import com.vmware.vim25.VirtualDisk;
import com.vmware.vim25.VirtualDiskCompatibilityMode;
import com.vmware.vim25.VirtualDiskFlatVer2BackingInfo;
import com.vmware.vim25.VirtualDiskMode;
import com.vmware.vim25.VirtualDiskRawDiskMappingVer1BackingInfo;
import com.vmware.vim25.VirtualMachineConfigOption;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualSCSIController;

/**
 * <pre>
 * VMDiskCreate
 * 
 * This sample demonstrates how to create a virtual disk
 * 
 * <b>Parameters:</b>
 * url             [required] : url of the web service
 * username        [required] : username for the authentication
 * password        [required] : password for the authentication
 * vmname          [required] : Name of the virtual machine
 * datastorename   [optional] : name of the DataStore
 * disksize        [required] : Size of the virtual disk in MB
 * disktype        [optional] : Virtual Disk Type
 *                 [thin | preallocated | eagerzeroed | rdm | rdmp]
 * persistence     [optional] : Persistence mode of the virtual disk
 *                 [persistent | independent_persistent | independent_nonpersistent]
 * devicename      [optional] : Canonical name of the LUN to use for disk types
 * 
 * <b>Command Line:</b>
 * VMDiskCreate --url [webserviceurl]
 * --username [username] --password [password]
 * --vmname [vmname] --disksize [8]
 * --disktype [thin | preallocated | eagerzeroed | rdm | rdmp]
 * --persistence [persistent | independent_persistent | independent_nonpersistent]
 * --devicename vmhba0:0:0:0
 * </pre>
 */

public class VMDiskCreate {

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

   /** Disk Types allowed. **/
   private static enum DISKTYPE {
      THIN, THICK, PRE_ALLOCATED, RDM, RDMP, EAGERZEROED;
   }

   private static enum CONTROLLERTYPE {

      /**
       * Default device count max for SCSI controller is 16, with unit# 7 being
       * the reserver slot. Similarly for IDE controller the count is 2 a.k.a
       * primary and secondary. These are mentioned here just to keep the logic
       * of this sample simple and should NOT be used in production. Use
       * {@link VirtualMachineConfigOption} to retrieve these at the runtime
       * instead in production
       */
      SCSI(16, 7), IDE(2);

      private final int maxdevice;
      private int reserveSlot = -1;

      private CONTROLLERTYPE(int maxdevice) {
         this.maxdevice = maxdevice;
      }

      private CONTROLLERTYPE(int maxdevice, int reserveSlot) {
         this.maxdevice = maxdevice;
         this.reserveSlot = reserveSlot;
      }

      public int getMaxDevice() {
         return this.maxdevice;
      }

      public int getReserveSlot() {
         return this.reserveSlot;
      }
   }

   /** Hard Disk Bean. Inner class. **/
   private static class HardDiskBean {

      private DISKTYPE diskType;
      private String deviceName;
      private int disksize;

      public HardDiskBean() {
      }

      public void setDiskSize(int key) {
         this.disksize = key;
      }

      public int getDiskSize() {
         return this.disksize;
      }

      public void setDiskType(DISKTYPE dsktype) {
         this.diskType = dsktype;
      }

      public DISKTYPE getDiskType() {
         return this.diskType;
      }

      public void setDeviceName(String dvcname) {
         this.deviceName = dvcname;
      }

      public String getDeviceName() {
         return this.deviceName;
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
   private static final HardDiskBean hDiskBean = new HardDiskBean();

   private static String virtualMachineName;
   private static int diskSize;
   private static ManagedObjectReference dataStore;
   private static String dataStoreName;
   private static String disktype;
   private static String persistence;
   private static String devicename;

   private static final Map<String, DISKTYPE> disktypehm =
         new HashMap<String, DISKTYPE>();

   static {
      disktypehm.put("thin", DISKTYPE.THIN);
      disktypehm.put("thick", DISKTYPE.THICK);
      disktypehm.put("pre-allocated", DISKTYPE.PRE_ALLOCATED);
      disktypehm.put("rdm", DISKTYPE.RDM);
      disktypehm.put("rdmp", DISKTYPE.RDMP);
      disktypehm.put("eagerzeroed", DISKTYPE.EAGERZEROED);
   }

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
            virtualMachineName = val;
         } else if (param.equalsIgnoreCase("--datastorename")
               && !val.startsWith("--") && !val.isEmpty()) {
            dataStoreName = val;
         } else if (param.equalsIgnoreCase("--disktype")
               && !val.startsWith("--") && !val.isEmpty()) {
            disktype = val;
         } else if (param.equalsIgnoreCase("--persistence")
               && !val.startsWith("--") && !val.isEmpty()) {
            persistence = val;
         } else if (param.equalsIgnoreCase("--disksize")
               && !val.startsWith("--") && !val.isEmpty()) {
            try {
               diskSize = Integer.parseInt(val);
            } catch (SOAPFaultException sfe) {
               printSoapFaultException(sfe);
            } catch (NumberFormatException e) {
               throw new IllegalArgumentException(
                     "Please provide numeric argument for disk size.");
            }
         } else if (param.equalsIgnoreCase("--devicename")
               && !val.startsWith("--") && !val.isEmpty()) {
            devicename = val;
         }
         val = "";
         ai += 2;
      }
      if (virtualMachineName == null || diskSize < 0) {
         throw new IllegalArgumentException(
               "Expected --vmname and valid --disksize arguments.");
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

   private static void setDiskInformation() throws IllegalArgumentException {
      DISKTYPE vmdisktype = null;
      /** Set the Disk Type. **/
      if (disktype == null || disktype.trim().length() == 0) {
         System.out
               .println(" Disktype is not specified Assuming disktype [thin] ");
         vmdisktype = DISKTYPE.THIN;
         hDiskBean.setDiskType(vmdisktype);
         hDiskBean.setDiskSize(diskSize);
      } else {
         vmdisktype = disktypehm.get(disktype.trim().toLowerCase());
         if (vmdisktype == null) {
            System.out
                  .println("Invalid value for option disktype. Possible values are : "
                        + disktypehm.keySet());
            throw new IllegalArgumentException("The DISK Type " + disktype
                  + " is Invalid");
         }
         hDiskBean.setDiskType(vmdisktype);
         hDiskBean.setDiskSize(diskSize);
      }

      /** Set the Size of the newvirtualdisk. **/
      hDiskBean.setDiskSize((diskSize <= 0) ? 1 : diskSize);

      /** Set the device name for this newvirtualdisk. **/
      if (devicename == null || devicename.trim().length() == 0) {
         if ((vmdisktype == DISKTYPE.RDM) || (vmdisktype == DISKTYPE.RDMP)) {
            throw new IllegalArgumentException(
                  "The devicename is mandatory for specified disktype [ "
                        + vmdisktype + " ]");
         }
      } else {
         hDiskBean.setDeviceName(devicename);
      }
   }


   /**
    * @param vmMor
    *           ManagedObjectReference of the VM on which the operation is
    *           carried out
    * @param hdiskbean
    *           {@link HardDiskBean}
    * @return {@link VirtualDeviceConfigSpec} spec for the device change
    */
   private static VirtualDeviceConfigSpec virtualDiskOp(
         ManagedObjectReference vmMor, HardDiskBean hdiskbean) throws Exception {
      String deviceName = hdiskbean.getDeviceName();
      DISKTYPE diskType = hdiskbean.getDiskType();
      int diskSizeMB = hdiskbean.getDiskSize();
      VirtualDeviceConfigSpec vmcs = null;
      List<Integer> getControllerKeyReturnArr = getControllerKey(vmMor);
      String msg = "Failure Disk Create : SCSI Controller not found";
      if (!getControllerKeyReturnArr.isEmpty()) {
         Integer controllerKey = getControllerKeyReturnArr.get(0);
         Integer unitNumber = getControllerKeyReturnArr.get(1);
         vmcs =
               createVirtualDiskConfigSpec(deviceName, controllerKey,
                     unitNumber, diskType, diskSizeMB);
      } else {
         throw new RuntimeException(msg);
      }
      return vmcs;
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
            int[] slots = new int[CONTROLLERTYPE.SCSI.getMaxDevice()];
            slots[CONTROLLERTYPE.SCSI.getReserveSlot()] = 1;
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

   /*
    * This method constructs a VirtualDeviceConfigSpec for a Virtual Disk.
    *
    * @param deviceName Name of the device, must be the absolute path
    * like /vmfs/devices/disks/vmhba1:0:0:0
    * @param controllerKey index on the controller
    * @param unitNumber of the device on the controller
    * @param diskType one of thin, thick, rdm, rdmp
    * @param diskSizeGB size of the newvirtualdisk in GB.
    * @return VirtualDeviceConfigSpec used for adding / removing an
    * RDM based virtual newvirtualdisk.
    */
   private static VirtualDeviceConfigSpec createVirtualDiskConfigSpec(
         String deviceName, int controllerkey, int unitNumber,
         DISKTYPE diskType, int diskSizeMB) {

      VirtualDeviceConnectInfo vdci = new VirtualDeviceConnectInfo();
      vdci.setStartConnected(true);
      vdci.setConnected(true);
      vdci.setAllowGuestControl(false);

      VirtualDisk newvirtualdisk = new VirtualDisk();
      newvirtualdisk.setControllerKey(new Integer(controllerkey));
      newvirtualdisk.setUnitNumber(new Integer(unitNumber));
      newvirtualdisk.setCapacityInKB(1024 * diskSizeMB);
      newvirtualdisk.setKey(-1);
      newvirtualdisk.setConnectable(vdci);

      VirtualDiskFlatVer2BackingInfo backinginfo =
            new VirtualDiskFlatVer2BackingInfo();
      VirtualDiskRawDiskMappingVer1BackingInfo rdmorrdmpbackinginfo =
            new VirtualDiskRawDiskMappingVer1BackingInfo();

      switch (diskType) {
      case RDM:
         rdmorrdmpbackinginfo
               .setCompatibilityMode(VirtualDiskCompatibilityMode.VIRTUAL_MODE
                     .value());
         rdmorrdmpbackinginfo.setDeviceName(deviceName);
         rdmorrdmpbackinginfo.setDiskMode(persistence);
         rdmorrdmpbackinginfo.setDatastore(dataStore);
         rdmorrdmpbackinginfo.setFileName("");
         newvirtualdisk.setBacking(rdmorrdmpbackinginfo);
         break;
      case RDMP:
         rdmorrdmpbackinginfo
               .setCompatibilityMode(VirtualDiskCompatibilityMode.PHYSICAL_MODE
                     .value());
         rdmorrdmpbackinginfo.setDeviceName(deviceName);
         rdmorrdmpbackinginfo.setDatastore(dataStore);
         rdmorrdmpbackinginfo.setFileName("");
         newvirtualdisk.setBacking(rdmorrdmpbackinginfo);
         break;
      case THICK:
         backinginfo
               .setDiskMode(VirtualDiskMode.INDEPENDENT_PERSISTENT.value());
         backinginfo.setThinProvisioned(Boolean.FALSE);
         backinginfo.setEagerlyScrub(Boolean.FALSE);
         backinginfo.setDatastore(dataStore);
         backinginfo.setFileName("");
         newvirtualdisk.setBacking(backinginfo);
         break;
      case THIN:
         if (persistence == null) {
            persistence = "persistent";
         }
         backinginfo.setDiskMode(persistence);
         backinginfo.setThinProvisioned(Boolean.TRUE);
         backinginfo.setEagerlyScrub(Boolean.FALSE);
         backinginfo.setDatastore(dataStore);
         backinginfo.setFileName("");
         newvirtualdisk.setBacking(backinginfo);
         break;
      case PRE_ALLOCATED:
         backinginfo.setDiskMode(persistence);
         backinginfo.setThinProvisioned(Boolean.FALSE);
         backinginfo.setEagerlyScrub(Boolean.FALSE);
         backinginfo.setDatastore(dataStore);
         backinginfo.setFileName("");
         newvirtualdisk.setBacking(backinginfo);
         break;
      case EAGERZEROED:
         backinginfo.setDiskMode(persistence);
         backinginfo.setThinProvisioned(Boolean.FALSE);
         backinginfo.setEagerlyScrub(Boolean.TRUE);
         backinginfo.setDatastore(dataStore);
         backinginfo.setFileName("");
         newvirtualdisk.setBacking(backinginfo);
         break;
      default:
         break;
      }

      VirtualDeviceConfigSpec virtualdiskconfigspec =
            new VirtualDeviceConfigSpec();
      virtualdiskconfigspec
            .setFileOperation(VirtualDeviceConfigSpecFileOperation.CREATE);
      virtualdiskconfigspec.setOperation(VirtualDeviceConfigSpecOperation.ADD);
      virtualdiskconfigspec.setDevice(newvirtualdisk);
      return virtualdiskconfigspec;
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
            .println("This sample demonstrates how to create a virtual disk");
      System.out.println("\nParameters:");
      System.out
            .println("url             [required] : url of the web service.");
      System.out
            .println("username        [required] : username for the authentication");
      System.out
            .println("password        [required] : password for the authentication");
      System.out
            .println("vmname          [required] : Name of the virtual machine");
      System.out.println("datastorename   [optional] : name of the DataStore");
      System.out
            .println("disksize        [required] : Size of the virtual disk in MB");
      System.out.println("disktype        [optional] : Virtual Disk Type");
      System.out
            .println("                [thin | preallocated | eagerzeroed | rdm | rdmp]");
      System.out
            .println("persistence     [optional] : Persistence mode of the virtual disk");
      System.out
            .println("                "
                  + "[persistent | independent_persistent | independent_nonpersistent]");
      System.out
            .println("devicename      [optional] : Canonical name of the LUN to "
                  + "use for disk types");
      System.out.println("\nCommand:");
      System.out.println("VMDiskCreate --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--vmname [vmname] --disksize [8]");
      System.out
            .println("--disktype [thin | preallocated | eagerzeroed | rdm | rdmp]");
      System.out
            .println("--persistence [persistent | independent_persistent | independent_nonpersistent]");
      System.out.println("--devicename vmhba0:0:0:0");
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
         ManagedObjectReference vmmor =
               getMOREFsInContainerByType(serviceContent.getRootFolder(),
                     "VirtualMachine").get(virtualMachineName);

         if (vmmor == null) {
            System.out.printf(" Virtual Machine [ %s ] not found",
                  virtualMachineName);
            return;
         }

         // Start Setting the Required Objects,
         //to configure a hard newvirtualdisk to this
         // Virtual machine.
         VirtualMachineConfigSpec vmcsreconfig = new VirtualMachineConfigSpec();

         // Initialize the Hard Disk bean.
         setDiskInformation();

         //Initialize the data store
         dataStoreName = "[" + dataStoreName + "]";

         VirtualDeviceConfigSpec diskSpecification =
               virtualDiskOp(vmmor, hDiskBean);
         if (diskSpecification == null) {
            System.exit(0);
         }
         List<VirtualDeviceConfigSpec> alvdcs =
               new ArrayList<VirtualDeviceConfigSpec>();
         alvdcs.add(diskSpecification);

         vmcsreconfig.getDeviceChange().addAll(alvdcs);
         System.out.printf(" Reconfiguring the Virtual Machine  - [ %s ]",
               virtualMachineName);
         ManagedObjectReference task =
               vimPort.reconfigVMTask(vmmor, vmcsreconfig);
         if (getTaskResultAfterDone(task)) {
            System.out.printf("\n Reconfiguring the Virtual Machine "
                  + " - [ %s ] Successful", virtualMachineName);
         } else {
            System.out.printf(" Reconfiguring the Virtual Machine "
                  + " - [ %s ] Failed", virtualMachineName);
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
