
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="autoPreInstallAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="autoUpgradeAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="partialUpgradeAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSPolicy", propOrder = {
    "autoPreInstallAllowed",
    "autoUpgradeAllowed",
    "partialUpgradeAllowed"
})
public class DVSPolicy
    extends DynamicData
{

    protected Boolean autoPreInstallAllowed;
    protected Boolean autoUpgradeAllowed;
    protected Boolean partialUpgradeAllowed;

    /**
     * Gets the value of the autoPreInstallAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoPreInstallAllowed() {
        return autoPreInstallAllowed;
    }

    /**
     * Sets the value of the autoPreInstallAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoPreInstallAllowed(Boolean value) {
        this.autoPreInstallAllowed = value;
    }

    /**
     * Gets the value of the autoUpgradeAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoUpgradeAllowed() {
        return autoUpgradeAllowed;
    }

    /**
     * Sets the value of the autoUpgradeAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoUpgradeAllowed(Boolean value) {
        this.autoUpgradeAllowed = value;
    }

    /**
     * Gets the value of the partialUpgradeAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPartialUpgradeAllowed() {
        return partialUpgradeAllowed;
    }

    /**
     * Sets the value of the partialUpgradeAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPartialUpgradeAllowed(Boolean value) {
        this.partialUpgradeAllowed = value;
    }

}
