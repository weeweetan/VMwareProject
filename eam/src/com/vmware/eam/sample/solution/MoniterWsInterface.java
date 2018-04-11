package com.vmware.eam.sample.solution;

import com.vmware.vsphere.ManagedObjectReference;
import com.vmware.vsphere.ServiceContent;
import com.vmware.vsphere.VimPortType;
import com.vmware.vsphere.VimService;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.Map;

/**
 * Created by zhujunlong on 2016/11/8.
 */
public class MoniterWsInterface
{
    private static String url;
    private static String userName;
    private static String password;

    private static final ManagedObjectReference SVC_INST_REF = new ManagedObjectReference();
    private static VimService vimService;
    private static VimPortType vimPort;

    private static ServiceContent serviceContent;
    private static final String SVC_INST_NAME = "ServiceInstance";
    private static Boolean isConnected = false;
    private static ManagedObjectReference perfManager;
    private static ManagedObjectReference propCollectorRef;

    public MoniterWsInterface(String puserName, String ppassWord, String purl)
    {
        url = purl;
        userName = puserName;
        password = ppassWord;
    }

    private static class TrustAllTrustManager implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager
    {
        public java.security.cert.X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }

        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs)
        {
            return true;
        }

        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs)
        {
            return true;
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException
        {
            return;
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException
        {
            return;
        }
    }

    private static void trustAllHttpsCertificates() throws Exception
    {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new TrustAllTrustManager();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        javax.net.ssl.SSLSessionContext sslsc = sc.getServerSessionContext();
        sslsc.setSessionTimeout(0);
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    public static void connect() throws Exception
    {
        HostnameVerifier hv = new HostnameVerifier()
        {
            public boolean verify(String urlHostName, SSLSession session)
            {
                return true;
            }
        };
        trustAllHttpsCertificates();

        HttpsURLConnection.setDefaultHostnameVerifier(hv);

        SVC_INST_REF.setType(SVC_INST_NAME);
        SVC_INST_REF.setValue(SVC_INST_NAME);

        vimService = new VimService();
        vimPort = vimService.getVimPort();
        Map<String, Object> ctxt = ((BindingProvider) vimPort).getRequestContext();

        ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

        serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF);
        vimPort.login(serviceContent.getSessionManager(), userName, password, null);
        isConnected = true;

        perfManager = serviceContent.getPerfManager();
        propCollectorRef = serviceContent.getPropertyCollector();
    }

    public static void disconnect() throws Exception
    {
        if (isConnected)
        {
            vimPort.logout(serviceContent.getSessionManager());
        }
        isConnected = false;
    }

    private static void printSoapFaultException(SOAPFaultException sfe)
    {
        System.out.println("Soap fault: ");
        if (sfe.getFault().hasDetail())
        {
            System.out.println(sfe.getFault().getDetail().getFirstChild().getLocalName());
        }
        if (sfe.getFault().getFaultString() != null)
        {
            System.out.println("Message: " + sfe.getFault().getFaultString());
        }
    }
    public static void main(String[] args)
    {
        new MoniterWsInterface("192.168.17.152", "WIN-84Q5R6MSTI1\\Administrator", "jcb410.");
        try
        {
            connect();
        }
        catch (SOAPFaultException sfe)
        {
            printSoapFaultException(sfe);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                disconnect();
            }
            catch (SOAPFaultException sfe)
            {
                printSoapFaultException(sfe);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
