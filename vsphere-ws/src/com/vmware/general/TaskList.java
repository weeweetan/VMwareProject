package com.vmware.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.LocalizedMethodFault;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * TaskList
 * 
 * This sample prints out a list of tasks if any are running
 * The sample display the tasks in the following format:
 * Operation:
 * Name:
 * Type:
 * State:
 * Error:
 * 
 * <b>Parameters:</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.general.TaskList --url [webserviceurl]
 * --username [username] --password [password]
 * </pre>
 */

public class TaskList {

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
   private static ManagedObjectReference propCollectorRef;
   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;
   private static final String SVC_INST_NAME = "ServiceInstance";

   private static String url;
   private static String userName;
   private static String password;
   private static boolean help = false;
   private static boolean isConnected = false;

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

   private static List<PropertyFilterSpec> createPFSForRecentTasks(
         ManagedObjectReference taskManagerRef) {
      PropertySpec pSpec = new PropertySpec();
      pSpec.setAll(Boolean.FALSE);
      pSpec.setType("Task");
      List<String> listofprop = new ArrayList<String>();
      listofprop.add("info.entity");
      listofprop.add("info.entityName");
      listofprop.add("info.name");
      listofprop.add("info.state");
      listofprop.add("info.cancelled");
      listofprop.add("info.error");
      pSpec.getPathSet().addAll(listofprop);

      ObjectSpec oSpec = new ObjectSpec();
      oSpec.setObj(taskManagerRef);
      oSpec.setSkip(Boolean.FALSE);

      TraversalSpec tSpec = new TraversalSpec();
      tSpec.setType("TaskManager");
      tSpec.setPath("recentTask");
      tSpec.setSkip(Boolean.FALSE);

      oSpec.getSelectSet().add(tSpec);

      PropertyFilterSpec pfSpec = new PropertyFilterSpec();
      pfSpec.getPropSet().add(pSpec);
      pfSpec.getObjectSet().add(oSpec);

      List<PropertyFilterSpec> result = new ArrayList<PropertyFilterSpec>();
      result.add(pfSpec);
      return result;
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

   private static void displayTasks(List<ObjectContent> oContents) {
      for (int oci = 0; oci < oContents.size(); ++oci) {
         System.out.println("Task");
         List<DynamicProperty> dplist = oContents.get(oci).getPropSet();

         if (dplist != null) {
            String op = "", name = "", type = "", state = "", error = "";
            for (int dpi = 0; dpi < dplist.size(); ++dpi) {
               DynamicProperty dp = dplist.get(dpi);
               if ("info.entity".equals(dp.getName())) {
                  type = ((ManagedObjectReference) dp.getVal()).getType();
               } else if ("info.entityName".equals(dp.getName())) {
                  name = ((String) dp.getVal());
               } else if ("info.name".equals(dp.getName())) {
                  op = ((String) dp.getVal());
               } else if ("info.state".equals(dp.getName())) {
                  TaskInfoState tis = (TaskInfoState) dp.getVal();
                  if (TaskInfoState.ERROR.equals(tis)) {
                     state = "-Error";
                  } else if (TaskInfoState.QUEUED.equals(tis)) {
                     state = "-Queued";
                  } else if (TaskInfoState.RUNNING.equals(tis)) {
                     state = "-Running";
                  } else if (TaskInfoState.SUCCESS.equals(tis)) {
                     state = "-Success";
                  }
               } else if ("info.cancelled".equals(dp.getName())) {
                  Boolean b = (Boolean) dp.getVal();
                  if (b != null && b.booleanValue()) {
                     state += "-Cancelled";
                  }
               } else if ("info.error".equals(dp.getName())) {
                  LocalizedMethodFault mf = (LocalizedMethodFault) dp.getVal();
                  if (mf != null) {
                     error = mf.getLocalizedMessage();
                  }
               } else {
                  op =
                        "Got unexpected property: " + dp.getName() + " Value: "
                              + dp.getVal().toString();
               }
            }
            System.out.println("Operation " + op);
            System.out.println("Name " + name);
            System.out.println("Type " + type);
            System.out.println("State " + state);
            System.out.println("Error " + error);
            System.out.println("======================");
         }
      }
      if (oContents.size() == 0) {
         System.out.println("Currently no task running");
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
            .println("This sample prints out a list of tasks if any are running");
      System.out
            .println("The sample display the tasks in the following format: ");
      System.out.println("Operation: ");
      System.out.println("Name: ");
      System.out.println("Type: ");
      System.out.println("State: ");
      System.out.println("Error: ");
      System.out.println("\nParameters:");
      System.out.println("url          [required] : url of the web service");
      System.out
            .println("username     [required] : username for the authentication");
      System.out
            .println("password     [required] : password for the authentication");
      System.out.println("\nCommand:");
      System.out
            .println("run.bat com.vmware.general.TaskList --url [webserviceurl] ");
      System.out.println("--username [username] --password [password] ");
   }

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         if (help) {
            printUsage();
            return;
         }
         connect();
         ManagedObjectReference taskManagerRef =
               serviceContent.getTaskManager();
         List<PropertyFilterSpec> listpfs =
               createPFSForRecentTasks(taskManagerRef);
         List<ObjectContent> listobjcont =
               retrievePropertiesAllObjects(listpfs);
         if (listobjcont != null) {
            displayTasks(listobjcont);
         } else {
            System.out.println("Currently no task running");
         }
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
