package com.vmware.httpfileaccess;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
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
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDeviceFileBackingInfo;
import com.vmware.vim25.VirtualDisk;
import com.vmware.vim25.VirtualMachineConfigInfo;

/**
 * <pre>
 * GetVMFiles
 * 
 * This sample gets all the config files, snapshots files,
 * logs files, virtual disk files to the local system.
 * 
 * <b>Parameters:</b>
 * url          [required] : url of the web service.
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 * vmname       [required] : Name of the virtual machine
 * localpath    [required] : localpath to copy files
 * 
 * <b>Command Line:</b>
 * To get the virtual machine files on local disk
 * run.bat com.vmware.httpfileaccess.GetVMFiles
 * --url [webserviceurl] --username [username] --password [password]
 * --vmname [vmname] --localpath [localpath]
 * </pre>
 */

public class GetVMFiles {

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

   private static final String SVC_INST_NAME = "ServiceInstance";
   private static final ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();

   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;

   private static String cookieValue = "";
   private static Map headers = new HashMap();

   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
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

   private static void getConnectionParameters(String[] args) {
      String param = "";
      if (args.length != 0) {
         if (args.length < 2) {
            param = args[0].trim();
            if (param.equalsIgnoreCase("--help")) {
               help = true;
               return;
            } else {
               throw new IllegalArgumentException("Expected --url,"
                     + " --username, --password arguments.");
            }
         }
      }
      int ai = 0;
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
      if ((url == null) || (userName == null) || (password == null) && !help) {
         throw new IllegalArgumentException("Expected --url, --username, "
               + "--password arguments.");
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
         isConnected = false;
      }
   }

   private static String vmName = null;
   private static String localPath = null;
   private static Map<String, String> downloadedDir =
         new HashMap<String, String>();

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
         }
         if (param.equalsIgnoreCase("--localpath") && !val.startsWith("--")
               && !val.isEmpty()) {
            localPath = val;
         }
         val = "";
         ai += 2;
      }
      if (vmName == null || localPath == null) {
         throw new IllegalArgumentException("Expected --vnname argument.");
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

   /**
    * 
    * @return An array of SelectionSpec to navigate from the VM and move upwards
    *         to reach the Datacenter
    */
   private static List<SelectionSpec> buildTraversalSpecForVMToDatacenter() {
   
      // For Folder -> Folder recursion
      SelectionSpec sspecvfolders = new SelectionSpec();
      sspecvfolders.setName("VisitFolders");
   
      TraversalSpec visitFolders = new TraversalSpec();
      visitFolders.setType("Folder");
      visitFolders.setPath("parent");
      visitFolders.setSkip(Boolean.FALSE);
      visitFolders.setName("VisitFolders");
      visitFolders.getSelectSet().add(sspecvfolders);
   
      // For vApp -> vApp recursion
      SelectionSpec sspecvApp = new SelectionSpec();
      sspecvApp.setName("vAppToVApp");
   
      SelectionSpec sspecvAppToFolder = new SelectionSpec();
      sspecvAppToFolder.setName("vAppToFolder");
   
      TraversalSpec vAppToFolder = new TraversalSpec();
      vAppToFolder.setType("VirtualApp");
      vAppToFolder.setPath("parentFolder");
      vAppToFolder.setSkip(Boolean.FALSE);
      vAppToFolder.setName("vAppToFolder");
      vAppToFolder.getSelectSet().add(sspecvfolders);
   
      TraversalSpec vAppToVApp = new TraversalSpec();
      vAppToVApp.setType("VirtualApp");
      vAppToVApp.setPath("parentVApp");
      vAppToVApp.setSkip(Boolean.FALSE);
      vAppToVApp.setName("vAppToVApp");
      vAppToVApp.getSelectSet().add(sspecvApp);
      vAppToVApp.getSelectSet().add(sspecvAppToFolder);
   
      TraversalSpec vmTovApp = new TraversalSpec();
      vmTovApp.setType("VirtualMachine");
      vmTovApp.setPath("parentVApp");
      vmTovApp.setSkip(Boolean.FALSE);
      vmTovApp.setName("vmTovApp");
      vmTovApp.getSelectSet().add(vAppToVApp);
      vmTovApp.getSelectSet().add(vAppToFolder);
   
      TraversalSpec vmToFolder = new TraversalSpec();
      vmToFolder.setType("VirtualMachine");
      vmToFolder.setPath("parent");
      vmToFolder.setSkip(Boolean.FALSE);
      vmToFolder.setName("vmToFolder");
      vmToFolder.getSelectSet().add(sspecvfolders);
   
      List<SelectionSpec> speclist = new ArrayList<SelectionSpec>();
      speclist.add(vmToFolder);
      speclist.add(vmTovApp);
      speclist.add(visitFolders);
      return speclist;
   }

   /**
    * Method to retrieve the Datacenter under which the specified VM resides
    * 
    * @param vmMor
    *           {@link ManagedObjectReference} of the VM
    * @return {@link String} name of the datacenter that contains the VM.
    * @throws InvalidPropertyFaultMsg
    * @throws RuntimeFaultFaultMsg
    */
   private static String getDatacenterOfVM(ManagedObjectReference vmMor)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
      String datacenterName = "";
   
      // Create Property Spec
      PropertySpec propertySpec = new PropertySpec();
      propertySpec.setAll(Boolean.FALSE);
      propertySpec.setType("Datacenter");
      propertySpec.getPathSet().add("name");
   
      // Now create Object Spec
      ObjectSpec objectSpec = new ObjectSpec();
      objectSpec.setObj(vmMor);
      objectSpec.setSkip(Boolean.TRUE);
      objectSpec.getSelectSet().addAll(buildTraversalSpecForVMToDatacenter());
   
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
                  datacenterName = (String) dp.getVal();
               }
            }
            System.out.println("VM is present under " + datacenterName
                  + " Datacenter");
            break;
         }
      }
      return datacenterName;
   }

   private static void getVM() throws IllegalArgumentException, Exception {
      File file = new File(localPath);
      if (!file.exists()) {
         System.out.println("Wrong or invalid path " + localPath);
         return;
      }
      ManagedObjectReference vmRef =
            getMOREFsInContainerByType(serviceContent.getRootFolder(),
                  "VirtualMachine").get(vmName);
      if (vmRef != null) {
         System.out.println("vmRef: " + vmRef.getValue());
         getDiskSizeInKB(vmRef);
         String dataCenterName = getDatacenterOfVM(vmRef);
         String[] vmDirectory = getVmDirectory(vmRef);
         if (vmDirectory[0] != null) {
            System.out.println("vmDirectory-0: " + vmDirectory[0]
                  + " datacenter as : " + dataCenterName);
            System.out
                  .println("Downloading Virtual Machine Configuration Directory");
            String dataStoreName =
                  vmDirectory[0].substring(vmDirectory[0].indexOf("[") + 1,
                        vmDirectory[0].lastIndexOf("]"));
            String configurationDir =
                  vmDirectory[0].substring(vmDirectory[0].indexOf("]") + 2,
                        vmDirectory[0].lastIndexOf("/"));
            boolean success =
                  new File(localPath + "\\" + configurationDir + "#vm#"
                        + dataStoreName).mkdir();
            if (!success) {
               System.out.println("Could not create " + localPath + "\\"
                     + configurationDir + "#vm#" + dataStoreName + "directory");
            }
            downloadDirectory(configurationDir, configurationDir + "#vm#"
                  + dataStoreName, dataStoreName, dataCenterName);
            downloadedDir.put(configurationDir + "#vm#" + dataStoreName,
                  "Directory");
            System.out.println("Downloading Virtual Machine"
                  + " Configuration Directory Complete");
         }

         if (vmDirectory[1] != null) {
            System.out.println("Downloading Virtual Machine "
                  + "Snapshot / Suspend / Log Directory");
            for (int i = 1; i < vmDirectory.length; i++) {
               String dataStoreName =
                     vmDirectory[i].substring(vmDirectory[i].indexOf("[") + 1,
                           vmDirectory[i].lastIndexOf("]"));
               String configurationDir = "";
               String apiType = serviceContent.getAbout().getApiType();
               if (apiType.equalsIgnoreCase("VirtualCenter")) {
                  configurationDir =
                        vmDirectory[i].substring(
                              vmDirectory[i].indexOf("]") + 2,
                              vmDirectory[i].length() - 1);
               } else {
                  configurationDir =
                        vmDirectory[i]
                              .substring(vmDirectory[i].indexOf("]") + 2);
               }
               if (!downloadedDir.containsKey(configurationDir + "#vm#"
                     + dataStoreName)) {
                  boolean success =
                        new File(localPath + "/" + configurationDir + "#vm#"
                              + dataStoreName).mkdir();
                  if (!success) {
                     System.out.println("Could not create " + localPath + "/"
                           + configurationDir + "#vm#" + dataStoreName
                           + "directory");
                  }
                  downloadDirectory(configurationDir, configurationDir + "#vm#"
                        + dataStoreName, dataStoreName, dataCenterName);
                  downloadedDir.put(configurationDir + "#vm#" + dataStoreName,
                        "Directory");
               } else {
                  System.out.println("Already Downloaded");
               }
            }
            System.out.println("Downloading Virtual Machine Snapshot"
                  + " / Suspend / Log Directory Complete");
         }

         String[] virtualDiskLocations = getVDiskLocations(vmRef);
         if (virtualDiskLocations != null) {
            System.out.println("Downloading Virtual Disks");
            for (int i = 0; i < virtualDiskLocations.length; i++) {
               if (virtualDiskLocations[i] != null) {
                  String dataStoreName =
                        virtualDiskLocations[i].substring(
                              virtualDiskLocations[i].indexOf("[") + 1,
                              virtualDiskLocations[i].lastIndexOf("]"));
                  String configurationDir =
                        virtualDiskLocations[i].substring(
                              virtualDiskLocations[i].indexOf("]") + 2,
                              virtualDiskLocations[i].lastIndexOf("/"));
                  if (!downloadedDir.containsKey(configurationDir + "#vm#"
                        + dataStoreName)) {
                     boolean success =
                           new File(localPath + "/" + configurationDir
                                 + "#vdisk#" + dataStoreName).mkdir();
                     if (!success) {
                        System.out.println("Could not create " + localPath
                              + "/" + configurationDir + "#vdisk#"
                              + dataStoreName + "directory");
                     }
                     downloadDirectory(configurationDir, configurationDir
                           + "#vdisk#" + dataStoreName, dataStoreName,
                           dataCenterName);
                     downloadedDir.put(configurationDir + "#vdisk#"
                           + dataStoreName, "Directory");
                  } else {
                     System.out.println("Already Downloaded");
                  }
               } else {
                  System.out.println("Already Downloaded");
               }
            }
            System.out.println("Downloading Virtual Disks Complete");
         } else {
            System.out.println("Downloading Virtual Disks Complete");
         }
      } else {
         throw new IllegalArgumentException("Virtual Machine " + vmName
               + " Not Found.");
      }
   }

   private static String[] getVmDirectory(ManagedObjectReference vmmor)
         throws Exception {
      String[] vmDir = new String[4];
      VirtualMachineConfigInfo vmConfigInfo =
            (VirtualMachineConfigInfo) getEntityProps(vmmor,
                  new String[] { "config" }).get("config");
      if (vmConfigInfo != null) {
         vmDir[0] = vmConfigInfo.getFiles().getVmPathName();
         vmDir[1] = vmConfigInfo.getFiles().getSnapshotDirectory();
         vmDir[2] = vmConfigInfo.getFiles().getSuspendDirectory();
         vmDir[3] = vmConfigInfo.getFiles().getLogDirectory();
      } else {
         System.out.println("Connot Restore VM. Not Able "
               + "To Find The Virtual Machine Config Info");
      }
      return vmDir;
   }

   private static void getDiskSizeInKB(ManagedObjectReference vmMor)
         throws Exception {
      VirtualMachineConfigInfo vmConfigInfo =
            (VirtualMachineConfigInfo) getEntityProps(vmMor,
                  new String[] { "config" }).get("config");
      if (vmConfigInfo != null) {
         List<VirtualDevice> livd = vmConfigInfo.getHardware().getDevice();
         for (VirtualDevice virtualDevice : livd) {
            if (virtualDevice instanceof VirtualDisk) {
               System.out.println("Disk size in kb: "
                     + ((VirtualDisk) virtualDevice).getCapacityInKB());
            }
         }
      }
   }

   private static String[] getVDiskLocations(ManagedObjectReference vmmor)
         throws Exception {
      VirtualMachineConfigInfo vmConfigInfo =
            (VirtualMachineConfigInfo) getEntityProps(vmmor,
                  new String[] { "config" }).get("config");
      System.out.println("vmconfig info : " + vmConfigInfo);
      if (vmConfigInfo != null) {
         List<VirtualDevice> livd = vmConfigInfo.getHardware().getDevice();
         VirtualDevice[] vDevice = livd.toArray(new VirtualDevice[livd.size()]);
         int count = 0;
         String[] virtualDisk = new String[vDevice.length];

         for (int i = 0; i < vDevice.length; i++) {
            if (vDevice[i].getClass().getCanonicalName()
                  .equalsIgnoreCase("com.vmware.vim25.VirtualDisk")) {
               try {
                  long size = ((VirtualDisk) vDevice[i]).getCapacityInKB();
                  System.out.println("Disk size in kb: " + size);
                  VirtualDeviceFileBackingInfo backingInfo =
                        (VirtualDeviceFileBackingInfo) vDevice[i].getBacking();
                  virtualDisk[count] = backingInfo.getFileName();
                  System.out.println("virtualDisk : " + virtualDisk[count]);
                  count++;
               } catch (SOAPFaultException sfe) {
                  printSoapFaultException(sfe);
               } catch (ClassCastException e) {
                  System.out.println("Got Exception : " + e);
               }
            }
         }
         return virtualDisk;
      } else {
         System.out.println("Connot Restore VM. Not Able To"
               + " Find The Virtual Machine Config Info");
         return null;
      }
   }

   private static void downloadDirectory(String directoryName,
         String localDirectory, String dataStoreName, String dataCenter)
         throws Exception {
      String serviceUrl = url;
      serviceUrl = serviceUrl.substring(0, serviceUrl.lastIndexOf("sdk") - 1);
      String httpUrl =
            serviceUrl + "/folder/" + directoryName + "?dcPath=" + dataCenter
                  + "&dsName=" + dataStoreName;
      httpUrl = httpUrl.replaceAll("\\ ", "%20");
      System.out.println("httpUrl : " + httpUrl);
      String[] linkMap = getListFiles(httpUrl);
      for (int i = 0; i < linkMap.length; i++) {
         System.out.println("Downloading VM File " + linkMap[i]);
         String urlString = serviceUrl + linkMap[i];
         String fileName =
               localDirectory
                     + "/"
                     + linkMap[i].substring(linkMap[i].lastIndexOf("/"),
                           linkMap[i].lastIndexOf("?"));
         urlString = urlString.replaceAll("\\ ", "%20");
         getData(urlString, fileName);
      }
   }

   @SuppressWarnings("unchecked")
   private static String[] getListFiles(String urlString) throws Exception {
      HttpURLConnection conn = null;
      URL urlSt = new URL(urlString);
      conn = (HttpURLConnection) urlSt.openConnection();
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setAllowUserInteraction(true);

      // Maintain session
      List<String> cookies = (List<String>) headers.get("Set-cookie");
      cookieValue = cookies.get(0);
      StringTokenizer tokenizer = new StringTokenizer(cookieValue, ";");
      cookieValue = tokenizer.nextToken();
      String pathData = "$" + tokenizer.nextToken();
      String cookie = "$Version=\"1\"; " + cookieValue + "; " + pathData;

      // set the cookie in the new request header
      Map<String, List<String>> map = new HashMap<String, List<String>>();
      map.put("Cookie", Collections.singletonList(cookie));
      ((BindingProvider) vimPort).getRequestContext().put(
            MessageContext.HTTP_REQUEST_HEADERS, map);

      conn.setRequestProperty("Cookie", cookie);
      conn.setRequestProperty("Content-Type", "application/octet-stream");
      conn.setRequestProperty("Expect", "100-continue");
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Content-Length", "1024");
      String line = null;
      String xmlString = "";
      BufferedReader in =
            new BufferedReader(new InputStreamReader(conn.getInputStream()));
      while ((line = in.readLine()) != null) {
         xmlString = xmlString + line;
      }
      xmlString = xmlString.replaceAll("&amp;", "&");
      xmlString = xmlString.replaceAll("%2e", ".");
      xmlString = xmlString.replaceAll("%2d", "-");
      xmlString = xmlString.replaceAll("%5f", "_");
      ArrayList<String> list = getFileLinks(xmlString);
      String[] linkMap = new String[list.size()];
      for (int i = 0; i < list.size(); i++) {
         linkMap[i] = list.get(i);
      }
      return linkMap;
   }

   private static ArrayList<String> getFileLinks(String xmlString)
         throws Exception {
      ArrayList<String> linkMap = new ArrayList<String>();
      Pattern regex = Pattern.compile("<a href=\".*?\">");
      Matcher regexMatcher = regex.matcher(xmlString);
      while (regexMatcher.find()) {
         String data = regexMatcher.group();
         int ind = data.indexOf("\"") + 1;
         int lind = data.lastIndexOf("\"");
         data = data.substring(ind, lind);
         if (data.indexOf("folder?") == -1) {
            System.out.println("fileLinks data : " + data);
            linkMap.add(data);
         }
      }
      return linkMap;
   }

   @SuppressWarnings("unchecked")
   private static void getData(String urlString, String fileName)
         throws Exception {
      HttpURLConnection conn = null;
      URL urlSt = new URL(urlString);
      conn = (HttpURLConnection) urlSt.openConnection();
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setAllowUserInteraction(true);
      // Maintain session
      List<String> cookies = (List<String>) headers.get("Set-cookie");
      cookieValue = cookies.get(0);
      StringTokenizer tokenizer = new StringTokenizer(cookieValue, ";");
      cookieValue = tokenizer.nextToken();
      String pathData = "$" + tokenizer.nextToken();
      String cookie = "$Version=\"1\"; " + cookieValue + "; " + pathData;

      // set the cookie in the new request header
      Map<String, List<String>> map = new HashMap<String, List<String>>();
      map.put("Cookie", Collections.singletonList(cookie));
      ((BindingProvider) vimPort).getRequestContext().put(
            MessageContext.HTTP_REQUEST_HEADERS, map);

      conn.setRequestProperty("Cookie", cookie);
      conn.setRequestProperty("Content-Type", "application/octet-stream");
      conn.setRequestProperty("Expect", "100-continue");
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Content-Length", "1024");
      InputStream in = conn.getInputStream();
      int leng = fileName.lastIndexOf("/");
      String dir = fileName.substring(0, leng - 1);
      String fName = fileName.substring(leng + 1);
      fName = fName.replace("%20", " ");
      dir = replaceSpecialChar(dir);
      fileName = localPath + "\\" + dir + "\\" + fName;
      OutputStream out =
            new BufferedOutputStream(new FileOutputStream(fileName));
      int bufLen = 9 * 1024;
      byte[] buf = new byte[bufLen];
      byte[] tmp = null;
      int len = 0;
      int bytesRead = 0;
      while ((len = in.read(buf, 0, bufLen)) != -1) {
         bytesRead += len;
         tmp = new byte[len];
         System.arraycopy(buf, 0, tmp, 0, len);
         out.write(tmp, 0, len);
      }
      in.close();
      out.close();
   }

   private static String replaceSpecialChar(String fileName) {
      fileName = fileName.replace(':', '_');
      fileName = fileName.replace('*', '_');
      fileName = fileName.replace('<', '_');
      fileName = fileName.replace('>', '_');
      fileName = fileName.replace('|', '_');
      return fileName;
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
            .println("This sample gets all the config files, snapshots files,");
      System.out.println("logs files, virtual disk files to the local system.");
      System.out.println("\nParameters:\n");
      System.out.println("url          [required] : url of the web service.");
      System.out
            .println("username     [required] : username for the authentication.");
      System.out
            .println("Password     [required] : password for the authentication");
      System.out
            .println("vmname       [required] : Name of the virtual machine");
      System.out.println("localpath    [required] : localpath to copy files");
      System.out
            .println("Command: To get the virtual machine files on local disk.");
      System.out.println("run.bat com.vmware.httpfileaccess.GetVMFiles");
      System.out
            .println("--url [webserviceurl] --username [username] --password [password]");
      System.out.println("--vmname [vmname] --localpath [localpath]");
   }

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         if (help) {
            printUsage();
            return;
         }
         getInputParameters(args);
         connect();
         getVM();
      } catch (IllegalArgumentException iae) {
         System.out.println(iae.getMessage());
         printUsage();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println(" Failed : " + e);
         e.printStackTrace();
      } finally {
         try {
            disconnect();
         } catch (SOAPFaultException sfe) {
            printSoapFaultException(sfe);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

}
