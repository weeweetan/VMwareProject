
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfProfileExpressionMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProfileExpressionMetadata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProfileExpressionMetadata" type="{urn:vim25}ProfileExpressionMetadata" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProfileExpressionMetadata", propOrder = {
    "profileExpressionMetadata"
})
public class ArrayOfProfileExpressionMetadata {

    @XmlElement(name = "ProfileExpressionMetadata")
    protected List<ProfileExpressionMetadata> profileExpressionMetadata;

    /**
     * Gets the value of the profileExpressionMetadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profileExpressionMetadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfileExpressionMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileExpressionMetadata }
     * 
     * 
     */
    public List<ProfileExpressionMetadata> getProfileExpressionMetadata() {
        if (profileExpressionMetadata == null) {
            profileExpressionMetadata = new ArrayList<ProfileExpressionMetadata>();
        }
        return this.profileExpressionMetadata;
    }

}
