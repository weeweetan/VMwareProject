package com.vmware.general;


import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;

import javax.net.ssl.*;
import javax.xml.ws.BindingProvider;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

public class TestClient {
    //Authentication  is  handled  by  using  a  TrustManager  and  supplying  a  host  verifier
    //method.(The host name verifier(֤����) is declared in the main function
    private static class TrustAllTrustManager implements TrustManager,X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers(){
            return null;
        }
        public Boolean isServerTrusted(X509Certificate[] certs){
            return true;
        }
        public Boolean isClientTrusted(X509Certificate[] certs){
            return true;
        }
        public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException{
            return;
        }
        public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException{
            return;
        }

    }

    public static void main(String[] args){
        try {
            String servername = args[0];
            String username = args[1];
            String password = args[2];
            String url  = "https://" + servername + "/sdk/vimService";

            //Variables of the following types for access to the API methods
            //and to the vSphere inventory.
            //ManagedObjectReference for the ServiceInstance on the Server
            //VimService for access to the vSphere Web Service
            //VimPortType for access to methods
            //ServiceContent for access to managed object services
            ManagedObjectReference SVC_INST_REF = new ManagedObjectReference();
            VimService vimService;
            VimPortType vimPort;
            ServiceContent serviceContent;

            //Declare a host name verifier that will automatically enable
            //the connection.The host name verifier is involved during the SSL handshake(����)
            HostnameVerifier hv = new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            };

            //Create the trust manager.
            TrustManager[] trustAllCerts = new TrustManager[1];
            TrustManager tm = new TrustAllTrustManager();
            trustAllCerts[0] = tm;

            //Create ths SSL context.
            SSLContext sc = SSLContext.getInstance("SSL");

            //Create ths session context.
            SSLSessionContext sslsc = sc.getServerSessionContext();

            //Initialize the contexts; the session context takes the trust manager.
            sslsc.setSessionTimeout(0);

            sc.init(null, trustAllCerts,null);

            //Use the default socket factory to create the socket for the secure connection
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            //Set the default host name verifier to enable the connection
            HttpsURLConnection.setDefaultHostnameVerifier(hv);

            //Set up the manufactured managed object reference for the ServiceInstance
            SVC_INST_REF.setType("ServiceInstance");
            SVC_INST_REF.setValue("ServiceInstance");

            //Create a VimService object to obtain a VimPort binding provider
            //The BindingProvider provides access to the protocol fields
            //in request/response messages.Retrieve the request context
            //which will be used for processing message requests.
            vimService = new VimService();
            vimPort = vimService.getVimPort();
            Map<String, Object> ctxt = ((BindingProvider)vimPort).getRequestContext();

            //Store the Server URL  in the request context and specify true
            //to maintain the connection between the client and server.
            //The client API will include the Server�� s HTTP cookie in its
            //requests to maintain the session.if you do not set this to true, the Server will start
            //a new session with each request.
            ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,url);
            ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY,true);

            //Retrieve the ServiceContent object and login
            serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF);
            vimPort.login(serviceContent.getSessionManager(),username,password,null);

            //print out the product name,server type ,and product version
            System.out.println(serviceContent.getAbout().getFullName());
            System.out.println("Server type is " + serviceContent.getAbout().getApiType());
            System.out.println("API version is " + serviceContent.getAbout().getVersion());

            //close the connection
            vimPort.logout(serviceContent.getSessionManager());
        }catch (Exception e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }
}
