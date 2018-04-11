
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineFileLayoutSnapshotLayout complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineFileLayoutSnapshotLayout">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineFileLayoutSnapshotLayout" type="{urn:vim25}VirtualMachineFileLayoutSnapshotLayout" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineFileLayoutSnapshotLayout", propOrder = {
    "virtualMachineFileLayoutSnapshotLayout"
})
public class ArrayOfVirtualMachineFileLayoutSnapshotLayout {

    @XmlElement(name = "VirtualMachineFileLayoutSnapshotLayout")
    protected List<VirtualMachineFileLayoutSnapshotLayout> virtualMachineFileLayoutSnapshotLayout;

    /**
     * Gets the value of the virtualMachineFileLayoutSnapshotLayout property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineFileLayoutSnapshotLayout property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineFileLayoutSnapshotLayout().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFileLayoutSnapshotLayout }
     * 
     * 
     */
    public List<VirtualMachineFileLayoutSnapshotLayout> getVirtualMachineFileLayoutSnapshotLayout() {
        if (virtualMachineFileLayoutSnapshotLayout == null) {
            virtualMachineFileLayoutSnapshotLayout = new ArrayList<VirtualMachineFileLayoutSnapshotLayout>();
        }
        return this.virtualMachineFileLayoutSnapshotLayout;
    }

}
