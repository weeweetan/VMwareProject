
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateVirtualSwitchRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateVirtualSwitchRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="vswitchName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="spec" type="{urn:vim25}HostVirtualSwitchSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateVirtualSwitchRequestType", propOrder = {
    "_this",
    "vswitchName",
    "spec"
})
public class UpdateVirtualSwitchRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected String vswitchName;
    @XmlElement(required = true)
    protected HostVirtualSwitchSpec spec;

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
     * Gets the value of the vswitchName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVswitchName() {
        return vswitchName;
    }

    /**
     * Sets the value of the vswitchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVswitchName(String value) {
        this.vswitchName = value;
    }

    /**
     * Gets the value of the spec property.
     * 
     * @return
     *     possible object is
     *     {@link HostVirtualSwitchSpec }
     *     
     */
    public HostVirtualSwitchSpec getSpec() {
        return spec;
    }

    /**
     * Sets the value of the spec property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostVirtualSwitchSpec }
     *     
     */
    public void setSpec(HostVirtualSwitchSpec value) {
        this.spec = value;
    }

}
