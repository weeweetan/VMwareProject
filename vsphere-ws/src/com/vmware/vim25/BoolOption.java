
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BoolOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BoolOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OptionType">
 *       &lt;sequence>
 *         &lt;element name="supported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoolOption", propOrder = {
    "supported",
    "defaultValue"
})
public class BoolOption
    extends OptionType
{

    protected boolean supported;
    protected boolean defaultValue;

    /**
     * Gets the value of the supported property.
     * 
     */
    public boolean isSupported() {
        return supported;
    }

    /**
     * Sets the value of the supported property.
     * 
     */
    public void setSupported(boolean value) {
        this.supported = value;
    }

    /**
     * Gets the value of the defaultValue property.
     * 
     */
    public boolean isDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     */
    public void setDefaultValue(boolean value) {
        this.defaultValue = value;
    }

}
