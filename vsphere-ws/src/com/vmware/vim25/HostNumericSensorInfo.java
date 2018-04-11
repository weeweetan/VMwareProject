
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostNumericSensorInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostNumericSensorInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="healthState" type="{urn:vim25}ElementDescription" minOccurs="0"/>
 *         &lt;element name="currentReading" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="unitModifier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="baseUnits" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rateUnits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sensorType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostNumericSensorInfo", propOrder = {
    "name",
    "healthState",
    "currentReading",
    "unitModifier",
    "baseUnits",
    "rateUnits",
    "sensorType"
})
public class HostNumericSensorInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String name;
    protected ElementDescription healthState;
    protected long currentReading;
    protected int unitModifier;
    @XmlElement(required = true)
    protected String baseUnits;
    protected String rateUnits;
    @XmlElement(required = true)
    protected String sensorType;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the healthState property.
     * 
     * @return
     *     possible object is
     *     {@link ElementDescription }
     *     
     */
    public ElementDescription getHealthState() {
        return healthState;
    }

    /**
     * Sets the value of the healthState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElementDescription }
     *     
     */
    public void setHealthState(ElementDescription value) {
        this.healthState = value;
    }

    /**
     * Gets the value of the currentReading property.
     * 
     */
    public long getCurrentReading() {
        return currentReading;
    }

    /**
     * Sets the value of the currentReading property.
     * 
     */
    public void setCurrentReading(long value) {
        this.currentReading = value;
    }

    /**
     * Gets the value of the unitModifier property.
     * 
     */
    public int getUnitModifier() {
        return unitModifier;
    }

    /**
     * Sets the value of the unitModifier property.
     * 
     */
    public void setUnitModifier(int value) {
        this.unitModifier = value;
    }

    /**
     * Gets the value of the baseUnits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseUnits() {
        return baseUnits;
    }

    /**
     * Sets the value of the baseUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseUnits(String value) {
        this.baseUnits = value;
    }

    /**
     * Gets the value of the rateUnits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateUnits() {
        return rateUnits;
    }

    /**
     * Sets the value of the rateUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateUnits(String value) {
        this.rateUnits = value;
    }

    /**
     * Gets the value of the sensorType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSensorType() {
        return sensorType;
    }

    /**
     * Sets the value of the sensorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSensorType(String value) {
        this.sensorType = value;
    }

}
