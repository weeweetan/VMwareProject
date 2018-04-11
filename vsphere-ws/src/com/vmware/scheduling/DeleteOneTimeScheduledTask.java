package com.vmware.scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * DeleteOneTimeScheduledTask
 * 
 * This sample demonstrates deleting a scheduled task
 * 
 * <b>Parameters:</b>
 * url            [required] : url of the web service
 * username       [required] : username for the authentication
 * password       [required] : password for the authentication
 * taskname       [required] : name of the task to be deleted
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.scheduling.DeleteOneTimeScheduledTask
 * --url [webserviceurl] --username [username] --password [password]
 * --taskname [TaskToBeDeleted]
 * </pre>
 */

public class DeleteOneTimeScheduledTask {

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
   private static ManagedObjectReference SVC_INST_REF =
         new ManagedObjectReference();

   private static ManagedObjectReference propCollectorRef = null;
   private static ManagedObjectReference scheduleManager = null;

   /*
       Connection input parameters
    */
   private static String url = null;
   private static String userName = null;
   private static String password = null;
   private static boolean help = false;
   private static String taskName = null;
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

   // get input parameters to run the sample
   private static void getInputParameters(String[] args)
         throws IllegalArgumentException {
      int ai = 0;
      String param = "";
      String val = "";
      while (ai < args.length) {
         param = args[ai].trim();
         if (ai + 1 < args.length) {
            val = args[ai + 1].trim();
         }
         if (param.equalsIgnoreCase("--taskname") && !val.startsWith("--")
               && !val.isEmpty()) {
            taskName = val;
         }
         val = "";
         ai += 2;
      }
      if (taskName == null) {
         throw new IllegalArgumentException("Expected --taskname argument.");
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
      scheduleManager = serviceContent.getScheduledTaskManager();
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
    * RetrieveProperties method
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

   /**
    * Create Property Filter Spec to get names of all ScheduledTasks the
    * ScheduledTaskManager has.
    * 
    * @return PropertyFilterSpec to get properties
    */
   private PropertyFilterSpec createTaskPropertyFilterSpec() {
      // The traversal spec traverses the "scheduledTask" property of
      // ScheduledTaskManager to get names of ScheduledTask ManagedEntities
      // A Traversal Spec allows traversal into a ManagedObjects
      // using a single attribute of the managedObject
      TraversalSpec scheduledTaskTraversal = new TraversalSpec();

      scheduledTaskTraversal.setType(scheduleManager.getType());
      scheduledTaskTraversal.setPath("scheduledTask");

      // We want to get values of the scheduleTask property
      // of the scheduledTaskManager, which are the ScheduledTasks
      // so we set skip = false.
      scheduledTaskTraversal.setSkip(Boolean.FALSE);
      scheduledTaskTraversal.setName("scheduleManagerToScheduledTasks");

      // Setup a PropertySpec to return names of Scheduled Tasks so
      // we can find the named ScheduleTask ManagedEntity to delete
      // Name is an attribute of ScheduledTaskInfo so
      // the path set will contain "info.name"
      PropertySpec propSpec = new PropertySpec();
      propSpec.setAll(new Boolean(false));
      propSpec.getPathSet().add("info.name");
      propSpec.setType("ScheduledTask");

      // PropertySpecs are wrapped in a PropertySpec array
      // since we only have a propertySpec for the ScheduledTask,
      // the only values we will get back are names of scheduledTasks
      List<PropertySpec> propSpecArray = new ArrayList<PropertySpec>();
      propSpecArray.add(propSpec);

      // Create an Object Spec to specify the starting or root object
      // and the SelectionSpec to traverse to each ScheduledTask in the
      // array of scheduledTasks in the ScheduleManager
      ObjectSpec objSpec = new ObjectSpec();
      objSpec.setObj(scheduleManager);
      objSpec.getSelectSet().add(scheduledTaskTraversal);

      // Set skip = true so properties of ScheduledTaskManager
      // are not returned, and only values of info.name property of
      // each ScheduledTask is returned
      objSpec.setSkip(Boolean.TRUE);

      // ObjectSpecs used in PropertyFilterSpec are wrapped in an array
      List<ObjectSpec> objSpecArray = new ArrayList<ObjectSpec>();
      objSpecArray.add(objSpec);

      // Create the PropertyFilter spec with
      // ScheduledTaskManager as "root" object
      PropertyFilterSpec spec = new PropertyFilterSpec();
      spec.getPropSet().addAll(propSpecArray);
      spec.getObjectSet().addAll(objSpecArray);
      return spec;
   }

   private ManagedObjectReference findOneTimeScheduledTask(
         PropertyFilterSpec scheduledTaskSpec) throws Exception {
      boolean found = false;
      ManagedObjectReference oneTimeTask = null;
      // Use PropertyCollector to get all scheduled tasks the
      // ScheduleManager has
      List<PropertyFilterSpec> propertyFilterSpecList =
            new ArrayList<PropertyFilterSpec>();
      propertyFilterSpecList.add(scheduledTaskSpec);
      List<ObjectContent> scheduledTasks =
            retrievePropertiesAllObjects(propertyFilterSpecList);

      // Find the task name we're looking for and return the
      // ManagedObjectReference for the ScheduledTask with the
      // name that matched the name of the OneTimeTask created earlier
      if (scheduledTasks != null) {
         for (int i = 0; i < scheduledTasks.size() && !found; i++) {
            ObjectContent taskContent = scheduledTasks.get(i);
            List<DynamicProperty> props = taskContent.getPropSet();
            for (int p = 0; p < props.size() && !found; p++) {
               DynamicProperty prop = props.get(p);
               String taskNameVal = (String) prop.getVal();
               if (taskName.equals(taskNameVal)) {
                  oneTimeTask = taskContent.getObj();
                  found = true;
               }
            }
         }
      }
      if (!found) {
         System.out.println("Scheduled task '" + taskName + "' not found");
      }
      return oneTimeTask;
   }

   private void deleteScheduledTask(ManagedObjectReference oneTimeTask)
         throws Exception {
      try {
         // Remove the One Time Scheduled Task
         vimPort.removeScheduledTask(oneTimeTask);
         System.out.println("Successfully Deleted ScheduledTask: "
               + oneTimeTask.getValue());
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println("Error");
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
      System.out.println("This sample demonstrates deleting a scheduled task");
      System.out.println("\nParameters:");
      System.out.println("url            [required] : url of the web service.");
      System.out
            .println("username       [required] : username for the authentication");
      System.out
            .println("password       [required] : password for the authentication");
      System.out
            .println("taskname       [required] : name of the task to be deleted");
      System.out.println("\nCommand:");
      System.out
            .println("run.bat com.vmware.scheduling.DeleteOneTimeScheduledTask");
      System.out
            .println("--url [webserviceurl] --username [username] --password [password]");
      System.out.println("--taskname [TaskToBeDeleted]");
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
         DeleteOneTimeScheduledTask schedTask =
               new DeleteOneTimeScheduledTask();
         // create a Property Filter Spec to get names
         // of all scheduled tasks
         PropertyFilterSpec taskFilterSpec =
               schedTask.createTaskPropertyFilterSpec();

         // Retrieve names of all ScheduledTasks and find
         // the named one time Scheduled Task
         ManagedObjectReference oneTimeTask =
               schedTask.findOneTimeScheduledTask(taskFilterSpec);

         // Delete the one time scheduled task
         if (oneTimeTask != null) {
            schedTask.deleteScheduledTask(oneTimeTask);
         }
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
}
