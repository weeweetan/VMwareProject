
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPhysicalNicHintInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPhysicalNicHintInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PhysicalNicHintInfo" type="{urn:vim25}PhysicalNicHintInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPhysicalNicHintInfo", propOrder = {
    "physicalNicHintInfo"
})
public class ArrayOfPhysicalNicHintInfo {

    @XmlElement(name = "PhysicalNicHintInfo")
    protected List<PhysicalNicHintInfo> physicalNicHintInfo;

    /**
     * Gets the value of the physicalNicHintInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the physicalNicHintInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhysicalNicHintInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhysicalNicHintInfo }
     * 
     * 
     */
    public List<PhysicalNicHintInfo> getPhysicalNicHintInfo() {
        if (physicalNicHintInfo == null) {
            physicalNicHintInfo = new ArrayList<PhysicalNicHintInfo>();
        }
        return this.physicalNicHintInfo;
    }

}
