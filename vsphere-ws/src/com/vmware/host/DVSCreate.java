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

import com.vmware.vim25.DVPortgroupConfigSpec;
import com.vmware.vim25.DVSCapability;
import com.vmware.vim25.DVSConfigSpec;
import com.vmware.vim25.DVSCreateSpec;
import com.vmware.vim25.DVSPolicy;
import com.vmware.vim25.DistributedVirtualSwitchHostProductSpec;
import com.vmware.vim25.DistributedVirtualSwitchProductSpec;
import com.vmware.vim25.DuplicateNameFaultMsg;
import com.vmware.vim25.DvsFaultFaultMsg;
import com.vmware.vim25.DvsNotAuthorizedFaultMsg;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.InvalidCollectorVersionFaultMsg;
import com.vmware.vim25.InvalidNameFaultMsg;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.LocalizedMethodFault;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NotFoundFaultMsg;
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
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * This sample demonstrates how to create/update Distributed Virtual Switch
 * <b>Parameters:</b>
 * url               [required]: url of the web service.
 * username          [required]: username for the authentication
 * Password          [required]: password for the authentication
 * option            [required]:
 *                       "createdvs" for creating a new DVS
 *                       "addportgroup" for adding a port group to DVS
 * dcname            : Datacenter name
 * dvsname           [required]: Distributed Virtual Switch name
 * dvsdesc           [optional]: Description string of the switch
 * dvsversion        : Distributed Virtual Switch either 4.0, 4.1.0, 5.0.0 or 5.1.0
 * numports          : Number of ports in the portgroup.
 * portgroupname     : Name of the port group.
 * 
 * <b>Sample usage:</b>
 * Create DVS : run.bat com.vmware.host.DVSCreate --url [URLString] --username [User]
 *              --password [Password] --option createdvs --dcname [dcname]
 *              --dvsname [dvsname] --dvsversion [dvsversion]
 * Add PortGroup : run.bat com.vmware.host.DVSCreate --url [URLString] --username [User]
 *                 --password [Password] --option addportgroup --dvsname [dvsname]
 *                 --numports [numports] --portgroupname [portgroupname]
 * </pre>
 */

public class DVSCreate {

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
   /* Connection input parameters*/
   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
   private static String dcName = null;
   private static String dvsName = null;
   private static String dvsDesc = null;
   private static String dvsVersion = null;
   private static String noOfPorts;
   private static String portGroupName = null;
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
         } else if (param.equalsIgnoreCase("--dvsname")
               && !val.startsWith("--") && !val.isEmpty()) {
            dvsName = val;
         } else if (param.equalsIgnoreCase("--dvsdesc")
               && !val.startsWith("--") && !val.isEmpty()) {
            dvsDesc = val;
         } else if (param.equalsIgnoreCase("--dvsversion")
               && !val.startsWith("--") && !val.isEmpty()) {
            dvsVersion = val;
         } else if (param.equalsIgnoreCase("--numports")
               && !val.startsWith("--") && !val.isEmpty()) {
            noOfPorts = val;
         } else if (param.equalsIgnoreCase("--portgroupname")
               && !val.startsWith("--") && !val.isEmpty()) {
            portGroupName = val;
         } else if (param.equalsIgnoreCase("--option") && !val.startsWith("--")
               && !val.isEmpty()) {
            option = val;
         }
         val = "";
         ai += 2;
      }
      if (option != null) {
         if (!(option.equals("createdvs") || option.equals("addportgroup"))) {
            throw new IllegalArgumentException(
                  "Expected valid --option. createdvs" + " or addportgroup");
         }
      } else {
         throw new IllegalArgumentException(
               "Expected --option argument. createdvs" + " or addportgroup");
      }
      if (option.equals("createdvs")) {
         if (dcName == null || dvsName == null) {
            throw new IllegalArgumentException(
                  "Expected --dcname and --dvsname arguments");
         }
      }
      if (option.equals("addportgroup")) {
         if (dvsName == null || noOfPorts == null || portGroupName == null) {
            throw new IllegalArgumentException(
                  "Expected --dvsname, --numports and --portgroupname arguments");
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


   // Create DVSConfigSpec for creating a DVS.
   private static DVSConfigSpec getDVSConfigSpec(String dvsName, String dvsDesc) {
      DVSConfigSpec dvsConfigSpec = new DVSConfigSpec();
      dvsConfigSpec.setName(dvsName);
      if (dvsDesc != null) {
         dvsConfigSpec.setDescription(dvsDesc);
      }
      DVSPolicy dvsPolicy = new DVSPolicy();
      dvsPolicy.setAutoPreInstallAllowed(new Boolean(true));
      dvsPolicy.setAutoUpgradeAllowed(new Boolean(true));
      dvsPolicy.setPartialUpgradeAllowed(new Boolean(true));
      return dvsConfigSpec;
   }

   // Fetch DistributedVirtualSwitchProductSpec.
   private static DistributedVirtualSwitchProductSpec getDVSProductSpec(
         String version) throws RuntimeFaultFaultMsg {
      List<DistributedVirtualSwitchProductSpec> dvsProdSpec =
            vimPort.queryAvailableDvsSpec(serviceContent.getDvSwitchManager());
      DistributedVirtualSwitchProductSpec dvsSpec = null;
      if (version != null) {
         for (DistributedVirtualSwitchProductSpec prodSpec : dvsProdSpec) {
            if (version.equalsIgnoreCase(prodSpec.getVersion())) {
               dvsSpec = prodSpec;
            }
         }
         if (dvsSpec == null) {
            throw new IllegalArgumentException("DVS Version " + version
                  + " not supported.");
         }
      } else {
         dvsSpec = dvsProdSpec.get(dvsProdSpec.size() - 1);
      }
      return dvsSpec;
   }

   /**
    * Create a Distributed Virtual Switch.
    * 
    * @param dcName
    *           The Datacenter name.
    * @param dvsName
    *           The DVS name.
    * @param dvsDesc
    *           The DVS description.
    * @param version
    *           Dot-separated version string.
    * @throws InvalidCollectorVersionFaultMsg
    * @throws RuntimeFaultFaultMsg
    * @throws InvalidPropertyFaultMsg
    * @throws NotFoundFaultMsg
    * @throws InvalidNameFaultMsg
    * @throws DvsNotAuthorizedFaultMsg
    * @throws DvsFaultFaultMsg
    * @throws DuplicateNameFaultMsg
    */
   private static void createDVS(String dcName, String dvsName, String dvsDesc,
         String version) throws InvalidCollectorVersionFaultMsg,
         RuntimeFaultFaultMsg, InvalidPropertyFaultMsg, DuplicateNameFaultMsg,
         DvsFaultFaultMsg, DvsNotAuthorizedFaultMsg, InvalidNameFaultMsg,
         NotFoundFaultMsg {
      DistributedVirtualSwitchProductSpec dvsProdSpec =
            getDVSProductSpec(version);
      ManagedObjectReference dcmor =
            getMOREFsInFolderByType(serviceContent.getRootFolder(),
                  "Datacenter").get(dcName);
      if (dcmor == null) {
         System.out.println("Datacenter " + dcName + " not found.");
         return;
      }
      ManagedObjectReference networkmor =
            (ManagedObjectReference) getEntityProps(dcmor,
                  new String[] { "networkFolder" }).get("networkFolder");

      DVSCreateSpec dvsspec = new DVSCreateSpec();
      List<DistributedVirtualSwitchHostProductSpec> dvsHostProdSpec =
            vimPort.queryDvsCompatibleHostSpec(
                  serviceContent.getDvSwitchManager(), dvsProdSpec);
      DVSCapability dvsCapability = new DVSCapability();
      dvsCapability.getCompatibleHostComponentProductInfo().addAll(
            dvsHostProdSpec);
      dvsspec.setCapability(dvsCapability);
      dvsspec.setConfigSpec(getDVSConfigSpec(dvsName, dvsDesc));
      dvsspec.setProductInfo(dvsProdSpec);

      ManagedObjectReference taskmor =
            vimPort.createDVSTask(networkmor, dvsspec);

      if (getTaskResultAfterDone(taskmor)) {
         System.out.printf("Success: Creating Distributed Virtual Switch");
      } else {
         throw new RuntimeException(
               "Failure: Creating Distributed Virtual Switch");
      }
   }

   /**
    * Add a DistributedVirtualPortgroup to the switch.
    * 
    * @param dvSwitchName
    *           The DVS name.
    * @param numOfPorts
    *           Number of ports in the portgroup.
    * @param portGroupName
    *           The name of the portgroup.
    * @throws RemoteException
    * @throws RuntimeFaultFaultMsg
    * @throws InvalidPropertyFaultMsg
    * @throws InvalidNameFaultMsg
    * @throws DvsFaultFaultMsg
    * @throws DuplicateNameFaultMsg
    * @throws InvalidCollectorVersionFaultMsg
    * @throws Exception
    */
   private static void addPortGroup(String dvSwitchName, int numOfPorts,
         String portGroupName) throws RemoteException, InvalidPropertyFaultMsg,
         RuntimeFaultFaultMsg, DuplicateNameFaultMsg, DvsFaultFaultMsg,
         InvalidNameFaultMsg, InvalidCollectorVersionFaultMsg {
      ManagedObjectReference dvsMor =
            getMOREFsInFolderByType(serviceContent.getRootFolder(),
                  "VmwareDistributedVirtualSwitch").get(dvSwitchName);
      if (dvsMor != null) {
         DVPortgroupConfigSpec portGroupConfigSpec =
               new DVPortgroupConfigSpec();

         portGroupConfigSpec.setName(portGroupName);
         portGroupConfigSpec.setNumPorts(numOfPorts);
         portGroupConfigSpec.setType("earlyBinding");

         List<DVPortgroupConfigSpec> listDVSPortConfigSpec =
               new ArrayList<DVPortgroupConfigSpec>();
         listDVSPortConfigSpec.add(portGroupConfigSpec);

         ManagedObjectReference taskmor =
               vimPort.addDVPortgroupTask(dvsMor, listDVSPortConfigSpec);

         if (getTaskResultAfterDone(taskmor)) {
            System.out.printf("Success: Adding Port Group");
         } else {
            throw new RuntimeException("Failure: Adding Port Group");
         }
      } else {
         System.out.println("DVS Switch " + dvSwitchName + " Not Found");
         return;
      }
   }

   // Method to print help on how to run the sample
   private static void printUsage() {
      System.out.println("\nUsed to create/update Distributed Virtual Switch:");
      System.out
            .println("url               [required]: url of the web service.");
      System.out
            .println("username          [required]: username for the authentication");
      System.out
            .println("Password          [required]: password for the authentication");
      System.out
            .println("option            [required]: \"createdvs\" for creating a "
                  + "new DVS OR \"addportgroup\" for adding a port group to DVS");
      System.out.println("dcname            : Datacenter name");
      System.out
            .println("dvsname           [required]: Distributed Virtual Switch name");
      System.out
            .println("dvsdesc           [optional]: Description string of the switch");
      System.out.println("dvsversion        : Distributed Virtual Switch"
            + " either 4.0, 4.1.0, 5.0.0 or 5.1.0");
      System.out
            .println("numports          : Number of ports in the portgroup.");
      System.out.println("portgroupname     : Name of the port group.");
      System.out.println("\nCreate DVS : ");
      System.out.println("run.bat com.vmware.host.DVSCreate "
            + "--url [URLString] --username [User] --password [Password]"
            + " --option createdvs --dcname [dcname] --dvsname [dvsname]"
            + " --dvsversion [dvsversion]");
      System.out.println("\nAdd PortGroup : ");
      System.out
            .println("run.bat com.vmware.host.DVSCreate "
                  + "--url [URLString] --username [User] --password [Password]"
                  + " --option addportgroup --dvsname [dvsname] --numports [numports]"
                  + " --portgroupname [portgroupname]");
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
         if (option.equals("createdvs")) {
            createDVS(dcName, dvsName, dvsDesc, dvsVersion);
         } else if (option.equals("addportgroup")) {
            addPortGroup(dvsName, Integer.parseInt(noOfPorts), portGroupName);
         }
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
