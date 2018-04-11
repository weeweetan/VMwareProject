
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IncompatibleSetting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IncompatibleSetting">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InvalidArgument">
 *       &lt;sequence>
 *         &lt;element name="conflictingProperty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IncompatibleSetting", propOrder = {
    "conflictingProperty"
})
public class IncompatibleSetting
    extends InvalidArgument
{

    @XmlElement(required = true)
    protected String conflictingProperty;

    /**
     * Gets the value of the conflictingProperty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConflictingProperty() {
        return conflictingProperty;
    }

    /**
     * Sets the value of the conflictingProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConflictingProperty(String value) {
        this.conflictingProperty = value;
    }

}
