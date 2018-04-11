
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostIpRouteConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostIpRouteConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="defaultGateway" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gatewayDevice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipV6DefaultGateway" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipV6GatewayDevice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostIpRouteConfig", propOrder = {
    "defaultGateway",
    "gatewayDevice",
    "ipV6DefaultGateway",
    "ipV6GatewayDevice"
})
@XmlSeeAlso({
    HostIpRouteConfigSpec.class
})
public class HostIpRouteConfig
    extends DynamicData
{

    protected String defaultGateway;
    protected String gatewayDevice;
    protected String ipV6DefaultGateway;
    protected String ipV6GatewayDevice;

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
     * Gets the value of the gatewayDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGatewayDevice() {
        return gatewayDevice;
    }

    /**
     * Sets the value of the gatewayDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGatewayDevice(String value) {
        this.gatewayDevice = value;
    }

    /**
     * Gets the value of the ipV6DefaultGateway property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpV6DefaultGateway() {
        return ipV6DefaultGateway;
    }

    /**
     * Sets the value of the ipV6DefaultGateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpV6DefaultGateway(String value) {
        this.ipV6DefaultGateway = value;
    }

    /**
     * Gets the value of the ipV6GatewayDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpV6GatewayDevice() {
        return ipV6GatewayDevice;
    }

    /**
     * Sets the value of the ipV6GatewayDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpV6GatewayDevice(String value) {
        this.ipV6GatewayDevice = value;
    }

}
