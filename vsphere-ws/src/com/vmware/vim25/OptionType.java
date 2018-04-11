
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptionType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="valueIsReadonly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptionType", propOrder = {
    "valueIsReadonly"
})
@XmlSeeAlso({
    StringOption.class,
    FloatOption.class,
    ChoiceOption.class,
    LongOption.class,
    IntOption.class,
    BoolOption.class
})
public class OptionType
    extends DynamicData
{

    protected Boolean valueIsReadonly;

    /**
     * Gets the value of the valueIsReadonly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isValueIsReadonly() {
        return valueIsReadonly;
    }

    /**
     * Sets the value of the valueIsReadonly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValueIsReadonly(Boolean value) {
        this.valueIsReadonly = value;
    }

}
