
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LocalLicenseSource complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocalLicenseSource">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}LicenseSource">
 *       &lt;sequence>
 *         &lt;element name="licenseKeys" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalLicenseSource", propOrder = {
    "licenseKeys"
})
public class LocalLicenseSource
    extends LicenseSource
{

    @XmlElement(required = true)
    protected String licenseKeys;

    /**
     * Gets the value of the licenseKeys property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseKeys() {
        return licenseKeys;
    }

    /**
     * Sets the value of the licenseKeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseKeys(String value) {
        this.licenseKeys = value;
    }

}
