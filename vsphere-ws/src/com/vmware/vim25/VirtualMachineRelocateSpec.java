
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineRelocateSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineRelocateSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="datastore" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="diskMoveType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pool" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="host" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="disk" type="{urn:vim25}VirtualMachineRelocateSpecDiskLocator" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transform" type="{urn:vim25}VirtualMachineRelocateTransformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineRelocateSpec", propOrder = {
    "datastore",
    "diskMoveType",
    "pool",
    "host",
    "disk",
    "transform"
})
public class VirtualMachineRelocateSpec
    extends DynamicData
{

    protected ManagedObjectReference datastore;
    protected String diskMoveType;
    protected ManagedObjectReference pool;
    protected ManagedObjectReference host;
    protected List<VirtualMachineRelocateSpecDiskLocator> disk;
    protected VirtualMachineRelocateTransformation transform;

    /**
     * Gets the value of the datastore property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getDatastore() {
        return datastore;
    }

    /**
     * Sets the value of the datastore property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setDatastore(ManagedObjectReference value) {
        this.datastore = value;
    }

    /**
     * Gets the value of the diskMoveType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskMoveType() {
        return diskMoveType;
    }

    /**
     * Sets the value of the diskMoveType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskMoveType(String value) {
        this.diskMoveType = value;
    }

    /**
     * Gets the value of the pool property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getPool() {
        return pool;
    }

    /**
     * Sets the value of the pool property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setPool(ManagedObjectReference value) {
        this.pool = value;
    }

    /**
     * Gets the value of the host property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setHost(ManagedObjectReference value) {
        this.host = value;
    }

    /**
     * Gets the value of the disk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineRelocateSpecDiskLocator }
     * 
     * 
     */
    public List<VirtualMachineRelocateSpecDiskLocator> getDisk() {
        if (disk == null) {
            disk = new ArrayList<VirtualMachineRelocateSpecDiskLocator>();
        }
        return this.disk;
    }

    /**
     * Gets the value of the transform property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineRelocateTransformation }
     *     
     */
    public VirtualMachineRelocateTransformation getTransform() {
        return transform;
    }

    /**
     * Sets the value of the transform property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineRelocateTransformation }
     *     
     */
    public void setTransform(VirtualMachineRelocateTransformation value) {
        this.transform = value;
    }

}
