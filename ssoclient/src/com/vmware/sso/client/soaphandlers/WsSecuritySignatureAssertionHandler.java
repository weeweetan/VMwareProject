/* **********************************************************
 * Copyright 2012 VMware, Inc.  All rights reserved.
 *
 * VMware Confidential
 * **********************************************************/
package com.vmware.sso.client.soaphandlers;

import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.X509Certificate;

import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.vmware.sso.client.utils.Utils;
import com.vmware.sso.client.wssecurity.WsSecuritySignatureAssertion;

/**
 * Handler class to sign the SOAP message using the assertionId of the SAML
 * token along with the private key and certificate of the user / solution This
 * handler is to be used only when acquiring a new token using an existing token
 * 
 * @author Ecosystem Engineering
 */
public class WsSecuritySignatureAssertionHandler extends SSOHeaderHandler {
	private final String _assertionId;
	private final PrivateKey _privateKey;
	private final X509Certificate _userCert;

	public WsSecuritySignatureAssertionHandler(PrivateKey privateKey,
			X509Certificate userCert, String assertionId) {
		_privateKey = privateKey;
		_userCert = userCert;
		_assertionId = assertionId;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext smc) {
		// At this stage the raw SOAPMessage is created and now we need to sign
		// the message using the private key and the certificate provided by the
		// user.
		if (Utils.isOutgoingMessage(smc)) {
			WsSecuritySignatureAssertion wsSign = new WsSecuritySignatureAssertion(
					_privateKey, _userCert, _assertionId);
			try {
				wsSign.sign(smc.getMessage());
			} catch (SignatureException e) {
				System.out
						.println("Could not sign the SOAPMessage - SignatureException");
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (SOAPException e) {
				System.out
						.println("Could not sign the SOAPMessage - SOAPException");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return true;
	}

}
