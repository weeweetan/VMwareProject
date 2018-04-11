
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddVirtualNicRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddVirtualNicRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="portgroup" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nic" type="{urn:vim25}HostVirtualNicSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddVirtualNicRequestType", propOrder = {
    "_this",
    "portgroup",
    "nic"
})
public class AddVirtualNicRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected String portgroup;
    @XmlElement(required = true)
    protected HostVirtualNicSpec nic;

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
     * Gets the value of the portgroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortgroup() {
        return portgroup;
    }

    /**
     * Sets the value of the portgroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortgroup(String value) {
        this.portgroup = value;
    }

    /**
     * Gets the value of the nic property.
     * 
     * @return
     *     possible object is
     *     {@link HostVirtualNicSpec }
     *     
     */
    public HostVirtualNicSpec getNic() {
        return nic;
    }

    /**
     * Sets the value of the nic property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostVirtualNicSpec }
     *     
     */
    public void setNic(HostVirtualNicSpec value) {
        this.nic = value;
    }

}
