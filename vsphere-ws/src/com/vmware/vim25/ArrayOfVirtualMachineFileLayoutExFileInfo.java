
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineFileLayoutExFileInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineFileLayoutExFileInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineFileLayoutExFileInfo" type="{urn:vim25}VirtualMachineFileLayoutExFileInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineFileLayoutExFileInfo", propOrder = {
    "virtualMachineFileLayoutExFileInfo"
})
public class ArrayOfVirtualMachineFileLayoutExFileInfo {

    @XmlElement(name = "VirtualMachineFileLayoutExFileInfo")
    protected List<VirtualMachineFileLayoutExFileInfo> virtualMachineFileLayoutExFileInfo;

    /**
     * Gets the value of the virtualMachineFileLayoutExFileInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineFileLayoutExFileInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineFileLayoutExFileInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFileLayoutExFileInfo }
     * 
     * 
     */
    public List<VirtualMachineFileLayoutExFileInfo> getVirtualMachineFileLayoutExFileInfo() {
        if (virtualMachineFileLayoutExFileInfo == null) {
            virtualMachineFileLayoutExFileInfo = new ArrayList<VirtualMachineFileLayoutExFileInfo>();
        }
        return this.virtualMachineFileLayoutExFileInfo;
    }

}
