
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineUsageOnDatastore complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineUsageOnDatastore">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineUsageOnDatastore" type="{urn:vim25}VirtualMachineUsageOnDatastore" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineUsageOnDatastore", propOrder = {
    "virtualMachineUsageOnDatastore"
})
public class ArrayOfVirtualMachineUsageOnDatastore {

    @XmlElement(name = "VirtualMachineUsageOnDatastore")
    protected List<VirtualMachineUsageOnDatastore> virtualMachineUsageOnDatastore;

    /**
     * Gets the value of the virtualMachineUsageOnDatastore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineUsageOnDatastore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineUsageOnDatastore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineUsageOnDatastore }
     * 
     * 
     */
    public List<VirtualMachineUsageOnDatastore> getVirtualMachineUsageOnDatastore() {
        if (virtualMachineUsageOnDatastore == null) {
            virtualMachineUsageOnDatastore = new ArrayList<VirtualMachineUsageOnDatastore>();
        }
        return this.virtualMachineUsageOnDatastore;
    }

}
