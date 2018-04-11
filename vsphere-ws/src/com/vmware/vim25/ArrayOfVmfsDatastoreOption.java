
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVmfsDatastoreOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVmfsDatastoreOption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VmfsDatastoreOption" type="{urn:vim25}VmfsDatastoreOption" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVmfsDatastoreOption", propOrder = {
    "vmfsDatastoreOption"
})
public class ArrayOfVmfsDatastoreOption {

    @XmlElement(name = "VmfsDatastoreOption")
    protected List<VmfsDatastoreOption> vmfsDatastoreOption;

    /**
     * Gets the value of the vmfsDatastoreOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmfsDatastoreOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmfsDatastoreOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmfsDatastoreOption }
     * 
     * 
     */
    public List<VmfsDatastoreOption> getVmfsDatastoreOption() {
        if (vmfsDatastoreOption == null) {
            vmfsDatastoreOption = new ArrayList<VmfsDatastoreOption>();
        }
        return this.vmfsDatastoreOption;
    }

}
