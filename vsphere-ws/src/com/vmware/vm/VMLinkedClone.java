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
import com.vmware.vim25.VirtualDisk;
import com.vmware.vim25.VirtualDiskFlatVer1BackingInfo;
import com.vmware.vim25.VirtualDiskFlatVer2BackingInfo;
import com.vmware.vim25.VirtualDiskRawDiskMappingVer1BackingInfo;
import com.vmware.vim25.VirtualDiskSparseVer1BackingInfo;
import com.vmware.vim25.VirtualDiskSparseVer2BackingInfo;
import com.vmware.vim25.VirtualHardware;
import com.vmware.vim25.VirtualMachineCloneSpec;
import com.vmware.vim25.VirtualMachineRelocateDiskMoveOptions;
import com.vmware.vim25.VirtualMachineRelocateSpec;
import com.vmware.vim25.VirtualMachineRelocateSpecDiskLocator;
import com.vmware.vim25.VirtualMachineSnapshotInfo;
import com.vmware.vim25.VirtualMachineSnapshotTree;

/**
 * <pre>
 * VMLinkedClone
 * 
 * This sample creates a linked clone from an existing snapshot
 * 
 * Each independent disk needs a DiskLocator with
 * diskmovetype as moveAllDiskBackingsAndDisallowSharing
 * 
 * <b>Parameters:</b>
 * url             [required] : url of the web service
 * username        [required] : username for the authentication
 * password        [required] : password for the authentication
 * vmname          [required] : Name of the virtual machine
 * snapshotname    [required] : Name of the snaphot
 * clonename       [required] : Name of the cloneName
 * 
 * <b>Command Line:</b>
 * Create a linked clone
 * run.bat com.vmware.vm.VMLinkedClone --url [webserviceurl]
 * --username [username] --password [password]  --vmname [myVM]
 * --snapshotname [snapshot name]  --clonename [clone name]
 * </pre>
 */
public class VMLinkedClone {

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
   private static String cloneName;
   private static String virtualMachineName;
   private static String snapshotName;

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
         } else if (param.equalsIgnoreCase("--snapshotname")
               && !val.startsWith("--") && !val.isEmpty()) {
            snapshotName = val;
         } else if (param.equalsIgnoreCase("--clonename")
               && !val.startsWith("--") && !val.isEmpty()) {
            cloneName = val;
         }
         val = "";
         ai += 2;
      }
      if (virtualMachineName == null || snapshotName == null
            || cloneName == null) {
         throw new IllegalArgumentException(
               "Expected --vmanme, --snapshotname and --clonename arguments.");
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
    * Creates the linked clone.
    * 
    * @throws Exception
    *            the exception
    */
   private static void createLinkedClone() throws Exception {
      ManagedObjectReference vmMOR =
            getMOREFsInContainerByType(serviceContent.getRootFolder(),
                  "VirtualMachine").get(virtualMachineName);

      if (vmMOR != null) {
         ManagedObjectReference snapMOR =
               getSnapshotReference(vmMOR, snapshotName);
         if (snapMOR != null) {
            ArrayList<Integer> independentVirtualDiskKeys =
                  getIndependenetVirtualDiskKeys(vmMOR);

            VirtualMachineRelocateSpec rSpec = new VirtualMachineRelocateSpec();
            if (independentVirtualDiskKeys.size() > 0) {
               List<ManagedObjectReference> ds =
                     ((ArrayOfManagedObjectReference) getEntityProps(vmMOR,
                           new String[] { "datastore" }).get("datastore"))
                           .getManagedObjectReference();
               List<VirtualMachineRelocateSpecDiskLocator> diskLocator =
                     new ArrayList<VirtualMachineRelocateSpecDiskLocator>();

               for (Integer iDiskKey : independentVirtualDiskKeys) {
                  VirtualMachineRelocateSpecDiskLocator diskloc =
                        new VirtualMachineRelocateSpecDiskLocator();
                  diskloc.setDatastore(ds.get(0));
                  diskloc
                        .setDiskMoveType(VirtualMachineRelocateDiskMoveOptions.MOVE_ALL_DISK_BACKINGS_AND_DISALLOW_SHARING
                              .value());
                  diskloc.setDiskId(iDiskKey);
                  diskLocator.add(diskloc);
               }
               rSpec.setDiskMoveType(VirtualMachineRelocateDiskMoveOptions.CREATE_NEW_CHILD_DISK_BACKING
                     .value());
               rSpec.getDisk().addAll(diskLocator);
            } else {
               rSpec.setDiskMoveType(VirtualMachineRelocateDiskMoveOptions.CREATE_NEW_CHILD_DISK_BACKING
                     .value());
            }
            VirtualMachineCloneSpec cloneSpec = new VirtualMachineCloneSpec();
            cloneSpec.setPowerOn(false);
            cloneSpec.setTemplate(false);
            cloneSpec.setLocation(rSpec);
            cloneSpec.setSnapshot(snapMOR);

            try {
               ManagedObjectReference parentMOR =
                     (ManagedObjectReference) getEntityProps(vmMOR,
                           new String[] { "parent" }).get("parent");
               if (parentMOR == null) {
                  throw new RuntimeException(
                        "The selected VM is a part of vAPP. This sample only "
                              + "works with virtual machines that are not a part "
                              + "of any vAPP");
               }
               ManagedObjectReference cloneTask =
                     vimPort
                           .cloneVMTask(vmMOR, parentMOR, cloneName, cloneSpec);
               if (getTaskResultAfterDone(cloneTask)) {
                  System.out.printf(" Cloning Successful");
               } else {
                  System.out.printf(" Cloning Failure");
               }
            } catch (SOAPFaultException sfe) {
               printSoapFaultException(sfe);
            } catch (Exception e) {
               e.printStackTrace();
            }
         } else {
            System.out.println("Snapshot " + snapshotName + " doesn't exist");
         }
      } else {
         System.out.println("Virtual Machine " + virtualMachineName
               + " doesn't exist");
      }
   }

   /**
    * Gets the independenet virtual disk keys.
    * 
    * @param vmMOR
    *           the vm mor
    * @return the independent virtual disk keys
    * @throws RuntimeFaultFaultMsg
    * @throws InvalidPropertyFaultMsg
    */
   private static ArrayList<Integer> getIndependenetVirtualDiskKeys(
         ManagedObjectReference vmMOR) throws InvalidPropertyFaultMsg,
         RuntimeFaultFaultMsg {
      ArrayList<Integer> independenetVirtualDiskKeys = new ArrayList<Integer>();
      VirtualHardware hw =
            (VirtualHardware) getEntityProps(vmMOR,
                  new String[] { "config.hardware" }).get("config.hardware");
      List<VirtualDevice> listvd = hw.getDevice();
      for (VirtualDevice vDisk : listvd) {
         if (vDisk instanceof VirtualDisk) {
            String diskMode = "";
            if (vDisk.getBacking() instanceof VirtualDiskFlatVer1BackingInfo) {
               diskMode =
                     ((VirtualDiskFlatVer1BackingInfo) vDisk.getBacking())
                           .getDiskMode();
            } else if (vDisk.getBacking() instanceof VirtualDiskFlatVer2BackingInfo) {
               diskMode =
                     ((VirtualDiskFlatVer2BackingInfo) vDisk.getBacking())
                           .getDiskMode();
            } else if (vDisk.getBacking() instanceof VirtualDiskRawDiskMappingVer1BackingInfo) {
               diskMode =
                     ((VirtualDiskRawDiskMappingVer1BackingInfo) vDisk
                           .getBacking()).getDiskMode();
            } else if (vDisk.getBacking() instanceof VirtualDiskSparseVer1BackingInfo) {
               diskMode =
                     ((VirtualDiskSparseVer1BackingInfo) vDisk.getBacking())
                           .getDiskMode();
            } else if (vDisk.getBacking() instanceof VirtualDiskSparseVer2BackingInfo) {
               diskMode =
                     ((VirtualDiskSparseVer2BackingInfo) vDisk.getBacking())
                           .getDiskMode();
            }
            if (diskMode.indexOf("independent") != -1) {
               independenetVirtualDiskKeys.add(vDisk.getKey());
            }
         }
      }
      return independenetVirtualDiskKeys;
   }

   /**
    * Gets the snapshot reference.
    * 
    * @param vmmor
    *           the vmmor
    * @param snapName
    *           the snap name
    * @return the snapshot reference
    * @throws Exception
    *            the exception
    */
   private static ManagedObjectReference getSnapshotReference(
         ManagedObjectReference vmmor, String snapName) throws Exception {
      VirtualMachineSnapshotInfo snapInfo =
            (VirtualMachineSnapshotInfo) getEntityProps(vmmor,
                  new String[] { "snapshot" }).get("snapshot");
      ManagedObjectReference snapmor = null;
      if (snapInfo != null) {
         List<VirtualMachineSnapshotTree> listvmsst =
               snapInfo.getRootSnapshotList();
         List<VirtualMachineSnapshotTree> snapTree = listvmsst;
         snapmor = traverseSnapshotInTree(snapTree, snapName);
      }
      return snapmor;
   }

   /**
    * Traverse snapshot in tree.
    * 
    * @param snapTree
    *           the snap tree
    * @param findName
    *           the find name
    * @return the managed object reference
    */
   private static ManagedObjectReference traverseSnapshotInTree(
         List<VirtualMachineSnapshotTree> snapTree, String findName) {
      ManagedObjectReference snapmor = null;
      if (snapTree == null) {
         return snapmor;
      }
      for (int i = 0; i < snapTree.size() && snapmor == null; i++) {
         VirtualMachineSnapshotTree node = snapTree.get(i);
         if (findName != null && node.getName().equals(findName)) {
            snapmor = node.getSnapshot();
         } else {
            List<VirtualMachineSnapshotTree> childTree =
                  node.getChildSnapshotList();
            snapmor = traverseSnapshotInTree(childTree, findName);
         }
      }
      return snapmor;
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
      System.out.println("This sample creates a linked "
            + "clone from an existing snapshot.");
      System.out.println("Each independent disk needs a DiskLocator with "
            + "diskmovetype as moveAllDiskBackingsAndDisallowSharing.");
      System.out.println("\nParameters:");
      System.out
            .println("url             [required] : url of the web service.");
      System.out
            .println("username        [required] : username for the authentication");
      System.out
            .println("password        [required] : password for the authentication");
      System.out
            .println("vmname          [required] : Name of the virtual machine");
      System.out.println("snapshotname    [required] : Name of the snaphot");
      System.out.println("clonename       [required] : Name of the cloneName");
      System.out.println("\nCommand:");
      System.out.println("Create a linked clone");
      System.out
            .println("run.bat com.vmware.vm.VMLinkedClone --url [webserviceurl]");
      System.out
            .println("--username [username] --password [password]  --vmname [myVM]");
      System.out
            .println("--snapshotname [snapshot name]  --clonename [clone name]");
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
         createLinkedClone();
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
