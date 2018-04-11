
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVAppPropertyInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVAppPropertyInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VAppPropertyInfo" type="{urn:vim25}VAppPropertyInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVAppPropertyInfo", propOrder = {
    "vAppPropertyInfo"
})
public class ArrayOfVAppPropertyInfo {

    @XmlElement(name = "VAppPropertyInfo")
    protected List<VAppPropertyInfo> vAppPropertyInfo;

    /**
     * Gets the value of the vAppPropertyInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vAppPropertyInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVAppPropertyInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VAppPropertyInfo }
     * 
     * 
     */
    public List<VAppPropertyInfo> getVAppPropertyInfo() {
        if (vAppPropertyInfo == null) {
            vAppPropertyInfo = new ArrayList<VAppPropertyInfo>();
        }
        return this.vAppPropertyInfo;
    }

}
