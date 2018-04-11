package com.vmware.vm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.ArrayOfManagedObjectReference;
import com.vmware.vim25.DatastoreSummary;
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
import com.vmware.vim25.VirtualMachineMovePriority;
import com.vmware.vim25.VirtualMachinePowerState;
import com.vmware.vim25.VirtualMachineRelocateSpec;

/**
 * <pre>
 * VMotion
 * 
 * Used to validate if VMotion is feasible between two hosts or not,
 * It is also used to perform migrate/relocate task depending on the data given
 * 
 * <b>Parameters:</b>
 * url            [required] : url of the web service
 * username       [required] : username for the authentication
 * password       [required] : password for the authentication
 * vmname         [required] : name of the virtual machine
 * targethost     [required] : Name of the target host
 * sourcehost     [required] : Name of the host containing the virtual machine
 * targetpool     [required] : Name of the target resource pool
 * targetdatastore [required] : Name of the target datastore
 * priority       [required] : The priority of the migration task:-
 *                             defaultPriority, highPriority,lowPriority
 * state          [optional]
 *  
 * <b>Command Line:</b>
 * run.bat com.vmware.vm.VMotion --url [URLString] --username [User] --password [Password]
 * --vmname [VMName] --targethost [Target host] --sourcehost [Source host] --targetpool [Target resource pool]
 * --targetdatastore [Target datastore] --priority [Migration task priority] --state
 * </pre>
 */
public class VMotion {

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

   private static String[] meTree = { "ManagedEntity", "ComputeResource",
         "ClusterComputeResource", "Datacenter", "Folder", "HostSystem",
         "ResourcePool", "VirtualMachine" };
   private static String[] crTree = { "ComputeResource",
         "ClusterComputeResource" };
   private static String[] hcTree = { "HistoryCollector",
         "EventHistoryCollector", "TaskHistoryCollector" };

   /* Start Server Connection and common code */
   private static VimService vimService = null;
   private static VimPortType vimPort = null;
   private static ServiceContent serviceContent = null;
   private static final String SVC_INST_NAME = "ServiceInstance";
   private static final ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();

   private static ManagedObjectReference propCollectorRef = null;

   /*
   Connection input parameters
    */
   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
   private static String vmName = null;
   private static String targetHost = null;
   private static String targetPool = null;
   private static String sourceHost = null;
   private static String targetDS = null;
   private static String priority = null;
   private static String state = null;
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
            vmName = val;
         } else if (param.equalsIgnoreCase("--targethost")
               && !val.startsWith("--") && !val.isEmpty()) {
            targetHost = val;
         } else if (param.equalsIgnoreCase("--sourcehost")
               && !val.startsWith("--") && !val.isEmpty()) {
            sourceHost = val;
         } else if (param.equalsIgnoreCase("--targetpool")
               && !val.startsWith("--") && !val.isEmpty()) {
            targetPool = val;
         } else if (param.equalsIgnoreCase("--targetdatastore")
               && !val.startsWith("--") && !val.isEmpty()) {
            targetDS = val;
         } else if (param.equalsIgnoreCase("--priority")
               && !val.startsWith("--") && !val.isEmpty()) {
            priority = val;
         }
         val = "";
         ai += 2;
      }
      if (vmName == null || targetHost == null || sourceHost == null
            || targetPool == null || targetDS == null) {
         throw new IllegalArgumentException(
               "Expected --vmname, --targethost, --sourcehost, --targetpool or --targetdatastore arguments.");
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

   /*
    * @return An array of SelectionSpec covering VM, Host, Resource pool,
    * Cluster Compute Resource and Datastore.
    */
   private static List<SelectionSpec> buildFullTraversal() {
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
      hToVm.setName("hToVm");
      hToVm.getSelectSet().add(getSelectionSpec("visitFolders"));
      hToVm.setSkip(Boolean.FALSE);

      // DC -> DS
      TraversalSpec dcToDs = new TraversalSpec();
      dcToDs.setType("Datacenter");
      dcToDs.setPath("datastore");
      dcToDs.setName("dcToDs");
      dcToDs.setSkip(Boolean.FALSE);

      // Recurse through all ResourcePools
      TraversalSpec rpToRp = new TraversalSpec();
      rpToRp.setType("ResourcePool");
      rpToRp.setPath("resourcePool");
      rpToRp.setSkip(Boolean.FALSE);
      rpToRp.setName("rpToRp");
      rpToRp.getSelectSet().add(getSelectionSpec("rpToRp"));
      rpToRp.getSelectSet().add(getSelectionSpec("rpToVm"));

      TraversalSpec crToRp = new TraversalSpec();
      crToRp.setType("ComputeResource");
      crToRp.setPath("resourcePool");
      crToRp.setSkip(Boolean.FALSE);
      crToRp.setName("crToRp");
      crToRp.getSelectSet().add(getSelectionSpec("rpToRp"));
      crToRp.getSelectSet().add(getSelectionSpec("rpToVm"));

      TraversalSpec crToH = new TraversalSpec();
      crToH.setSkip(Boolean.FALSE);
      crToH.setType("ComputeResource");
      crToH.setPath("host");
      crToH.setName("crToH");

      TraversalSpec dcToHf = new TraversalSpec();
      dcToHf.setSkip(Boolean.FALSE);
      dcToHf.setType("Datacenter");
      dcToHf.setPath("hostFolder");
      dcToHf.setName("dcToHf");
      dcToHf.getSelectSet().add(getSelectionSpec("visitFolders"));

      TraversalSpec vAppToRp = new TraversalSpec();
      vAppToRp.setName("vAppToRp");
      vAppToRp.setType("VirtualApp");
      vAppToRp.setPath("resourcePool");
      vAppToRp.getSelectSet().add(getSelectionSpec("rpToRp"));

      TraversalSpec dcToVmf = new TraversalSpec();
      dcToVmf.setType("Datacenter");
      dcToVmf.setSkip(Boolean.FALSE);
      dcToVmf.setPath("vmFolder");
      dcToVmf.setName("dcToVmf");
      dcToVmf.getSelectSet().add(getSelectionSpec("visitFolders"));

      // For Folder -> Folder recursion
      TraversalSpec visitFolders = new TraversalSpec();
      visitFolders.setType("Folder");
      visitFolders.setPath("childEntity");
      visitFolders.setSkip(Boolean.FALSE);
      visitFolders.setName("visitFolders");
      List<SelectionSpec> sspecarrvf = new ArrayList<SelectionSpec>();
      sspecarrvf.add(getSelectionSpec("visitFolders"));
      sspecarrvf.add(getSelectionSpec("dcToVmf"));
      sspecarrvf.add(getSelectionSpec("dcToHf"));
      sspecarrvf.add(getSelectionSpec("dcToDs"));
      sspecarrvf.add(getSelectionSpec("crToRp"));
      sspecarrvf.add(getSelectionSpec("crToH"));
      sspecarrvf.add(getSelectionSpec("hToVm"));
      sspecarrvf.add(getSelectionSpec("rpToVm"));
      sspecarrvf.add(getSelectionSpec("rpToRp"));
      sspecarrvf.add(getSelectionSpec("vAppToRp"));
      sspecarrvf.add(getSelectionSpec("vAppToVM"));

      visitFolders.getSelectSet().addAll(sspecarrvf);

      List<SelectionSpec> resultspec = new ArrayList<SelectionSpec>();
      resultspec.add(visitFolders);
      resultspec.add(dcToVmf);
      resultspec.add(dcToHf);
      resultspec.add(dcToDs);
      resultspec.add(crToRp);
      resultspec.add(crToH);
      resultspec.add(hToVm);
      resultspec.add(rpToVm);
      resultspec.add(vAppToRp);
      resultspec.add(vAppToVM);
      resultspec.add(rpToRp);

      return resultspec;
   }

   private static SelectionSpec getSelectionSpec(String name) {
      SelectionSpec genericSpec = new SelectionSpec();
      genericSpec.setName(name);
      return genericSpec;
   }

   private static List<DynamicProperty> getDynamicProarray(
         ManagedObjectReference ref, String type, String propertyString)
         throws Exception {
      PropertySpec propertySpec = new PropertySpec();
      propertySpec.setAll(Boolean.FALSE);
      propertySpec.getPathSet().add(propertyString);
      propertySpec.setType(type);

      // Now create Object Spec
      ObjectSpec objectSpec = new ObjectSpec();
      objectSpec.setObj(ref);
      objectSpec.setSkip(Boolean.FALSE);
      objectSpec.getSelectSet().addAll(buildFullTraversal());
      // Create PropertyFilterSpec using the PropertySpec and ObjectPec
      // created above.
      PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
      propertyFilterSpec.getPropSet().add(propertySpec);
      propertyFilterSpec.getObjectSet().add(objectSpec);
      List<PropertyFilterSpec> listPfs = new ArrayList<PropertyFilterSpec>(1);
      listPfs.add(propertyFilterSpec);
      List<ObjectContent> oContList = retrievePropertiesAllObjects(listPfs);
      ObjectContent contentObj = oContList.get(0);
      List<DynamicProperty> objList = contentObj.getPropSet();
      return objList;
   }

   /**
    * 
    * @return TraversalSpec specification to get to the HostSystem managed
    *         object.
    */
   private static TraversalSpec getHostSystemTraversalSpec() {
      // Create a traversal spec that starts from the 'root' objects
      // and traverses the inventory tree to get to the Host system.
      // Build the traversal specs bottoms up
      SelectionSpec ss = new SelectionSpec();
      ss.setName("VisitFolders");

      // Traversal to get to the host from ComputeResource
      TraversalSpec computeResourceToHostSystem = new TraversalSpec();
      computeResourceToHostSystem.setName("computeResourceToHostSystem");
      computeResourceToHostSystem.setType("ComputeResource");
      computeResourceToHostSystem.setPath("host");
      computeResourceToHostSystem.setSkip(false);
      computeResourceToHostSystem.getSelectSet().add(ss);

      // Traversal to get to the ComputeResource from hostFolder
      TraversalSpec hostFolderToComputeResource = new TraversalSpec();
      hostFolderToComputeResource.setName("hostFolderToComputeResource");
      hostFolderToComputeResource.setType("Folder");
      hostFolderToComputeResource.setPath("childEntity");
      hostFolderToComputeResource.setSkip(false);
      hostFolderToComputeResource.getSelectSet().add(ss);

      // Traversal to get to the hostFolder from DataCenter
      TraversalSpec dataCenterToHostFolder = new TraversalSpec();
      dataCenterToHostFolder.setName("DataCenterToHostFolder");
      dataCenterToHostFolder.setType("Datacenter");
      dataCenterToHostFolder.setPath("hostFolder");
      dataCenterToHostFolder.setSkip(false);
      dataCenterToHostFolder.getSelectSet().add(ss);

      //TraversalSpec to get to the DataCenter from rootFolder
      TraversalSpec traversalSpec = new TraversalSpec();
      traversalSpec.setName("VisitFolders");
      traversalSpec.setType("Folder");
      traversalSpec.setPath("childEntity");
      traversalSpec.setSkip(false);

      List<SelectionSpec> sSpecArr = new ArrayList<SelectionSpec>();
      sSpecArr.add(ss);
      sSpecArr.add(dataCenterToHostFolder);
      sSpecArr.add(hostFolderToComputeResource);
      sSpecArr.add(computeResourceToHostSystem);
      traversalSpec.getSelectSet().addAll(sSpecArr);
      return traversalSpec;
   }

   /**
    * Retrieves the MOREF of the host.
    * 
    * @param hostName
    *           :
    * @return
    */
   private static ManagedObjectReference getHostByHostName(String hostName) {
      ManagedObjectReference retVal = null;
      ManagedObjectReference rootFolder = serviceContent.getRootFolder();
      try {
         TraversalSpec tSpec = getHostSystemTraversalSpec();
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add("name");
         propertySpec.setType("HostSystem");

         // Now create Object Spec
         ObjectSpec objectSpec = new ObjectSpec();
         objectSpec.setObj(rootFolder);
         objectSpec.setSkip(Boolean.TRUE);
         objectSpec.getSelectSet().add(tSpec);

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
               ManagedObjectReference mr = oc.getObj();
               String hostnm = null;
               List<DynamicProperty> listDynamicProps = oc.getPropSet();
               DynamicProperty[] dps =
                     listDynamicProps
                           .toArray(new DynamicProperty[listDynamicProps.size()]);
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     hostnm = (String) dp.getVal();
                  }
               }
               if (hostnm != null && hostnm.equals(hostName)) {
                  retVal = mr;
                  break;
               }
            }
         } else {
            System.out.println("The Object Content is Null");
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      if (retVal == null) {
         throw new RuntimeException("Host " + hostName + " not found.");
      }
      return retVal;
   }

   private static DatastoreSummary getDataStoreSummary(
         ManagedObjectReference dataStore) throws Exception {
      DatastoreSummary dataStoreSummary = new DatastoreSummary();
      PropertySpec propertySpec = new PropertySpec();
      propertySpec.setAll(Boolean.FALSE);
      propertySpec.getPathSet().add("summary");
      propertySpec.setType("Datastore");

      // Now create Object Spec
      ObjectSpec objectSpec = new ObjectSpec();
      objectSpec.setObj(dataStore);
      objectSpec.setSkip(Boolean.FALSE);
      objectSpec.getSelectSet().addAll(buildFullTraversal());
      // Create PropertyFilterSpec using the PropertySpec and ObjectPec
      // created above.
      PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
      propertyFilterSpec.getPropSet().add(propertySpec);
      propertyFilterSpec.getObjectSet().add(objectSpec);
      List<PropertyFilterSpec> listpfs = new ArrayList<PropertyFilterSpec>(1);
      listpfs.add(propertyFilterSpec);
      List<ObjectContent> listobjcont = retrievePropertiesAllObjects(listpfs);
      for (int j = 0; j < listobjcont.size(); j++) {
         List<DynamicProperty> propSetList = listobjcont.get(j).getPropSet();
         for (int k = 0; k < propSetList.size(); k++) {
            dataStoreSummary = (DatastoreSummary) propSetList.get(k).getVal();
         }
      }
      return dataStoreSummary;
   }

   private static ManagedObjectReference browseDSMOR(
         List<ManagedObjectReference> dsMOR) {
      ManagedObjectReference dataMOR = null;
      try {
         if (dsMOR != null && dsMOR.size() > 0) {
            for (int i = 0; i < dsMOR.size(); i++) {
               DatastoreSummary ds = getDataStoreSummary(dsMOR.get(i));
               String dsname = ds.getName();
               if (dsname.equalsIgnoreCase(targetDS)) {
                  dataMOR = dsMOR.get(i);
                  break;
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return dataMOR;
   }

   /*
    *This function is used to check whether relocation is to be done or
    *migration is to be done. If two hosts have a shared datastore then
    *migration will be done and if there is no shared datastore relocation
    *will be done.
    *@param String name of the source host
    *@param String name of the target host
    *@param String name of the target datastore
    *@return String mentioning migration or relocation
    */
   private static String checkOperationType(String targetHost,
         String sourceHost, String targetDS) throws Exception {
      String operation = "";
      if (targetHost.equalsIgnoreCase(sourceHost)) {
         return "same";
      }
      ManagedObjectReference targetHostMOR = getHostByHostName(targetHost);
      ManagedObjectReference sourceHostMOR = getHostByHostName(sourceHost);
      List<DynamicProperty> datastoresTarget =
            getDynamicProarray(targetHostMOR, "HostSystem", "datastore");
      ArrayOfManagedObjectReference dsTargetArr =
            ((ArrayOfManagedObjectReference) (datastoresTarget.get(0)).getVal());
      List<ManagedObjectReference> dsTarget =
            dsTargetArr.getManagedObjectReference();
      ManagedObjectReference tarHostDS = browseDSMOR(dsTarget);
      List<DynamicProperty> datastoresSource =
            getDynamicProarray(sourceHostMOR, "HostSystem", "datastore");
      ArrayOfManagedObjectReference dsSourceArr =
            ((ArrayOfManagedObjectReference) (datastoresSource.get(0)).getVal());
      List<ManagedObjectReference> dsSourceList =
            dsSourceArr.getManagedObjectReference();
      ManagedObjectReference srcHostDS = browseDSMOR(dsSourceList);

      if ((tarHostDS != null) && (srcHostDS != null)) {
         operation = "migrate";
      } else {
         operation = "relocate";
      }
      return operation;
   }

   /**
    * This code takes an array of [typename, property, property, ...] and
    * converts it into a PropertySpec[]. handles case where multiple references
    * to the same typename are specified.
    * 
    * @param typeinfo
    *           2D array of type and properties to retrieve
    * 
    * @return Array of container filter specs
    */
   private static List<PropertySpec> buildPropertySpecArray(String[][] typeinfo) {
      // Eliminate duplicates
      HashMap<String, Set> tInfo = new HashMap<String, Set>();
      for (int ti = 0; ti < typeinfo.length; ++ti) {
         Set props = tInfo.get(typeinfo[ti][0]);
         if (props == null) {
            props = new HashSet<String>();
            tInfo.put(typeinfo[ti][0], props);
         }
         boolean typeSkipped = false;
         for (int pi = 0; pi < typeinfo[ti].length; ++pi) {
            String prop = typeinfo[ti][pi];
            if (typeSkipped) {
               props.add(prop);
            } else {
               typeSkipped = true;
            }
         }
      }

      // Create PropertySpecs
      ArrayList<PropertySpec> pSpecs = new ArrayList<PropertySpec>();
      for (Iterator<String> ki = tInfo.keySet().iterator(); ki.hasNext();) {
         String type = ki.next();
         PropertySpec pSpec = new PropertySpec();
         Set props = tInfo.get(type);
         pSpec.setType(type);
         pSpec.setAll(props.isEmpty() ? Boolean.TRUE : Boolean.FALSE);
         for (Iterator pi = props.iterator(); pi.hasNext();) {
            String prop = (String) pi.next();
            pSpec.getPathSet().add(prop);
         }
         pSpecs.add(pSpec);
      }

      return pSpecs;
   }

   /**
    * Retrieve content recursively with multiple properties. the typeinfo array
    * contains typename + properties to retrieve.
    * 
    * @param collector
    *           a property collector if available or null for default
    * @param root
    *           a root folder if available, or null for default
    * @param typeinfo
    *           2D array of properties for each typename
    * @param recurse
    *           retrieve contents recursively from the root down
    * 
    * @return retrieved object contents
    */
   private static List<ObjectContent> getContentsRecursively(
         ManagedObjectReference collector, ManagedObjectReference root,
         String[][] typeinfo, boolean recurse) throws Exception {
      if (typeinfo == null || typeinfo.length == 0) {
         return null;
      }

      ManagedObjectReference usecoll = collector;
      if (usecoll == null) {
         usecoll = serviceContent.getPropertyCollector();
      }

      ManagedObjectReference useroot = root;
      if (useroot == null) {
         useroot = serviceContent.getRootFolder();
      }

      List<SelectionSpec> selectionSpecs = null;
      if (recurse) {
         selectionSpecs = buildFullTraversal();
      }

      List<PropertySpec> propspecary = buildPropertySpecArray(typeinfo);
      ObjectSpec objSpec = new ObjectSpec();
      objSpec.setObj(useroot);
      objSpec.setSkip(Boolean.FALSE);
      objSpec.getSelectSet().addAll(selectionSpecs);
      List<ObjectSpec> objSpecList = new ArrayList<ObjectSpec>();
      objSpecList.add(objSpec);
      PropertyFilterSpec spec = new PropertyFilterSpec();
      spec.getPropSet().addAll(propspecary);
      spec.getObjectSet().addAll(objSpecList);
      List<PropertyFilterSpec> listpfs = new ArrayList<PropertyFilterSpec>();
      listpfs.add(spec);
      List<ObjectContent> listobjcont = retrievePropertiesAllObjects(listpfs);

      return listobjcont;
   }

   private static boolean typeIsA(String searchType, String foundType) {
      if (searchType.equals(foundType)) {
         return true;
      } else if (searchType.equals("ManagedEntity")) {
         for (int i = 0; i < meTree.length; ++i) {
            if (meTree[i].equals(foundType)) {
               return true;
            }
         }
      } else if (searchType.equals("ComputeResource")) {
         for (int i = 0; i < crTree.length; ++i) {
            if (crTree[i].equals(foundType)) {
               return true;
            }
         }
      } else if (searchType.equals("HistoryCollector")) {
         for (int i = 0; i < hcTree.length; ++i) {
            if (hcTree[i].equals(foundType)) {
               return true;
            }
         }
      }
      return false;
   }

   /**
    * Get the ManagedObjectReference for an item under the specified root folder
    * that has the type and name specified.
    * 
    * @param root
    *           a root folder if available, or null for default
    * @param type
    *           type of the managed object
    * @param name
    *           name to match
    * 
    * @return First ManagedObjectReference of the type / name pair found
    */
   private static ManagedObjectReference getDecendentMoRef(
         ManagedObjectReference root, String type, String name)
         throws Exception {
      if (name == null || name.length() == 0) {
         return null;
      }

      String[][] typeinfo = new String[][] { new String[] { type, "name" }, };

      List<ObjectContent> ocary =
            getContentsRecursively(null, root, typeinfo, true);

      if (ocary == null || ocary.size() == 0) {
         return null;
      }

      ObjectContent oc = null;
      ManagedObjectReference mor = null;
      List<DynamicProperty> propary = null;
      String propval = null;
      boolean found = false;
      for (int oci = 0; oci < ocary.size() && !found; oci++) {
         oc = ocary.get(oci);
         mor = oc.getObj();
         propary = oc.getPropSet();

         propval = null;
         if (type == null || typeIsA(type, mor.getType())) {
            if (propary.size() > 0) {
               propval = (String) propary.get(0).getVal();
            }
            found = propval != null && name.equals(propval);
         }
      }

      if (!found) {
         mor = null;
      }

      return mor;
   }

   private static void migrateVM(String vmname, String pool, String tHost,
         String srcHost, String priority) throws Exception {
      VirtualMachinePowerState st = null;
      VirtualMachineMovePriority pri = null;
      if (state != null) {
         if (VirtualMachinePowerState.POWERED_OFF.toString().equalsIgnoreCase(
               state)) {
            st = VirtualMachinePowerState.POWERED_OFF;
         } else if (VirtualMachinePowerState.POWERED_ON.toString()
               .equalsIgnoreCase(state)) {
            st = VirtualMachinePowerState.POWERED_ON;
         } else if (VirtualMachinePowerState.SUSPENDED.toString()
               .equalsIgnoreCase(state)) {
            st = VirtualMachinePowerState.SUSPENDED;
         }
      }
      if (priority == null) {
         pri = VirtualMachineMovePriority.DEFAULT_PRIORITY;
      } else {
         if (VirtualMachineMovePriority.DEFAULT_PRIORITY.toString()
               .equalsIgnoreCase(priority)) {
            pri = VirtualMachineMovePriority.DEFAULT_PRIORITY;
         } else if (VirtualMachineMovePriority.HIGH_PRIORITY.toString()
               .equalsIgnoreCase(priority)) {
            pri = VirtualMachineMovePriority.HIGH_PRIORITY;
         } else if (VirtualMachineMovePriority.LOW_PRIORITY.toString()
               .equalsIgnoreCase(priority)) {
            pri = VirtualMachineMovePriority.LOW_PRIORITY;
         }
      }
      try {
         ManagedObjectReference srcMOR = getHostByHostName(srcHost);
         if (srcMOR == null) {
            throw new IllegalArgumentException("Source Host" + sourceHost
                  + " Not Found.");
         }
         //ManagedObjectReference vmMOR = getVmByVMname(vmname);
         ManagedObjectReference vmMOR =
               getDecendentMoRef(srcMOR, "VirtualMachine", vmname);
         if (vmMOR == null) {
            throw new IllegalArgumentException("Virtual Machine " + vmName
                  + " Not Found.");
         }
         ManagedObjectReference poolMOR =
               getDecendentMoRef(null, "ResourcePool", pool);
         if (poolMOR == null) {
            throw new IllegalArgumentException("Target Resource Pool "
                  + targetPool + " Not Found.");
         }
         ManagedObjectReference hMOR = getHostByHostName(tHost);
         if (hMOR == null) {
            throw new IllegalArgumentException(" Target Host " + targetHost
                  + " Not Found.");
         }
         System.out.println("Migrating the Virtual Machine " + vmname);
         ManagedObjectReference taskMOR =
               vimPort.migrateVMTask(vmMOR, poolMOR, hMOR, pri, st);
         if (getTaskResultAfterDone(taskMOR)) {
            System.out.println("Migration of Virtual Machine " + vmname
                  + " done successfully to " + tHost);
         } else {
            System.out.println("Error::  Migration failed");
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println(e);
      }
   }

   /*
    *This function is used for doing the relocation VM task
    *@param String vmname
    *@param String resourcepool name
    *@param String name of the target host
    *@param String name of the target datastore
    */
   private static void relocateVM(String vmname, String pool, String tHost,
         String tDS, String srcHost) throws Exception {
      VirtualMachineMovePriority pri = null;
      if (priority == null) {
         pri = VirtualMachineMovePriority.DEFAULT_PRIORITY;
      } else {
         if (VirtualMachineMovePriority.DEFAULT_PRIORITY.toString()
               .equalsIgnoreCase(priority)) {
            pri = VirtualMachineMovePriority.DEFAULT_PRIORITY;
         } else if (VirtualMachineMovePriority.HIGH_PRIORITY.toString()
               .equalsIgnoreCase(priority)) {
            pri = VirtualMachineMovePriority.HIGH_PRIORITY;
         } else if (VirtualMachineMovePriority.LOW_PRIORITY.toString()
               .equalsIgnoreCase(priority)) {
            pri = VirtualMachineMovePriority.LOW_PRIORITY;
         }
      }
      ManagedObjectReference srcMOR = getHostByHostName(srcHost);
      if (srcMOR == null) {
         throw new IllegalArgumentException(" Source Host " + sourceHost
               + " Not Found.");
      }
      ManagedObjectReference vmMOR =
            getDecendentMoRef(srcMOR, "VirtualMachine", vmname);
      if (vmMOR == null) {
         throw new IllegalArgumentException("Virtual Machine " + vmName
               + " Not Found.");
      }
      ManagedObjectReference poolMOR =
            getDecendentMoRef(null, "ResourcePool", pool);
      if (poolMOR == null) {
         throw new IllegalArgumentException(" Target Resource Pool "
               + targetPool + " Not Found.");
      }
      ManagedObjectReference hMOR = getHostByHostName(tHost);
      if (hMOR == null) {
         throw new IllegalArgumentException(" Target Host " + targetHost
               + " Not Found.");
      }

      List<DynamicProperty> datastoresSource =
            getDynamicProarray(hMOR, "HostSystem", "datastore");
      ArrayOfManagedObjectReference dsSourceArr =
            ((ArrayOfManagedObjectReference) (datastoresSource.get(0)).getVal());
      List<ManagedObjectReference> dsTarget =
            dsSourceArr.getManagedObjectReference();
      ManagedObjectReference dsMOR = browseDSMOR(dsTarget);
      if (dsMOR == null) {
         throw new IllegalArgumentException(" DataSource " + tDS
               + " Not Found.");
      }
      VirtualMachineRelocateSpec relSpec = new VirtualMachineRelocateSpec();
      relSpec.setDatastore(dsMOR);
      relSpec.setHost(hMOR);
      relSpec.setPool(poolMOR);
      System.out.println("Relocating the Virtual Machine " + vmname);
      ManagedObjectReference taskMOR =
            vimPort.relocateVMTask(vmMOR, relSpec, pri);

      if (getTaskResultAfterDone(taskMOR)) {
         System.out.println("Relocation done successfully of " + vmname
               + " to host " + tHost);
      } else {
         System.out.println("Error::  Relocation failed");
      }
   }

   private static void migrateOrRelocateVM() throws Exception {
      // first we need to check if the VM should be migrated of relocated
      // If target host and source host both contains
      //the datastore, virtual machine needs to be migrated
      // If only target host contains the datastore, machine needs to be relocated
      String operationName =
            checkOperationType(targetHost, sourceHost, targetDS);
      if (operationName.equalsIgnoreCase("migrate")) {
         migrateVM(vmName, targetPool, targetHost, sourceHost, priority);
      } else if (operationName.equalsIgnoreCase("relocate")) {
         relocateVM(vmName, targetPool, targetHost, targetDS, sourceHost);
      } else if (operationName.equalsIgnoreCase("same")) {
         throw new IllegalArgumentException(
               "targethost and sourcehost must not be same");
      } else {
         throw new IllegalArgumentException(operationName + " Not Found.");
      }
   }

   private static boolean customValidation() throws Exception {
      boolean flag = true;
      if (state != null) {
         if (!state.equalsIgnoreCase("poweredOn")
               && !state.equalsIgnoreCase("poweredOff")
               && !state.equalsIgnoreCase("suspended")) {
            System.out.println("Must specify 'poweredOn', 'poweredOff' or"
                  + " 'suspended' for 'state' option\n");
            flag = false;
         }
      }
      if (priority != null) {
         if (!priority.equalsIgnoreCase("default_Priority")
               && !priority.equalsIgnoreCase("high_Priority")
               && !priority.equalsIgnoreCase("low_Priority")) {
            System.out
                  .println("Must specify 'default_Priority', 'high_Priority "
                        + " 'or 'low_Priority' for 'priority' option\n");
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
      System.out
            .println("Used to validate if VMotion is feasible between two hosts or not, "
                  + "It is also used to perform migrate/relocate task depending on the data given");
      System.out
            .println("url               [required]: url of the web service.");
      System.out
            .println("username          [required]: username for the authentication");
      System.out
            .println("Password          [required]: password for the authentication");
      System.out
            .println("vmname            [required]: name of the virtual machine");
      System.out
            .println("targethost        [required]: Name of the target host");
      System.out
            .println("sourcehost        [required]: Name of the host containg the virtual machine");
      System.out
            .println("targetpool        [required]: Name of the target resource pool");
      System.out
            .println("targetdatastore   [required]: Name of the target datastore");
      System.out
            .println("priority          [required]: The priority of the migration task: default_Priority, high_Priority,low_Priority");
      System.out
            .println("state             [optional]: name of the virtual machine");
      System.out
            .println("run.bat com.vmware.scheduling.VMotion "
                  + "--url [URLString] --username [User] --password [Password] --vmname [VMName] "
                  + "--targethost [Target host] --sourcehost [Source host] --targetpool [Target resource pool]"
                  + "--targetdatastore [Target datastore] --priority [Migration task priority] --state");
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
         if (customValidation()) {
            migrateOrRelocateVM();
         } else {
            printUsage();
         }
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
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
}
