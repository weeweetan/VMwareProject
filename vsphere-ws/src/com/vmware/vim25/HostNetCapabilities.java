
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostNetCapabilities complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostNetCapabilities">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="canSetPhysicalNicLinkSpeed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="supportsNicTeaming" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nicTeamingPolicy" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="supportsVlan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="usesServiceConsoleNic" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="supportsNetworkHints" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="maxPortGroupsPerVswitch" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vswitchConfigSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vnicConfigSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ipRouteConfigSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dnsConfigSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dhcpOnVnicSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ipV6Supported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostNetCapabilities", propOrder = {
    "canSetPhysicalNicLinkSpeed",
    "supportsNicTeaming",
    "nicTeamingPolicy",
    "supportsVlan",
    "usesServiceConsoleNic",
    "supportsNetworkHints",
    "maxPortGroupsPerVswitch",
    "vswitchConfigSupported",
    "vnicConfigSupported",
    "ipRouteConfigSupported",
    "dnsConfigSupported",
    "dhcpOnVnicSupported",
    "ipV6Supported"
})
public class HostNetCapabilities
    extends DynamicData
{

    protected boolean canSetPhysicalNicLinkSpeed;
    protected boolean supportsNicTeaming;
    protected List<String> nicTeamingPolicy;
    protected boolean supportsVlan;
    protected boolean usesServiceConsoleNic;
    protected boolean supportsNetworkHints;
    protected Integer maxPortGroupsPerVswitch;
    protected boolean vswitchConfigSupported;
    protected boolean vnicConfigSupported;
    protected boolean ipRouteConfigSupported;
    protected boolean dnsConfigSupported;
    protected boolean dhcpOnVnicSupported;
    protected Boolean ipV6Supported;

    /**
     * Gets the value of the canSetPhysicalNicLinkSpeed property.
     * 
     */
    public boolean isCanSetPhysicalNicLinkSpeed() {
        return canSetPhysicalNicLinkSpeed;
    }

    /**
     * Sets the value of the canSetPhysicalNicLinkSpeed property.
     * 
     */
    public void setCanSetPhysicalNicLinkSpeed(boolean value) {
        this.canSetPhysicalNicLinkSpeed = value;
    }

    /**
     * Gets the value of the supportsNicTeaming property.
     * 
     */
    public boolean isSupportsNicTeaming() {
        return supportsNicTeaming;
    }

    /**
     * Sets the value of the supportsNicTeaming property.
     * 
     */
    public void setSupportsNicTeaming(boolean value) {
        this.supportsNicTeaming = value;
    }

    /**
     * Gets the value of the nicTeamingPolicy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nicTeamingPolicy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNicTeamingPolicy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNicTeamingPolicy() {
        if (nicTeamingPolicy == null) {
            nicTeamingPolicy = new ArrayList<String>();
        }
        return this.nicTeamingPolicy;
    }

    /**
     * Gets the value of the supportsVlan property.
     * 
     */
    public boolean isSupportsVlan() {
        return supportsVlan;
    }

    /**
     * Sets the value of the supportsVlan property.
     * 
     */
    public void setSupportsVlan(boolean value) {
        this.supportsVlan = value;
    }

    /**
     * Gets the value of the usesServiceConsoleNic property.
     * 
     */
    public boolean isUsesServiceConsoleNic() {
        return usesServiceConsoleNic;
    }

    /**
     * Sets the value of the usesServiceConsoleNic property.
     * 
     */
    public void setUsesServiceConsoleNic(boolean value) {
        this.usesServiceConsoleNic = value;
    }

    /**
     * Gets the value of the supportsNetworkHints property.
     * 
     */
    public boolean isSupportsNetworkHints() {
        return supportsNetworkHints;
    }

    /**
     * Sets the value of the supportsNetworkHints property.
     * 
     */
    public void setSupportsNetworkHints(boolean value) {
        this.supportsNetworkHints = value;
    }

    /**
     * Gets the value of the maxPortGroupsPerVswitch property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxPortGroupsPerVswitch() {
        return maxPortGroupsPerVswitch;
    }

    /**
     * Sets the value of the maxPortGroupsPerVswitch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxPortGroupsPerVswitch(Integer value) {
        this.maxPortGroupsPerVswitch = value;
    }

    /**
     * Gets the value of the vswitchConfigSupported property.
     * 
     */
    public boolean isVswitchConfigSupported() {
        return vswitchConfigSupported;
    }

    /**
     * Sets the value of the vswitchConfigSupported property.
     * 
     */
    public void setVswitchConfigSupported(boolean value) {
        this.vswitchConfigSupported = value;
    }

    /**
     * Gets the value of the vnicConfigSupported property.
     * 
     */
    public boolean isVnicConfigSupported() {
        return vnicConfigSupported;
    }

    /**
     * Sets the value of the vnicConfigSupported property.
     * 
     */
    public void setVnicConfigSupported(boolean value) {
        this.vnicConfigSupported = value;
    }

    /**
     * Gets the value of the ipRouteConfigSupported property.
     * 
     */
    public boolean isIpRouteConfigSupported() {
        return ipRouteConfigSupported;
    }

    /**
     * Sets the value of the ipRouteConfigSupported property.
     * 
     */
    public void setIpRouteConfigSupported(boolean value) {
        this.ipRouteConfigSupported = value;
    }

    /**
     * Gets the value of the dnsConfigSupported property.
     * 
     */
    public boolean isDnsConfigSupported() {
        return dnsConfigSupported;
    }

    /**
     * Sets the value of the dnsConfigSupported property.
     * 
     */
    public void setDnsConfigSupported(boolean value) {
        this.dnsConfigSupported = value;
    }

    /**
     * Gets the value of the dhcpOnVnicSupported property.
     * 
     */
    public boolean isDhcpOnVnicSupported() {
        return dhcpOnVnicSupported;
    }

    /**
     * Sets the value of the dhcpOnVnicSupported property.
     * 
     */
    public void setDhcpOnVnicSupported(boolean value) {
        this.dhcpOnVnicSupported = value;
    }

    /**
     * Gets the value of the ipV6Supported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIpV6Supported() {
        return ipV6Supported;
    }

    /**
     * Sets the value of the ipV6Supported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIpV6Supported(Boolean value) {
        this.ipV6Supported = value;
    }

}
