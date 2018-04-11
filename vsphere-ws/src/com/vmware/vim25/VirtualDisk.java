
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDisk complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDisk">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDevice">
 *       &lt;sequence>
 *         &lt;element name="capacityInKB" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="shares" type="{urn:vim25}SharesInfo" minOccurs="0"/>
 *         &lt;element name="storageIOAllocation" type="{urn:vim25}StorageIOAllocationInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDisk", propOrder = {
    "capacityInKB",
    "shares",
    "storageIOAllocation"
})
public class VirtualDisk
    extends VirtualDevice
{

    protected long capacityInKB;
    protected SharesInfo shares;
    protected StorageIOAllocationInfo storageIOAllocation;

    /**
     * Gets the value of the capacityInKB property.
     * 
     */
    public long getCapacityInKB() {
        return capacityInKB;
    }

    /**
     * Sets the value of the capacityInKB property.
     * 
     */
    public void setCapacityInKB(long value) {
        this.capacityInKB = value;
    }

    /**
     * Gets the value of the shares property.
     * 
     * @return
     *     possible object is
     *     {@link SharesInfo }
     *     
     */
    public SharesInfo getShares() {
        return shares;
    }

    /**
     * Sets the value of the shares property.
     * 
     * @param value
     *     allowed object is
     *     {@link SharesInfo }
     *     
     */
    public void setShares(SharesInfo value) {
        this.shares = value;
    }

    /**
     * Gets the value of the storageIOAllocation property.
     * 
     * @return
     *     possible object is
     *     {@link StorageIOAllocationInfo }
     *     
     */
    public StorageIOAllocationInfo getStorageIOAllocation() {
        return storageIOAllocation;
    }

    /**
     * Sets the value of the storageIOAllocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageIOAllocationInfo }
     *     
     */
    public void setStorageIOAllocation(StorageIOAllocationInfo value) {
        this.storageIOAllocation = value;
    }

}
