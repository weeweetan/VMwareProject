/* **********************************************************
 * Copyright 2012 VMware, Inc.  All rights reserved.
 *
 * VMware Confidential
 * **********************************************************/
package com.vmware.sso.client.wssecurity;

import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.UUID;

import javax.xml.bind.DatatypeConverter;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.oasis_open.docs.ws_sx.ws_trust._200512.UseKeyType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.BinarySecurityTokenType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.ReferenceType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.SecurityTokenReferenceType;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.vmware.sso.client.utils.Constants;
import com.vmware.sso.client.utils.Utils;

public class WsSecuritySignatureCertificate extends WsSecuritySignatureImpl {

	public WsSecuritySignatureCertificate(PrivateKey privateKey,
			X509Certificate userCert) {
		super(privateKey, userCert);
	}

	@Override
	protected String addUseKeySignatureId(SOAPMessage message) {
		String sigId = UUID.randomUUID().toString();
		try {
			message.getSOAPBody().appendChild(
							message.getSOAPPart().importNode(
									createUseKeyElement(sigId), true /* deep */));
		} catch (DOMException e) {
			System.out.println(Constants.ERR_CREATING_USE_KEY_ELEMENT);
			e.printStackTrace();
			throw new RuntimeException(Constants.ERR_CREATING_USE_KEY_ELEMENT,
					e);
		} catch (SOAPException e) {
			System.out.println(Constants.ERR_CREATING_USE_KEY_ELEMENT);
			e.printStackTrace();
			throw new RuntimeException(Constants.ERR_CREATING_USE_KEY_ELEMENT,
					e);
		}
		return sigId;
	}

	@Override
	protected Node createKeyInfoContent(SOAPMessage message) {

		String bstId = UUID.randomUUID().toString();

		// insert BinarySecurityToken in the Security header
		NodeList secNodeList = message.getSOAPPart().getElementsByTagNameNS(
				Constants.WSSE_NAMESPACE, Constants.SECURITY_ELEMENT);
		if (secNodeList.getLength() != 1) {
			throw new RuntimeException("No/too many security elements found");
		}
		secNodeList.item(0).appendChild(
				message.getSOAPPart().importNode(
						createBinarySecurityToken(bstId), true /* deep */));

		return createSecurityTokenReference(bstId);
	}

	/**
	 * Creates UseKey element. It points to confirmation certificate used for
	 * signing the signature. This certificate will be embedded in the requested
	 * token as confirmation data.
	 * 
	 * @param sigId
	 *            the signature element id
	 * @return
	 */
	private Node createUseKeyElement(String sigId) {
		org.oasis_open.docs.ws_sx.ws_trust._200512.ObjectFactory wstFactory = new org.oasis_open.docs.ws_sx.ws_trust._200512.ObjectFactory();
		UseKeyType useKey = wstFactory.createUseKeyType();
		useKey.setSig(sigId);
		return Utils.marshallJaxbElement(wstFactory.createUseKey(useKey))
				.getFirstChild();
	}

	/**
	 * Creates a BinarySecurityToken element and sets its value to the base64
	 * encoded version of the holder-of-key certificate
	 * 
	 * @return BST element Id
	 */
	private Node createBinarySecurityToken(String uuid) {
		org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.ObjectFactory secExtFactory = new org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.ObjectFactory();
		BinarySecurityTokenType bst = secExtFactory
				.createBinarySecurityTokenType();
		try {

			bst.setValue(DatatypeConverter.printBase64Binary(getUserCert()
					.getEncoded()));
		} catch (CertificateEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(
					Constants.ERROR_CREATING_BINARY_SECURITY_TOKEN, e);
		}

		bst.setValueType(Constants.X509_CERTIFICATE_TYPE);
		bst.setEncodingType(Constants.ENCODING_TYPE_BASE64);
		bst.setId(uuid);
		return Utils.marshallJaxbElement(
				secExtFactory.createBinarySecurityToken(bst)).getFirstChild();
	}

	/**
	 * Creates SecurityTokenReference element that points to the refId
	 * parameter.
	 * 
	 * @param refId
	 *            the reference to which this element points
	 * 
	 * @return Node
	 */
	private Node createSecurityTokenReference(String refId) {
		org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.ObjectFactory secExtFactory = new org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.ObjectFactory();
		SecurityTokenReferenceType stRef = secExtFactory
				.createSecurityTokenReferenceType();
		ReferenceType ref = secExtFactory.createReferenceType();
		ref.setURI("#" + refId);
		ref.setValueType(Constants.X509_CERTIFICATE_TYPE);
		stRef.getAny().add(secExtFactory.createReference(ref));
		return Utils.marshallJaxbElement(
				secExtFactory.createSecurityTokenReference(stRef))
				.getFirstChild();
	}

}
