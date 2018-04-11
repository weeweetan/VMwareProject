
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IscsiFaultVnicHasMultipleUplinks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IscsiFaultVnicHasMultipleUplinks">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}IscsiFault">
 *       &lt;sequence>
 *         &lt;element name="vnicDevice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IscsiFaultVnicHasMultipleUplinks", propOrder = {
    "vnicDevice"
})
public class IscsiFaultVnicHasMultipleUplinks
    extends IscsiFault
{

    @XmlElement(required = true)
    protected String vnicDevice;

    /**
     * Gets the value of the vnicDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVnicDevice() {
        return vnicDevice;
    }

    /**
     * Sets the value of the vnicDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVnicDevice(String value) {
        this.vnicDevice = value;
    }

}
