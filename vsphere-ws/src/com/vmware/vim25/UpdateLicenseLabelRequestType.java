
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateLicenseLabelRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateLicenseLabelRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="licenseKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="labelKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="labelValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateLicenseLabelRequestType", propOrder = {
    "_this",
    "licenseKey",
    "labelKey",
    "labelValue"
})
public class UpdateLicenseLabelRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected String licenseKey;
    @XmlElement(required = true)
    protected String labelKey;
    @XmlElement(required = true)
    protected String labelValue;

    /**
     * Gets the value of the this property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getThis() {
        return _this;
    }

    /**
     * Sets the value of the this property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setThis(ManagedObjectReference value) {
        this._this = value;
    }

    /**
     * Gets the value of the licenseKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseKey() {
        return licenseKey;
    }

    /**
     * Sets the value of the licenseKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseKey(String value) {
        this.licenseKey = value;
    }

    /**
     * Gets the value of the labelKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelKey() {
        return labelKey;
    }

    /**
     * Sets the value of the labelKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelKey(String value) {
        this.labelKey = value;
    }

    /**
     * Gets the value of the labelValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelValue() {
        return labelValue;
    }

    /**
     * Sets the value of the labelValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelValue(String value) {
        this.labelValue = value;
    }

}
