/* **********************************************************
 * Copyright 2012 VMware, Inc.  All rights reserved.
 *
 * VMware Confidential
 * **********************************************************/
package com.vmware.sso.client.samples;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TimeZone;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import org.oasis_open.docs.ws_sx.ws_trust._200512.LifetimeType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RenewingType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.AttributedDateTime;
import org.w3c.dom.Element;

import com.rsa.names._2009._12.product.riat.wsdl.STSService;
import com.rsa.names._2009._12.product.riat.wsdl.STSServicePortType;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.vmware.sso.client.soaphandlers.SSOHeaderHandler;
import com.vmware.sso.client.soaphandlers.SamlTokenExtractionHandler;
import com.vmware.sso.client.soaphandlers.SamlTokenHandler;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.soaphandlers.WsSecuritySignatureAssertionHandler;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;

/**
 * This sample illustrates acquiring a Holder-Of-Key token from SSO server by
 * passing an existing Holder-Of-Key token. This sample in turn uses the
 * {@link AcquireHoKTokenByUserCredentialSample} sample using the generated
 * key/certificate pair at the runtime to first acquire a Holder-Of-Key token,
 * which then is used to acquire another Holder-Of-Key token
 * 
 * <pre>
 * <b>Usage:</b>
 * run.bat com.vmware.sso.client.samples.AcquireHoKTokenByHoKTokenSample [sso url] [username] [password]
 * </pre>
 * 
 * @author Ecosystem Engineering
 */
public class AcquireHoKTokenByHoKTokenSample {

	/**
	 * @param ssoUrl
	 *            SSO server url e.g. https://[Host Name or IP
	 *            Address]:8444/ims/STSService
	 * @param token
	 *            An existing Holder-Of-Key token
	 * @param privateKey
	 *            {@link PrivateKey} of the user or solution
	 * @param userCert
	 *            {@link X509Certificate} certificate of the user or solution
	 * 
	 * @return A new Holder-Of-Key token
	 * 
	 * @throws DatatypeConfigurationException
	 */
	public static Element getToken(String ssoUrl, Element token,
			PrivateKey privateKey, X509Certificate userCert)
			throws DatatypeConfigurationException {

		/* Instantiating the STSService */
		STSService stsService = new STSService();

		/*
		 * Instantiating the HeaderHandlerResolver. This is required to provide
		 * the capability of modifying the SOAP headers and the SOAP message in
		 * general for various requests via the different handlers. For
		 * different kinds of requests to SSO server one needs to follow the
		 * WS-Trust guidelines to provide the required SOAP message structure.
		 */
		HeaderHandlerResolver headerResolver = new HeaderHandlerResolver();

		/*
		 * For this specific case we need the following header elements wrapped
		 * in the security tag.
		 * 
		 * 1. Timestamp containing the request's creation and expiry time
		 * 
		 * 2. Holder-Of-Key token to be used for issuing the new token
		 * 
		 * Once the above headers are added we need to sign the SOAP message
		 * using the combination of private key, certificate of the user or
		 * solution and the Holder-Of-Key token by adding a Signature element to
		 * the security header
		 */

		/* Adding the Timestamp via TimeStampHandler */
		headerResolver.addHandler(new TimeStampHandler());

		/* Adding the HoK SAML token in the header via SamlTokenHandler */
		SamlTokenHandler stHandler = new SamlTokenHandler(token);
		headerResolver.addHandler(stHandler);
		SamlTokenExtractionHandler sbHandler = new SamlTokenExtractionHandler();
		headerResolver.addHandler(sbHandler);
		/*
		 * Adding the handler for signing the message via
		 * WsSecuritySignatureAssertionHandler
		 */
		SSOHeaderHandler ssoHandler = new WsSecuritySignatureAssertionHandler(
				privateKey, userCert, Utils.getNodeProperty(token, "ID"));
		headerResolver.addHandler(ssoHandler);

		/*
		 * Set the handlerResolver for the STSService to the
		 * HeaderHandlerResolver created above
		 */
		stsService.setHandlerResolver(headerResolver);

		/*
		 * Retrieve the STSServicePort from the STSServicePortType object Note:
		 * All the required handlerResolvers need to be set in the
		 * STSServicePortType object before you retrieve the STSService instance
		 */
		STSServicePortType stsPort = stsService.getSTSServicePort();

		/*
		 * Construct the SOAP body for the request. RequestSecurityTokenType is
		 * the parameter type that is passed to the "acquire" method. However,
		 * based on what kind of token (bearer or holder-of-key type) and by
		 * what means (aka username/password, certificate, or existing token) we
		 * want to acquire the token, different elements need to be populated
		 */
		RequestSecurityTokenType tokenType = new RequestSecurityTokenType();

		/*
		 * For this request we need at least the following element in the
		 * RequestSecurityTokenType set
		 * 
		 * 1. Lifetime - represented by LifetimeType which specifies the
		 * lifetime for the token to be issued
		 * 
		 * 2. Tokentype - "urn:oasis:names:tc:SAML:2.0:assertion", which is the
		 * class that models the requested token
		 * 
		 * 3. RequestType -
		 * "http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue", as we want
		 * to get a token issued
		 * 
		 * 4. KeyType -
		 * "http://docs.oasis-open.org/ws-sx/ws-trust/200512/PublicKey",
		 * representing the holder-of-key kind of key the token will have. There
		 * are two options namely bearer and holder-of-key
		 * 
		 * 5. SignatureAlgorithm -
		 * "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256", representing the
		 * algorithm used for generating signature
		 * 
		 * 6. Renewing - represented by the RenewingType which specifies whether
		 * the token is renewable or not
		 */
		LifetimeType lifetime = new LifetimeType();
		DatatypeFactory dtFactory = DatatypeFactory.newInstance();
		GregorianCalendar cal = new GregorianCalendar(
				TimeZone.getTimeZone("GMT"));
		XMLGregorianCalendar xmlCalendar = dtFactory
				.newXMLGregorianCalendar(cal);
		AttributedDateTime created = new AttributedDateTime();
		created.setValue(xmlCalendar.toXMLFormat());

		AttributedDateTime expires = new AttributedDateTime();
		xmlCalendar.add(dtFactory.newDuration(30 * 60 * 1000));
		expires.setValue(xmlCalendar.toXMLFormat());

		lifetime.setCreated(created);
		lifetime.setExpires(expires);
		tokenType.setLifetime(lifetime);

		tokenType.setTokenType("urn:oasis:names:tc:SAML:2.0:assertion");
		tokenType
				.setRequestType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue");
		tokenType
				.setKeyType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/PublicKey");
		tokenType
				.setSignatureAlgorithm("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");

		RenewingType renewing = new RenewingType();
		renewing.setAllow(Boolean.FALSE);
		renewing.setOK(Boolean.FALSE); // WS-Trust Profile: MUST be set to false
		tokenType.setRenewing(renewing);

		/* Set the endpoint address for the request */
		Map<String, Object> reqContext = ((BindingProvider) stsPort)
				.getRequestContext();
		reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ssoUrl);

		/*
		 * Invoke the "issue" method on the STSService object to acquire the
		 * token from SSO Server
		 */
		stsPort.issue(tokenType);

		// SamlTokenExtractionHandler will now contain the raw SAML token for
		// further consumption
		return sbHandler.getToken();
	}

	private static void printUsage() {
		System.out
				.println("run.bat com.vmware.sso.client.samples.AcquireHoKTokenByHoKTokenSample [sso url] [username] [password]");
	}

	public static void main(String[] args)
			throws DatatypeConfigurationException {
		if (args.length < 3) {
			printUsage();
			return;
		}
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
		Utils.trustAllHttpsCertificates();
		System.out
				.println("Aquiring a HoK token by using another HoK token acquired "
						+ "using user credentials");
		/*
		 * Use the helper method generateKeyCertPair() of the SecurityUtil class
		 * to generate a pair of private key and public certificate on the fly.
		 */
		SecurityUtil userCert = SecurityUtil.generateKeyCertPair();

		/* Acquire a HoK token using username & password */
		Element token = AcquireHoKTokenByUserCredentialSample.getToken(args,
				userCert.getPrivateKey(), userCert.getUserCert());
		System.out.println("*****Original token issued*****");
		Utils.printToken(token);
		System.out.println("*****Additional token issued*****");
		Utils.printToken(getToken(args[0], token, userCert.getPrivateKey(),
				userCert.getUserCert()));
	}
}
