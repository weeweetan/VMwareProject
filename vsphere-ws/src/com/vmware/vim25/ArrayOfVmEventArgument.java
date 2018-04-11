
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVmEventArgument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVmEventArgument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VmEventArgument" type="{urn:vim25}VmEventArgument" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVmEventArgument", propOrder = {
    "vmEventArgument"
})
public class ArrayOfVmEventArgument {

    @XmlElement(name = "VmEventArgument")
    protected List<VmEventArgument> vmEventArgument;

    /**
     * Gets the value of the vmEventArgument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmEventArgument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmEventArgument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmEventArgument }
     * 
     * 
     */
    public List<VmEventArgument> getVmEventArgument() {
        if (vmEventArgument == null) {
            vmEventArgument = new ArrayList<VmEventArgument>();
        }
        return this.vmEventArgument;
    }

}
