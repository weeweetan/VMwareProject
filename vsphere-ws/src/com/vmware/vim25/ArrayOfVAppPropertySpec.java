
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVAppPropertySpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVAppPropertySpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VAppPropertySpec" type="{urn:vim25}VAppPropertySpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVAppPropertySpec", propOrder = {
    "vAppPropertySpec"
})
public class ArrayOfVAppPropertySpec {

    @XmlElement(name = "VAppPropertySpec")
    protected List<VAppPropertySpec> vAppPropertySpec;

    /**
     * Gets the value of the vAppPropertySpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vAppPropertySpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVAppPropertySpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VAppPropertySpec }
     * 
     * 
     */
    public List<VAppPropertySpec> getVAppPropertySpec() {
        if (vAppPropertySpec == null) {
            vAppPropertySpec = new ArrayList<VAppPropertySpec>();
        }
        return this.vAppPropertySpec;
    }

}
