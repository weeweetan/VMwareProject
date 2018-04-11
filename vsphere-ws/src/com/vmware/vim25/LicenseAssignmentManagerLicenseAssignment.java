
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LicenseAssignmentManagerLicenseAssignment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LicenseAssignmentManagerLicenseAssignment">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="entityId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="scope" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="entityDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assignedLicense" type="{urn:vim25}LicenseManagerLicenseInfo"/>
 *         &lt;element name="properties" type="{urn:vim25}KeyAnyValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LicenseAssignmentManagerLicenseAssignment", propOrder = {
    "entityId",
    "scope",
    "entityDisplayName",
    "assignedLicense",
    "properties"
})
public class LicenseAssignmentManagerLicenseAssignment
    extends DynamicData
{

    @XmlElement(required = true)
    protected String entityId;
    protected String scope;
    protected String entityDisplayName;
    @XmlElement(required = true)
    protected LicenseManagerLicenseInfo assignedLicense;
    protected List<KeyAnyValue> properties;

    /**
     * Gets the value of the entityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityId() {
        return entityId;
    }

    /**
     * Sets the value of the entityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityId(String value) {
        this.entityId = value;
    }

    /**
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScope(String value) {
        this.scope = value;
    }

    /**
     * Gets the value of the entityDisplayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityDisplayName() {
        return entityDisplayName;
    }

    /**
     * Sets the value of the entityDisplayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityDisplayName(String value) {
        this.entityDisplayName = value;
    }

    /**
     * Gets the value of the assignedLicense property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseManagerLicenseInfo }
     *     
     */
    public LicenseManagerLicenseInfo getAssignedLicense() {
        return assignedLicense;
    }

    /**
     * Sets the value of the assignedLicense property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseManagerLicenseInfo }
     *     
     */
    public void setAssignedLicense(LicenseManagerLicenseInfo value) {
        this.assignedLicense = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the properties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyAnyValue }
     * 
     * 
     */
    public List<KeyAnyValue> getProperties() {
        if (properties == null) {
            properties = new ArrayList<KeyAnyValue>();
        }
        return this.properties;
    }

}
