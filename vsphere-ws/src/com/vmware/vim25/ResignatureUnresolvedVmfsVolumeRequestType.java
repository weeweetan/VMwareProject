
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResignatureUnresolvedVmfsVolumeRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResignatureUnresolvedVmfsVolumeRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="resolutionSpec" type="{urn:vim25}HostUnresolvedVmfsResignatureSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResignatureUnresolvedVmfsVolumeRequestType", propOrder = {
    "_this",
    "resolutionSpec"
})
public class ResignatureUnresolvedVmfsVolumeRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected HostUnresolvedVmfsResignatureSpec resolutionSpec;

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
     * Gets the value of the resolutionSpec property.
     * 
     * @return
     *     possible object is
     *     {@link HostUnresolvedVmfsResignatureSpec }
     *     
     */
    public HostUnresolvedVmfsResignatureSpec getResolutionSpec() {
        return resolutionSpec;
    }

    /**
     * Sets the value of the resolutionSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostUnresolvedVmfsResignatureSpec }
     *     
     */
    public void setResolutionSpec(HostUnresolvedVmfsResignatureSpec value) {
        this.resolutionSpec = value;
    }

}
