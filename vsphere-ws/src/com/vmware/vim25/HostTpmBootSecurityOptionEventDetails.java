
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostTpmBootSecurityOptionEventDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostTpmBootSecurityOptionEventDetails">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostTpmEventDetails">
 *       &lt;sequence>
 *         &lt;element name="bootSecurityOption" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostTpmBootSecurityOptionEventDetails", propOrder = {
    "bootSecurityOption"
})
public class HostTpmBootSecurityOptionEventDetails
    extends HostTpmEventDetails
{

    @XmlElement(required = true)
    protected String bootSecurityOption;

    /**
     * Gets the value of the bootSecurityOption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBootSecurityOption() {
        return bootSecurityOption;
    }

    /**
     * Sets the value of the bootSecurityOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBootSecurityOption(String value) {
        this.bootSecurityOption = value;
    }

}
