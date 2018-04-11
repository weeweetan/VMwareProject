
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfProfileProfileStructureProperty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProfileProfileStructureProperty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProfileProfileStructureProperty" type="{urn:vim25}ProfileProfileStructureProperty" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProfileProfileStructureProperty", propOrder = {
    "profileProfileStructureProperty"
})
public class ArrayOfProfileProfileStructureProperty {

    @XmlElement(name = "ProfileProfileStructureProperty")
    protected List<ProfileProfileStructureProperty> profileProfileStructureProperty;

    /**
     * Gets the value of the profileProfileStructureProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profileProfileStructureProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfileProfileStructureProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileProfileStructureProperty }
     * 
     * 
     */
    public List<ProfileProfileStructureProperty> getProfileProfileStructureProperty() {
        if (profileProfileStructureProperty == null) {
            profileProfileStructureProperty = new ArrayList<ProfileProfileStructureProperty>();
        }
        return this.profileProfileStructureProperty;
    }

}
