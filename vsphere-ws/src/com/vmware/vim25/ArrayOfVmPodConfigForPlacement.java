
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVmPodConfigForPlacement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVmPodConfigForPlacement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VmPodConfigForPlacement" type="{urn:vim25}VmPodConfigForPlacement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVmPodConfigForPlacement", propOrder = {
    "vmPodConfigForPlacement"
})
public class ArrayOfVmPodConfigForPlacement {

    @XmlElement(name = "VmPodConfigForPlacement")
    protected List<VmPodConfigForPlacement> vmPodConfigForPlacement;

    /**
     * Gets the value of the vmPodConfigForPlacement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmPodConfigForPlacement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmPodConfigForPlacement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmPodConfigForPlacement }
     * 
     * 
     */
    public List<VmPodConfigForPlacement> getVmPodConfigForPlacement() {
        if (vmPodConfigForPlacement == null) {
            vmPodConfigForPlacement = new ArrayList<VmPodConfigForPlacement>();
        }
        return this.vmPodConfigForPlacement;
    }

}
