
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LicenseSourceUnavailable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LicenseSourceUnavailable">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}NotEnoughLicenses">
 *       &lt;sequence>
 *         &lt;element name="licenseSource" type="{urn:vim25}LicenseSource"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LicenseSourceUnavailable", propOrder = {
    "licenseSource"
})
public class LicenseSourceUnavailable
    extends NotEnoughLicenses
{

    @XmlElement(required = true)
    protected LicenseSource licenseSource;

    /**
     * Gets the value of the licenseSource property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseSource }
     *     
     */
    public LicenseSource getLicenseSource() {
        return licenseSource;
    }

    /**
     * Sets the value of the licenseSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseSource }
     *     
     */
    public void setLicenseSource(LicenseSource value) {
        this.licenseSource = value;
    }

}
