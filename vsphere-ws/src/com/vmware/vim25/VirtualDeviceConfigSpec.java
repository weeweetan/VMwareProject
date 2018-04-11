
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDeviceConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDeviceConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="operation" type="{urn:vim25}VirtualDeviceConfigSpecOperation" minOccurs="0"/>
 *         &lt;element name="fileOperation" type="{urn:vim25}VirtualDeviceConfigSpecFileOperation" minOccurs="0"/>
 *         &lt;element name="device" type="{urn:vim25}VirtualDevice"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDeviceConfigSpec", propOrder = {
    "operation",
    "fileOperation",
    "device"
})
public class VirtualDeviceConfigSpec
    extends DynamicData
{

    protected VirtualDeviceConfigSpecOperation operation;
    protected VirtualDeviceConfigSpecFileOperation fileOperation;
    @XmlElement(required = true)
    protected VirtualDevice device;

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualDeviceConfigSpecOperation }
     *     
     */
    public VirtualDeviceConfigSpecOperation getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualDeviceConfigSpecOperation }
     *     
     */
    public void setOperation(VirtualDeviceConfigSpecOperation value) {
        this.operation = value;
    }

    /**
     * Gets the value of the fileOperation property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualDeviceConfigSpecFileOperation }
     *     
     */
    public VirtualDeviceConfigSpecFileOperation getFileOperation() {
        return fileOperation;
    }

    /**
     * Sets the value of the fileOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualDeviceConfigSpecFileOperation }
     *     
     */
    public void setFileOperation(VirtualDeviceConfigSpecFileOperation value) {
        this.fileOperation = value;
    }

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

}
