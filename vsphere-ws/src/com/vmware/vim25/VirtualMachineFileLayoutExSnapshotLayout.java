
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineFileLayoutExSnapshotLayout complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineFileLayoutExSnapshotLayout">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="dataKey" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="disk" type="{urn:vim25}VirtualMachineFileLayoutExDiskLayout" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineFileLayoutExSnapshotLayout", propOrder = {
    "key",
    "dataKey",
    "disk"
})
public class VirtualMachineFileLayoutExSnapshotLayout
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference key;
    protected int dataKey;
    protected List<VirtualMachineFileLayoutExDiskLayout> disk;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setKey(ManagedObjectReference value) {
        this.key = value;
    }

    /**
     * Gets the value of the dataKey property.
     * 
     */
    public int getDataKey() {
        return dataKey;
    }

    /**
     * Sets the value of the dataKey property.
     * 
     */
    public void setDataKey(int value) {
        this.dataKey = value;
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
     * {@link VirtualMachineFileLayoutExDiskLayout }
     * 
     * 
     */
    public List<VirtualMachineFileLayoutExDiskLayout> getDisk() {
        if (disk == null) {
            disk = new ArrayList<VirtualMachineFileLayoutExDiskLayout>();
        }
        return this.disk;
    }

}
