
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfProfileApplyProfileProperty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProfileApplyProfileProperty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProfileApplyProfileProperty" type="{urn:vim25}ProfileApplyProfileProperty" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProfileApplyProfileProperty", propOrder = {
    "profileApplyProfileProperty"
})
public class ArrayOfProfileApplyProfileProperty {

    @XmlElement(name = "ProfileApplyProfileProperty")
    protected List<ProfileApplyProfileProperty> profileApplyProfileProperty;

    /**
     * Gets the value of the profileApplyProfileProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profileApplyProfileProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfileApplyProfileProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileApplyProfileProperty }
     * 
     * 
     */
    public List<ProfileApplyProfileProperty> getProfileApplyProfileProperty() {
        if (profileApplyProfileProperty == null) {
            profileApplyProfileProperty = new ArrayList<ProfileApplyProfileProperty>();
        }
        return this.profileApplyProfileProperty;
    }

}
