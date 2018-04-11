
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationLicenseFilePrintData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomizationLicenseFilePrintData">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="autoMode" type="{urn:vim25}CustomizationLicenseDataMode"/>
 *         &lt;element name="autoUsers" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomizationLicenseFilePrintData", propOrder = {
    "autoMode",
    "autoUsers"
})
public class CustomizationLicenseFilePrintData
    extends DynamicData
{

    @XmlElement(required = true)
    protected CustomizationLicenseDataMode autoMode;
    protected Integer autoUsers;

    /**
     * Gets the value of the autoMode property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationLicenseDataMode }
     *     
     */
    public CustomizationLicenseDataMode getAutoMode() {
        return autoMode;
    }

    /**
     * Sets the value of the autoMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationLicenseDataMode }
     *     
     */
    public void setAutoMode(CustomizationLicenseDataMode value) {
        this.autoMode = value;
    }

    /**
     * Gets the value of the autoUsers property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAutoUsers() {
        return autoUsers;
    }

    /**
     * Sets the value of the autoUsers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAutoUsers(Integer value) {
        this.autoUsers = value;
    }

}
