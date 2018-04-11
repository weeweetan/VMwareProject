
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfileProfileStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfileProfileStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="profileTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="child" type="{urn:vim25}ProfileProfileStructureProperty" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileProfileStructure", propOrder = {
    "profileTypeName",
    "child"
})
public class ProfileProfileStructure
    extends DynamicData
{

    @XmlElement(required = true)
    protected String profileTypeName;
    protected List<ProfileProfileStructureProperty> child;

    /**
     * Gets the value of the profileTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfileTypeName() {
        return profileTypeName;
    }

    /**
     * Sets the value of the profileTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfileTypeName(String value) {
        this.profileTypeName = value;
    }

    /**
     * Gets the value of the child property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the child property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChild().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileProfileStructureProperty }
     * 
     * 
     */
    public List<ProfileProfileStructureProperty> getChild() {
        if (child == null) {
            child = new ArrayList<ProfileProfileStructureProperty>();
        }
        return this.child;
    }

}
