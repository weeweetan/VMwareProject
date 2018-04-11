
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostNetworkConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostNetworkConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="vswitch" type="{urn:vim25}HostVirtualSwitchConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="proxySwitch" type="{urn:vim25}HostProxySwitchConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="portgroup" type="{urn:vim25}HostPortGroupConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pnic" type="{urn:vim25}PhysicalNicConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vnic" type="{urn:vim25}HostVirtualNicConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="consoleVnic" type="{urn:vim25}HostVirtualNicConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dnsConfig" type="{urn:vim25}HostDnsConfig" minOccurs="0"/>
 *         &lt;element name="ipRouteConfig" type="{urn:vim25}HostIpRouteConfig" minOccurs="0"/>
 *         &lt;element name="consoleIpRouteConfig" type="{urn:vim25}HostIpRouteConfig" minOccurs="0"/>
 *         &lt;element name="routeTableConfig" type="{urn:vim25}HostIpRouteTableConfig" minOccurs="0"/>
 *         &lt;element name="dhcp" type="{urn:vim25}HostDhcpServiceConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nat" type="{urn:vim25}HostNatServiceConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ipV6Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostNetworkConfig", propOrder = {
    "vswitch",
    "proxySwitch",
    "portgroup",
    "pnic",
    "vnic",
    "consoleVnic",
    "dnsConfig",
    "ipRouteConfig",
    "consoleIpRouteConfig",
    "routeTableConfig",
    "dhcp",
    "nat",
    "ipV6Enabled"
})
public class HostNetworkConfig
    extends DynamicData
{

    protected List<HostVirtualSwitchConfig> vswitch;
    protected List<HostProxySwitchConfig> proxySwitch;
    protected List<HostPortGroupConfig> portgroup;
    protected List<PhysicalNicConfig> pnic;
    protected List<HostVirtualNicConfig> vnic;
    protected List<HostVirtualNicConfig> consoleVnic;
    protected HostDnsConfig dnsConfig;
    protected HostIpRouteConfig ipRouteConfig;
    protected HostIpRouteConfig consoleIpRouteConfig;
    protected HostIpRouteTableConfig routeTableConfig;
    protected List<HostDhcpServiceConfig> dhcp;
    protected List<HostNatServiceConfig> nat;
    protected Boolean ipV6Enabled;

    /**
     * Gets the value of the vswitch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vswitch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVswitch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostVirtualSwitchConfig }
     * 
     * 
     */
    public List<HostVirtualSwitchConfig> getVswitch() {
        if (vswitch == null) {
            vswitch = new ArrayList<HostVirtualSwitchConfig>();
        }
        return this.vswitch;
    }

    /**
     * Gets the value of the proxySwitch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proxySwitch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProxySwitch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostProxySwitchConfig }
     * 
     * 
     */
    public List<HostProxySwitchConfig> getProxySwitch() {
        if (proxySwitch == null) {
            proxySwitch = new ArrayList<HostProxySwitchConfig>();
        }
        return this.proxySwitch;
    }

    /**
     * Gets the value of the portgroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the portgroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPortgroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPortGroupConfig }
     * 
     * 
     */
    public List<HostPortGroupConfig> getPortgroup() {
        if (portgroup == null) {
            portgroup = new ArrayList<HostPortGroupConfig>();
        }
        return this.portgroup;
    }

    /**
     * Gets the value of the pnic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pnic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPnic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhysicalNicConfig }
     * 
     * 
     */
    public List<PhysicalNicConfig> getPnic() {
        if (pnic == null) {
            pnic = new ArrayList<PhysicalNicConfig>();
        }
        return this.pnic;
    }

    /**
     * Gets the value of the vnic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vnic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVnic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostVirtualNicConfig }
     * 
     * 
     */
    public List<HostVirtualNicConfig> getVnic() {
        if (vnic == null) {
            vnic = new ArrayList<HostVirtualNicConfig>();
        }
        return this.vnic;
    }

    /**
     * Gets the value of the consoleVnic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consoleVnic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsoleVnic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostVirtualNicConfig }
     * 
     * 
     */
    public List<HostVirtualNicConfig> getConsoleVnic() {
        if (consoleVnic == null) {
            consoleVnic = new ArrayList<HostVirtualNicConfig>();
        }
        return this.consoleVnic;
    }

    /**
     * Gets the value of the dnsConfig property.
     * 
     * @return
     *     possible object is
     *     {@link HostDnsConfig }
     *     
     */
    public HostDnsConfig getDnsConfig() {
        return dnsConfig;
    }

    /**
     * Sets the value of the dnsConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostDnsConfig }
     *     
     */
    public void setDnsConfig(HostDnsConfig value) {
        this.dnsConfig = value;
    }

    /**
     * Gets the value of the ipRouteConfig property.
     * 
     * @return
     *     possible object is
     *     {@link HostIpRouteConfig }
     *     
     */
    public HostIpRouteConfig getIpRouteConfig() {
        return ipRouteConfig;
    }

    /**
     * Sets the value of the ipRouteConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostIpRouteConfig }
     *     
     */
    public void setIpRouteConfig(HostIpRouteConfig value) {
        this.ipRouteConfig = value;
    }

    /**
     * Gets the value of the consoleIpRouteConfig property.
     * 
     * @return
     *     possible object is
     *     {@link HostIpRouteConfig }
     *     
     */
    public HostIpRouteConfig getConsoleIpRouteConfig() {
        return consoleIpRouteConfig;
    }

    /**
     * Sets the value of the consoleIpRouteConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostIpRouteConfig }
     *     
     */
    public void setConsoleIpRouteConfig(HostIpRouteConfig value) {
        this.consoleIpRouteConfig = value;
    }

    /**
     * Gets the value of the routeTableConfig property.
     * 
     * @return
     *     possible object is
     *     {@link HostIpRouteTableConfig }
     *     
     */
    public HostIpRouteTableConfig getRouteTableConfig() {
        return routeTableConfig;
    }

    /**
     * Sets the value of the routeTableConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostIpRouteTableConfig }
     *     
     */
    public void setRouteTableConfig(HostIpRouteTableConfig value) {
        this.routeTableConfig = value;
    }

    /**
     * Gets the value of the dhcp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dhcp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDhcp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostDhcpServiceConfig }
     * 
     * 
     */
    public List<HostDhcpServiceConfig> getDhcp() {
        if (dhcp == null) {
            dhcp = new ArrayList<HostDhcpServiceConfig>();
        }
        return this.dhcp;
    }

    /**
     * Gets the value of the nat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostNatServiceConfig }
     * 
     * 
     */
    public List<HostNatServiceConfig> getNat() {
        if (nat == null) {
            nat = new ArrayList<HostNatServiceConfig>();
        }
        return this.nat;
    }

    /**
     * Gets the value of the ipV6Enabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIpV6Enabled() {
        return ipV6Enabled;
    }

    /**
     * Sets the value of the ipV6Enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIpV6Enabled(Boolean value) {
        this.ipV6Enabled = value;
    }

}
