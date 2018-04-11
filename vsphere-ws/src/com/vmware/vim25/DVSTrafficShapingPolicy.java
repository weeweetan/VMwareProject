
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSTrafficShapingPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSTrafficShapingPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InheritablePolicy">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{urn:vim25}BoolPolicy" minOccurs="0"/>
 *         &lt;element name="averageBandwidth" type="{urn:vim25}LongPolicy" minOccurs="0"/>
 *         &lt;element name="peakBandwidth" type="{urn:vim25}LongPolicy" minOccurs="0"/>
 *         &lt;element name="burstSize" type="{urn:vim25}LongPolicy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSTrafficShapingPolicy", propOrder = {
    "enabled",
    "averageBandwidth",
    "peakBandwidth",
    "burstSize"
})
public class DVSTrafficShapingPolicy
    extends InheritablePolicy
{

    protected BoolPolicy enabled;
    protected LongPolicy averageBandwidth;
    protected LongPolicy peakBandwidth;
    protected LongPolicy burstSize;

    /**
     * Gets the value of the enabled property.
     * 
     * @return
     *     possible object is
     *     {@link BoolPolicy }
     *     
     */
    public BoolPolicy getEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolPolicy }
     *     
     */
    public void setEnabled(BoolPolicy value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the averageBandwidth property.
     * 
     * @return
     *     possible object is
     *     {@link LongPolicy }
     *     
     */
    public LongPolicy getAverageBandwidth() {
        return averageBandwidth;
    }

    /**
     * Sets the value of the averageBandwidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link LongPolicy }
     *     
     */
    public void setAverageBandwidth(LongPolicy value) {
        this.averageBandwidth = value;
    }

    /**
     * Gets the value of the peakBandwidth property.
     * 
     * @return
     *     possible object is
     *     {@link LongPolicy }
     *     
     */
    public LongPolicy getPeakBandwidth() {
        return peakBandwidth;
    }

    /**
     * Sets the value of the peakBandwidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link LongPolicy }
     *     
     */
    public void setPeakBandwidth(LongPolicy value) {
        this.peakBandwidth = value;
    }

    /**
     * Gets the value of the burstSize property.
     * 
     * @return
     *     possible object is
     *     {@link LongPolicy }
     *     
     */
    public LongPolicy getBurstSize() {
        return burstSize;
    }

    /**
     * Sets the value of the burstSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link LongPolicy }
     *     
     */
    public void setBurstSize(LongPolicy value) {
        this.burstSize = value;
    }

}
