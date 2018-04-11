package com.vmware.vapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.rmi.RemoteException;
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
import com.vmware.vim25.OvfCreateDescriptorParams;
import com.vmware.vim25.OvfCreateDescriptorResult;
import com.vmware.vim25.OvfFile;
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
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * OVFManagerExportVAPP
 * 
 * This sample demonstrates OVFManager.
 * Exports VMDK's and OVF Descriptor of all VM's in the vApps
 * 
 * <b>Parameters:</b>
 * username         [required]: username for the authentication
 * password         [required]: password for the authentication
 * host             [required]: Name of the host system
 * vapp             [required]: Name of the vapp
 * localpath        [required]: local System Folder path
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.httpfileaccess.OVFManagerExportVAPP
 * --url [URLString] --username [username] --password [password]
 * --host [Host name] --vapp [Vapp Name] --localpath [Local Path]
 * </pre>
 */

public class OVFManagerExportVAPP {

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
   private static final String SVC_INST_NAME = "ServiceInstance";
   private static final ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();
   private static ServiceContent serviceContent = null;
   private static VimService vimService = null;
   private static VimPortType vimPort = null;

   private static Map<String, List<String>> headers =
         new HashMap<String, List<String>>();
   private static String cookieValue = "";

   private static volatile long TOTAL_BYTES = 0;
   private static volatile long TOTAL_BYTES_WRITTEN = 0;
   private static HttpNfcLeaseExtender leaseExtender;
   private static boolean vmdkFlag = false;

   private static ManagedObjectReference propCollectorRef = null;

   /*
   Connection input parameters
    */
   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
   private static String host = null;
   private static String vApp = null;
   private static String localpath = null;
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
         if (param.equalsIgnoreCase("--host") && !val.startsWith("--")
               && !val.isEmpty()) {
            host = val;
         } else if (param.equalsIgnoreCase("--vapp") && !val.startsWith("--")
               && !val.isEmpty()) {
            vApp = val;
         } else if (param.equalsIgnoreCase("--localpath")
               && !val.startsWith("--") && !val.isEmpty()) {
            localpath = val;
         }
         val = "";
         ai += 2;
      }
      if (host == null || vApp == null || localpath == null) {
         throw new IllegalArgumentException(
               "Expected --host or --vapp arguments or --localpath");
      }
   }

   /**
    * Establishes session with the virtual center server.
    * 
    * @throws Exception
    *            the exception
    */
   @SuppressWarnings("unchecked")
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
            (Map<String, List<String>>) ((BindingProvider) vimPort)
                  .getResponseContext().get(
                        MessageContext.HTTP_RESPONSE_HEADERS);
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
            vimPort.createFilter(propCollectorRef, spec, true);
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
               updateset = vimPort.waitForUpdates(propCollectorRef, version);
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

   /**
    * The Class HttpNfcLeaseExtender.
    */
   private class HttpNfcLeaseExtender implements Runnable {
      private ManagedObjectReference httpNfcLease = null;

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

   private static TraversalSpec getVappTraversalSpec() {
      TraversalSpec dataCenterToVMFolder = new TraversalSpec();
      dataCenterToVMFolder.setName("DataCenterToVMFolder");
      dataCenterToVMFolder.setType("Datacenter");
      dataCenterToVMFolder.setPath("vmFolder");
      dataCenterToVMFolder.setSkip(false);
      SelectionSpec sSpec = new SelectionSpec();
      sSpec.setName("VisitFolders");
      List<SelectionSpec> sSpecs = new ArrayList<SelectionSpec>();
      sSpecs.add(sSpec);
      dataCenterToVMFolder.getSelectSet().addAll(sSpecs);

      TraversalSpec traversalSpec = new TraversalSpec();
      traversalSpec.setName("VisitFolders");
      traversalSpec.setType("Folder");
      traversalSpec.setPath("childEntity");
      traversalSpec.setSkip(false);
      List<SelectionSpec> sSpecArr = new ArrayList<SelectionSpec>();
      sSpecArr.add(sSpec);
      sSpecArr.add(dataCenterToVMFolder);
      traversalSpec.getSelectSet().addAll(sSpecArr);
      return traversalSpec;
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
      return retVal;
   }

   private static ManagedObjectReference getVAPPByName(String vmName) {
      ManagedObjectReference retVal = null;
      try {
         TraversalSpec tSpec = getVappTraversalSpec();
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add(new String("name"));
         propertySpec.setType("VirtualApp");
         List<PropertySpec> propertySpecs = new ArrayList<PropertySpec>();
         propertySpecs.add(propertySpec);

         ObjectSpec objectSpec = new ObjectSpec();
         objectSpec.setObj(serviceContent.getRootFolder());
         objectSpec.setSkip(Boolean.TRUE);
         objectSpec.getSelectSet().add(tSpec);

         List<ObjectSpec> objectSpecs = new ArrayList<ObjectSpec>();
         objectSpecs.add(objectSpec);

         PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
         propertyFilterSpec.getPropSet().addAll(propertySpecs);
         propertyFilterSpec.getObjectSet().addAll(objectSpecs);

         List<PropertyFilterSpec> propertyFilterSpecs =
               new ArrayList<PropertyFilterSpec>();
         propertyFilterSpecs.add(propertyFilterSpec);

         List<ObjectContent> oCont =
               vimPort
                     .retrieveProperties(serviceContent.getPropertyCollector(),
                           propertyFilterSpecs);
         if (oCont != null) {
            boolean flag = false;
            for (ObjectContent oc : oCont) {
               ManagedObjectReference mr = oc.getObj();
               List<DynamicProperty> dps = oc.getPropSet();
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     if (dp.getName().equalsIgnoreCase("name")) {
                        String vmnm = (String) dp.getVal();
                        if (vmnm.equalsIgnoreCase(vmName)) {
                           retVal = mr;
                           flag = true;
                           break;
                        }
                     }
                  }
               }
               if (flag) {
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

   private static void printHttpNfcLeaseInfo(HttpNfcLeaseInfo info,
         String hostString) {
      System.out
            .println("########################################################");
      System.out.println("HttpNfcLeaseInfo");
      System.out.println("Lease Timeout: " + info.getLeaseTimeout());
      System.out.println("Total Disk capacity: "
            + info.getTotalDiskCapacityInKB());
      List<HttpNfcLeaseDeviceUrl> deviceUrlArr = info.getDeviceUrl();
      if (deviceUrlArr != null) {
         int deviceUrlCount = 1;
         for (HttpNfcLeaseDeviceUrl durl : deviceUrlArr) {
            System.out.println("HttpNfcLeaseDeviceUrl : " + deviceUrlCount++);
            System.out.println("   Device URL Import Key: "
                  + durl.getImportKey());
            System.out.println("   Device URL Key: " + durl.getKey());
            System.out.println("   Device URL : " + durl.getUrl());
            System.out.println("   Updated device URL: "
                  + durl.getUrl().replace("*", hostString));
            System.out
                  .println("   SSL Thumbprint : " + durl.getSslThumbprint());
         }
      } else {
         System.out.println("No Device URLS Found");
         System.out
               .println("########################################################");
      }
   }

   private static long writeVMDKFile(String absoluteFile, String urlString)
         throws Exception {
      URL urlCon = new URL(urlString);
      HttpsURLConnection conn = (HttpsURLConnection) urlCon.openConnection();

      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setAllowUserInteraction(true);

      // Maintain session
      List<String> cookies = headers.get("Set-cookie");
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
      conn.setRequestProperty("Expect", "100-continue");
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Content-Length", "1024");

      InputStream in = conn.getInputStream();
      String _localpath = localpath + "/" + absoluteFile;
      OutputStream out = new FileOutputStream(new File(_localpath));
      byte[] buf = new byte[102400];
      int len = 0;
      long written = 0;
      while ((len = in.read(buf)) > 0) {
         out.write(buf, 0, len);
         written = written + len;
      }
      System.out.println("   Exported File " + absoluteFile + " : " + written);
      in.close();
      out.close();
      return written;
   }

   private static void exportVApp() throws Exception {
      try {
         File file = new File(localpath);
         if (!file.exists()) {
            System.out.println("Wrong or invalid path " + localpath);
            return;
         }
         ManagedObjectReference hostRef = getHostByHostName(host);
         if (hostRef == null) {
            System.out.println("Host Not Found");
         } else {
            ManagedObjectReference vAppMoRef = getVAPPByName(vApp);
            if (vAppMoRef != null) {
               OvfCreateDescriptorParams ovfCreateDescriptorParams =
                     new OvfCreateDescriptorParams();
               ManagedObjectReference httpNfcLease =
                     vimPort.exportVApp(vAppMoRef);
               System.out.println("Getting the HTTP NFCLEASE for the vApp: "
                     + vApp);

               Object[] result =
                     waitForValues(httpNfcLease, new String[] { "state" },
                           new String[] { "state" },
                           new Object[][] { new Object[] {
                                 HttpNfcLeaseState.READY,
                                 HttpNfcLeaseState.ERROR } });
               if (result[0].equals(HttpNfcLeaseState.READY)) {

                  HttpNfcLeaseInfo httpNfcLeaseInfo =
                        (HttpNfcLeaseInfo) getEntityProps(httpNfcLease,
                              new String[] { "info" }).get("info");

                  httpNfcLeaseInfo.setLeaseTimeout(300000000);
                  printHttpNfcLeaseInfo(httpNfcLeaseInfo, host);
                  long diskCapacity =
                        (httpNfcLeaseInfo.getTotalDiskCapacityInKB()) * 1024;
                  System.out.println("************ " + diskCapacity);

                  TOTAL_BYTES = diskCapacity;
                  leaseExtender =
                        new OVFManagerExportVAPP().new HttpNfcLeaseExtender(
                              httpNfcLease, vimPort);
                  Thread t = new Thread(leaseExtender);
                  t.start();

                  List<HttpNfcLeaseDeviceUrl> deviceUrlArr =
                        httpNfcLeaseInfo.getDeviceUrl();
                  if (deviceUrlArr != null) {
                     List<OvfFile> ovfFiles = new ArrayList<OvfFile>();
                     for (int i = 0; i < deviceUrlArr.size(); i++) {
                        System.out.println("Downloading Files:");
                        String deviceId = deviceUrlArr.get(i).getKey();
                        String deviceUrlStr = deviceUrlArr.get(i).getUrl();
                        String absoluteFile =
                              deviceUrlStr.substring(deviceUrlStr
                                    .lastIndexOf("/") + 1);
                        System.out.println("   Absolute File Name: "
                              + absoluteFile);
                        System.out.println("   VMDK URL: "
                              + deviceUrlStr.replace("*", host));
                        long writtenSize =
                              writeVMDKFile(absoluteFile,
                                    deviceUrlStr.replace("*", host));
                        OvfFile ovfFile = new OvfFile();
                        ovfFile.setPath(absoluteFile);
                        ovfFile.setDeviceId(deviceId);
                        ovfFile.setSize(writtenSize);
                        ovfFiles.add(ovfFile);
                     }
                     ovfCreateDescriptorParams.getOvfFiles().addAll(ovfFiles);
                     OvfCreateDescriptorResult ovfCreateDescriptorResult =
                           vimPort.createDescriptor(
                                 serviceContent.getOvfManager(), vAppMoRef,
                                 ovfCreateDescriptorParams);
                     System.out.println();
                     String outOVF = localpath + "/" + vApp + ".ovf";
                     File outFile = new File(outOVF);
                     FileWriter out = new FileWriter(outFile);
                     out.write(ovfCreateDescriptorResult.getOvfDescriptor());
                     out.close();
                     System.out.println("OVF Desriptor Written to file " + vApp
                           + ".ovf");
                     System.out.println("DONE");
                     if (!ovfCreateDescriptorResult.getError().isEmpty()) {
                        System.out.println("SOME ERRORS");
                     }
                     if (!ovfCreateDescriptorResult.getWarning().isEmpty()) {
                        System.out.println("SOME WARNINGS");
                     }
                  } else {
                     System.out.println("No Device URLS");
                  }
                  System.out.println("Completed Downloading the files");
                  vmdkFlag = true;
                  t.interrupt();
                  vimPort.httpNfcLeaseProgress(httpNfcLease, 100);
                  vimPort.httpNfcLeaseComplete(httpNfcLease);
               } else {
                  System.out.println("HttpNfcLeaseState not ready");
                  System.out.println("HttpNfcLeaseState: " + result);
               }
            } else {
               System.out.println("vApp Not Found");
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
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
            .println("This sample demonstrates OVFManager. Exports VMDK's and OVF Descriptor of all VM's in the vApps.");
      System.out
            .println("url              [required] : url of the web service.");
      System.out
            .println("username         [required] : username for the authentication");
      System.out
            .println("password         [required] : password for the authentication");
      System.out
            .println("host             [required] : Name of the host system");
      System.out.println("vapp             [required] : Name of the vapp");
      System.out
            .println("localpath        [required] : Local System Folder Path");
      System.out
            .println("run.bat com.vmware.httpfileaccess.OVFManagerExportVAPP");
      System.out
            .println("--url [webserviceurl] --username [username] --password [password]");
      System.out
            .println("--host [Host name] --vapp [Vapp Name] --localpath [Local path]");
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
         OVFManagerExportVAPP.exportVApp();
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
}
