package com.vmware.vsphere.soaphandlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.vmware.sso.client.soaphandlers.SSOHeaderHandler;

/**
 * Custom {@link Handler} to insert the cookie within the request headers
 */
public class HeaderCookieHandler extends SSOHeaderHandler {

	private final String _cookie;

	public HeaderCookieHandler(String cookie) {
		_cookie = cookie;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean outboundProperty = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (outboundProperty.booleanValue()) {
			@SuppressWarnings("unchecked")
			Map<String, List<String>> headers = (Map<String, List<String>>) context
					.get(MessageContext.HTTP_REQUEST_HEADERS);
			if (headers == null) {
				headers = new HashMap<String, List<String>>();
				List<String> cookieHeader = new ArrayList<String>();
				cookieHeader.add(_cookie);
				headers.put("Cookie", cookieHeader);
				context.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
			} else {
				List<String> value = new ArrayList<String>();
				value.add(_cookie);
				headers.put("Cookie", value);
			}
		}
		return true;
	}

}