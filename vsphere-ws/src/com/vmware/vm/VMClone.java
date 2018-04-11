package com.vmware.vm;

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
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VirtualMachineCloneSpec;
import com.vmware.vim25.VirtualMachineRelocateSpec;

/**
 * <pre>
 * VMClone
 * 
 * This sample makes a template of an existing VM and
 * deploy multiple instances of this template onto a datacenter
 * 
 * <b>Parameters:</b>
 * url             [required] : url of the web service
 * username        [required] : username for the authentication
 * password        [required] : password for the authentication
 * datacentername  [required] : name of Datacenter
 * vmpath          [required] : inventory path of the VM
 * clonename       [required] : name of the clone
 * 
 * <b>Command Line:</b>
 * java com.vmware.vm.VMClone --url [webserviceurl]
 * --username [username] --password [password]
 * --datacentername [DatacenterName]"
 * --vmpath [vmPath] --clonename [CloneName]
 * </pre>
 */
public class VMClone {

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
   private static ManagedObjectReference propCollectorRef;
   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;
   private static final String SVC_INST_NAME = "ServiceInstance";

   private static String url;
   private static String userName;
   private static String password;
   private static boolean help = false;
   private static boolean isConnected = false;
   private static String dataCenterName;
   private static String vmPathName;
   private static String cloneName;

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
         if (param.equalsIgnoreCase("--datacentername")
               && !val.startsWith("--") && !val.isEmpty()) {
            dataCenterName = val;
         } else if (param.equalsIgnoreCase("--vmpath") && !val.startsWith("--")
               && !val.isEmpty()) {
            vmPathName = val;
         } else if (param.equalsIgnoreCase("--clonename")
               && !val.startsWith("--") && !val.isEmpty()) {
            cloneName = val;
         }
         val = "";
         ai += 2;
      }
      if (dataCenterName == null || vmPathName == null || cloneName == null) {
         throw new IllegalArgumentException("Expected --datacentername, "
               + "--vmpath and --clonename argument.");
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

   private static void cloneVM() throws Exception {
      // Find the Datacenter reference by using findByInventoryPath().
      ManagedObjectReference datacenterRef =
            vimPort.findByInventoryPath(serviceContent.getSearchIndex(),
                  dataCenterName);
      if (datacenterRef == null) {
         System.out.printf("The specified datacenter [ %s ]is not found %n",
               dataCenterName);
         return;
      }
      // Find the virtual machine folder for this datacenter.
      ManagedObjectReference vmFolderRef =
            (ManagedObjectReference) getDynamicProperty(datacenterRef,
                  "vmFolder");
      if (vmFolderRef == null) {
         System.out.println("The virtual machine is not found");
         return;
      }
      ManagedObjectReference vmRef =
            vimPort.findByInventoryPath(serviceContent.getSearchIndex(),
                  vmPathName);
      if (vmRef == null) {
         System.out.printf("The VMPath specified [ %s ] is not found %n",
               vmPathName);
         return;
      }
      VirtualMachineCloneSpec cloneSpec = new VirtualMachineCloneSpec();
      VirtualMachineRelocateSpec relocSpec = new VirtualMachineRelocateSpec();
      cloneSpec.setLocation(relocSpec);
      cloneSpec.setPowerOn(false);
      cloneSpec.setTemplate(false);

      System.out.printf("Cloning Virtual Machine [%s] to clone name [%s] %n",
            vmPathName.substring(vmPathName.lastIndexOf("/") + 1), cloneName);
      try {
         ManagedObjectReference cloneTask =
               vimPort.cloneVMTask(vmRef, vmFolderRef, cloneName, cloneSpec);
         if (getTaskResultAfterDone(cloneTask)) {
            System.out
                  .printf(
                        "Successfully cloned Virtual Machine [%s] to clone name [%s] %n",
                        vmPathName.substring(vmPathName.lastIndexOf("/") + 1),
                        cloneName);
         } else {
            System.out.printf(
                  "Failure Cloning Virtual Machine [%s] to clone name [%s] %n",
                  vmPathName.substring(vmPathName.lastIndexOf("/") + 1),
                  cloneName);
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
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
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println(" : Failed Getting Contents");
         e.printStackTrace();
      }

      return listobjcontent;
   }

   private static Object getDynamicProperty(ManagedObjectReference mor,
         String propertyName) throws Exception {
      ObjectContent[] objContent =
            getObjectProperties(mor, new String[] { propertyName });

      Object propertyValue = null;
      if (objContent != null) {
         List<DynamicProperty> listdp = objContent[0].getPropSet();
         if (listdp != null) {
            /*
             * Check the dynamic property for ArrayOfXXX object
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
                * If object is ArrayOfXXX object, then get the XXX[] by
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
      List<ObjectContent> listobjcont = retrievePropertiesAllObjects(listpfs);
      return listobjcont.toArray(new ObjectContent[listobjcont.size()]);
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
      System.out.println("This sample makes a template of an existing VM and ");
      System.out
            .println("deploy multiple instances of this template onto a datacenter.");
      System.out.println("\nParameters:");
      System.out.println("url             [required] : url of the web service");
      System.out
            .println("username        [required] : username for the authentication");
      System.out
            .println("password        [required] : password for the authentication");
      System.out.println("datacentername  [required] : name of Datacenter");
      System.out
            .println("vmpath          [required] : inventory path of the VM");
      System.out.println("clonename       [required] : name of the clone");
      System.out.println("\nCommand:");
      System.out
            .println("run.bat com.vmware.vm.VMClone --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--datacentername [datacenter name]");
      System.out.println("--vmpath [vmPath] --clonename [CloneName]");
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
         cloneVM();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (IllegalArgumentException e) {
         printUsage();
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
