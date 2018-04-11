
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualHardware complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualHardware">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="numCPU" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numCoresPerSocket" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="memoryMB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="virtualICH7MPresent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="virtualSMCPresent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="device" type="{urn:vim25}VirtualDevice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualHardware", propOrder = {
    "numCPU",
    "numCoresPerSocket",
    "memoryMB",
    "virtualICH7MPresent",
    "virtualSMCPresent",
    "device"
})
public class VirtualHardware
    extends DynamicData
{

    protected int numCPU;
    protected Integer numCoresPerSocket;
    protected int memoryMB;
    protected Boolean virtualICH7MPresent;
    protected Boolean virtualSMCPresent;
    protected List<VirtualDevice> device;

    /**
     * Gets the value of the numCPU property.
     * 
     */
    public int getNumCPU() {
        return numCPU;
    }

    /**
     * Sets the value of the numCPU property.
     * 
     */
    public void setNumCPU(int value) {
        this.numCPU = value;
    }

    /**
     * Gets the value of the numCoresPerSocket property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumCoresPerSocket() {
        return numCoresPerSocket;
    }

    /**
     * Sets the value of the numCoresPerSocket property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumCoresPerSocket(Integer value) {
        this.numCoresPerSocket = value;
    }

    /**
     * Gets the value of the memoryMB property.
     * 
     */
    public int getMemoryMB() {
        return memoryMB;
    }

    /**
     * Sets the value of the memoryMB property.
     * 
     */
    public void setMemoryMB(int value) {
        this.memoryMB = value;
    }

    /**
     * Gets the value of the virtualICH7MPresent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVirtualICH7MPresent() {
        return virtualICH7MPresent;
    }

    /**
     * Sets the value of the virtualICH7MPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVirtualICH7MPresent(Boolean value) {
        this.virtualICH7MPresent = value;
    }

    /**
     * Gets the value of the virtualSMCPresent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVirtualSMCPresent() {
        return virtualSMCPresent;
    }

    /**
     * Sets the value of the virtualSMCPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVirtualSMCPresent(Boolean value) {
        this.virtualSMCPresent = value;
    }

    /**
     * Gets the value of the device property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the device property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualDevice }
     * 
     * 
     */
    public List<VirtualDevice> getDevice() {
        if (device == null) {
            device = new ArrayList<VirtualDevice>();
        }
        return this.device;
    }

}
