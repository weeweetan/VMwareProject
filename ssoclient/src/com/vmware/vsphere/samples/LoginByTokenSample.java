/* **********************************************************
 * Copyright 2012 VMware, Inc.  All rights reserved.
 *
 * VMware Confidential
 * **********************************************************/
package com.vmware.vsphere.samples;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import org.w3c.dom.Element;

import com.vmware.sso.client.samples.AcquireBearerTokenByUserCredentialSample;
import com.vmware.sso.client.samples.AcquireHoKTokenByUserCredentialSample;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.vmware.sso.client.soaphandlers.SamlTokenHandler;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.soaphandlers.WsSecuritySignatureAssertionHandler;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;
import com.vmware.vim25.InvalidLocaleFaultMsg;
import com.vmware.vim25.InvalidLoginFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.UserSession;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vsphere.soaphandlers.HeaderCookieExtractionHandler;
import com.vmware.vsphere.soaphandlers.HeaderCookieHandler;

/**
 * Sample program demonstrating the usage of the new LoginByToken method,
 * introduced to authenticate the client using the SAML token obtained from the
 * SSO server.
 * 
 * This sample illustrates the usage of both Bearer token as well as the
 * HolderOfKey token for authenticating to a vCenter server
 * 
 * <pre>
 * <b>Usage:</b>
 * run.bat com.vmware.vsphere.samples.LoginByTokenSample [sso url] [username] [password] [vCenter url]
 * </pre>
 * 
 * @author Ecosystem Engineering
 */
public class LoginByTokenSample {

	public static VimPortType vimPort;
	public static ManagedObjectReference SVC_INST_REF = new ManagedObjectReference();
	private static VimService vimService = new VimService();
	private static HandlerResolver defaultHandler = vimService
			.getHandlerResolver();
	/*
	 * Use the helper method generateKeyCertPair() of the SecurityUtil class to
	 * generate a pair of private key and public certificate on the fly.
	 */
	private static SecurityUtil userCert = SecurityUtil.generateKeyCertPair();
	private static ServiceContent serviceContent;
	private static boolean isConnected;

	/**
	 * Method to clear the HandlerResolver chain
	 * 
	 * @param vcServerUrl
	 *            The vCenter server url that needs to be connected
	 * @param cookie
	 *            The session cookie value that represents the current
	 *            connection
	 */
	private static void clearHandlerResolver(String vcServerUrl, String cookie) {
		// After login we do not need this handler thus reverting to the
		// original one
		vimService.setHandlerResolver(defaultHandler);
		vimPort = vimService.getVimPort();
		// Set the validated session cookie and set it in the header for once,
		// JAXWS will maintain that cookie for all the subsequent requests
		{
			Map<String, Object> ctxt = ((BindingProvider) vimPort)
					.getRequestContext();
			ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
			ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
			// One time setting of the cookie
			@SuppressWarnings("unchecked")
			Map<String, List<String>> headers = (Map<String, List<String>>) ctxt
					.get(MessageContext.HTTP_REQUEST_HEADERS);
			if (headers == null) {
				headers = new HashMap<String, List<String>>();
			}
			headers.put("Cookie", Arrays.asList(cookie));
			ctxt.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		}
	}

	/**
	 * This method retrieves the current time from the server and prints it.
	 */
	public static void getCurrentTime() {
		try {
			XMLGregorianCalendar ct = vimPort.currentTime(SVC_INST_REF);
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd 'T' HH:mm:ss.SSSZ");
			System.out.println("Server current time: "
					+ sdf.format(ct.toGregorianCalendar().getTime()));
		} catch (SOAPFaultException sfe) {
			sfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method invokes the loginByToken method for authentication. Once this
	 * method is called the established session is authenticated and operations
	 * can be performed on the connected vCenter server
	 * 
	 * @param token
	 *            {@link Element} representing the SAML token that needs to be
	 *            used for the authentication
	 * @param vcServerUrl
	 *            The vCenter server url that needs to be connected
	 * @throws RuntimeFaultFaultMsg
	 * @throws InvalidLocaleFaultMsg
	 * @throws InvalidLoginFaultMsg
	 */
	public static void loginUsingSAMLToken(Element token, String vcServerUrl)
			throws RuntimeFaultFaultMsg, InvalidLocaleFaultMsg,
			InvalidLoginFaultMsg {

		// Setting up the configuration for ignoring the SSL certificates
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);

		// The process we are going to follow is described below:
		// 1. Retrieve the ServiceContent
		// 2. Extract the session cookie that is established in the previous
		// call to the server.
		// 3. Set up the required HandlerResolver chain as per the type of the
		// token passed.
		// 4. Invoke the LoginByToken method
		// 5. Clear the HandlerResolver chain setup in the step 3 as that is
		// required only one time for the invocation of the LoginByToken method
		// 6. Inject the session cookie back into the request once before making
		// another call to the server.
		// 7. Authentication complete. Proceed with rest of the API calls that
		// are required for your functionality

		vimService = new VimService();
		System.out.println("Step 1 Retrieve the service content");
		// Step 1 Retrieve the service content
		SVC_INST_REF.setType("ServiceInstance");
		SVC_INST_REF.setValue("ServiceInstance");

		// Injecting the HeaderCookieExtractionHandler, to be able to extract
		// the session cookie for now and use it later
		HeaderCookieExtractionHandler cookieExtractor = new HeaderCookieExtractionHandler();
		{
			HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
			handlerResolver.addHandler(cookieExtractor);
			vimService.setHandlerResolver(handlerResolver);
		}
		vimPort = vimService.getVimPort();

		Map<String, Object> ctxt = ((BindingProvider) vimPort)
				.getRequestContext();
		ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
		ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

		serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF);
		String cookie = cookieExtractor.getCookie();
		System.out.println("Cookie extracted is " + cookie);

		System.out.println("Step 2 Invoking the loginByToken method");
		if (Utils.isHoKToken(token)) {
			validateSessionUsingHoKToken(token, vcServerUrl, cookie);
		} else {
			validateSessionUsingBearerToken(token, vcServerUrl, cookie);
		}
	}

	/**
	 * Disconnects the user session.
	 * 
	 * @throws RuntimeFaultFaultMsg
	 * 
	 * @throws Exception
	 */
	public static void logout() throws RuntimeFaultFaultMsg {
		if (isConnected) {
			vimPort.logout(serviceContent.getSessionManager());
		}
		System.out.println("Logged out....");
		isConnected = false;
	}

	public static void main(String[] args)
			throws DatatypeConfigurationException, RuntimeFaultFaultMsg,
			InvalidLocaleFaultMsg, InvalidLoginFaultMsg {
		if (args.length < 4) {
			printUsage();
			return;
		}
		Utils.trustAllHttpsCertificates();
		/*
		 * Acquiring a bearer token using the
		 * AcquireBearerTokenByUserCredentialSample sample
		 */
		System.out.println("Acquiring a bearer token using the "
				+ "AcquireBearerTokenByUserCredentialSample sample");
		Element token = AcquireBearerTokenByUserCredentialSample.getToken(args);
		Utils.printToken(token);
		System.out.println("Bearer Token received....");
		System.out.println("Connecting to the vCenter " + args[3] + "....");
		loginUsingSAMLToken(token, args[3]);
		System.out.println("Now getting the current time on the server....");
		// Now getting the current time on the server
		getCurrentTime();
		logout();

		/*
		 * Acquiring a Holder-Of-Key token using the
		 * AcquireHoKTokenByUserCredentialSample sample
		 */
		System.out.println("Acquiring a Holder-Of-Key token using the "
				+ "AcquireHoKTokenByUserCredentialSample sample....");
		token = AcquireHoKTokenByUserCredentialSample.getToken(args,
				userCert.getPrivateKey(), userCert.getUserCert());
		Utils.printToken(token);
		System.out.println("HoK Token received....");
		System.out.println("Connecting to the vCenter " + args[3] + "....");
		loginUsingSAMLToken(token, args[3]);
		System.out.println("Now getting the current time on the server....");
		// Now getting the current time on the server
		getCurrentTime();
		logout();

	}

	private static void printUsage() {
		System.out
				.println("run.bat com.vmware.vsphere.samples.LoginByTokenSample [sso url] [username] [password] [vCenter url]");
	}

	/**
	 * Method that sets up the HandlerResolver chain for the Bearer tokens
	 * 
	 * @param token
	 *            {@link Element} representing the Bearer SAML token
	 * @param vcServerUrl
	 *            The vCenter server url that needs to be connected
	 * @param cookie
	 *            The session cookie value that represents the current
	 *            connection
	 * @throws InvalidLocaleFaultMsg
	 * @throws InvalidLoginFaultMsg
	 * @throws RuntimeFaultFaultMsg
	 */
	private static void validateSessionUsingBearerToken(Element token,
			String vcServerUrl, String cookie) throws InvalidLocaleFaultMsg,
			InvalidLoginFaultMsg, RuntimeFaultFaultMsg {

		// Step 2 Invoking the loginByToken method
		{
			HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
			handlerResolver.addHandler(new TimeStampHandler());
			handlerResolver.addHandler(new SamlTokenHandler(token));
			handlerResolver.addHandler(new HeaderCookieHandler(cookie));
			vimService.setHandlerResolver(handlerResolver);
		}
		vimPort = vimService.getVimPort();

		Map<String, Object> ctxt = ((BindingProvider) vimPort)
				.getRequestContext();
		ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
		ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

		UserSession us = vimPort.loginByToken(
				serviceContent.getSessionManager(), null);
		System.out.println("UserName " + us.getUserName()
				+ " logged in with session " + us.getKey());
		isConnected = true;
		System.out
				.println("Step 3 Now perform some task as the authenticated user");
		// Step 3 Now perform some task as the authenticated user
		clearHandlerResolver(vcServerUrl, cookie);
	}

	/**
	 * Method that sets up the HandlerResolver chain for the HolderOfKey tokens
	 * 
	 * @param token
	 *            {@link Element} representing the Bearer SAML token
	 * @param vcServerUrl
	 *            The vCenter server url that needs to be connected
	 * @param cookie
	 *            The session cookie value that represents the current
	 *            connection
	 * @throws InvalidLocaleFaultMsg
	 * @throws InvalidLoginFaultMsg
	 * @throws RuntimeFaultFaultMsg
	 */
	private static void validateSessionUsingHoKToken(Element token,
			String vcServerUrl, String cookie) throws InvalidLocaleFaultMsg,
			InvalidLoginFaultMsg, RuntimeFaultFaultMsg {

		// Step 2 Invoking the loginByToken method
		{
			HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
			handlerResolver.addHandler(new TimeStampHandler());
			handlerResolver.addHandler(new SamlTokenHandler(token));
			handlerResolver.addHandler(new HeaderCookieHandler(cookie));
			handlerResolver.addHandler(new WsSecuritySignatureAssertionHandler(
					userCert.getPrivateKey(), userCert.getUserCert(), Utils
							.getNodeProperty(token, "ID")));
			vimService.setHandlerResolver(handlerResolver);
		}
		vimPort = vimService.getVimPort();

		Map<String, Object> ctxt = ((BindingProvider) vimPort)
				.getRequestContext();
		ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
		ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

		UserSession us = vimPort.loginByToken(
				serviceContent.getSessionManager(), null);
		System.out.println("UserName " + us.getUserName()
				+ " logged in with session " + us.getKey());
		isConnected = true;
		System.out
				.println("Step 3 Now perform some task as the authenticated user");
		// Step 3 Now perform some task as the authenticated user
		clearHandlerResolver(vcServerUrl, cookie);

	}
}
