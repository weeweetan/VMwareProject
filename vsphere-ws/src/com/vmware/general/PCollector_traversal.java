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
public class PCollector_traversal {
    private static void collectPropertites(VimPortType methods, ServiceContent sContent) throws Exception {

        ManagedObjectReference viewMgrRef = sContent.getViewManager();
        ManagedObjectReference propColl = sContent.getPropertyCollector();

        List<String> vmList = new ArrayList<String>();
        vmList.add("VirtualMachine");

        ManagedObjectReference cViewRef = methods.createContainerView(viewMgrRef, sContent.getRootFolder(), vmList, true);
        ObjectSpec oSpec = new ObjectSpec();
        oSpec.setObj(cViewRef);
        oSpec.setSkip(true);

        TraversalSpec tSpec = new TraversalSpec();
        tSpec.setName("traverseEntities");
        tSpec.setPath("view");
        tSpec.setSkip(false);
        tSpec.setType("ContainerView");

        oSpec.getSelectSet().add(tSpec);

        //extend from virtual machine to network
        TraversalSpec tSpecVmN = new TraversalSpec();
        tSpecVmN.setType("VirtualMachine");
        tSpecVmN.setPath("network");
        tSpecVmN.setSkip(false);

        //extend from virtual machine to resourcepool
        TraversalSpec tSpecVmRp = new TraversalSpec();
        tSpecVmRp.setType("VirtualMachine");
        tSpecVmRp.setPath("resourcePool");
        tSpecVmRp.setSkip(false);

        tSpec.getSelectSet().add(tSpecVmN);
        tSpec.getSelectSet().add(tSpecVmRp);

        PropertySpec pSpec = new PropertySpec();
        pSpec.setType("VirtualMachine");
        pSpec.getPathSet().add("name");

        PropertySpec pSpecNs = new PropertySpec();
        pSpecNs.setType("Network");
        pSpecNs.getPathSet().add("summary.accessible");

        PropertySpec pSpecRPr = new PropertySpec();
        pSpecRPr.setType("ResourcePool");
        pSpecRPr.getPathSet().add("runtime.cpu.maxUsage");
        pSpecRPr.getPathSet().add("runtime.memory.maxUsage");
        pSpecRPr.getPathSet().add("runtime.overallStatus");

        PropertyFilterSpec fSpec = new PropertyFilterSpec();
        fSpec.getObjectSet().add(oSpec);
        fSpec.getPropSet().add(pSpec);
        fSpec.getPropSet().add(pSpecNs);
        fSpec.getPropSet().add(pSpecRPr);

        List<PropertyFilterSpec> fSpecList = new ArrayList<PropertyFilterSpec>();
        fSpecList.add(fSpec);

        RetrieveOptions ro = new RetrieveOptions();
        RetrieveResult props = methods.retrievePropertiesEx(propColl, fSpecList, ro);

        if (props != null) {
            for (ObjectContent oc : props.getObjects()) {
                String value = null;
                String path = null;
                List<DynamicProperty> dps = oc.getPropSet();
                if (dps != null) {
                    for (DynamicProperty dp : dps) {
                        path = dp.getName();
                        if (path.equals("name")) {
                            value = (String) dp.getVal();
                        }
                        else if (path.equals("summary.accessible")) {
                            value = String.valueOf(dp.getVal());
                        }
                        else if (path.equals("summary.cpu.maxUsage")) {
                            value = String.valueOf(dp.getVal());
                        }
                        else if (path.equals("summary.memory.maxUsage")) {
                            value = String.valueOf(dp.getVal());
                        }
                        else if (path.equals("summary.overallStatus")) {
                            value = String.valueOf(dp.getVal());
                        }
                        System.out.println(path + " = " + value);
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

        Map<String, Object> ctxt = ((BindingProvider) vimPort).getRequestContext();
        ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

        serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF);
        vimPort.login(serviceContent.getSessionManager(), username, password, null);

        collectPropertites(vimPort, serviceContent);
        vimPort.logout(serviceContent.getSessionManager());
    }
}
