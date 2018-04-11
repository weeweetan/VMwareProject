
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDiskRawDiskVer2BackingOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDiskRawDiskVer2BackingOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceDeviceBackingOption">
 *       &lt;sequence>
 *         &lt;element name="descriptorFileNameExtensions" type="{urn:vim25}ChoiceOption"/>
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
@XmlType(name = "VirtualDiskRawDiskVer2BackingOption", propOrder = {
    "descriptorFileNameExtensions",
    "uuid"
})
@XmlSeeAlso({
    VirtualDiskPartitionedRawDiskVer2BackingOption.class
})
public class VirtualDiskRawDiskVer2BackingOption
    extends VirtualDeviceDeviceBackingOption
{

    @XmlElement(required = true)
    protected ChoiceOption descriptorFileNameExtensions;
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
