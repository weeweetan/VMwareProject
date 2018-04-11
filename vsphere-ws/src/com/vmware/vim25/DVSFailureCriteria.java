
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSFailureCriteria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSFailureCriteria">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InheritablePolicy">
 *       &lt;sequence>
 *         &lt;element name="checkSpeed" type="{urn:vim25}StringPolicy" minOccurs="0"/>
 *         &lt;element name="speed" type="{urn:vim25}IntPolicy" minOccurs="0"/>
 *         &lt;element name="checkDuplex" type="{urn:vim25}BoolPolicy" minOccurs="0"/>
 *         &lt;element name="fullDuplex" type="{urn:vim25}BoolPolicy" minOccurs="0"/>
 *         &lt;element name="checkErrorPercent" type="{urn:vim25}BoolPolicy" minOccurs="0"/>
 *         &lt;element name="percentage" type="{urn:vim25}IntPolicy" minOccurs="0"/>
 *         &lt;element name="checkBeacon" type="{urn:vim25}BoolPolicy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSFailureCriteria", propOrder = {
    "checkSpeed",
    "speed",
    "checkDuplex",
    "fullDuplex",
    "checkErrorPercent",
    "percentage",
    "checkBeacon"
})
public class DVSFailureCriteria
    extends InheritablePolicy
{

    protected StringPolicy checkSpeed;
    protected IntPolicy speed;
    protected BoolPolicy checkDuplex;
    protected BoolPolicy fullDuplex;
    protected BoolPolicy checkErrorPercent;
    protected IntPolicy percentage;
    protected BoolPolicy checkBeacon;

    /**
     * Gets the value of the checkSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link StringPolicy }
     *     
     */
    public StringPolicy getCheckSpeed() {
        return checkSpeed;
    }

    /**
     * Sets the value of the checkSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringPolicy }
     *     
     */
    public void setCheckSpeed(StringPolicy value) {
        this.checkSpeed = value;
    }

    /**
     * Gets the value of the speed property.
     * 
     * @return
     *     possible object is
     *     {@link IntPolicy }
     *     
     */
    public IntPolicy getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntPolicy }
     *     
     */
    public void setSpeed(IntPolicy value) {
        this.speed = value;
    }

    /**
     * Gets the value of the checkDuplex property.
     * 
     * @return
     *     possible object is
     *     {@link BoolPolicy }
     *     
     */
    public BoolPolicy getCheckDuplex() {
        return checkDuplex;
    }

    /**
     * Sets the value of the checkDuplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolPolicy }
     *     
     */
    public void setCheckDuplex(BoolPolicy value) {
        this.checkDuplex = value;
    }

    /**
     * Gets the value of the fullDuplex property.
     * 
     * @return
     *     possible object is
     *     {@link BoolPolicy }
     *     
     */
    public BoolPolicy getFullDuplex() {
        return fullDuplex;
    }

    /**
     * Sets the value of the fullDuplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolPolicy }
     *     
     */
    public void setFullDuplex(BoolPolicy value) {
        this.fullDuplex = value;
    }

    /**
     * Gets the value of the checkErrorPercent property.
     * 
     * @return
     *     possible object is
     *     {@link BoolPolicy }
     *     
     */
    public BoolPolicy getCheckErrorPercent() {
        return checkErrorPercent;
    }

    /**
     * Sets the value of the checkErrorPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolPolicy }
     *     
     */
    public void setCheckErrorPercent(BoolPolicy value) {
        this.checkErrorPercent = value;
    }

    /**
     * Gets the value of the percentage property.
     * 
     * @return
     *     possible object is
     *     {@link IntPolicy }
     *     
     */
    public IntPolicy getPercentage() {
        return percentage;
    }

    /**
     * Sets the value of the percentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntPolicy }
     *     
     */
    public void setPercentage(IntPolicy value) {
        this.percentage = value;
    }

    /**
     * Gets the value of the checkBeacon property.
     * 
     * @return
     *     possible object is
     *     {@link BoolPolicy }
     *     
     */
    public BoolPolicy getCheckBeacon() {
        return checkBeacon;
    }

    /**
     * Sets the value of the checkBeacon property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolPolicy }
     *     
     */
    public void setCheckBeacon(BoolPolicy value) {
        this.checkBeacon = value;
    }

}
