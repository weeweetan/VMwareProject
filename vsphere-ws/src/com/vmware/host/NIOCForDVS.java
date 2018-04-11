package com.vmware.host;

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

import com.vmware.vim25.ArrayOfDVSNetworkResourcePool;
import com.vmware.vim25.ConcurrentAccessFaultMsg;
import com.vmware.vim25.DVPortSetting;
import com.vmware.vim25.DVPortgroupConfigInfo;
import com.vmware.vim25.DVPortgroupConfigSpec;
import com.vmware.vim25.DVSNetworkResourcePool;
import com.vmware.vim25.DVSNetworkResourcePoolAllocationInfo;
import com.vmware.vim25.DVSNetworkResourcePoolConfigSpec;
import com.vmware.vim25.DuplicateNameFaultMsg;
import com.vmware.vim25.DvsFaultFaultMsg;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.InvalidCollectorVersionFaultMsg;
import com.vmware.vim25.InvalidNameFaultMsg;
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
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.SharesInfo;
import com.vmware.vim25.SharesLevel;
import com.vmware.vim25.StringPolicy;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 *  This sample demonstrates how to add/modify NetworkResourcePool to Distributed
 *  Virtual Switch:
 * 
 * <b>Parameters:</b>
 *  url               [required]: url of the web service.
 *  username          [required]: username for authentication
 *  Password          [required]: password for authentication
 *  option            [required]:
 *                       "enablenioc" for enabling network I/O control
 *                       "addnrp" for adding Network Resource Pool
 *                       "listnrp" for Listing existing DVSNetworkResourcePool
 *                       "modifynrp" for reconfiguring NetworkResourcePool
 *                       "nrptoportgroup" for adding NetworkResourcePool key to DVS Port Group
 *  dvsname           [required]: Distributed Virtual Switch name
 *  enablenioc        : If true, enables I/O control. If false, disables network I/O control
 *  nrpsharelevel     : The allocation level. The level is a simplified view of shares.
 *                      Levels map to a pre-determined set of numeric values for shares. If the
 *                      Shares value does not map to a predefined size, then the level is set as custom.
 *  nrphostlimit      : Numeric value: The maximum allowed usage for network clients
 *                      belonging to this resource pool per host.
 *  nrpprioritytag    : Numeric value: The 802.1p tag to be used for this resource pool.
 *                      Its value should be between 0-7
 *  nrpname           : The user defined name for the resource pool.
 *  nrpdesc           : [optional] The user defined description for the resource pool.
 *  dvpgname          : The name of the portgroup.
 * 
 * <b>Sample usage:</b>
 *  Enable Network I/O Control:
 *  run.bat com.vmware.host.NIOCForDVS --url [URLString] --username [User] --password [Password]
 *  --option enablenioc --dvsname [dvsname] --enablenioc [enablenioc]
 * 
 *  Add NetworkResourcePool:
 *  run.bat com.vmware.host.NIOCForDVS --url [URLString] --username [User] --password [Password]
 *  --option addnrp --dvsname [dvsname] --nrpsharelevel [nrpsharelevel] --nrphostlimit [nrphostlimit]
 *  --nrpprioritytag [nrpprioritytag] --nrpname [nrpname] --nrpdesc [nrpdesc] 
 * 
 *  List NetworkResourcePool:
 *  run.bat com.vmware.host.NIOCForDVS --url [URLString] --username [User] --password [Password]
 *  --option listnrp --dvsname [dvsname]
 * 
 *  Reconfiguring NetworkResourcePool:
 *  run.bat com.vmware.host.NIOCForDVS --url [URLString] --username [User] --password [Password]
 *  --option modifynrp --dvsname [dvsname] --nrpsharelevel [nrpsharelevel] --nrphostlimit [nrphostlimit]
 *  --nrpprioritytag [nrpprioritytag] --nrpname [nrpname]
 * 
 *  Associate DVS Port Group to NetworkResourcePool :
 *  run.bat com.vmware.host.NIOCForDVS --url [URLString] --username [User] --password [Password]
 *  --option nrptoportgroup --dvsname [dvsname] --nrpname [nrpname] --dvpgname [dvpgname]
 * 
 *  Note: Sample only works for DVS 5.0 onwards.
 * </pre>
 */
public class NIOCForDVS {

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
   /*
   Connection input parameters
    */
   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
   private static String dvsname = null;
   private static String dvPGName = null;
   private static String nrpName = null;
   private static String nrpAllocationShareLevel = null;
   private static String prioritytag = null;
   private static String hostLimit = null;
   private static int noOfShares = -1;
   private static String nrpDesc = null;
   private static String enableNIOC = null;
   private static String option = null;
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
      List<ObjectContent> oCont =
            vimPort.retrieveProperties(serviceContent.getPropertyCollector(),
                  propertyFilterSpecs);
      if (oCont != null) {
         for (ObjectContent oc : oCont) {
            List<DynamicProperty> dps = oc.getPropSet();
            if (dps != null) {
               for (DynamicProperty dp : dps) {
                  retVal.put(dp.getName(), dp.getVal());
               }
            }
         }
      }
      return retVal;
   }

   /**
    * Returns all the MOREFs of the specified type that are present under the
    * folder
    * 
    * @param folder
    *           {@link ManagedObjectReference} of the folder to begin the search
    *           from
    * @param morefType
    *           Type of the managed entity that needs to be searched
    * 
    * @return Map of name and MOREF of the managed objects present. If none
    *         exist then empty Map is returned
    * 
    * @throws InvalidPropertyFaultMsg
    * @throws RuntimeFaultFaultMsg
    */
   private static Map<String, ManagedObjectReference> getMOREFsInFolderByType(
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

      List<ObjectContent> oCont =
            vimPort.retrieveProperties(serviceContent.getPropertyCollector(),
                  propertyFilterSpecs);
      if (oCont != null) {
         for (ObjectContent oc : oCont) {
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
      }
      return tgtMoref;
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
         if (param.equalsIgnoreCase("--dvsname") && !val.startsWith("--")
               && !val.isEmpty()) {
            dvsname = val;
         } else if (param.equalsIgnoreCase("--dvpgname")
               && !val.startsWith("--") && !val.isEmpty()) {
            dvPGName = val;
         } else if (param.equalsIgnoreCase("--nrpname")
               && !val.startsWith("--") && !val.isEmpty()) {
            nrpName = val;
         } else if (param.equalsIgnoreCase("--nrpsharelevel")
               && !val.startsWith("--") && !val.isEmpty()) {
            nrpAllocationShareLevel = val;
         } else if (param.equalsIgnoreCase("--nrphostlimit")
               && !val.startsWith("--") && !val.isEmpty()) {
            hostLimit = val;
         } else if (param.equalsIgnoreCase("--nrpprioritytag")
               && !val.startsWith("--") && !val.isEmpty()) {
            prioritytag = val;
         } else if (param.equalsIgnoreCase("--nrpdesc")
               && !val.startsWith("--") && !val.isEmpty()) {
            nrpDesc = val;
         } else if (param.equalsIgnoreCase("--enablenioc")
               && !val.startsWith("--") && !val.isEmpty()) {
            enableNIOC = val;
         } else if (param.equalsIgnoreCase("--option") && !val.startsWith("--")
               && !val.isEmpty()) {
            option = val;
         }
         val = "";
         ai += 2;
      }
      if (option != null) {
         if (!(option.equalsIgnoreCase("enablenioc")
               || option.equalsIgnoreCase("addnrp")
               || option.equalsIgnoreCase("listnrp")
               || option.equalsIgnoreCase("modifynrp") || option
               .equalsIgnoreCase("nrptoportgroup"))) {
            throw new IllegalArgumentException(
                  "Expected valid --option. enablenioc,"
                        + " addnrp, listnrp, modifynrp or nrptoportgroup");
         }
      } else {
         throw new IllegalArgumentException(
               "Expected --option argument. enablenioc,"
                     + " addnrp, listnrp, modifynrp or nrptoportgroup");
      }
      if (option.equalsIgnoreCase("enablenioc")) {
         if (dvsname == null || enableNIOC == null) {
            throw new IllegalArgumentException(
                  "Expected --dvsname and --enablenioc arguments");
         }
      }
      if (option.equalsIgnoreCase("listnrp")) {
         if (dvsname == null) {
            throw new IllegalArgumentException("Expected --dvsname arguments");
         }
      }
      if (option.equalsIgnoreCase("addnrp")
            || option.equalsIgnoreCase("modifynrp")) {
         if (dvsname == null || nrpName == null) {
            throw new IllegalArgumentException(
                  "Expected --dvsname and --nrpname arguments");
         }
         if (nrpAllocationShareLevel != null) {
            if (nrpAllocationShareLevel.matches("\\d+")) {
               noOfShares = Integer.parseInt(nrpAllocationShareLevel);
            } else if (!(nrpAllocationShareLevel
                  .equalsIgnoreCase(SharesLevel.HIGH.toString())
                  || nrpAllocationShareLevel
                        .equalsIgnoreCase(SharesLevel.NORMAL.toString()) || nrpAllocationShareLevel
                  .equalsIgnoreCase(SharesLevel.LOW.toString()))) {
               throw new IllegalArgumentException(
                     "Expected --nrpsharelevel arguments. "
                           + "high, normal, low or numeric");
            }
         }
         if (prioritytag != null) {
            if ((Integer.parseInt(prioritytag) < 0)
                  || (Integer.parseInt(prioritytag) > 7)) {
               throw new IllegalArgumentException(
                     "Expected --nrpprioritytag integer between 0-7");
            }
         }
      }
      if (option.equalsIgnoreCase("nrptoportgroup")) {
         if (dvPGName == null || dvsname == null || nrpName == null) {
            throw new IllegalArgumentException(
                  "Expected --dvsname, --nrpName and --dvpgname arguments");
         }
      }
   }

   /**
    * Enable/Disable network I/O control on the vSphere Distributed Switch.
    * 
    * @param dvSwitchName
    *           VmwareDistributedVirtualSwitch name
    * @param enableNIOC
    *           boolean; true, enables I/O control. false, disables network I/O
    *           control.
    * @throws DvsFaultFaultMsg
    *            Thrown if the enabling/disabling fails.
    * @throws RuntimeFaultFaultMsg
    *            Thrown if any type of runtime fault is thrown that is not
    *            covered by the other faults; for example, a communication
    *            error.
    * @throws InvalidPropertyFaultMsg
    */
   private static void enableNIOC(String dvSwitchName, boolean enableNIOC)
         throws DvsFaultFaultMsg, RuntimeFaultFaultMsg, InvalidPropertyFaultMsg {
      ManagedObjectReference dvsMor =
            getMOREFsInFolderByType(serviceContent.getRootFolder(),
                  "VmwareDistributedVirtualSwitch").get(dvSwitchName);
      if (dvsMor != null) {
         vimPort.enableNetworkResourceManagement(dvsMor, enableNIOC);
         System.out.printf("Set network I/O control");
      } else {
         System.out.println("DVS Switch " + dvSwitchName + " Not Found");
         return;
      }
   }

   /**
    * Add a network resource pool
    * 
    * @param dvSwitchName
    *           VmwareDistributedVirtualSwitch name.
    * @param nrpName
    *           The user defined name for the resource pool.
    * @param nrpDesc
    *           The user defined description for the resource pool.
    * @param noOfShares
    *           The number of shares allocated. Used to determine resource
    *           allocation in case of resource contention. This value is only
    *           set if level is set to custom. If level is not set to custom,
    *           this value is ignored.
    * @param level
    *           The allocation level. The level is a simplified view of shares.
    *           Levels map to a pre-determined set of numeric values for shares.
    * @param prioritytag
    *           The 802.1p tag to be used for this resource pool.
    * @param hostLimit
    *           The maximum allowed usage for network clients belonging to this
    *           resource pool per host.
    * @throws DvsFaultFaultMsg
    *            Thrown if the enabling/disabling fails.
    * @throws InvalidNameFaultMsg
    * @throws RuntimeFaultFaultMsg
    *            Thrown if any type of runtime fault is thrown that is not
    *            covered by the other faults; for example, a communication
    *            error.
    * @throws InvalidPropertyFaultMsg
    */
   private static void addNetworkResourcePool(String dvSwitchName,
         String nrpName, String nrpDesc, int noOfShares, String level,
         String prioritytag, String hostLimit) throws DvsFaultFaultMsg,
         InvalidNameFaultMsg, RuntimeFaultFaultMsg, InvalidPropertyFaultMsg {
      ManagedObjectReference dvsMor =
            getMOREFsInFolderByType(serviceContent.getRootFolder(),
                  "VmwareDistributedVirtualSwitch").get(dvSwitchName);
      if (dvsMor != null) {
         List<DVSNetworkResourcePoolConfigSpec> dvsNetworkRPConfigSpecs =
               new ArrayList<DVSNetworkResourcePoolConfigSpec>();
         DVSNetworkResourcePoolConfigSpec dvsNetworkRPConfigSpec =
               new DVSNetworkResourcePoolConfigSpec();
         DVSNetworkResourcePoolAllocationInfo allocationInfo =
               new DVSNetworkResourcePoolAllocationInfo();
         if (level != null) {
            SharesInfo shares = new SharesInfo();
            if (noOfShares != -1) {
               shares.setLevel(SharesLevel.CUSTOM);
               shares.setShares(noOfShares);
            } else {
               shares.setLevel(SharesLevel.valueOf(level.toUpperCase()));
            }
            allocationInfo.setShares(shares);
         }
         if (hostLimit != null) {
            allocationInfo.setLimit(Long.parseLong(hostLimit));
         }
         if (prioritytag != null) {
            allocationInfo.setPriorityTag(Integer.parseInt(prioritytag));
         }
         dvsNetworkRPConfigSpec.setConfigVersion("0");
         if (nrpDesc != null) {
            dvsNetworkRPConfigSpec.setDescription(nrpDesc);
         } else {
            dvsNetworkRPConfigSpec.setDescription(nrpName);
         }
         dvsNetworkRPConfigSpec.setName(nrpName);
         dvsNetworkRPConfigSpec.setAllocationInfo(allocationInfo);
         dvsNetworkRPConfigSpec.setKey("");
         dvsNetworkRPConfigSpecs.add(dvsNetworkRPConfigSpec);
         vimPort.addNetworkResourcePool(dvsMor, dvsNetworkRPConfigSpecs);
         System.out.printf("Added NetworkResourcePool successfully");
      } else {
         System.out.println("DVS Switch " + dvSwitchName + " Not Found");
         return;
      }
   }

   /**
    * List NetworkResourcePool in a particular DVS switch.
    * 
    * @param dvSwitchName
    *           VmwareDistributedVirtualSwitch name.
    * @throws Exception
    */
   private static void listNetworkResourcePool(String dvSwitchName)
         throws Exception {
      ManagedObjectReference dvsMor =
            getMOREFsInFolderByType(serviceContent.getRootFolder(),
                  "VmwareDistributedVirtualSwitch").get(dvSwitchName);
      if (dvsMor != null) {
         List<DVSNetworkResourcePool> nrpList =
               ((ArrayOfDVSNetworkResourcePool) getEntityProps(dvsMor,
                     new String[] { "networkResourcePool" }).get(
                     "networkResourcePool")).getDVSNetworkResourcePool();
         if (nrpList != null) {
            System.out.println("Existing DVSNetworkResourcePool:");
            for (DVSNetworkResourcePool dvsNrp : nrpList) {
               String nrp = "System defined DVSNetworkResourcePool";
               if (dvsNrp.getKey().startsWith("NRP")) {
                  nrp = "User defined DVSNetworkResourcePool";
               }
               System.out.println(dvsNrp.getName()
                     + " : networkResourcePool[\"" + dvsNrp.getKey() + "\"] : "
                     + nrp);
            }
         } else {
            System.out.println("No NetworkResourcePool found for DVS Switch "
                  + dvSwitchName);
            return;
         }
      } else {
         System.out.println("DVS Switch " + dvSwitchName + " Not Found");
      }
   }

   /**
    * Update the network resource pool configuration.
    * 
    * @param dvSwitchName
    *           VmwareDistributedVirtualSwitch name.
    * @param nrpName
    *           name of the NetworkResourcePool to be updated.
    * @param noOfShares
    *           The number of shares allocated. Used to determine resource
    *           allocation in case of resource contention. This value is only
    *           set if level is set to custom. If level is not set to custom,
    *           this value is ignored.
    * @param level
    *           The allocation level. The level is a simplified view of shares.
    *           Levels map to a pre-determined set of numeric values for shares.
    * @param prioritytag
    *           The 802.1p tag to be used for this resource pool.
    * @param hostLimit
    *           The maximum allowed usage for network clients belonging to this
    *           resource pool per host.
    * @throws Exception
    */
   private static void modifyNetworkResourcePool(String dvSwitchName,
         String nrpName, int noOfShares, String level, String prioritytag,
         String hostLimit) throws Exception {
      ManagedObjectReference dvsMor =
            getMOREFsInFolderByType(serviceContent.getRootFolder(),
                  "VmwareDistributedVirtualSwitch").get(dvSwitchName);
      if (dvsMor != null) {
         List<DVSNetworkResourcePool> nrpList =
               ((ArrayOfDVSNetworkResourcePool) getEntityProps(dvsMor,
                     new String[] { "networkResourcePool" }).get(
                     "networkResourcePool")).getDVSNetworkResourcePool();
         if (nrpList != null) {
            String configVersion = null;
            String nrpKey = null;
            for (DVSNetworkResourcePool dvsNrp : nrpList) {
               if (dvsNrp.getName().equalsIgnoreCase(nrpName)) {
                  nrpKey = dvsNrp.getKey();
                  configVersion = dvsNrp.getConfigVersion();
               }
            }
            if (nrpKey == null) {
               System.out.println("NetworkResource Pool " + nrpName
                     + " Not Found");
               return;
            }
            List<DVSNetworkResourcePoolConfigSpec> dvsNetworkRPConfigSpecs =
                  new ArrayList<DVSNetworkResourcePoolConfigSpec>();
            DVSNetworkResourcePoolConfigSpec dvsNetworkRPConfigSpec =
                  new DVSNetworkResourcePoolConfigSpec();
            DVSNetworkResourcePoolAllocationInfo allocationInfo =
                  new DVSNetworkResourcePoolAllocationInfo();
            if (level != null) {
               SharesInfo shares = new SharesInfo();
               if (noOfShares != -1) {
                  shares.setLevel(SharesLevel.CUSTOM);
                  shares.setShares(noOfShares);
               } else {
                  shares.setLevel(SharesLevel.valueOf(level.toUpperCase()));
               }
               allocationInfo.setShares(shares);
            }
            if (hostLimit != null) {
               allocationInfo.setLimit(Long.parseLong(hostLimit));
            }
            if (prioritytag != null) {
               allocationInfo.setPriorityTag(Integer.parseInt(prioritytag));
            }
            dvsNetworkRPConfigSpec.setConfigVersion(configVersion);
            dvsNetworkRPConfigSpec.setAllocationInfo(allocationInfo);
            dvsNetworkRPConfigSpec.setKey(nrpKey);
            dvsNetworkRPConfigSpecs.add(dvsNetworkRPConfigSpec);
            vimPort.updateNetworkResourcePool(dvsMor, dvsNetworkRPConfigSpecs);
            System.out.printf("Modified NetworkResourcePool successfully");
         } else {
            System.out.println("No NetworkResourcePool found for DVS Switch "
                  + dvSwitchName);
            return;
         }
      } else {
         System.out.println("DVS Switch " + dvSwitchName + " Not Found");
         return;
      }
   }

   /**
    * Reconfigure DVS PortGroup to associate it with a NetworkResourcePool.
    * 
    * @param dvSwitchName
    *           The name of VmwareDistributedVirtualSwitch having
    *           NetworkResourcePool to be associated with port group.
    * @param nrpName
    *           The name of NetworkResourcePool to be associated with port
    *           group.
    * @param dvPortGroupName
    *           The name of the portgroup.
    * @throws RemoteException
    * @throws RuntimeFaultFaultMsg
    * @throws InvalidPropertyFaultMsg
    * @throws InvalidNameFaultMsg
    * @throws DvsFaultFaultMsg
    * @throws DuplicateNameFaultMsg
    * @throws ConcurrentAccessFaultMsg
    * @throws InvalidCollectorVersionFaultMsg
    * @throws Exception
    */
   private static void reconfigureDVSPG(String dvSwitchName, String nrpName,
         String dvPortGroupName) throws RemoteException,
         InvalidPropertyFaultMsg, RuntimeFaultFaultMsg,
         ConcurrentAccessFaultMsg, DuplicateNameFaultMsg, DvsFaultFaultMsg,
         InvalidNameFaultMsg, InvalidCollectorVersionFaultMsg {

      ManagedObjectReference dvsMor =
            getMOREFsInFolderByType(serviceContent.getRootFolder(),
                  "VmwareDistributedVirtualSwitch").get(dvSwitchName);
      if (dvsMor != null) {
         List<DVSNetworkResourcePool> nrpList =
               ((ArrayOfDVSNetworkResourcePool) getEntityProps(dvsMor,
                     new String[] { "networkResourcePool" }).get(
                     "networkResourcePool")).getDVSNetworkResourcePool();
         String nrpKey = null;
         if (nrpList != null) {
            for (DVSNetworkResourcePool dvsNrp : nrpList) {
               if (dvsNrp.getName().equalsIgnoreCase(nrpName)) {
                  nrpKey = dvsNrp.getKey();
               }
            }
            if (nrpKey == null) {
               System.out.println("NetworkResourcePool " + nrpName
                     + " Not Found");
               return;
            }
         } else {
            System.out.println("No NetworkResourcePool found for DVS Switch "
                  + dvSwitchName);
            return;
         }
         ManagedObjectReference dvspgMor =
               getMOREFsInFolderByType(serviceContent.getRootFolder(),
                     "DistributedVirtualPortgroup").get(dvPortGroupName);
         if (dvspgMor != null) {
            DVPortgroupConfigInfo configInfo =
                  (DVPortgroupConfigInfo) getEntityProps(dvspgMor,
                        new String[] { "config" }).get("config");
            String dvPortGroupConfigVersion = configInfo.getConfigVersion();
            DVPortgroupConfigSpec dvPortGConfigSpec =
                  new DVPortgroupConfigSpec();
            DVPortSetting portSetting = new DVPortSetting();
            StringPolicy networkResourcePoolKey = new StringPolicy();
            networkResourcePoolKey.setValue(nrpKey);
            networkResourcePoolKey.setInherited(false);
            portSetting.setNetworkResourcePoolKey(networkResourcePoolKey);
            dvPortGConfigSpec.setName(dvPortGroupName);
            dvPortGConfigSpec.setConfigVersion(dvPortGroupConfigVersion);
            dvPortGConfigSpec.setDefaultPortConfig(portSetting);
            ManagedObjectReference taskmor =
                  vimPort.reconfigureDVPortgroupTask(dvspgMor,
                        dvPortGConfigSpec);
            if (getTaskResultAfterDone(taskmor)) {
               System.out.printf("Success: Reconfiguring Port Group");
            } else {
               throw new RuntimeException("Failure: Reconfiguring Port Group");
            }
         } else {
            System.out.println("DVS port group " + dvPortGroupName
                  + " Not Found");
            return;
         }
      } else {
         System.out.println("DVS Switch " + dvSwitchName + " Not Found");
      }
   }

   // method to print help on how to run the sample
   private static void printUsage() {
      System.out
            .println("Used to add/modify NetworkResourcePool to Distributed"
                  + " Virtual Switch:");
      System.out
            .println("url               : [required] url of the web service.");
      System.out
            .println("username          : [required] username for authentication");
      System.out
            .println("Password          : [required] password for authentication");
      System.out
            .println("option            : [required] \"enablenioc\" for enabling"
                  + " network I/O control OR \"addnrp\" for adding NetworkResourcePool OR "
                  + "\"listnrp\" for listing existing DVSNetworkResourcePool OR \"modifynrp\" "
                  + "for reconfiguring NetworkResourcePool OR \"nrptoportgroup\" "
                  + "for associating DVSPortGroup with a specific NetworkResourcePool");
      System.out
            .println("dvsname           : [required] Distributed Virtual Switch name");
      System.out
            .println("enablenioc        : If true, enables I/O control. If false,"
                  + " disables network I/O control");
      System.out
            .println("nrpsharelevel     : [optional] The allocation level. The level is a "
                  + "simplified view of shares. Levels map to a pre-determined set of numeric "
                  + "values for shares. If the shares value does not map to a predefined size, "
                  + "then the level is set as custom. ");
      System.out
            .println("nrphostlimit      : [optional] Numeric value: The maximum allowed usage "
                  + "for network clients belonging to this resource pool per host.");
      System.out
            .println("nrpprioritytag    : [optional] Numeric value: The 802.1p tag to be used "
                  + "for this resource pool. Its value should be between 0-7");
      System.out
            .println("nrpname           : The user defined name for the resource pool.");
      System.out
            .println("nrpdesc           : [optional] The user defined description"
                  + " for the resource pool.");
      System.out.println("dvpgname          : The name of the portgroup. ");
      System.out.println("\nEnable Network I/O Control:");
      System.out
            .println("run.bat com.vmware.host.NIOCForDVS "
                  + "--url [URLString] --username [User] --password [Password] --option enablenioc");
      System.out.println(" --dvsname [dvsname] --enablenioc [enablenioc]");
      System.out.println("\nAdd NetworkResourcePool:");
      System.out
            .println("run.bat com.vmware.host.NIOCForDVS "
                  + "--url [URLString] --username [User] --password [Password] --option addnrp");
      System.out
            .println(" --dvsname [dvsname] --nrpsharelevel [nrpsharelevel] "
                  + " --nrphostlimit [nrphostlimit] --nrpprioritytag [nrpprioritytag] --nrpname"
                  + " [nrpname] --nrpdesc [nrpdesc] ");
      System.out.println("\nList NetworkResourcePool:");
      System.out
            .println("run.bat com.vmware.host.NIOCForDVS "
                  + "--url [URLString] --username [User] --password [Password] --option listnrp");
      System.out.println(" --dvsname [dvsname]");
      System.out.println("\nReconfiguring NetworkResourcePool:");
      System.out
            .println("run.bat com.vmware.host.NIOCForDVS "
                  + "--url [URLString] --username [User] --password [Password] --option modifynrp");
      System.out
            .println(" --dvsname [dvsname] --nrpsharelevel [nrpsharelevel] "
                  + " --nrphostlimit [nrphostlimit] --nrpprioritytag [nrpprioritytag] --nrpname [nrpname]");
      System.out.println("\nAssociate DVSPortGroup to NetworkResourcePool :");
      System.out
            .println("run.bat com.vmware.host.NIOCForDVS "
                  + "--url [URLString] --username [User] --password [Password] --option nrptoportgroup");
      System.out
            .println(" --dvsname [dvsname] --nrpname [nrpname] --dvpgname [dvpgname]");
      System.out.println("\n\nNote: Sample only works for DVS 5.0 onwards");
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
         if (option.equalsIgnoreCase("enablenioc")) {
            enableNIOC(dvsname, Boolean.parseBoolean(enableNIOC));
         } else if (option.equalsIgnoreCase("addnrp")) {
            addNetworkResourcePool(dvsname, nrpName, nrpDesc, noOfShares,
                  nrpAllocationShareLevel, prioritytag, hostLimit);
         } else if (option.equalsIgnoreCase("listnrp")) {
            listNetworkResourcePool(dvsname);
         } else if (option.equalsIgnoreCase("modifynrp")) {
            modifyNetworkResourcePool(dvsname, nrpName, noOfShares,
                  nrpAllocationShareLevel, prioritytag, hostLimit);
         } else if (option.equalsIgnoreCase("nrptoportgroup")) {
            reconfigureDVSPG(dvsname, nrpName, dvPGName);
         }
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
         printUsage();
      } catch (Exception e) {
         System.out.println("Exception encountered " + e);
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
