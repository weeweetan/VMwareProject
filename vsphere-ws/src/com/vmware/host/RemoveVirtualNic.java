package com.vmware.host;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.HostConfigFaultFaultMsg;
import com.vmware.vim25.HostConfigManager;
import com.vmware.vim25.HostVirtualNic;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NotFoundFaultMsg;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * RemoveVirtualNic
 * 
 * This sample removes a Virtual Nic from a PortGroup on a vSwitch
 * 
 * <b>Parameters:</b>
 * url              [required] : url of the web service
 * username         [required] : username for the authentication
 * password         [required] : password for the authentication
 * portgroupname    [required] : Name of port group to remove Virtual Nic from
 * hostname         [required] : Name of host
 * datacentername   [optional] : Name of datacenter
 * 
 * <b>Command Line:</b>
 * Remove a VirtualNic from a PortGroup
 * run.bat com.vmware.host.RemoveVirtualNic --url [webserviceurl]
 * --username [username] --password  [password] --datacentername [mydatacenter]
 * --portgroupname [myportgroup] --hostname [hostname]
 * 
 * Remove a VirtualNic from a PortGroup without hostname
 * run.bat com.vmware.host.RemoveVirtualNic --url [webserviceurl]
 * --username [username] --password  [password] --datacentername [mydatacenter]
 * --portgroupname [myportgroup]
 * 
 * Remove a VirtualNic from a PortGroup without datacentername
 * run.bat com.vmware.host.RemoveVirtualNic --url [webserviceurl]
 * --username [username] --password  [password]
 * --portgroupname [myportgroup] --hostname [name of the host]
 * </pre>
 */
public class RemoveVirtualNic {

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
   private static ManagedObjectReference propCollectorRef = null;
   private static ManagedObjectReference rootFolder;

   private static String url;
   private static String userName;
   private static String password;
   private static Boolean help = false;
   private static String datacenter;
   private static String host;
   private static String portgroupname;
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
      propCollectorRef = serviceContent.getPropertyCollector();
      rootFolder = serviceContent.getRootFolder();
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
         if (param.equalsIgnoreCase("--datacentername")
               && !val.startsWith("--") && !val.isEmpty()) {
            datacenter = val;
         }
         if (param.equalsIgnoreCase("--hostname") && !val.startsWith("--")
               && !val.isEmpty()) {
            host = val;
         }
         if (param.equalsIgnoreCase("--portgroupname") && !val.startsWith("--")
               && !val.isEmpty()) {
            portgroupname = val;
         }
         val = "";
         ai += 2;
      }
      if (portgroupname == null || host == null) {
         throw new IllegalArgumentException(
               "Expected --portgroupname --hostname arguments properly");
      }
   }

   private static void disconnect() throws Exception {
      if (isConnected) {
         vimPort.logout(serviceContent.getSessionManager());
      }
      isConnected = false;
   }

   /**
    * 
    * @return TraversalSpec specification to get to the Datacenter managed
    *         object.
    */
   private static TraversalSpec getDatacenterTraversalSpec() {
      // Create a traversal spec that starts from the 'root' objects
      SelectionSpec sSpec = new SelectionSpec();
      sSpec.setName("VisitFolders");

      //TraversalSpec to get to the DataCenter from rootFolder
      TraversalSpec traversalSpec = new TraversalSpec();
      traversalSpec.setName("VisitFolders");
      traversalSpec.setType("Folder");
      traversalSpec.setPath("childEntity");
      traversalSpec.setSkip(false);
      traversalSpec.getSelectSet().add(sSpec);
      return traversalSpec;
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
    * @param datacenterName
    *           The name of the Datacenter
    * @return ManagedObjectReference to the Datacenter
    */
   private static ManagedObjectReference getDatacenterByName(
         String datacenterName) {
      ManagedObjectReference retVal = null;

      try {
         TraversalSpec tSpec = getDatacenterTraversalSpec();
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add("name");
         propertySpec.setType("Datacenter");

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
               String dcnm = null;
               List<DynamicProperty> dps = oc.getPropSet();
               if (dps != null) {
                  //Since there is only one property PropertySpec pathset
                  //this array contains only one value
                  for (DynamicProperty dp : dps) {
                     dcnm = (String) dp.getVal();
                  }
               }
               //This is done outside of the previous for loop to break
               //out of the loop as soon as the required datacenter is found.
               if (dcnm != null && dcnm.equals(datacenterName)) {
                  retVal = mr;
                  break;
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return retVal;
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
         ManagedObjectReference mobj, String[] properties) throws Exception {
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
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
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
    */
   private static Object getDynamicProperty(ManagedObjectReference mor,
         String propertyName) throws Exception {
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
                * If object is ArrayOfYYY object, then get the YYY[] by
                * invoking getYYY() on the object.
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
    * Get a MORef from the property returned.
    * 
    * @param objMor
    *           Object to get a reference property from
    * @param propName
    *           name of the property that is the MORef
    * @return the ManagedObjectReference for that property.
    */
   private static ManagedObjectReference getMorFromPropertyName(
         ManagedObjectReference objMor, String propName) throws Exception {
      Object props = getDynamicProperty(objMor, propName);
      ManagedObjectReference propmor = null;
      if (!props.getClass().isArray()) {
         propmor = (ManagedObjectReference) props;
      }
      return propmor;
   }

   private static String getEntityName(ManagedObjectReference obj,
         String entityType) {
      String retVal = null;

      try {
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add("name");
         propertySpec.setType(entityType);

         // Now create Object Spec
         ObjectSpec objectSpec = new ObjectSpec();
         objectSpec.setObj(obj);

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
               List<DynamicProperty> dps = oc.getPropSet();
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     retVal = (String) dp.getVal();
                     return retVal;
                  }
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return retVal;
   }

   /**
    * 
    * @return An array of SelectionSpec covering all the entities that provide
    *         performance statistics. The entities that provide performance
    *         statistics are VM, Host, Resource pool, Cluster Compute Resource
    *         and Datastore.
    */
   private static SelectionSpec[] buildFullTraversal() {

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

      TraversalSpec crToRp = new TraversalSpec();
      crToRp.setType("ComputeResource");
      crToRp.setPath("resourcePool");
      crToRp.setSkip(Boolean.FALSE);
      crToRp.setName("crToRp");
      SelectionSpec[] sspecarrayrptorprtptovm = new SelectionSpec[] { rpToRp };
      crToRp.getSelectSet().addAll(Arrays.asList(sspecarrayrptorprtptovm));

      TraversalSpec crToH = new TraversalSpec();
      crToH.setSkip(Boolean.FALSE);
      crToH.setType("ComputeResource");
      crToH.setPath("host");
      crToH.setName("crToH");
      crToH.getSelectSet().add(hToVm);

      // For Folder -> Folder recursion
      SelectionSpec sspecvfolders = new SelectionSpec();
      sspecvfolders.setName("VisitFolders");

      TraversalSpec dcToHf = new TraversalSpec();
      dcToHf.setSkip(Boolean.FALSE);
      dcToHf.setType("Datacenter");
      dcToHf.setPath("hostFolder");
      dcToHf.setName("dcToHf");
      dcToHf.getSelectSet().add(sspecvfolders);

      TraversalSpec vAppToRp = new TraversalSpec();
      vAppToRp.setName("vAppToRp");
      vAppToRp.setType("VirtualApp");
      vAppToRp.setPath("resourcePool");
      SelectionSpec[] vAppToVMSS = new SelectionSpec[] { rpToRpSpec };
      vAppToRp.getSelectSet().addAll(Arrays.asList(vAppToVMSS));

      TraversalSpec dcToVmf = new TraversalSpec();
      dcToVmf.setType("Datacenter");
      dcToVmf.setSkip(Boolean.FALSE);
      dcToVmf.setPath("vmFolder");
      dcToVmf.setName("dcToVmf");
      dcToVmf.getSelectSet().add(sspecvfolders);

      TraversalSpec visitFolders = new TraversalSpec();
      visitFolders.setType("Folder");
      visitFolders.setPath("childEntity");
      visitFolders.setSkip(Boolean.FALSE);
      visitFolders.setName("VisitFolders");
      List<SelectionSpec> sspecarrvf = new ArrayList<SelectionSpec>();
      sspecarrvf.add(crToRp);
      sspecarrvf.add(crToH);
      sspecarrvf.add(dcToVmf);
      sspecarrvf.add(dcToHf);
      sspecarrvf.add(vAppToRp);
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
         objectSpec.setObj(rootFolder);
         objectSpec.setSkip(Boolean.TRUE);
         objectSpec.getSelectSet().addAll(Arrays.asList(buildFullTraversal()));

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
               if (getEntityName(oc.getObj(), entityType).equals(entityName)) {
                  retVal = oc.getObj();
                  break;
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return retVal;
   }

   /**
    * Getting the MOREF of the entity.
    */
   private static List<ManagedObjectReference> getMorList(
         ManagedObjectReference mor, String entityType) {
      List<ManagedObjectReference> retVal =
            new ArrayList<ManagedObjectReference>();

      try {
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.setType(entityType);
         propertySpec.getPathSet().add("name");

         // Now create Object Spec
         ObjectSpec objectSpec = new ObjectSpec();
         if (mor == null) {
            objectSpec.setObj(rootFolder);
         } else {
            objectSpec.setObj(mor);
         }
         objectSpec.setSkip(Boolean.TRUE);
         objectSpec.getSelectSet().addAll(Arrays.asList(buildFullTraversal()));

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
               retVal.add(oc.getObj());
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return retVal;
   }

   /**
    * Getting the MOREF of the entity.
    */
   private static ManagedObjectReference getFirstEntityByMOR(
         ManagedObjectReference mor, String entityType) {
      List<ManagedObjectReference> listmors = getMorList(mor, entityType);
      ManagedObjectReference retval = null;
      if (listmors.size() > 0) {
         return listmors.get(0);
      }
      return retval;
   }

   /**
    * This method returns a MoRef to the HostSystem with the supplied name under
    * the supplied Folder. If hostname is null, it returns the first HostSystem
    * found under the supplied Folder
    * 
    * @param hostFolderMor
    *           MoRef to the Folder to look in
    * @param hostname
    *           Name of the HostSystem you are looking for
    * @return MoRef to the HostSystem or null if not found
    * @throws Exception
    */
   private static ManagedObjectReference getHost(
         ManagedObjectReference hostFolderMor, String hostname)
         throws Exception {

      ManagedObjectReference hostmor = null;
      if (hostname != null) {
         hostmor = getEntityByName(hostname, "HostSystem");
      } else {
         hostmor = getFirstEntityByMOR(hostFolderMor, "HostSystem");
      }
      return hostmor;
   }

   /**
    * @param vmName
    *           Name of the virtual machine
    * @return ManagedObjectReference spec for the virtual machine
    */
   private static Object getHostConfigManagerrByHostMor(
         ManagedObjectReference hostmor) throws Exception {
      return getDynamicProperty(hostmor, "configManager");
   }

   @SuppressWarnings("unchecked")
   private static void removeVirtualNic() {
      ManagedObjectReference dcmor;
      ManagedObjectReference hostfoldermor;
      ManagedObjectReference hostmor = null;

      try {
         if (((datacenter != null) && (host != null))
               || ((datacenter != null) && (host == null))) {
            dcmor = getDatacenterByName(datacenter);
            if (dcmor == null) {
               System.out.println("Datacenter not found");
               return;
            }
            hostfoldermor = getMorFromPropertyName(dcmor, "hostFolder");
            hostmor = getHost(hostfoldermor, host);
         } else if ((datacenter == null) && (host != null)) {
            hostmor = getHost(null, host);
         }

         if (hostmor != null) {
            Object cmobj = getHostConfigManagerrByHostMor(hostmor);
            HostConfigManager configMgr = (HostConfigManager) cmobj;
            ManagedObjectReference nwSystem = configMgr.getNetworkSystem();

            List<HostVirtualNic> hvncArr =
                  (List<HostVirtualNic>) getDynamicProperty(nwSystem,
                        "networkInfo.vnic");
            boolean foundOne = false;
            for (HostVirtualNic nic : hvncArr) {
               String portGroup = nic.getPortgroup();
               if (portGroup.equals(portgroupname)) {
                  vimPort.removeVirtualNic(nwSystem, nic.getDevice());
                  foundOne = true;
               }
            }
            if (foundOne) {
               System.out
                     .println("Successfully removed virtual nic from portgroup : "
                           + portgroupname);
            } else {
               System.out.println("No virtual nic found on portgroup : "
                     + portgroupname);
            }
         } else {
            System.out.println("Host not found");
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (HostConfigFaultFaultMsg ex) {
         System.out.println("Failed : Configuration falilures. ");
      } catch (NotFoundFaultMsg ex) {
         System.out.println("Failed : " + ex);
      } catch (RuntimeFaultFaultMsg ex) {
         System.out.println("Failed : " + ex);
      } catch (Exception e) {
         System.out.println("Failed : " + e);
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
      System.out.println("This sample removes a Virtual Nic from a PortGroup"
            + " on a vSwitch");
      System.out.println("\nParameters:");
      System.out
            .println("url              [required] : url of the web service");
      System.out
            .println("username         [required] : username for the authentication");
      System.out
            .println("password         [required] : password for the authentication");
      System.out
            .println("portgroupname    [required] : Name of port group to remove Virtual Nic from");
      System.out.println("hostname         [required] : Name of host");
      System.out.println("datacentername   [optional] : Name of datacenter");
      System.out.println("\nCommand:");
      System.out.println("Remove a VirtualNic from a PortGroup");
      System.out
            .println("run.bat com.vmware.host.RemoveVirtualNic --url [webserviceurl]");
      System.out
            .println("--username [username] --password  [password] --datacentername [mydatacenter]");
      System.out.println("--portgroupname [myportgroup] --hostname [hostname]");
      System.out
            .println("Remove a VirtualNic from a PortGroup without hostname");
      System.out
            .println("run.bat com.vmware.host.RemoveVirtualNic --url [webserviceurl]");
      System.out
            .println("--username [username] --password  [password] --datacentername [mydatacenter]");
      System.out.println("--portgroupname [myportgroup]");
      System.out
            .println("Remove a VirtualNic from a PortGroup without datacentername");
      System.out
            .println("run.bat com.vmware.host.RemoveVirtualNic --url [webserviceurl]");
      System.out.println("--username [username] --password  [password]");
      System.out
            .println("--portgroupname [myportgroup] --hostname [name of the host]");
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
         removeVirtualNic();
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
