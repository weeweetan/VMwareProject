
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualControllerOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualControllerOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceOption">
 *       &lt;sequence>
 *         &lt;element name="devices" type="{urn:vim25}IntOption"/>
 *         &lt;element name="supportedDevice" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualControllerOption", propOrder = {
    "devices",
    "supportedDevice"
})
@XmlSeeAlso({
    VirtualUSBControllerOption.class,
    VirtualPS2ControllerOption.class,
    VirtualPCIControllerOption.class,
    VirtualSIOControllerOption.class,
    VirtualIDEControllerOption.class,
    VirtualSCSIControllerOption.class,
    VirtualUSBXHCIControllerOption.class
})
public class VirtualControllerOption
    extends VirtualDeviceOption
{

    @XmlElement(required = true)
    protected IntOption devices;
    protected List<String> supportedDevice;

    /**
     * Gets the value of the devices property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getDevices() {
        return devices;
    }

    /**
     * Sets the value of the devices property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setDevices(IntOption value) {
        this.devices = value;
    }

    /**
     * Gets the value of the supportedDevice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedDevice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedDevice() {
        if (supportedDevice == null) {
            supportedDevice = new ArrayList<String>();
        }
        return this.supportedDevice;
    }

}
