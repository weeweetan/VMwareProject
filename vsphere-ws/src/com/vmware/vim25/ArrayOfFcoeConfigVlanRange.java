
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfFcoeConfigVlanRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFcoeConfigVlanRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FcoeConfigVlanRange" type="{urn:vim25}FcoeConfigVlanRange" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFcoeConfigVlanRange", propOrder = {
    "fcoeConfigVlanRange"
})
public class ArrayOfFcoeConfigVlanRange {

    @XmlElement(name = "FcoeConfigVlanRange")
    protected List<FcoeConfigVlanRange> fcoeConfigVlanRange;

    /**
     * Gets the value of the fcoeConfigVlanRange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fcoeConfigVlanRange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFcoeConfigVlanRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FcoeConfigVlanRange }
     * 
     * 
     */
    public List<FcoeConfigVlanRange> getFcoeConfigVlanRange() {
        if (fcoeConfigVlanRange == null) {
            fcoeConfigVlanRange = new ArrayList<FcoeConfigVlanRange>();
        }
        return this.fcoeConfigVlanRange;
    }

}
