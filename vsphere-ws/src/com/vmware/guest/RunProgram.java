package com.vmware.guest;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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

import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.FileTransferInformation;
import com.vmware.vim25.GuestProcessInfo;
import com.vmware.vim25.GuestProgramSpec;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NamePasswordAuthentication;
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
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VirtualMachinePowerState;

/**
 * <pre>
 * RunProgram
 * 
 * This sample runs a specified program inside a virtual machine with
 * output re-directed to a temporary file inside the guest and
 * downloads the output file.
 * 
 * <b>Parameters:</b>
 * url                 [required] : url of the web service
 * username            [required] : username for the authentication
 * password            [required] : password for the authentication
 * vmname              [required] : name of the virtual machine
 * guestusername       [required] : username in the guest
 * guestpassword       [required] : password in the guest
 * guestprogrampath    [required] : Fully qualified path of the program
 *                                  inside the guest.
 * localoutputfilepath [required] : Path to the local file to store the
 *                                  output.
 * interactivesession  [optional] : Run the program within an
 *                                  interactive session inside the guest.
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.general.RunProgram --url [webserviceurl]
 * --username [username] --password [password] --vmname [vmname]
 * --guestusername [guest user] --guestpassword [guest password]
 * --guestprogrampath [Fully qualified path of the program in the guest]
 * --localoutputfilepath [Path to the local file to store the output]
 * [--interactivesession]
 * </pre>
 */

public class RunProgram {

   private static final ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();
   private static ManagedObjectReference propCollector;
   private static ManagedObjectReference rootRef;
   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;
   private static final String SVC_INST_NAME = "ServiceInstance";
   private static String vimHost;
   private static String userName;
   private static String password;
   private static String guestUserName;
   private static String guestPassword;
   private static String virtualMachineName;
   private static String guestProgramPath;
   private static String localOutputFilePath;
   private static VirtualMachinePowerState powerState;
   private static Map<String, String> optionsmap =
         new HashMap<String, String>();
   private static boolean connected = false;
   private static String tempFilePath = null;
   private static ManagedObjectReference vmMOR = null;
   private static ManagedObjectReference fileManagerRef = null;
   private static ManagedObjectReference processManagerRef = null;
   private static NamePasswordAuthentication auth = null;

   private static void getInputArguments(List<String> args) throws Exception {
      int len = args.size();
      int i = 0;

      if (len == 0) {
         printUsage();
         throw new IllegalArgumentException("Invalid Input");
      }
      while (i < len) {
         String val = "";
         String opt = args.get(i);

         if (opt.startsWith("--")) {
            if (optionsmap.containsKey(opt.substring(2))) {
               String msg = "Duplicate key : " + opt.substring(2);
               printUsage();
               throw new IllegalArgumentException(msg);
            }
            if (args.size() > i + 1) {
               if (!args.get(i + 1).startsWith("--")) {
                  val = args.get(i + 1);
                  optionsmap.put(opt.substring(2), val);
               } else {
                  optionsmap.put(opt.substring(2), null);
               }
            } else {
               optionsmap.put(opt.substring(2), null);
            }
         }
         i++;
      }
   }

   /**
    * Set the managed object reference type, and value to ServiceInstance.
    */
   private static void initSvcInstRef() {
      SVC_INST_REF.setType(SVC_INST_NAME);
      SVC_INST_REF.setValue(SVC_INST_NAME);
   }

   /**
    * 
    * @param url
    *           The URL of the vCenter Server
    * 
    *           https://<Server IP / host name>/sdk
    * 
    *           The method establishes a connection with the web service port on
    *           the server. This is not to be confused with the session
    *           connection.
    * 
    */
   private static void initVimPort(String url) throws Exception {
      vimService = new VimService();
      vimPort = vimService.getVimPort();
      Map<String, Object> ctxt =
            ((BindingProvider) vimPort).getRequestContext();
      ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
      ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
   }

   /*
    * This method calls all the initialization methods required in order.
    */
   private static void initAll() throws Exception {
      // These following methods have to be called in this order.
      initSvcInstRef();
      initVimPort(vimHost);
      initServiceContent();
      connect(vimHost, userName, password);
      initPropertyCollector();
      initRootFolder();
      connected = true;
   }

   private static void initServiceContent() throws Exception {
      if (serviceContent == null) {
         serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF);
         if (serviceContent == null) {
            throw new Exception("Could not get Service Content");
         }
      }
   }

   private static void initPropertyCollector() throws Exception {
      if (propCollector == null) {
         propCollector = serviceContent.getPropertyCollector();
         if (propCollector == null) {
            throw new Exception("Could not get Property Collector");
         }
      }
   }

   private static void initRootFolder() throws Exception {
      if (rootRef == null) {
         rootRef = serviceContent.getRootFolder();
         if (rootRef == null) {
            throw new Exception("Could not get Root Folder");
         }
      }
   }

   /**
    * 
    * @param url
    *           The URL of the server
    * @param uname
    *           The user name for the session
    * @param pword
    *           The password for the user
    * 
    *           Establishes a session with the virtual center server
    * 
    * @throws Exception
    */
   private static void connect(String url, String uname, String pword)
         throws Exception {
      vimPort.login(serviceContent.getSessionManager(), uname, pword, null);
   }

   /**
    * Disconnects the user session.
    * 
    * @throws Exception
    */
   private static void disconnect() throws Exception {
      vimPort.logout(serviceContent.getSessionManager());
   }

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

   private static void printUsage() {
      System.out
            .println("This sample runs a specified program inside a virtual machine, "
                  + "with output re-directed to a temporary file inside the guest and "
                  + "downloads the output file.");
      System.out.println("To run this sample following parameters are used:");
      System.out
            .println("vmname              [required]:Name of the virtual machine");
      System.out
            .println("guestusername       [required]:Username in the Guest OS");
      System.out
            .println("guestpassword       [required]:Password in the Guest OS");
      System.out
            .println("guestprogrampath    [required]: Fully qualified path of the program in the Guest OS");
      System.out
            .println("localoutputfilepath [required]:Path to the local file to store the output");
      System.out
            .println("interactivesession  [optional]:Run the program within an interactive session in the Guest OS");
      System.out
            .println("<b>Command Line:To run a program and download the output</b>");
      System.out.println("run.bat com.vmware.guest.RunProgram "
            + "--url [webserviceurl]");
      System.out.println("--username [username] --password  [password] "
            + "--vmname [vmname]");
      System.out
            .println("--guestusername [guest user] --guestpassword [guest password]");
      System.out
            .println("--guestprogrampath [Path of the program in the guest]");
      System.out
            .println("--localoutputfilepath [Path to the local file to store the output]");
      System.out.println("[--interactivesession]");
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

   private static void getData(String urlString, String fileName)
         throws Exception {
      HttpURLConnection conn = null;
      URL urlSt = new URL(urlString);
      conn = (HttpURLConnection) urlSt.openConnection();
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setRequestProperty("Content-Type", "application/octet-stream");
      conn.setRequestMethod("GET");
      InputStream in = conn.getInputStream();
      OutputStream out = new FileOutputStream(fileName);
      byte[] buf = new byte[102400];
      int len = 0;
      while ((len = in.read(buf)) > 0) {
         out.write(buf, 0, len);
      }
      in.close();
      out.close();

      int returnErrorCode = conn.getResponseCode();
      conn.disconnect();
      if (HttpsURLConnection.HTTP_OK != returnErrorCode) {
         throw new Exception("File Download is unsuccessful");
      }
   }

   private static boolean verifyInputArguments() throws Exception {
      List<String> vinput = new ArrayList<String>();
      vinput.add(vimHost);
      vinput.add(userName);
      vinput.add(password);
      vinput.add(guestUserName);
      vinput.add(guestPassword);
      vinput.add(virtualMachineName);
      vinput.add(guestProgramPath);
      vinput.add(localOutputFilePath);
      for (String s : vinput) {
         if (s == null) {
            return false;
         }
      }
      return true;
   }

   private static Object[] waitForValues(ManagedObjectReference objmor,
         String[] filterProps, String[] endWaitProps, Object[][] expectedVals)
         throws RemoteException, Exception {
      // version string is initially null
      String version = "";
      Object[] endVals = new Object[endWaitProps.length];
      Object[] filterVals = new Object[filterProps.length];

      PropertyFilterSpec spec = new PropertyFilterSpec();

      spec.getObjectSet().add(new ObjectSpec());

      spec.getObjectSet().get(0).setObj(objmor);

      spec.getPropSet().addAll(
            Arrays.asList(new PropertySpec[] { new PropertySpec() }));

      spec.getPropSet().get(0).getPathSet().addAll(Arrays.asList(filterProps));

      spec.getPropSet().get(0).setType(objmor.getType());

      spec.getObjectSet().get(0).setSkip(Boolean.FALSE);

      ManagedObjectReference filterSpecRef =
            vimPort.createFilter(propCollector, spec, true);

      boolean reached = false;

      UpdateSet updateset = null;
      PropertyFilterUpdate[] filtupary = null;
      PropertyFilterUpdate filtup = null;
      ObjectUpdate[] objupary = null;
      ObjectUpdate objup = null;
      PropertyChange[] propchgary = null;
      PropertyChange propchg = null;
      while (!reached) {
         boolean retry = true;
         while (retry) {
            try {
               updateset = vimPort.waitForUpdates(propCollector, version);
               retry = false;
            } catch (SOAPFaultException sfe) {
               printSoapFaultException(sfe);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         version = updateset.getVersion();
         if (updateset == null || updateset.getFilterSet() == null) {
            continue;
         }
         List<PropertyFilterUpdate> listprfup = updateset.getFilterSet();
         filtupary =
               listprfup.toArray(new PropertyFilterUpdate[listprfup.size()]);
         filtup = null;
         for (int fi = 0; fi < filtupary.length; fi++) {
            filtup = filtupary[fi];
            List<ObjectUpdate> listobjup = filtup.getObjectSet();
            objupary = listobjup.toArray(new ObjectUpdate[listobjup.size()]);
            objup = null;
            propchgary = null;
            for (int oi = 0; oi < objupary.length; oi++) {
               objup = objupary[oi];
               if (objup.getKind() == ObjectUpdateKind.MODIFY
                     || objup.getKind() == ObjectUpdateKind.ENTER
                     || objup.getKind() == ObjectUpdateKind.LEAVE) {
                  List<PropertyChange> listchset = objup.getChangeSet();
                  propchgary =
                        listchset.toArray(new PropertyChange[listchset.size()]);
                  for (int ci = 0; ci < propchgary.length; ci++) {
                     propchg = propchgary[ci];
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

   public static void main(String[] args) {
      try {
         getInputArguments(Arrays.asList(args));
         if (optionsmap.containsKey("help")) {
            printUsage();
            return;
         }
         vimHost = optionsmap.get("url");
         userName = optionsmap.get("username");
         password = optionsmap.get("password");
         guestUserName = optionsmap.get("guestusername");
         guestPassword = optionsmap.get("guestpassword");
         virtualMachineName = optionsmap.get("vmname");
         guestProgramPath = optionsmap.get("guestprogrampath");
         localOutputFilePath = optionsmap.get("localoutputfilepath");

         if (!verifyInputArguments()) {
            printUsage();
            return;
         }

         try {
            HostnameVerifier hv = new HostnameVerifier() {
               @Override
               public boolean verify(String urlHostName, SSLSession session) {
                  return true;
               }
            };
            trustAllHttpsCertificates();
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
         } catch (Exception e) {
            e.printStackTrace();
         }
         initAll();
         Map<String, ManagedObjectReference> vms =
               getMOREFsInFolderByType(serviceContent.getRootFolder(),
                     "VirtualMachine");
         vmMOR = vms.get(virtualMachineName);
         if (vmMOR != null) {
            System.out.println("Virtual Machine " + virtualMachineName
                  + " found");
            powerState =
                  (VirtualMachinePowerState) getEntityProps(vmMOR,
                        new String[] { "runtime.powerState" }).get(
                        "runtime.powerState");
            if (!powerState.equals(VirtualMachinePowerState.POWERED_ON)) {
               System.out.println("VirtualMachine: " + virtualMachineName
                     + " needs to be powered on");
               return;
            }
         } else {
            System.out.println("Virtual Machine " + virtualMachineName
                  + " not found.");
            return;
         }

         boolean useInteractiveSession =
               optionsmap.containsKey("interactivesession");
         String[] opts;
         String[] opt;
         if (useInteractiveSession) {
            opts = new String[] { "guest.interactiveGuestOperationsReady" };
            opt = new String[] { "guest.interactiveGuestOperationsReady" };
         } else {
            opts = new String[] { "guest.guestOperationsReady" };
            opt = new String[] { "guest.guestOperationsReady" };
         }
         waitForValues(vmMOR, opts, opt,
               new Object[][] { new Object[] { true } });

         System.out.println("Guest Operations are ready for the VM");
         ManagedObjectReference guestOpManger =
               serviceContent.getGuestOperationsManager();
         Map<String, Object> guestOpMgr =
               getEntityProps(guestOpManger, new String[] { "processManager",
                     "fileManager" });
         fileManagerRef =
               (ManagedObjectReference) guestOpMgr.get("fileManager");
         processManagerRef =
               (ManagedObjectReference) guestOpMgr.get("processManager");
         auth = new NamePasswordAuthentication();
         auth.setUsername(optionsmap.get("guestusername"));
         auth.setPassword(optionsmap.get("guestpassword"));
         auth.setInteractiveSession(useInteractiveSession);

         System.out.println("Executing CreateTemporaryFile guest operation");
         tempFilePath =
               vimPort.createTemporaryFileInGuest(fileManagerRef, vmMOR, auth,
                     "", "", "");
         System.out.println("Successfully created a temporary file at: "
               + tempFilePath + " inside the guest");

         GuestProgramSpec spec = new GuestProgramSpec();
         spec.setProgramPath(guestProgramPath);
         spec.setArguments("> " + tempFilePath + " 2>&1");
         System.out.println("Starting the specified program inside the guest");
         long pid =
               vimPort
                     .startProgramInGuest(processManagerRef, vmMOR, auth, spec);
         System.out
               .println("Process ID of the program started is: " + pid + "");

         List<Long> pidsList = new ArrayList<Long>();
         pidsList.add(pid);
         List<GuestProcessInfo> procInfo = null;
         do {
            System.out.println("Waiting for the process to finish running.");
            procInfo =
                  vimPort.listProcessesInGuest(processManagerRef, vmMOR, auth,
                        pidsList);
            Thread.sleep(5 * 1000);
         } while (procInfo.get(0).getEndTime() == null);

         System.out.println("Exit code of the program is "
               + procInfo.get(0).getExitCode());

         FileTransferInformation fileTransferInformation = null;
         fileTransferInformation =
               vimPort.initiateFileTransferFromGuest(fileManagerRef, vmMOR,
                     auth, tempFilePath);
         URL tempUrlObject = new URL(vimHost);
         String fileDownloadUrl =
               fileTransferInformation.getUrl().replaceAll("\\*",
                     tempUrlObject.getHost());
         System.out.println("Downloading the output file from :"
               + fileDownloadUrl);
         getData(fileDownloadUrl, localOutputFilePath);
         System.out.println("Successfully downloaded the file");
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception ex) {
         System.out.println(ex.getMessage());
         ex.printStackTrace();
      } finally {
         try {
            if (!optionsmap.containsKey("help") && connected) {
               if (tempFilePath != null) {
                  vimPort.deleteFileInGuest(fileManagerRef, vmMOR, auth,
                        tempFilePath);
               }
               disconnect();
            }
         } catch (SOAPFaultException sfe) {
            printSoapFaultException(sfe);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }
}
