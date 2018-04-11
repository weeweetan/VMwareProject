
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetDhcpConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NetDhcpConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="ipv6" type="{urn:vim25}NetDhcpConfigSpecDhcpOptionsSpec" minOccurs="0"/>
 *         &lt;element name="ipv4" type="{urn:vim25}NetDhcpConfigSpecDhcpOptionsSpec" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetDhcpConfigSpec", propOrder = {
    "ipv6",
    "ipv4"
})
public class NetDhcpConfigSpec
    extends DynamicData
{

    protected NetDhcpConfigSpecDhcpOptionsSpec ipv6;
    protected NetDhcpConfigSpecDhcpOptionsSpec ipv4;

    /**
     * Gets the value of the ipv6 property.
     * 
     * @return
     *     possible object is
     *     {@link NetDhcpConfigSpecDhcpOptionsSpec }
     *     
     */
    public NetDhcpConfigSpecDhcpOptionsSpec getIpv6() {
        return ipv6;
    }

    /**
     * Sets the value of the ipv6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetDhcpConfigSpecDhcpOptionsSpec }
     *     
     */
    public void setIpv6(NetDhcpConfigSpecDhcpOptionsSpec value) {
        this.ipv6 = value;
    }

    /**
     * Gets the value of the ipv4 property.
     * 
     * @return
     *     possible object is
     *     {@link NetDhcpConfigSpecDhcpOptionsSpec }
     *     
     */
    public NetDhcpConfigSpecDhcpOptionsSpec getIpv4() {
        return ipv4;
    }

    /**
     * Sets the value of the ipv4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetDhcpConfigSpecDhcpOptionsSpec }
     *     
     */
    public void setIpv4(NetDhcpConfigSpecDhcpOptionsSpec value) {
        this.ipv4 = value;
    }

}
