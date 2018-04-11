
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineDisplayTopology complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineDisplayTopology">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineDisplayTopology" type="{urn:vim25}VirtualMachineDisplayTopology" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineDisplayTopology", propOrder = {
    "virtualMachineDisplayTopology"
})
public class ArrayOfVirtualMachineDisplayTopology {

    @XmlElement(name = "VirtualMachineDisplayTopology")
    protected List<VirtualMachineDisplayTopology> virtualMachineDisplayTopology;

    /**
     * Gets the value of the virtualMachineDisplayTopology property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineDisplayTopology property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineDisplayTopology().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineDisplayTopology }
     * 
     * 
     */
    public List<VirtualMachineDisplayTopology> getVirtualMachineDisplayTopology() {
        if (virtualMachineDisplayTopology == null) {
            virtualMachineDisplayTopology = new ArrayList<VirtualMachineDisplayTopology>();
        }
        return this.virtualMachineDisplayTopology;
    }

}
