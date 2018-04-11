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
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.ArrayOfComplianceResult;
import com.vmware.vim25.ComplianceFailure;
import com.vmware.vim25.ComplianceResult;
import com.vmware.vim25.DuplicateName;
import com.vmware.vim25.DuplicateNameFaultMsg;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.HostConfigFailed;
import com.vmware.vim25.HostConfigSpec;
import com.vmware.vim25.HostProfileHostBasedConfigSpec;
import com.vmware.vim25.HostProfileManagerConfigTaskList;
import com.vmware.vim25.InvalidCollectorVersionFaultMsg;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.LocalizableMessage;
import com.vmware.vim25.LocalizedMethodFault;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.ObjectUpdate;
import com.vmware.vim25.ObjectUpdateKind;
import com.vmware.vim25.ProfileExecuteError;
import com.vmware.vim25.ProfileExecuteResult;
import com.vmware.vim25.PropertyChange;
import com.vmware.vim25.PropertyChangeOp;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertyFilterUpdate;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * This sample demonstrates HostProfileManager and ProfileComplainceManager
 * 
 * <b>Parameters:</b>
 * url              [required] : url of the web service
 * username         [required] : username for the authentication
 * password         [required] : password for the authentication
 * sourcehostname   [required] : Name of the host
 * entityname       [required] : Attached Entity Name
 * entitytype       [required] : Attached Entity Type
 * 
 * <b>Command Line:</b>
 * Create hostprofile given profileSourceHost (host system)
 * profileAttachEntity (host system), profileAttachEntityType (host system)
 * Applies config after attaching hostprofile to host system and check for compliance");
 * run.bat com.vmware.host.HostProfileManager --url [webserviceurl]");
 * --username [username] --password [password] --sourcehostname [host name]
 * --entityname [host name] --entitytype HostSystem
 * 
 * Create hostprofile given profileSourceHost (host system),
 * profileAttachEntity (cluster computer resource), profileAttachEntityType
 * (cluster compute resource)
 * Attaches hostprofile to all hosts in cluster and checks for compliance
 * run.bat com.vmware.host.HostProfileManager --url [webserviceurl]
 * --username [username] --password  [password] --sourcehostname [host name]
 * --entityname [Cluster] --entitytype ClusterComputeResource
 * </pre>
 */

public class HostProfileManager {

   private static class TrustAllTrustManager1 implements
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
   private static VimPortType vimPort;
   private static VimService vimService;
   private static ServiceContent serviceContent;
   private static ManagedObjectReference hostprofileManager;
   private static ManagedObjectReference profilecomplianceManager;

   private static String url;
   private static String userName;
   private static String password;
   private static Boolean help = false;
   private static String createHostEntityName;
   private static String attachEntityName;
   private static String attachEntityType;
   private static Boolean isConnected = false;


   private static void getConnectionParameters(String[] args) {
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

   private static void trustAllHttpsCertificates() throws Exception {
      javax.net.ssl.TrustManager[] trustAllCerts =
            new javax.net.ssl.TrustManager[1];
      javax.net.ssl.TrustManager tm = new TrustAllTrustManager1();
      trustAllCerts[0] = tm;
      javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
      javax.net.ssl.SSLSessionContext sslsc = sc.getServerSessionContext();
      sslsc.setSessionTimeout(0);
      sc.init(null, trustAllCerts, null);
      HttpsURLConnection.setDefaultSSLSocketFactory(sc
            .getSocketFactory());
   }

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
      hostprofileManager = serviceContent.getHostProfileManager();
      profilecomplianceManager = serviceContent.getComplianceManager();
   }

   private static void getInputParameters(String[] args) {

      int ai = 0;
      String param = "";
      String val = "";
      while (ai < args.length) {
         param = args[ai].trim();
         if (ai + 1 < args.length) {
            val = args[ai + 1].trim();
         }
         if (param.equalsIgnoreCase("--sourcehostname")
               && !val.startsWith("--") && !val.isEmpty()) {
            createHostEntityName = val;
         }
         if (param.equalsIgnoreCase("--entityname") && !val.startsWith("--")
               && !val.isEmpty()) {
            attachEntityName = val;
         }
         if (param.equalsIgnoreCase("--entitytype") && !val.startsWith("--")
               && !val.isEmpty()) {
            attachEntityType = val;
         }
         val = "";
         ai += 2;
      }
      if (createHostEntityName == null || attachEntityName == null
            || attachEntityType == null) {
         throw new IllegalArgumentException(
               "Expected --sourcehostname, --entityname, --entitytype arguments properly");
      }
   }

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

   /**
    * Create a profile from the specified CreateSpec.
    * HostProfileHostBasedConfigSpec is created from the hostEntitymoref
    * (create_host_entity_name) reference. Using this spec a hostProfile is
    * created.
    * 
    * @param hostEntitymoref
    * @return
    * @throws DuplicateName
    * @throws RuntimeFault
    * @throws RemoteException
    */
   private static ManagedObjectReference createHostProfile(
         ManagedObjectReference hostEntitymoref) throws DuplicateNameFaultMsg,
         RuntimeFaultFaultMsg {
      HostProfileHostBasedConfigSpec hostProfileHostBasedConfigSpec =
            new HostProfileHostBasedConfigSpec();
      hostProfileHostBasedConfigSpec.setHost(hostEntitymoref);
      hostProfileHostBasedConfigSpec.setAnnotation("SDK Sample Host Profile");
      hostProfileHostBasedConfigSpec.setEnabled(true);
      hostProfileHostBasedConfigSpec.setName("SDK Profile "
            + createHostEntityName);
      System.out.println("--------------------");
      System.out.println("* Creating Host Profile");
      System.out.println("--------------------");
      ManagedObjectReference hostProfile =
            vimPort.createProfile(hostprofileManager,
                  hostProfileHostBasedConfigSpec);
      // Changed from get_value to getValue
      System.out.println("Profile : " + hostProfile.getValue());
      System.out.println("Host : " + hostEntitymoref.getValue());
      return hostProfile;
   }

   /**
    * Associate a profile with a managed entity. The created hostProfile is
    * attached to a hostEntityMoref (ATTACH_HOST_ENTITY_NAME). We attach only
    * one host to the host profile
    * 
    * @param hostProfile
    * @param attachEntitymorefs
    * @throws RuntimeFault
    * @throws RemoteException
    */
   private static void attachProfileWithManagedEntity(
         ManagedObjectReference hostProfile,
         List<ManagedObjectReference> attachEntitymorefs)
         throws RuntimeFaultFaultMsg {
      System.out.println("------------------------");
      System.out.println("* Associating Host Profile");
      System.out.println("------------------------");
      vimPort.associateProfile(hostProfile, attachEntitymorefs);
      System.out.println("Associated " + hostProfile.getValue() + " with "
            + attachEntitymorefs.get(0).getValue());
   }

   /**
    * Get the profile(s) to which this entity is associated. The list of
    * profiles will only include profiles known to this profileManager.
    * 
    * @param attachMoref
    * @throws RuntimeFault
    * @throws RemoteException
    */
   private static void printProfilesAssociatedWithEntity(
         ManagedObjectReference attachMoref) throws RuntimeFaultFaultMsg {
      System.out.println("------------------------------------");
      System.out.println("* Finding Associated Profiles with Host");
      System.out.println("------------------------------------");
      System.out.println("Profiles");
      for (ManagedObjectReference profile : vimPort.findAssociatedProfile(
            hostprofileManager, attachMoref)) {
         System.out.println("    " + profile.getValue());
      }
   }

   /**
    * Update the reference host in use by the HostProfile.
    * 
    * @param hostProfile
    * @param attachHostMoref
    * @throws RuntimeFault
    * @throws RemoteException
    */
   private static void updateReferenceHost(ManagedObjectReference hostProfile,
         ManagedObjectReference attachHostMoref) throws RuntimeFaultFaultMsg {
      System.out.println("--------------------------------------");
      System.out.println("* Updating Reference Host for the Profile");
      System.out.println("--------------------------------------");
      vimPort.updateReferenceHost(hostProfile, attachHostMoref);
      System.out.println("Updated Host Profile : " + hostProfile.getValue()
            + " Reference to " + attachHostMoref.getValue());
   }

   /**
    * Execute the Profile Engine to calculate the list of configuration changes
    * needed for the host.
    * 
    * @param hostProfile
    * @param attachHostMoref
    * @return
    * @throws RuntimeFault
    * @throws RemoteException
    */
   private static HostConfigSpec executeHostProfile(
         ManagedObjectReference hostProfile,
         ManagedObjectReference attachHostMoref) throws RuntimeFaultFaultMsg {

      System.out.println("------------------------------");
      System.out.println("* Executing Profile Against Host");
      System.out.println("------------------------------");
      ProfileExecuteResult profileExecuteResult =
            vimPort.executeHostProfile(hostProfile, attachHostMoref, null);
      System.out.println("Status : " + profileExecuteResult.getStatus());
      if (profileExecuteResult.getStatus().equals("success")) {
         System.out.println("Valid HostConfigSpec representing "
               + "Configuration changes to be made on host");
         return profileExecuteResult.getConfigSpec();
      }
      if (profileExecuteResult.getStatus().equals("error")) {
         System.out.println("List of Errors");
         for (ProfileExecuteError profileExecuteError : profileExecuteResult
               .getError()) {
            System.out.println("    "
                  + profileExecuteError.getMessage().getMessage());
         }
         return null;
      }
      return null;
   }

   /**
    * Generate a list of configuration tasks that will be performed on the host
    * during HostProfile application.
    * 
    * @param hostConfigSpec
    * @param attachHostMoref
    * @throws RuntimeFault
    * @throws RemoteException
    */
   private static void configurationTasksToBeAppliedOnHost(
         HostConfigSpec hostConfigSpec, ManagedObjectReference attachHostMoref)
         throws RuntimeFaultFaultMsg {

      System.out
            .println("-------------------------------------------------------");
      System.out
            .println("* Config Tasks on the Host during HostProfile Application");
      System.out
            .println("-------------------------------------------------------");
      HostProfileManagerConfigTaskList hostProfileManagerConfigTaskList =
            vimPort.generateConfigTaskList(hostprofileManager, hostConfigSpec,
                  attachHostMoref);
      List<LocalizableMessage> taskMessages =
            hostProfileManagerConfigTaskList.getTaskDescription();
      if (taskMessages != null) {
         for (LocalizableMessage taskMessage : taskMessages) {
            System.out.println("Message : " + taskMessage.getMessage());
         }
      } else {
         System.out.println("There are no configuration changes to be made");
      }
   }

   /**
    * Checking for the compliance status and results. If compliance is
    * "nonCompliant", it lists all the compliance failures.
    * 
    * @param resultone
    * @return
    */
   private static boolean complianceStatusAndResults(Object result) {
      List<ComplianceResult> complianceResults =
            ((ArrayOfComplianceResult) result).getComplianceResult();
      for (ComplianceResult complianceResult : complianceResults) {
         System.out
               .println("Host : " + complianceResult.getEntity().getValue());
         System.out.println("Profile : "
               + complianceResult.getProfile().getValue());
         System.out.println("Compliance Status : "
               + complianceResult.getComplianceStatus());
         if (complianceResult.getComplianceStatus().equals("nonCompliant")) {
            System.out.println("Compliance Failure Reason");
            for (ComplianceFailure complianceFailure : complianceResult
                  .getFailure()) {
               System.out.println(" "
                     + complianceFailure.getMessage().getMessage());
            }
            return false;
         } else {
            return true;
         }
      }
      return false;

   }

   /**
    * Check compliance of an entity against a Profile.
    * 
    * @param profiles
    * @param entities
    * @return
    * @throws RuntimeFault
    * @throws RemoteException
    */
   private static boolean checkProfileCompliance(
         List<ManagedObjectReference> profiles,
         List<ManagedObjectReference> entities) throws RemoteException,
         Exception {
      System.out.println("---------------------------------------------");
      System.out.println("* Checking Complaince of Entity against Profile");
      System.out.println("---------------------------------------------");
      List<String> opts = new ArrayList<String>();
      opts.add("info.state");
      opts.add("info.error");
      List<String> opt = new ArrayList<String>();
      opt.add("state");
      ManagedObjectReference cpctask =
            vimPort.checkComplianceTask(profilecomplianceManager, profiles,
                  entities);
      if (getTaskResultAfterDone(cpctask)) {
         System.out.printf("Success: Entered Maintenance Mode ");
      } else {
         throw new RuntimeException("Failure: Entering Maintenance Mode");
      }
      Object result =
            getEntityProps(cpctask, new String[] { "info.result" }).get(
                  "info.result");
      return complianceStatusAndResults(result);
   }

   /**
    * Setting the host to maintenance mode and apply the configuration to the
    * host.
    * 
    * @param attachHostMoref
    * @param hostConfigSpec
    * @throws HostConfigFailed
    * @throws InvalidState
    * @throws RuntimeFault
    * @throws RemoteException
    */
   private static void applyConfigurationToHost(
         ManagedObjectReference attachHostMoref, HostConfigSpec hostConfigSpec)
         throws RemoteException, Exception {
      System.out
            .println("----------------------------------------------------");
      System.out
            .println("* Applying Configuration changes or HostProfile to Host");
      System.out
            .println("----------------------------------------------------");
      System.out.println("Putting Host in Maintenance Mode");
      List<String> opts = new ArrayList<String>();
      opts.add("info.state");
      opts.add("info.error");
      List<String> opt = new ArrayList<String>();
      opt.add("state");
      ManagedObjectReference mainmodetask =
            vimPort.enterMaintenanceModeTask(attachHostMoref, 0, null);
      Object[] result =
            waitForValues(mainmodetask, new String[] { "info.state",
                  "info.error" }, new String[] { "state" },
                  new Object[][] { new Object[] { TaskInfoState.SUCCESS,
                        TaskInfoState.ERROR } });
      if (result[0].equals(TaskInfoState.SUCCESS)) {
         System.out.printf("Success: Entered Maintenance Mode ");
      } else {
         String msg = "Failure: Entering Maintenance Mode";
         throw new Exception(msg);
      }
      System.out.println("Applying Profile to Host");
      ManagedObjectReference apphostconftask =
            vimPort.applyHostConfigTask(hostprofileManager, attachHostMoref,
                  hostConfigSpec, null);
      Object[] resultone =
            waitForValues(apphostconftask, new String[] { "info.state",
                  "info.error" }, new String[] { "state" },
                  new Object[][] { new Object[] { TaskInfoState.SUCCESS,
                        TaskInfoState.ERROR } });
      if (resultone[0].equals(TaskInfoState.SUCCESS)) {
         System.out.printf("Success: Apply Configuration to Host ");
      } else {
         String msg = "Failure: Apply configuration to Host";
         throw new Exception(msg);
      }
   }

   /*
    * Destroy the Profile.
    *
    * @param hostProfile
    * @throws RuntimeFault
    * @throws RemoteException
    */
   private static void deleteHostProfile(ManagedObjectReference hostProfile)
         throws RuntimeFaultFaultMsg {
      System.out.println("Deleting Profile");
      System.out.println("---------------");
      vimPort.destroyProfile(hostProfile);
      System.out.println("Profile : " + hostProfile.getValue());
   }

   /**
    * Detach a profile from a managed entity.
    * 
    * @param hostProfile
    * @param managedObjectReferences
    * @throws RuntimeFault
    * @throws RemoteException
    */
   private static void detachHostFromProfile(
         ManagedObjectReference hostProfile,
         List<ManagedObjectReference> managedObjectReferences)
         throws RuntimeFaultFaultMsg {
      System.out.println("------------------------");
      System.out.println("* Detach Host From Profile");
      System.out.println("------------------------");
      vimPort.dissociateProfile(hostProfile, managedObjectReferences);
      System.out.println("Detached Host : "
            + managedObjectReferences.get(0).getValue() + " From Profile : "
            + hostProfile.getValue());
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
      System.out.println("This sample demonstrates HostProfileManager and "
            + " ProfileComplainceManager");
      System.out.println("\nParameters:");
      System.out
            .println("url              [required] : url of the web service");
      System.out
            .println("username         [required] : username for the authentication");
      System.out
            .println("password         [required] : password for the authentication");
      System.out.println("sourcehostname   [required] : Name of the host ");
      System.out.println("entityname       [required] : Attached Entity Name");
      System.out.println("entitytype       [required] : Attached Entity Type");
      System.out.println("\nCommand:");
      System.out
            .println("Create hostprofile given profileSourceHost (host system),"
                  + " profileAttachEntity (host system), profileAttachEntityType (host system)");
      System.out.println("Applies config after attaching hostprofile to"
            + " host system and check for compliance");
      System.out
            .println("run.bat com.vmware.host.HostProfileManager --url [webserviceurl]");
      System.out
            .println("--username [username] --password [password] --sourcehostname [host name]");
      System.out.println("--entityname [host name] --entitytype HostSystem");
      System.out
            .println("Create hostprofile given profileSourceHost (host system), "
                  + "profileAttachEntity (cluster computer resource), profileAttachEntityType "
                  + "(cluster compute resource)");
      System.out.println("Attaches hostprofile to all hosts in"
            + " cluster and checks for compliance");
      System.out
            .println("run.bat com.vmware.host.HostProfileManager --url [webserviceurl]");
      System.out.println("--username [username] --password  [password]"
            + " --sourcehostname [host name]");
      System.out
            .println("--entityname [Cluster] --entitytype ClusterComputeResource");
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
         ManagedObjectReference createHostMoref =
               getMOREFsInFolderByType(serviceContent.getRootFolder(),
                     "HostSystem").get(createHostEntityName);
         ManagedObjectReference attachMoref =
               getMOREFsInFolderByType(serviceContent.getRootFolder(),
                     attachEntityType).get(attachEntityName);
         List<ManagedObjectReference> hmor =
               new ArrayList<ManagedObjectReference>();
         hmor.add(attachMoref);
         ManagedObjectReference hostProfile =
               createHostProfile(createHostMoref);
         attachProfileWithManagedEntity(hostProfile, hmor);
         printProfilesAssociatedWithEntity(attachMoref);
         List<ManagedObjectReference> hpmor =
               new ArrayList<ManagedObjectReference>();
         List<ManagedObjectReference> hamor =
               new ArrayList<ManagedObjectReference>();
         hpmor.add(hostProfile);
         hamor.add(attachMoref);
         if (attachEntityType.equals("HostSystem")) {
            updateReferenceHost(hostProfile, attachMoref);
            HostConfigSpec hostConfigSpec =
                  executeHostProfile(hostProfile, attachMoref);
            if (hostConfigSpec != null) {
               configurationTasksToBeAppliedOnHost(hostConfigSpec, attachMoref);
            }
            if (checkProfileCompliance(hpmor, hamor)) {
               applyConfigurationToHost(attachMoref, hostConfigSpec);
            }
         } else {
            checkProfileCompliance(hpmor, hamor);
         }
         detachHostFromProfile(hostProfile, hamor);
         deleteHostProfile(hostProfile);
      } catch (IllegalArgumentException iae) {
         System.out.println(iae.getMessage());
         printUsage();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println("Exception encountered " + e);
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
