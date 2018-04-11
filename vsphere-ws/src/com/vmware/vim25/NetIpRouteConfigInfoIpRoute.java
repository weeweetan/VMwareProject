
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetIpRouteConfigInfoIpRoute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NetIpRouteConfigInfoIpRoute">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="network" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prefixLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gateway" type="{urn:vim25}NetIpRouteConfigInfoGateway"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetIpRouteConfigInfoIpRoute", propOrder = {
    "network",
    "prefixLength",
    "gateway"
})
public class NetIpRouteConfigInfoIpRoute
    extends DynamicData
{

    @XmlElement(required = true)
    protected String network;
    protected int prefixLength;
    @XmlElement(required = true)
    protected NetIpRouteConfigInfoGateway gateway;

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
     * Gets the value of the prefixLength property.
     * 
     */
    public int getPrefixLength() {
        return prefixLength;
    }

    /**
     * Sets the value of the prefixLength property.
     * 
     */
    public void setPrefixLength(int value) {
        this.prefixLength = value;
    }

    /**
     * Gets the value of the gateway property.
     * 
     * @return
     *     possible object is
     *     {@link NetIpRouteConfigInfoGateway }
     *     
     */
    public NetIpRouteConfigInfoGateway getGateway() {
        return gateway;
    }

    /**
     * Sets the value of the gateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetIpRouteConfigInfoGateway }
     *     
     */
    public void setGateway(NetIpRouteConfigInfoGateway value) {
        this.gateway = value;
    }

}
