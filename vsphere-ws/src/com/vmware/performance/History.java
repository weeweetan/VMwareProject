package com.vmware.performance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.ArrayOfPerfCounterInfo;
import com.vmware.vim25.ArrayOfPerfInterval;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PerfCounterInfo;
import com.vmware.vim25.PerfEntityMetric;
import com.vmware.vim25.PerfEntityMetricBase;
import com.vmware.vim25.PerfInterval;
import com.vmware.vim25.PerfMetricId;
import com.vmware.vim25.PerfMetricIntSeries;
import com.vmware.vim25.PerfMetricSeries;
import com.vmware.vim25.PerfQuerySpec;
import com.vmware.vim25.PerfSampleInfo;
import com.vmware.vim25.PerfStatsType;
import com.vmware.vim25.PerfSummaryType;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * History
 * 
 * This sample reads performance measurements from the current time.
 * 
 * <b>Parameters:</b>
 * url            [required]: url of the web service.
 * username       [required]: username for the authentication
 * Password       [required]: password for the authentication
 * hostname       [required]: name of the host
 * interval       [required]: sampling interval in seconds.
 * starttime:     [optional]: In minutes, to specify what's start time from which samples needs to be collected
 * duration       [optional]: Duration for which samples needs to be  taken
 * groupname      [required]: cpu, mem
 * countername    [required]: Usage (for cpu and mem), Overhead (for mem)
 * 
 * <b>Command Line:</b>
 * Display performance measurements of extra CPU usage
 * run.bat com.vmware.performance.History --url [webserviceurl]
 * --username [username]  --password [password] --hostname [name of the
 * history server]  --groupname cpu --countername usage --interval 300
 * 
 * Display performance measurements from the past
 * should be displayed as per the counter and the group specified.
 * run.bat com.vmware.performance.History --url [webserviceurl]
 * --username [username]  --password [password]--hostname [name of the 
 * history server]  --groupname mem --countername overhead --interval 300
 * </pre>
 */

public class History {

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
   private static final ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();
   private static ManagedObjectReference propCollector = null;
   private static ManagedObjectReference rootFolder = null;

   /*
    *Connection input parameters
    */
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
      if (url == null || userName == null || password == null) {
         throw new IllegalArgumentException(
               "Expected --url, --username, --password arguments.");
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

      propCollector = serviceContent.getPropertyCollector();
      rootFolder = serviceContent.getRootFolder();
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

   /* End Server Connection and common code */

   /* Start Sample functional code */

   private static String hostname = null;
   private static String groupname = null;
   private static Map<String, Map<String, ArrayList<PerfCounterInfo>>> pci =
         new HashMap<String, Map<String, ArrayList<PerfCounterInfo>>>();
   private static ManagedObjectReference perfManager;
   private static int duration = 0;
   private static int starttime = 0;
   private static String interval = null;
   private static String countername = null;

   private static void getInputParameters(String[] args) throws Exception {
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
            hostname = val;
         } else if (param.equalsIgnoreCase("--interval")
               && !val.startsWith("--") && !val.isEmpty()) {
            interval = val;
         } else if (param.equalsIgnoreCase("--groupname")
               && !val.startsWith("--") && !val.isEmpty()) {
            groupname = val;
         } else if (param.equalsIgnoreCase("--countername")
               && !val.startsWith("--") && !val.isEmpty()) {
            countername = val;
         } else if (param.equalsIgnoreCase("--starttime")
               && !val.startsWith("--") && !val.isEmpty()) {
            starttime = Integer.parseInt(val);
         } else if (param.equalsIgnoreCase("--duration")
               && !val.startsWith("--") && !val.isEmpty()) {
            duration = Integer.parseInt(val);
         }
         val = "";
         ai += 2;
      }
      if (hostname == null) {
         throw new IllegalArgumentException("Expected --hostname argument.");
      }
      if (interval == null) {
         throw new IllegalArgumentException("Expected --interval argument.");
      }
      if (groupname == null) {
         throw new IllegalArgumentException("Expected --groupname argument.");
      }
      if (countername == null) {
         throw new IllegalArgumentException("Expected --countername argument.");
      }
      setStartTimeAndDuration(duration, starttime);
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
               vimPort.retrievePropertiesEx(propCollector, listpfs,
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
            rslts = vimPort.continueRetrievePropertiesEx(propCollector, token);
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
         System.out.println("Failed Getting Contents");
         e.printStackTrace();
      }
      return listobjcontent;
   }

   private static void setStartTimeAndDuration(int dura, int sttime)
         throws Exception {
      if (dura == 0 || sttime == 0) {
         duration = 20;
         starttime = 20;
      } else {
         duration = (dura <= 0) ? 20 : dura;
         starttime = (sttime <= 0) ? 20 : sttime;
      }
      if (duration > starttime) {
         System.out.println("Duration must be less than startime");
      }
   }

   /**
    * This method initializes all the performance counters available on the
    * system it is connected to. The performance counters are stored in the
    * hashmap counters with group.counter.rolluptype being the key and id being
    * the value.
    */
   private static List<PerfInterval> getPerfInterval() {

      List<PerfInterval> pciArr = null;
      try {
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add("historicalInterval");
         propertySpec.setType("PerformanceManager");
         List<PropertySpec> propertySpecs = new ArrayList<PropertySpec>();
         propertySpecs.add(propertySpec);

         // Now create Object Spec
         ObjectSpec objectSpec = new ObjectSpec();
         objectSpec.setObj(perfManager);

         List<ObjectSpec> objectSpecs = new ArrayList<ObjectSpec>();
         objectSpecs.add(objectSpec);

         // Create PropertyFilterSpec using the PropertySpec and ObjectPec
         // created above.
         PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
         propertyFilterSpec.getPropSet().add(propertySpec);
         propertyFilterSpec.getObjectSet().add(objectSpec);

         List<PropertyFilterSpec> propertyFilterSpecs =
               new ArrayList<PropertyFilterSpec>();
         propertyFilterSpecs.add(propertyFilterSpec);

         List<PropertyFilterSpec> listpfs =
               new ArrayList<PropertyFilterSpec>(1);
         listpfs.add(propertyFilterSpec);
         List<ObjectContent> listocont = retrievePropertiesAllObjects(listpfs);

         if (listocont != null) {
            for (ObjectContent oc : listocont) {
               List<DynamicProperty> dps = oc.getPropSet();
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     List<PerfInterval> perintlist =
                           ((ArrayOfPerfInterval) dp.getVal())
                                 .getPerfInterval();
                     pciArr = perintlist;
                  }
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return pciArr;
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
         List<PropertyFilterSpec> listPfs =
               new ArrayList<PropertyFilterSpec>(1);
         listPfs.add(propertyFilterSpec);
         List<ObjectContent> oContList = retrievePropertiesAllObjects(listPfs);

         if (oContList != null) {
            for (ObjectContent oc : oContList) {
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

   private static void displayHistory() throws Exception {
      ManagedObjectReference hostmor = getHostByHostName(hostname);
      if (hostmor == null) {
         System.out.println("Host " + hostname + " not found");
         return;
      }
      counterInfo(perfManager);
      List<PerfInterval> intervals = getPerfInterval();

      // Integer interval = new Integer(Integer.parseInt(interval));
      boolean valid = checkInterval(intervals, Integer.valueOf(interval));
      if (!valid) {
         System.out.println("Invalid interval, Specify one from above");
         return;
      }

      PerfCounterInfo pci =
            getCounterInfo(groupname, countername, PerfSummaryType.AVERAGE,
                  null);
      if (pci == null) {
         System.out.println("Incorrect Group Name and Countername specified");
         return;
      }

      PerfQuerySpec qSpec = new PerfQuerySpec();
      qSpec.setEntity(hostmor);
      qSpec.setMaxSample(new Integer(10));
      List<PerfQuerySpec> qSpecs = new ArrayList<PerfQuerySpec>();
      qSpecs.add(qSpec);
      XMLGregorianCalendar serverstarttime = vimPort.currentTime(SVC_INST_REF);
      XMLGregorianCalendar serverendtime = vimPort.currentTime(SVC_INST_REF);

      int minsToaddEnd = duration - (2 * starttime);
      int minsToaddStart = duration - ((2 * starttime) + duration);

      int setTime;
      if (minsToaddStart < 0) {
         setTime = serverstarttime.getMinute() + (60 + minsToaddStart);
         if (setTime >= 60) {
            setTime = setTime - 60;
            serverstarttime.setMinute(setTime);
         } else {
            serverstarttime.setHour(serverstarttime.getHour() - 1);
            serverstarttime.setMinute(setTime);
         }
      } else {
         serverstarttime.setMinute(serverstarttime.getMinute()
               + (duration - ((2 * starttime) + duration)));
      }
      if (minsToaddEnd < 0) {
         setTime = serverendtime.getMinute() + (60 + minsToaddEnd);
         if (setTime >= 60) {
            setTime = setTime - 60;
            serverendtime.setMinute(setTime);
         } else {
            serverendtime.setHour(serverendtime.getHour() - 1);
            serverendtime.setMinute(setTime);
         }
      } else {
         serverendtime.setMinute(serverendtime.getMinute()
               + (duration - (2 * starttime)));
      }

      System.out.println("Start Time "
            + serverstarttime.toGregorianCalendar().getTime().toString());
      System.out.println("End Time   "
            + serverendtime.toGregorianCalendar().getTime().toString());

      System.out.println();

      List<PerfMetricId> listprfmetid =
            vimPort.queryAvailablePerfMetric(perfManager, hostmor,
                  serverstarttime, serverendtime, Integer.valueOf(interval));

      PerfMetricId ourCounter = null;

      for (int index = 0; index < listprfmetid.size(); ++index) {
         if (listprfmetid.get(index).getCounterId() == pci.getKey()) {
            ourCounter = listprfmetid.get(index);
            break;
         }
      }
      if (ourCounter == null) {
         System.out.println("No data on Host to collect. "
               + "Has it been running for at least " + duration + " minutes");
      } else {
         qSpec = new PerfQuerySpec();
         qSpec.setEntity(hostmor);
         qSpec.setStartTime(serverstarttime);
         qSpec.setEndTime(serverendtime);
         qSpec.getMetricId().addAll(
               Arrays.asList(new PerfMetricId[] { ourCounter }));
         qSpec.setIntervalId(Integer.valueOf(interval));
         qSpecs.add(qSpec);

         List<PerfQuerySpec> alpqs = new ArrayList<PerfQuerySpec>(1);
         alpqs.add(qSpec);
         List<PerfEntityMetricBase> listpemb =
               vimPort.queryPerf(perfManager, alpqs);

         if (listpemb != null) {
            displayValues(listpemb, pci, ourCounter, Integer.valueOf(interval));
         } else {
            System.out.println("No Samples Found");
         }
      }
   }

   private static boolean checkInterval(List<PerfInterval> intervals,
         Integer interv) throws Exception {
      boolean flag = false;
      for (int i = 0; i < intervals.size(); ++i) {
         PerfInterval pi = intervals.get(i);
         if (pi.getSamplingPeriod() == interv) {
            flag = true;
            break;
         }
      }
      if (!flag) {
         System.out.println("Available summary collection intervals");
         System.out.println("Period\tLength\tName");
         for (int i = 0; i < intervals.size(); ++i) {
            PerfInterval pi = intervals.get(i);
            System.out.println(pi.getSamplingPeriod() + "\t" + pi.getLength()
                  + "\t" + pi.getName());
         }
         System.out.println();
      }
      return flag;
   }

   /**
    * This method initializes all the performance counters available on the
    * system it is connected to. The performance counters are stored in the
    * hashmap counters with group.counter.rolluptype being the key and id being
    * the value.
    */
   private static List<PerfCounterInfo> getPerfCounters() {

      List<PerfCounterInfo> pciArr = null;
      try {
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add("perfCounter");
         propertySpec.setType("PerformanceManager");
         List<PropertySpec> propertySpecs = new ArrayList<PropertySpec>();
         propertySpecs.add(propertySpec);

         // Now create Object Spec
         ObjectSpec objectSpec = new ObjectSpec();
         objectSpec.setObj(perfManager);

         List<ObjectSpec> objectSpecs = new ArrayList<ObjectSpec>();
         objectSpecs.add(objectSpec);

         // Create PropertyFilterSpec using the PropertySpec and ObjectPec
         // created above.
         PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
         propertyFilterSpec.getPropSet().add(propertySpec);
         propertyFilterSpec.getObjectSet().add(objectSpec);

         List<PropertyFilterSpec> propertyFilterSpecs =
               new ArrayList<PropertyFilterSpec>();
         propertyFilterSpecs.add(propertyFilterSpec);

         List<PropertyFilterSpec> listpfs =
               new ArrayList<PropertyFilterSpec>(1);
         listpfs.add(propertyFilterSpec);
         List<ObjectContent> listocont = retrievePropertiesAllObjects(listpfs);

         if (listocont != null) {
            for (ObjectContent oc : listocont) {
               List<DynamicProperty> dps = oc.getPropSet();
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     List<PerfCounterInfo> pcinfolist =
                           ((ArrayOfPerfCounterInfo) dp.getVal())
                                 .getPerfCounterInfo();
                     pciArr = pcinfolist;
                  }
               }
            }
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return pciArr;
   }

   private static void counterInfo(ManagedObjectReference pmRef)
         throws Exception {
      List<PerfCounterInfo> cInfos = getPerfCounters();
      for (int i = 0; i < cInfos.size(); ++i) {
         PerfCounterInfo cInfo = cInfos.get(i);
         String group = cInfo.getGroupInfo().getKey();
         Map<String, ArrayList<PerfCounterInfo>> nameMap = null;
         if (!pci.containsKey(group)) {
            nameMap = new HashMap<String, ArrayList<PerfCounterInfo>>();
            pci.put(group, nameMap);
         } else {
            nameMap = pci.get(group);
         }
         String name = cInfo.getNameInfo().getKey();
         ArrayList<PerfCounterInfo> counters = null;
         if (!nameMap.containsKey(name)) {
            counters = new ArrayList<PerfCounterInfo>();
            nameMap.put(name, counters);
         } else {
            counters = nameMap.get(name);
         }
         counters.add(cInfo);
      }

   }

   private static ArrayList<PerfCounterInfo> getCounterInfos(String groupName,
         String counterName) {
      Map<String, ArrayList<PerfCounterInfo>> nameMap = pci.get(groupName);
      if (nameMap != null) {
         ArrayList<PerfCounterInfo> ret = nameMap.get(counterName);
         if (ret != null) {
            return ret;
         }
      }
      return null;
   }

   private static PerfCounterInfo getCounterInfo(String groupName,
         String counterName, PerfSummaryType rollupType, PerfStatsType statsType) {
      ArrayList<PerfCounterInfo> counters =
            getCounterInfos(groupName, counterName);
      if (counters != null) {
         for (Iterator<?> i = counters.iterator(); i.hasNext();) {
            PerfCounterInfo pci = (PerfCounterInfo) i.next();
            if ((statsType == null || statsType.equals(pci.getStatsType()))
                  && (rollupType == null || rollupType.equals(pci
                        .getRollupType()))) {
               return pci;
            }
         }
      }
      return null;
   }

   private static void displayValues(List<PerfEntityMetricBase> values,
         PerfCounterInfo pci, PerfMetricId pmid, Integer inter) {
      for (int i = 0; i < values.size(); ++i) {
         List<PerfMetricSeries> listperfmetser =
               ((PerfEntityMetric) values.get(i)).getValue();
         List<PerfSampleInfo> listperfsinfo =
               ((PerfEntityMetric) values.get(i)).getSampleInfo();
         if (listperfsinfo == null || listperfsinfo.size() == 0) {
            System.out.println("No Samples available. Continuing.");
            continue;
         }
         System.out.println("Sample time range: "
               + listperfsinfo.get(0).getTimestamp().toGregorianCalendar()
                     .getTime().toString()
               + " - "
               + (listperfsinfo.get(listperfsinfo.size() - 1)).getTimestamp()
                     .toGregorianCalendar().getTime().toString()
               + ", read every " + inter + " seconds");
         for (int vi = 0; vi < listperfmetser.size(); ++vi) {
            if (pci != null) {
               if (pci.getKey() != listperfmetser.get(vi).getId()
                     .getCounterId()) {
                  continue;
               }
               System.out.println(pci.getNameInfo().getSummary()
                     + " - Instance: " + pmid.getInstance());
            }
            if (listperfmetser.get(vi) instanceof PerfMetricIntSeries) {
               PerfMetricIntSeries val =
                     (PerfMetricIntSeries) listperfmetser.get(vi);
               List<Long> listlongs = val.getValue();
               for (int j = 0; j < listlongs.size(); j++) {
                  System.out.println("timestamp: "
                        + listperfsinfo.get(j).getTimestamp()
                              .toGregorianCalendar().getTime() + "\tvalue: "
                        + listlongs.get(j));
               }
            }
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

      System.out.println("This sample reads performance measurements from the"
            + " current time.");
      System.out.println("url            [required]: url of the web service.");
      System.out
            .println("username       [required]: username for the authentication");
      System.out
            .println("Password       [required]: password for the authentication");
      System.out.println("hostname       [required]: name of the host");
      System.out
            .println("interval       [required]: sampling interval in seconds");
      System.out
            .println("starttime:     [optional]: In minutes, to specfiy what's"
                  + " start time from which samples needs to be collected");
      System.out.println("duration       [optional]: Duration for which"
            + " samples needs to be  taken");
      System.out.println("groupname      [required]: cpu, mem");
      System.out.println("countername     [required]: Usage (for cpu and mem),"
            + " Overhead (for mem)");
      System.out.println("<b>Command Line: to display performance measurements"
            + " of extra CPU usage");
      System.out.println("run.bat com.vmware.performance."
            + "History --url [webserviceurl]");
      System.out.println("--username [username]  --password [password]"
            + " --hostname [name of the");
      System.out
            .println("history server]  --groupname cpu --countername usage --interval 300");
      System.out.println("<b>Command Line: to display performance "
            + "measurements from the past");
      System.out.println("should be displayed as per the counter "
            + "and the group specified.");
      System.out.println("run.bat com.vmware.performance.History"
            + " --url [webserviceurl]");
      System.out.println("--username [username]  --password [password] "
            + "--hostname [name of the");
      System.out
            .println("history server]  --groupname mem --countername overhead --interval 300");
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
         displayHistory();
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
