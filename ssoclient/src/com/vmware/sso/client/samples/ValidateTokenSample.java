/* **********************************************************
 * Copyright 2012 VMware, Inc.  All rights reserved.
 *
 * VMware Confidential
 * **********************************************************/
package com.vmware.sso.client.samples;

import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenResponseType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.StatusType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.ValidateTargetType;
import org.w3c.dom.Element;

import com.rsa.names._2009._12.product.riat.wsdl.STSService;
import com.rsa.names._2009._12.product.riat.wsdl.STSServicePortType;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;

/**
 * This sample illustrates validating a SAML token received from SSO server.
 * This sample in turn uses the {@link AcquireHoKTokenByUserCredentialSample}
 * and {@link AcquireBearerTokenByUserCredentialSample} samples using the
 * generated key/certificate pair at the runtime to first acquire a token, which
 * are then used to validate
 * 
 * <pre>
 * <b>Usage:</b>
 * run.bat com.vmware.sso.client.samples.ValidateTokenSample [sso url] [username] [password]
 * </pre>
 * 
 * @author Ecosystem Engineering
 */
public class ValidateTokenSample {

	/**
	 * @param ssoUrl
	 *            SSO server url e.g. https://[Host Name or IP
	 *            Address]:8444/ims/STSService
	 * @param token
	 *            An existing token to be verified
	 * 
	 * @return true is valid, false otherwise
	 * 
	 * @throws DatatypeConfigurationException
	 */
	public static boolean isTokenValid(String ssoUrl, Element token)
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
		 */

		/* Adding the Timestamp via TimeStampHandler */
		headerResolver.addHandler(new TimeStampHandler());

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
		 * 1. Tokentype -
		 * "http://docs.oasis-open.org/ws-sx/ws-trust/200512/RSTR/Status", which
		 * is the class that models token status
		 * 
		 * 2. RequestType -
		 * "http://docs.oasis-open.org/ws-sx/ws-trust/200512/Validate", as we
		 * want to get a token validated
		 * 
		 * 3. ValidateTarget - represented by ValidateTargetType which contains
		 * the SAML token to be validated
		 */
		tokenType
				.setTokenType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/RSTR/Status");
		tokenType
				.setRequestType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Validate");

		ValidateTargetType value = new ValidateTargetType();

		value.setAny(token);
		tokenType.setValidateTarget(value);

		/* Set the endpoint address for the request */
		Map<String, Object> reqContext = ((BindingProvider) stsPort)
				.getRequestContext();
		reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ssoUrl);

		/*
		 * Invoke the "validate" method on the STSService object to validate the
		 * token from SSO Server
		 */
		RequestSecurityTokenResponseType statusResponse = stsPort
				.validate(tokenType);

		/* handle the response - extract the SAML token status */
		StatusType rstResponse = statusResponse.getStatus();

		/*
		 * There are only two possible values for the status code
		 * "http://docs.oasis-open.org/ws-sx/ws-trust/200512/status/valid" for
		 * valid token
		 * "http://docs.oasis-open.org/ws-sx/ws-trust/200512/status/invalid" for
		 * invalid token
		 */
		String tokenStatus = rstResponse.getCode();
		System.out.println("Token Status is determined to be " + tokenStatus);
		return tokenStatus
				.equalsIgnoreCase("http://docs.oasis-open.org/ws-sx/ws-trust/200512/status/valid");
	}

	private static void printUsage() {
		System.out
				.println("run.bat com.vmware.sso.client.samples.ValidateTokenSample [sso url] [username] [password]");
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

		System.out.println("Acquiring bearer token using "
				+ "AcquireBearerTokenByUserCredentialSample sample");
		/*
		 * Validating a bearer token using the
		 * AcquireBearerTokenByUserCredentialSample sample
		 */
		Element token = AcquireBearerTokenByUserCredentialSample.getToken(args);
		Utils.printToken(token);
		System.out.println("Validating the acquired token");
		System.out.println("The bearer token is "
				+ (isTokenValid(args[0], token) ? "valid" : "invalid"));

		System.out.println("\nAcquiring HoK token using "
				+ "AcquireHoKTokenByUserCredentialSample sample");

		/*
		 * Use the helper method generateKeyCertPair() of the SecurityUtil class
		 * to generate a pair of private key and public certificate on the fly.
		 */
		SecurityUtil userCert = SecurityUtil.generateKeyCertPair();
		token = AcquireHoKTokenByUserCredentialSample.getToken(args,
				userCert.getPrivateKey(), userCert.getUserCert());
		Utils.printToken(token);
		System.out.println("Validating the acquired token");

		/*
		 * Validating a Holder-Of-Key token using the
		 * AcquireHoKTokenByUserCredentialSample sample
		 */
		System.out.println("The HoK token is "
				+ (isTokenValid(args[0], token) ? "valid" : "invalid"));
	}

}
