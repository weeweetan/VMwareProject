
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostIpConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostIpConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="dhcp" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ipAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subnetMask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipV6Config" type="{urn:vim25}HostIpConfigIpV6AddressConfiguration" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostIpConfig", propOrder = {
    "dhcp",
    "ipAddress",
    "subnetMask",
    "ipV6Config"
})
public class HostIpConfig
    extends DynamicData
{

    protected boolean dhcp;
    protected String ipAddress;
    protected String subnetMask;
    protected HostIpConfigIpV6AddressConfiguration ipV6Config;

    /**
     * Gets the value of the dhcp property.
     * 
     */
    public boolean isDhcp() {
        return dhcp;
    }

    /**
     * Sets the value of the dhcp property.
     * 
     */
    public void setDhcp(boolean value) {
        this.dhcp = value;
    }

    /**
     * Gets the value of the ipAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Sets the value of the ipAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpAddress(String value) {
        this.ipAddress = value;
    }

    /**
     * Gets the value of the subnetMask property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubnetMask() {
        return subnetMask;
    }

    /**
     * Sets the value of the subnetMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubnetMask(String value) {
        this.subnetMask = value;
    }

    /**
     * Gets the value of the ipV6Config property.
     * 
     * @return
     *     possible object is
     *     {@link HostIpConfigIpV6AddressConfiguration }
     *     
     */
    public HostIpConfigIpV6AddressConfiguration getIpV6Config() {
        return ipV6Config;
    }

    /**
     * Sets the value of the ipV6Config property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostIpConfigIpV6AddressConfiguration }
     *     
     */
    public void setIpV6Config(HostIpConfigIpV6AddressConfiguration value) {
        this.ipV6Config = value;
    }

}
