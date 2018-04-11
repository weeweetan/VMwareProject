
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for LicenseFeatureInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LicenseFeatureInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="featureName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="featureDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{urn:vim25}LicenseFeatureInfoState" minOccurs="0"/>
 *         &lt;element name="costUnit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sourceRestriction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dependentKey" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="edition" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="expiresOn" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LicenseFeatureInfo", propOrder = {
    "key",
    "featureName",
    "featureDescription",
    "state",
    "costUnit",
    "sourceRestriction",
    "dependentKey",
    "edition",
    "expiresOn"
})
public class LicenseFeatureInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String key;
    @XmlElement(required = true)
    protected String featureName;
    protected String featureDescription;
    protected LicenseFeatureInfoState state;
    @XmlElement(required = true)
    protected String costUnit;
    protected String sourceRestriction;
    protected List<String> dependentKey;
    protected Boolean edition;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiresOn;

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
     * Gets the value of the featureName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeatureName() {
        return featureName;
    }

    /**
     * Sets the value of the featureName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeatureName(String value) {
        this.featureName = value;
    }

    /**
     * Gets the value of the featureDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeatureDescription() {
        return featureDescription;
    }

    /**
     * Sets the value of the featureDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeatureDescription(String value) {
        this.featureDescription = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseFeatureInfoState }
     *     
     */
    public LicenseFeatureInfoState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseFeatureInfoState }
     *     
     */
    public void setState(LicenseFeatureInfoState value) {
        this.state = value;
    }

    /**
     * Gets the value of the costUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostUnit() {
        return costUnit;
    }

    /**
     * Sets the value of the costUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostUnit(String value) {
        this.costUnit = value;
    }

    /**
     * Gets the value of the sourceRestriction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceRestriction() {
        return sourceRestriction;
    }

    /**
     * Sets the value of the sourceRestriction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceRestriction(String value) {
        this.sourceRestriction = value;
    }

    /**
     * Gets the value of the dependentKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependentKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependentKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDependentKey() {
        if (dependentKey == null) {
            dependentKey = new ArrayList<String>();
        }
        return this.dependentKey;
    }

    /**
     * Gets the value of the edition property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEdition() {
        return edition;
    }

    /**
     * Sets the value of the edition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEdition(Boolean value) {
        this.edition = value;
    }

    /**
     * Gets the value of the expiresOn property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiresOn() {
        return expiresOn;
    }

    /**
     * Sets the value of the expiresOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiresOn(XMLGregorianCalendar value) {
        this.expiresOn = value;
    }

}
