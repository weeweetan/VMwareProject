
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RemoveInternetScsiStaticTargetsRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RemoveInternetScsiStaticTargetsRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="iScsiHbaDevice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="targets" type="{urn:vim25}HostInternetScsiHbaStaticTarget" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemoveInternetScsiStaticTargetsRequestType", propOrder = {
    "_this",
    "iScsiHbaDevice",
    "targets"
})
public class RemoveInternetScsiStaticTargetsRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected String iScsiHbaDevice;
    @XmlElement(required = true)
    protected List<HostInternetScsiHbaStaticTarget> targets;

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
     * Gets the value of the targets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostInternetScsiHbaStaticTarget }
     * 
     * 
     */
    public List<HostInternetScsiHbaStaticTarget> getTargets() {
        if (targets == null) {
            targets = new ArrayList<HostInternetScsiHbaStaticTarget>();
        }
        return this.targets;
    }

}
