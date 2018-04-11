package com.vmware.httpfileaccess;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.ArrayOfDatastoreHostMount;
import com.vmware.vim25.DatastoreHostMount;
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
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualMachineFileInfo;

/**
 * <pre>
 * ColdMigration
 * 
 * This sample puts VM files in specified Datacenter and
 * Datastore and register and reconfigure the particular VM
 * 
 * <b>Parameters:</b>
 * url              [required]: url of the web service.
 * username         [required]: username for the authentication
 * password         [required]: password for the authentication
 * vmname           [required]: Name of the virtual machine
 * localpath        [required]: Local path to which files will be copied
 * datacentername   [required]: Name of the target datacenter
 * datastorename    [required]: Name of the target datastore
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.httpfileaccess.ColdMigration
 * --url [URLString] --username [username] --password [password]
 * --vmname [VM name] --localpath [local path]
 * --datacentername [datacenter name]
 * --datastorename [datastore name]
 * </pre>
 */

public class ColdMigration {

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
   private static Map headers = new HashMap();
   private static String cookieValue = "";
   private static ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();

   private static ManagedObjectReference registeredVMRef = null;
   /*
   Connection input parameters
   */
   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
   private static String vmName = null;
   private static String localPath = null;
   private static String datacenter = null;
   private static String datastore = null;
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

   // get imput parameters to run the sample
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
         } else if (param.equalsIgnoreCase("--localpath")
               && !val.startsWith("--") && !val.isEmpty()) {
            localPath = val;
         } else if (param.equalsIgnoreCase("--datacentername")
               && !val.startsWith("--") && !val.isEmpty()) {
            datacenter = val;
         } else if (param.equalsIgnoreCase("--datastorename")
               && !val.startsWith("--") && !val.isEmpty()) {
            datastore = val;
         }
         val = "";
         ai += 2;
      }
      if (vmName == null || localPath == null || datacenter == null
            || datastore == null) {
         throw new IllegalArgumentException(
               "Expected --vmName, --localPath, --datacenter and --datastore arguments.");
      }
   }

   /**
    * Establishes session with the virtual center server.
    * 
    * @throws Exception
    *            the exception
    */
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
      headers =
            (Map) ((BindingProvider) vimPort).getResponseContext().get(
                  MessageContext.HTTP_RESPONSE_HEADERS);
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

   /**
    * Returns all the MOREFs of the specified type that are present under the
    * container
    * 
    * @param folder
    *           {@link ManagedObjectReference} of the container to begin the
    *           search from
    * @param morefType
    *           Type of the managed entity that needs to be searched
    * 
    * @return Map of name and MOREF of the managed objects present. If none
    *         exist then empty Map is returned
    * 
    * @throws InvalidPropertyFaultMsg
    * @throws RuntimeFaultFaultMsg
    */
   private static Map<String, ManagedObjectReference> getMOREFsInContainerByType(
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

      RetrieveResult rslts =
            vimPort.retrievePropertiesEx(serviceContent.getPropertyCollector(),
                  propertyFilterSpecs, new RetrieveOptions());
      List<ObjectContent> listobjcontent = new ArrayList<ObjectContent>();
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
               vimPort.continueRetrievePropertiesEx(
                     serviceContent.getPropertyCollector(), token);
         token = null;
         if (rslts != null) {
            token = rslts.getToken();
            if (rslts.getObjects() != null && !rslts.getObjects().isEmpty()) {
               listobjcontent.addAll(rslts.getObjects());
            }
         }
      }
      for (ObjectContent oc : listobjcontent) {
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

      RetrieveResult rslts =
            vimPort.retrievePropertiesEx(serviceContent.getPropertyCollector(),
                  propertyFilterSpecs, new RetrieveOptions());
      List<ObjectContent> listobjcontent = new ArrayList<ObjectContent>();
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
               vimPort.continueRetrievePropertiesEx(
                     serviceContent.getPropertyCollector(), token);
         token = null;
         if (rslts != null) {
            token = rslts.getToken();
            if (rslts.getObjects() != null && !rslts.getObjects().isEmpty()) {
               listobjcontent.addAll(rslts.getObjects());
            }
         }
      }
      for (ObjectContent oc : listobjcontent) {
         List<DynamicProperty> dps = oc.getPropSet();
         if (dps != null) {
            for (DynamicProperty dp : dps) {
               retVal.put(dp.getName(), dp.getVal());
            }
         }
      }
      return retVal;
   }

   private static boolean customValidation() throws Exception {
      boolean validate = false;
      if (datacenter.length() != 0 && datacenter != null
            && datastore.length() != 0 && datastore != null) {
         ManagedObjectReference dcmor =
               getMOREFsInContainerByType(serviceContent.getRootFolder(),
                     "Datacenter").get(datacenter);
         if (dcmor != null) {
            ManagedObjectReference ds =
                  getMOREFsInContainerByType(dcmor, "Datastore").get(datastore);
            if (ds == null) {
               System.out.println("Specified Datastore with name " + datastore
                     + " was not" + " found in specified Datacenter");
               return validate;
            }
            validate = true;
         } else {
            System.out.println("Specified Datacenter with name " + datacenter
                  + " not Found");
            return validate;
         }
      }
      return validate;
   }

   private static String[] getDirFiles(String localDir) throws Exception {
      File temp = new File(localDir);
      String[] listOfFiles = temp.list();
      if (listOfFiles != null) {
         return listOfFiles;
      } else {
         System.out.println("Local Path Doesn't Exist");
         return null;
      }
   }

   @SuppressWarnings("unchecked")
   private static void putVMFiles(String remoteFilePath, String localFilePath)
         throws Exception {
      String serviceUrl = url.substring(0, url.lastIndexOf("sdk") - 1);
      String httpUrl =
            serviceUrl + "/folder" + remoteFilePath + "?dcPath=" + datacenter
                  + "&dsName=" + datastore;
      httpUrl = httpUrl.replaceAll("\\ ", "%20");
      System.out.println("Putting VM File " + httpUrl);
      URL fileURL = new URL(httpUrl);
      HttpURLConnection conn = (HttpURLConnection) fileURL.openConnection();
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setAllowUserInteraction(true);

      // Maintain session
      List<String> cookies = (List<String>) headers.get("Set-cookie");
      cookieValue = cookies.get(0);
      StringTokenizer tokenizer = new StringTokenizer(cookieValue, ";");
      cookieValue = tokenizer.nextToken();
      String path = "$" + tokenizer.nextToken();
      String cookie = "$Version=\"1\"; " + cookieValue + "; " + path;

      // set the cookie in the new request header
      Map<String, List<String>> map = new HashMap<String, List<String>>();
      map.put("Cookie", Collections.singletonList(cookie));
      ((BindingProvider) vimPort).getRequestContext().put(
            MessageContext.HTTP_REQUEST_HEADERS, map);

      conn.setRequestProperty("Cookie", cookie);
      conn.setRequestProperty("Content-Type", "application/octet-stream");
      conn.setRequestMethod("PUT");
      conn.setRequestProperty("Content-Length", "1024");
      long fileLen = new File(localFilePath).length();
      System.out.println("File size is: " + fileLen);
      conn.setChunkedStreamingMode((int) fileLen);
      OutputStream out = conn.getOutputStream();
      InputStream in =
            new BufferedInputStream(new FileInputStream(localFilePath));
      int bufLen = 9 * 1024;
      byte[] buf = new byte[bufLen];
      byte[] tmp = null;
      int len = 0;
      while ((len = in.read(buf, 0, bufLen)) != -1) {
         tmp = new byte[len];
         System.arraycopy(buf, 0, tmp, 0, len);
         out.write(tmp, 0, len);
      }
      in.close();
      out.close();
      conn.getResponseMessage();
      conn.disconnect();
   }

   private static void copyDir(String dirName) throws Exception {
      System.out.println("Copying The Virtual Machine To Host..........");
      dirName = localPath + "/" + dirName;
      String[] listOfFiles = getDirFiles(dirName);
      for (int i = 0; i < listOfFiles.length; i++) {
         String remoteFilePath = "/" + vmName + "/" + listOfFiles[i];
         String localFilePath = dirName + "/" + listOfFiles[i];
         if (localFilePath.indexOf("vdisk") != -1) {
            String dataStoreName =
                  dirName.substring(dirName.lastIndexOf("#") + 1);
            remoteFilePath =
                  "/" + vmName + "/" + dataStoreName + "/" + listOfFiles[i];
         } else {
            remoteFilePath = "/" + vmName + "/" + listOfFiles[i];
         }
         putVMFiles(remoteFilePath, localFilePath);
      }
      System.out.println("Copying The Virtual Machine To Host..........Done");
   }

   private static boolean registerVirtualMachine() throws Exception {
      boolean registered = false;
      System.out.println("Registering The Virtual Machine ..........");
      ManagedObjectReference hostmor = null;
      // Get the Datacenter
      ManagedObjectReference dcmor =
            getMOREFsInContainerByType(serviceContent.getRootFolder(),
                  "Datacenter").get(datacenter);

      // Get the Datastore
      ManagedObjectReference dsmor =
            getMOREFsInContainerByType(dcmor, "Datastore").get(datastore);

      List<DatastoreHostMount> hostmounts =
            ((ArrayOfDatastoreHostMount) getEntityProps(dsmor,
                  new String[] { "host" }).get("host")).getDatastoreHostMount();

      for (DatastoreHostMount datastoreHostMount : hostmounts) {
         if (datastoreHostMount.getMountInfo().isAccessible()
               && datastoreHostMount.getMountInfo().isMounted()) {
            hostmor = datastoreHostMount.getKey();
            break;
         }
      }
      if (hostmor == null) {
         throw new RuntimeException("No host connected to the datastore "
               + datastore);
      }

      ManagedObjectReference crmor =
            (ManagedObjectReference) getEntityProps(hostmor,
                  new String[] { "parent" }).get("parent");

      ManagedObjectReference resourcePoolRef =
            (ManagedObjectReference) getEntityProps(crmor,
                  new String[] { "resourcePool" }).get("resourcePool");

      ManagedObjectReference vmFolderMor =
            (ManagedObjectReference) getEntityProps(dcmor,
                  new String[] { "vmFolder" }).get("vmFolder");

      // Get The vmx path
      String vmxPath = "[" + datastore + "] " + vmName + "/" + vmName + ".vmx";


      // Registering The Virtual machine
      ManagedObjectReference taskmor =
            vimPort.registerVMTask(vmFolderMor, vmxPath, vmName, false,
                  resourcePoolRef, hostmor);

      if (getTaskResultAfterDone(taskmor)) {
         System.out.println("Registering The Virtual Machine ..........Done");
         registered = true;
         registeredVMRef =
               (ManagedObjectReference) getEntityProps(taskmor,
                     new String[] { "info.result" }).get("info.result");
         System.out.println("VM registered with value "
               + registeredVMRef.getValue());
      } else {
         System.out.println("Some Exception While Registering The VM");
         registered = false;
      }
      return registered;
   }

   private static void reconfigVirtualMachine() throws Exception {
      System.out.println("ReConfigure The Virtual Machine ..........");
      VirtualMachineFileInfo vmFileInfo = new VirtualMachineFileInfo();
      vmFileInfo.setLogDirectory("[" + datastore + "] " + vmName);
      vmFileInfo.setSnapshotDirectory("[" + datastore + "] " + vmName);
      vmFileInfo.setSuspendDirectory("[" + datastore + "] " + vmName);
      vmFileInfo.setVmPathName("[" + datastore + "] " + vmName + "/" + vmName
            + ".vmx");

      VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
      vmConfigSpec.setFiles(vmFileInfo);

      ManagedObjectReference taskmor =
            vimPort.reconfigVMTask(registeredVMRef, vmConfigSpec);

      if (getTaskResultAfterDone(taskmor)) {
         System.out.println("ReConfigure The Virtual Machine .......... Done");
      } else {
         System.out.println("Some Exception While Reconfiguring The VM ");
      }
   }

   private static void coldMigration() throws Exception {
      boolean validated = customValidation();
      if (validated) {
         String[] listOfDir = getDirFiles(localPath);
         if (listOfDir != null && listOfDir.length != 0) {
            // Dumping All The Data
            for (int i = 0; i < listOfDir.length; i++) {
               if (listOfDir[i].indexOf("#") != -1) {
                  if (!listOfDir[i].substring(0, listOfDir[i].indexOf("#"))
                        .equals(vmName)) {
                     continue;
                  }
               }
               copyDir(listOfDir[i]);
               // Register The Virtual Machine
               boolean reconFlag = registerVirtualMachine();
               //Reconfigure the disks
               if (reconFlag) {
                  reconfigVirtualMachine();
               }
            }
         } else {
            System.out.println("There are no VM Directories"
                  + " available on Specified locations");
         }
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
            .println("This sample puts VM files in specified Datacenter and"
                  + " Datastore and register and reconfigure the particular VM");
      System.out
            .println("url              [required] : url of the web service.");
      System.out
            .println("username         [required] : username for the authentication");
      System.out
            .println("password         [required] : password for the authentication");
      System.out
            .println("vmname           [required] : Name of the virtual machine");
      System.out
            .println("localpath        [required] : Local path to which files will be copied");
      System.out
            .println("datacentername   [required] : Name of the target datacenter");
      System.out
            .println("datastorename    [required] : Name of the target datastore");
      System.out.println("run.bat com.vmware.httpfileaccess.ColdMigration");
      System.out
            .println("--url [webserviceurl] --username [username] --password [password]");
      System.out.println("--vmname [VM name] --localpath [local path]");
      System.out.println("--datacentername [datacenter name]");
      System.out.println("--datastorename [datastore name]");
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
         coldMigration();
      } catch (IllegalArgumentException e) {
         printUsage();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println("Exception encountered " + e);
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
