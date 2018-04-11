
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualPointingDeviceBackingOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualPointingDeviceBackingOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceDeviceBackingOption">
 *       &lt;sequence>
 *         &lt;element name="hostPointingDevice" type="{urn:vim25}ChoiceOption"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualPointingDeviceBackingOption", propOrder = {
    "hostPointingDevice"
})
public class VirtualPointingDeviceBackingOption
    extends VirtualDeviceDeviceBackingOption
{

    @XmlElement(required = true)
    protected ChoiceOption hostPointingDevice;

    /**
     * Gets the value of the hostPointingDevice property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOption }
     *     
     */
    public ChoiceOption getHostPointingDevice() {
        return hostPointingDevice;
    }

    /**
     * Sets the value of the hostPointingDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOption }
     *     
     */
    public void setHostPointingDevice(ChoiceOption value) {
        this.hostPointingDevice = value;
    }

}
