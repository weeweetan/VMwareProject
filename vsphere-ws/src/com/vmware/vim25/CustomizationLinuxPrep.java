
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationLinuxPrep complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomizationLinuxPrep">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}CustomizationIdentitySettings">
 *       &lt;sequence>
 *         &lt;element name="hostName" type="{urn:vim25}CustomizationName"/>
 *         &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeZone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hwClockUTC" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomizationLinuxPrep", propOrder = {
    "hostName",
    "domain",
    "timeZone",
    "hwClockUTC"
})
public class CustomizationLinuxPrep
    extends CustomizationIdentitySettings
{

    @XmlElement(required = true)
    protected CustomizationName hostName;
    @XmlElement(required = true)
    protected String domain;
    protected String timeZone;
    protected Boolean hwClockUTC;

    /**
     * Gets the value of the hostName property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationName }
     *     
     */
    public CustomizationName getHostName() {
        return hostName;
    }

    /**
     * Sets the value of the hostName property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationName }
     *     
     */
    public void setHostName(CustomizationName value) {
        this.hostName = value;
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomain(String value) {
        this.domain = value;
    }

    /**
     * Gets the value of the timeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZone(String value) {
        this.timeZone = value;
    }

    /**
     * Gets the value of the hwClockUTC property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHwClockUTC() {
        return hwClockUTC;
    }

    /**
     * Sets the value of the hwClockUTC property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHwClockUTC(Boolean value) {
        this.hwClockUTC = value;
    }

}
