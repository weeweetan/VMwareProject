
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateInternetScsiAdvancedOptionsRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateInternetScsiAdvancedOptionsRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="iScsiHbaDevice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="targetSet" type="{urn:vim25}HostInternetScsiHbaTargetSet" minOccurs="0"/>
 *         &lt;element name="options" type="{urn:vim25}HostInternetScsiHbaParamValue" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateInternetScsiAdvancedOptionsRequestType", propOrder = {
    "_this",
    "iScsiHbaDevice",
    "targetSet",
    "options"
})
public class UpdateInternetScsiAdvancedOptionsRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected String iScsiHbaDevice;
    protected HostInternetScsiHbaTargetSet targetSet;
    @XmlElement(required = true)
    protected List<HostInternetScsiHbaParamValue> options;

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
     * Gets the value of the targetSet property.
     * 
     * @return
     *     possible object is
     *     {@link HostInternetScsiHbaTargetSet }
     *     
     */
    public HostInternetScsiHbaTargetSet getTargetSet() {
        return targetSet;
    }

    /**
     * Sets the value of the targetSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostInternetScsiHbaTargetSet }
     *     
     */
    public void setTargetSet(HostInternetScsiHbaTargetSet value) {
        this.targetSet = value;
    }

    /**
     * Gets the value of the options property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the options property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostInternetScsiHbaParamValue }
     * 
     * 
     */
    public List<HostInternetScsiHbaParamValue> getOptions() {
        if (options == null) {
            options = new ArrayList<HostInternetScsiHbaParamValue>();
        }
        return this.options;
    }

}
