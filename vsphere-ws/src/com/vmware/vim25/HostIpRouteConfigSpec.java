
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostIpRouteConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostIpRouteConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostIpRouteConfig">
 *       &lt;sequence>
 *         &lt;element name="gatewayDeviceConnection" type="{urn:vim25}HostVirtualNicConnection" minOccurs="0"/>
 *         &lt;element name="ipV6GatewayDeviceConnection" type="{urn:vim25}HostVirtualNicConnection" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostIpRouteConfigSpec", propOrder = {
    "gatewayDeviceConnection",
    "ipV6GatewayDeviceConnection"
})
public class HostIpRouteConfigSpec
    extends HostIpRouteConfig
{

    protected HostVirtualNicConnection gatewayDeviceConnection;
    protected HostVirtualNicConnection ipV6GatewayDeviceConnection;

    /**
     * Gets the value of the gatewayDeviceConnection property.
     * 
     * @return
     *     possible object is
     *     {@link HostVirtualNicConnection }
     *     
     */
    public HostVirtualNicConnection getGatewayDeviceConnection() {
        return gatewayDeviceConnection;
    }

    /**
     * Sets the value of the gatewayDeviceConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostVirtualNicConnection }
     *     
     */
    public void setGatewayDeviceConnection(HostVirtualNicConnection value) {
        this.gatewayDeviceConnection = value;
    }

    /**
     * Gets the value of the ipV6GatewayDeviceConnection property.
     * 
     * @return
     *     possible object is
     *     {@link HostVirtualNicConnection }
     *     
     */
    public HostVirtualNicConnection getIpV6GatewayDeviceConnection() {
        return ipV6GatewayDeviceConnection;
    }

    /**
     * Sets the value of the ipV6GatewayDeviceConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostVirtualNicConnection }
     *     
     */
    public void setIpV6GatewayDeviceConnection(HostVirtualNicConnection value) {
        this.ipV6GatewayDeviceConnection = value;
    }

}
