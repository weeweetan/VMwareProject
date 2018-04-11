
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StringOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StringOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OptionType">
 *       &lt;sequence>
 *         &lt;element name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="validCharacters" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StringOption", propOrder = {
    "defaultValue",
    "validCharacters"
})
public class StringOption
    extends OptionType
{

    @XmlElement(required = true)
    protected String defaultValue;
    protected String validCharacters;

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultValue(String value) {
        this.defaultValue = value;
    }

    /**
     * Gets the value of the validCharacters property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidCharacters() {
        return validCharacters;
    }

    /**
     * Sets the value of the validCharacters property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidCharacters(String value) {
        this.validCharacters = value;
    }

}
