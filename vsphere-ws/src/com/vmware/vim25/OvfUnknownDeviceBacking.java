
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfUnknownDeviceBacking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfUnknownDeviceBacking">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfHardwareExport">
 *       &lt;sequence>
 *         &lt;element name="backing" type="{urn:vim25}VirtualDeviceBackingInfo"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfUnknownDeviceBacking", propOrder = {
    "backing"
})
public class OvfUnknownDeviceBacking
    extends OvfHardwareExport
{

    @XmlElement(required = true)
    protected VirtualDeviceBackingInfo backing;

    /**
     * Gets the value of the backing property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualDeviceBackingInfo }
     *     
     */
    public VirtualDeviceBackingInfo getBacking() {
        return backing;
    }

    /**
     * Sets the value of the backing property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualDeviceBackingInfo }
     *     
     */
    public void setBacking(VirtualDeviceBackingInfo value) {
        this.backing = value;
    }

}
