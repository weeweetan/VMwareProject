
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomFieldDefEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomFieldDefEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}CustomFieldEvent">
 *       &lt;sequence>
 *         &lt;element name="fieldKey" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomFieldDefEvent", propOrder = {
    "fieldKey",
    "name"
})
@XmlSeeAlso({
    CustomFieldDefRemovedEvent.class,
    CustomFieldDefAddedEvent.class,
    CustomFieldDefRenamedEvent.class
})
public class CustomFieldDefEvent
    extends CustomFieldEvent
{

    protected int fieldKey;
    @XmlElement(required = true)
    protected String name;

    /**
     * Gets the value of the fieldKey property.
     * 
     */
    public int getFieldKey() {
        return fieldKey;
    }

    /**
     * Sets the value of the fieldKey property.
     * 
     */
    public void setFieldKey(int value) {
        this.fieldKey = value;
    }

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

}
