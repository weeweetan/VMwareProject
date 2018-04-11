
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfProfileMetadataProfileSortSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProfileMetadataProfileSortSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProfileMetadataProfileSortSpec" type="{urn:vim25}ProfileMetadataProfileSortSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProfileMetadataProfileSortSpec", propOrder = {
    "profileMetadataProfileSortSpec"
})
public class ArrayOfProfileMetadataProfileSortSpec {

    @XmlElement(name = "ProfileMetadataProfileSortSpec")
    protected List<ProfileMetadataProfileSortSpec> profileMetadataProfileSortSpec;

    /**
     * Gets the value of the profileMetadataProfileSortSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profileMetadataProfileSortSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfileMetadataProfileSortSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileMetadataProfileSortSpec }
     * 
     * 
     */
    public List<ProfileMetadataProfileSortSpec> getProfileMetadataProfileSortSpec() {
        if (profileMetadataProfileSortSpec == null) {
            profileMetadataProfileSortSpec = new ArrayList<ProfileMetadataProfileSortSpec>();
        }
        return this.profileMetadataProfileSortSpec;
    }

}
