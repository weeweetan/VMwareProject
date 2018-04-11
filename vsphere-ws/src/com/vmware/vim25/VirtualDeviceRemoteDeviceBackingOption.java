
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDeviceRemoteDeviceBackingOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDeviceRemoteDeviceBackingOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceBackingOption">
 *       &lt;sequence>
 *         &lt;element name="autoDetectAvailable" type="{urn:vim25}BoolOption"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDeviceRemoteDeviceBackingOption", propOrder = {
    "autoDetectAvailable"
})
@XmlSeeAlso({
    VirtualCdromRemotePassthroughBackingOption.class,
    VirtualFloppyRemoteDeviceBackingOption.class,
    VirtualUSBRemoteClientBackingOption.class
})
public class VirtualDeviceRemoteDeviceBackingOption
    extends VirtualDeviceBackingOption
{

    @XmlElement(required = true)
    protected BoolOption autoDetectAvailable;

    /**
     * Gets the value of the autoDetectAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getAutoDetectAvailable() {
        return autoDetectAvailable;
    }

    /**
     * Sets the value of the autoDetectAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setAutoDetectAvailable(BoolOption value) {
        this.autoDetectAvailable = value;
    }

}
