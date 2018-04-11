
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StoragePlacementAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StoragePlacementAction">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterAction">
 *       &lt;sequence>
 *         &lt;element name="vm" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="relocateSpec" type="{urn:vim25}VirtualMachineRelocateSpec"/>
 *         &lt;element name="destination" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="spaceUtilBefore" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="spaceUtilAfter" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ioLatencyBefore" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoragePlacementAction", propOrder = {
    "vm",
    "relocateSpec",
    "destination",
    "spaceUtilBefore",
    "spaceUtilAfter",
    "ioLatencyBefore"
})
public class StoragePlacementAction
    extends ClusterAction
{

    protected ManagedObjectReference vm;
    @XmlElement(required = true)
    protected VirtualMachineRelocateSpec relocateSpec;
    @XmlElement(required = true)
    protected ManagedObjectReference destination;
    protected Float spaceUtilBefore;
    protected Float spaceUtilAfter;
    protected Float ioLatencyBefore;

    /**
     * Gets the value of the vm property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getVm() {
        return vm;
    }

    /**
     * Sets the value of the vm property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setVm(ManagedObjectReference value) {
        this.vm = value;
    }

    /**
     * Gets the value of the relocateSpec property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineRelocateSpec }
     *     
     */
    public VirtualMachineRelocateSpec getRelocateSpec() {
        return relocateSpec;
    }

    /**
     * Sets the value of the relocateSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineRelocateSpec }
     *     
     */
    public void setRelocateSpec(VirtualMachineRelocateSpec value) {
        this.relocateSpec = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setDestination(ManagedObjectReference value) {
        this.destination = value;
    }

    /**
     * Gets the value of the spaceUtilBefore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSpaceUtilBefore() {
        return spaceUtilBefore;
    }

    /**
     * Sets the value of the spaceUtilBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSpaceUtilBefore(Float value) {
        this.spaceUtilBefore = value;
    }

    /**
     * Gets the value of the spaceUtilAfter property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSpaceUtilAfter() {
        return spaceUtilAfter;
    }

    /**
     * Sets the value of the spaceUtilAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSpaceUtilAfter(Float value) {
        this.spaceUtilAfter = value;
    }

    /**
     * Gets the value of the ioLatencyBefore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getIoLatencyBefore() {
        return ioLatencyBefore;
    }

    /**
     * Sets the value of the ioLatencyBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setIoLatencyBefore(Float value) {
        this.ioLatencyBefore = value;
    }

}
