
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineScsiPassthroughInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineScsiPassthroughInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineScsiPassthroughInfo" type="{urn:vim25}VirtualMachineScsiPassthroughInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineScsiPassthroughInfo", propOrder = {
    "virtualMachineScsiPassthroughInfo"
})
public class ArrayOfVirtualMachineScsiPassthroughInfo {

    @XmlElement(name = "VirtualMachineScsiPassthroughInfo")
    protected List<VirtualMachineScsiPassthroughInfo> virtualMachineScsiPassthroughInfo;

    /**
     * Gets the value of the virtualMachineScsiPassthroughInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineScsiPassthroughInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineScsiPassthroughInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineScsiPassthroughInfo }
     * 
     * 
     */
    public List<VirtualMachineScsiPassthroughInfo> getVirtualMachineScsiPassthroughInfo() {
        if (virtualMachineScsiPassthroughInfo == null) {
            virtualMachineScsiPassthroughInfo = new ArrayList<VirtualMachineScsiPassthroughInfo>();
        }
        return this.virtualMachineScsiPassthroughInfo;
    }

}
