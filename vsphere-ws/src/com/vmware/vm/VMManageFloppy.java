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
import com.vmware.vim25.ConcurrentAccessFaultMsg;
import com.vmware.vim25.Description;
import com.vmware.vim25.DuplicateNameFaultMsg;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.FileFaultFaultMsg;
import com.vmware.vim25.InsufficientResourcesFaultFaultMsg;
import com.vmware.vim25.InvalidCollectorVersionFaultMsg;
import com.vmware.vim25.InvalidDatastoreFaultMsg;
import com.vmware.vim25.InvalidNameFaultMsg;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.InvalidStateFaultMsg;
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
import com.vmware.vim25.TaskInProgressFaultMsg;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDeviceConfigSpec;
import com.vmware.vim25.VirtualDeviceConfigSpecOperation;
import com.vmware.vim25.VirtualDeviceConnectInfo;
import com.vmware.vim25.VirtualFloppy;
import com.vmware.vim25.VirtualFloppyDeviceBackingInfo;
import com.vmware.vim25.VirtualFloppyImageBackingInfo;
import com.vmware.vim25.VirtualFloppyRemoteDeviceBackingInfo;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VmConfigFaultFaultMsg;

/**
 * <pre>
 * VMManageFloppy
 * 
 * This sample adds / removes floppy to / from an existing VM
 * This sample lists information about a VMs Floppies
 * This sample updates an existing floppy drive on a VM
 * 
 * <b>Parameters:</b>
 * url               [required] : url of the web service
 * username          [required] : username for the authentication
 * password          [required] : password for the authentication
 * vmname            [required] : name of the virtual machine
 * operation         [required] : operation type - [get|add|remove|set]
 * imgpath           [optional] : path of image file
 * remote            [optional] : device is a remote or client device or iso
 * startconnected    [optional] : virtual floppy starts connected on VM poweron
 * connect           [optional] : virtual floppy is connected
 *                                Set only if the VM is powered on
 * label             [optional] : used to find the device.key value
 * device            [optional] : path to the floppy on the VM's host
 * 
 * <b>Command Line:</b>
 * Get Floppy Info");
 * run.bat com.vmware.vm.VMManageFloppy
 * --url [webserviceurl] --username [username] --password  [password]
 * --operation get --vmname [Virtual Machine Name]
 * 
 * Add Floppy
 * run.bat com.vmware.vm.VMManageFloppy
 * --url [webserviceurl] --username [username] --password [password]
 * --operation add --vmname [Virtual Machine Name]
 * --imgpath test.flp --remote false --connect true
 * 
 * Remove Floppy
 * run.bat com.vmware.vm.VMManageFloppy
 * --url [webserviceurl] --username [username] --password  [password]
 * --operation remove --vmname [Virtual Machine Name]
 * --label Floppy Drive 1
 * 
 * Reconfigure Floppy
 * run.bat com.vmware.vm.VMManageFloppy
 * --url [webserviceurl] --username [username] --password  [password]
 * --operation set --vmname [Virtual Machine Name]
 * --label Floppy Drive 1 --connect false
 * </pre>
 */

public class VMManageFloppy {

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

   private static String virtualmachinename;
   private static String operation;
   private static String imagePath;
   private static String remote;
   private static String startConnected;
   private static String device;
   private static String label;
   private static String setConnect;
   private static ManagedObjectReference vmRef;

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
         } else if (param.equalsIgnoreCase("--operation")
               && !val.startsWith("--") && !val.isEmpty()) {
            operation = val;
         } else if (param.equalsIgnoreCase("--imgpath")
               && !val.startsWith("--") && !val.isEmpty()) {
            imagePath = val;
         } else if (param.equalsIgnoreCase("--remote") && !val.startsWith("--")
               && !val.isEmpty()) {
            remote = val;
         } else if (param.equalsIgnoreCase("--startconnected")
               && !val.startsWith("--") && !val.isEmpty()) {
            startConnected = val;
         } else if (param.equalsIgnoreCase("--connect")
               && !val.startsWith("--") && !val.isEmpty()) {
            setConnect = val;
         } else if (param.equalsIgnoreCase("--label") && !val.startsWith("--")
               && !val.isEmpty()) {
            label = val;
         } else if (param.equalsIgnoreCase("--device") && !val.startsWith("--")
               && !val.isEmpty()) {
            device = val;
         }
         val = "";
         ai += 2;
      }
      if (virtualmachinename == null || operation == null) {
         throw new IllegalArgumentException(
               "Expected --vmname and --operation argument.");
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

   private static boolean validateTheInput() {

      boolean valid = true;

      if (operation != null) {
         if (!operation.equalsIgnoreCase("add")
               && !operation.equalsIgnoreCase("get")
               && !operation.equalsIgnoreCase("remove")
               && !operation.equalsIgnoreCase("set")) {
            System.out.println("Invalid option for operation");
            System.out.println("Valid Options : get | remove | add | set");
            valid = false;
         }
      }
      if (setConnect != null) {
         if (!setConnect.equalsIgnoreCase("true")
               && !setConnect.equalsIgnoreCase("false")) {
            System.out.println("Invalid option for connect");
            System.out.println("Valid Options : true | false");
            valid = false;
         }
      }
      if (startConnected != null) {
         if (!startConnected.equalsIgnoreCase("true")
               && !startConnected.equalsIgnoreCase("false")) {
            System.out.println("Invalid option for startConnected");
            System.out.println("Valid Options : true | false");
            valid = false;
         }
      }
      if (remote != null) {
         if (!remote.equalsIgnoreCase("true")
               && !remote.equalsIgnoreCase("false")) {
            System.out.println("Invalid option for remote");
            System.out.println("Valid Options : true | false");
            valid = false;
         }
      }
      return valid;
   }

   private static void doOperation() throws Exception {
      vmRef =
            getMOREFsInContainerByType(serviceContent.getRootFolder(),
                  "VirtualMachine").get(virtualmachinename);
      if (vmRef == null) {
         System.out.println("Virtual Machine " + virtualmachinename
               + " not found.");
         return;
      }
      if (operation.equalsIgnoreCase("get")) {
         getInfo();
      } else if (operation.equalsIgnoreCase("add")) {
         addFloppy();
      }
      if (operation.equalsIgnoreCase("remove")) {
         removeFloppy();
      }
      if (operation.equalsIgnoreCase("set")) {
         setFloppy();
      }
   }

   private static void getInfo() throws Exception {
      List<VirtualDevice> deviceArr =
            ((ArrayOfVirtualDevice) getEntityProps(vmRef,
                  new String[] { "config.hardware.device" }).get(
                  "config.hardware.device")).getVirtualDevice();
      int count = 0;
      for (VirtualDevice devicearr : deviceArr) {
         if (devicearr instanceof VirtualFloppy) {
            String name = devicearr.getDeviceInfo().getLabel();
            int key = devicearr.getKey();
            boolean isconnected = devicearr.getConnectable().isConnected();
            boolean isConnectedAtPowerOn =
                  devicearr.getConnectable().isStartConnected();

            boolean isRemote = false;
            String deviceName = "";
            String imgPath = "";

            if (devicearr.getBacking() instanceof VirtualFloppyRemoteDeviceBackingInfo) {
               isRemote = true;
               deviceName =
                     ((VirtualFloppyRemoteDeviceBackingInfo) devicearr
                           .getBacking()).getDeviceName();
            }

            if (devicearr.getBacking() instanceof VirtualFloppyDeviceBackingInfo) {
               deviceName =
                     ((VirtualFloppyDeviceBackingInfo) devicearr.getBacking())
                           .getDeviceName();
            }

            if (devicearr.getBacking() instanceof VirtualFloppyImageBackingInfo) {
               imgPath =
                     ((VirtualFloppyImageBackingInfo) devicearr.getBacking())
                           .getFileName();
            }
            System.out.println("Image Path              : " + imgPath);
            System.out.println("Device                  : " + deviceName);
            System.out.println("Remote                  : " + isRemote);
            System.out.println("Connected               : " + isconnected);
            System.out.println("ConnectedAtPowerOn      : "
                  + isConnectedAtPowerOn);
            System.out.println("Id                      : " + "VirtualMachine-"
                  + vmRef.getValue() + "/" + key);
            System.out.println("Name                    : " + "Floppy/" + name);
            System.out.println("---------------------------------------------");
            count++;
         }
      }
      if (count == 0) {
         System.out.println("No Floppy device attached to this VM.");
      }
   }

   private static void addFloppy() throws ConcurrentAccessFaultMsg,
         DuplicateNameFaultMsg, FileFaultFaultMsg,
         InsufficientResourcesFaultFaultMsg, InvalidDatastoreFaultMsg,
         InvalidNameFaultMsg, InvalidStateFaultMsg, RuntimeFaultFaultMsg,
         TaskInProgressFaultMsg, VmConfigFaultFaultMsg,
         InvalidPropertyFaultMsg, InvalidCollectorVersionFaultMsg {
      if (remote == null) {
         remote = "false";
      }
      if (startConnected == null) {
         startConnected = "false";
      }
      if (setConnect == null) {
         setConnect = "false";
      }

      VirtualMachineConfigSpec configSpec = new VirtualMachineConfigSpec();
      List<VirtualDeviceConfigSpec> deviceConfigSpecArr =
            new ArrayList<VirtualDeviceConfigSpec>();

      VirtualDeviceConfigSpec deviceConfigSpec = new VirtualDeviceConfigSpec();
      VirtualFloppy floppyDev = new VirtualFloppy();
      floppyDev.setKey(-1);


      VirtualDeviceConnectInfo cInfo = new VirtualDeviceConnectInfo();
      if (setConnect != null) {
         cInfo.setConnected(Boolean.valueOf(setConnect));
      }

      if (startConnected != null) {
         cInfo.setStartConnected(Boolean.valueOf(startConnected));
      }

      floppyDev.setConnectable(cInfo);

      if (remote.equalsIgnoreCase("true")) {
         VirtualFloppyRemoteDeviceBackingInfo backingInfo =
               new VirtualFloppyRemoteDeviceBackingInfo();
         backingInfo.setDeviceName("/dev/fd0");
         floppyDev.setBacking(backingInfo);
      } else if (imagePath != null) {
         VirtualFloppyImageBackingInfo backingInfo =
               new VirtualFloppyImageBackingInfo();
         backingInfo.setFileName(imagePath);
         floppyDev.setBacking(backingInfo);
      } else if (device != null) {
         VirtualFloppyDeviceBackingInfo backingInfo =
               new VirtualFloppyDeviceBackingInfo();
         backingInfo.setDeviceName(device);
         floppyDev.setBacking(backingInfo);
      } else {
         throw new IllegalArgumentException(
               "Plese specify the --imgpath or --device option if --remote "
                     + "is either omitted or set to false while adding a floppy\n");
      }

      deviceConfigSpec.setDevice(floppyDev);
      deviceConfigSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);

      deviceConfigSpecArr.add(deviceConfigSpec);
      configSpec.getDeviceChange().addAll(deviceConfigSpecArr);

      ManagedObjectReference task = vimPort.reconfigVMTask(vmRef, configSpec);
      if (getTaskResultAfterDone(task)) {
         System.out.printf(" Reconfiguring the Virtual "
               + "Machine  - [ %s ] Successful on %s%n", virtualmachinename,
               operation);
      } else {
         System.out.printf(" Reconfiguring the Virtual Machine  "
               + "- [ %s ] Failure on %s%n", virtualmachinename, operation);
      }
   }

   private static void removeFloppy() throws Exception {
      if (label == null) {
         System.out.println("Option label is required for remove option");
         return;
      }
      List<VirtualDevice> deviceArr =
            ((ArrayOfVirtualDevice) getEntityProps(vmRef,
                  new String[] { "config.hardware.device" }).get(
                  "config.hardware.device")).getVirtualDevice();
      VirtualDevice floppy = null;

      for (VirtualDevice device : deviceArr) {
         if (device instanceof VirtualFloppy) {
            Description info = device.getDeviceInfo();
            if (info != null) {
               if (info.getLabel().equalsIgnoreCase(label)) {
                  floppy = device;
                  break;
               }
            }
         }
      }
      if (floppy == null) {
         System.out.println("Specified Device Not Found");
         return;
      }

      VirtualMachineConfigSpec configSpec = new VirtualMachineConfigSpec();
      List<VirtualDeviceConfigSpec> deviceConfigSpecArr =
            new ArrayList<VirtualDeviceConfigSpec>();

      VirtualDeviceConfigSpec deviceConfigSpec = new VirtualDeviceConfigSpec();
      deviceConfigSpec.setDevice(floppy);
      deviceConfigSpec.setOperation(VirtualDeviceConfigSpecOperation.REMOVE);

      deviceConfigSpecArr.add(deviceConfigSpec);
      configSpec.getDeviceChange().addAll(deviceConfigSpecArr);

      ManagedObjectReference task = vimPort.reconfigVMTask(vmRef, configSpec);
      if (getTaskResultAfterDone(task)) {
         System.out.printf(" Reconfiguring the Virtual "
               + "Machine  - [ %s ] Successful on %s%n", virtualmachinename,
               operation);
      } else {
         System.out.printf(" Reconfiguring the Virtual Machine  "
               + "- [ %s ] Failure on %s%n", virtualmachinename, operation);
      }
   }

   private static void setFloppy() throws Exception {
      if (label == null) {
         System.out.println("Option label is required for set option");
         return;
      }

      if (remote == null) {
         remote = "false";
      }

      if (startConnected == null) {
         startConnected = "false";
      }

      if (setConnect == null) {
         setConnect = "false";
      }

      VirtualMachineConfigSpec configSpec = new VirtualMachineConfigSpec();
      List<VirtualDeviceConfigSpec> deviceConfigSpecArr =
            new ArrayList<VirtualDeviceConfigSpec>();

      VirtualDeviceConfigSpec deviceConfigSpec = new VirtualDeviceConfigSpec();

      List<VirtualDevice> deviceArr =
            ((ArrayOfVirtualDevice) getEntityProps(vmRef,
                  new String[] { "config.hardware.device" }).get(
                  "config.hardware.device")).getVirtualDevice();
      VirtualDevice floppy = null;

      for (VirtualDevice device : deviceArr) {
         if (device instanceof VirtualFloppy) {
            Description info = device.getDeviceInfo();
            if (info != null) {
               if (info.getLabel().equalsIgnoreCase(label)) {
                  floppy = device;
                  break;
               }
            }
         }
      }
      if (floppy == null) {
         System.out.println("Specified Device Not Found");
         return;
      }

      VirtualDeviceConnectInfo cInfo = new VirtualDeviceConnectInfo();
      if (setConnect != null) {
         cInfo.setConnected(Boolean.valueOf(setConnect));
      }

      if (startConnected != null) {
         cInfo.setStartConnected(Boolean.valueOf(startConnected));
      }

      floppy.setConnectable(cInfo);

      if (remote.equalsIgnoreCase("true")) {
         VirtualFloppyRemoteDeviceBackingInfo backingInfo =
               new VirtualFloppyRemoteDeviceBackingInfo();
         backingInfo.setDeviceName("/dev/fd0");
         floppy.setBacking(backingInfo);
      } else if (imagePath != null) {
         VirtualFloppyImageBackingInfo backingInfo =
               new VirtualFloppyImageBackingInfo();
         backingInfo.setFileName(imagePath);
         floppy.setBacking(backingInfo);
      } else if (device != null) {
         VirtualFloppyDeviceBackingInfo backingInfo =
               new VirtualFloppyDeviceBackingInfo();
         backingInfo.setDeviceName(device);
         floppy.setBacking(backingInfo);
      }
      deviceConfigSpec.setDevice(floppy);
      deviceConfigSpec.setOperation(VirtualDeviceConfigSpecOperation.EDIT);

      deviceConfigSpecArr.add(deviceConfigSpec);
      configSpec.getDeviceChange().addAll(deviceConfigSpecArr);

      ManagedObjectReference task = vimPort.reconfigVMTask(vmRef, configSpec);
      if (getTaskResultAfterDone(task)) {
         System.out.printf(" Reconfiguring the Virtual "
               + "Machine  - [ %s ] Successful on %s%n", virtualmachinename,
               operation);
      } else {
         System.out.printf(" Reconfiguring the Virtual Machine  "
               + "- [ %s ] Failure on %s%n", virtualmachinename, operation);
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
            .println("This sample adds / removes floppy to / from an existing VM");
      System.out.println("This sample lists information about a VMs Floppies");
      System.out
            .println("This sample updates an existing floppy drive on a VM");
      System.out.println("\nParameters:");
      System.out
            .println("url               [required] : url of the web service");
      System.out
            .println("username          [required] : username for the authentication");
      System.out
            .println("password          [required] : password for the authentication");
      System.out.println("vmname            [required] : "
            + "name of the virtual machine");
      System.out.println("operation         [required] : "
            + "operation type - [get|add|remove|set]");
      System.out.println("imgpath           [optional] : "
            + "path of image file");
      System.out.println("remote            [optional] : "
            + "device is a remote or client device or iso");
      System.out.println("startconnected    [optional] : "
            + "virtual floppy starts connected on VM poweron");
      System.out.println("connect           [optional] : "
            + "virtual floppy is connected");
      System.out.println("                               "
            + "Set only if the VM is powered on");
      System.out.println("label             [optional] : "
            + "used to find the device.key value");
      System.out.println("device            [optional] : "
            + "path to the floppy on the VM's host");
      System.out.println("\nCommand:");
      System.out.println("Get Floppy Info");
      System.out
            .println("run.bat com.vmware.vm.VMManageFloppy "
                  + "--url [webserviceurl] --username [username] --password  [password]");
      System.out.println("--operation get --vmname [Virtual Machine Name]");
      System.out.println("Add Floppy");
      System.out
            .println("run.bat com.vmware.vm.VMManageFloppy "
                  + "--url [webserviceurl] --username [username] --password [password]");
      System.out.println("--operation add --vmname [Virtual Machine Name] "
            + "--imgpath test.flp --remote false --connect true");
      System.out.println("Remove Floppy");
      System.out
            .println("run.bat com.vmware.vm.VMManageFloppy "
                  + "--url [webserviceurl] --username [username] --password  [password]");
      System.out.println("--operation remove --vmname [Virtual Machine Name] "
            + "--label Floppy Drive 1");
      System.out.println("Reconfigure Floppy");
      System.out
            .println("run.bat com.vmware.vm.VMManageFloppy "
                  + "--url [webserviceurl] --username [username] --password  [password]");
      System.out.println("--operation set --vmname [Virtual Machine Name] "
            + "--label Floppy Drive 1 --connect false");
   }

   public static void main(String[] args) {

      try {
         getConnectionParameters(args);
         getInputParameters(args);
         if (help) {
            printUsage();
            return;
         }
         if (validateTheInput()) {
            connect();
            doOperation();
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
