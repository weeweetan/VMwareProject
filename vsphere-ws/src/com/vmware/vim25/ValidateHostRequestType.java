
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidateHostRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidateHostRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="ovfDescriptor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="host" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="vhp" type="{urn:vim25}OvfValidateHostParams"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateHostRequestType", propOrder = {
    "_this",
    "ovfDescriptor",
    "host",
    "vhp"
})
public class ValidateHostRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected String ovfDescriptor;
    @XmlElement(required = true)
    protected ManagedObjectReference host;
    @XmlElement(required = true)
    protected OvfValidateHostParams vhp;

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
     * Gets the value of the ovfDescriptor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOvfDescriptor() {
        return ovfDescriptor;
    }

    /**
     * Sets the value of the ovfDescriptor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOvfDescriptor(String value) {
        this.ovfDescriptor = value;
    }

    /**
     * Gets the value of the host property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setHost(ManagedObjectReference value) {
        this.host = value;
    }

    /**
     * Gets the value of the vhp property.
     * 
     * @return
     *     possible object is
     *     {@link OvfValidateHostParams }
     *     
     */
    public OvfValidateHostParams getVhp() {
        return vhp;
    }

    /**
     * Sets the value of the vhp property.
     * 
     * @param value
     *     allowed object is
     *     {@link OvfValidateHostParams }
     *     
     */
    public void setVhp(OvfValidateHostParams value) {
        this.vhp = value;
    }

}
