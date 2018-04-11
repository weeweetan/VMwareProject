package com.vmware.general;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.HostListSummaryQuickStats;
import com.vmware.vim25.HostRuntimeInfo;
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
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VirtualMachineQuickStats;
import com.vmware.vim25.VirtualMachineRuntimeInfo;

/**
 * <pre>
 * GetUpdates
 * 
 * This sample demonstrates how to use the PropertyCollector to monitor one or more
 * properties of one or more managed objects.
 * In particular this sample monitors all or one Virtual Machine
 * and all or one Host for changes to some basic properties
 * 
 * <b>Parameters:</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 * vmname       [required] : name of the virtual machine
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.general.GetUpdates --url [webserviceurl]
 * --username [username] --password [password]
 * --vmname  [vm name]
 * </pre>
 */

public class GetUpdates {

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
   private static ManagedObjectReference rootRef;
   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;

   private static String url;
   private static String userName;
   private static String password;
   private static boolean help = false;
   private static boolean isConnected = false;
   private static String virtualmachinename;

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
         if (param.equalsIgnoreCase("--vmname") && !val.startsWith("--")
               && !val.isEmpty()) {
            virtualmachinename = val;
         }
         val = "";
         ai += 2;
      }
      if (virtualmachinename == null) {
         throw new IllegalArgumentException("Expected --entityname argument.");
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
      rootRef = serviceContent.getRootFolder();
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
    * 
    * @return TraversalSpec specification to get to the VirtualMachine managed
    *         object.
    */
   private static TraversalSpec getVMTraversalSpec() {
      // Create a traversal spec that starts from the 'root' objects
      // and traverses the inventory tree to get to the VirtualMachines.
      // Build the traversal specs bottoms up

      //Traversal to get to the VM in a VApp
      TraversalSpec vAppToVM = new TraversalSpec();
      vAppToVM.setName("vAppToVM");
      vAppToVM.setType("VirtualApp");
      vAppToVM.setPath("vm");

      //Traversal spec for VApp to VApp
      TraversalSpec vAppToVApp = new TraversalSpec();
      vAppToVApp.setName("vAppToVApp");
      vAppToVApp.setType("VirtualApp");
      vAppToVApp.setPath("resourcePool");
      //SelectionSpec for VApp to VApp recursion
      SelectionSpec vAppRecursion = new SelectionSpec();
      vAppRecursion.setName("vAppToVApp");
      //SelectionSpec to get to a VM in the VApp
      SelectionSpec vmInVApp = new SelectionSpec();
      vmInVApp.setName("vAppToVM");
      //SelectionSpec for both VApp to VApp and VApp to VM
      List<SelectionSpec> vAppToVMSS = new ArrayList<SelectionSpec>();
      vAppToVMSS.add(vAppRecursion);
      vAppToVMSS.add(vmInVApp);
      vAppToVApp.getSelectSet().addAll(vAppToVMSS);

      //This SelectionSpec is used for recursion for Folder recursion
      SelectionSpec sSpec = new SelectionSpec();
      sSpec.setName("VisitFolders");

      // Traversal to get to the vmFolder from DataCenter
      TraversalSpec dataCenterToVMFolder = new TraversalSpec();
      dataCenterToVMFolder.setName("DataCenterToVMFolder");
      dataCenterToVMFolder.setType("Datacenter");
      dataCenterToVMFolder.setPath("vmFolder");
      dataCenterToVMFolder.setSkip(false);
      dataCenterToVMFolder.getSelectSet().add(sSpec);

      // TraversalSpec to get to the DataCenter from rootFolder
      TraversalSpec traversalSpec = new TraversalSpec();
      traversalSpec.setName("VisitFolders");
      traversalSpec.setType("Folder");
      traversalSpec.setPath("childEntity");
      traversalSpec.setSkip(false);
      List<SelectionSpec> sSpecArr = new ArrayList<SelectionSpec>();
      sSpecArr.add(sSpec);
      sSpecArr.add(dataCenterToVMFolder);
      sSpecArr.add(vAppToVM);
      sSpecArr.add(vAppToVApp);
      traversalSpec.getSelectSet().addAll(sSpecArr);
      return traversalSpec;
   }

   /**
    * Get the MOR of the Virtual Machine by its name.
    * 
    * @param vmName
    *           The name of the Virtual Machine
    * @return The Managed Object reference for this VM
    */
   private static ManagedObjectReference getVmByVMname(String vmName) {
      ManagedObjectReference retVal = null;
      ManagedObjectReference rootFolder = serviceContent.getRootFolder();
      try {
         TraversalSpec tSpec = getVMTraversalSpec();
         // Create Property Spec
         PropertySpec propertySpec = new PropertySpec();
         propertySpec.setAll(Boolean.FALSE);
         propertySpec.getPathSet().add("name");
         propertySpec.setType("VirtualMachine");

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
         List<ObjectContent> listobcont =
               vimPort.retrieveProperties(propCollectorRef, listpfs);

         if (listobcont != null) {
            for (ObjectContent oc : listobcont) {
               ManagedObjectReference mr = oc.getObj();
               String vmnm = null;
               List<DynamicProperty> dps = oc.getPropSet();
               if (dps != null) {
                  for (DynamicProperty dp : dps) {
                     vmnm = (String) dp.getVal();
                  }
               }
               if (vmnm != null && vmnm.equals(vmName)) {
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

   private static void getUpdates() throws Exception {
      ManagedObjectReference vmRef = getVmByVMname(virtualmachinename);

      if (vmRef == null) {
         System.out.println("Virtual Machine " + virtualmachinename
               + " Not Found");
         return;
      }
      String[][] typeInfo =
            { new String[] { "VirtualMachine", "name", "summary.quickStats",
                  "runtime" } };
      List<PropertySpec> pSpecs = buildPropertySpecArray(typeInfo);
      List<ObjectSpec> oSpecs = new ArrayList<ObjectSpec>();
      boolean oneOnly = vmRef != null;
      ObjectSpec os = new ObjectSpec();
      os.setObj(oneOnly ? vmRef : rootRef);
      os.setSkip(new Boolean(!oneOnly));
      if (!oneOnly) {
         os.getSelectSet().addAll(Arrays.asList(buildFullTraversal()));
      }
      oSpecs.add(os);
      PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
      propertyFilterSpec.getPropSet().addAll(pSpecs);
      propertyFilterSpec.getObjectSet().addAll(oSpecs);
      ManagedObjectReference propFilter =
            vimPort.createFilter(propCollectorRef, propertyFilterSpec, false);

      BufferedReader console =
            new BufferedReader(new InputStreamReader(System.in));

      String version = "";
      do {
         UpdateSet update = vimPort.checkForUpdates(propCollectorRef, version);
         if (update != null && update.getFilterSet() != null) {
            handleUpdate(update);
            version = update.getVersion();
         } else {
            System.out.println("No update is present!");
         }
         System.out.println("");
         System.out.println("Press <Enter> to check for updates");
         System.out.println("Enter 'exit' <Enter> to exit the program");
         String line = console.readLine();
         if (line != null && line.trim().equalsIgnoreCase("exit")) {
            break;
         }
      } while (true);
      vimPort.destroyPropertyFilter(propFilter);
   }

   private static void handleUpdate(UpdateSet update) {
      List<ObjectUpdate> vmUpdates = new ArrayList<ObjectUpdate>();
      List<ObjectUpdate> hostUpdates = new ArrayList<ObjectUpdate>();
      List<PropertyFilterUpdate> pfus = update.getFilterSet();

      for (PropertyFilterUpdate pfu : pfus) {
         List<ObjectUpdate> listobup = pfu.getObjectSet();
         for (ObjectUpdate oup : listobup) {
            if (oup.getObj().getType().equals("VirtualMachine")) {
               vmUpdates.add(oup);
            } else if (oup.getObj().getType().equals("HostSystem")) {
               hostUpdates.add(oup);
            }
         }
      }

      if (vmUpdates.size() > 0) {
         System.out.println("Virtual Machine updates:");
         for (ObjectUpdate up : vmUpdates) {
            handleObjectUpdate(up);
         }
      }
      if (hostUpdates.size() > 0) {
         System.out.println("Host updates:");
         for (ObjectUpdate up : hostUpdates) {
            handleObjectUpdate(up);
         }
      }
   }

   private static void handleObjectUpdate(ObjectUpdate oUpdate) {
      List<PropertyChange> pc = oUpdate.getChangeSet();
      if (oUpdate.getKind() == ObjectUpdateKind.ENTER) {
         System.out.println(" New Data:");
         handleChanges(pc);
      } else if (oUpdate.getKind() == ObjectUpdateKind.LEAVE) {
         System.out.println(" Removed Data:");
         handleChanges(pc);
      } else if (oUpdate.getKind() == ObjectUpdateKind.MODIFY) {
         System.out.println(" Changed Data:");
         handleChanges(pc);
      }

   }

   private static void handleChanges(List<PropertyChange> changes) {
      for (int pci = 0; pci < changes.size(); ++pci) {
         String name = changes.get(pci).getName();
         Object value = changes.get(pci).getVal();
         PropertyChangeOp op = changes.get(pci).getOp();
         if (op != PropertyChangeOp.REMOVE) {
            System.out.println("  Property Name: " + name);
            if ("summary.quickStats".equals(name)) {
               if (value instanceof VirtualMachineQuickStats) {
                  VirtualMachineQuickStats vmqs =
                        (VirtualMachineQuickStats) value;
                  String cpu =
                        vmqs.getOverallCpuUsage() == null ? "unavailable"
                              : vmqs.getOverallCpuUsage().toString();
                  String memory =
                        vmqs.getHostMemoryUsage() == null ? "unavailable"
                              : vmqs.getHostMemoryUsage().toString();
                  System.out.println("   Guest Status: "
                        + vmqs.getGuestHeartbeatStatus().toString());
                  System.out.println("   CPU Load %: " + cpu);
                  System.out.println("   Memory Load %: " + memory);
               } else if (value instanceof HostListSummaryQuickStats) {
                  HostListSummaryQuickStats hsqs =
                        (HostListSummaryQuickStats) value;
                  String cpu =
                        hsqs.getOverallCpuUsage() == null ? "unavailable"
                              : hsqs.getOverallCpuUsage().toString();
                  String memory =
                        hsqs.getOverallMemoryUsage() == null ? "unavailable"
                              : hsqs.getOverallMemoryUsage().toString();
                  System.out.println("   CPU Load %: " + cpu);
                  System.out.println("   Memory Load %: " + memory);
               }
            } else if ("runtime".equals(name)) {
               if (value instanceof VirtualMachineRuntimeInfo) {
                  VirtualMachineRuntimeInfo vmri =
                        (VirtualMachineRuntimeInfo) value;
                  System.out.println("   Power State: "
                        + vmri.getPowerState().toString());
                  System.out.println("   Connection State: "
                        + vmri.getConnectionState().toString());
                  XMLGregorianCalendar bTime = vmri.getBootTime();
                  if (bTime != null) {
                     System.out.println("   Boot Time: "
                           + bTime.toGregorianCalendar().getTime());
                  }
                  Long mOverhead = vmri.getMemoryOverhead();
                  if (mOverhead != null) {
                     System.out.println("   Memory Overhead: " + mOverhead);
                  }
               } else if (value instanceof HostRuntimeInfo) {
                  HostRuntimeInfo hri = (HostRuntimeInfo) value;
                  System.out.println("   Connection State: "
                        + hri.getConnectionState().toString());
                  XMLGregorianCalendar bTime = hri.getBootTime();
                  if (bTime != null) {
                     System.out.println("   Boot Time: "
                           + bTime.toGregorianCalendar().getTime());
                  }
               }
            } else if ("name".equals(name)) {
               System.out.println("   " + value);
            } else {
               System.out.println("   " + value.toString());
            }
         } else {
            System.out.println("Property Name: " + name + " value removed.");
         }
      }
   }

   /**
    * This code takes an array of [typename, property, property, ...] and
    * converts it into a PropertySpec[]. handles case where multiple references
    * to the same typename are specified.
    * 
    * @param typeinfo
    *           2D array of type and properties to retrieve
    * 
    * @return Array of container filter specs
    */
   private static List<PropertySpec> buildPropertySpecArray(String[][] typeinfo) {
      // Eliminate duplicates
      HashMap<String, Set<String>> tInfo = new HashMap<String, Set<String>>();
      for (int ti = 0; ti < typeinfo.length; ++ti) {
         Set<String> props = tInfo.get(typeinfo[ti][0]);
         if (props == null) {
            props = new HashSet<String>();
            tInfo.put(typeinfo[ti][0], props);
         }
         boolean typeSkipped = false;
         for (int pi = 0; pi < typeinfo[ti].length; ++pi) {
            String prop = typeinfo[ti][pi];
            if (typeSkipped) {
               props.add(prop);
            } else {
               typeSkipped = true;
            }
         }
      }

      // Create PropertySpecs
      ArrayList<PropertySpec> pSpecs = new ArrayList<PropertySpec>();

      for (String type : tInfo.keySet()) {
         PropertySpec pSpec = new PropertySpec();
         Set<String> props = tInfo.get(type);
         pSpec.setType(type);
         pSpec.setAll(props.isEmpty() ? Boolean.TRUE : Boolean.FALSE);
         for (Iterator<?> pi = props.iterator(); pi.hasNext();) {
            String prop = (String) pi.next();
            pSpec.getPathSet().add(prop);
         }
         pSpecs.add(pSpec);
      }

      return pSpecs;
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
            .println("This sample demonstrates how to use the"
                  + " PropertyCollector to monitor one or more properties of one or more managed objects.");
      System.out
            .println("In particular this sample monitors all or one Virtual Machine "
                  + "and all or one Host for changes to some basic properties.");
      System.out.println("\nParameters:");
      System.out.println("url          [required] : url of the web service");
      System.out
            .println("username     [required] : username for the authentication");
      System.out
            .println("password     [required] : password for the authentication");
      System.out
            .println("vmname       [required] : name of the virtual machine");
      System.out.println("\nCommand:");
      System.out
            .println("run.bat com.vmware.general.GetUpdates --url [webserviceurl]");
      System.out.println("--username [username] --password [password]");
      System.out.println("--vmname [vm name]");
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
         getUpdates();
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
