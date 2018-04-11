
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostInternetScsiHbaIPProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostInternetScsiHbaIPProperties">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="mac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dhcpConfigurationEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="subnetMask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultGateway" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primaryDnsServerAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alternateDnsServerAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipv6Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipv6SubnetMask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipv6DefaultGateway" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arpRedirectEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="mtu" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="jumboFramesEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostInternetScsiHbaIPProperties", propOrder = {
    "mac",
    "address",
    "dhcpConfigurationEnabled",
    "subnetMask",
    "defaultGateway",
    "primaryDnsServerAddress",
    "alternateDnsServerAddress",
    "ipv6Address",
    "ipv6SubnetMask",
    "ipv6DefaultGateway",
    "arpRedirectEnabled",
    "mtu",
    "jumboFramesEnabled"
})
public class HostInternetScsiHbaIPProperties
    extends DynamicData
{

    protected String mac;
    protected String address;
    protected boolean dhcpConfigurationEnabled;
    protected String subnetMask;
    protected String defaultGateway;
    protected String primaryDnsServerAddress;
    protected String alternateDnsServerAddress;
    protected String ipv6Address;
    protected String ipv6SubnetMask;
    protected String ipv6DefaultGateway;
    protected Boolean arpRedirectEnabled;
    protected Integer mtu;
    protected Boolean jumboFramesEnabled;

    /**
     * Gets the value of the mac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMac() {
        return mac;
    }

    /**
     * Sets the value of the mac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMac(String value) {
        this.mac = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the dhcpConfigurationEnabled property.
     * 
     */
    public boolean isDhcpConfigurationEnabled() {
        return dhcpConfigurationEnabled;
    }

    /**
     * Sets the value of the dhcpConfigurationEnabled property.
     * 
     */
    public void setDhcpConfigurationEnabled(boolean value) {
        this.dhcpConfigurationEnabled = value;
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
     * Gets the value of the defaultGateway property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultGateway() {
        return defaultGateway;
    }

    /**
     * Sets the value of the defaultGateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultGateway(String value) {
        this.defaultGateway = value;
    }

    /**
     * Gets the value of the primaryDnsServerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryDnsServerAddress() {
        return primaryDnsServerAddress;
    }

    /**
     * Sets the value of the primaryDnsServerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryDnsServerAddress(String value) {
        this.primaryDnsServerAddress = value;
    }

    /**
     * Gets the value of the alternateDnsServerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternateDnsServerAddress() {
        return alternateDnsServerAddress;
    }

    /**
     * Sets the value of the alternateDnsServerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternateDnsServerAddress(String value) {
        this.alternateDnsServerAddress = value;
    }

    /**
     * Gets the value of the ipv6Address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpv6Address() {
        return ipv6Address;
    }

    /**
     * Sets the value of the ipv6Address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpv6Address(String value) {
        this.ipv6Address = value;
    }

    /**
     * Gets the value of the ipv6SubnetMask property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpv6SubnetMask() {
        return ipv6SubnetMask;
    }

    /**
     * Sets the value of the ipv6SubnetMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpv6SubnetMask(String value) {
        this.ipv6SubnetMask = value;
    }

    /**
     * Gets the value of the ipv6DefaultGateway property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpv6DefaultGateway() {
        return ipv6DefaultGateway;
    }

    /**
     * Sets the value of the ipv6DefaultGateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpv6DefaultGateway(String value) {
        this.ipv6DefaultGateway = value;
    }

    /**
     * Gets the value of the arpRedirectEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isArpRedirectEnabled() {
        return arpRedirectEnabled;
    }

    /**
     * Sets the value of the arpRedirectEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setArpRedirectEnabled(Boolean value) {
        this.arpRedirectEnabled = value;
    }

    /**
     * Gets the value of the mtu property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMtu() {
        return mtu;
    }

    /**
     * Sets the value of the mtu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMtu(Integer value) {
        this.mtu = value;
    }

    /**
     * Gets the value of the jumboFramesEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isJumboFramesEnabled() {
        return jumboFramesEnabled;
    }

    /**
     * Sets the value of the jumboFramesEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setJumboFramesEnabled(Boolean value) {
        this.jumboFramesEnabled = value;
    }

}
