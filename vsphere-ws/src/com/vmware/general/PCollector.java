package com.vmware.general;

import com.vmware.vim25.*;

import javax.net.ssl.*;
import javax.xml.ws.BindingProvider;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhujunlong on 2017/1/23.
 */
public class PCollector {
    private static void collectProperties(VimPortType methods, ServiceContent sContent) throws Exception {
        //get references to the ViewManager and PropertyCollector
        ManagedObjectReference viewMgrRef = sContent.getViewManager();
        ManagedObjectReference propcoll = sContent.getPropertyCollector();

        //use a container view for virtual machines to define the traversal
        //- invoke the VimPortType method createContainerView (corresponds
        //to the ViewManager method) -pass the viewManager Mor and
        //- createContainerView takes a string[] for the type parameter;
        //declare an arraylist and add the type string to it
        List<String> vmList = new ArrayList<String>();
        vmList.add("VirtualMachine");

        ManagedObjectReference cViewRef = methods.createContainerView(viewMgrRef,
                sContent.getRootFolder(),
                vmList,
                true);

        //create an object spec to define the beginning of the traversal;
        //container view is the root object for this traversal
        ObjectSpec oSpec = new ObjectSpec();
        oSpec.setObj(cViewRef);
        oSpec.setSkip(true);

        // create a traversal spec to select all objects in the view
        TraversalSpec tSpec = new TraversalSpec();
        tSpec.setName("traverseEntities");
        tSpec.setPath("view");
        tSpec.setSkip(false);
        tSpec.setType("ContainerView");

        //add the traversal spec to the object spec;
        //the accessor method (getSelectSet) returns a reference
        //to the mapped XML representation of the list; using this
        //reference to add the spec will update the list
        oSpec.getSelectSet().add(tSpec);

        //specify the property for retrieval (virtual machine name)
        PropertySpec pSpec = new PropertySpec();
        pSpec.setType("VirtualMachine");
        pSpec.getPathSet().add("name");

        //create a PropertyFilterSpec and add the object and
        //property specs to it; use the getter method to reference
        //the mapped XML representation of the lists and the specs
        //directly to the list
        PropertyFilterSpec fSpec = new PropertyFilterSpec();
        fSpec.getObjectSet().add(oSpec);
        fSpec.getPropSet().add(pSpec);

        //create a list for the filters and add the spec to it
        List<PropertyFilterSpec> fSpecList = new ArrayList<PropertyFilterSpec>();
        fSpecList.add(fSpec);

        //get the data from the server
        RetrieveOptions ro = new RetrieveOptions();
        RetrieveResult props = methods.retrievePropertiesEx(propcoll, fSpecList, ro);
        //go through the returned list and print out the data
        if (props != null) {
            for (ObjectContent oc : props.getObjects()) {
                String vmName = null;
                String path = null;
                List<DynamicProperty> dps = oc.getPropSet();
                if (dps != null) {
                    for (DynamicProperty dp : dps) {
                        vmName = (String)dp.getVal();
                        path = dp.getName();
                        System.out.println(path + " = " + vmName);
                    }
                }
            }
        }
    }

    private static class TrustAllManager implements TrustManager, X509TrustManager {

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType)
            throws CertificateException {
            return;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType)
            throws CertificateException {
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        String serverName = "win-84q5r6msti1";
        String username = "WIN-84Q5R6MSTI1\\Administrator";
        String password = "jcb410.";
        String url = "https://" + serverName + "/sdk/vimService";

        ManagedObjectReference SVC_INST_REF = new ManagedObjectReference();
        VimService vimService;
        VimPortType vimPort;
        ServiceContent serviceContent;

        //declare a host name vertifier that will automatically enable
        //the connection. the host name verifier is invoked during
        //the ssl handshake.
        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        };

        //create the trust manager
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager tm = new TrustAllManager();
        trustAllCerts[0] = tm;

        //create the ssl context
        SSLContext sc = SSLContext.getInstance("SSL");

        //create the session context
        SSLSessionContext sslsc = sc.getServerSessionContext();

        //initialize the contexts; the session context takes the trus manager.
        sslsc.setSessionTimeout(0);
        sc.init(null, trustAllCerts, null);

        //use the default socket factory to create the socket for the secure connection
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        //set the default name verifier to enable the connection.
        HttpsURLConnection.setDefaultHostnameVerifier(hv);

        //set up the manufactured managed object reference for the ServiceInstance
        SVC_INST_REF.setType("ServiceInstance");
        SVC_INST_REF.setValue("ServiceInstance");

        vimService = new VimService();
        vimPort = vimService.getVimPort();

        Map<String, Object> ctxt = ((BindingProvider)vimPort).getRequestContext();
        ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

        serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF);
        vimPort.login(serviceContent.getSessionManager(), username, password, null);

        collectProperties(vimPort, serviceContent);
        vimPort.logout(serviceContent.getSessionManager());

    }
}
