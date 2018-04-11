
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineSnapshotInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineSnapshotInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="currentSnapshot" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="rootSnapshotList" type="{urn:vim25}VirtualMachineSnapshotTree" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineSnapshotInfo", propOrder = {
    "currentSnapshot",
    "rootSnapshotList"
})
public class VirtualMachineSnapshotInfo
    extends DynamicData
{

    protected ManagedObjectReference currentSnapshot;
    @XmlElement(required = true)
    protected List<VirtualMachineSnapshotTree> rootSnapshotList;

    /**
     * Gets the value of the currentSnapshot property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getCurrentSnapshot() {
        return currentSnapshot;
    }

    /**
     * Sets the value of the currentSnapshot property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setCurrentSnapshot(ManagedObjectReference value) {
        this.currentSnapshot = value;
    }

    /**
     * Gets the value of the rootSnapshotList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rootSnapshotList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRootSnapshotList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineSnapshotTree }
     * 
     * 
     */
    public List<VirtualMachineSnapshotTree> getRootSnapshotList() {
        if (rootSnapshotList == null) {
            rootSnapshotList = new ArrayList<VirtualMachineSnapshotTree>();
        }
        return this.rootSnapshotList;
    }

}
