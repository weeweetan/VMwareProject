
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualAppLinkInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualAppLinkInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualAppLinkInfo" type="{urn:vim25}VirtualAppLinkInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualAppLinkInfo", propOrder = {
    "virtualAppLinkInfo"
})
public class ArrayOfVirtualAppLinkInfo {

    @XmlElement(name = "VirtualAppLinkInfo")
    protected List<VirtualAppLinkInfo> virtualAppLinkInfo;

    /**
     * Gets the value of the virtualAppLinkInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualAppLinkInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualAppLinkInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualAppLinkInfo }
     * 
     * 
     */
    public List<VirtualAppLinkInfo> getVirtualAppLinkInfo() {
        if (virtualAppLinkInfo == null) {
            virtualAppLinkInfo = new ArrayList<VirtualAppLinkInfo>();
        }
        return this.virtualAppLinkInfo;
    }

}
