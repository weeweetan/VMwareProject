
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineDeviceRuntimeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineDeviceRuntimeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineDeviceRuntimeInfo" type="{urn:vim25}VirtualMachineDeviceRuntimeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineDeviceRuntimeInfo", propOrder = {
    "virtualMachineDeviceRuntimeInfo"
})
public class ArrayOfVirtualMachineDeviceRuntimeInfo {

    @XmlElement(name = "VirtualMachineDeviceRuntimeInfo")
    protected List<VirtualMachineDeviceRuntimeInfo> virtualMachineDeviceRuntimeInfo;

    /**
     * Gets the value of the virtualMachineDeviceRuntimeInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineDeviceRuntimeInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineDeviceRuntimeInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineDeviceRuntimeInfo }
     * 
     * 
     */
    public List<VirtualMachineDeviceRuntimeInfo> getVirtualMachineDeviceRuntimeInfo() {
        if (virtualMachineDeviceRuntimeInfo == null) {
            virtualMachineDeviceRuntimeInfo = new ArrayList<VirtualMachineDeviceRuntimeInfo>();
        }
        return this.virtualMachineDeviceRuntimeInfo;
    }

}
