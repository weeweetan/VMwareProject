
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiscoverFcoeHbasRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiscoverFcoeHbasRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="fcoeSpec" type="{urn:vim25}FcoeConfigFcoeSpecification"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiscoverFcoeHbasRequestType", propOrder = {
    "_this",
    "fcoeSpec"
})
public class DiscoverFcoeHbasRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected FcoeConfigFcoeSpecification fcoeSpec;

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
     * Gets the value of the fcoeSpec property.
     * 
     * @return
     *     possible object is
     *     {@link FcoeConfigFcoeSpecification }
     *     
     */
    public FcoeConfigFcoeSpecification getFcoeSpec() {
        return fcoeSpec;
    }

    /**
     * Sets the value of the fcoeSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link FcoeConfigFcoeSpecification }
     *     
     */
    public void setFcoeSpec(FcoeConfigFcoeSpecification value) {
        this.fcoeSpec = value;
    }

}
