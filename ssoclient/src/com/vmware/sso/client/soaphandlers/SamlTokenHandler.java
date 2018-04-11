/* **********************************************************
 * Copyright 2012 VMware, Inc.  All rights reserved.
 *
 * VMware Confidential
 * **********************************************************/
package com.vmware.sso.client.soaphandlers;

import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

import com.vmware.sso.client.utils.Constants;
import com.vmware.sso.client.utils.Utils;

/**
 * Handler class to add the SAML token inside the security header
 * 
 * @author Ecosystem Engineering
 */
public class SamlTokenHandler extends SSOHeaderHandler {

	private final Node token;

	/**
	 * @param token
	 *            SAML token to be embedded
	 */
	public SamlTokenHandler(Node token) {
		if (!Utils.isSamlToken(token))
			throw new IllegalArgumentException(Constants.ERR_NOT_A_SAML_TOKEN);
		this.token = token;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext smc) {
		if (Utils.isOutgoingMessage(smc)) {
			try {
				Node securityNode = Utils.getSecurityElement(Utils
						.getSOAPHeader(smc));
				securityNode.appendChild(securityNode.getOwnerDocument()
						.importNode(token, true));
				// System.out.println(Constants.DBG_AFTER_ADDING_SAML_HEADER);
			} catch (DOMException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (SOAPException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		// Utils.printMessage(smc);
		return true;

	}
}
