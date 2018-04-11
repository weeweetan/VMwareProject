
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SessionTerminatedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SessionTerminatedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}SessionEvent">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="terminatedUsername" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SessionTerminatedEvent", propOrder = {
    "sessionId",
    "terminatedUsername"
})
public class SessionTerminatedEvent
    extends SessionEvent
{

    @XmlElement(required = true)
    protected String sessionId;
    @XmlElement(required = true)
    protected String terminatedUsername;

    /**
     * Gets the value of the sessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Gets the value of the terminatedUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminatedUsername() {
        return terminatedUsername;
    }

    /**
     * Sets the value of the terminatedUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminatedUsername(String value) {
        this.terminatedUsername = value;
    }

}
