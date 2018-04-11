
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfDuplicatedPropertyIdExport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfDuplicatedPropertyIdExport">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfExport">
 *       &lt;sequence>
 *         &lt;element name="fqid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfDuplicatedPropertyIdExport", propOrder = {
    "fqid"
})
public class OvfDuplicatedPropertyIdExport
    extends OvfExport
{

    @XmlElement(required = true)
    protected String fqid;

    /**
     * Gets the value of the fqid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFqid() {
        return fqid;
    }

    /**
     * Sets the value of the fqid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFqid(String value) {
        this.fqid = value;
    }

}
