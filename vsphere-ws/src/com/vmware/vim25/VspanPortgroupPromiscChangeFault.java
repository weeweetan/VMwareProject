
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VspanPortgroupPromiscChangeFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VspanPortgroupPromiscChangeFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsFault">
 *       &lt;sequence>
 *         &lt;element name="portgroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VspanPortgroupPromiscChangeFault", propOrder = {
    "portgroupName"
})
public class VspanPortgroupPromiscChangeFault
    extends DvsFault
{

    @XmlElement(required = true)
    protected String portgroupName;

    /**
     * Gets the value of the portgroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortgroupName() {
        return portgroupName;
    }

    /**
     * Sets the value of the portgroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortgroupName(String value) {
        this.portgroupName = value;
    }

}
