
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfProfilePolicyOptionMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProfilePolicyOptionMetadata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProfilePolicyOptionMetadata" type="{urn:vim25}ProfilePolicyOptionMetadata" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProfilePolicyOptionMetadata", propOrder = {
    "profilePolicyOptionMetadata"
})
public class ArrayOfProfilePolicyOptionMetadata {

    @XmlElement(name = "ProfilePolicyOptionMetadata")
    protected List<ProfilePolicyOptionMetadata> profilePolicyOptionMetadata;

    /**
     * Gets the value of the profilePolicyOptionMetadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profilePolicyOptionMetadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfilePolicyOptionMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfilePolicyOptionMetadata }
     * 
     * 
     */
    public List<ProfilePolicyOptionMetadata> getProfilePolicyOptionMetadata() {
        if (profilePolicyOptionMetadata == null) {
            profilePolicyOptionMetadata = new ArrayList<ProfilePolicyOptionMetadata>();
        }
        return this.profilePolicyOptionMetadata;
    }

}
