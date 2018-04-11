
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfileMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfileMetadata">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="profileTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{urn:vim25}ExtendedDescription" minOccurs="0"/>
 *         &lt;element name="sortSpec" type="{urn:vim25}ProfileMetadataProfileSortSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="profileCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="profileComponent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileMetadata", propOrder = {
    "key",
    "profileTypeName",
    "description",
    "sortSpec",
    "profileCategory",
    "profileComponent"
})
public class ProfileMetadata
    extends DynamicData
{

    @XmlElement(required = true)
    protected String key;
    protected String profileTypeName;
    protected ExtendedDescription description;
    protected List<ProfileMetadataProfileSortSpec> sortSpec;
    protected String profileCategory;
    protected String profileComponent;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedDescription }
     *     
     */
    public ExtendedDescription getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedDescription }
     *     
     */
    public void setDescription(ExtendedDescription value) {
        this.description = value;
    }

    /**
     * Gets the value of the sortSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sortSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSortSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileMetadataProfileSortSpec }
     * 
     * 
     */
    public List<ProfileMetadataProfileSortSpec> getSortSpec() {
        if (sortSpec == null) {
            sortSpec = new ArrayList<ProfileMetadataProfileSortSpec>();
        }
        return this.sortSpec;
    }

    /**
     * Gets the value of the profileCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfileCategory() {
        return profileCategory;
    }

    /**
     * Sets the value of the profileCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfileCategory(String value) {
        this.profileCategory = value;
    }

    /**
     * Gets the value of the profileComponent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfileComponent() {
        return profileComponent;
    }

    /**
     * Sets the value of the profileComponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfileComponent(String value) {
        this.profileComponent = value;
    }

}
