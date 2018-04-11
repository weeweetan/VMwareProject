
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EventDescriptionEventDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventDescriptionEventDetail">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="formatOnDatacenter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="formatOnComputeResource" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="formatOnHost" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="formatOnVm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fullFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="longDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventDescriptionEventDetail", propOrder = {
    "key",
    "description",
    "category",
    "formatOnDatacenter",
    "formatOnComputeResource",
    "formatOnHost",
    "formatOnVm",
    "fullFormat",
    "longDescription"
})
public class EventDescriptionEventDetail
    extends DynamicData
{

    @XmlElement(required = true)
    protected String key;
    protected String description;
    @XmlElement(required = true)
    protected String category;
    @XmlElement(required = true)
    protected String formatOnDatacenter;
    @XmlElement(required = true)
    protected String formatOnComputeResource;
    @XmlElement(required = true)
    protected String formatOnHost;
    @XmlElement(required = true)
    protected String formatOnVm;
    @XmlElement(required = true)
    protected String fullFormat;
    protected String longDescription;

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the formatOnDatacenter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatOnDatacenter() {
        return formatOnDatacenter;
    }

    /**
     * Sets the value of the formatOnDatacenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatOnDatacenter(String value) {
        this.formatOnDatacenter = value;
    }

    /**
     * Gets the value of the formatOnComputeResource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatOnComputeResource() {
        return formatOnComputeResource;
    }

    /**
     * Sets the value of the formatOnComputeResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatOnComputeResource(String value) {
        this.formatOnComputeResource = value;
    }

    /**
     * Gets the value of the formatOnHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatOnHost() {
        return formatOnHost;
    }

    /**
     * Sets the value of the formatOnHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatOnHost(String value) {
        this.formatOnHost = value;
    }

    /**
     * Gets the value of the formatOnVm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatOnVm() {
        return formatOnVm;
    }

    /**
     * Sets the value of the formatOnVm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatOnVm(String value) {
        this.formatOnVm = value;
    }

    /**
     * Gets the value of the fullFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullFormat() {
        return fullFormat;
    }

    /**
     * Sets the value of the fullFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullFormat(String value) {
        this.fullFormat = value;
    }

    /**
     * Gets the value of the longDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * Sets the value of the longDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongDescription(String value) {
        this.longDescription = value;
    }

}
