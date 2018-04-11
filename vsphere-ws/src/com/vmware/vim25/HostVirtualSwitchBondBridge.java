
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostVirtualSwitchBondBridge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostVirtualSwitchBondBridge">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostVirtualSwitchBridge">
 *       &lt;sequence>
 *         &lt;element name="nicDevice" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="beacon" type="{urn:vim25}HostVirtualSwitchBeaconConfig" minOccurs="0"/>
 *         &lt;element name="linkDiscoveryProtocolConfig" type="{urn:vim25}LinkDiscoveryProtocolConfig" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostVirtualSwitchBondBridge", propOrder = {
    "nicDevice",
    "beacon",
    "linkDiscoveryProtocolConfig"
})
public class HostVirtualSwitchBondBridge
    extends HostVirtualSwitchBridge
{

    @XmlElement(required = true)
    protected List<String> nicDevice;
    protected HostVirtualSwitchBeaconConfig beacon;
    protected LinkDiscoveryProtocolConfig linkDiscoveryProtocolConfig;

    /**
     * Gets the value of the nicDevice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nicDevice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNicDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNicDevice() {
        if (nicDevice == null) {
            nicDevice = new ArrayList<String>();
        }
        return this.nicDevice;
    }

    /**
     * Gets the value of the beacon property.
     * 
     * @return
     *     possible object is
     *     {@link HostVirtualSwitchBeaconConfig }
     *     
     */
    public HostVirtualSwitchBeaconConfig getBeacon() {
        return beacon;
    }

    /**
     * Sets the value of the beacon property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostVirtualSwitchBeaconConfig }
     *     
     */
    public void setBeacon(HostVirtualSwitchBeaconConfig value) {
        this.beacon = value;
    }

    /**
     * Gets the value of the linkDiscoveryProtocolConfig property.
     * 
     * @return
     *     possible object is
     *     {@link LinkDiscoveryProtocolConfig }
     *     
     */
    public LinkDiscoveryProtocolConfig getLinkDiscoveryProtocolConfig() {
        return linkDiscoveryProtocolConfig;
    }

    /**
     * Sets the value of the linkDiscoveryProtocolConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkDiscoveryProtocolConfig }
     *     
     */
    public void setLinkDiscoveryProtocolConfig(LinkDiscoveryProtocolConfig value) {
        this.linkDiscoveryProtocolConfig = value;
    }

}
