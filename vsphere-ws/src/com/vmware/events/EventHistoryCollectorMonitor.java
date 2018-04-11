package com.vmware.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.ArrayOfEvent;
import com.vmware.vim25.Event;
import com.vmware.vim25.EventFilterSpec;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

/**
 * <pre>
 * EventHistoryCollectorMonitor
 * 
 * This sample demonstrates how to create and monitor an EventHistoryCollector
 * This sample uses the latestPage property of the EventHistoryCollector
 * to filter the Events
 * 
 * <b>Parameters:</b>
 * url            [required] : url of the web service
 * username       [required] : username for the authentication
 * password       [required] : password for the authentication
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.vm.EventHistoryCollectorMonitor
 * --url [webserviceurl] --username [username] --password [password]
 * </pre>
 */

public class EventHistoryCollectorMonitor {

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
   private static ManagedObjectReference propCollector;
   private static ManagedObjectReference eventHistoryCollector;
   private static ManagedObjectReference eventManager;
   private static VimService vimService;
   private static VimPortType vimPort;
   private static ServiceContent serviceContent;
   private static final String SVC_INST_NAME = "ServiceInstance";

   private static String url;
   private static String userName;
   private static String password;
   private static boolean help;
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
         } else {
            throw new IllegalArgumentException("Expected --url, --username,"
                  + " --password arguments.");
         }
         val = "";
         ai += 2;
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

      propCollector = serviceContent.getPropertyCollector();
   }

   private static void disconnect() throws Exception {
      if (isConnected) {
         vimPort.logout(serviceContent.getSessionManager());
      }
      isConnected = false;
   }

   private static void initEventManagerRef() {
      if (serviceContent != null) {
         eventManager = serviceContent.getEventManager();
      }
   }

   private static void createEventHistoryCollector() throws Exception {
      EventFilterSpec eventFilter = new EventFilterSpec();
      eventHistoryCollector =
            vimPort.createCollectorForEvents(eventManager, eventFilter);
   }

   private static PropertyFilterSpec createEventFilterSpec() {
      PropertySpec propSpec = new PropertySpec();
      propSpec.setAll(new Boolean(false));
      propSpec.getPathSet().add("latestPage");
      propSpec.setType(eventHistoryCollector.getType());

      ObjectSpec objSpec = new ObjectSpec();
      objSpec.setObj(eventHistoryCollector);
      objSpec.setSkip(new Boolean(false));

      PropertyFilterSpec spec = new PropertyFilterSpec();
      spec.getPropSet().add(propSpec);
      spec.getObjectSet().add(objSpec);
      return spec;
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
         System.out.println(" : Failed Getting Contents");
         e.printStackTrace();
      }

      return listobjcontent;
   }

   private static void monitorEvents(PropertyFilterSpec spec) throws Exception {
      ArrayList<PropertyFilterSpec> listpfs =
            new ArrayList<PropertyFilterSpec>();
      listpfs.add(spec);
      List<ObjectContent> listobjcont = retrievePropertiesAllObjects(listpfs);
      if (listobjcont != null) {
         ObjectContent oc = listobjcont.get(0);
         ArrayOfEvent arrayEvents =
               (ArrayOfEvent) (oc.getPropSet().get(0)).getVal();

         ArrayList<Event> eventList = (ArrayList<Event>) arrayEvents.getEvent();
         System.out.println("Events In the latestPage are: ");
         for (int i = 0; i < eventList.size(); i++) {
            Event anEvent = eventList.get(i);
            System.out.println("Event: " + anEvent.getClass().getName());
         }
      } else {
         System.out.println("No Events retrieved!");
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
            .println("This sample demonstrates how to create and monitor an "
                  + " EventHistoryCollector");
      System.out.println("This sample uses the latestPage property of"
            + " the EventHistoryCollector to filter the Events");
      System.out.println("\nParameters:");
      System.out.println("url            [required] : url of the web service");
      System.out
            .println("username       [required] : username for the authentication");
      System.out
            .println("password       [required] : password for the authentication");
      System.out.println("\nCommand:");
      System.out
            .println("run.bat com.vmware.events.EventHistoryCollectorMonitor"
                  + " --url [webserviceurl] --username [username] --password [password]");
   }

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         if (help) {
            printUsage();
            return;
         }
         connect();
         initEventManagerRef();
         createEventHistoryCollector();
         PropertyFilterSpec eventFilterSpec = createEventFilterSpec();
         monitorEvents(eventFilterSpec);
      } catch (IllegalArgumentException iae) {
         printUsage();
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         System.out.println("Failed to Monitor Event History - "
               + e.getMessage());
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
