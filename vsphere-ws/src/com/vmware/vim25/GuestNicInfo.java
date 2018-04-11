
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestNicInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuestNicInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="network" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipAddress" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="macAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="deviceConfigId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dnsConfig" type="{urn:vim25}NetDnsConfigInfo" minOccurs="0"/>
 *         &lt;element name="ipConfig" type="{urn:vim25}NetIpConfigInfo" minOccurs="0"/>
 *         &lt;element name="netBIOSConfig" type="{urn:vim25}NetBIOSConfigInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestNicInfo", propOrder = {
    "network",
    "ipAddress",
    "macAddress",
    "connected",
    "deviceConfigId",
    "dnsConfig",
    "ipConfig",
    "netBIOSConfig"
})
public class GuestNicInfo
    extends DynamicData
{

    protected String network;
    protected List<String> ipAddress;
    protected String macAddress;
    protected boolean connected;
    protected int deviceConfigId;
    protected NetDnsConfigInfo dnsConfig;
    protected NetIpConfigInfo ipConfig;
    protected NetBIOSConfigInfo netBIOSConfig;

    /**
     * Gets the value of the network property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetwork(String value) {
        this.network = value;
    }

    /**
     * Gets the value of the ipAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIpAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIpAddress() {
        if (ipAddress == null) {
            ipAddress = new ArrayList<String>();
        }
        return this.ipAddress;
    }

    /**
     * Gets the value of the macAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Sets the value of the macAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress(String value) {
        this.macAddress = value;
    }

    /**
     * Gets the value of the connected property.
     * 
     */
    public boolean isConnected() {
        return connected;
    }

    /**
     * Sets the value of the connected property.
     * 
     */
    public void setConnected(boolean value) {
        this.connected = value;
    }

    /**
     * Gets the value of the deviceConfigId property.
     * 
     */
    public int getDeviceConfigId() {
        return deviceConfigId;
    }

    /**
     * Sets the value of the deviceConfigId property.
     * 
     */
    public void setDeviceConfigId(int value) {
        this.deviceConfigId = value;
    }

    /**
     * Gets the value of the dnsConfig property.
     * 
     * @return
     *     possible object is
     *     {@link NetDnsConfigInfo }
     *     
     */
    public NetDnsConfigInfo getDnsConfig() {
        return dnsConfig;
    }

    /**
     * Sets the value of the dnsConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetDnsConfigInfo }
     *     
     */
    public void setDnsConfig(NetDnsConfigInfo value) {
        this.dnsConfig = value;
    }

    /**
     * Gets the value of the ipConfig property.
     * 
     * @return
     *     possible object is
     *     {@link NetIpConfigInfo }
     *     
     */
    public NetIpConfigInfo getIpConfig() {
        return ipConfig;
    }

    /**
     * Sets the value of the ipConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetIpConfigInfo }
     *     
     */
    public void setIpConfig(NetIpConfigInfo value) {
        this.ipConfig = value;
    }

    /**
     * Gets the value of the netBIOSConfig property.
     * 
     * @return
     *     possible object is
     *     {@link NetBIOSConfigInfo }
     *     
     */
    public NetBIOSConfigInfo getNetBIOSConfig() {
        return netBIOSConfig;
    }

    /**
     * Sets the value of the netBIOSConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetBIOSConfigInfo }
     *     
     */
    public void setNetBIOSConfig(NetBIOSConfigInfo value) {
        this.netBIOSConfig = value;
    }

}
