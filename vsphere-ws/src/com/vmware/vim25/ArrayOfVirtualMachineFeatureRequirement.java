
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualMachineFeatureRequirement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualMachineFeatureRequirement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualMachineFeatureRequirement" type="{urn:vim25}VirtualMachineFeatureRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualMachineFeatureRequirement", propOrder = {
    "virtualMachineFeatureRequirement"
})
public class ArrayOfVirtualMachineFeatureRequirement {

    @XmlElement(name = "VirtualMachineFeatureRequirement")
    protected List<VirtualMachineFeatureRequirement> virtualMachineFeatureRequirement;

    /**
     * Gets the value of the virtualMachineFeatureRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineFeatureRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineFeatureRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFeatureRequirement }
     * 
     * 
     */
    public List<VirtualMachineFeatureRequirement> getVirtualMachineFeatureRequirement() {
        if (virtualMachineFeatureRequirement == null) {
            virtualMachineFeatureRequirement = new ArrayList<VirtualMachineFeatureRequirement>();
        }
        return this.virtualMachineFeatureRequirement;
    }

}
