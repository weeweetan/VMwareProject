package com.vmware.events;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import com.vmware.vim25.ArrayOfEventDescriptionEventDetail;
import com.vmware.vim25.Event;
import com.vmware.vim25.EventDescriptionEventDetail;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.UserLoginSessionEvent;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vim25.VmPoweredOnEvent;
import com.vmware.vim25.VmRenamedEvent;

/**
 * <pre>
 * EventFormat
 * 
 * This sample retrieves and formats the lastEvent from Hostd or Vpxd
 * 
 * <b>Parameters:</b>
 * url          [required] : url of the web service.
 * username     [required] : username for the authentication.
 * password     [required] : password for the authentication
 * 
 * <b>Command Line:</b>
 * run.bat com.vmware.events.EventFormat --url [webserviceurl]
 * --username [username] --password [password]
 * </pre>
 */
public class EventFormat {

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
   private static ManagedObjectReference propCollectorRef = null;

   /**
    * Connection input parameters.
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
         } else {
            throw new IllegalArgumentException("Expected --url, --username,"
                  + " --password arguments.");
         }
         val = "";
         ai += 2;
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

   /* End Server Connection and common code */

   /* Start Sample functional code */

   private static ManagedObjectReference eventManagerRef = null;

   private static void initEventManagerRef() {
      if (serviceContent != null) {
         eventManagerRef = serviceContent.getEventManager();
         System.out.println("EV Man Val " + eventManagerRef.getValue());
      }
   }

   /**
    * Creates the event filter Spec.
    * 
    * @return the PropertyFilterSpec
    */
   private static PropertyFilterSpec createEventFilterSpec(String name) {
      PropertySpec propSpec = new PropertySpec();
      propSpec.setAll(new Boolean(false));
      propSpec.getPathSet().add(name);
      propSpec.setType(eventManagerRef.getType());

      ObjectSpec objSpec = new ObjectSpec();
      objSpec.setObj(eventManagerRef);
      objSpec.setSkip(new Boolean(false));

      PropertyFilterSpec spec = new PropertyFilterSpec();
      spec.getPropSet().add(propSpec);
      spec.getObjectSet().add(objSpec);
      return spec;
   }

   private static void formatLatestEvent() throws Exception {
      try {
         ArrayList<PropertyFilterSpec> listpfs =
               new ArrayList<PropertyFilterSpec>();
         listpfs.add(createEventFilterSpec("description.eventInfo"));
         List<ObjectContent> listobjcont =
               retrievePropertiesAllObjects(listpfs);
         if (listobjcont != null) {
            ArrayOfEventDescriptionEventDetail arrayEventDetails =
                  (ArrayOfEventDescriptionEventDetail) listobjcont.get(0)
                        .getPropSet().get(0).getVal();
            List<EventDescriptionEventDetail> eventDetails =
                  arrayEventDetails.getEventDescriptionEventDetail();
            Hashtable<String, EventDescriptionEventDetail> eventDetail =
                  new Hashtable<String, EventDescriptionEventDetail>();
            for (EventDescriptionEventDetail ed : eventDetails) {
               eventDetail.put(ed.getKey(), ed);
            }
            ArrayList<PropertyFilterSpec> listpfsevent =
                  new ArrayList<PropertyFilterSpec>();
            listpfsevent.add(createEventFilterSpec("latestEvent"));
            List<ObjectContent> listobjcontevent =
                  retrievePropertiesAllObjects(listpfsevent);
            if (listobjcontevent != null) {
               Event anEvent =
                     (Event) listobjcontevent.get(0).getPropSet().get(0)
                           .getVal();

               // Get the 'latestEvent' property of the EventManager
               System.out.println("The latestEvent was : "
                     + anEvent.getClass().getName());
               formatEvent(0, eventDetail, anEvent);
               formatEvent(1, eventDetail, anEvent);
               formatEvent(2, eventDetail, anEvent);
               formatEvent(3, eventDetail, anEvent);
               formatEvent(4, eventDetail, anEvent);
            }
         } else {
            System.out.println("No Events retrieved!");
         }
      } catch (SOAPFaultException sfe) {
         printSoapFaultException(sfe);
      } catch (Exception e) {
         throw e;
      }
   }

   private static void formatEvent(int fType,
         Hashtable<String, EventDescriptionEventDetail> eventDetail,
         Event theEvent) {
      String typeName = theEvent.getClass().getName();
      // Remove package information...
      int lastDot = typeName.lastIndexOf('.');
      if (lastDot != -1) {
         typeName = typeName.substring(lastDot + 1);
      }
      EventDescriptionEventDetail detail = eventDetail.get(typeName);
      // Determine format string
      String format = detail.getFullFormat();
      switch (fType) {
      case 2:
         format = detail.getFormatOnComputeResource();
         break;
      case 3:
         format = detail.getFormatOnDatacenter();
         break;
      case 1:
         format = detail.getFormatOnHost();
         break;
      case 0:
         format = detail.getFormatOnVm();
         break;
      case 4:
         format = detail.getFullFormat();
         break;
      }
      String ret = "";
      if ("VmPoweredOnEvent".equals(typeName)) {
         ret = replaceText(format, (VmPoweredOnEvent) theEvent);
         if (ret != null) {
            System.out.println(ret);
         }
      } else if ("VmRenamedEvent".equals(typeName)) {
         ret = replaceText(format, (VmRenamedEvent) theEvent);
         if (ret != null) {
            System.out.println(ret);
         }
      } else if ("UserLoginSessionEvent".equals(typeName)) {
         ret = replaceText(format, (UserLoginSessionEvent) theEvent);
         if (ret != null) {
            System.out.println(ret);
         }
      } else {
         // Try generic, if all values are replaced by base type
         // return that, else return fullFormattedMessage;
         ret = replaceText(format, theEvent);
         if (ret.length() == 0 || ret.indexOf("{") != -1) {
            ret = theEvent.getFullFormattedMessage();
         }
         if (ret != null) {
            System.out.println(ret);
         }
      }
   }

   private static String replaceText(String format,
         UserLoginSessionEvent theEvent) {
      // Do base first
      format = replaceText(format, (Event) theEvent);
      // Then specific values
      format = format.replaceAll("\\{ipAddress\\}", theEvent.getIpAddress());
      return format;
   }

   private static String replaceText(String format, VmPoweredOnEvent theEvent) {
      // Same as base type
      return replaceText(format, (Event) theEvent);
   }

   private static String replaceText(String format, VmRenamedEvent theEvent) {
      // Do base first
      format = replaceText(format, (Event) theEvent);
      // Then specific values
      format = format.replaceAll("\\{oldName\\}", theEvent.getOldName());
      format = format.replaceAll("\\{newName\\}", theEvent.getNewName());
      return format;
   }

   private static String replaceText(String format, Event theEvent) {
      format = format.replaceAll("\\{userName\\}", theEvent.getUserName());
      if (theEvent.getComputeResource() != null) {
         format =
               format.replaceAll("\\{computeResource.name\\}", theEvent
                     .getComputeResource().getName());
      }
      if (theEvent.getDatacenter() != null) {
         format =
               format.replaceAll("\\{datacenter.name\\}", theEvent
                     .getDatacenter().getName());
      }
      if (theEvent.getHost() != null) {
         format =
               format.replaceAll("\\{host.name\\}", theEvent.getHost()
                     .getName());
      }
      if (theEvent.getVm() != null) {
         format =
               format.replaceAll("\\{vm.name\\}", theEvent.getVm().getName());
      }
      return format;
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
      System.out.println("This sample retrieves and formats"
            + " the lastEvent from Hostd or Vpxd");
      System.out.println("\nParameters:");
      System.out.println("url          [required] : url of the web service.");
      System.out
            .println("username     [required] : username for the authentication.");
      System.out
            .println("password     [required]:  password for the authentication");
      System.out.println("\nCommand:");
      System.out.println("run.bat com.vmware.events.EventFormat --url "
            + "[webserviceurl] --username [username] --password [password] ");
   }

   /* End Sample functional code */

   public static void main(String[] args) {
      try {
         getConnectionParameters(args);
         if (help) {
            printUsage();
            return;
         }
         connect();
         initEventManagerRef();
         formatLatestEvent();
      } catch (IllegalArgumentException iae) {
         System.out.println(iae.getMessage());
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