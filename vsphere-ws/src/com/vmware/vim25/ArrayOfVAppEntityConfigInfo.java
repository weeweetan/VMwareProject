
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVAppEntityConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVAppEntityConfigInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VAppEntityConfigInfo" type="{urn:vim25}VAppEntityConfigInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVAppEntityConfigInfo", propOrder = {
    "vAppEntityConfigInfo"
})
public class ArrayOfVAppEntityConfigInfo {

    @XmlElement(name = "VAppEntityConfigInfo")
    protected List<VAppEntityConfigInfo> vAppEntityConfigInfo;

    /**
     * Gets the value of the vAppEntityConfigInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vAppEntityConfigInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVAppEntityConfigInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VAppEntityConfigInfo }
     * 
     * 
     */
    public List<VAppEntityConfigInfo> getVAppEntityConfigInfo() {
        if (vAppEntityConfigInfo == null) {
            vAppEntityConfigInfo = new ArrayList<VAppEntityConfigInfo>();
        }
        return this.vAppEntityConfigInfo;
    }

}
