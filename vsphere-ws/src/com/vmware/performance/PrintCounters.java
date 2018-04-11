/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vmware.performance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.ArrayOfPerfCounterInfo;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.ElementDescription;
import com.vmware.vim25.InvalidPropertyFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PerfCounterInfo;
import com.vmware.vim25.PerfMetricId;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * PrintCounters
 * 
 * This sample writes available VM, Hostsystem or ResourcePool
 * perf counters into the file specified
 * 
 * <b>Parameters:</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 * entitytype   [required] : Managed entity
 *                          [HostSystem|VirtualMachine|ResourcePool]
 * entityname   [required] : name of the managed entity
 * filename     [required] : Full path of filename to write to
 * 
 * <b>Command Line:</b>
 * Save counters available for a host
 * run.bat com.vmware.performance.PrintCounters
 * --url https://myHost.com/sdk
 * --username [user]  --password [password] --entitytype HostSystem
 * --entityname myHost.com --filename myHostCounters
 * </pre>
 */

public class PrintCounters {

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
   private static ManagedObjectReference perfManager;
   private static String filename;
   private static String entityname;
   private static String entitytype;
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
         if (param.equalsIgnoreCase("--entitytype") && !val.startsWith("--")
               && !val.isEmpty()) {
            entitytype = val;
         } else if (param.equalsIgnoreCase("--entityname")
               && !val.startsWith("--") && !val.isEmpty()) {
            entityname = val;
         } else if (param.equalsIgnoreCase("--filename")
               && !val.startsWith("--") && !val.isEmpty()) {
            filename = val;
         }
         val = "";
         ai += 2;
      }
      if (entitytype == null || entityname == null || filename == null) {
         throw new IllegalArgumentException(
               "Expected --entitytype, --entityname and --filename arguments.");
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

   private static void printCounters() throws Exception {
      String entityType = entitytype;

      if (entityType.equalsIgnoreCase("HostSystem")) {
         printEntityCounters("HostSystem");
      } else if (entityType.equalsIgnoreCase("VirtualMachine")) {
         printEntityCounters("VirtualMachine");
      } else if (entityType.equals("ResourcePool")) {
         printEntityCounters("ResourcePool");
      } else {
         System.out.println("Entity Argument must be "
               + "[HostSystem|VirtualMachine|ResourcePool]");
      }
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
         List<ObjectContent> listobjcont =
               retrievePropertiesAllObjects(listpfs);

         if (listobjcont != null) {
            for (ObjectContent oc : listobjcont) {
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

   private static void printEntityCounters(String entityType) throws Exception {

      ManagedObjectReference mor =
            getMOREFsInFolderByType(serviceContent.getRootFolder(), entityType)
                  .get(entityname);

      List<PerfCounterInfo> cInfo = getPerfCounters();

      if (mor != null) {
         Set<?> ids = getPerfIdsAvailable(perfManager, mor);
         PrintWriter out =
               new PrintWriter(new BufferedWriter(new FileWriter(filename)));
         if (cInfo != null) {
            out.println("<perf-counters>");
            for (int c = 0; c < cInfo.size(); ++c) {
               PerfCounterInfo pci = cInfo.get(c);
               Integer id = new Integer(pci.getKey());
               if (ids.contains(id)) {
                  out.print("  <perf-counter key=\"");
                  out.print(id);
                  out.print("\" ");

                  out.print("rollupType=\"");
                  out.print(pci.getRollupType());
                  out.print("\" ");

                  out.print("statsType=\"");
                  out.print(pci.getStatsType());
                  out.println("\">");
                  printElementDescription(out, "groupInfo", pci.getGroupInfo());
                  printElementDescription(out, "nameInfo", pci.getNameInfo());
                  printElementDescription(out, "unitInfo", pci.getUnitInfo());

                  out.println("    <entity type=\"" + entityType + "\"/>");
                  List<Integer> listint = pci.getAssociatedCounterId();
                  int[] ac = new int[listint.size()];
                  for (int i = 0; i < listint.size(); i++) {
                     ac[i] = listint.get(i);
                  }
                  if (ac != null) {
                     for (int a = 0; a < ac.length; ++a) {
                        out.println("    <associatedCounter>" + ac[a]
                              + "</associatedCounter>");
                     }
                  }
                  out.println("  </perf-counter>");
               }
            }
            out.println("</perf-counters>");
            out.flush();
            out.close();
         }
         System.out.println("Check " + filename + " for Print Counters");
      } else {
         System.out.println(entityType + " " + entityname + " not found.");
      }
   }

   private static void printElementDescription(PrintWriter out, String name,
         ElementDescription ed) {
      out.print("   <" + name + "-key>");
      out.print(ed.getKey());
      out.println("</" + name + "-key>");

      out.print("   <" + name + "-label>");
      out.print(ed.getLabel());
      out.println("</" + name + "-label>");

      out.print("   <" + name + "-summary>");
      out.print(ed.getSummary());
      out.println("</" + name + "-summary>");
   }

   private static Set<Integer> getPerfIdsAvailable(
         ManagedObjectReference perfMoRef, ManagedObjectReference entityMoRef)
         throws Exception {
      Set<Integer> ret = new HashSet<Integer>();
      if (entityMoRef != null) {
         List<PerfMetricId> listpermids =
               vimPort.queryAvailablePerfMetric(perfMoRef, entityMoRef, null,
                     null, new Integer(300));
         if (listpermids != null) {
            for (int i = 0; i < listpermids.size(); ++i) {
               ret.add(new Integer(listpermids.get(i).getCounterId()));
            }
         }
      }
      return ret;
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
            .println("This sample writes available VM, Hostsystem or ResourcePool");
      System.out.println("perf counters into the file specified.");
      System.out.println("\nParameters:");
      System.out.println("url          [required] : url of the web service.");
      System.out
            .println("username     [required] : username for the authentication");
      System.out
            .println("password     [required] : password for the authentication");
      System.out.println("entitytype   [required] : Managed entity");
      System.out
            .println("                          [HostSystem|VirtualMachine|ResourcePool]");
      System.out
            .println("entityname   [required] : name of the managed entity");
      System.out
            .println("filename     [required] : Full path of filename to write to");
      System.out.println("\nCommand:");
      System.out.println("Save counters available for a host");
      System.out.println("run.bat com.vmware.performance.PrintCounters");
      System.out.println("--url https://myHost.com/sdk");
      System.out
            .println("--username [user]  --password [password] --entitytype HostSystem");
      System.out.println("--entityname myHost.com --filename myHostCounters");
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
         printCounters();
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
         printUsage();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
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
