
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AllocateIpv6AddressRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AllocateIpv6AddressRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="dc" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="poolId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="allocationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllocateIpv6AddressRequestType", propOrder = {
    "_this",
    "dc",
    "poolId",
    "allocationId"
})
public class AllocateIpv6AddressRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected ManagedObjectReference dc;
    protected int poolId;
    @XmlElement(required = true)
    protected String allocationId;

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
     * Gets the value of the dc property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getDc() {
        return dc;
    }

    /**
     * Sets the value of the dc property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setDc(ManagedObjectReference value) {
        this.dc = value;
    }

    /**
     * Gets the value of the poolId property.
     * 
     */
    public int getPoolId() {
        return poolId;
    }

    /**
     * Sets the value of the poolId property.
     * 
     */
    public void setPoolId(int value) {
        this.poolId = value;
    }

    /**
     * Gets the value of the allocationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllocationId() {
        return allocationId;
    }

    /**
     * Sets the value of the allocationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllocationId(String value) {
        this.allocationId = value;
    }

}
