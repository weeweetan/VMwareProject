
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostShortNameInconsistentEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostShortNameInconsistentEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostDasEvent">
 *       &lt;sequence>
 *         &lt;element name="shortName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shortName2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostShortNameInconsistentEvent", propOrder = {
    "shortName",
    "shortName2"
})
public class HostShortNameInconsistentEvent
    extends HostDasEvent
{

    @XmlElement(required = true)
    protected String shortName;
    @XmlElement(required = true)
    protected String shortName2;

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
    }

    /**
     * Gets the value of the shortName2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName2() {
        return shortName2;
    }

    /**
     * Sets the value of the shortName2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName2(String value) {
        this.shortName2 = value;
    }

}
