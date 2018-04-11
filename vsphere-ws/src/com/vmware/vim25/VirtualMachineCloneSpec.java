
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineCloneSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineCloneSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="location" type="{urn:vim25}VirtualMachineRelocateSpec"/>
 *         &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="config" type="{urn:vim25}VirtualMachineConfigSpec" minOccurs="0"/>
 *         &lt;element name="customization" type="{urn:vim25}CustomizationSpec" minOccurs="0"/>
 *         &lt;element name="powerOn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="snapshot" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineCloneSpec", propOrder = {
    "location",
    "template",
    "config",
    "customization",
    "powerOn",
    "snapshot"
})
public class VirtualMachineCloneSpec
    extends DynamicData
{

    @XmlElement(required = true)
    protected VirtualMachineRelocateSpec location;
    protected boolean template;
    protected VirtualMachineConfigSpec config;
    protected CustomizationSpec customization;
    protected boolean powerOn;
    protected ManagedObjectReference snapshot;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineRelocateSpec }
     *     
     */
    public VirtualMachineRelocateSpec getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineRelocateSpec }
     *     
     */
    public void setLocation(VirtualMachineRelocateSpec value) {
        this.location = value;
    }

    /**
     * Gets the value of the template property.
     * 
     */
    public boolean isTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     * 
     */
    public void setTemplate(boolean value) {
        this.template = value;
    }

    /**
     * Gets the value of the config property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineConfigSpec }
     *     
     */
    public VirtualMachineConfigSpec getConfig() {
        return config;
    }

    /**
     * Sets the value of the config property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineConfigSpec }
     *     
     */
    public void setConfig(VirtualMachineConfigSpec value) {
        this.config = value;
    }

    /**
     * Gets the value of the customization property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationSpec }
     *     
     */
    public CustomizationSpec getCustomization() {
        return customization;
    }

    /**
     * Sets the value of the customization property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationSpec }
     *     
     */
    public void setCustomization(CustomizationSpec value) {
        this.customization = value;
    }

    /**
     * Gets the value of the powerOn property.
     * 
     */
    public boolean isPowerOn() {
        return powerOn;
    }

    /**
     * Sets the value of the powerOn property.
     * 
     */
    public void setPowerOn(boolean value) {
        this.powerOn = value;
    }

    /**
     * Gets the value of the snapshot property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getSnapshot() {
        return snapshot;
    }

    /**
     * Sets the value of the snapshot property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setSnapshot(ManagedObjectReference value) {
        this.snapshot = value;
    }

}
