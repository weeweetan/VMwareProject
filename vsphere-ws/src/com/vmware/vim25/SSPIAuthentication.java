
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SSPIAuthentication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SSPIAuthentication">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}GuestAuthentication">
 *       &lt;sequence>
 *         &lt;element name="sspiToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SSPIAuthentication", propOrder = {
    "sspiToken"
})
public class SSPIAuthentication
    extends GuestAuthentication
{

    @XmlElement(required = true)
    protected String sspiToken;

    /**
     * Gets the value of the sspiToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSspiToken() {
        return sspiToken;
    }

    /**
     * Sets the value of the sspiToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSspiToken(String value) {
        this.sspiToken = value;
    }

}
