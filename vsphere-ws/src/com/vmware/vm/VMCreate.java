package com.vmware.vm;

import java.rmi.RemoteException;
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

import com.vmware.vim25.*;

/**
 * <pre>
 * VMCreate
 * 
 * This sample creates a VM
 * 
 * <b>Parameters:</b>
 * url              [required] : url of the web service
 * username         [required] : username for the authentication
 * password         [required] : password for the authentication
 * vmname           [required] : Name of the virtual machine
 * datacentername   [required] : Name of the datacenter
 * hostname         [required] : Name of the host
 * guestosid        [optional] : Type of Guest OS
 * cpucount         [optional] : Total cpu count
 * disksize         [optional] : Size of the Disk
 * memorysize       [optional] : Size of the Memory in 1024MB blocks
 * datastorename    [optional] : Name of dataStore
 * 
 * <b>Command Line:</b>
 * Create a VM given datacenter and host names
 * run.bat com.vmware.vm.VMCreate --url [webserviceurl]
 * --username [username] --password [password] --vmname [vmname]
 * --datacentername [DataCenterName] --hostname [hostname]
 * 
 * Create a VM given its name, Datacenter name and GuestOsId
 * run.bat com.vmware.vm.VMCreate --url [webserviceurl]
 * --username [username] --password [password] --vmname [vmname]
 * --datacentername [DataCenterName] --guestosid [GuestOsId]
 * 
 * Create a VM given its name, Datacenter name and its cpucount
 * run.bat com.vmware.vm.VMCreate --url [webserviceurl]
 * --username [username] --password [password] --vmname [vmname]
 * --datacentername [DataCenterName] --cpucount [cpucount]
 * </pre>
 */
public class VMCreate {

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
   private static String dataStore;
   private static String virtualMachineName;
   private static long vmMemory;
   private static int numCpus;
   private static String dataCenterName;
   private static long diskSize;
   private static String hostname;
   private static String guestOsId = "windows7Guest";

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
         if (param.equalsIgnoreCase("--datacentername")
               && !val.startsWith("--") && !val.isEmpty()) {
            dataCenterName = val;
         } else if (param.equalsIgnoreCase("--vmname") && !val.startsWith("--")
               && !val.isEmpty()) {
            virtualMachineName = val;
         } else if (param.equalsIgnoreCase("--hostname")
               && !val.startsWith("--") && !val.isEmpty()) {
            hostname = val;
         } else if (param.equalsIgnoreCase("--guestosid")
               && !val.startsWith("--") && !val.isEmpty()) {
            guestOsId = val;
         } else if (param.equalsIgnoreCase("--cpucount")
               && !val.startsWith("--") && !val.isEmpty()) {
            try {
               numCpus = Integer.parseInt(val);
            } catch (SOAPFaultException sfe) {
               printSoapFaultException(sfe);
            } catch (NumberFormatException e) {
               throw new IllegalArgumentException(
                     "Please provide numeric argument for cpu count.");
            }
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
         } else if (param.equalsIgnoreCase("--memorysize")
               && !val.startsWith("--") && !val.isEmpty()) {
            try {
               vmMemory = Long.parseLong(val);
            } catch (NumberFormatException e) {
               throw new IllegalArgumentException(
                     "Please provide numeric argument for memory size.");
            }
         } else if (param.equalsIgnoreCase("--datastorename")
               && !val.startsWith("--") && !val.isEmpty()) {
            dataStore = val;
         }
         val = "";
         ai += 2;
      }
      if (virtualMachineName == null || dataCenterName == null
            || hostname == null) {
         throw new IllegalArgumentException(
               "Expected --datacentername, --vmname, --hostname arguments.");
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

   /**
    * Creates the virtual machine.
    * 
    * @throws RemoteException
    *            the remote exception
    * @throws Exception
    *            the exception
    */
   private static void createVirtualMachine() throws RemoteException, Exception {

      ManagedObjectReference dcmor =
            getMOREFsInContainerByType(serviceContent.getRootFolder(),
                  "Datacenter").get(dataCenterName);

      if (dcmor == null) {
         System.out.println("Datacenter " + dataCenterName + " not found.");
         return;
      }
      ManagedObjectReference hostmor =
            getMOREFsInContainerByType(dcmor, "HostSystem").get(hostname);
      if (hostmor == null) {
         System.out.println("Host " + hostname + " not found");
         return;
      }

      ManagedObjectReference crmor =
            (ManagedObjectReference) getEntityProps(hostmor,
                  new String[] { "parent" }).get("parent");
      if (crmor == null) {
         System.out.println("No Compute Resource Found On Specified Host");
         return;
      }

      ManagedObjectReference resourcepoolmor =
            (ManagedObjectReference) getEntityProps(crmor,
                  new String[] { "resourcePool" }).get("resourcePool");
      ManagedObjectReference vmFolderMor =
            (ManagedObjectReference) getEntityProps(dcmor,
                  new String[] { "vmFolder" }).get("vmFolder");

      VirtualMachineConfigSpec vmConfigSpec =
            createVmConfigSpec(virtualMachineName, dataStore, diskSize, crmor,
                  hostmor);

      vmConfigSpec.setName(virtualMachineName);
      vmConfigSpec.setAnnotation("VirtualMachine Annotation");
      vmConfigSpec.setMemoryMB(new Long(vmMemory));
      vmConfigSpec.setNumCPUs(numCpus);
      vmConfigSpec.setGuestId(guestOsId);

      ManagedObjectReference taskmor =
            vimPort.createVMTask(vmFolderMor, vmConfigSpec, resourcepoolmor,
                  hostmor);
      if (getTaskResultAfterDone(taskmor)) {
         System.out.printf("Success: Creating VM  - [ %s ] %n",
               virtualMachineName);
      } else {
         String msg = "Failure: Creating [ " + virtualMachineName + "] VM";
         throw new RuntimeException(msg);
      }
      ManagedObjectReference vmMor =
            (ManagedObjectReference) getEntityProps(taskmor,
                  new String[] { "info.result" }).get("info.result");
      System.out.println("Powering on the newly created VM "
            + virtualMachineName);
      // Start the Newly Created VM.
      powerOnVM(vmMor);
   }

   /**
    * Creates the vm config spec object.
    * 
    * @param vmName
    *           the vm name
    * @param datastoreName
    *           the datastore name
    * @param diskSizeKB
    *           the disk size in mb
    * @param computeResMor
    *           the compute res moref
    * @param hostMor
    *           the host mor
    * @return the virtual machine config spec object
    * @throws Exception
    *            the exception
    */
   private static VirtualMachineConfigSpec createVmConfigSpec(String vmName,
         String datastoreName, long diskSizeKB,
         ManagedObjectReference computeResMor, ManagedObjectReference hostMor)
         throws Exception {

      ConfigTarget configTarget =
            getConfigTargetForHost(computeResMor, hostMor);
      List<VirtualDevice> defaultDevices =
            getDefaultDevices(computeResMor, hostMor);
      VirtualMachineConfigSpec configSpec = new VirtualMachineConfigSpec();
      String networkName = null;
      if (configTarget.getNetwork() != null) {
         for (int i = 0; i < configTarget.getNetwork().size(); i++) {
            VirtualMachineNetworkInfo netInfo =
                  configTarget.getNetwork().get(i);
            NetworkSummary netSummary = netInfo.getNetwork();
            if (netSummary.isAccessible()) {
               networkName = netSummary.getName();
               break;
            }
         }
      }
      ManagedObjectReference datastoreRef = null;
      if (datastoreName != null) {
         boolean flag = false;
         for (int i = 0; i < configTarget.getDatastore().size(); i++) {
            VirtualMachineDatastoreInfo vdsInfo =
                  configTarget.getDatastore().get(i);
            DatastoreSummary dsSummary = vdsInfo.getDatastore();
            if (dsSummary.getName().equals(datastoreName)) {
               flag = true;
               if (dsSummary.isAccessible()) {
                  datastoreRef = dsSummary.getDatastore();
               } else {
                  throw new RuntimeException(
                        "Specified Datastore is not accessible");
               }
               break;
            }
         }
         if (!flag) {
            throw new RuntimeException("Specified Datastore is not Found");
         }
      } else {
         boolean flag = false;
         for (int i = 0; i < configTarget.getDatastore().size(); i++) {
            VirtualMachineDatastoreInfo vdsInfo =
                  configTarget.getDatastore().get(i);
            DatastoreSummary dsSummary = vdsInfo.getDatastore();
            if (dsSummary.isAccessible()) {
               datastoreName = dsSummary.getName();
               datastoreRef = dsSummary.getDatastore();
               flag = true;
               break;
            }
         }
         if (!flag) {
            throw new RuntimeException("No Datastore found on host");
         }
      }
      String datastoreVolume = getVolumeName(datastoreName);
      VirtualMachineFileInfo vmfi = new VirtualMachineFileInfo();
      vmfi.setVmPathName(datastoreVolume);
      configSpec.setFiles(vmfi);
      // Add a scsi controller
      int diskCtlrKey = 1;
      VirtualDeviceConfigSpec scsiCtrlSpec = new VirtualDeviceConfigSpec();
      scsiCtrlSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);
      VirtualLsiLogicController scsiCtrl = new VirtualLsiLogicController();
      scsiCtrl.setBusNumber(0);
      scsiCtrlSpec.setDevice(scsiCtrl);
      scsiCtrl.setKey(diskCtlrKey);
      scsiCtrl.setSharedBus(VirtualSCSISharing.NO_SHARING);
      String ctlrType = scsiCtrl.getClass().getName();
      ctlrType = ctlrType.substring(ctlrType.lastIndexOf(".") + 1);

      // Find the IDE controller
      VirtualDevice ideCtlr = null;
      for (int di = 0; di < defaultDevices.size(); di++) {
         if (defaultDevices.get(di) instanceof VirtualIDEController) {
            ideCtlr = defaultDevices.get(di);
            break;
         }
      }

      // Add a floppy(软盘)
      VirtualDeviceConfigSpec floppySpec = new VirtualDeviceConfigSpec();
      floppySpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);
      VirtualFloppy floppy = new VirtualFloppy();
      VirtualFloppyDeviceBackingInfo flpBacking =
            new VirtualFloppyDeviceBackingInfo();
      flpBacking.setDeviceName("/dev/fd0");
      floppy.setBacking(flpBacking);
      floppy.setKey(3);
      floppySpec.setDevice(floppy);

      // Add a cdrom based on a physical device
      VirtualDeviceConfigSpec cdSpec = null;

      if (ideCtlr != null) {
         cdSpec = new VirtualDeviceConfigSpec();
         cdSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);
         VirtualCdrom cdrom = new VirtualCdrom();
         VirtualCdromIsoBackingInfo cdDeviceBacking =
               new VirtualCdromIsoBackingInfo();
         cdDeviceBacking.setDatastore(datastoreRef);
         cdDeviceBacking.setFileName(datastoreVolume + "testcd.iso");
         cdrom.setBacking(cdDeviceBacking);
         cdrom.setKey(20);
         cdrom.setControllerKey(new Integer(ideCtlr.getKey()));
         cdrom.setUnitNumber(new Integer(0));
         cdSpec.setDevice(cdrom);
      }

      // Create a new disk - file based - for the vm
      VirtualDeviceConfigSpec diskSpec = null;
      diskSpec =
            createVirtualDisk(datastoreName, diskCtlrKey, datastoreRef,
                  diskSizeKB);

      // Add a NIC. the network Name must be set as the device name to create the NIC.
      VirtualDeviceConfigSpec nicSpec = new VirtualDeviceConfigSpec();
      if (networkName != null) {
         nicSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);
         VirtualEthernetCard nic = new VirtualPCNet32();
         VirtualEthernetCardNetworkBackingInfo nicBacking =
               new VirtualEthernetCardNetworkBackingInfo();
         nicBacking.setDeviceName(networkName);
         nic.setAddressType("generated");
         nic.setBacking(nicBacking);
         nic.setKey(4);
         nicSpec.setDevice(nic);
      }

      List<VirtualDeviceConfigSpec> deviceConfigSpec =
            new ArrayList<VirtualDeviceConfigSpec>();
      deviceConfigSpec.add(scsiCtrlSpec);
      deviceConfigSpec.add(floppySpec);
      deviceConfigSpec.add(diskSpec);
      if (ideCtlr != null) {
         deviceConfigSpec.add(cdSpec);
         deviceConfigSpec.add(nicSpec);
      } else {
         deviceConfigSpec = new ArrayList<VirtualDeviceConfigSpec>();
         deviceConfigSpec.add(nicSpec);
      }
      configSpec.getDeviceChange().addAll(deviceConfigSpec);
      return configSpec;
   }

   /**
    * This method returns the ConfigTarget for a HostSystem.
    * 
    * @param computeResMor
    *           A MoRef to the ComputeResource used by the HostSystem
    * @param hostMor
    *           A MoRef to the HostSystem
    * @return Instance of ConfigTarget for the supplied
    *         HostSystem/ComputeResource
    * @throws Exception
    *            When no ConfigTarget can be found
    */
   private static ConfigTarget getConfigTargetForHost(
         ManagedObjectReference computeResMor, ManagedObjectReference hostMor)
         throws Exception {
      ManagedObjectReference envBrowseMor =
            (ManagedObjectReference) getEntityProps(computeResMor,
                  new String[] { "environmentBrowser" }).get(
                  "environmentBrowser");
      ConfigTarget configTarget =
            vimPort.queryConfigTarget(envBrowseMor, hostMor);
      if (configTarget == null) {
         throw new RuntimeException("No ConfigTarget found in ComputeResource");
      }
      return configTarget;
   }

   /**
    * The method returns the default devices from the HostSystem.
    * 
    * @param computeResMor
    *           A MoRef to the ComputeResource used by the HostSystem
    * @param hostMor
    *           A MoRef to the HostSystem
    * @return Array of VirtualDevice containing the default devices for the
    *         HostSystem
    * @throws Exception
    */
   private static List<VirtualDevice> getDefaultDevices(
         ManagedObjectReference computeResMor, ManagedObjectReference hostMor)
         throws Exception {
      ManagedObjectReference envBrowseMor =
            (ManagedObjectReference) getEntityProps(computeResMor,
                  new String[] { "environmentBrowser" }).get(
                  "environmentBrowser");
      VirtualMachineConfigOption cfgOpt =
            vimPort.queryConfigOption(envBrowseMor, null, hostMor);
      List<VirtualDevice> defaultDevs = null;
      if (cfgOpt == null) {
         throw new RuntimeException(
               "No VirtualHardwareInfo found in ComputeResource");
      } else {
         List<VirtualDevice> lvds = cfgOpt.getDefaultDevice();
         if (lvds == null) {
            throw new RuntimeException("No Datastore found in ComputeResource");
         } else {
            defaultDevs = lvds;
         }
      }
      return defaultDevs;
   }

   private static String getVolumeName(String volName) {
      String volumeName = null;
      if (volName != null && volName.length() > 0) {
         volumeName = "[" + volName + "]";
      } else {
         volumeName = "[Local]";
      }

      return volumeName;
   }

   /**
    * Creates the virtual disk.
    * 
    * @param volName
    *           the vol name
    * @param diskCtlrKey
    *           the disk ctlr key
    * @param datastoreRef
    *           the datastore ref
    * @param diskSizeKB
    *           the disk size in mb
    * @return the virtual device config spec object
    */
   private static VirtualDeviceConfigSpec createVirtualDisk(String volName,
         int diskCtlrKey, ManagedObjectReference datastoreRef, long diskSizeKB) {
      String volumeName = getVolumeName(volName);
      VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec();

      diskSpec.setFileOperation(VirtualDeviceConfigSpecFileOperation.CREATE);
      diskSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);

      VirtualDisk disk = new VirtualDisk();
      VirtualDiskFlatVer2BackingInfo diskfileBacking =
            new VirtualDiskFlatVer2BackingInfo();

      diskfileBacking.setFileName(volumeName);
      diskfileBacking.setDiskMode("persistent");

      disk.setKey(new Integer(0));
      disk.setControllerKey(new Integer(diskCtlrKey));
      disk.setUnitNumber(new Integer(0));
      disk.setBacking(diskfileBacking);
      disk.setCapacityInKB(diskSizeKB);

      diskSpec.setDevice(disk);

      return diskSpec;
   }

   /**
    * Power on vm.
    * 
    * @param vmMor
    *           the vm moref
    * @throws RemoteException
    *            the remote exception
    * @throws Exception
    *            the exception
    */
   private static void powerOnVM(ManagedObjectReference vmMor)
         throws RemoteException, Exception {
      ManagedObjectReference cssTask = vimPort.powerOnVMTask(vmMor, null);
      if (getTaskResultAfterDone(cssTask)) {
         System.out.println("Success: VM started Successfully");
      } else {
         String msg = "Failure: starting [ " + vmMor.getValue() + "] VM";
         throw new RuntimeException(msg);
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
      System.out.println("This sample creates a VM.");
      System.out.println("\nParameters:");
      System.out
            .println("url              [required] : url of the web service");
      System.out
            .println("username         [required] : username for the authentication");
      System.out
            .println("password         [required] : password for the authentication");
      System.out
            .println("vmname           [required] : Name of the virtual machine");
      System.out
            .println("datacentername   [required] : Name of the datacenter");
      System.out.println("hostname         [required] : Name of the host");
      System.out.println("guestosid        [optional] : Type of Guest OS");
      System.out.println("cpucount         [optional] : Total cpu count");
      System.out.println("disksize         [optional] : Size of the Disk");
      System.out
            .println("memorysize       [optional] : Size of the Memory in 1024MB blocks");
      System.out.println("datastorename    [optional] : Name of dataStore");
      System.out.println("\nCommand:");
      System.out.println("Create a VM given datacenter and host names");
      System.out
            .println("run.bat com.vmware.vm.VMCreate --url [webserviceurl]");
      System.out
            .println("--username [username] --password [password] --vmname [vmname]");
      System.out
            .println("--datacentername [DataCenterName] --hostname [hostname]");
      System.out
            .println("Create a VM given its name, Datacenter name and GuestOsId");
      System.out
            .println("run.bat com.vmware.vm.VMCreate --url [webserviceurl]");
      System.out
            .println("--username [username] --password [password] --vmname [vmname]");
      System.out
            .println("--datacentername [DataCenterName] --guestosid [GuestOsId]");
      System.out
            .println("Create a VM given its name, Datacenter name and its cpucount");
      System.out
            .println("run.bat com.vmware.vm.VMCreate --url [webserviceurl]");
      System.out
            .println("--username [username] --password [password] --vmname [vmname]");
      System.out
            .println("--datacentername [DataCenterName] --cpucount [cpucount]");
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
         String VirtualMachine  = "ubuntu";
         ManagedObjectReference vmmor =
                 getMOREFsInContainerByType(serviceContent.getRootFolder(),
                         "VirtualMachine").get(VirtualMachine);
         VirtualMachineConfigInfo vmConfigInfo =
                 (VirtualMachineConfigInfo)getEntityProps(vmmor,
                         new String[] { "config" }).get("config");
         guestOsId = vmConfigInfo.getGuestId();
         numCpus = vmConfigInfo.getHardware().getNumCPU();
         vmMemory = vmConfigInfo.getHardware().getMemoryMB();
         List<VirtualDevice> device = vmConfigInfo.getHardware().getDevice();
         for (VirtualDevice vd : device) {
            if (vd.getDeviceInfo().getLabel().contains("Hard disk") || vd.getDeviceInfo().getLabel().contains("硬盘")) {
               diskSize = ((VirtualDisk) vd).getCapacityInKB();
            }
         }
         // Create The Virtual Machine.
         createVirtualMachine();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
         printUsage();
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
