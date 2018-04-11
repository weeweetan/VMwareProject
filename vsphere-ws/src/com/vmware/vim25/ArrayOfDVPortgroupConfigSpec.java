
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDVPortgroupConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDVPortgroupConfigSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DVPortgroupConfigSpec" type="{urn:vim25}DVPortgroupConfigSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDVPortgroupConfigSpec", propOrder = {
    "dvPortgroupConfigSpec"
})
public class ArrayOfDVPortgroupConfigSpec {

    @XmlElement(name = "DVPortgroupConfigSpec")
    protected List<DVPortgroupConfigSpec> dvPortgroupConfigSpec;

    /**
     * Gets the value of the dvPortgroupConfigSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dvPortgroupConfigSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDVPortgroupConfigSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DVPortgroupConfigSpec }
     * 
     * 
     */
    public List<DVPortgroupConfigSpec> getDVPortgroupConfigSpec() {
        if (dvPortgroupConfigSpec == null) {
            dvPortgroupConfigSpec = new ArrayList<DVPortgroupConfigSpec>();
        }
        return this.dvPortgroupConfigSpec;
    }

}
