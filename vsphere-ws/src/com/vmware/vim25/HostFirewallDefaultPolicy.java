
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFirewallDefaultPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostFirewallDefaultPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="incomingBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="outgoingBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostFirewallDefaultPolicy", propOrder = {
    "incomingBlocked",
    "outgoingBlocked"
})
public class HostFirewallDefaultPolicy
    extends DynamicData
{

    protected Boolean incomingBlocked;
    protected Boolean outgoingBlocked;

    /**
     * Gets the value of the incomingBlocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncomingBlocked() {
        return incomingBlocked;
    }

    /**
     * Sets the value of the incomingBlocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncomingBlocked(Boolean value) {
        this.incomingBlocked = value;
    }

    /**
     * Gets the value of the outgoingBlocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOutgoingBlocked() {
        return outgoingBlocked;
    }

    /**
     * Sets the value of the outgoingBlocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutgoingBlocked(Boolean value) {
        this.outgoingBlocked = value;
    }

}
