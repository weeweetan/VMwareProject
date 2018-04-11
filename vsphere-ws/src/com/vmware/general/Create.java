package com.vmware.general;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
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

import com.vmware.vim25.ClusterConfigSpec;
import com.vmware.vim25.ComputeResourceConfigSpec;
import com.vmware.vim25.DuplicateNameFaultMsg;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.HostConnectSpec;
import com.vmware.vim25.InvalidCollectorVersionFaultMsg;
import com.vmware.vim25.InvalidLocaleFaultMsg;
import com.vmware.vim25.InvalidLoginFaultMsg;
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
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VirtualMachineConfigInfoSwapPlacementType;

/**
 * <pre>
 * Create
 * 
 * This sample creates managed entity like Host-Standalone Cluster
 * Datacenter, and folder
 * 
 * <b>Parameters:</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 * parentname   [required] : specifies the name of the parent folder
 * itemtype     [required] : Type of the object to be added
 *                           e.g. Host-Standalone | Cluster | Datacenter | Folder
 * itemname     [required]   : Name of the item added
 * 
 * <b>Command Line:</b>
 * Create a folder named myFolder under root folder Root:
 * run.bat com.vmware.general.Create --url [webserviceurl]
 * --username [username] --password [password]
 * --parentName [Root] --itemType [Folder] --itemName [myFolder]
 * 
 * Create a datacenter named myDatacenter under root folder Root:
 * run.bat com.vmware.general.Create --url [webserviceurl]
 * --username [username] --password [password]
 * --parentName [Root] --itemType [Datacenter] --itemName [myDatacenter]
 * 
 * Create a cluster named myCluster under root folder Root:
 * run.bat com.vmware.general.Create --url [webserviceurl]
 * --username [username] --password [password]
 * --parentName [Root] --itemType [Cluster] --itemName [myCluster]
 * </pre>
 */

public class Create {

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
   private static final String PROP_ME_NAME = "name";
   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;

   private static String url;
   private static String userName;
   private static String password;
   private static boolean help = false;
   private static boolean isConnected = false;
   private static String parentName;
   private static String itemType;
   private static String itemName;

   private static void trustAllHttpsCertificates() {
      try {
         // Create a trust manager that does not validate certificate chains
         javax.net.ssl.TrustManager[] trustAllCerts =
               new javax.net.ssl.TrustManager[1];
         javax.net.ssl.TrustManager tm = new TrustAllTrustManager();
         trustAllCerts[0] = tm;
         javax.net.ssl.SSLContext sc =
               javax.net.ssl.SSLContext.getInstance("SSL");
         javax.net.ssl.SSLSessionContext sslsc = sc.getServerSessionContext();
         sslsc.setSessionTimeout(0);
         sc.init(null, trustAllCerts, null);
         HttpsURLConnection.setDefaultSSLSocketFactory(sc
               .getSocketFactory());
      } catch (KeyManagementException e) {
         throw new RuntimeException(e);
      } catch (NoSuchAlgorithmException e) {
         throw new RuntimeException(e);
      } catch (IllegalArgumentException e) {
         throw new RuntimeException(e);
      }
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

   //get input parameters to run the sample
   private static void getInputParameters(String[] args) {
      int ai = 0;
      String param = "";
      String val = "";
      while (ai < args.length) {
         param = args[ai].trim();
         if (ai + 1 < args.length) {
            val = args[ai + 1].trim();
         }
         if (param.equalsIgnoreCase("--parentname") && !val.startsWith("--")
               && !val.isEmpty()) {
            parentName = val;
         } else if (param.equalsIgnoreCase("--itemtype")
               && !val.startsWith("--") && !val.isEmpty()) {
            itemType = val;
         } else if (param.equalsIgnoreCase("--itemname")
               && !val.startsWith("--") && !val.isEmpty()) {
            itemName = val;
         }
         val = "";
         ai += 2;
      }
      if (parentName == null || itemType == null || itemName == null) {
         throw new IllegalArgumentException("Expected --parentname,"
               + " --itemtype or --itemname arguments.");
      }
   }

   /**
    * Establishes session with the vCenter server.
    * 
    * @throws RuntimeFaultFaultMsg
    * @throws InvalidLoginFaultMsg
    * @throws InvalidLocaleFaultMsg
    * 
    * @throws Exception
    *            the exception
    */
   private static void connect() throws RuntimeFaultFaultMsg,
         InvalidLocaleFaultMsg, InvalidLoginFaultMsg {

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
    * @throws RuntimeFaultFaultMsg
    * 
    * @throws Exception
    */
   private static void disconnect() throws RuntimeFaultFaultMsg {
      if (isConnected) {
         vimPort.logout(serviceContent.getSessionManager());
      }
      isConnected = false;
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


   private static String getUserName() throws Exception {
      System.out.print("Enter the userName for the host: ");
      BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
      return (reader.readLine());
   }

   private static String getPassword() throws Exception {
      System.out.print("Enter the password for the host: ");
      BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
      return (reader.readLine());
   }

   private static String getLicenceKey() throws Exception {
      System.out.print("Enter the LicencecKey for the host: ");
      BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
      return (reader.readLine());
   }

   private static Integer getPort() throws Exception {
      System.out.print("Enter the port for the host : "
            + "[Hit enter for default:] ");
      BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

      String portStr = reader.readLine();
      if ((portStr == null) || portStr.length() == 0) {
         return new Integer(902);
      } else {
         return Integer.valueOf(portStr);
      }
   }

   private static void create() throws DuplicateNameFaultMsg,
         InvalidNameFaultMsg, RuntimeFaultFaultMsg, Exception {

      ManagedObjectReference taskMoRef = null;
      Map<String, ManagedObjectReference> folders =
            getMOREFsInFolderByType(serviceContent.getRootFolder(), "Folder");
      if (folders.containsKey(parentName)) {
         ManagedObjectReference folderMoRef = folders.get(parentName);
         if (itemType.equals("Folder")) {
            vimPort.createFolder(folderMoRef, itemName);
            System.out.println("Sucessfully created::" + itemName);
         } else if (itemType.equals("Datacenter")) {
            vimPort.createDatacenter(folderMoRef, itemName);
            System.out.println("Sucessfully created::" + itemName);
         } else if (itemType.equals("Cluster")) {
            ClusterConfigSpec clusterSpec = new ClusterConfigSpec();
            vimPort.createCluster(folderMoRef, itemName, clusterSpec);
            System.out.println("Sucessfully created::" + itemName);
         } else if (itemType.equals("Host-Standalone")) {
            HostConnectSpec hostSpec = new HostConnectSpec();
            hostSpec.setHostName(itemName);
            hostSpec.setUserName(getUserName());
            hostSpec.setPassword(getPassword());
            hostSpec.setPort(getPort());
            ComputeResourceConfigSpec crcs = new ComputeResourceConfigSpec();
            crcs.setVmSwapPlacement(VirtualMachineConfigInfoSwapPlacementType.VM_DIRECTORY
                  .value());
            taskMoRef =
                  vimPort.addStandaloneHostTask(folderMoRef, hostSpec, crcs,
                        true, getLicenceKey());

            if (getTaskResultAfterDone(taskMoRef)) {
               System.out.println("Sucessfully created::" + itemName);
            } else {
               System.out.println("Host'" + itemName + " not created::");
            }
         } else {
            System.out.println("Unknown Type. Allowed types are:");
            System.out.println(" Host-Standalone");
            System.out.println(" Cluster");
            System.out.println(" Datacenter");
            System.out.println(" Folder");
         }
      } else {
         System.out.println("Parent folder '" + parentName + "' not found");
      }

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

   private static void printUsage() {
      System.out
            .println("This sample creates managed entity like Host-Standalone Cluster");
      System.out.println("Datacenter, and folder.");
      System.out.println("\nParameters:");
      System.out.println("url          [required] : url of the web service");
      System.out
            .println("username     [required] : username for the authentication");
      System.out
            .println("password     [required] : password for the authentication");
      System.out
            .println("parentname   [required] : specifies the name of the parent folder");
      System.out
            .println("itemtype     [required] : Type of the object to be added");
      System.out
            .println("                          e.g. Host-Standalone | Cluster |");
      System.out.println("                               Datacenter | Folder");
      System.out.println("itemname     [required]   : Name of the item added");
      System.out.println("\nCommand:");
      System.out
            .println("Create a folder named myFolder under root folder Root:");
      System.out
            .println("run.bat com.vmware.general.Create --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out
            .println("--parentName [Root] --itemType [Folder] --itemName [myFolder]");
      System.out
            .println("Create a datacenter named myDatacenter under root folder Root:");
      System.out
            .println("run.bat com.vmware.general.Create --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out
            .println("--parentName [Root] --itemType [Datacenter] --itemName [myDatacenter]");
      System.out
            .println("Create a cluster named myCluster under root folder Root:");
      System.out
            .println("run.bat com.vmware.general.Create --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out
            .println("--parentName [Root] --itemType [Cluster] --itemName [myCluster]");
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
         create();
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