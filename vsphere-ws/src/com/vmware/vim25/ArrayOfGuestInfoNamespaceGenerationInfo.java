
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfGuestInfoNamespaceGenerationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfGuestInfoNamespaceGenerationInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GuestInfoNamespaceGenerationInfo" type="{urn:vim25}GuestInfoNamespaceGenerationInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfGuestInfoNamespaceGenerationInfo", propOrder = {
    "guestInfoNamespaceGenerationInfo"
})
public class ArrayOfGuestInfoNamespaceGenerationInfo {

    @XmlElement(name = "GuestInfoNamespaceGenerationInfo")
    protected List<GuestInfoNamespaceGenerationInfo> guestInfoNamespaceGenerationInfo;

    /**
     * Gets the value of the guestInfoNamespaceGenerationInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the guestInfoNamespaceGenerationInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuestInfoNamespaceGenerationInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuestInfoNamespaceGenerationInfo }
     * 
     * 
     */
    public List<GuestInfoNamespaceGenerationInfo> getGuestInfoNamespaceGenerationInfo() {
        if (guestInfoNamespaceGenerationInfo == null) {
            guestInfoNamespaceGenerationInfo = new ArrayList<GuestInfoNamespaceGenerationInfo>();
        }
        return this.guestInfoNamespaceGenerationInfo;
    }

}
