
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualSerialPortPipeBackingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualSerialPortPipeBackingInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDevicePipeBackingInfo">
 *       &lt;sequence>
 *         &lt;element name="endpoint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="noRxLoss" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualSerialPortPipeBackingInfo", propOrder = {
    "endpoint",
    "noRxLoss"
})
public class VirtualSerialPortPipeBackingInfo
    extends VirtualDevicePipeBackingInfo
{

    @XmlElement(required = true)
    protected String endpoint;
    protected Boolean noRxLoss;

    /**
     * Gets the value of the endpoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the value of the endpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndpoint(String value) {
        this.endpoint = value;
    }

    /**
     * Gets the value of the noRxLoss property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoRxLoss() {
        return noRxLoss;
    }

    /**
     * Sets the value of the noRxLoss property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoRxLoss(Boolean value) {
        this.noRxLoss = value;
    }

}
