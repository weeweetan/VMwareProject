
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfOvfFileItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOvfFileItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OvfFileItem" type="{urn:vim25}OvfFileItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOvfFileItem", propOrder = {
    "ovfFileItem"
})
public class ArrayOfOvfFileItem {

    @XmlElement(name = "OvfFileItem")
    protected List<OvfFileItem> ovfFileItem;

    /**
     * Gets the value of the ovfFileItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ovfFileItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOvfFileItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OvfFileItem }
     * 
     * 
     */
    public List<OvfFileItem> getOvfFileItem() {
        if (ovfFileItem == null) {
            ovfFileItem = new ArrayList<OvfFileItem>();
        }
        return this.ovfFileItem;
    }

}
