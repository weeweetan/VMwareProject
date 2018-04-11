
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostIpChangedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostIpChangedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostEvent">
 *       &lt;sequence>
 *         &lt;element name="oldIP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newIP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostIpChangedEvent", propOrder = {
    "oldIP",
    "newIP"
})
public class HostIpChangedEvent
    extends HostEvent
{

    @XmlElement(required = true)
    protected String oldIP;
    @XmlElement(required = true)
    protected String newIP;

    /**
     * Gets the value of the oldIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldIP() {
        return oldIP;
    }

    /**
     * Sets the value of the oldIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldIP(String value) {
        this.oldIP = value;
    }

    /**
     * Gets the value of the newIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewIP() {
        return newIP;
    }

    /**
     * Sets the value of the newIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewIP(String value) {
        this.newIP = value;
    }

}
