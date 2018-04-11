
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineSerialInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineSerialInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineSerialInfo" type="{urn:vim25}VirtualMachineSerialInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineSerialInfo", propOrder = {
    "virtualMachineSerialInfo"
})
public class ArrayOfVirtualMachineSerialInfo {

    @XmlElement(name = "VirtualMachineSerialInfo")
    protected List<VirtualMachineSerialInfo> virtualMachineSerialInfo;

    /**
     * Gets the value of the virtualMachineSerialInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineSerialInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineSerialInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineSerialInfo }
     * 
     * 
     */
    public List<VirtualMachineSerialInfo> getVirtualMachineSerialInfo() {
        if (virtualMachineSerialInfo == null) {
            virtualMachineSerialInfo = new ArrayList<VirtualMachineSerialInfo>();
        }
        return this.virtualMachineSerialInfo;
    }

}
