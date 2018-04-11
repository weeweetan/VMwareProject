
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageMigrationAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageMigrationAction">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterAction">
 *       &lt;sequence>
 *         &lt;element name="vm" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="relocateSpec" type="{urn:vim25}VirtualMachineRelocateSpec"/>
 *         &lt;element name="source" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="destination" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="sizeTransferred" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="spaceUtilSrcBefore" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="spaceUtilDstBefore" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="spaceUtilSrcAfter" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="spaceUtilDstAfter" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ioLatencySrcBefore" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ioLatencyDstBefore" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageMigrationAction", propOrder = {
    "vm",
    "relocateSpec",
    "source",
    "destination",
    "sizeTransferred",
    "spaceUtilSrcBefore",
    "spaceUtilDstBefore",
    "spaceUtilSrcAfter",
    "spaceUtilDstAfter",
    "ioLatencySrcBefore",
    "ioLatencyDstBefore"
})
public class StorageMigrationAction
    extends ClusterAction
{

    @XmlElement(required = true)
    protected ManagedObjectReference vm;
    @XmlElement(required = true)
    protected VirtualMachineRelocateSpec relocateSpec;
    @XmlElement(required = true)
    protected ManagedObjectReference source;
    @XmlElement(required = true)
    protected ManagedObjectReference destination;
    protected long sizeTransferred;
    protected Float spaceUtilSrcBefore;
    protected Float spaceUtilDstBefore;
    protected Float spaceUtilSrcAfter;
    protected Float spaceUtilDstAfter;
    protected Float ioLatencySrcBefore;
    protected Float ioLatencyDstBefore;

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
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setSource(ManagedObjectReference value) {
        this.source = value;
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
     * Gets the value of the sizeTransferred property.
     * 
     */
    public long getSizeTransferred() {
        return sizeTransferred;
    }

    /**
     * Sets the value of the sizeTransferred property.
     * 
     */
    public void setSizeTransferred(long value) {
        this.sizeTransferred = value;
    }

    /**
     * Gets the value of the spaceUtilSrcBefore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSpaceUtilSrcBefore() {
        return spaceUtilSrcBefore;
    }

    /**
     * Sets the value of the spaceUtilSrcBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSpaceUtilSrcBefore(Float value) {
        this.spaceUtilSrcBefore = value;
    }

    /**
     * Gets the value of the spaceUtilDstBefore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSpaceUtilDstBefore() {
        return spaceUtilDstBefore;
    }

    /**
     * Sets the value of the spaceUtilDstBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSpaceUtilDstBefore(Float value) {
        this.spaceUtilDstBefore = value;
    }

    /**
     * Gets the value of the spaceUtilSrcAfter property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSpaceUtilSrcAfter() {
        return spaceUtilSrcAfter;
    }

    /**
     * Sets the value of the spaceUtilSrcAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSpaceUtilSrcAfter(Float value) {
        this.spaceUtilSrcAfter = value;
    }

    /**
     * Gets the value of the spaceUtilDstAfter property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSpaceUtilDstAfter() {
        return spaceUtilDstAfter;
    }

    /**
     * Sets the value of the spaceUtilDstAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSpaceUtilDstAfter(Float value) {
        this.spaceUtilDstAfter = value;
    }

    /**
     * Gets the value of the ioLatencySrcBefore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getIoLatencySrcBefore() {
        return ioLatencySrcBefore;
    }

    /**
     * Sets the value of the ioLatencySrcBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setIoLatencySrcBefore(Float value) {
        this.ioLatencySrcBefore = value;
    }

    /**
     * Gets the value of the ioLatencyDstBefore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getIoLatencyDstBefore() {
        return ioLatencyDstBefore;
    }

    /**
     * Sets the value of the ioLatencyDstBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setIoLatencyDstBefore(Float value) {
        this.ioLatencyDstBefore = value;
    }

}
