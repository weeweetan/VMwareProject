
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVAppCloneSpecResourceMap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVAppCloneSpecResourceMap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VAppCloneSpecResourceMap" type="{urn:vim25}VAppCloneSpecResourceMap" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVAppCloneSpecResourceMap", propOrder = {
    "vAppCloneSpecResourceMap"
})
public class ArrayOfVAppCloneSpecResourceMap {

    @XmlElement(name = "VAppCloneSpecResourceMap")
    protected List<VAppCloneSpecResourceMap> vAppCloneSpecResourceMap;

    /**
     * Gets the value of the vAppCloneSpecResourceMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vAppCloneSpecResourceMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVAppCloneSpecResourceMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VAppCloneSpecResourceMap }
     * 
     * 
     */
    public List<VAppCloneSpecResourceMap> getVAppCloneSpecResourceMap() {
        if (vAppCloneSpecResourceMap == null) {
            vAppCloneSpecResourceMap = new ArrayList<VAppCloneSpecResourceMap>();
        }
        return this.vAppCloneSpecResourceMap;
    }

}
