
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SessionEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SessionEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}Event">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SessionEvent")
@XmlSeeAlso({
    BadUsernameSessionEvent.class,
    UserLogoutSessionEvent.class,
    GlobalMessageChangedEvent.class,
    ServerStartedSessionEvent.class,
    SessionTerminatedEvent.class,
    AlreadyAuthenticatedSessionEvent.class,
    NoAccessUserEvent.class,
    UserLoginSessionEvent.class
})
public class SessionEvent
    extends Event
{


}
