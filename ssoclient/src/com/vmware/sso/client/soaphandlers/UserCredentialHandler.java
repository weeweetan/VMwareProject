/* **********************************************************
 * Copyright 2012 VMware, Inc.  All rights reserved.
 *
 * VMware Confidential
 * **********************************************************/
package com.vmware.sso.client.soaphandlers;

import javax.xml.bind.JAXBElement;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.AttributedString;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.PasswordString;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.UsernameTokenType;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

import com.vmware.sso.client.utils.Utils;

/**
 * Handler class to add the Username token element inside the security header
 * 
 * @author Ecosystem Engineering
 */
public class UserCredentialHandler extends SSOHeaderHandler {

	private final String userName;
	private final String passwd;

	/**
	 * @param username
	 *            Username to use
	 * @param password
	 *            Password to use
	 */
	public UserCredentialHandler(String username, String password) {
		this.userName = username;
		this.passwd = password;
	}

	/**
	 * Creates a WS-Security UsernameToken element.
	 * 
	 * @return UsernameToken
	 */
	private final JAXBElement<UsernameTokenType> createUsernameToken() {
		org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.ObjectFactory objFactory = new org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.ObjectFactory();

		UsernameTokenType userNameToken = objFactory.createUsernameTokenType();
		AttributedString user = objFactory.createAttributedString();
		user.setValue(userName.toString());
		userNameToken.setUsername(user);

		if (passwd != null) {
			// If the password is not specified (i.e. requesting a solution
			// token)
			// do not create the password element
			PasswordString pass = objFactory.createPasswordString();
			pass.setValue(passwd);

			userNameToken.setPassword(pass);
		}
		return objFactory.createUsernameToken(userNameToken);
	}

	@Override
	public boolean handleMessage(SOAPMessageContext smc) {
		if (Utils.isOutgoingMessage(smc)) {
			try {
				Node securityNode = Utils.getSecurityElement(Utils
						.getSOAPHeader(smc));
				Node usernameNode = Utils.marshallJaxbElement(
						createUsernameToken()).getDocumentElement();
				securityNode.appendChild(securityNode.getOwnerDocument()
						.importNode(usernameNode, true));
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
