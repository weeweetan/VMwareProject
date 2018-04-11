
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfUnknownDevice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfUnknownDevice">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfSystemFault">
 *       &lt;sequence>
 *         &lt;element name="device" type="{urn:vim25}VirtualDevice" minOccurs="0"/>
 *         &lt;element name="vmName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfUnknownDevice", propOrder = {
    "device",
    "vmName"
})
public class OvfUnknownDevice
    extends OvfSystemFault
{

    protected VirtualDevice device;
    @XmlElement(required = true)
    protected String vmName;

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualDevice }
     *     
     */
    public VirtualDevice getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualDevice }
     *     
     */
    public void setDevice(VirtualDevice value) {
        this.device = value;
    }

    /**
     * Gets the value of the vmName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVmName() {
        return vmName;
    }

    /**
     * Sets the value of the vmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVmName(String value) {
        this.vmName = value;
    }

}
