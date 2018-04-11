
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineScsiDiskDeviceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineScsiDiskDeviceInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualMachineDiskDeviceInfo">
 *       &lt;sequence>
 *         &lt;element name="disk" type="{urn:vim25}HostScsiDisk" minOccurs="0"/>
 *         &lt;element name="transportHint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lunNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineScsiDiskDeviceInfo", propOrder = {
    "disk",
    "transportHint",
    "lunNumber"
})
public class VirtualMachineScsiDiskDeviceInfo
    extends VirtualMachineDiskDeviceInfo
{

    protected HostScsiDisk disk;
    protected String transportHint;
    protected Integer lunNumber;

    /**
     * Gets the value of the disk property.
     * 
     * @return
     *     possible object is
     *     {@link HostScsiDisk }
     *     
     */
    public HostScsiDisk getDisk() {
        return disk;
    }

    /**
     * Sets the value of the disk property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostScsiDisk }
     *     
     */
    public void setDisk(HostScsiDisk value) {
        this.disk = value;
    }

    /**
     * Gets the value of the transportHint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportHint() {
        return transportHint;
    }

    /**
     * Sets the value of the transportHint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportHint(String value) {
        this.transportHint = value;
    }

    /**
     * Gets the value of the lunNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLunNumber() {
        return lunNumber;
    }

    /**
     * Sets the value of the lunNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLunNumber(Integer value) {
        this.lunNumber = value;
    }

}
