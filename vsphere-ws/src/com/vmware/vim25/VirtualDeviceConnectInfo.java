
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDeviceConnectInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDeviceConnectInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="startConnected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="allowGuestControl" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="connected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDeviceConnectInfo", propOrder = {
    "startConnected",
    "allowGuestControl",
    "connected",
    "status"
})
public class VirtualDeviceConnectInfo
    extends DynamicData
{

    protected boolean startConnected;
    protected boolean allowGuestControl;
    protected boolean connected;
    protected String status;

    /**
     * Gets the value of the startConnected property.
     * 
     */
    public boolean isStartConnected() {
        return startConnected;
    }

    /**
     * Sets the value of the startConnected property.
     * 
     */
    public void setStartConnected(boolean value) {
        this.startConnected = value;
    }

    /**
     * Gets the value of the allowGuestControl property.
     * 
     */
    public boolean isAllowGuestControl() {
        return allowGuestControl;
    }

    /**
     * Sets the value of the allowGuestControl property.
     * 
     */
    public void setAllowGuestControl(boolean value) {
        this.allowGuestControl = value;
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
