
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateInternetScsiNameRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateInternetScsiNameRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="iScsiHbaDevice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iScsiName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateInternetScsiNameRequestType", propOrder = {
    "_this",
    "iScsiHbaDevice",
    "iScsiName"
})
public class UpdateInternetScsiNameRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected String iScsiHbaDevice;
    @XmlElement(required = true)
    protected String iScsiName;

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
     * Gets the value of the iScsiHbaDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIScsiHbaDevice() {
        return iScsiHbaDevice;
    }

    /**
     * Sets the value of the iScsiHbaDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIScsiHbaDevice(String value) {
        this.iScsiHbaDevice = value;
    }

    /**
     * Gets the value of the iScsiName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIScsiName() {
        return iScsiName;
    }

    /**
     * Sets the value of the iScsiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIScsiName(String value) {
        this.iScsiName = value;
    }

}
