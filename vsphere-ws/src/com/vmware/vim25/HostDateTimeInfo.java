
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDateTimeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDateTimeInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="timeZone" type="{urn:vim25}HostDateTimeSystemTimeZone"/>
 *         &lt;element name="ntpConfig" type="{urn:vim25}HostNtpConfig" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDateTimeInfo", propOrder = {
    "timeZone",
    "ntpConfig"
})
public class HostDateTimeInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected HostDateTimeSystemTimeZone timeZone;
    protected HostNtpConfig ntpConfig;

    /**
     * Gets the value of the timeZone property.
     * 
     * @return
     *     possible object is
     *     {@link HostDateTimeSystemTimeZone }
     *     
     */
    public HostDateTimeSystemTimeZone getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostDateTimeSystemTimeZone }
     *     
     */
    public void setTimeZone(HostDateTimeSystemTimeZone value) {
        this.timeZone = value;
    }

    /**
     * Gets the value of the ntpConfig property.
     * 
     * @return
     *     possible object is
     *     {@link HostNtpConfig }
     *     
     */
    public HostNtpConfig getNtpConfig() {
        return ntpConfig;
    }

    /**
     * Sets the value of the ntpConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostNtpConfig }
     *     
     */
    public void setNtpConfig(HostNtpConfig value) {
        this.ntpConfig = value;
    }

}
