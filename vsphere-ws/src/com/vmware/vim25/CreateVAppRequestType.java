
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateVAppRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateVAppRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resSpec" type="{urn:vim25}ResourceConfigSpec"/>
 *         &lt;element name="configSpec" type="{urn:vim25}VAppConfigSpec"/>
 *         &lt;element name="vmFolder" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateVAppRequestType", propOrder = {
    "_this",
    "name",
    "resSpec",
    "configSpec",
    "vmFolder"
})
public class CreateVAppRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected ResourceConfigSpec resSpec;
    @XmlElement(required = true)
    protected VAppConfigSpec configSpec;
    protected ManagedObjectReference vmFolder;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the resSpec property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceConfigSpec }
     *     
     */
    public ResourceConfigSpec getResSpec() {
        return resSpec;
    }

    /**
     * Sets the value of the resSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceConfigSpec }
     *     
     */
    public void setResSpec(ResourceConfigSpec value) {
        this.resSpec = value;
    }

    /**
     * Gets the value of the configSpec property.
     * 
     * @return
     *     possible object is
     *     {@link VAppConfigSpec }
     *     
     */
    public VAppConfigSpec getConfigSpec() {
        return configSpec;
    }

    /**
     * Sets the value of the configSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link VAppConfigSpec }
     *     
     */
    public void setConfigSpec(VAppConfigSpec value) {
        this.configSpec = value;
    }

    /**
     * Gets the value of the vmFolder property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getVmFolder() {
        return vmFolder;
    }

    /**
     * Sets the value of the vmFolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setVmFolder(ManagedObjectReference value) {
        this.vmFolder = value;
    }

}
