package com.vmware.vm;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.vmware.vim25.SelectionSpec;
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
import com.vmware.vim25.VirtualDeviceFileBackingInfo;
import com.vmware.vim25.VirtualDisk;
import com.vmware.vim25.VirtualDiskFlatVer1BackingInfo;
import com.vmware.vim25.VirtualDiskFlatVer2BackingInfo;
import com.vmware.vim25.VirtualDiskRawDiskMappingVer1BackingInfo;
import com.vmware.vim25.VirtualDiskSparseVer1BackingInfo;
import com.vmware.vim25.VirtualDiskSparseVer2BackingInfo;
import com.vmware.vim25.VirtualHardware;
import com.vmware.vim25.VirtualMachineConfigSpec;

/**
 * <pre>
 * VMDeltaDisk
 * 
 * This sample creates a delta disk on top of an existing virtual disk in a VM,
 * and simultaneously removes the original disk using the reconfigure API.
 * 
 * <b>Parameters:</b>
 * url            [required] : url of the web service
 * username       [required] : username for the authentication
 * password       [required] : password for the authentication
 * vmname         [required] : Name of the virtual machine
 * devicename     [required] : Name of the new delta disk
 * diskname       [required] : Name of the disk
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.vm.VMDeltaDisk --url [webserviceurl]
 * --username [username] --password [password]
 * --vmname [myVM] --devicename [myDeltaDisk]  --diskname [dname1]
 * </pre>
 */

public class VMDeltaDisk {

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
      if ((url == null) || (userName == null) || (password == null)) {
         throw new IllegalArgumentException("Expected --url, --username, "
               + "--password arguments.");
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
         isConnected = false;
      }
   }

   private static String vmName = null;
   private static String device = null;
   private static String diskName = null;

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
         } else if (param.equalsIgnoreCase("--devicename")
               && !val.startsWith("--") && !val.isEmpty()) {
            device = val;
         } else if (param.equalsIgnoreCase("--diskname")
               && !val.startsWith("--") && !val.isEmpty()) {
            diskName = val;
         }
         val = "";
         ai += 2;
      }
      if ((vmName == null) || (device == null) || (diskName == null)) {
         throw new IllegalArgumentException(
               "Expected --vnname, --devicename and" + " --diskname argument.");
      }
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

   private static void createDeltaDisk() throws IllegalArgumentException,
         Exception {
      ManagedObjectReference vmMOR = getVMByVMname(vmName);
      String dsName = null;
      VirtualHardware hw = new VirtualHardware();
      ArrayList<PropertyFilterSpec> listpfs =
            new ArrayList<PropertyFilterSpec>();
      listpfs.add(createPropertyFilterSpec(vmMOR, "config.hardware"));
      List<ObjectContent> listobjcont = retrievePropertiesAllObjects(listpfs);
      if (listobjcont != null) {
         for (ObjectContent oc : listobjcont) {
            List<DynamicProperty> dps = oc.getPropSet();
            if (dps != null) {
               for (DynamicProperty dp : dps) {
                  hw = (VirtualHardware) dp.getVal();
               }
            }
         }
      }
      if (vmMOR != null) {
         VirtualDisk vDisk = findVirtualDisk(vmMOR, diskName, hw);
         if (vDisk != null) {
            VirtualMachineConfigSpec configSpec =
                  new VirtualMachineConfigSpec();
            VirtualDeviceConfigSpec deviceSpec = new VirtualDeviceConfigSpec();

            deviceSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);
            deviceSpec
                  .setFileOperation(VirtualDeviceConfigSpecFileOperation.CREATE);

            VirtualDisk newDisk = new VirtualDisk();

            newDisk.setCapacityInKB(vDisk.getCapacityInKB());
            if (vDisk.getShares() != null) {
               newDisk.setShares(vDisk.getShares());
            }
            if (vDisk.getConnectable() != null) {
               newDisk.setConnectable(vDisk.getConnectable());
            }
            if (vDisk.getControllerKey() != null) {
               newDisk.setControllerKey(vDisk.getControllerKey());
            }
            VirtualDeviceFileBackingInfo fBacking =
                  (VirtualDeviceFileBackingInfo) vDisk.getBacking();
            ArrayList<PropertyFilterSpec> deviceList =
                  new ArrayList<PropertyFilterSpec>();
            deviceList.add(createPropertyFilterSpec(fBacking.getDatastore(),
                  "summary.name"));
            List<ObjectContent> listdevobjcont =
                  retrievePropertiesAllObjects(deviceList);
            if (listdevobjcont != null) {
               for (ObjectContent oc : listdevobjcont) {
                  List<DynamicProperty> dps = oc.getPropSet();
                  if (dps != null) {
                     for (DynamicProperty dp : dps) {
                        dsName = (String) dp.getVal();
                     }
                  }
               }
            }
            newDisk.setUnitNumber(vDisk.getUnitNumber());
            newDisk.setKey(vDisk.getKey());
            if (vDisk.getBacking() instanceof VirtualDiskFlatVer1BackingInfo) {
               VirtualDiskFlatVer1BackingInfo temp =
                     new VirtualDiskFlatVer1BackingInfo();
               temp.setDiskMode(((VirtualDiskFlatVer1BackingInfo) vDisk
                     .getBacking()).getDiskMode());
               temp.setFileName("[" + dsName + "] " + vmName + "/" + device
                     + ".vmdk");
               temp.setParent((VirtualDiskFlatVer1BackingInfo) vDisk
                     .getBacking());
               newDisk.setBacking(temp);
            } else if (vDisk.getBacking() instanceof VirtualDiskFlatVer2BackingInfo) {
               VirtualDiskFlatVer2BackingInfo temp =
                     new VirtualDiskFlatVer2BackingInfo();
               temp.setDiskMode(((VirtualDiskFlatVer2BackingInfo) vDisk
                     .getBacking()).getDiskMode());
               temp.setFileName("[" + dsName + "] " + vmName + "/" + device
                     + ".vmdk");
               temp.setParent((VirtualDiskFlatVer2BackingInfo) vDisk
                     .getBacking());
               newDisk.setBacking(temp);
            } else if (vDisk.getBacking() instanceof VirtualDiskRawDiskMappingVer1BackingInfo) {
               VirtualDiskRawDiskMappingVer1BackingInfo temp =
                     new VirtualDiskRawDiskMappingVer1BackingInfo();
               temp.setDiskMode(((VirtualDiskRawDiskMappingVer1BackingInfo) vDisk
                     .getBacking()).getDiskMode());
               temp.setFileName("[" + dsName + "] " + vmName + "/" + device
                     + ".vmdk");
               temp.setParent((VirtualDiskRawDiskMappingVer1BackingInfo) vDisk
                     .getBacking());
               newDisk.setBacking(temp);
            } else if (vDisk.getBacking() instanceof VirtualDiskSparseVer1BackingInfo) {
               VirtualDiskSparseVer1BackingInfo temp =
                     new VirtualDiskSparseVer1BackingInfo();
               temp.setDiskMode(((VirtualDiskSparseVer1BackingInfo) vDisk
                     .getBacking()).getDiskMode());
               temp.setFileName("[" + dsName + "] " + vmName + "/" + device
                     + ".vmdk");
               temp.setParent((VirtualDiskSparseVer1BackingInfo) vDisk
                     .getBacking());
               newDisk.setBacking(temp);
            } else if (vDisk.getBacking() instanceof VirtualDiskSparseVer2BackingInfo) {
               VirtualDiskSparseVer2BackingInfo temp =
                     new VirtualDiskSparseVer2BackingInfo();
               temp.setDiskMode(((VirtualDiskSparseVer2BackingInfo) vDisk
                     .getBacking()).getDiskMode());
               temp.setFileName("[" + dsName + "] " + vmName + "/" + device
                     + ".vmdk");
               temp.setParent((VirtualDiskSparseVer2BackingInfo) vDisk
                     .getBacking());
               newDisk.setBacking(temp);
            }
            deviceSpec.setDevice(newDisk);
            VirtualDeviceConfigSpec removeDeviceSpec =
                  new VirtualDeviceConfigSpec();
            removeDeviceSpec
                  .setOperation(VirtualDeviceConfigSpecOperation.REMOVE);
            removeDeviceSpec.setDevice(vDisk);
            List<VirtualDeviceConfigSpec> vdList =
                  new ArrayList<VirtualDeviceConfigSpec>();
            vdList.add(removeDeviceSpec);
            vdList.add(deviceSpec);
            configSpec.getDeviceChange().addAll(vdList);
            try {
               ManagedObjectReference taskMOR =
                     vimPort.reconfigVMTask(vmMOR, configSpec);
               if (getTaskResultAfterDone(taskMOR)) {
                  System.out.println("Delta Disk Created successfully.");
               } else {
                  System.out.println("Failure -: Delta Disk "
                        + "cannot be created");
               }
            } catch (SOAPFaultException sfe) {
               printSoapFaultException(sfe);
            } catch (Exception e) {
               throw e;
            }
         } else {
            System.out.println("Virtual Disk " + diskName + " not found");
         }
      } else {
         System.out.println("Virtual Machine " + vmName + " doesn't exist");
      }
   }

   private static VirtualDisk findVirtualDisk(ManagedObjectReference vmMOR,
         String diskname, VirtualHardware hw) throws Exception {
      VirtualDisk ret = null;
      List<VirtualDevice> deviceArray = hw.getDevice();
      for (VirtualDevice virtualDevice : deviceArray) {
         if (virtualDevice instanceof VirtualDisk) {
            if (diskname.equalsIgnoreCase(virtualDevice.getDeviceInfo()
                  .getLabel())) {
               ret = (VirtualDisk) virtualDevice;
               break;
            }
         }
      }
      return ret;
   }

   private static PropertyFilterSpec createPropertyFilterSpec(
         ManagedObjectReference ref, String property) {
      PropertySpec propSpec = new PropertySpec();
      propSpec.setAll(new Boolean(false));
      propSpec.getPathSet().add(property);
      propSpec.setType(ref.getType());

      ObjectSpec objSpec = new ObjectSpec();
      objSpec.setObj(ref);
      objSpec.setSkip(new Boolean(false));

      PropertyFilterSpec spec = new PropertyFilterSpec();
      spec.getPropSet().add(propSpec);
      spec.getObjectSet().add(objSpec);
      return spec;
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
   private static ManagedObjectReference getVMByVMname(String vmname)
         throws IllegalArgumentException, Exception {
      ManagedObjectReference retVmRef = null;
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

      List<PropertyFilterSpec> listpfs = new ArrayList<PropertyFilterSpec>(1);
      listpfs.add(propertyFilterSpec);
      List<ObjectContent> listobjcont = retrievePropertiesAllObjects(listpfs);

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
      if (retVmRef == null) {
         throw new IllegalArgumentException("VM not found.");
      }
      return retVmRef;
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
            .println("This sample creates a delta disk on top of an existing ");
      System.out
            .println("virtual disk in a VM, and simultaneously removes the");
      System.out.println("original disk using the reconfigure API.");
      System.out.println("\nParameters:");
      System.out.println("url            [required] : url of the web service");
      System.out
            .println("username       [required] : username for the authentication");
      System.out
            .println("password       [required] : password for the authentication");
      System.out
            .println("vmname         [required] : Name of the virtual machine");
      System.out
            .println("devicename     [required] : Name of the new delta disk");
      System.out.println("diskname       [required] : Name of the disk");
      System.out.println("\nCommand:");
      System.out
            .println("run.bat com.vmware.vm.VMDeltaDisk --url [webserviceurl] ");
      System.out.println("--username [username] --password [password]");
      System.out
            .println("--vmname [myVM] --devicename [myDeltaDisk] --diskname [dname1]");
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
         createDeltaDisk();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (IllegalArgumentException iae) {
         System.out.println(iae.getMessage());
         printUsage();
      } catch (Exception e) {
         System.out.println("Failed to Create Delta Disk - " + e.getMessage());
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
