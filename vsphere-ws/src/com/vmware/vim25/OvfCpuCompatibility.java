
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfCpuCompatibility complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfCpuCompatibility">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfImport">
 *       &lt;sequence>
 *         &lt;element name="registerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="level" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="registerValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="desiredRegisterValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfCpuCompatibility", propOrder = {
    "registerName",
    "level",
    "registerValue",
    "desiredRegisterValue"
})
public class OvfCpuCompatibility
    extends OvfImport
{

    @XmlElement(required = true)
    protected String registerName;
    protected int level;
    @XmlElement(required = true)
    protected String registerValue;
    @XmlElement(required = true)
    protected String desiredRegisterValue;

    /**
     * Gets the value of the registerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterName() {
        return registerName;
    }

    /**
     * Sets the value of the registerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterName(String value) {
        this.registerName = value;
    }

    /**
     * Gets the value of the level property.
     * 
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     */
    public void setLevel(int value) {
        this.level = value;
    }

    /**
     * Gets the value of the registerValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterValue() {
        return registerValue;
    }

    /**
     * Sets the value of the registerValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterValue(String value) {
        this.registerValue = value;
    }

    /**
     * Gets the value of the desiredRegisterValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesiredRegisterValue() {
        return desiredRegisterValue;
    }

    /**
     * Sets the value of the desiredRegisterValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesiredRegisterValue(String value) {
        this.desiredRegisterValue = value;
    }

}
