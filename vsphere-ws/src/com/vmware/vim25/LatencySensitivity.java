
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LatencySensitivity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LatencySensitivity">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="level" type="{urn:vim25}LatencySensitivitySensitivityLevel"/>
 *         &lt;element name="sensitivity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LatencySensitivity", propOrder = {
    "level",
    "sensitivity"
})
public class LatencySensitivity
    extends DynamicData
{

    @XmlElement(required = true)
    protected LatencySensitivitySensitivityLevel level;
    protected Integer sensitivity;

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link LatencySensitivitySensitivityLevel }
     *     
     */
    public LatencySensitivitySensitivityLevel getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link LatencySensitivitySensitivityLevel }
     *     
     */
    public void setLevel(LatencySensitivitySensitivityLevel value) {
        this.level = value;
    }

    /**
     * Gets the value of the sensitivity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSensitivity() {
        return sensitivity;
    }

    /**
     * Sets the value of the sensitivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSensitivity(Integer value) {
        this.sensitivity = value;
    }

}
