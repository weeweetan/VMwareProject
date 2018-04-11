
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetIpConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NetIpConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="ipAddress" type="{urn:vim25}NetIpConfigSpecIpAddressSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dhcp" type="{urn:vim25}NetDhcpConfigSpec" minOccurs="0"/>
 *         &lt;element name="autoConfigurationEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetIpConfigSpec", propOrder = {
    "ipAddress",
    "dhcp",
    "autoConfigurationEnabled"
})
public class NetIpConfigSpec
    extends DynamicData
{

    protected List<NetIpConfigSpecIpAddressSpec> ipAddress;
    protected NetDhcpConfigSpec dhcp;
    protected Boolean autoConfigurationEnabled;

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
     * {@link NetIpConfigSpecIpAddressSpec }
     * 
     * 
     */
    public List<NetIpConfigSpecIpAddressSpec> getIpAddress() {
        if (ipAddress == null) {
            ipAddress = new ArrayList<NetIpConfigSpecIpAddressSpec>();
        }
        return this.ipAddress;
    }

    /**
     * Gets the value of the dhcp property.
     * 
     * @return
     *     possible object is
     *     {@link NetDhcpConfigSpec }
     *     
     */
    public NetDhcpConfigSpec getDhcp() {
        return dhcp;
    }

    /**
     * Sets the value of the dhcp property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetDhcpConfigSpec }
     *     
     */
    public void setDhcp(NetDhcpConfigSpec value) {
        this.dhcp = value;
    }

    /**
     * Gets the value of the autoConfigurationEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoConfigurationEnabled() {
        return autoConfigurationEnabled;
    }

    /**
     * Sets the value of the autoConfigurationEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoConfigurationEnabled(Boolean value) {
        this.autoConfigurationEnabled = value;
    }

}
