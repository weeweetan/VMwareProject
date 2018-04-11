
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDiskRawDiskMappingVer1BackingOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDiskRawDiskMappingVer1BackingOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceDeviceBackingOption">
 *       &lt;sequence>
 *         &lt;element name="descriptorFileNameExtensions" type="{urn:vim25}ChoiceOption" minOccurs="0"/>
 *         &lt;element name="compatibilityMode" type="{urn:vim25}ChoiceOption"/>
 *         &lt;element name="diskMode" type="{urn:vim25}ChoiceOption"/>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDiskRawDiskMappingVer1BackingOption", propOrder = {
    "descriptorFileNameExtensions",
    "compatibilityMode",
    "diskMode",
    "uuid"
})
public class VirtualDiskRawDiskMappingVer1BackingOption
    extends VirtualDeviceDeviceBackingOption
{

    protected ChoiceOption descriptorFileNameExtensions;
    @XmlElement(required = true)
    protected ChoiceOption compatibilityMode;
    @XmlElement(required = true)
    protected ChoiceOption diskMode;
    protected boolean uuid;

    /**
     * Gets the value of the descriptorFileNameExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOption }
     *     
     */
    public ChoiceOption getDescriptorFileNameExtensions() {
        return descriptorFileNameExtensions;
    }

    /**
     * Sets the value of the descriptorFileNameExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOption }
     *     
     */
    public void setDescriptorFileNameExtensions(ChoiceOption value) {
        this.descriptorFileNameExtensions = value;
    }

    /**
     * Gets the value of the compatibilityMode property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOption }
     *     
     */
    public ChoiceOption getCompatibilityMode() {
        return compatibilityMode;
    }

    /**
     * Sets the value of the compatibilityMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOption }
     *     
     */
    public void setCompatibilityMode(ChoiceOption value) {
        this.compatibilityMode = value;
    }

    /**
     * Gets the value of the diskMode property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOption }
     *     
     */
    public ChoiceOption getDiskMode() {
        return diskMode;
    }

    /**
     * Sets the value of the diskMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOption }
     *     
     */
    public void setDiskMode(ChoiceOption value) {
        this.diskMode = value;
    }

    /**
     * Gets the value of the uuid property.
     * 
     */
    public boolean isUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     */
    public void setUuid(boolean value) {
        this.uuid = value;
    }

}
