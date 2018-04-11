
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerfProviderSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerfProviderSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="entity" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="currentSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="summarySupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="refreshRate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerfProviderSummary", propOrder = {
    "entity",
    "currentSupported",
    "summarySupported",
    "refreshRate"
})
public class PerfProviderSummary
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference entity;
    protected boolean currentSupported;
    protected boolean summarySupported;
    protected Integer refreshRate;

    /**
     * Gets the value of the entity property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getEntity() {
        return entity;
    }

    /**
     * Sets the value of the entity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setEntity(ManagedObjectReference value) {
        this.entity = value;
    }

    /**
     * Gets the value of the currentSupported property.
     * 
     */
    public boolean isCurrentSupported() {
        return currentSupported;
    }

    /**
     * Sets the value of the currentSupported property.
     * 
     */
    public void setCurrentSupported(boolean value) {
        this.currentSupported = value;
    }

    /**
     * Gets the value of the summarySupported property.
     * 
     */
    public boolean isSummarySupported() {
        return summarySupported;
    }

    /**
     * Sets the value of the summarySupported property.
     * 
     */
    public void setSummarySupported(boolean value) {
        this.summarySupported = value;
    }

    /**
     * Gets the value of the refreshRate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRefreshRate() {
        return refreshRate;
    }

    /**
     * Sets the value of the refreshRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRefreshRate(Integer value) {
        this.refreshRate = value;
    }

}
