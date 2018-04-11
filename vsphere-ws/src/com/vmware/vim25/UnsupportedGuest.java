
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnsupportedGuest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnsupportedGuest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InvalidVmConfig">
 *       &lt;sequence>
 *         &lt;element name="unsupportedGuestOS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnsupportedGuest", propOrder = {
    "unsupportedGuestOS"
})
public class UnsupportedGuest
    extends InvalidVmConfig
{

    @XmlElement(required = true)
    protected String unsupportedGuestOS;

    /**
     * Gets the value of the unsupportedGuestOS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnsupportedGuestOS() {
        return unsupportedGuestOS;
    }

    /**
     * Sets the value of the unsupportedGuestOS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnsupportedGuestOS(String value) {
        this.unsupportedGuestOS = value;
    }

}
