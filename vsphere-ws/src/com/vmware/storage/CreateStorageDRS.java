package com.vmware.storage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;

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
import com.vmware.vim25.StorageDrsConfigSpec;
import com.vmware.vim25.StorageDrsIoLoadBalanceConfig;
import com.vmware.vim25.StorageDrsPodConfigSpec;
import com.vmware.vim25.StorageDrsSpaceLoadBalanceConfig;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * This sample demonstrates how to create Storage DRS
 * <b>Parameters:</b>
 * url                       [required]: url of the web service.
 * username                  [required]: username for the authentication
 * password                  [required]: password for the authentication
 * dcname                    [required]: DataCenter name.
 * sdrsname                  [required]: Name for the new storage pod.
 * behavior                  [optional]: Storage DRS behavior, true if automated. It is
 *                                       manual by default.
 * iolatencythreshold        [optional]: int: Storage DRS makes storage migration
 *                                       recommendations if I/O latency on one (or more)
 *                                       of the datastores is higher than the specified
 *                                       threshold. Range is 5-100 ms, default is 15ms
 * ioloadimbalancethreshold  [optional]: Storage DRS makes storage migration
 *                                       recommendations if I/O load imbalance
 *                                       level is higher than the specified threshold.
 *                                       Range is 1-100, default is 5
 * loadbalinterval           [optional]: Specify the interval that storage DRS runs to
 *                                       load balance among datastores within a storage
 *                                       pod. it is 480 by default.
 * minutilizationdiff        [optional]: Storage DRS considers making storage migration
 *                                       recommendations if the difference in space
 *                                       utilization between the source and  destination
 *                                       datastores is higher than the specified threshold.
 *                                       Range 1-50%, default is 5%
 * utilizationthreshold      [optional]: Storage DRS makes storage migration
 *                                       recommendations if space utilization on one
 *                                       (or more) of the datastores is higher than the
 *                                       specified threshold. Range 50-100%, default is 80%
 * datastore                 [optional]: Name of the datastore to be added in StoragePod.
 * <b>Sample usage:</b>
 *  run.bat com.vmware.storage.CreateStorageDRS --url [URLString] --username [User]
 *  --password [Password] --dcname [dcname] --sdrsname [sdrsname] --behavior [behavior]
 *  --iolatencythreshold [iolatencythreshold] --ioloadimbalancethreshold
 *  [ioloadimbalancethreshold] --loadbalinterval [loadbalinterval] --minutilizationdiff
 *  [minutilizationdiff] --utilizationthreshold [utilizationthreshold] --datastore [datastore]
 * </pre>
 */

public class CreateStorageDRS {

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
   private static String dcName = null;
   private static String sdrsname = null;
   private static String behavior = "false";
   private static String ioLatencyThreshold = null;
   private static String ioLoadImbalanceThreshold = null;
   private static String loadBalanceInterval = null;
   private static String minSpaceUtilizationDifference = null;
   private static String spaceUtilizationThreshold = null;
   private static String dsname = null;
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
         if (param.equalsIgnoreCase("--dcname") && !val.startsWith("--")
               && !val.isEmpty()) {
            dcName = val;
         } else if (param.equalsIgnoreCase("--sdrsname")
               && !val.startsWith("--") && !val.isEmpty()) {
            sdrsname = val;
         } else if (param.equalsIgnoreCase("--behavior")
               && !val.startsWith("--") && !val.isEmpty()) {
            behavior = val;
         } else if (param.equalsIgnoreCase("--iolatencythreshold")
               && !val.startsWith("--") && !val.isEmpty()) {
            ioLatencyThreshold = val;
         } else if (param.equalsIgnoreCase("--ioloadimbalancethreshold")
               && !val.startsWith("--") && !val.isEmpty()) {
            ioLoadImbalanceThreshold = val;
         } else if (param.equalsIgnoreCase("--loadbalinterval")
               && !val.startsWith("--") && !val.isEmpty()) {
            loadBalanceInterval = val;
         } else if (param.equalsIgnoreCase("--minutilizationdiff")
               && !val.startsWith("--") && !val.isEmpty()) {
            minSpaceUtilizationDifference = val;
         } else if (param.equalsIgnoreCase("--utilizationthreshold")
               && !val.startsWith("--") && !val.isEmpty()) {
            spaceUtilizationThreshold = val;
         } else if (param.equalsIgnoreCase("--datastore")
               && !val.startsWith("--") && !val.isEmpty()) {
            dsname = val;
         }
         val = "";
         ai += 2;
      }
      if ((sdrsname == null) || (dcName == null)) {
         throw new IllegalArgumentException(
               "Expected valid -dcname, --sdrsname" + " arguments.");
      }
      if (ioLatencyThreshold != null) {
         if (Integer.parseInt(ioLatencyThreshold) < 5
               || Integer.parseInt(ioLatencyThreshold) > 50) {
            throw new IllegalArgumentException(
                  "Expected valid --iolatencythreshold argument. Range is 5-50 ms.");
         }
      }
      if (ioLoadImbalanceThreshold != null) {
         if (Integer.parseInt(ioLoadImbalanceThreshold) < 1
               || Integer.parseInt(ioLoadImbalanceThreshold) > 100) {
            throw new IllegalArgumentException(
                  "Expected valid --ioloadimbalancethreshold argument. Range is 1-100.");
         }
      }
      if (minSpaceUtilizationDifference != null) {
         if (Integer.parseInt(minSpaceUtilizationDifference) < 1
               || Integer.parseInt(minSpaceUtilizationDifference) > 50) {
            throw new IllegalArgumentException(
                  "Expected valid --minutilizationdiff argument. Range is 1-50%.");
         }
      }
      if (spaceUtilizationThreshold != null) {
         if (Integer.parseInt(spaceUtilizationThreshold) < 50
               || Integer.parseInt(spaceUtilizationThreshold) > 100) {
            throw new IllegalArgumentException(
                  "Expected valid --utilizationthreshold argument. Range is 50-100%.");
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
   private static Object getDatastoreFolder(ManagedObjectReference mor)
         throws SecurityException, NoSuchMethodException,
         IllegalArgumentException, IllegalAccessException,
         InvocationTargetException {
      ObjectContent[] objContent =
            getObjectProperties(mor, new String[] { "datastoreFolder" });

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
    * @return An array of SelectionSpec covering Datacenter to DatastoreFolder.
    */
   private static SelectionSpec[] buildTraversal() {

      // For Folder -> Folder recursion
      SelectionSpec sspecvfolders = new SelectionSpec();
      sspecvfolders.setName("VisitFolders");

      TraversalSpec dcToDf = new TraversalSpec();
      dcToDf.setType("Datacenter");
      dcToDf.setSkip(Boolean.FALSE);
      dcToDf.setPath("datastoreFolder");
      dcToDf.setName("dcToDf");
      dcToDf.getSelectSet().add(sspecvfolders);

      // DC -> DS
      TraversalSpec dcToDs = new TraversalSpec();
      dcToDs.setType("Datacenter");
      dcToDs.setPath("datastore");
      dcToDs.setName("dcToDs");
      dcToDs.setSkip(Boolean.FALSE);

      TraversalSpec visitFolders = new TraversalSpec();
      visitFolders.setType("Folder");
      visitFolders.setPath("childEntity");
      visitFolders.setSkip(Boolean.FALSE);
      visitFolders.setName("VisitFolders");

      List<SelectionSpec> sspecarrvf = new ArrayList<SelectionSpec>();
      sspecarrvf.add(dcToDs);
      sspecarrvf.add(dcToDf);
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
    * @param behavior
    *           Storage DRS behavior, true if automated.
    * @param ioLatencyThreshold
    *           Storage DRS makes storage migration recommendations if I/O
    *           latency on one (or more) of the datastores is higher than the
    *           specified threshold.
    * @param ioLoadImbalanceThreshold
    *           Storage DRS makes storage migration recommendations if I/O load
    *           imbalance level is higher than the specified threshold.
    * @param loadBalanceInterval
    *           Specify the interval that storage DRS runs to load balance among
    *           datastores within a storage pod.
    * @param minSpaceUtilizationDifference
    *           Storage DRS considers making storage migration recommendations
    *           if the difference in space utilization between the source and
    *           destination datastores is higher than the specified threshold.
    * @param spaceUtilizationThreshold
    *           Storage DRS makes storage migration recommendations if space
    *           utilization on one (or more) of the datastores is higher than
    *           the specified threshold.
    * @return StorageDrsConfigSpec object.
    */
   private static StorageDrsConfigSpec getStorageDrsConfigSpec(String behavior,
         String ioLatencyThreshold, String ioLoadImbalanceThreshold,
         String loadBalanceInterval, String minSpaceUtilizationDifference,
         String spaceUtilizationThreshold) {
      StorageDrsConfigSpec sdrsConfigSpec = new StorageDrsConfigSpec();
      StorageDrsPodConfigSpec podConfigSpec = new StorageDrsPodConfigSpec();
      podConfigSpec.setDefaultIntraVmAffinity(true);
      if (behavior.equals("true")) {
         podConfigSpec.setDefaultVmBehavior("automated");
      } else {
         podConfigSpec.setDefaultVmBehavior("manual");
      }
      podConfigSpec.setEnabled(true); // "True" as storage DRS should be enabled by default
      StorageDrsIoLoadBalanceConfig sdrsIoLoadBalanceConfig =
            new StorageDrsIoLoadBalanceConfig();
      if (ioLatencyThreshold != null) {
         sdrsIoLoadBalanceConfig.setIoLatencyThreshold(Integer
               .parseInt(ioLatencyThreshold));
      } else {
         sdrsIoLoadBalanceConfig.setIoLatencyThreshold(15);
      }
      if (ioLoadImbalanceThreshold != null) {
         sdrsIoLoadBalanceConfig.setIoLoadImbalanceThreshold(Integer
               .parseInt(ioLoadImbalanceThreshold));
      } else {
         sdrsIoLoadBalanceConfig.setIoLoadImbalanceThreshold(5);
      }
      podConfigSpec.setIoLoadBalanceConfig(sdrsIoLoadBalanceConfig);

      podConfigSpec.setIoLoadBalanceEnabled(true);
      if (loadBalanceInterval != null) {
         podConfigSpec.setLoadBalanceInterval(Integer
               .parseInt(loadBalanceInterval));
      } else {
         podConfigSpec.setLoadBalanceInterval(480);
      }
      StorageDrsSpaceLoadBalanceConfig sdrsSpaceLoadBalanceConfig =
            new StorageDrsSpaceLoadBalanceConfig();
      if (minSpaceUtilizationDifference != null) {
         sdrsSpaceLoadBalanceConfig.setMinSpaceUtilizationDifference(Integer
               .parseInt(minSpaceUtilizationDifference));
      } else {
         sdrsSpaceLoadBalanceConfig.setMinSpaceUtilizationDifference(5);
      }
      if (spaceUtilizationThreshold != null) {
         sdrsSpaceLoadBalanceConfig.setSpaceUtilizationThreshold(Integer
               .parseInt(spaceUtilizationThreshold));
      } else {
         sdrsSpaceLoadBalanceConfig.setSpaceUtilizationThreshold(80);
      }
      podConfigSpec.setSpaceLoadBalanceConfig(sdrsSpaceLoadBalanceConfig);
      sdrsConfigSpec.setPodConfigSpec(podConfigSpec);
      return sdrsConfigSpec;
   }

   /**
    * For creating customize StorageDRS.
    * 
    * @param dcName
    *           datacenter name
    * @param sdrsname
    *           Name for the new storage pod.
    * @param behavior
    *           Storage DRS behavior, true if automated.
    * @param ioLatencyThreshold
    *           Storage DRS makes storage migration recommendations if I/O
    *           latency on one (or more) of the datastores is higher than the
    *           specified threshold.
    * @param ioLoadImbalanceThreshold
    *           Storage DRS makes storage migration recommendations if I/O load
    *           imbalance level is higher than the specified threshold.
    * @param loadBalanceInterval
    *           Specify the interval that storage DRS runs to load balance among
    *           datastores within a storage pod.
    * @param minSpaceUtilizationDifference
    *           Storage DRS considers making storage migration recommendations
    *           if the difference in space utilization between the source and
    *           destination datastores is higher than the specified threshold.
    * @param spaceUtilizationThreshold
    *           Storage DRS makes storage migration recommendations if space
    *           utilization on one (or more) of the datastores is higher than
    *           the specified threshold.
    * @throws Exception
    */
   private static void createSDRS(String dcName, String name, String behavior,
         String ioLatencyThreshold, String ioLoadImbalanceThreshold,
         String loadBalanceInterval, String minSpaceUtilizationDifference,
         String spaceUtilizationThreshold, String dsname) throws Exception {
      ManagedObjectReference storagePod = new ManagedObjectReference();
      ManagedObjectReference storageResourceManager =
            serviceContent.getStorageResourceManager();
      ManagedObjectReference dcmor = getEntityByName(dcName, "Datacenter");
      if (dcmor != null) {
         ManagedObjectReference datastoreFolder =
               (ManagedObjectReference) getDatastoreFolder(dcmor);
         storagePod = vimPort.createStoragePod(datastoreFolder, name);
         System.out.printf("Success: Creating storagePod.");
         StorageDrsConfigSpec sdrsConfigSpec =
               getStorageDrsConfigSpec(behavior, ioLatencyThreshold,
                     ioLoadImbalanceThreshold, loadBalanceInterval,
                     minSpaceUtilizationDifference, spaceUtilizationThreshold);
         ManagedObjectReference taskmor =
               vimPort.configureStorageDrsForPodTask(storageResourceManager,
                     storagePod, sdrsConfigSpec, true);
         if (getTaskResultAfterDone(taskmor)) {
            System.out.printf("\nSuccess: Configuring storagePod.");
         } else {
            throw new RuntimeException("Failure: Configuring storagePod.");
         }
         if (dsname != null) {
            ManagedObjectReference dsMoref =
                  getEntityByName(dsname, "Datastore");
            if (dsMoref != null) {
               List<ManagedObjectReference> dsList =
                     new ArrayList<ManagedObjectReference>();
               dsList.add(dsMoref);
               ManagedObjectReference task =
                     vimPort.moveIntoFolderTask(storagePod, dsList);
               if (getTaskResultAfterDone(task)) {
                  System.out
                        .printf("\nSuccess: Adding datastore to storagePod.");
               } else {
                  throw new RuntimeException(
                        "Failure: Adding datastore to storagePod.");
               }
            } else {
               System.out.println("Datastore " + dsname + " Not Found");
               return;
            }
         }
      } else {
         System.out.println("Datacenter " + dcName + " Not Found");
         return;
      }
   }

   private static void printUsage() {
      System.out.println("This sample demonstrates how to create Storage DRS");
      System.out.println("Parameters:");
      System.out
            .println("url                       [required]: url of the web service.");
      System.out
            .println("username                  [required]: username for the authentication");
      System.out
            .println("Password                  [required]: password for the authentication");
      System.out
            .println("dcname                    [required]: DataCenter name.");
      System.out
            .println("sdrsname                  [required]: Name for the new storage pod.");
      System.out
            .println("behavior                  [optional]: Storage DRS behavior, true if automated. It is manual by default.");
      System.out
            .println("iolatencythreshold        [optional]: int: Storage DRS makes storage migration recommendations if I/O ");
      System.out
            .println("                                      latency on one (or more) of the datastores is higher than the specified threshold.");
      System.out
            .println("                                      Range is 5-100 ms, default is 15ms");
      System.out
            .println("ioloadimbalancethreshold  [optional]: Storage DRS makes storage migration recommendations if I/O load imbalance");
      System.out
            .println("                                      level is higher than the specified threshold.");
      System.out
            .println("                                      Range is 1-100, default is 5");
      System.out
            .println("loadbalinterval           [optional]: Specify the interval that storage DRS runs to load balance");
      System.out
            .println("                                      among datastores within a storage pod. it is 480 by default.");
      System.out
            .println("minutilizationdiff        [optional]: Storage DRS considers making storage migration recommendations");
      System.out
            .println("                                      if the difference in space utilization between the source and ");
      System.out
            .println("                                      destination datastores is higher than the specified threshold.");
      System.out
            .println("                                      Range 1-50%, default is 5%");
      System.out
            .println("utilizationthreshold      [optional]: Storage DRS makes storage migration recommendations if space utilization");
      System.out
            .println("                                      on one (or more) of the datastores is higher than the specified threshold.");
      System.out
            .println("                                      Range 50-100%, default is 80%");
      System.out
            .println("datastore                 [optional]: Name of the datastore to be added in StoragePod.");
      System.out.println("Sample usage:");
      System.out
            .println("run.bat com.vmware.storage.CreateStorageDRS --url [URLString] --username [User]");
      System.out
            .println(" --password [Password] --dcname [dcname] --sdrsname [sdrsname] --behavior");
      System.out
            .println(" [behavior] --iolatencythreshold [iolatencythreshold]");
      System.out
            .println(" --ioloadimbalancethreshold [ioloadimbalancethreshold] --loadbalinterval");
      System.out
            .println(" [loadbalinterval] --minutilizationdiff [minutilizationdiff]");
      System.out.println(" --utilizationthreshold [utilizationthreshold]");
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
         createSDRS(dcName, sdrsname, behavior, ioLatencyThreshold,
               ioLoadImbalanceThreshold, loadBalanceInterval,
               minSpaceUtilizationDifference, spaceUtilizationThreshold, dsname);
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
         printUsage();
      } catch (Exception e) {
         System.out.println("Exception encountered " + e.getMessage());
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
