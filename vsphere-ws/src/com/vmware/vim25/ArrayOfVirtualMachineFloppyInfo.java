
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineFloppyInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineFloppyInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineFloppyInfo" type="{urn:vim25}VirtualMachineFloppyInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineFloppyInfo", propOrder = {
    "virtualMachineFloppyInfo"
})
public class ArrayOfVirtualMachineFloppyInfo {

    @XmlElement(name = "VirtualMachineFloppyInfo")
    protected List<VirtualMachineFloppyInfo> virtualMachineFloppyInfo;

    /**
     * Gets the value of the virtualMachineFloppyInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineFloppyInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineFloppyInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFloppyInfo }
     * 
     * 
     */
    public List<VirtualMachineFloppyInfo> getVirtualMachineFloppyInfo() {
        if (virtualMachineFloppyInfo == null) {
            virtualMachineFloppyInfo = new ArrayList<VirtualMachineFloppyInfo>();
        }
        return this.virtualMachineFloppyInfo;
    }

}
