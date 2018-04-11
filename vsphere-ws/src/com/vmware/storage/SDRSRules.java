package com.vmware.storage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.soap.SOAPException;
import javax.xml.ws.BindingProvider;

import com.vmware.vim25.ArrayUpdateOperation;
import com.vmware.vim25.ClusterAntiAffinityRuleSpec;
import com.vmware.vim25.ClusterRuleInfo;
import com.vmware.vim25.ClusterRuleSpec;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.InvalidCollectorVersionFaultMsg;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.LocalizedMethodFault;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.ObjectUpdate;
import com.vmware.vim25.ObjectUpdateKind;
import com.vmware.vim25.PodStorageDrsEntry;
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
import com.vmware.vim25.StorageDrsConfigSpec;
import com.vmware.vim25.StorageDrsPodConfigSpec;
import com.vmware.vim25.StorageDrsVmConfigInfo;
import com.vmware.vim25.StorageDrsVmConfigSpec;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDiskAntiAffinityRuleSpec;
import com.vmware.vim25.VirtualMachineConfigInfo;

/**
 * <pre>
 * This sample demonstrates how to Add/List/Modify/Delete the rules for an
 *  existing SDRS cluster.
 * Parameters:
 * url                       [required]: url of the web service.
 * username                  [required]: username for the authentication
 * Password                  [required]: password for the authentication
 * podname                   [required]: StoragePod name.
 * option                    [required]:  valid option are "addVmAntiAffinity",
 *                           "addVmdkAntiAffinity", "list", "modifyVmAntiAffinity",
 *                           "modifyVmdkAntiAffinity", "deleteVmAntiAffinity" and
 *                           "deleteVmdkAntiAffinity".
 * rulename                  Rule name.
 * vmlist                    Comma separated, list of VM name. It is required while
 *                           adding VmAntiAffinity Rule.
 * newrulename               New name for rule while modifying
 * enable                    Flag to indicate whether or not the rule is enabled.
 * vmname                    virtual machine name.
 * 
 * <b>Sample usage:</b>
 * addVmAntiAffinity Rule:
 * run.bat com.vmware.storage.SDRSRules --url [URLString] --username [User] --password
 * [Password] --option addVmAntiAffinity --podname [podname] --rulename [rulename]
 *  --enable [enable] --vmlist [vmlist]
 * 
 * addVmdkAntiAffinity Rule:
 * run.bat com.vmware.storage.SDRSRules --url [URLString] --username [User] --password
 *  [Password] --option addVmdkAntiAffinity --podname [podname] --rulename [rulename]
 *   --enable [enable] --vmname [vmname]
 * 
 * List Rules:
 * run.bat com.vmware.storage.SDRSRules --url [URLString] --username [User] --password
 *  [Password] --option list --podname [podname]
 * 
 * modifyVmAntiAffinity Rule:
 * run.bat com.vmware.storage.SDRSRules --url [URLString] --username [User] --password
 *  [Password] --option modifyVmAntiAffinity  --podname [podname]  --rulename [rulename]
 *  --enable [enable] --vmname [vmname] --newrulename [newrulename]
 * 
 * modifyVmdkAntiAffinity Rule:
 * run.bat com.vmware.storage.SDRSRules --url [URLString] --username [User] --password
 *  [Password] --option modifyVmdkAntiAffinity --podname [podname] --rulename [rulename]
 *  --enable [enable] --newrulename [newrulename]
 * 
 * deleteVmAntiAffinity Rule:
 * run.bat com.vmware.storage.SDRSRules --url [URLString] --username [User] --password
 *  [Password] --option deleteVmAntiAffinity --podname [podname] --rulename [rulename]
 * 
 * deleteVmdkAntiAffinity Rule:
 * run.bat com.vmware.storage.SDRSRules --url [URLString] --username [User] --password
 *  [Password] --option deleteVmdkAntiAffinity  --podname [podname] --rulename [rulename]
 * 
 * NOTE: All the virtual disks will be added while adding Vmdk AntiAffinity Rule.
 * </pre>
 */
public class SDRSRules {

   /**
    * The Class TrustAllTrustManager.
    */
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
   private static ManagedObjectReference propCollectorRef = null;
   private static ManagedObjectReference rootRef = null;

   /* Connection input parameters*/
   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
   private static String option = null;
   private static String storagePodName = null;
   private static String ruleName = null;
   private static String newRuleName = null;
   private static String enabled = null;
   private static String vmName = null;
   private static String vmList = null;
   private static List<String> vm = new ArrayList<String>();
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

   // Get common parameters
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

   // Get input parameters to run the sample
   private static void getInputParameters(String[] args) {
      int ai = 0;
      String param = "";
      String val = "";
      while (ai < args.length) {
         param = args[ai].trim();
         if (ai + 1 < args.length) {
            val = args[ai + 1].trim();
         }
         if (param.equalsIgnoreCase("--podname") && !val.startsWith("--")
               && !val.isEmpty()) {
            storagePodName = val;
         } else if (param.equalsIgnoreCase("--option") && !val.startsWith("--")
               && !val.isEmpty()) {
            option = val;
         } else if (param.equalsIgnoreCase("--rulename")
               && !val.startsWith("--") && !val.isEmpty()) {
            ruleName = val;
         } else if (param.equalsIgnoreCase("--enable") && !val.startsWith("--")
               && !val.isEmpty()) {
            enabled = val;
         } else if (param.equalsIgnoreCase("--vmname") && !val.startsWith("--")
               && !val.isEmpty()) {
            vmName = val;
         } else if (param.equalsIgnoreCase("--vmlist") && !val.startsWith("--")
               && !val.isEmpty()) {
            vmList = val;
         } else if (param.equalsIgnoreCase("--newrulename")
               && !val.startsWith("--") && !val.isEmpty()) {
            newRuleName = val;
         }
         val = "";
         ai += 2;
      }
      if (storagePodName == null || option == null) {
         throw new IllegalArgumentException(
               "Expected --podname, --option arguments.");
      }
      if (option.equalsIgnoreCase("addVmAntiAffinity")) {
         if (ruleName == null || enabled == null || vmList == null) {
            throw new IllegalArgumentException(
                  "Expected --rulename, --enable and" + " --vmlist arguments.");
         }
         if (vmList.indexOf(",") <= -1) {
            throw new IllegalArgumentException("Expected --vmlist. List of VM"
                  + " name seperated by comma.");
         }
         StringTokenizer st = new StringTokenizer(vmList, ",");
         while (st.hasMoreElements()) {
            vm.add(st.nextElement().toString());
         }
      }
      if (option.equalsIgnoreCase("addVmdkAntiAffinity")) {
         if (ruleName == null || enabled == null || vmName == null) {
            throw new IllegalArgumentException(
                  "Expected --rulename, --enable and" + " --vmname arguments.");
         }
      }
      if (option.equalsIgnoreCase("modifyVmAntiAffinity")
            || option.equalsIgnoreCase("modifyVmdkAntiAffinity")
            || option.equalsIgnoreCase("deleteVmAntiAffinity")
            || option.equalsIgnoreCase("deleteVmdkAntiAffinity")) {
         if (ruleName == null) {
            throw new IllegalArgumentException("Expected --rulename argument.");
         }
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
      rootRef = serviceContent.getRootFolder();
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
    * Uses the new RetrievePropertiesEx method to emulate the now Depreciated
    * RetrieveProperties method.
    * 
    * @param listpfs
    * @return list of object content
    * @throws Exception
    */
   private static List<ObjectContent> retrievePropertiesAllObjects(
         List<PropertyFilterSpec> listpfs) {
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
      } catch (Exception e) {
         System.out.println(" : Failed Getting Contents");
         e.printStackTrace();
      }

      return listobjcontent;
   }

   /**
    * Retrieve contents for a single object based on the property collector
    * registered with the service.
    * 
    * @param collector
    *           Property collector registered with service
    * @param mobj
    *           Managed Object Reference to get contents for
    * @param properties
    *           names of properties of object to retrieve
    * 
    * @return retrieved object contents
    */
   private static ObjectContent[] getObjectProperties(
         ManagedObjectReference mobj, String[] properties) {
      if (mobj == null) {
         return null;
      }
      PropertyFilterSpec spec = new PropertyFilterSpec();
      spec.getPropSet().add(new PropertySpec());
      if ((properties == null || properties.length == 0)) {
         spec.getPropSet().get(0).setAll(Boolean.TRUE);
      } else {
         spec.getPropSet().get(0).setAll(Boolean.FALSE);
      }
      spec.getPropSet().get(0).setType(mobj.getType());
      spec.getPropSet().get(0).getPathSet().addAll(Arrays.asList(properties));
      spec.getObjectSet().add(new ObjectSpec());
      spec.getObjectSet().get(0).setObj(mobj);
      spec.getObjectSet().get(0).setSkip(Boolean.FALSE);
      List<PropertyFilterSpec> listpfs = new ArrayList<PropertyFilterSpec>(1);
      listpfs.add(spec);
      List<ObjectContent> listobcont = retrievePropertiesAllObjects(listpfs);
      return listobcont.toArray(new ObjectContent[listobcont.size()]);
   }

   /**
    * Determines of a method 'methodName' exists for the Object 'obj'.
    * 
    * @param obj
    *           The Object to check
    * @param methodName
    *           The method name
    * @param parameterTypes
    *           Array of Class objects for the parameter types
    * @return true if the method exists, false otherwise
    */
   @SuppressWarnings("rawtypes")
   private static boolean methodExists(Object obj, String methodName,
         Class[] parameterTypes) {
      boolean exists = false;
      try {
         Method method = obj.getClass().getMethod(methodName, parameterTypes);
         if (method != null) {
            exists = true;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return exists;
   }

   /**
    * Retrieve a single object.
    * 
    * @param mor
    *           Managed Object Reference to get contents for
    * @param propertyName
    *           of the object to retrieve
    * 
    * @return retrieved object
    * @throws NoSuchMethodException
    * @throws SecurityException
    * @throws InvocationTargetException
    * @throws IllegalAccessException
    * @throws IllegalArgumentException
    */
   private static Object getDynamicProperty(ManagedObjectReference mor,
         String propertyName) throws SecurityException, NoSuchMethodException,
         IllegalArgumentException, IllegalAccessException,
         InvocationTargetException {
      ObjectContent[] objContent =
            getObjectProperties(mor, new String[] { propertyName });

      Object propertyValue = null;
      if (objContent != null) {
         List<DynamicProperty> listdp = objContent[0].getPropSet();
         if (listdp != null) {
            /*
             * Check the dynamic propery for ArrayOfXXX object
             */
            Object dynamicPropertyVal = listdp.get(0).getVal();
            String dynamicPropertyName =
                  dynamicPropertyVal.getClass().getName();
            if (dynamicPropertyName.indexOf("ArrayOf") != -1) {
               String methodName =
                     dynamicPropertyName.substring(
                           dynamicPropertyName.indexOf("ArrayOf")
                                 + "ArrayOf".length(),
                           dynamicPropertyName.length());
               /*
                * If object is ArrayOfXXX object, then get the xxx[] by
                * invoking getXXX() on the object.
                * For Ex:
                * ArrayOfManagedObjectReference.getManagedObjectReference()
                * returns ManagedObjectReference[] array.
                */
               if (methodExists(dynamicPropertyVal, "get" + methodName, null)) {
                  methodName = "get" + methodName;
               } else {
                  /*
                   * Construct methodName for ArrayOf primitive types
                   * Ex: For ArrayOfInt, methodName is get_int
                   */
                  methodName = "get_" + methodName.toLowerCase();
               }
               Method getMorMethod =
                     dynamicPropertyVal.getClass().getDeclaredMethod(
                           methodName, (Class[]) null);
               propertyValue =
                     getMorMethod.invoke(dynamicPropertyVal, (Object[]) null);
            } else if (dynamicPropertyVal.getClass().isArray()) {
               /*
                * Handle the case of an unwrapped array being deserialized.
                */
               propertyValue = dynamicPropertyVal;
            } else {
               propertyValue = dynamicPropertyVal;
            }
         }
      }
      return propertyValue;
   }

   /**
    * 
    * @return An array of SelectionSpec for traversing DatastoreFolder and VM.
    */
   private static SelectionSpec[] buildTraversal() {

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
      hToVm.setName("HToVm");
      hToVm.setSkip(Boolean.FALSE);

      // DC -> DS
      TraversalSpec dcToDs = new TraversalSpec();
      dcToDs.setType("Datacenter");
      dcToDs.setPath("datastore");
      dcToDs.setName("dcToDs");
      dcToDs.setSkip(Boolean.FALSE);

      // For RP -> RP recursion
      SelectionSpec rpToRpSpec = new SelectionSpec();
      rpToRpSpec.setName("rpToRp");

      // Recurse through all ResourcePools
      TraversalSpec rpToRp = new TraversalSpec();
      rpToRp.setType("ResourcePool");
      rpToRp.setPath("resourcePool");
      rpToRp.setSkip(Boolean.FALSE);
      rpToRp.setName("rpToRp");
      SelectionSpec[] sspecs = new SelectionSpec[] { rpToRpSpec };
      rpToRp.getSelectSet().addAll(Arrays.asList(sspecs));

      // For Folder -> Folder recursion
      SelectionSpec sspecvfolders = new SelectionSpec();
      sspecvfolders.setName("VisitFolders");

      TraversalSpec dcToHf = new TraversalSpec();
      dcToHf.setSkip(Boolean.FALSE);
      dcToHf.setType("Datacenter");
      dcToHf.setPath("hostFolder");
      dcToHf.setName("dcToHf");
      dcToHf.getSelectSet().add(sspecvfolders);

      TraversalSpec dcToVmf = new TraversalSpec();
      dcToVmf.setType("Datacenter");
      dcToVmf.setSkip(Boolean.FALSE);
      dcToVmf.setPath("vmFolder");
      dcToVmf.setName("dcToVmf");
      dcToVmf.getSelectSet().add(sspecvfolders);

      TraversalSpec dcToDf = new TraversalSpec();
      dcToDf.setType("Datacenter");
      dcToDf.setSkip(Boolean.FALSE);
      dcToDf.setPath("datastoreFolder");
      dcToDf.setName("dcToDf");
      dcToDf.getSelectSet().add(sspecvfolders);

      TraversalSpec visitFolders = new TraversalSpec();
      visitFolders.setType("Folder");
      visitFolders.setPath("childEntity");
      visitFolders.setSkip(Boolean.FALSE);
      visitFolders.setName("VisitFolders");
      List<SelectionSpec> sspecarrvf = new ArrayList<SelectionSpec>();
      sspecarrvf.add(dcToDf);
      sspecarrvf.add(dcToVmf);
      sspecarrvf.add(dcToHf);
      sspecarrvf.add(vAppToVM);
      sspecarrvf.add(dcToDs);
      sspecarrvf.add(rpToVm);
      sspecarrvf.add(sspecvfolders);
      visitFolders.getSelectSet().addAll(sspecarrvf);
      return new SelectionSpec[] { visitFolders };
   }

   /**
    * Getting the MOREF of the entity.
    */
   private static ManagedObjectReference getEntityByName(String entityName,
         String entityType) {
      ManagedObjectReference retVal = null;

      try {
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.setType(entityType);
         propertySpec.getPathSet().add("name");

         // Now create Object Spec
         ObjectSpec objectSpec = new ObjectSpec();
         objectSpec.setObj(rootRef);
         objectSpec.setSkip(Boolean.TRUE);
         objectSpec.getSelectSet().addAll(Arrays.asList(buildTraversal()));

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
               if (oc.getPropSet().get(0).getVal().equals(entityName)) {
                  retVal = oc.getObj();
                  break;
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return retVal;
   }

   /**
    * Add VmAntiAffinity Rule.
    * 
    * @param storagePodName
    *           StoragePod name.
    * @param ruleName
    *           Name of the rule to be added.
    * @param enabled
    *           Flag to indicate whether or not the rule is enabled.
    * @param vm
    *           list of VMs that needs to be added in the Rule
    * @throws RemoteException
    * @throws Exception
    */
   private static void addVmAntiAffinityRule(String storagePodName,
         String ruleName, String enabled, List<String> vm)
         throws RemoteException, Exception {
      ManagedObjectReference storageResourceManager =
            serviceContent.getStorageResourceManager();
      ManagedObjectReference storagePod =
            getEntityByName(storagePodName, "StoragePod");
      if (storagePod != null) {
         ManagedObjectReference vmMoref = null;
         StorageDrsConfigSpec sdrsConfigSpec = new StorageDrsConfigSpec();
         StorageDrsPodConfigSpec podConfigSpec = new StorageDrsPodConfigSpec();
         ClusterAntiAffinityRuleSpec vmAntiAffinityRuleSpec =
               new ClusterAntiAffinityRuleSpec();
         ClusterRuleSpec ruleSpec = new ClusterRuleSpec();
         vmAntiAffinityRuleSpec.setName(ruleName);
         if (enabled.equalsIgnoreCase("true")) {
            vmAntiAffinityRuleSpec.setEnabled(true);
         } else {
            vmAntiAffinityRuleSpec.setEnabled(false);
         }
         for (String vmname : vm) {
            vmMoref = getEntityByName(vmname, "VirtualMachine");
            if (vmMoref != null) {
               vmAntiAffinityRuleSpec.getVm().add(vmMoref);
            } else {
               String msg =
                     "\nFailure: Virtual Machine " + vmname + " not found.";
               throw new RuntimeException(msg);
            }
         }
         vmAntiAffinityRuleSpec.setUserCreated(true);
         vmAntiAffinityRuleSpec.setMandatory(false);
         ruleSpec.setInfo(vmAntiAffinityRuleSpec);
         ruleSpec.setOperation(ArrayUpdateOperation.ADD);
         podConfigSpec.getRule().add(ruleSpec);
         sdrsConfigSpec.setPodConfigSpec(podConfigSpec);
         ManagedObjectReference taskmor =
               vimPort.configureStorageDrsForPodTask(storageResourceManager,
                     storagePod, sdrsConfigSpec, true);
         if (getTaskResultAfterDone(taskmor)) {
            System.out.printf("\nSuccess: Adding VmAntiAffinity Rule.");
         } else {
            String msg = "\nFailure: Adding VmAntiAffinity Rule.";
            throw new RuntimeException(msg);
         }
      } else {
         String msg = "\nFailure: StoragePod " + storagePodName + " not found.";
         throw new RuntimeException(msg);
      }
   }

   /**
    * Add VmdkAntiAffinity Rule.
    * 
    * @param storagePodName
    *           StoragePod name.
    * @param ruleName
    *           Name of the rule to be added.
    * @param enabled
    *           Flag to indicate whether or not the rule is enabled.
    * @param vmName
    *           VM for which the rule needs to be added.
    * @throws RemoteException
    * @throws Exception
    */
   private static void addVmdkAntiAffinityRule(String storagePodName,
         String ruleName, String enabled, String vmName)
         throws RemoteException, Exception {
      ManagedObjectReference storageResourceManager =
            serviceContent.getStorageResourceManager();
      ManagedObjectReference storagePod =
            getEntityByName(storagePodName, "StoragePod");
      if (storagePod != null) {
         ManagedObjectReference vmMoref = null;
         StorageDrsConfigSpec sdrsConfigSpec = new StorageDrsConfigSpec();
         StorageDrsVmConfigSpec drsVmConfigSpec = new StorageDrsVmConfigSpec();
         StorageDrsVmConfigInfo drsVmConfigInfo = new StorageDrsVmConfigInfo();
         VirtualDiskAntiAffinityRuleSpec vmdkAntiAffinityRuleSpec =
               new VirtualDiskAntiAffinityRuleSpec();
         vmdkAntiAffinityRuleSpec.setName(ruleName);
         if (enabled.equalsIgnoreCase("true")) {
            vmdkAntiAffinityRuleSpec.setEnabled(true);
         } else {
            vmdkAntiAffinityRuleSpec.setEnabled(false);
         }
         vmMoref = getEntityByName(vmName, "VirtualMachine");
         if (vmMoref != null) {
            VirtualMachineConfigInfo vmConfigInfo =
                  (VirtualMachineConfigInfo) getDynamicProperty(vmMoref,
                        "config");
            List<VirtualDevice> vDevice =
                  vmConfigInfo.getHardware().getDevice();
            List<VirtualDevice> virtualDisk = new ArrayList<VirtualDevice>();
            for (VirtualDevice device : vDevice) {
               if (device.getClass().getSimpleName()
                     .equalsIgnoreCase("VirtualDisk")) {
                  virtualDisk.add(device);
                  vmdkAntiAffinityRuleSpec.getDiskId().add(device.getKey());
               }
            }
            if (virtualDisk.size() < 2) {
               throw new SOAPException(
                     "VM should have minimum of 2 virtual disks"
                           + " while adding VMDK AntiAffinity Rule.");
            }
            System.out.println("Adding below list of virtual disk to rule "
                  + ruleName + " :");
            for (VirtualDevice device : virtualDisk) {
               System.out.println("Virtual Disk : "
                     + device.getDeviceInfo().getLabel() + ", Key : "
                     + device.getKey());
            }
            vmdkAntiAffinityRuleSpec.setUserCreated(true);
            vmdkAntiAffinityRuleSpec.setMandatory(false);
            drsVmConfigInfo.setIntraVmAntiAffinity(vmdkAntiAffinityRuleSpec);
            drsVmConfigInfo.setVm(vmMoref);
         } else {
            String msg = "\nFailure: Virtual Machine " + vmName + " not found.";
            throw new RuntimeException(msg);
         }
         drsVmConfigSpec.setInfo(drsVmConfigInfo);
         drsVmConfigSpec.setOperation(ArrayUpdateOperation.EDIT);
         sdrsConfigSpec.getVmConfigSpec().add(drsVmConfigSpec);
         ManagedObjectReference taskmor =
               vimPort.configureStorageDrsForPodTask(storageResourceManager,
                     storagePod, sdrsConfigSpec, true);
         if (getTaskResultAfterDone(taskmor)) {
            System.out.printf("\nSuccess: Adding VmdkAntiAffinity Rule.");
         } else {
            String msg = "\nFailure: Adding VmdkAntiAffinity Rule.";
            throw new RuntimeException(msg);
         }
      } else {
         String msg = "\nFailure: StoragePod " + storagePodName + " not found.";
         throw new RuntimeException(msg);
      }
   }

   /**
    * List Rules for a StoragePod.
    * 
    * @param storagePodName
    *           StoragePod name.
    * @throws Exception
    */
   private static void listRules(String storagePodName) throws Exception {
      ManagedObjectReference storagePod =
            getEntityByName(storagePodName, "StoragePod");
      if (storagePod != null) {
         PodStorageDrsEntry podSDrsEntry =
               (PodStorageDrsEntry) getDynamicProperty(storagePod,
                     "podStorageDrsEntry");
         System.out.println("\n List of VM anti-affinity rules: ");
         List<ClusterRuleInfo> vmRuleSpec =
               podSDrsEntry.getStorageDrsConfig().getPodConfig().getRule();
         for (ClusterRuleInfo vmRule : vmRuleSpec) {
            System.out.println(vmRule.getName());
         }
         System.out.println("\n List of VMDK anti-affinity rules: ");
         List<StorageDrsVmConfigInfo> vmConfig =
               podSDrsEntry.getStorageDrsConfig().getVmConfig();
         for (StorageDrsVmConfigInfo sdrsVmConfig : vmConfig) {
            if (sdrsVmConfig.getIntraVmAntiAffinity() != null) {
               System.out.println(sdrsVmConfig.getIntraVmAntiAffinity()
                     .getName());
            }
         }
      } else {
         String msg = "\nFailure: StoragePod " + storagePodName + " not found.";
         throw new RuntimeException(msg);
      }
   }

   /**
    * Modify VmAntiAffinity Rule.
    * 
    * @param storagePodName
    *           StoragePod name.
    * @param ruleName
    *           Name of the rule to be modified.
    * @param newRuleName
    *           new name for the rule.
    * @param enabled
    *           Flag to indicate whether or not the rule is enabled.
    * @param vmName
    *           VM to be added to the list of VMs in the Rule.
    * @throws RemoteException
    * @throws Exception
    */
   private static void modifyVmAntiAffinityRule(String storagePodName,
         String ruleName, String newRuleName, String enabled, String vmName)
         throws RemoteException, Exception {
      ManagedObjectReference storageResourceManager =
            serviceContent.getStorageResourceManager();
      ManagedObjectReference storagePod =
            getEntityByName(storagePodName, "StoragePod");
      if (storagePod != null) {
         PodStorageDrsEntry podSDrsEntry =
               (PodStorageDrsEntry) getDynamicProperty(storagePod,
                     "podStorageDrsEntry");
         ClusterRuleSpec ruleSpec = new ClusterRuleSpec();
         List<ClusterRuleInfo> vmRuleInfo =
               podSDrsEntry.getStorageDrsConfig().getPodConfig().getRule();
         ManagedObjectReference vmMoref = null;
         StorageDrsConfigSpec sdrsConfigSpec = new StorageDrsConfigSpec();
         StorageDrsPodConfigSpec podConfigSpec = new StorageDrsPodConfigSpec();
         ClusterAntiAffinityRuleSpec vmAntiAffinityRuleSpec = null;
         for (ClusterRuleInfo vmRule : vmRuleInfo) {
            if (vmRule.getName().equalsIgnoreCase(ruleName)) {
               vmAntiAffinityRuleSpec = (ClusterAntiAffinityRuleSpec) vmRule;
            }
         }
         if (vmAntiAffinityRuleSpec != null) {
            if (newRuleName != null) {
               vmAntiAffinityRuleSpec.setName(newRuleName);
            }
            if (enabled != null) {
               if (enabled.equalsIgnoreCase("true")) {
                  vmAntiAffinityRuleSpec.setEnabled(true);
               } else {
                  vmAntiAffinityRuleSpec.setEnabled(false);
               }
            }
            if (vmName != null) {
               vmMoref = getEntityByName(vmName, "VirtualMachine");
               if (vmMoref != null) {
                  vmAntiAffinityRuleSpec.getVm().add(vmMoref);
               } else {
                  String msg =
                        "\nFailure: Virtual Machine " + vmName + " not found.";
                  throw new RuntimeException(msg);
               }
            }
            ruleSpec.setInfo(vmAntiAffinityRuleSpec);
            ruleSpec.setOperation(ArrayUpdateOperation.EDIT);
            podConfigSpec.getRule().add(ruleSpec);
            sdrsConfigSpec.setPodConfigSpec(podConfigSpec);
         } else {
            String msg = "\nFailure: Rule " + ruleName + " not found.";
            throw new RuntimeException(msg);
         }
         ManagedObjectReference taskmor =
               vimPort.configureStorageDrsForPodTask(storageResourceManager,
                     storagePod, sdrsConfigSpec, true);
         if (getTaskResultAfterDone(taskmor)) {
            System.out.printf("\nSuccess: Modifying VmAntiAffinityRule.");
         } else {
            String msg = "\nFailure: Modifying VmAntiAffinityRule.";
            throw new RuntimeException(msg);
         }
      } else {
         String msg = "\nFailure: StoragePod " + storagePodName + " not found.";
         throw new RuntimeException(msg);
      }
   }

   /**
    * Modify VmdkAntiAffinity Rule.
    * 
    * @param storagePodName
    *           StoragePod name.
    * @param ruleName
    *           Name of the rule to be modified.
    * @param newRuleName
    *           new name for the rule.
    * @param enabled
    *           Flag to indicate whether or not the rule is enabled.
    * @throws RemoteException
    * @throws Exception
    */
   private static void modifyVmdkAntiAffinityRule(String storagePodName,
         String ruleName, String newRuleName, String enabled)
         throws RemoteException, Exception {
      ManagedObjectReference storageResourceManager =
            serviceContent.getStorageResourceManager();
      ManagedObjectReference storagePod =
            getEntityByName(storagePodName, "StoragePod");
      if (storagePod != null) {
         PodStorageDrsEntry podSDrsEntry =
               (PodStorageDrsEntry) getDynamicProperty(storagePod,
                     "podStorageDrsEntry");
         StorageDrsVmConfigInfo drsVmConfigInfo = null;
         StorageDrsConfigSpec sdrsConfigSpec = new StorageDrsConfigSpec();
         StorageDrsVmConfigSpec drsVmConfigSpec = new StorageDrsVmConfigSpec();
         List<StorageDrsVmConfigInfo> sdrsVmConfig =
               podSDrsEntry.getStorageDrsConfig().getVmConfig();
         for (StorageDrsVmConfigInfo vmConfig : sdrsVmConfig) {
            if (vmConfig.getIntraVmAntiAffinity() != null) {
               if (vmConfig.getIntraVmAntiAffinity().getName()
                     .equalsIgnoreCase(ruleName)) {
                  drsVmConfigInfo = vmConfig;
               }
            }
         }
         if (drsVmConfigInfo != null) {
            if (newRuleName != null) {
               drsVmConfigInfo.getIntraVmAntiAffinity().setName(newRuleName);
            }
            if (enabled != null) {
               if (enabled.equalsIgnoreCase("true")) {
                  drsVmConfigInfo.getIntraVmAntiAffinity().setEnabled(true);
               } else {
                  drsVmConfigInfo.getIntraVmAntiAffinity().setEnabled(false);
               }
            }
            drsVmConfigSpec.setInfo(drsVmConfigInfo);
            drsVmConfigSpec.setOperation(ArrayUpdateOperation.EDIT);
            sdrsConfigSpec.getVmConfigSpec().add(drsVmConfigSpec);
         } else {
            String msg = "\nFailure: Rule " + ruleName + " not found.";
            throw new RuntimeException(msg);
         }
         ManagedObjectReference taskmor =
               vimPort.configureStorageDrsForPodTask(storageResourceManager,
                     storagePod, sdrsConfigSpec, true);
         if (getTaskResultAfterDone(taskmor)) {
            System.out.printf("\nSuccess: Modifying VmdkAntiAffinityRule.");
         } else {
            String msg = "\nFailure: Modifying VmdkAntiAffinityRule.";
            throw new RuntimeException(msg);
         }
      } else {
         String msg = "\nFailure: StoragePod " + storagePodName + " not found.";
         throw new RuntimeException(msg);
      }
   }

   /**
    * Delete VmAntiAffinity Rule.
    * 
    * @param storagePodName
    *           StoragePod name.
    * @param ruleName
    *           Name of the rule to be deleted.
    * @throws RemoteException
    * @throws Exception
    */
   private static void deleteVmAntiAffinityRule(String storagePodName,
         String ruleName) throws RemoteException, Exception {
      ManagedObjectReference storageResourceManager =
            serviceContent.getStorageResourceManager();
      ManagedObjectReference storagePod =
            getEntityByName(storagePodName, "StoragePod");
      if (storagePod != null) {
         PodStorageDrsEntry podSDrsEntry =
               (PodStorageDrsEntry) getDynamicProperty(storagePod,
                     "podStorageDrsEntry");
         ClusterRuleSpec ruleSpec = new ClusterRuleSpec();
         List<ClusterRuleInfo> vmRuleInfo =
               podSDrsEntry.getStorageDrsConfig().getPodConfig().getRule();
         StorageDrsConfigSpec sdrsConfigSpec = new StorageDrsConfigSpec();
         StorageDrsPodConfigSpec podConfigSpec = new StorageDrsPodConfigSpec();
         ClusterAntiAffinityRuleSpec vmAntiAffinityRuleSpec = null;
         for (ClusterRuleInfo vmRule : vmRuleInfo) {
            if (vmRule.getName().equalsIgnoreCase(ruleName)) {
               vmAntiAffinityRuleSpec = (ClusterAntiAffinityRuleSpec) vmRule;
            }
         }
         if (vmAntiAffinityRuleSpec != null) {
            ruleSpec.setInfo(vmAntiAffinityRuleSpec);
            ruleSpec.setOperation(ArrayUpdateOperation.REMOVE);
            ruleSpec.setRemoveKey(vmAntiAffinityRuleSpec.getKey());
            podConfigSpec.getRule().add(ruleSpec);
            sdrsConfigSpec.setPodConfigSpec(podConfigSpec);
         } else {
            String msg = "\nFailure: Rule " + ruleName + " not found.";
            throw new RuntimeException(msg);
         }
         ManagedObjectReference taskmor =
               vimPort.configureStorageDrsForPodTask(storageResourceManager,
                     storagePod, sdrsConfigSpec, true);
         if (getTaskResultAfterDone(taskmor)) {
            System.out.printf("\nSuccess: Deleting VmAntiAffinity Rule.");
         } else {
            String msg = "\nFailure: Deleting VmAntiAffinity Rule.";
            throw new RuntimeException(msg);
         }
      } else {
         String msg = "\nFailure: StoragePod " + storagePodName + " not found.";
         throw new RuntimeException(msg);
      }
   }

   /**
    * Delete VmdkAntiAffinity Rule.
    * 
    * @param storagePodName
    *           StoragePod name.
    * @param ruleName
    *           Name of the rule to be deleted.
    * @throws RemoteException
    * @throws Exception
    */
   private static void deleteVmdkAntiAffinityRule(String storagePodName,
         String ruleName) throws RemoteException, Exception {
      ManagedObjectReference storageResourceManager =
            serviceContent.getStorageResourceManager();
      ManagedObjectReference storagePod =
            getEntityByName(storagePodName, "StoragePod");
      if (storagePod != null) {
         PodStorageDrsEntry podSDrsEntry =
               (PodStorageDrsEntry) getDynamicProperty(storagePod,
                     "podStorageDrsEntry");
         StorageDrsVmConfigInfo drsVmConfigInfo = null;
         StorageDrsConfigSpec sdrsConfigSpec = new StorageDrsConfigSpec();
         StorageDrsVmConfigSpec drsVmConfigSpec = new StorageDrsVmConfigSpec();
         List<StorageDrsVmConfigInfo> sdrsVmConfig =
               podSDrsEntry.getStorageDrsConfig().getVmConfig();
         for (StorageDrsVmConfigInfo vmConfig : sdrsVmConfig) {
            if (vmConfig.getIntraVmAntiAffinity() != null) {
               if (vmConfig.getIntraVmAntiAffinity().getName()
                     .equalsIgnoreCase(ruleName)) {
                  drsVmConfigInfo = vmConfig;
               }
            }
         }
         if (drsVmConfigInfo != null) {
            drsVmConfigInfo.setIntraVmAntiAffinity(null);
            drsVmConfigSpec.setInfo(drsVmConfigInfo);
            drsVmConfigSpec.setOperation(ArrayUpdateOperation.EDIT);
            sdrsConfigSpec.getVmConfigSpec().add(drsVmConfigSpec);
         } else {
            String msg = "\nFailure: Rule " + ruleName + " not found.";
            throw new RuntimeException(msg);
         }
         ManagedObjectReference taskmor =
               vimPort.configureStorageDrsForPodTask(storageResourceManager,
                     storagePod, sdrsConfigSpec, true);
         if (getTaskResultAfterDone(taskmor)) {
            System.out.printf("\nSuccess: Deleting VmdkAntiAffinity Rule.");
         } else {
            String msg = "\nFailure: Deleting VmdkAntiAffinity Rule.";
            throw new RuntimeException(msg);
         }
      } else {
         String msg = "\nFailure: StoragePod " + storagePodName + " not found.";
         throw new RuntimeException(msg);
      }
   }

   private static void printUsage() {
      System.out
            .println("This sample demonstrates how to Add/List/Modify/Delete the"
                  + " rules for an existing SDRS cluster.");
      System.out.println("Parameters:");
      System.out
            .println("url                       [required]: url of the web service.");
      System.out
            .println("username                  [required]: username for the authentication");
      System.out
            .println("Password                  [required]: password for the authentication");
      System.out
            .println("podname                   [required]: StoragePod name.");
      System.out
            .println("option                    [required]:  valid option are \"addVmAntiAffinity\",");
      System.out
            .println("                          \"addVmdkAntiAffinity\", \"list\", \"modifyVmAntiAffinity\",");
      System.out
            .println("                          \"modifyVmdkAntiAffinity\", \"deleteVmAntiAffinity\" and");
      System.out
            .println("                          \"deleteVmdkAntiAffinity\".");
      System.out.println("rulename                  Rule name.");
      System.out
            .println("vmlist                    Comma separated, list of VM name. It is required while");
      System.out
            .println("                          adding VmAntiAffinity Rule.");
      System.out
            .println("newrulename               New name for rule while modifying");
      System.out
            .println("enable                    Flag to indicate whether or not the rule is"
                  + " enabled.");
      System.out.println("vmname                    virtual machine name.");
      System.out.println("\nSample usage:");
      System.out.println("\naddVmAntiAffinity Rule:");
      System.out
            .println("run.bat com.vmware.storage.SDRSRules --url [URLString]"
                  + " --username [User] --password");
      System.out
            .println("[Password] --option addVmAntiAffinity --podname [podname]"
                  + " --rulename [rulename]");
      System.out.println(" --enable [enable] --vmlist [vmlist]");
      System.out.println("\naddVmdkAntiAffinity Rule:");
      System.out
            .println("run.bat com.vmware.storage.SDRSRules --url [URLString]"
                  + " --username [User] --password");
      System.out
            .println("[Password] --option addVmdkAntiAffinity --podname [podname]"
                  + " --rulename [rulename]");
      System.out.println(" --enable [enable] --vmname [vmname]");
      System.out.println("\nList Rules:");
      System.out
            .println("run.bat com.vmware.storage.SDRSRules --url [URLString]"
                  + " --username [User] --password");
      System.out.println("[Password] --option list --podname [podname]");
      System.out.println("\nmodifyVmAntiAffinity Rule:");
      System.out
            .println("run.bat com.vmware.storage.SDRSRules --url [URLString]"
                  + " --username [User] --password");
      System.out
            .println("[Password] --option modifyVmAntiAffinity  --podname [podname]"
                  + " --rulename [rulename]");
      System.out
            .println(" --enable [enable] --vmname [vmname] --newrulename [newrulename]");
      System.out.println("\nmodifyVmdkAntiAffinity Rule:");
      System.out
            .println("run.bat com.vmware.storage.SDRSRules --url [URLString]"
                  + " --username [User] --password");
      System.out
            .println(" [Password] --option modifyVmdkAntiAffinity --podname [podname]"
                  + " --rulename [rulename]");
      System.out.println(" --enable [enable] --newrulename [newrulename]");
      System.out.println("\ndeleteVmAntiAffinity Rule:");
      System.out
            .println("run.bat com.vmware.storage.SDRSRules --url [URLString]"
                  + " --username [User] --password");
      System.out
            .println("[Password] --option deleteVmAntiAffinity --podname [podname]"
                  + " --rulename [rulename]");
      System.out.println("\ndeleteVmdkAntiAffinity Rule:");
      System.out
            .println("run.bat com.vmware.storage.SDRSRules --url [URLString]"
                  + " --username [User] --password");
      System.out
            .println("[Password] --option deleteVmdkAntiAffinity  --podname [podname]"
                  + " --rulename [rulename]");
      System.out
            .println("\nNOTE: All the virtual disks will be added while adding"
                  + " Vmdk AntiAffinity Rule.");
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
         connect();
         if (option.equalsIgnoreCase("list")) {
            listRules(storagePodName);
         } else if (option.equalsIgnoreCase("addVmAntiAffinity")) {
            addVmAntiAffinityRule(storagePodName, ruleName, enabled, vm);
         } else if (option.equalsIgnoreCase("addVmdkAntiAffinity")) {
            addVmdkAntiAffinityRule(storagePodName, ruleName, enabled, vmName);
         } else if (option.equalsIgnoreCase("modifyVmAntiAffinity")) {
            modifyVmAntiAffinityRule(storagePodName, ruleName, newRuleName,
                  enabled, vmName);
         } else if (option.equalsIgnoreCase("modifyVmdkAntiAffinity")) {
            modifyVmdkAntiAffinityRule(storagePodName, ruleName, newRuleName,
                  enabled);
         } else if (option.equalsIgnoreCase("deleteVmAntiAffinity")) {
            deleteVmAntiAffinityRule(storagePodName, ruleName);
         } else if (option.equalsIgnoreCase("deleteVmdkAntiAffinity")) {
            deleteVmdkAntiAffinityRule(storagePodName, ruleName);
         }
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
         printUsage();
      } catch (Exception e) {
         System.out.println("Exception encountered. " + e.getMessage());
      } finally {
         try {
            disconnect();
         } catch (Exception e) {
            System.out.println("Failed to disconnect - " + e.getMessage());
            e.printStackTrace();
         }
      }
   }
}
