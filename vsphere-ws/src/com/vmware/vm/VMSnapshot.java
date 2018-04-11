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
import com.vmware.vim25.FileFaultFaultMsg;
import com.vmware.vim25.InvalidCollectorVersionFaultMsg;
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
import com.vmware.vim25.SnapshotFaultFaultMsg;
import com.vmware.vim25.TaskInProgressFaultMsg;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VirtualMachineSnapshotInfo;
import com.vmware.vim25.VirtualMachineSnapshotTree;
import com.vmware.vim25.VmConfigFaultFaultMsg;

/**
 * <pre>
 * VMSnapshot
 * 
 * This sample demonstrates VM snapshot operations
 * 
 * <b>Parameters:</b>
 * url            [required] : url of the web service.
 * username       [required] : username for the authentication
 * password       [required] : password for the authentication
 * vmname         [required] : Name of the virtual machine
 * operation      [required] : operation type - [list|create|remove|revert]
 * snapshotname   [optional] : Name of the snapshot
 * description    [optional] : description of the sanpshot
 * removechild    [optional] : remove snapshot children - [1 | 0]
 * 
 * <b>Command Line:</b>
 * List VM snapshot names
 * run.bat com.vmware.vm.VMSnapshot
 * --url [webserviceurl] --username [username] --password  [password]
 * --vmname [vmname] --operation list
 * 
 * Create VM snapshot
 * run.bat com.vmware.vm.VMSnapshot
 * --url [webserviceurl] --username [username] --password  [password]
 * --vmname [vmname] --operation create
 * --description [Description of the snapshot]
 * 
 * Revert VM snapshot
 * run.bat com.vmware.vm.VMSnapshot
 * --url [webserviceurl] --username [username] --password  [password]
 * --vmname [vmname] --operation revert --description [Snapshot Description]
 * 
 * Remove VM snapshot
 * run.bat com.vmware.vm.VMSnapshot
 * --url [webserviceurl] --username [username] --password  [password]
 * --vmname [vmname] --operation remove --removechild 0
 * </pre>
 */

public class VMSnapshot {

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
   private static String virtualMachineName;
   private static String operation;
   private static String snapshotname;
   private static String description;
   private static String removechild;

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
         } else if (param.equalsIgnoreCase("--operation")
               && !val.startsWith("--") && !val.isEmpty()) {
            operation = val;
         } else if (param.equalsIgnoreCase("--snapshotname")
               && !val.startsWith("--") && !val.isEmpty()) {
            snapshotname = val;
         } else if (param.equalsIgnoreCase("--description")
               && !val.startsWith("--") && !val.isEmpty()) {
            description = val;
         } else if (param.equalsIgnoreCase("--removechild")
               && !val.startsWith("--") && !val.isEmpty()) {
            removechild = val;
         }
         val = "";
         ai += 2;
      }
      if (virtualMachineName == null || operation == null) {
         throw new IllegalArgumentException(
               "Expected --operation and --vmname argument.");
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
      oSpec.setSkip(false);
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
      propertySpec.setAll(false);
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
      objectSpec.setSkip(true);
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
      propertySpec.setAll(false);
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

   private static boolean createSnapshot(ManagedObjectReference vmMor)
         throws FileFaultFaultMsg, InvalidNameFaultMsg, InvalidStateFaultMsg,
         RuntimeFaultFaultMsg, SnapshotFaultFaultMsg, TaskInProgressFaultMsg,
         VmConfigFaultFaultMsg, InvalidPropertyFaultMsg,
         InvalidCollectorVersionFaultMsg {
      ManagedObjectReference taskMor =
            vimPort.createSnapshotTask(vmMor, snapshotname, description, false,
                  false);
      if (getTaskResultAfterDone(taskMor)) {
         System.out.printf(" Creating Snapshot - [ %s ] Successful %n",
               snapshotname);
         return true;
      } else {
         System.out.printf(" Creating Snapshot - [ %s ] Failure %n",
               snapshotname);
         return false;
      }
   }

   private static boolean listSnapshot(ManagedObjectReference vmMor)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
      VirtualMachineSnapshotInfo snapInfo =
            (VirtualMachineSnapshotInfo) getEntityProps(vmMor,
                  new String[] { "snapshot" }).get("snapshot");
      if (snapInfo == null) {
         System.out.println("No Snapshots found");
      } else {
         List<VirtualMachineSnapshotTree> listvmsht =
               snapInfo.getRootSnapshotList();
         traverseSnapshotInTree(listvmsht, null, true);
      }
      return true;
   }

   private static boolean revertSnapshot(ManagedObjectReference vmMor)
         throws Exception {
      ManagedObjectReference snapmor =
            getSnapshotReference(vmMor, virtualMachineName, snapshotname);
      if (snapmor != null) {
         ManagedObjectReference taskMor =
               vimPort.revertToSnapshotTask(snapmor, null, true);
         if (getTaskResultAfterDone(taskMor)) {
            System.out.printf(" Reverting Snapshot - [ %s ] Successful %n",
                  snapshotname);
            return true;
         } else {
            System.out.printf(" Reverting Snapshot - [ %s ] Failure %n",
                  snapshotname);
            return false;
         }
      } else {
         System.out.println("Snapshot not found");
      }
      return false;
   }

   private static boolean removeAllSnapshot(ManagedObjectReference vmMor)
         throws Exception {
      ManagedObjectReference taskMor =
            vimPort.removeAllSnapshotsTask(vmMor, true);
      if (taskMor != null) {
         String[] opts =
               new String[] { "info.state", "info.error", "info.progress" };
         String[] opt = new String[] { "state" };
         Object[] results =
               waitForValues(taskMor, opts, opt, new Object[][] { new Object[] {
                     TaskInfoState.SUCCESS, TaskInfoState.ERROR } });

         // Wait till the task completes.
         if (results[0].equals(TaskInfoState.SUCCESS)) {
            System.out.printf(
                  " Removing All Snapshots on - [ %s ] Successful %n",
                  virtualMachineName);
            return true;
         } else {
            System.out.printf(" Removing All Snapshots on - [ %s ] Failure %n",
                  virtualMachineName);
            return false;
         }
      } else {
         return false;
      }
   }

   private static boolean removeSnapshot(ManagedObjectReference vmMor)
         throws Exception {
      int rem = Integer.parseInt(removechild);
      boolean flag = true;
      if (rem == 0) {
         flag = false;
      }
      ManagedObjectReference snapmor =
            getSnapshotReference(vmMor, virtualMachineName, snapshotname);
      if (snapmor != null) {
         ManagedObjectReference taskMor =
               vimPort.removeSnapshotTask(snapmor, flag, true);
         if (taskMor != null) {
            String[] opts =
                  new String[] { "info.state", "info.error", "info.progress" };
            String[] opt = new String[] { "state" };
            Object[] results =
                  waitForValues(taskMor, opts, opt,
                        new Object[][] { new Object[] { TaskInfoState.SUCCESS,
                              TaskInfoState.ERROR } });

            // Wait till the task completes.
            if (results[0].equals(TaskInfoState.SUCCESS)) {
               System.out.printf(" Removing Snapshot - [ %s ] Successful %n",
                     snapshotname);
               return true;
            } else {
               System.out.printf(" Removing Snapshot - [ %s ] Failure %n",
                     snapshotname);
               return false;
            }
         }
      } else {
         System.out.println("Snapshot not found");
      }
      return false;
   }

   private static ManagedObjectReference traverseSnapshotInTree(
         List<VirtualMachineSnapshotTree> snapTree, String findName,
         boolean print) {
      ManagedObjectReference snapmor = null;
      if (snapTree == null) {
         return snapmor;
      }
      for (VirtualMachineSnapshotTree node : snapTree) {
         if (print) {
            System.out.println("Snapshot Name : " + node.getName());
         }
         if (findName != null && node.getName().equalsIgnoreCase(findName)) {
            return node.getSnapshot();
         } else {
            List<VirtualMachineSnapshotTree> listvmst =
                  node.getChildSnapshotList();
            List<VirtualMachineSnapshotTree> childTree = listvmst;
            snapmor = traverseSnapshotInTree(childTree, findName, print);
         }
      }
      return snapmor;
   }

   private static ManagedObjectReference getSnapshotReference(
         ManagedObjectReference vmmor, String vmName, String snapName)
         throws Exception {
      VirtualMachineSnapshotInfo snapInfo =
            (VirtualMachineSnapshotInfo) getEntityProps(vmmor,
                  new String[] { "snapshot" }).get("snapshot");
      ManagedObjectReference snapmor = null;
      if (snapInfo != null) {
         List<VirtualMachineSnapshotTree> listvmst =
               snapInfo.getRootSnapshotList();
         snapmor = traverseSnapshotInTree(listvmst, snapName, false);
         if (snapmor == null) {
            System.out.println("No Snapshot named : " + snapName
                  + " found for VirtualMachine : " + vmName);
         }
      } else {
         System.out
               .println("No Snapshots found for VirtualMachine : " + vmName);
      }
      return snapmor;
   }

   private static boolean isOptionSet(String test) {
      return (test == null) ? false : true;
   }

   private static boolean verifyInputArguments() throws Exception {
      boolean flag = true;
      String op = operation;
      if (op.equalsIgnoreCase("create")) {
         if ((!isOptionSet(snapshotname)) || (!isOptionSet(description))) {
            System.out.println("For Create operation SnapshotName"
                  + " and Description are the Mandatory options");
            flag = false;
         }
      }
      if (op.equalsIgnoreCase("remove")) {
         if ((!isOptionSet(snapshotname)) || (!isOptionSet(removechild))) {
            System.out.println("For Remove operation Snapshotname"
                  + " and removechild are the Mandatory option");
            flag = false;
         } else {
            int child = Integer.parseInt(removechild);
            if (child != 0 && child != 1) {
               System.out.println("Value of removechild parameter"
                     + " must be either 0 or 1");
               flag = false;
            }
         }
      }
      if (op.equalsIgnoreCase("revert")) {
         if ((!isOptionSet(snapshotname))) {
            System.out.println("For Revert operation SnapshotName"
                  + " is the Mandatory option");
            flag = false;
         }
      }
      return flag;
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
      System.out.println("This sample demonstrates VM snapshot operations");
      System.out.println("\nParameters:");
      System.out.println("url            [required] : url of the web service.");
      System.out
            .println("username       [required] : username for the authentication");
      System.out
            .println("password       [required] : password for the authentication");
      System.out
            .println("vmname         [required] : Name of the virtual machine");
      System.out
            .println("operation      [required] : operation type - [list|create|remove|revert]");
      System.out.println("snapshotname   [optional] : Name of the snapshot");
      System.out
            .println("description    [optional] : description of the sanpshot");
      System.out
            .println("removechild    [optional] : remove snapshot children - [1 | 0]");
      System.out.println("\nCommand:");
      System.out.println("List VM snapshot names");
      System.out
            .println("run.bat com.vmware.vm.VMSnapshot "
                  + "--url [webserviceurl] --username [username] --password  [password]");
      System.out.println("--vmname [vmname] --operation list");
      System.out.println("Create VM snapshot");
      System.out
            .println("run.bat com.vmware.vm.VMSnapshot "
                  + "--url [webserviceurl] --username [username] --password  [password]");
      System.out.println("--vmname [vmname] --operation create");
      System.out.println("--description [Description of the snapshot]");
      System.out.println("Revert VM snapshot");
      System.out
            .println("run.bat com.vmware.vm.VMSnapshot "
                  + "--url [webserviceurl] --username [username] --password  [password]");
      System.out.println("--vmname [vmname] --operation revert");
      System.out.println("--description [Snapshot Description]");
      System.out.println("Remove VM snapshot");
      System.out
            .println("run.bat com.vmware.vm.VMSnapshot "
                  + "--url [webserviceurl] --username [username] --password  [password]");
      System.out.println("--vmname [vmname] "
            + "--operation remove --removechild 0");
   }

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         getInputParameters(args);
         if (help) {
            printUsage();
            return;
         }
         boolean valid = false;
         valid = verifyInputArguments();
         if (!valid) {
            printUsage();
            return;
         }
         connect();
         ManagedObjectReference vmRef =
               getMOREFsInContainerByType(serviceContent.getRootFolder(),
                     "VirtualMachine").get(virtualMachineName);

         if (vmRef != null) {
            boolean res = false;
            if (operation.equalsIgnoreCase("create")) {
               res = createSnapshot(vmRef);
            } else if (operation.equalsIgnoreCase("list")) {
               res = listSnapshot(vmRef);
            } else if (operation.equalsIgnoreCase("revert")) {
               res = revertSnapshot(vmRef);
            } else if (operation.equalsIgnoreCase("removeall")) {
               res = removeAllSnapshot(vmRef);
            } else if (operation.equalsIgnoreCase("remove")) {
               res = removeSnapshot(vmRef);
            } else {
               System.out.println("Invalid operation [create|list|"
                     + "revert|removeall|remove]");
            }
            if (res) {
               System.out.println("Operation " + operation
                     + "snapshot completed sucessfully");
            }
         } else {
            System.out.println("Virtual Machine " + virtualMachineName
                  + " not found.");
            return;
         }
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
         printUsage();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception ex) {
         ex.printStackTrace();
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
