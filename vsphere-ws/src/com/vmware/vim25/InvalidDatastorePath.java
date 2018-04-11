
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvalidDatastorePath complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvalidDatastorePath">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InvalidDatastore">
 *       &lt;sequence>
 *         &lt;element name="datastorePath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvalidDatastorePath", propOrder = {
    "datastorePath"
})
public class InvalidDatastorePath
    extends InvalidDatastore
{

    @XmlElement(required = true)
    protected String datastorePath;

    /**
     * Gets the value of the datastorePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatastorePath() {
        return datastorePath;
    }

    /**
     * Sets the value of the datastorePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatastorePath(String value) {
        this.datastorePath = value;
    }

}
