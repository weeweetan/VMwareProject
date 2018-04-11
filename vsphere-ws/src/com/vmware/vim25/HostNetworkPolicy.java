
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostNetworkPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostNetworkPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="security" type="{urn:vim25}HostNetworkSecurityPolicy" minOccurs="0"/>
 *         &lt;element name="nicTeaming" type="{urn:vim25}HostNicTeamingPolicy" minOccurs="0"/>
 *         &lt;element name="offloadPolicy" type="{urn:vim25}HostNetOffloadCapabilities" minOccurs="0"/>
 *         &lt;element name="shapingPolicy" type="{urn:vim25}HostNetworkTrafficShapingPolicy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostNetworkPolicy", propOrder = {
    "security",
    "nicTeaming",
    "offloadPolicy",
    "shapingPolicy"
})
public class HostNetworkPolicy
    extends DynamicData
{

    protected HostNetworkSecurityPolicy security;
    protected HostNicTeamingPolicy nicTeaming;
    protected HostNetOffloadCapabilities offloadPolicy;
    protected HostNetworkTrafficShapingPolicy shapingPolicy;

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link HostNetworkSecurityPolicy }
     *     
     */
    public HostNetworkSecurityPolicy getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostNetworkSecurityPolicy }
     *     
     */
    public void setSecurity(HostNetworkSecurityPolicy value) {
        this.security = value;
    }

    /**
     * Gets the value of the nicTeaming property.
     * 
     * @return
     *     possible object is
     *     {@link HostNicTeamingPolicy }
     *     
     */
    public HostNicTeamingPolicy getNicTeaming() {
        return nicTeaming;
    }

    /**
     * Sets the value of the nicTeaming property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostNicTeamingPolicy }
     *     
     */
    public void setNicTeaming(HostNicTeamingPolicy value) {
        this.nicTeaming = value;
    }

    /**
     * Gets the value of the offloadPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link HostNetOffloadCapabilities }
     *     
     */
    public HostNetOffloadCapabilities getOffloadPolicy() {
        return offloadPolicy;
    }

    /**
     * Sets the value of the offloadPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostNetOffloadCapabilities }
     *     
     */
    public void setOffloadPolicy(HostNetOffloadCapabilities value) {
        this.offloadPolicy = value;
    }

    /**
     * Gets the value of the shapingPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link HostNetworkTrafficShapingPolicy }
     *     
     */
    public HostNetworkTrafficShapingPolicy getShapingPolicy() {
        return shapingPolicy;
    }

    /**
     * Sets the value of the shapingPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostNetworkTrafficShapingPolicy }
     *     
     */
    public void setShapingPolicy(HostNetworkTrafficShapingPolicy value) {
        this.shapingPolicy = value;
    }

}
