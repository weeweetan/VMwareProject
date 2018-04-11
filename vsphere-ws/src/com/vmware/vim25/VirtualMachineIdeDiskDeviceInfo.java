
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineIdeDiskDeviceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineIdeDiskDeviceInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualMachineDiskDeviceInfo">
 *       &lt;sequence>
 *         &lt;element name="partitionTable" type="{urn:vim25}VirtualMachineIdeDiskDevicePartitionInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineIdeDiskDeviceInfo", propOrder = {
    "partitionTable"
})
public class VirtualMachineIdeDiskDeviceInfo
    extends VirtualMachineDiskDeviceInfo
{

    protected List<VirtualMachineIdeDiskDevicePartitionInfo> partitionTable;

    /**
     * Gets the value of the partitionTable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partitionTable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartitionTable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineIdeDiskDevicePartitionInfo }
     * 
     * 
     */
    public List<VirtualMachineIdeDiskDevicePartitionInfo> getPartitionTable() {
        if (partitionTable == null) {
            partitionTable = new ArrayList<VirtualMachineIdeDiskDevicePartitionInfo>();
        }
        return this.partitionTable;
    }

}
