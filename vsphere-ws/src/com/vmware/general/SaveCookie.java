package com.vmware.general;

import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.vmware.sso.client.utils.TrustAllTrustManager;
import com.vmware.vim25.*;
import com.vmware.vsphere.soaphandlers.HeaderCookieExtractionHandler;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.HandlerResolver;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by zhujunlong on 2017/1/22.
 */
public class SaveCookie {
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
    public static void main(String[] args) throws RuntimeFaultFaultMsg {

        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String urlHostName, SSLSession session) {
                return true;
            }
        };
        trustAllHttpsCertificates();
        HttpsURLConnection.setDefaultHostnameVerifier(hv);

        VimService vimService = new VimService();
        HandlerResolver defaultHandler = vimService.getHandlerResolver();
        ManagedObjectReference SVC_INST_REF =  new ManagedObjectReference();
        SVC_INST_REF.setType("ServiceInstance");
        SVC_INST_REF.setValue("ServiceInstance");

        /**
         * Create a handler resolver.
         * Create a cookie extraction handler and add it to the handler resolver.
         * set the VIM service handler resolver.
         */
        HeaderCookieExtractionHandler cookieExtractor = new HeaderCookieExtractionHandler();
        HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
        handlerResolver.addHandler(cookieExtractor);
        vimService.setHandlerResolver(handlerResolver);

        /**
         * get the VIM port for access to vsphere API methods.This call clears
         * the request context
         */
        VimPortType vimPort  = vimService.getVimPort();

        /**
         * get the request context and set the connection endpoint.
         */
        Map<String, Object> ctxt = ((BindingProvider) vimPort).getRequestContext();
        ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://win-84q5r6msti1/sdk");
        ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

        /**
         * retrieve the ServiceContent. this call establishes the http connection.
         */
        ServiceContent serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF);

        /**
         * save the Http cookie
         */
        String cookie  = cookieExtractor.getCookie();
        System.out.println(cookie);
    }
}
