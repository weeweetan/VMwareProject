/* ***************************************************************************
 * Copyright 2011 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * ***************************************************************************/

package com.vmware.eam.sample.solution.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;

/**
 * Custom proxy selector used when this sample solution talks to both ESX Agent
 * Manager and the vCenter server. We need to login to vCenter server as an
 * extension and this means that vCenter needs to be able to see our certificate
 * we use for our connection. If we just connect to the vCenter server HTTPS
 * reverse proxy at https://<vcenter>/sdk, the certificate is not forwarded to
 * the vCenter server endpoint. We will get an HTTPS connection to the reverse
 * proxy, but the connection from the reverse proxy to vCenter will be HTTP.
 *
 * To handle this we need to tunnel all our traffic through the proxy server
 * when talking to vCenter.
 *
 * When talking to the ESX Agent Manager we don't need to tunnel the traffic
 * through the proxy.
 */
public class CustomProxySelector extends ProxySelector {

   private final String _host;
   private final int _port;

   public CustomProxySelector(String host, int port) {
      _host = host;
      _port = port;
   }

   @Override
   public java.util.List<Proxy> select(URI uri) {
      if (VimConnection.SDK_URI.equals(uri.toString())) {
         // We talk to the vCenter server.
         return Collections.singletonList(new Proxy(Proxy.Type.HTTP,
                                                    new InetSocketAddress(_host, _port)));
      } else {
         // We talk to the ESX Agent Manager.
         return Collections.singletonList(Proxy.NO_PROXY);
      }
   }

   /**
    * @see ProxySelector#connectFailed(URI,
    *      SocketAddress, IOException)
    */
   @Override
   public void connectFailed(URI paramURI,
                             SocketAddress paramSocketAddress,
                             IOException paramIOException) {
      // do nothing.
   }
}
