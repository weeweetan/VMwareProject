
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineConfigOptionDescriptor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineConfigOptionDescriptor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineConfigOptionDescriptor" type="{urn:vim25}VirtualMachineConfigOptionDescriptor" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineConfigOptionDescriptor", propOrder = {
    "virtualMachineConfigOptionDescriptor"
})
public class ArrayOfVirtualMachineConfigOptionDescriptor {

    @XmlElement(name = "VirtualMachineConfigOptionDescriptor")
    protected List<VirtualMachineConfigOptionDescriptor> virtualMachineConfigOptionDescriptor;

    /**
     * Gets the value of the virtualMachineConfigOptionDescriptor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineConfigOptionDescriptor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineConfigOptionDescriptor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineConfigOptionDescriptor }
     * 
     * 
     */
    public List<VirtualMachineConfigOptionDescriptor> getVirtualMachineConfigOptionDescriptor() {
        if (virtualMachineConfigOptionDescriptor == null) {
            virtualMachineConfigOptionDescriptor = new ArrayList<VirtualMachineConfigOptionDescriptor>();
        }
        return this.virtualMachineConfigOptionDescriptor;
    }

}
