
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineBootOptionsBootableDevice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineBootOptionsBootableDevice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineBootOptionsBootableDevice" type="{urn:vim25}VirtualMachineBootOptionsBootableDevice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineBootOptionsBootableDevice", propOrder = {
    "virtualMachineBootOptionsBootableDevice"
})
public class ArrayOfVirtualMachineBootOptionsBootableDevice {

    @XmlElement(name = "VirtualMachineBootOptionsBootableDevice")
    protected List<VirtualMachineBootOptionsBootableDevice> virtualMachineBootOptionsBootableDevice;

    /**
     * Gets the value of the virtualMachineBootOptionsBootableDevice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineBootOptionsBootableDevice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineBootOptionsBootableDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineBootOptionsBootableDevice }
     * 
     * 
     */
    public List<VirtualMachineBootOptionsBootableDevice> getVirtualMachineBootOptionsBootableDevice() {
        if (virtualMachineBootOptionsBootableDevice == null) {
            virtualMachineBootOptionsBootableDevice = new ArrayList<VirtualMachineBootOptionsBootableDevice>();
        }
        return this.virtualMachineBootOptionsBootableDevice;
    }

}
