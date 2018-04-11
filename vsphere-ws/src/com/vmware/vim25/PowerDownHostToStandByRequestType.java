
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PowerDownHostToStandByRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PowerDownHostToStandByRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="timeoutSec" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="evacuatePoweredOffVms" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerDownHostToStandByRequestType", propOrder = {
    "_this",
    "timeoutSec",
    "evacuatePoweredOffVms"
})
public class PowerDownHostToStandByRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    protected int timeoutSec;
    protected Boolean evacuatePoweredOffVms;

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
     * Gets the value of the timeoutSec property.
     * 
     */
    public int getTimeoutSec() {
        return timeoutSec;
    }

    /**
     * Sets the value of the timeoutSec property.
     * 
     */
    public void setTimeoutSec(int value) {
        this.timeoutSec = value;
    }

    /**
     * Gets the value of the evacuatePoweredOffVms property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEvacuatePoweredOffVms() {
        return evacuatePoweredOffVms;
    }

    /**
     * Sets the value of the evacuatePoweredOffVms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEvacuatePoweredOffVms(Boolean value) {
        this.evacuatePoweredOffVms = value;
    }

}
