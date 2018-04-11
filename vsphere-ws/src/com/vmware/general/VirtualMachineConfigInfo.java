package com.vmware.general;

import com.vmware.vim25.*;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by zhujunlong on 2016/12/12.
 */
public class VirtualMachineConfigInfo {
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
    private static VimService vimService;
    private static VimPortType vimPort;
    private static ServiceContent serviceContent;

    private static String url;
    private static String userName;
    private static String password;
    private static boolean help = false;
    private static boolean isConnected = false;

    private static void trustAllHttpsCertificates() {
        try {
            // Create a trust manager that does not validate certificate chains
            javax.net.ssl.TrustManager[] trustAllCerts =
                    new javax.net.ssl.TrustManager[1];
            javax.net.ssl.TrustManager tm = new TrustAllTrustManager();
            trustAllCerts[0] = tm;
            javax.net.ssl.SSLContext sc =
                    javax.net.ssl.SSLContext.getInstance("SSL");
            javax.net.ssl.SSLSessionContext sslsc = sc.getServerSessionContext();
            sslsc.setSessionTimeout(0);
            sc.init(null, trustAllCerts, null);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc
                    .getSocketFactory());
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
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
     * Establishes session with the vCenter server.
     *
     * @throws RuntimeFaultFaultMsg
     * @throws InvalidLoginFaultMsg
     * @throws InvalidLocaleFaultMsg
     *
     * @throws Exception
     *            the exception
     */
    private static void connect() throws RuntimeFaultFaultMsg,
            InvalidLocaleFaultMsg, InvalidLoginFaultMsg {

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

    /**
     * Disconnects the user session.
     *
     * @throws RuntimeFaultFaultMsg
     *
     * @throws Exception
     */
    private static void disconnect() throws RuntimeFaultFaultMsg {
        if (isConnected) {
            vimPort.logout(serviceContent.getSessionManager());
        }
        isConnected = false;
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
    /**
     * Returns all the MOREFs of the specified type that are present under the
     * container
     *
     * @param folder
     *           {@link ManagedObjectReference} of the container to begin the
     *           search from
     * @param morefType
     *           Type of the managed entity that needs to be searched
     *
     * @return Map of name and MOREF of the managed objects present. If none
     *         exist then empty Map is returned
     *
     * @throws InvalidPropertyFaultMsg
     * @throws RuntimeFaultFaultMsg
     */
    private static Map<String, ManagedObjectReference> getMOREFsInContainerByType(
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

        RetrieveResult rslts =
                vimPort.retrievePropertiesEx(serviceContent.getPropertyCollector(),
                        propertyFilterSpecs, new RetrieveOptions());
        List<ObjectContent> listobjcontent = new ArrayList<ObjectContent>();
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
                    vimPort.continueRetrievePropertiesEx(
                            serviceContent.getPropertyCollector(), token);
            token = null;
            if (rslts != null) {
                token = rslts.getToken();
                if (rslts.getObjects() != null && !rslts.getObjects().isEmpty()) {
                    listobjcontent.addAll(rslts.getObjects());
                }
            }
        }
        for (ObjectContent oc : listobjcontent) {
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

        RetrieveResult rslts =
                vimPort.retrievePropertiesEx(serviceContent.getPropertyCollector(),
                        propertyFilterSpecs, new RetrieveOptions());
        List<ObjectContent> listobjcontent = new ArrayList<ObjectContent>();
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
                    vimPort.continueRetrievePropertiesEx(
                            serviceContent.getPropertyCollector(), token);
            token = null;
            if (rslts != null) {
                token = rslts.getToken();
                if (rslts.getObjects() != null && !rslts.getObjects().isEmpty()) {
                    listobjcontent.addAll(rslts.getObjects());
                }
            }
        }
        for (ObjectContent oc : listobjcontent) {
            List<DynamicProperty> dps = oc.getPropSet();
            if (dps != null) {
                for (DynamicProperty dp : dps) {
                    retVal.put(dp.getName(), dp.getVal());
                }
            }
        }
        return retVal;
    }

    private static void printUsage() {
        System.out.println("This sample simply connects "
                + "to an ESX server or to vCenter server");
        System.out.println("\nParameters:");
        System.out.println("url         [required] : url of the web service");
        System.out
                .println("username    [required] : username for the authentication");
        System.out
                .println("password    [required] : password for the authentication");
        System.out.println("\nCommand:");
        System.out
                .println("run.bat com.vmware.general.Connect --url [webserviceurl] "
                        + "--username [username] --password [password]");
    }

    public static void main(String[] args) {
        try {
            getConnectionParameters(args);
            if (help) {
                printUsage();
                return;
            }
            connect();
            ManagedObjectReference vmRef =
                    getMOREFsInContainerByType(serviceContent.getRootFolder(),
                            "VirtualMachine").get("backup-test");
            com.vmware.vim25.VirtualMachineConfigInfo vmConfigInfo =
                    (com.vmware.vim25.VirtualMachineConfigInfo) getEntityProps(vmRef,
                            new String[] { "config" }).get("config");
            System.out.println(vmConfigInfo.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            printUsage();
        } catch (SOAPFaultException sfe) {
            printSoapFaultException(sfe);
        } catch (Exception e) {
            System.out.println(" Connect Failed ");
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
