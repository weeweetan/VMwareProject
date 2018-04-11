/* **********************************************************
 * Copyright 2012 VMware, Inc.  All rights reserved.
 *
 * VMware Confidential
 * **********************************************************/
package com.vmware.sso.client.soaphandlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

/**
 * Reference implementation of the {@link HandlerResolver} interface with an
 * additional method addHandler to add a new {@link SSOHeaderHandler} to the
 * chain.
 * 
 * @author Ecosystem Engineering
 */
@SuppressWarnings("rawtypes")
public final class HeaderHandlerResolver implements HandlerResolver {

	private final List<Handler> handlerChain = new ArrayList<Handler>();

	@Override
	public List<Handler> getHandlerChain(PortInfo arg0) {
		return Collections.unmodifiableList(handlerChain);
	}

	/**
	 * Adds a specific {@link SSOHeaderHandler} to the handler chain
	 * 
	 * @param ssoHandler
	 */
	public void addHandler(SSOHeaderHandler ssoHandler) {
		handlerChain.add(ssoHandler);
	}

	/**
	 * Clears the current list of {@link SSOHeaderHandler} in the handler chain
	 */
	public void clearHandlerChain() {
		handlerChain.clear();
	}
}
