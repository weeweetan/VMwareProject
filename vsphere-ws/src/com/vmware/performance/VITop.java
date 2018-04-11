package com.vmware.performance;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.performance.widgets.StatsTable;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PerfCompositeMetric;
import com.vmware.vim25.PerfCounterInfo;
import com.vmware.vim25.PerfEntityMetric;
import com.vmware.vim25.PerfEntityMetricBase;
import com.vmware.vim25.PerfMetricId;
import com.vmware.vim25.PerfMetricIntSeries;
import com.vmware.vim25.PerfProviderSummary;
import com.vmware.vim25.PerfQuerySpec;
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
 * VITop
 * 
 * This sample is an ESX-Top-like application that lets administrators specify
 * the CPU and memory counters by name to obtain metrics for a specified host
 * 
 * <b>Parameters:</b>
 * url        [required] : url of the web service
 * username   [required] : username for the authentication
 * password   [required] : password for the authentication
 * host       [required] : name of the host
 * cpu        [required] : CPU counter name
 *                         e.g. usage, ready, guaranteed
 * memory     [required] : memory counter name
 *                         e.g. usage, granted
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.performance.VITop
 * --url [webservice url] --username [user] --password [password]
 * --host [FQDN_host_name]
 * --cpu [cpu_counter_name] --memory [mem_counter_name]
 * </pre>
 */
public class VITop {

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

   private static ManagedObjectReference propCollectorRef;
   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;

   private static String url;
   private static String userName;
   private static String password;
   private static boolean help = false;
   private static String cpu;
   private static String memory;
   private static StatsTable statsTable;
   private static String hostname;
   private static ManagedObjectReference perfManager;
   private static PerfQuerySpec querySpec;
   private static Boolean isConnected = false;

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
         if (param.equalsIgnoreCase("--cpu") && !val.startsWith("--")
               && !val.isEmpty()) {
            cpu = val;
         } else if (param.equalsIgnoreCase("--host") && !val.startsWith("--")
               && !val.isEmpty()) {
            hostname = val;
         } else if (param.equalsIgnoreCase("--memory") && !val.startsWith("--")
               && !val.isEmpty()) {
            memory = val;
         }
         val = "";
         ai += 2;
      }
      if (hostname == null || cpu == null || memory == null) {
         throw new IllegalArgumentException(
               "Expected --host, --cpu and --memory arguments.");
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
      perfManager = serviceContent.getPerfManager();
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

   private static void createAndShowGUI(String firstColumnName,
         List<String> statNames) {
      try {
         String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
         UIManager.setLookAndFeel(lookAndFeel);
         JFrame.setDefaultLookAndFeelDecorated(true);
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }

      JFrame frame = new JFrame("VITop");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.addWindowListener(new WindowListener() {
         @Override
         public void windowOpened(WindowEvent e) {
         }

         @Override
         public void windowIconified(WindowEvent e) {
         }

         @Override
         public void windowDeiconified(WindowEvent e) {
         }

         @Override
         public void windowDeactivated(WindowEvent e) {
         }

         @Override
         public void windowClosing(WindowEvent e) {
            try {
               disconnect();
            } catch (SOAPFaultException sfe) {
               printSoapFaultException(sfe);
            } catch (Exception ex) {
               System.out.println("Failed to disconnect - " + ex.getMessage());
               ex.printStackTrace();
            }
         }

         @Override
         public void windowClosed(WindowEvent e) {
         }

         @Override
         public void windowActivated(WindowEvent e) {
         }
      });

      String[] columnNamesArray = new String[statNames.size() + 1];
      columnNamesArray[0] = firstColumnName;
      for (int i = 0; i < statNames.size(); i++) {
         columnNamesArray[i + 1] = statNames.get(i);
      }
      statsTable = new StatsTable(columnNamesArray);
      statsTable.setOpaque(true);
      frame.setContentPane(statsTable);

      frame.pack();
      frame.setVisible(true);
   }

   private static String getEntityName(ManagedObjectReference moRef)
         throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
      String ret = null;
      try {
         ret = (String) getDynamicProperty(moRef, "name");
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         return "<Unknown Entity>";
      }

      if (ret != null) {
         return ret;
      } else {
         return "<Unknown Entity>";
      }
   }

   /**
    * 
    * @param midList
    * @param compMetric
    * @return
    * @throws RuntimeException
    * @throws RemoteException
    * @throws InvalidPropertyFaultMsg
    * @throws RuntimeFaultFaultMsg
    */
   private static XMLGregorianCalendar displayStats(List<PerfMetricId> midList,
         PerfCompositeMetric compMetric) throws RuntimeException,
         RemoteException, InvalidPropertyFaultMsg, RuntimeFaultFaultMsg {
      if (compMetric == null || (compMetric.getEntity() == null)) {
         return null;
      }

      List<Object[]> data = new ArrayList<Object[]>();
      PerfEntityMetric entityMetric = (PerfEntityMetric) compMetric.getEntity();
      PerfMetricIntSeries intSeries =
            (PerfMetricIntSeries) entityMetric.getValue().get(0);
      int numSamples = entityMetric.getSampleInfo().size();

      XMLGregorianCalendar timeStamp =
            entityMetric.getSampleInfo().get(numSamples - 1).getTimestamp();
      long overallUsage = intSeries.getValue().get(numSamples - 1);
      System.out.println("Info Updated");
      int numColumns = midList.size() + 1;
      List<PerfEntityMetricBase> listpemb = compMetric.getChildEntity();
      List<PerfEntityMetricBase> childEntityMetric = listpemb;
      for (int childNum = 0; childNum < childEntityMetric.size(); childNum++) {
         PerfEntityMetric childStats =
               (PerfEntityMetric) childEntityMetric.get(childNum);
         String childName = getEntityName(childStats.getEntity());
         int numChildSamples = childStats.getSampleInfo().size();
         Object[] tableData = new Object[numColumns];
         tableData[0] = childName;

         for (int i = 0; i < childStats.getValue().size(); i++) {
            PerfMetricIntSeries childSeries =
                  (PerfMetricIntSeries) childStats.getValue().get(i);
            int col = findStatsIndex(midList, childSeries.getId());
            if (col >= 0) {
               long statsVal = childSeries.getValue().get(numChildSamples - 1);
               tableData[col + 1] = new Long(statsVal);
            }
         }
         data.add(tableData);
      }

      if (statsTable != null) {
         statsTable.setData(timeStamp.toGregorianCalendar(), overallUsage,
               "Mhz", data);
      }
      return timeStamp;
   }

   private static int findStatsIndex(List<PerfMetricId> midList,
         PerfMetricId mid) {
      int count = 0;
      for (PerfMetricId pmid : midList) {
         if ((pmid.getCounterId() == mid.getCounterId())
               && pmid.getInstance().equals(mid.getInstance())) {
            return count;
         }
         ++count;
      }
      return -1;
   }

   private static PerfCounterInfo getCounterInfo(
         List<PerfCounterInfo> counterInfo, String groupName, String counterName) {
      for (PerfCounterInfo info : counterInfo) {
         if (info.getGroupInfo().getKey().equals(groupName)
               && info.getNameInfo().getKey().equals(counterName)) {
            return info;
         }
      }
      return null;
   }

   /**
    * 
    * @return
    * @throws Exception
    */
   private static String[][] getCounters() throws Exception {

      String[] cpuCounters = cpu.split(",");
      String[] memCounters = memory.split(",");
      String[][] ret = new String[(cpuCounters.length + memCounters.length)][2];

      for (int i = 0; i < cpuCounters.length; i++) {
         ret[i] = new String[] { "cpu", cpuCounters[i] };
      }

      for (int i = 0; i < memCounters.length; i++) {
         ret[(cpuCounters.length + i)] = new String[] { "mem", memCounters[i] };
      }
      return ret;
   }

   /**
    *
    */
   private static void refreshStats() {
      try {
         PerfCompositeMetric metric =
               vimPort.queryPerfComposite(perfManager, querySpec);
         XMLGregorianCalendar latestTs =
               displayStats(querySpec.getMetricId(), metric);
         if (latestTs != null) {
            querySpec.setStartTime(latestTs);
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
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

   /**
    * 
    * @throws Exception
    */
   private static void displayStats() throws Exception {
      String[][] statsList = getCounters();
      ManagedObjectReference hostmor = getHostByHostName(hostname);
      if (hostmor == null) {
         System.out.println("Host Not Found");
         return;
      }

      @SuppressWarnings("unchecked")
      List<PerfCounterInfo> props =
            (List<PerfCounterInfo>) getDynamicProperty(perfManager,
                  "perfCounter");

      List<PerfMetricId> midVector = new ArrayList<PerfMetricId>();
      List<String> statNames = new ArrayList<String>();
      for (int i = 0; i < statsList.length; i++) {
         PerfCounterInfo counterInfo =
               getCounterInfo(props, statsList[i][0], statsList[i][1]);
         if (counterInfo == null) {
            System.out.println("Warning: Unable to find stat "
                  + statsList[i][0] + " " + statsList[i][1]);
            continue;
         }
         String counterName = counterInfo.getNameInfo().getLabel();
         statNames.add(counterName);

         PerfMetricId pmid = new PerfMetricId();
         pmid.setCounterId(counterInfo.getKey());
         pmid.setInstance("");
         midVector.add(pmid);
      }
      List<PerfMetricId> midList = new ArrayList<PerfMetricId>(midVector);
      Collections.copy(midList, midVector);


      PerfProviderSummary perfProviderSummary =
            vimPort.queryPerfProviderSummary(perfManager, hostmor);
      PerfQuerySpec spec = new PerfQuerySpec();
      spec.setEntity(hostmor);
      spec.getMetricId().addAll(midList);
      spec.setIntervalId(perfProviderSummary.getRefreshRate());
      querySpec = spec;

      final List<String> statNames2 = statNames;
      javax.swing.SwingUtilities.invokeLater(new Runnable() {

         @Override
         public void run() {
            createAndShowGUI("VM Name", statNames2);
         }
      });

      Timer timer = new Timer(true);
      timer.schedule(new TimerTask() {

         @Override
         public void run() {
            refreshStats();
         }
      }, 1000, 21000);
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
      System.out.println("This sample is an ESX-Top-like "
            + "application that lets administrators specify");
      System.out.println("the CPU and memory counters by name "
            + "to obtain metrics for a specified host.");
      System.out.println("\nParameters:");
      System.out.println("url        [required] : url of the web service");
      System.out
            .println("username   [required] : username for the authentication");
      System.out
            .println("password   [required] : password for the authentication");
      System.out.println("host       [required] : name of the host");
      System.out.println("cpu        [required] : CPU counter name");
      System.out
            .println("                        e.g. usage, ready, guaranteed");
      System.out.println("memory     [required] : memory counter name");
      System.out.println("                        e.g. usage, granted");
      System.out.println("\nCommand:");
      System.out.println("run.bat com.vmware.performance.VITop "
            + "--url [webservice url] --username [user] --password [password]");
      System.out.println("--host [FQDN_host_name] "
            + "--cpu [cpu_counter_name] --memory [mem_counter_name] ");
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
         displayStats();
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
         printUsage();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
