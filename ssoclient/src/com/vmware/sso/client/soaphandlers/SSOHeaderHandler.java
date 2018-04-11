/* **********************************************************
 * Copyright 2012 VMware, Inc.  All rights reserved.
 *
 * VMware Confidential
 * **********************************************************/
package com.vmware.sso.client.soaphandlers;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * Base Abstract class that all the header handler will be extending.
 * 
 * <pre>
 * The reason for this abstract base class is two folds:
 * 1. Provide a common base class that can be utilized by the single
 * {@link HeaderHandlerResolver}
 * 2. The subclasses can simply implement the handleMessage() method instead to
 * creating dummy code for all the other methods as well
 * </pre>
 * 
 * @author Ecosystem Engineering
 */
public abstract class SSOHeaderHandler implements
		SOAPHandler<SOAPMessageContext> {

	@Override
	public void close(MessageContext arg0) {
	}

	@Override
	public boolean handleFault(SOAPMessageContext arg0) {
		return false;
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
