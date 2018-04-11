
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostScsiDisk complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostScsiDisk">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ScsiLun">
 *       &lt;sequence>
 *         &lt;element name="capacity" type="{urn:vim25}HostDiskDimensionsLba"/>
 *         &lt;element name="devicePath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ssd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostScsiDisk", propOrder = {
    "capacity",
    "devicePath",
    "ssd"
})
public class HostScsiDisk
    extends ScsiLun
{

    @XmlElement(required = true)
    protected HostDiskDimensionsLba capacity;
    @XmlElement(required = true)
    protected String devicePath;
    protected Boolean ssd;

    /**
     * Gets the value of the capacity property.
     * 
     * @return
     *     possible object is
     *     {@link HostDiskDimensionsLba }
     *     
     */
    public HostDiskDimensionsLba getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostDiskDimensionsLba }
     *     
     */
    public void setCapacity(HostDiskDimensionsLba value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the devicePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevicePath() {
        return devicePath;
    }

    /**
     * Sets the value of the devicePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevicePath(String value) {
        this.devicePath = value;
    }

    /**
     * Gets the value of the ssd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSsd() {
        return ssd;
    }

    /**
     * Sets the value of the ssd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSsd(Boolean value) {
        this.ssd = value;
    }

}
