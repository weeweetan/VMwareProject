
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhysicalNicCdpDeviceCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PhysicalNicCdpDeviceCapability">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="router" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="transparentBridge" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sourceRouteBridge" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="networkSwitch" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="igmpEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="repeater" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalNicCdpDeviceCapability", propOrder = {
    "router",
    "transparentBridge",
    "sourceRouteBridge",
    "networkSwitch",
    "host",
    "igmpEnabled",
    "repeater"
})
public class PhysicalNicCdpDeviceCapability
    extends DynamicData
{

    protected boolean router;
    protected boolean transparentBridge;
    protected boolean sourceRouteBridge;
    protected boolean networkSwitch;
    protected boolean host;
    protected boolean igmpEnabled;
    protected boolean repeater;

    /**
     * Gets the value of the router property.
     * 
     */
    public boolean isRouter() {
        return router;
    }

    /**
     * Sets the value of the router property.
     * 
     */
    public void setRouter(boolean value) {
        this.router = value;
    }

    /**
     * Gets the value of the transparentBridge property.
     * 
     */
    public boolean isTransparentBridge() {
        return transparentBridge;
    }

    /**
     * Sets the value of the transparentBridge property.
     * 
     */
    public void setTransparentBridge(boolean value) {
        this.transparentBridge = value;
    }

    /**
     * Gets the value of the sourceRouteBridge property.
     * 
     */
    public boolean isSourceRouteBridge() {
        return sourceRouteBridge;
    }

    /**
     * Sets the value of the sourceRouteBridge property.
     * 
     */
    public void setSourceRouteBridge(boolean value) {
        this.sourceRouteBridge = value;
    }

    /**
     * Gets the value of the networkSwitch property.
     * 
     */
    public boolean isNetworkSwitch() {
        return networkSwitch;
    }

    /**
     * Sets the value of the networkSwitch property.
     * 
     */
    public void setNetworkSwitch(boolean value) {
        this.networkSwitch = value;
    }

    /**
     * Gets the value of the host property.
     * 
     */
    public boolean isHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     */
    public void setHost(boolean value) {
        this.host = value;
    }

    /**
     * Gets the value of the igmpEnabled property.
     * 
     */
    public boolean isIgmpEnabled() {
        return igmpEnabled;
    }

    /**
     * Sets the value of the igmpEnabled property.
     * 
     */
    public void setIgmpEnabled(boolean value) {
        this.igmpEnabled = value;
    }

    /**
     * Gets the value of the repeater property.
     * 
     */
    public boolean isRepeater() {
        return repeater;
    }

    /**
     * Sets the value of the repeater property.
     * 
     */
    public void setRepeater(boolean value) {
        this.repeater = value;
    }

}
