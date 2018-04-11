
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualEthernetCardNetworkBackingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualEthernetCardNetworkBackingInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceDeviceBackingInfo">
 *       &lt;sequence>
 *         &lt;element name="network" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="inPassthroughMode" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualEthernetCardNetworkBackingInfo", propOrder = {
    "network",
    "inPassthroughMode"
})
public class VirtualEthernetCardNetworkBackingInfo
    extends VirtualDeviceDeviceBackingInfo
{

    protected ManagedObjectReference network;
    protected Boolean inPassthroughMode;

    /**
     * Gets the value of the network property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setNetwork(ManagedObjectReference value) {
        this.network = value;
    }

    /**
     * Gets the value of the inPassthroughMode property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInPassthroughMode() {
        return inPassthroughMode;
    }

    /**
     * Sets the value of the inPassthroughMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInPassthroughMode(Boolean value) {
        this.inPassthroughMode = value;
    }

}
