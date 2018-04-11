
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineNetworkInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineNetworkInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineNetworkInfo" type="{urn:vim25}VirtualMachineNetworkInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineNetworkInfo", propOrder = {
    "virtualMachineNetworkInfo"
})
public class ArrayOfVirtualMachineNetworkInfo {

    @XmlElement(name = "VirtualMachineNetworkInfo")
    protected List<VirtualMachineNetworkInfo> virtualMachineNetworkInfo;

    /**
     * Gets the value of the virtualMachineNetworkInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineNetworkInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineNetworkInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineNetworkInfo }
     * 
     * 
     */
    public List<VirtualMachineNetworkInfo> getVirtualMachineNetworkInfo() {
        if (virtualMachineNetworkInfo == null) {
            virtualMachineNetworkInfo = new ArrayList<VirtualMachineNetworkInfo>();
        }
        return this.virtualMachineNetworkInfo;
    }

}
