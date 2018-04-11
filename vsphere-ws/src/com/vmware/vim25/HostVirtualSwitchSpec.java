
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostVirtualSwitchSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostVirtualSwitchSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="numPorts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bridge" type="{urn:vim25}HostVirtualSwitchBridge" minOccurs="0"/>
 *         &lt;element name="policy" type="{urn:vim25}HostNetworkPolicy" minOccurs="0"/>
 *         &lt;element name="mtu" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostVirtualSwitchSpec", propOrder = {
    "numPorts",
    "bridge",
    "policy",
    "mtu"
})
public class HostVirtualSwitchSpec
    extends DynamicData
{

    protected int numPorts;
    protected HostVirtualSwitchBridge bridge;
    protected HostNetworkPolicy policy;
    protected Integer mtu;

    /**
     * Gets the value of the numPorts property.
     * 
     */
    public int getNumPorts() {
        return numPorts;
    }

    /**
     * Sets the value of the numPorts property.
     * 
     */
    public void setNumPorts(int value) {
        this.numPorts = value;
    }

    /**
     * Gets the value of the bridge property.
     * 
     * @return
     *     possible object is
     *     {@link HostVirtualSwitchBridge }
     *     
     */
    public HostVirtualSwitchBridge getBridge() {
        return bridge;
    }

    /**
     * Sets the value of the bridge property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostVirtualSwitchBridge }
     *     
     */
    public void setBridge(HostVirtualSwitchBridge value) {
        this.bridge = value;
    }

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link HostNetworkPolicy }
     *     
     */
    public HostNetworkPolicy getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostNetworkPolicy }
     *     
     */
    public void setPolicy(HostNetworkPolicy value) {
        this.policy = value;
    }

    /**
     * Gets the value of the mtu property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMtu() {
        return mtu;
    }

    /**
     * Sets the value of the mtu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMtu(Integer value) {
        this.mtu = value;
    }

}
