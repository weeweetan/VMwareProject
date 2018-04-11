
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfWrongNamespace complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfWrongNamespace">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfInvalidPackage">
 *       &lt;sequence>
 *         &lt;element name="namespaceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfWrongNamespace", propOrder = {
    "namespaceName"
})
public class OvfWrongNamespace
    extends OvfInvalidPackage
{

    @XmlElement(required = true)
    protected String namespaceName;

    /**
     * Gets the value of the namespaceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespaceName() {
        return namespaceName;
    }

    /**
     * Sets the value of the namespaceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespaceName(String value) {
        this.namespaceName = value;
    }

}
