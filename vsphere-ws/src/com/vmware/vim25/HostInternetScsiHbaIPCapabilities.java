
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostInternetScsiHbaIPCapabilities complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostInternetScsiHbaIPCapabilities">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="addressSettable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ipConfigurationMethodSettable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="subnetMaskSettable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="defaultGatewaySettable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="primaryDnsServerAddressSettable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="alternateDnsServerAddressSettable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ipv6Supported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="arpRedirectSettable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="mtuSettable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="hostNameAsTargetAddress" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nameAliasSettable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostInternetScsiHbaIPCapabilities", propOrder = {
    "addressSettable",
    "ipConfigurationMethodSettable",
    "subnetMaskSettable",
    "defaultGatewaySettable",
    "primaryDnsServerAddressSettable",
    "alternateDnsServerAddressSettable",
    "ipv6Supported",
    "arpRedirectSettable",
    "mtuSettable",
    "hostNameAsTargetAddress",
    "nameAliasSettable"
})
public class HostInternetScsiHbaIPCapabilities
    extends DynamicData
{

    protected boolean addressSettable;
    protected boolean ipConfigurationMethodSettable;
    protected boolean subnetMaskSettable;
    protected boolean defaultGatewaySettable;
    protected boolean primaryDnsServerAddressSettable;
    protected boolean alternateDnsServerAddressSettable;
    protected Boolean ipv6Supported;
    protected Boolean arpRedirectSettable;
    protected Boolean mtuSettable;
    protected Boolean hostNameAsTargetAddress;
    protected Boolean nameAliasSettable;

    /**
     * Gets the value of the addressSettable property.
     * 
     */
    public boolean isAddressSettable() {
        return addressSettable;
    }

    /**
     * Sets the value of the addressSettable property.
     * 
     */
    public void setAddressSettable(boolean value) {
        this.addressSettable = value;
    }

    /**
     * Gets the value of the ipConfigurationMethodSettable property.
     * 
     */
    public boolean isIpConfigurationMethodSettable() {
        return ipConfigurationMethodSettable;
    }

    /**
     * Sets the value of the ipConfigurationMethodSettable property.
     * 
     */
    public void setIpConfigurationMethodSettable(boolean value) {
        this.ipConfigurationMethodSettable = value;
    }

    /**
     * Gets the value of the subnetMaskSettable property.
     * 
     */
    public boolean isSubnetMaskSettable() {
        return subnetMaskSettable;
    }

    /**
     * Sets the value of the subnetMaskSettable property.
     * 
     */
    public void setSubnetMaskSettable(boolean value) {
        this.subnetMaskSettable = value;
    }

    /**
     * Gets the value of the defaultGatewaySettable property.
     * 
     */
    public boolean isDefaultGatewaySettable() {
        return defaultGatewaySettable;
    }

    /**
     * Sets the value of the defaultGatewaySettable property.
     * 
     */
    public void setDefaultGatewaySettable(boolean value) {
        this.defaultGatewaySettable = value;
    }

    /**
     * Gets the value of the primaryDnsServerAddressSettable property.
     * 
     */
    public boolean isPrimaryDnsServerAddressSettable() {
        return primaryDnsServerAddressSettable;
    }

    /**
     * Sets the value of the primaryDnsServerAddressSettable property.
     * 
     */
    public void setPrimaryDnsServerAddressSettable(boolean value) {
        this.primaryDnsServerAddressSettable = value;
    }

    /**
     * Gets the value of the alternateDnsServerAddressSettable property.
     * 
     */
    public boolean isAlternateDnsServerAddressSettable() {
        return alternateDnsServerAddressSettable;
    }

    /**
     * Sets the value of the alternateDnsServerAddressSettable property.
     * 
     */
    public void setAlternateDnsServerAddressSettable(boolean value) {
        this.alternateDnsServerAddressSettable = value;
    }

    /**
     * Gets the value of the ipv6Supported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIpv6Supported() {
        return ipv6Supported;
    }

    /**
     * Sets the value of the ipv6Supported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIpv6Supported(Boolean value) {
        this.ipv6Supported = value;
    }

    /**
     * Gets the value of the arpRedirectSettable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isArpRedirectSettable() {
        return arpRedirectSettable;
    }

    /**
     * Sets the value of the arpRedirectSettable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setArpRedirectSettable(Boolean value) {
        this.arpRedirectSettable = value;
    }

    /**
     * Gets the value of the mtuSettable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMtuSettable() {
        return mtuSettable;
    }

    /**
     * Sets the value of the mtuSettable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMtuSettable(Boolean value) {
        this.mtuSettable = value;
    }

    /**
     * Gets the value of the hostNameAsTargetAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHostNameAsTargetAddress() {
        return hostNameAsTargetAddress;
    }

    /**
     * Sets the value of the hostNameAsTargetAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHostNameAsTargetAddress(Boolean value) {
        this.hostNameAsTargetAddress = value;
    }

    /**
     * Gets the value of the nameAliasSettable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNameAliasSettable() {
        return nameAliasSettable;
    }

    /**
     * Sets the value of the nameAliasSettable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNameAliasSettable(Boolean value) {
        this.nameAliasSettable = value;
    }

}
