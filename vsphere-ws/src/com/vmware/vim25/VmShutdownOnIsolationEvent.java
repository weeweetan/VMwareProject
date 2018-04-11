
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmShutdownOnIsolationEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmShutdownOnIsolationEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmPoweredOffEvent">
 *       &lt;sequence>
 *         &lt;element name="isolatedHost" type="{urn:vim25}HostEventArgument"/>
 *         &lt;element name="shutdownResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmShutdownOnIsolationEvent", propOrder = {
    "isolatedHost",
    "shutdownResult"
})
public class VmShutdownOnIsolationEvent
    extends VmPoweredOffEvent
{

    @XmlElement(required = true)
    protected HostEventArgument isolatedHost;
    protected String shutdownResult;

    /**
     * Gets the value of the isolatedHost property.
     * 
     * @return
     *     possible object is
     *     {@link HostEventArgument }
     *     
     */
    public HostEventArgument getIsolatedHost() {
        return isolatedHost;
    }

    /**
     * Sets the value of the isolatedHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostEventArgument }
     *     
     */
    public void setIsolatedHost(HostEventArgument value) {
        this.isolatedHost = value;
    }

    /**
     * Gets the value of the shutdownResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShutdownResult() {
        return shutdownResult;
    }

    /**
     * Sets the value of the shutdownResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShutdownResult(String value) {
        this.shutdownResult = value;
    }

}
