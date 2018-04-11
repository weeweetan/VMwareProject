
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvalidLicense complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvalidLicense">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VimFault">
 *       &lt;sequence>
 *         &lt;element name="licenseContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvalidLicense", propOrder = {
    "licenseContent"
})
public class InvalidLicense
    extends VimFault
{

    @XmlElement(required = true)
    protected String licenseContent;

    /**
     * Gets the value of the licenseContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseContent() {
        return licenseContent;
    }

    /**
     * Sets the value of the licenseContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseContent(String value) {
        this.licenseContent = value;
    }

}
