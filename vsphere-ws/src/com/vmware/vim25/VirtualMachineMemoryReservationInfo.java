
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineMemoryReservationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineMemoryReservationInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="virtualMachineMin" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="virtualMachineMax" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="virtualMachineReserved" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="allocationPolicy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineMemoryReservationInfo", propOrder = {
    "virtualMachineMin",
    "virtualMachineMax",
    "virtualMachineReserved",
    "allocationPolicy"
})
public class VirtualMachineMemoryReservationInfo
    extends DynamicData
{

    protected long virtualMachineMin;
    protected long virtualMachineMax;
    protected long virtualMachineReserved;
    @XmlElement(required = true)
    protected String allocationPolicy;

    /**
     * Gets the value of the virtualMachineMin property.
     * 
     */
    public long getVirtualMachineMin() {
        return virtualMachineMin;
    }

    /**
     * Sets the value of the virtualMachineMin property.
     * 
     */
    public void setVirtualMachineMin(long value) {
        this.virtualMachineMin = value;
    }

    /**
     * Gets the value of the virtualMachineMax property.
     * 
     */
    public long getVirtualMachineMax() {
        return virtualMachineMax;
    }

    /**
     * Sets the value of the virtualMachineMax property.
     * 
     */
    public void setVirtualMachineMax(long value) {
        this.virtualMachineMax = value;
    }

    /**
     * Gets the value of the virtualMachineReserved property.
     * 
     */
    public long getVirtualMachineReserved() {
        return virtualMachineReserved;
    }

    /**
     * Sets the value of the virtualMachineReserved property.
     * 
     */
    public void setVirtualMachineReserved(long value) {
        this.virtualMachineReserved = value;
    }

    /**
     * Gets the value of the allocationPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllocationPolicy() {
        return allocationPolicy;
    }

    /**
     * Sets the value of the allocationPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllocationPolicy(String value) {
        this.allocationPolicy = value;
    }

}
