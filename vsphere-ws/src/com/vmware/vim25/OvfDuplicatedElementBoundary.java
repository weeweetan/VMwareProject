
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfDuplicatedElementBoundary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfDuplicatedElementBoundary">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfElement">
 *       &lt;sequence>
 *         &lt;element name="boundary" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfDuplicatedElementBoundary", propOrder = {
    "boundary"
})
public class OvfDuplicatedElementBoundary
    extends OvfElement
{

    @XmlElement(required = true)
    protected String boundary;

    /**
     * Gets the value of the boundary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoundary() {
        return boundary;
    }

    /**
     * Sets the value of the boundary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoundary(String value) {
        this.boundary = value;
    }

}
