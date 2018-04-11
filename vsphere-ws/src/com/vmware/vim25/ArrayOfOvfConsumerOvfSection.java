
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfOvfConsumerOvfSection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOvfConsumerOvfSection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OvfConsumerOvfSection" type="{urn:vim25}OvfConsumerOvfSection" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOvfConsumerOvfSection", propOrder = {
    "ovfConsumerOvfSection"
})
public class ArrayOfOvfConsumerOvfSection {

    @XmlElement(name = "OvfConsumerOvfSection")
    protected List<OvfConsumerOvfSection> ovfConsumerOvfSection;

    /**
     * Gets the value of the ovfConsumerOvfSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ovfConsumerOvfSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOvfConsumerOvfSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OvfConsumerOvfSection }
     * 
     * 
     */
    public List<OvfConsumerOvfSection> getOvfConsumerOvfSection() {
        if (ovfConsumerOvfSection == null) {
            ovfConsumerOvfSection = new ArrayList<OvfConsumerOvfSection>();
        }
        return this.ovfConsumerOvfSection;
    }

}
