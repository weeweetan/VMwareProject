package com.vmware.vapp;

import java.io.File;
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

import org.w3c.dom.Element;

import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.HttpNfcLeaseDeviceUrl;
import com.vmware.vim25.HttpNfcLeaseInfo;
import com.vmware.vim25.HttpNfcLeaseState;
import com.vmware.vim25.InvalidPropertyFaultMsg;
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
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * OVFManagerExportVMDK
 * 
 * This is a demonstrates OVFManager.Exports VMDK's of a VM to the localSystem.
 * 
 * <b>Parameters:</b>
 * url              [required] : url of the web service.
 * username         [required] : username for the authentication
 * password         [required] : password for the authentication
 * vmname           [required] : Name of the virtual machine
 * host             [required] : Name of Host System
 * localPath        [required] : Absolute path of localSystem folder
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.vapp.OVFManagerExportVMDK
 * --url [webserviceurl] --username [username] --password [password]--vmname [VM name]
 * --host [Name of Host]
 * </pre>
 */

public class OVFManagerExportVMDK {

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

   private static String url;
   private static String userName;
   private static String password;
   private static Boolean help = false;
   private static final ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();
   private static final String SVC_INST_NAME = "ServiceInstance";
   private static VimPortType vimPort;
   private static VimService vimService;
   private static ServiceContent serviceContent;
   private static Boolean isConnected = false;
   private static volatile long TOTAL_BYTES = 0;
   private static HttpNfcLeaseExtender leaseExtender;
   private static volatile long TOTAL_BYTES_WRITTEN = 0;
   private static boolean vmdkFlag = false;

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
            vmname = val;
         }
         if (param.equalsIgnoreCase("--host") && !val.startsWith("--")
               && !val.isEmpty()) {
            host = val;
         }
         if (param.equalsIgnoreCase("--localPath") && !val.startsWith("--")
               && !val.isEmpty()) {
            localPath = val;
         }
         val = "";
         ai += 2;
      }
      if (vmname == null || host == null || localPath == null) {
         throw new IllegalArgumentException(
               "Expected --vmname, --host, --localPath arguments properly");
      }
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
   }

   private static void disconnect() throws Exception {
      if (isConnected) {
         vimPort.logout(serviceContent.getSessionManager());
      }
      isConnected = false;
   }

   private static String host = null;
   private static String vmname = null;
   private static String localPath = null;

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
    * Wait for values.
    * 
    * @param objmor
    *           the object mor
    * @param filterProps
    *           the filter props
    * @param endWaitProps
    *           the end wait props
    * @param expectedVals
    *           the expected vals
    * @return the object[]
    * @throws RemoteException
    *            the remote exception
    * @throws Exception
    *            the exception
    */
   private static Object[] waitForValues(ManagedObjectReference objmor,
         String[] filterProps, String[] endWaitProps, Object[][] expectedVals)
         throws RemoteException, Exception {
      // version string is initially null
      String version = "";
      Object[] endVals = new Object[endWaitProps.length];
      Object[] filterVals = new Object[filterProps.length];
      String stateVal = null;
      PropertyFilterSpec spec = new PropertyFilterSpec();
      spec.getObjectSet().add(new ObjectSpec());
      spec.getObjectSet().get(0).setObj(objmor);
      spec.getPropSet().addAll(
            Arrays.asList(new PropertySpec[] { new PropertySpec() }));
      spec.getPropSet().get(0).getPathSet().addAll(Arrays.asList(filterProps));
      spec.getPropSet().get(0).setType(objmor.getType());
      spec.getObjectSet().get(0).setSkip(Boolean.FALSE);
      ManagedObjectReference filterSpecRef =
            vimPort.createFilter(serviceContent.getPropertyCollector(), spec,
                  true);
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
               updateset =
                     vimPort.waitForUpdates(
                           serviceContent.getPropertyCollector(), version);
               retry = false;
            } catch (SOAPFaultException sfe) {
               printSoapFaultException(sfe);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if (updateset != null) {
            version = updateset.getVersion();
         }
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
         // Check if the expected values have been reached and exit the loop if done.
         // Also exit the WaitForUpdates loop if this is the case.
         for (int chgi = 0; chgi < endVals.length && !reached; chgi++) {
            for (int vali = 0; vali < expectedVals[chgi].length && !reached; vali++) {
               expctdval = expectedVals[chgi][vali];
               if (endVals[chgi] == null) {
                  // Do Nothing
               } else if (endVals[chgi].toString().contains("val: null")) {
                  // Due to some issue in JAX-WS De-serialization getting the information from the nodes
                  Element stateElement = (Element) endVals[chgi];
                  if (stateElement != null
                        && stateElement.getFirstChild() != null) {
                     stateVal = stateElement.getFirstChild().getTextContent();
                     reached =
                           expctdval.toString().equalsIgnoreCase(stateVal)
                                 || reached;
                  }
               } else {
                  expctdval = expectedVals[chgi][vali];
                  reached = expctdval.equals(endVals[chgi]) || reached;
                  stateVal = "filtervals";
               }
            }
         }
      }
      Object[] retVal = null;
      // Destroy the filter when we are done.
      vimPort.destroyPropertyFilter(filterSpecRef);
      if (stateVal != null) {
         if (stateVal.equalsIgnoreCase("ready")) {
            retVal = new Object[] { HttpNfcLeaseState.READY };
         }
         if (stateVal.equalsIgnoreCase("error")) {
            retVal = new Object[] { HttpNfcLeaseState.ERROR };
         }
         if (stateVal.equals("filtervals")) {
            retVal = filterVals;
         }
      } else {
         retVal = new Object[] { HttpNfcLeaseState.ERROR };
      }
      return retVal;
   }

   /**
    * Update values.
    * 
    * @param props
    *           the properties
    * @param vals
    *           the values
    * @param propchg
    *           the property change
    */
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

   private static void exportVM() throws Exception {
      File file = new File(localPath);
      if (!file.exists()) {
         System.out.println("Wrong or invalid path " + localPath);
         return;
      }
      ManagedObjectReference srcMOR =
            getMOREFsInFolderByType(serviceContent.getRootFolder(),
                  "HostSystem").get(host);
      if (srcMOR == null) {
         throw new RuntimeException(" Source Host " + host + " Not Found.");
      }
      ManagedObjectReference vmMoRef =
            getMOREFsInFolderByType(srcMOR, "VirtualMachine").get(vmname);

      if (vmMoRef == null) {
         throw new RuntimeException("Virtual Machine " + vmname + " Not Found.");
      }
      System.out.println("Getting the HTTP NFCLEASE for the VM: " + vmname);
      try {
         ManagedObjectReference httpNfcLease = vimPort.exportVm(vmMoRef);

         Object[] result =
               waitForValues(httpNfcLease, new String[] { "state" },
                     new String[] { "state" }, new Object[][] { new Object[] {
                           HttpNfcLeaseState.READY, HttpNfcLeaseState.ERROR } });
         if (result[0].equals(HttpNfcLeaseState.READY)) {
            System.out.println("HttpNfcLeaseState: " + result[0]);
            HttpNfcLeaseInfo httpNfcLeaseInfo =
                  (HttpNfcLeaseInfo) getEntityProps(httpNfcLease,
                        new String[] { "info" }).get("info");
            httpNfcLeaseInfo.setLeaseTimeout(300000000);
            printHttpNfcLeaseInfo(httpNfcLeaseInfo, host);
            long diskCapacity =
                  (httpNfcLeaseInfo.getTotalDiskCapacityInKB()) * 1024;
            TOTAL_BYTES = diskCapacity;
            leaseExtender =
                  new OVFManagerExportVMDK().new HttpNfcLeaseExtender(
                        httpNfcLease, vimPort);
            Thread t = new Thread(leaseExtender);
            t.start();
            List<HttpNfcLeaseDeviceUrl> deviceUrlArr =
                  httpNfcLeaseInfo.getDeviceUrl();
            for (HttpNfcLeaseDeviceUrl deviceUrl : deviceUrlArr) {
               System.out.println("Downloading Files:");
               String deviceUrlStr = deviceUrl.getUrl();
               String absoluteFile =
                     deviceUrlStr.substring(deviceUrlStr.lastIndexOf("/") + 1);
               System.out.println("Absolute File Name: " + absoluteFile);
               System.out.println("VMDK URL: "
                     + deviceUrlStr.replace("*", host));
               writeVMDKFile(absoluteFile, deviceUrlStr.replace("*", host),
                     diskCapacity, vmname);
            }
            System.out.println("Completed Downloading the files");
            vmdkFlag = true;
            t.interrupt();
            vimPort.httpNfcLeaseProgress(httpNfcLease, 100);
            vimPort.httpNfcLeaseComplete(httpNfcLease);
         } else {
            System.out.println("HttpNfcLeaseState not ready");
            for (Object o : result) {
               System.out.println("HttpNfcLeaseState: " + o);
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static void printHttpNfcLeaseInfo(HttpNfcLeaseInfo info,
         String hostName) {
      System.out
            .println("########################################################");
      System.out.println("HttpNfcLeaseInfo");
      System.out.println("Lease Timeout: " + info.getLeaseTimeout());
      System.out.println("Total Disk capacity: "
            + info.getTotalDiskCapacityInKB());
      List<HttpNfcLeaseDeviceUrl> deviceUrlArr = info.getDeviceUrl();
      int deviceUrlCount = 1;
      for (HttpNfcLeaseDeviceUrl durl : deviceUrlArr) {
         System.out.println("HttpNfcLeaseDeviceUrl : " + deviceUrlCount++);
         System.out.println("   Device URL Import Key: " + durl.getImportKey());
         System.out.println("   Device URL Key: " + durl.getKey());
         System.out.println("   Device URL : " + durl.getUrl());
         System.out.println("   Updated device URL: "
               + durl.getUrl().replace("*", hostName));
         System.out.println("   SSL Thumbprint : " + durl.getSslThumbprint());
      }
      System.out
            .println("########################################################");
   }

   /**
    * The Class HttpNfcLeaseExtender.
    */
   public class HttpNfcLeaseExtender implements Runnable {
      private ManagedObjectReference httpNfcLease = null;
      private VimPortType vimPort = null;

      public HttpNfcLeaseExtender(ManagedObjectReference mor,
            VimPortType VIM_PORT) {
         httpNfcLease = mor;
         vimPort = VIM_PORT;
      }

      @Override
      public void run() {
         try {
            System.out.println("---------------------- Thread for "
                  + "Checking the HTTP NFCLEASE vmdkFlag: " + vmdkFlag
                  + "----------------------");
            while (!vmdkFlag) {
               System.out.println("#### TOTAL_BYTES_WRITTEN "
                     + TOTAL_BYTES_WRITTEN);
               System.out.println("#### TOTAL_BYTES " + TOTAL_BYTES);
               try {
                  vimPort.httpNfcLeaseProgress(httpNfcLease, 0);
                  Thread.sleep(290000000);
               } catch (InterruptedException e) {
                  System.out
                        .println("---------------------- Thread interrupted "
                              + "----------------------");
               } catch (SOAPFaultException sfe) {
                  printSoapFaultException(sfe);
               }
            }
         } catch (SOAPFaultException sfe) {
            printSoapFaultException(sfe);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private static void writeVMDKFile(String absoluteFile, String string,
         long diskCapacity, String vmName) throws Exception {
      HttpURLConnection conn = getHTTPConnection(string);
      InputStream in = conn.getInputStream();
      String fileName = localPath + "/" + vmName + "-" + absoluteFile;
      OutputStream out = new FileOutputStream(new File(fileName));
      byte[] buf = new byte[102400];
      int len = 0;
      long written = 0;
      while ((len = in.read(buf)) > 0) {
         out.write(buf, 0, len);
         written = written + len;
      }
      System.out.println("Exported File " + vmName + "-" + absoluteFile + " : "
            + written);
      in.close();
      out.close();
   }

   private static HttpURLConnection getHTTPConnection(String urlString)
         throws Exception {
      trustAllHttpsCertificates();
      HostnameVerifier hv = new HostnameVerifier() {
         @Override
         public boolean verify(String urlHostName, SSLSession session) {
            return true;
         }
      };
      HttpsURLConnection.setDefaultHostnameVerifier(hv);
      URL urlStr = new URL(urlString);
      HttpURLConnection conn = (HttpURLConnection) urlStr.openConnection();

      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setAllowUserInteraction(true);
      conn.connect();
      return conn;
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
            .println("This is a demostrates OVFManager.Exports VMDK's of a VM to the localSystem.");
      System.out
            .println("url              [required] : url of the web service.");
      System.out
            .println("username         [required] : username for the authentication");
      System.out
            .println("password         [required] : password for the authentication");
      System.out
            .println("vmname           [required] : Name of the virtual machine");
      System.out.println("host             [required] : Name of Host System");
      System.out
            .println("localPath        [required] : Absolute path of localSystem folder");
      System.out.println("run.bat com.vmware.vapp.OVFManagerExportVMDK");
      System.out
            .println("--url [webserviceurl] --username [username] --password [password]"
                  + "--vmname [VM name] --host [Name of Host] --localPath [path of local System]");
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
         exportVM();

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
