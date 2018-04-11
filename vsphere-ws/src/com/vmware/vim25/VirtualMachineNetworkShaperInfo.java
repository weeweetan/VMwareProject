
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineNetworkShaperInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineNetworkShaperInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="peakBps" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="averageBps" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="burstSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineNetworkShaperInfo", propOrder = {
    "enabled",
    "peakBps",
    "averageBps",
    "burstSize"
})
public class VirtualMachineNetworkShaperInfo
    extends DynamicData
{

    protected Boolean enabled;
    protected Long peakBps;
    protected Long averageBps;
    protected Long burstSize;

    /**
     * Gets the value of the enabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the peakBps property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPeakBps() {
        return peakBps;
    }

    /**
     * Sets the value of the peakBps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPeakBps(Long value) {
        this.peakBps = value;
    }

    /**
     * Gets the value of the averageBps property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAverageBps() {
        return averageBps;
    }

    /**
     * Sets the value of the averageBps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAverageBps(Long value) {
        this.averageBps = value;
    }

    /**
     * Gets the value of the burstSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBurstSize() {
        return burstSize;
    }

    /**
     * Sets the value of the burstSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBurstSize(Long value) {
        this.burstSize = value;
    }

}
