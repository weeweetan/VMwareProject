
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVAppOvfSectionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVAppOvfSectionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VAppOvfSectionInfo" type="{urn:vim25}VAppOvfSectionInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVAppOvfSectionInfo", propOrder = {
    "vAppOvfSectionInfo"
})
public class ArrayOfVAppOvfSectionInfo {

    @XmlElement(name = "VAppOvfSectionInfo")
    protected List<VAppOvfSectionInfo> vAppOvfSectionInfo;

    /**
     * Gets the value of the vAppOvfSectionInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vAppOvfSectionInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVAppOvfSectionInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VAppOvfSectionInfo }
     * 
     * 
     */
    public List<VAppOvfSectionInfo> getVAppOvfSectionInfo() {
        if (vAppOvfSectionInfo == null) {
            vAppOvfSectionInfo = new ArrayList<VAppOvfSectionInfo>();
        }
        return this.vAppOvfSectionInfo;
    }

}
