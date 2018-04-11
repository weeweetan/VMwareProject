
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostSnmpSystemAgentLimits complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostSnmpSystemAgentLimits">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="maxReadOnlyCommunities" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxTrapDestinations" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxCommunityLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxBufferSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="capability" type="{urn:vim25}HostSnmpAgentCapability" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostSnmpSystemAgentLimits", propOrder = {
    "maxReadOnlyCommunities",
    "maxTrapDestinations",
    "maxCommunityLength",
    "maxBufferSize",
    "capability"
})
public class HostSnmpSystemAgentLimits
    extends DynamicData
{

    protected int maxReadOnlyCommunities;
    protected int maxTrapDestinations;
    protected int maxCommunityLength;
    protected int maxBufferSize;
    protected HostSnmpAgentCapability capability;

    /**
     * Gets the value of the maxReadOnlyCommunities property.
     * 
     */
    public int getMaxReadOnlyCommunities() {
        return maxReadOnlyCommunities;
    }

    /**
     * Sets the value of the maxReadOnlyCommunities property.
     * 
     */
    public void setMaxReadOnlyCommunities(int value) {
        this.maxReadOnlyCommunities = value;
    }

    /**
     * Gets the value of the maxTrapDestinations property.
     * 
     */
    public int getMaxTrapDestinations() {
        return maxTrapDestinations;
    }

    /**
     * Sets the value of the maxTrapDestinations property.
     * 
     */
    public void setMaxTrapDestinations(int value) {
        this.maxTrapDestinations = value;
    }

    /**
     * Gets the value of the maxCommunityLength property.
     * 
     */
    public int getMaxCommunityLength() {
        return maxCommunityLength;
    }

    /**
     * Sets the value of the maxCommunityLength property.
     * 
     */
    public void setMaxCommunityLength(int value) {
        this.maxCommunityLength = value;
    }

    /**
     * Gets the value of the maxBufferSize property.
     * 
     */
    public int getMaxBufferSize() {
        return maxBufferSize;
    }

    /**
     * Sets the value of the maxBufferSize property.
     * 
     */
    public void setMaxBufferSize(int value) {
        this.maxBufferSize = value;
    }

    /**
     * Gets the value of the capability property.
     * 
     * @return
     *     possible object is
     *     {@link HostSnmpAgentCapability }
     *     
     */
    public HostSnmpAgentCapability getCapability() {
        return capability;
    }

    /**
     * Sets the value of the capability property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostSnmpAgentCapability }
     *     
     */
    public void setCapability(HostSnmpAgentCapability value) {
        this.capability = value;
    }

}
