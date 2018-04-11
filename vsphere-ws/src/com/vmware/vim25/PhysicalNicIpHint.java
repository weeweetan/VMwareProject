
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhysicalNicIpHint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PhysicalNicIpHint">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}PhysicalNicHint">
 *       &lt;sequence>
 *         &lt;element name="ipSubnet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalNicIpHint", propOrder = {
    "ipSubnet"
})
public class PhysicalNicIpHint
    extends PhysicalNicHint
{

    @XmlElement(required = true)
    protected String ipSubnet;

    /**
     * Gets the value of the ipSubnet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpSubnet() {
        return ipSubnet;
    }

    /**
     * Sets the value of the ipSubnet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpSubnet(String value) {
        this.ipSubnet = value;
    }

}
