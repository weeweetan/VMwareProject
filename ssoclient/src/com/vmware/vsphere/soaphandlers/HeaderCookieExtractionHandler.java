package com.vmware.vsphere.soaphandlers;

import java.util.List;
import java.util.Map;

import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.vmware.sso.client.soaphandlers.SSOHeaderHandler;

public class HeaderCookieExtractionHandler extends SSOHeaderHandler {

	private String extractedCookie;

	@Override
	public boolean handleMessage(SOAPMessageContext smc) {
		Boolean outboundProperty = (Boolean) smc
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		// Only interested in the Response
		if (!outboundProperty.booleanValue()) {
			@SuppressWarnings("unchecked")
			Map<String, List<String>> headers = (Map<String, List<String>>) smc
					.get(MessageContext.HTTP_RESPONSE_HEADERS);
			if (headers != null) {
				// This cookie is present only in the first response
				List<String> cookieVal = headers.get("Set-cookie");
				if (cookieVal != null)
					extractedCookie = cookieVal.get(0);
			}
		}
		return true;
	}

	public String getCookie() {
		return extractedCookie;
	}
}
