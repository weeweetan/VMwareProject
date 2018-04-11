
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDiskOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDiskOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceOption">
 *       &lt;sequence>
 *         &lt;element name="capacityInKB" type="{urn:vim25}LongOption"/>
 *         &lt;element name="ioAllocationOption" type="{urn:vim25}StorageIOAllocationOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDiskOption", propOrder = {
    "capacityInKB",
    "ioAllocationOption"
})
public class VirtualDiskOption
    extends VirtualDeviceOption
{

    @XmlElement(required = true)
    protected LongOption capacityInKB;
    protected StorageIOAllocationOption ioAllocationOption;

    /**
     * Gets the value of the capacityInKB property.
     * 
     * @return
     *     possible object is
     *     {@link LongOption }
     *     
     */
    public LongOption getCapacityInKB() {
        return capacityInKB;
    }

    /**
     * Sets the value of the capacityInKB property.
     * 
     * @param value
     *     allowed object is
     *     {@link LongOption }
     *     
     */
    public void setCapacityInKB(LongOption value) {
        this.capacityInKB = value;
    }

    /**
     * Gets the value of the ioAllocationOption property.
     * 
     * @return
     *     possible object is
     *     {@link StorageIOAllocationOption }
     *     
     */
    public StorageIOAllocationOption getIoAllocationOption() {
        return ioAllocationOption;
    }

    /**
     * Sets the value of the ioAllocationOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageIOAllocationOption }
     *     
     */
    public void setIoAllocationOption(StorageIOAllocationOption value) {
        this.ioAllocationOption = value;
    }

}
