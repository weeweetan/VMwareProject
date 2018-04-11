
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineUsbInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineUsbInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineUsbInfo" type="{urn:vim25}VirtualMachineUsbInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineUsbInfo", propOrder = {
    "virtualMachineUsbInfo"
})
public class ArrayOfVirtualMachineUsbInfo {

    @XmlElement(name = "VirtualMachineUsbInfo")
    protected List<VirtualMachineUsbInfo> virtualMachineUsbInfo;

    /**
     * Gets the value of the virtualMachineUsbInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineUsbInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineUsbInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineUsbInfo }
     * 
     * 
     */
    public List<VirtualMachineUsbInfo> getVirtualMachineUsbInfo() {
        if (virtualMachineUsbInfo == null) {
            virtualMachineUsbInfo = new ArrayList<VirtualMachineUsbInfo>();
        }
        return this.virtualMachineUsbInfo;
    }

}
