
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateInternetScsiDiscoveryPropertiesRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateInternetScsiDiscoveryPropertiesRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="iScsiHbaDevice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="discoveryProperties" type="{urn:vim25}HostInternetScsiHbaDiscoveryProperties"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateInternetScsiDiscoveryPropertiesRequestType", propOrder = {
    "_this",
    "iScsiHbaDevice",
    "discoveryProperties"
})
public class UpdateInternetScsiDiscoveryPropertiesRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected String iScsiHbaDevice;
    @XmlElement(required = true)
    protected HostInternetScsiHbaDiscoveryProperties discoveryProperties;

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
     * Gets the value of the discoveryProperties property.
     * 
     * @return
     *     possible object is
     *     {@link HostInternetScsiHbaDiscoveryProperties }
     *     
     */
    public HostInternetScsiHbaDiscoveryProperties getDiscoveryProperties() {
        return discoveryProperties;
    }

    /**
     * Sets the value of the discoveryProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostInternetScsiHbaDiscoveryProperties }
     *     
     */
    public void setDiscoveryProperties(HostInternetScsiHbaDiscoveryProperties value) {
        this.discoveryProperties = value;
    }

}
