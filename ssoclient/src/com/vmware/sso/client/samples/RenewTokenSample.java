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
import org.oasis_open.docs.ws_sx.ws_trust._200512.RenewTargetType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.AttributedDateTime;
import org.w3c.dom.Element;

import com.rsa.names._2009._12.product.riat.wsdl.STSService;
import com.rsa.names._2009._12.product.riat.wsdl.STSServicePortType;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.vmware.sso.client.soaphandlers.SSOHeaderHandler;
import com.vmware.sso.client.soaphandlers.SamlTokenExtractionHandler;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.soaphandlers.WsSecurityUserCertificateSignatureHandler;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;

/**
 * This sample illustrates renewing a Holder-Of-Key token from SSO server. This
 * sample in turn uses the {@link AcquireHoKTokenByUserCredentialSample} sample
 * using the generated key/certificate pair at the runtime to first acquire a
 * Holder-Of-Key token, which then is used to renew
 * 
 * <pre>
 * <b>Usage:</b>
 * run.bat com.vmware.sso.client.samples.RenewTokenSample [sso url] [username] [password] [durationInSeconds]
 * </pre>
 * 
 * @author Ecosystem Engineering
 */
public class RenewTokenSample {

	/**
	 * @param ssoUrl
	 *            SSO server url e.g. https://[Host Name or IP
	 *            Address]:8444/ims/STSService
	 * @param token
	 *            An existing Holder-Of-Key token
	 * @param privateKey
	 *            {@link PrivateKey} of the user or solution
	 * @param cert
	 *            {@link X509Certificate} certificate of the user or solution
	 * 
	 * @param durationInSeconds
	 *            Duration in seconds the token should be kept valid from the
	 *            current time.
	 * 
	 * @return A renewed Holder-Of-Key token
	 * 
	 * @throws DatatypeConfigurationException
	 */
	public static Element renewToken(String ssoUrl, Element token,
			PrivateKey privateKey, X509Certificate cert, long durationInSeconds)
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
		 * Once the above headers are added we need to sign the SOAP message
		 * using the combination of private key, certificate of the user or
		 * solution by adding a Signature element to the security header
		 */

		/* Adding the Timestamp via TimeStampHandler */
		headerResolver.addHandler(new TimeStampHandler());

		/*
		 * Adding the handler for signing the message via
		 * WsSecurityUserCertificateSignatureHandler
		 */
		SSOHeaderHandler ssoHandler = new WsSecurityUserCertificateSignatureHandler(
				privateKey, cert);
		headerResolver.addHandler(ssoHandler);
		SamlTokenExtractionHandler sbHandler = new SamlTokenExtractionHandler();
		headerResolver.addHandler(sbHandler);
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
		 * lifetime for the token to be issued. In this case this will represent
		 * the extended validity period for the token after renewal
		 * 
		 * 2. Tokentype - "urn:oasis:names:tc:SAML:2.0:assertion", which is the
		 * class that models the requested token
		 * 
		 * 3. RequestType -
		 * "http://docs.oasis-open.org/ws-sx/ws-trust/200512/Renew", as we want
		 * to get a token renewed
		 * 
		 * 4. RenewTarget - represented by RenewTargetType which contains the
		 * Holder-Of-Key SAML token to be renewed
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
		xmlCalendar.add(dtFactory.newDuration(durationInSeconds * 1000));
		expires.setValue(xmlCalendar.toXMLFormat());
		lifetime.setCreated(created);
		lifetime.setExpires(expires);
		tokenType.setLifetime(lifetime);

		tokenType.setTokenType("urn:oasis:names:tc:SAML:2.0:assertion");
		tokenType
				.setRequestType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Renew");

		RenewTargetType renewTarget = new RenewTargetType();
		renewTarget.setAny(token);
		tokenType.setRenewTarget(renewTarget);

		/* Set the endpoint address for the request */
		Map<String, Object> reqContext = ((BindingProvider) stsPort)
				.getRequestContext();
		reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ssoUrl);

		/*
		 * Invoke the "renew" method on the STSService object to renew the token
		 * from SSO Server
		 */
		stsPort.renew(tokenType);

		// SamlTokenExtractionHandler will now contain the raw SAML token for
		// further consumption
		return sbHandler.getToken();
	}

	private static void printUsage() {
		System.out
				.println("run.bat com.vmware.sso.client.samples.RenewTokenSample [sso url] [username] [password] [durationInSeconds]");
	}

	public static void main(String[] args)
			throws DatatypeConfigurationException, InterruptedException {
		if (args.length < 4) {
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

		System.out.println("Inital token acquired using "
				+ "AcquireHoKTokenByUserCredentialSample sample");
		/*
		 * Validating a Holder-Of-Key token using the
		 * AcquireHoKTokenByUserCredentialSample sample
		 */
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

		Thread.sleep(5000);
		System.out.println("Renewing the token");
		System.out.println("*****Renewed token*****");
		Utils.printToken(renewToken(args[0], token, userCert.getPrivateKey(),
				userCert.getUserCert(), Long.parseLong(args[3])));

	}

}
