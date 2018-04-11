
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LicenseServerSource complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LicenseServerSource">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}LicenseSource">
 *       &lt;sequence>
 *         &lt;element name="licenseServer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LicenseServerSource", propOrder = {
    "licenseServer"
})
public class LicenseServerSource
    extends LicenseSource
{

    @XmlElement(required = true)
    protected String licenseServer;

    /**
     * Gets the value of the licenseServer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseServer() {
        return licenseServer;
    }

    /**
     * Sets the value of the licenseServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseServer(String value) {
        this.licenseServer = value;
    }

}
