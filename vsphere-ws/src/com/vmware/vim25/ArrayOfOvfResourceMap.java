
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfOvfResourceMap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOvfResourceMap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OvfResourceMap" type="{urn:vim25}OvfResourceMap" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOvfResourceMap", propOrder = {
    "ovfResourceMap"
})
public class ArrayOfOvfResourceMap {

    @XmlElement(name = "OvfResourceMap")
    protected List<OvfResourceMap> ovfResourceMap;

    /**
     * Gets the value of the ovfResourceMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ovfResourceMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOvfResourceMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OvfResourceMap }
     * 
     * 
     */
    public List<OvfResourceMap> getOvfResourceMap() {
        if (ovfResourceMap == null) {
            ovfResourceMap = new ArrayList<OvfResourceMap>();
        }
        return this.ovfResourceMap;
    }

}
