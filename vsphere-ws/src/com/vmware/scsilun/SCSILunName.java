package com.vmware.scsilun;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.ArrayOfManagedObjectReference;
import com.vmware.vim25.ArrayOfScsiLun;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.HostScsiDiskPartition;
import com.vmware.vim25.HostVmfsVolume;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.ScsiLun;
import com.vmware.vim25.ScsiLunDurableName;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VmfsDatastoreInfo;

/**
 * <pre>
 * SCSILunName
 * 
 * This sample displays the CanonicalName,Vendor,Model,Data,Namespace
 * and NamespaceId of the host SCSI LUN name
 * 
 * <b>Parameters:</b>
 * url            [required] : url of the web service
 * username       [required] : username for the authentication
 * password       [required] : password for the authentication
 * hostname       [required] : host for which SCSI details will be displayed
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.scsilun.SCSILunName
 * --url [webserviceurl] --username [username] --password [password]
 * --hostname [host name]
 * </pre>
 */

public class SCSILunName {

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
   private static ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();

   private static ManagedObjectReference propCollectorRef = null;
   private static ManagedObjectReference host = null;

   /*
   Connection input parameters
   */
   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
   private static String hostName = null;
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
         throw new IllegalArgumentException("Expected --url, --username,"
               + " --password arguments.");
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
         if (param.equalsIgnoreCase("--hostname") && !val.startsWith("--")
               && !val.isEmpty()) {
            hostName = val;
         }
         val = "";
         ai += 2;
      }
      if (hostName == null) {
         throw new IllegalArgumentException("Expected --hostname argument.");
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
    * RetrieveProperties method
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
   private static void getHostByHostName() {
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
      host = retVal;
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
      hToVm.getSelectSet().add(getSelectionSpec("VisitFolders"));
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

      TraversalSpec crToRp = new TraversalSpec();
      crToRp.setType("ComputeResource");
      crToRp.setPath("resourcePool");
      crToRp.setSkip(Boolean.FALSE);
      crToRp.setName("crToRp");
      crToRp.getSelectSet().add(getSelectionSpec("rpToRp"));

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
      dcToHf.getSelectSet().add(getSelectionSpec("VisitFolders"));

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
      dcToVmf.getSelectSet().add(getSelectionSpec("VisitFolders"));

      // For Folder -> Folder recursion
      TraversalSpec visitFolders = new TraversalSpec();
      visitFolders.setType("Folder");
      visitFolders.setPath("childEntity");
      visitFolders.setSkip(Boolean.FALSE);
      visitFolders.setName("VisitFolders");
      List<SelectionSpec> sspecarrvf = new ArrayList<SelectionSpec>();
      sspecarrvf.add(getSelectionSpec("crToRp"));
      sspecarrvf.add(getSelectionSpec("crToH"));
      sspecarrvf.add(getSelectionSpec("dcToVmf"));
      sspecarrvf.add(getSelectionSpec("dcToHf"));
      sspecarrvf.add(getSelectionSpec("vAppToRp"));
      sspecarrvf.add(getSelectionSpec("vAppToVM"));
      sspecarrvf.add(getSelectionSpec("dcToDs"));
      sspecarrvf.add(getSelectionSpec("hToVm"));
      sspecarrvf.add(getSelectionSpec("rpToVm"));
      sspecarrvf.add(getSelectionSpec("VisitFolders"));

      visitFolders.getSelectSet().addAll(sspecarrvf);

      List<SelectionSpec> resultspec = new ArrayList<SelectionSpec>();
      resultspec.add(visitFolders);
      resultspec.add(crToRp);
      resultspec.add(crToH);
      resultspec.add(dcToVmf);
      resultspec.add(dcToHf);
      resultspec.add(vAppToRp);
      resultspec.add(vAppToVM);
      resultspec.add(dcToDs);
      resultspec.add(hToVm);
      resultspec.add(rpToVm);
      resultspec.add(rpToRp);

      return resultspec;
   }

   private static SelectionSpec getSelectionSpec(String name) {
      SelectionSpec genericSpec = new SelectionSpec();
      genericSpec.setName(name);
      return genericSpec;
   }

   private static List<DynamicProperty> getDynamicPropArray(
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
      List<PropertyFilterSpec> listpfs = new ArrayList<PropertyFilterSpec>(1);
      listpfs.add(propertyFilterSpec);
      List<ObjectContent> listobjcont = retrievePropertiesAllObjects(listpfs);
      ObjectContent contentObj = listobjcont.get(0);
      List<DynamicProperty> objList = contentObj.getPropSet();
      return objList;
   }

   /*
    * This subroutine prints the virtual machine file
    * system volumes affected by the given SCSI LUN.
    * @param  hmor      A HostSystem object of the given host.
    * @param canName    Canonical name of the SCSI logical unit
    */
   private static void getVMFS(ManagedObjectReference hmor, String canName)
         throws Exception {
      List<DynamicProperty> dsArr =
            getDynamicPropArray(host, "HostSystem", "datastore");
      ArrayOfManagedObjectReference ds =
            ((ArrayOfManagedObjectReference) (dsArr.get(0)).getVal());
      List<ManagedObjectReference> dataStoresMOR =
            ds.getManagedObjectReference();
      boolean vmfsFlag = false;
      try {
         for (int j = 0; j < dataStoresMOR.size(); j++) {
            List<DynamicProperty> infoArr =
                  getDynamicPropArray(dataStoresMOR.get(j), "Datastore", "info");
            String infoClass = infoArr.get(0).getVal().getClass().toString();
            if (infoClass.equals("class com.vmware.vim.VmfsDatastoreInfo")) {
               VmfsDatastoreInfo vds =
                     (VmfsDatastoreInfo) infoArr.get(0).getVal();
               HostVmfsVolume hvms = vds.getVmfs();
               String vmfsName = vds.getName();
               List<HostScsiDiskPartition> hdp = hvms.getExtent();
               for (int k = 0; k < hdp.size(); k++) {
                  if (hdp.get(k).getDiskName().equals(canName)) {
                     vmfsFlag = true;
                     System.out.println(" " + vmfsName + "\n");
                  }
               }
            }
         }
         if (!vmfsFlag) {
            System.out.println(" None\n");
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println("error" + e);
         e.printStackTrace();
      }
   }

   /*
    *This subroutine prints the virtual machine
    *affected by the given SCSI LUN.
    *@param  hmor      ManagedObjectReference of the host
    *@param  canName   Canonical name of the SCSI logical unit
    */
   private static void getVMs(ManagedObjectReference hmor, String canName)
         throws Exception {
      List<DynamicProperty> dsArr =
            getDynamicPropArray(host, "HostSystem", "datastore");
      ArrayOfManagedObjectReference ds =
            ((ArrayOfManagedObjectReference) (dsArr.get(0)).getVal());
      List<ManagedObjectReference> dataStoresMOR =
            ds.getManagedObjectReference();
      boolean vmfsFlag = false;
      try {
         for (int j = 0; j < dataStoresMOR.size(); j++) {
            List<DynamicProperty> infoArr =
                  getDynamicPropArray(dataStoresMOR.get(j), "Datastore", "info");
            String infoClass = infoArr.get(0).getVal().getClass().toString();
            if (infoClass.equals("class com.vmware.vim.VmfsDatastoreInfo")) {
               VmfsDatastoreInfo vds =
                     (VmfsDatastoreInfo) infoArr.get(0).getVal();
               HostVmfsVolume hvms = vds.getVmfs();
               List<HostScsiDiskPartition> hdp = hvms.getExtent();
               for (int k = 0; k < hdp.size(); k++) {
                  if (hdp.get(k).getDiskName().equals(canName)) {
                     List<DynamicProperty> vmArr =
                           getDynamicPropArray(dataStoresMOR.get(j),
                                 "Datastore", "vm");
                     ArrayOfManagedObjectReference vms =
                           ((ArrayOfManagedObjectReference) vmArr.get(0)
                                 .getVal());
                     List<ManagedObjectReference> vmsMOR =
                           vms.getManagedObjectReference();
                     if (vmsMOR != null) {
                        for (int l = 0; l < vmsMOR.size(); l++) {
                           vmfsFlag = true;
                           List<DynamicProperty> nameArr =
                                 getDynamicPropArray(vmsMOR.get(l),
                                       "VirtualMachine", "name");
                           String vmname = nameArr.get(0).getVal().toString();
                           System.out.println(" " + vmname);
                        }
                     }
                  }
               }
            }
         }
         if (!vmfsFlag) {
            System.out.println(" None\n");
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println("error" + e);
         e.printStackTrace();
      }
   }

   private static void printLunInfo() {
      try {
         List<DynamicProperty> scsiArry =
               getDynamicPropArray(host, "HostSystem",
                     "config.storageDevice.scsiLun");
         ArrayOfScsiLun scsiLUNarr =
               ((ArrayOfScsiLun) (scsiArry.get(0)).getVal());
         List<ScsiLun> scsiLun = scsiLUNarr.getScsiLun();
         if (scsiLun != null && scsiLun.size() > 0) {
            for (int j = 0; j < scsiLun.size(); j++) {
               System.out.println("\nSCSI LUN " + (j + 1));
               System.out.println("--------------");
               String canName = scsiLun.get(j).getCanonicalName();
               if (scsiLun.get(j).getDurableName() != null) {
                  ScsiLunDurableName scsiLunDurableName =
                        scsiLun.get(j).getDurableName();
                  List<Byte> data = scsiLunDurableName.getData();
                  String namespace = scsiLunDurableName.getNamespace();
                  byte namespaceId = scsiLunDurableName.getNamespaceId();
                  System.out.print("\nData            : ");
                  for (int i = 0; i < data.size(); i++) {
                     System.out.print(data.get(i) + " ");
                  }
                  System.out.println("\nCanonical Name  : " + canName);
                  System.out.println("Namespace       : " + namespace);
                  System.out.println("Namespace ID    : " + namespaceId);
                  System.out.println("\nVMFS Affected ");
                  getVMFS(host, canName);
                  System.out.println("Virtual Machines ");
                  getVMs(host, canName);
               } else {
                  System.out
                        .println("\nDurable name for "
                              + scsiLun.get(j).getCanonicalName()
                              + " does not exist");
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println("Exception: " + e.getMessage());
         e.printStackTrace();
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
            .println("This sample displays the CanonicalName,Vendor,Model,Data,Namespace");
      System.out.println("and NamespaceId of the host SCSI LUN name");
      System.out.println("\nParameters:");
      System.out.println("url            [required] : url of the web service.");
      System.out
            .println("username       [required] : username for the authentication");
      System.out
            .println("password       [required] : password for the authentication");
      System.out
            .println("hostname       [required] : host for which SCSI details will be displayed");
      System.out.println("\nCommand:");
      System.out.println("run.bat com.vmware.scsilun.SCSILunName");
      System.out
            .println("--url [webserviceurl] --username [username] --password [password]");
      System.out.println("--hostname [host name]");
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
         getHostByHostName();
         if (host == null) {
            System.out.println("Host does not exist!");
         } else {
            printLunInfo();
         }
      } catch (IllegalArgumentException e) {
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
