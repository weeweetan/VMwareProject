
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtensionFaultTypeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtensionFaultTypeInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="faultID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtensionFaultTypeInfo", propOrder = {
    "faultID"
})
public class ExtensionFaultTypeInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String faultID;

    /**
     * Gets the value of the faultID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultID() {
        return faultID;
    }

    /**
     * Sets the value of the faultID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultID(String value) {
        this.faultID = value;
    }

}
