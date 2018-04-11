
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostNetworkInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostNetworkInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="vswitch" type="{urn:vim25}HostVirtualSwitch" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="proxySwitch" type="{urn:vim25}HostProxySwitch" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="portgroup" type="{urn:vim25}HostPortGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pnic" type="{urn:vim25}PhysicalNic" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vnic" type="{urn:vim25}HostVirtualNic" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="consoleVnic" type="{urn:vim25}HostVirtualNic" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dnsConfig" type="{urn:vim25}HostDnsConfig" minOccurs="0"/>
 *         &lt;element name="ipRouteConfig" type="{urn:vim25}HostIpRouteConfig" minOccurs="0"/>
 *         &lt;element name="consoleIpRouteConfig" type="{urn:vim25}HostIpRouteConfig" minOccurs="0"/>
 *         &lt;element name="routeTableInfo" type="{urn:vim25}HostIpRouteTableInfo" minOccurs="0"/>
 *         &lt;element name="dhcp" type="{urn:vim25}HostDhcpService" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nat" type="{urn:vim25}HostNatService" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ipV6Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="atBootIpV6Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostNetworkInfo", propOrder = {
    "vswitch",
    "proxySwitch",
    "portgroup",
    "pnic",
    "vnic",
    "consoleVnic",
    "dnsConfig",
    "ipRouteConfig",
    "consoleIpRouteConfig",
    "routeTableInfo",
    "dhcp",
    "nat",
    "ipV6Enabled",
    "atBootIpV6Enabled"
})
public class HostNetworkInfo
    extends DynamicData
{

    protected List<HostVirtualSwitch> vswitch;
    protected List<HostProxySwitch> proxySwitch;
    protected List<HostPortGroup> portgroup;
    protected List<PhysicalNic> pnic;
    protected List<HostVirtualNic> vnic;
    protected List<HostVirtualNic> consoleVnic;
    protected HostDnsConfig dnsConfig;
    protected HostIpRouteConfig ipRouteConfig;
    protected HostIpRouteConfig consoleIpRouteConfig;
    protected HostIpRouteTableInfo routeTableInfo;
    protected List<HostDhcpService> dhcp;
    protected List<HostNatService> nat;
    protected Boolean ipV6Enabled;
    protected Boolean atBootIpV6Enabled;

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
     * {@link HostVirtualSwitch }
     * 
     * 
     */
    public List<HostVirtualSwitch> getVswitch() {
        if (vswitch == null) {
            vswitch = new ArrayList<HostVirtualSwitch>();
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
     * {@link HostProxySwitch }
     * 
     * 
     */
    public List<HostProxySwitch> getProxySwitch() {
        if (proxySwitch == null) {
            proxySwitch = new ArrayList<HostProxySwitch>();
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
     * {@link HostPortGroup }
     * 
     * 
     */
    public List<HostPortGroup> getPortgroup() {
        if (portgroup == null) {
            portgroup = new ArrayList<HostPortGroup>();
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
     * {@link PhysicalNic }
     * 
     * 
     */
    public List<PhysicalNic> getPnic() {
        if (pnic == null) {
            pnic = new ArrayList<PhysicalNic>();
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
     * {@link HostVirtualNic }
     * 
     * 
     */
    public List<HostVirtualNic> getVnic() {
        if (vnic == null) {
            vnic = new ArrayList<HostVirtualNic>();
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
     * {@link HostVirtualNic }
     * 
     * 
     */
    public List<HostVirtualNic> getConsoleVnic() {
        if (consoleVnic == null) {
            consoleVnic = new ArrayList<HostVirtualNic>();
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
     * Gets the value of the routeTableInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostIpRouteTableInfo }
     *     
     */
    public HostIpRouteTableInfo getRouteTableInfo() {
        return routeTableInfo;
    }

    /**
     * Sets the value of the routeTableInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostIpRouteTableInfo }
     *     
     */
    public void setRouteTableInfo(HostIpRouteTableInfo value) {
        this.routeTableInfo = value;
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
     * {@link HostDhcpService }
     * 
     * 
     */
    public List<HostDhcpService> getDhcp() {
        if (dhcp == null) {
            dhcp = new ArrayList<HostDhcpService>();
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
     * {@link HostNatService }
     * 
     * 
     */
    public List<HostNatService> getNat() {
        if (nat == null) {
            nat = new ArrayList<HostNatService>();
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

    /**
     * Gets the value of the atBootIpV6Enabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAtBootIpV6Enabled() {
        return atBootIpV6Enabled;
    }

    /**
     * Sets the value of the atBootIpV6Enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAtBootIpV6Enabled(Boolean value) {
        this.atBootIpV6Enabled = value;
    }

}
