
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineFileLayoutDiskLayout complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineFileLayoutDiskLayout">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineFileLayoutDiskLayout" type="{urn:vim25}VirtualMachineFileLayoutDiskLayout" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineFileLayoutDiskLayout", propOrder = {
    "virtualMachineFileLayoutDiskLayout"
})
public class ArrayOfVirtualMachineFileLayoutDiskLayout {

    @XmlElement(name = "VirtualMachineFileLayoutDiskLayout")
    protected List<VirtualMachineFileLayoutDiskLayout> virtualMachineFileLayoutDiskLayout;

    /**
     * Gets the value of the virtualMachineFileLayoutDiskLayout property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineFileLayoutDiskLayout property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineFileLayoutDiskLayout().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFileLayoutDiskLayout }
     * 
     * 
     */
    public List<VirtualMachineFileLayoutDiskLayout> getVirtualMachineFileLayoutDiskLayout() {
        if (virtualMachineFileLayoutDiskLayout == null) {
            virtualMachineFileLayoutDiskLayout = new ArrayList<VirtualMachineFileLayoutDiskLayout>();
        }
        return this.virtualMachineFileLayoutDiskLayout;
    }

}
