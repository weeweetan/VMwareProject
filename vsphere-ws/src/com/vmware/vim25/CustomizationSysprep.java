
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationSysprep complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomizationSysprep">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}CustomizationIdentitySettings">
 *       &lt;sequence>
 *         &lt;element name="guiUnattended" type="{urn:vim25}CustomizationGuiUnattended"/>
 *         &lt;element name="userData" type="{urn:vim25}CustomizationUserData"/>
 *         &lt;element name="guiRunOnce" type="{urn:vim25}CustomizationGuiRunOnce" minOccurs="0"/>
 *         &lt;element name="identification" type="{urn:vim25}CustomizationIdentification"/>
 *         &lt;element name="licenseFilePrintData" type="{urn:vim25}CustomizationLicenseFilePrintData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomizationSysprep", propOrder = {
    "guiUnattended",
    "userData",
    "guiRunOnce",
    "identification",
    "licenseFilePrintData"
})
public class CustomizationSysprep
    extends CustomizationIdentitySettings
{

    @XmlElement(required = true)
    protected CustomizationGuiUnattended guiUnattended;
    @XmlElement(required = true)
    protected CustomizationUserData userData;
    protected CustomizationGuiRunOnce guiRunOnce;
    @XmlElement(required = true)
    protected CustomizationIdentification identification;
    protected CustomizationLicenseFilePrintData licenseFilePrintData;

    /**
     * Gets the value of the guiUnattended property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationGuiUnattended }
     *     
     */
    public CustomizationGuiUnattended getGuiUnattended() {
        return guiUnattended;
    }

    /**
     * Sets the value of the guiUnattended property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationGuiUnattended }
     *     
     */
    public void setGuiUnattended(CustomizationGuiUnattended value) {
        this.guiUnattended = value;
    }

    /**
     * Gets the value of the userData property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationUserData }
     *     
     */
    public CustomizationUserData getUserData() {
        return userData;
    }

    /**
     * Sets the value of the userData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationUserData }
     *     
     */
    public void setUserData(CustomizationUserData value) {
        this.userData = value;
    }

    /**
     * Gets the value of the guiRunOnce property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationGuiRunOnce }
     *     
     */
    public CustomizationGuiRunOnce getGuiRunOnce() {
        return guiRunOnce;
    }

    /**
     * Sets the value of the guiRunOnce property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationGuiRunOnce }
     *     
     */
    public void setGuiRunOnce(CustomizationGuiRunOnce value) {
        this.guiRunOnce = value;
    }

    /**
     * Gets the value of the identification property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationIdentification }
     *     
     */
    public CustomizationIdentification getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationIdentification }
     *     
     */
    public void setIdentification(CustomizationIdentification value) {
        this.identification = value;
    }

    /**
     * Gets the value of the licenseFilePrintData property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationLicenseFilePrintData }
     *     
     */
    public CustomizationLicenseFilePrintData getLicenseFilePrintData() {
        return licenseFilePrintData;
    }

    /**
     * Sets the value of the licenseFilePrintData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationLicenseFilePrintData }
     *     
     */
    public void setLicenseFilePrintData(CustomizationLicenseFilePrintData value) {
        this.licenseFilePrintData = value;
    }

}
