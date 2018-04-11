
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyFilterSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyFilterSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="propSet" type="{urn:vim25}PropertySpec" maxOccurs="unbounded"/>
 *         &lt;element name="objectSet" type="{urn:vim25}ObjectSpec" maxOccurs="unbounded"/>
 *         &lt;element name="reportMissingObjectsInResults" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyFilterSpec", propOrder = {
    "propSet",
    "objectSet",
    "reportMissingObjectsInResults"
})
public class PropertyFilterSpec
    extends DynamicData
{

    @XmlElement(required = true)
    protected List<PropertySpec> propSet;
    @XmlElement(required = true)
    protected List<ObjectSpec> objectSet;
    protected Boolean reportMissingObjectsInResults;

    /**
     * Gets the value of the propSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertySpec }
     * 
     * 
     */
    public List<PropertySpec> getPropSet() {
        if (propSet == null) {
            propSet = new ArrayList<PropertySpec>();
        }
        return this.propSet;
    }

    /**
     * Gets the value of the objectSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjectSpec }
     * 
     * 
     */
    public List<ObjectSpec> getObjectSet() {
        if (objectSet == null) {
            objectSet = new ArrayList<ObjectSpec>();
        }
        return this.objectSet;
    }

    /**
     * Gets the value of the reportMissingObjectsInResults property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReportMissingObjectsInResults() {
        return reportMissingObjectsInResults;
    }

    /**
     * Sets the value of the reportMissingObjectsInResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReportMissingObjectsInResults(Boolean value) {
        this.reportMissingObjectsInResults = value;
    }

}
