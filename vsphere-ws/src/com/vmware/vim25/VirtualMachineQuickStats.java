
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineQuickStats complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineQuickStats">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="overallCpuUsage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="overallCpuDemand" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="guestMemoryUsage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="hostMemoryUsage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="guestHeartbeatStatus" type="{urn:vim25}ManagedEntityStatus"/>
 *         &lt;element name="distributedCpuEntitlement" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="distributedMemoryEntitlement" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="staticCpuEntitlement" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="staticMemoryEntitlement" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="privateMemory" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sharedMemory" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="swappedMemory" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="balloonedMemory" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="consumedOverheadMemory" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ftLogBandwidth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ftSecondaryLatency" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ftLatencyStatus" type="{urn:vim25}ManagedEntityStatus" minOccurs="0"/>
 *         &lt;element name="compressedMemory" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="uptimeSeconds" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ssdSwappedMemory" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineQuickStats", propOrder = {
    "overallCpuUsage",
    "overallCpuDemand",
    "guestMemoryUsage",
    "hostMemoryUsage",
    "guestHeartbeatStatus",
    "distributedCpuEntitlement",
    "distributedMemoryEntitlement",
    "staticCpuEntitlement",
    "staticMemoryEntitlement",
    "privateMemory",
    "sharedMemory",
    "swappedMemory",
    "balloonedMemory",
    "consumedOverheadMemory",
    "ftLogBandwidth",
    "ftSecondaryLatency",
    "ftLatencyStatus",
    "compressedMemory",
    "uptimeSeconds",
    "ssdSwappedMemory"
})
public class VirtualMachineQuickStats
    extends DynamicData
{

    protected Integer overallCpuUsage;
    protected Integer overallCpuDemand;
    protected Integer guestMemoryUsage;
    protected Integer hostMemoryUsage;
    @XmlElement(required = true)
    protected ManagedEntityStatus guestHeartbeatStatus;
    protected Integer distributedCpuEntitlement;
    protected Integer distributedMemoryEntitlement;
    protected Integer staticCpuEntitlement;
    protected Integer staticMemoryEntitlement;
    protected Integer privateMemory;
    protected Integer sharedMemory;
    protected Integer swappedMemory;
    protected Integer balloonedMemory;
    protected Integer consumedOverheadMemory;
    protected Integer ftLogBandwidth;
    protected Integer ftSecondaryLatency;
    protected ManagedEntityStatus ftLatencyStatus;
    protected Long compressedMemory;
    protected Integer uptimeSeconds;
    protected Long ssdSwappedMemory;

    /**
     * Gets the value of the overallCpuUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOverallCpuUsage() {
        return overallCpuUsage;
    }

    /**
     * Sets the value of the overallCpuUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOverallCpuUsage(Integer value) {
        this.overallCpuUsage = value;
    }

    /**
     * Gets the value of the overallCpuDemand property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOverallCpuDemand() {
        return overallCpuDemand;
    }

    /**
     * Sets the value of the overallCpuDemand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOverallCpuDemand(Integer value) {
        this.overallCpuDemand = value;
    }

    /**
     * Gets the value of the guestMemoryUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGuestMemoryUsage() {
        return guestMemoryUsage;
    }

    /**
     * Sets the value of the guestMemoryUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGuestMemoryUsage(Integer value) {
        this.guestMemoryUsage = value;
    }

    /**
     * Gets the value of the hostMemoryUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHostMemoryUsage() {
        return hostMemoryUsage;
    }

    /**
     * Sets the value of the hostMemoryUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHostMemoryUsage(Integer value) {
        this.hostMemoryUsage = value;
    }

    /**
     * Gets the value of the guestHeartbeatStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public ManagedEntityStatus getGuestHeartbeatStatus() {
        return guestHeartbeatStatus;
    }

    /**
     * Sets the value of the guestHeartbeatStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public void setGuestHeartbeatStatus(ManagedEntityStatus value) {
        this.guestHeartbeatStatus = value;
    }

    /**
     * Gets the value of the distributedCpuEntitlement property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDistributedCpuEntitlement() {
        return distributedCpuEntitlement;
    }

    /**
     * Sets the value of the distributedCpuEntitlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDistributedCpuEntitlement(Integer value) {
        this.distributedCpuEntitlement = value;
    }

    /**
     * Gets the value of the distributedMemoryEntitlement property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDistributedMemoryEntitlement() {
        return distributedMemoryEntitlement;
    }

    /**
     * Sets the value of the distributedMemoryEntitlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDistributedMemoryEntitlement(Integer value) {
        this.distributedMemoryEntitlement = value;
    }

    /**
     * Gets the value of the staticCpuEntitlement property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStaticCpuEntitlement() {
        return staticCpuEntitlement;
    }

    /**
     * Sets the value of the staticCpuEntitlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStaticCpuEntitlement(Integer value) {
        this.staticCpuEntitlement = value;
    }

    /**
     * Gets the value of the staticMemoryEntitlement property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStaticMemoryEntitlement() {
        return staticMemoryEntitlement;
    }

    /**
     * Sets the value of the staticMemoryEntitlement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStaticMemoryEntitlement(Integer value) {
        this.staticMemoryEntitlement = value;
    }

    /**
     * Gets the value of the privateMemory property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPrivateMemory() {
        return privateMemory;
    }

    /**
     * Sets the value of the privateMemory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPrivateMemory(Integer value) {
        this.privateMemory = value;
    }

    /**
     * Gets the value of the sharedMemory property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSharedMemory() {
        return sharedMemory;
    }

    /**
     * Sets the value of the sharedMemory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSharedMemory(Integer value) {
        this.sharedMemory = value;
    }

    /**
     * Gets the value of the swappedMemory property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSwappedMemory() {
        return swappedMemory;
    }

    /**
     * Sets the value of the swappedMemory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSwappedMemory(Integer value) {
        this.swappedMemory = value;
    }

    /**
     * Gets the value of the balloonedMemory property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBalloonedMemory() {
        return balloonedMemory;
    }

    /**
     * Sets the value of the balloonedMemory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBalloonedMemory(Integer value) {
        this.balloonedMemory = value;
    }

    /**
     * Gets the value of the consumedOverheadMemory property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getConsumedOverheadMemory() {
        return consumedOverheadMemory;
    }

    /**
     * Sets the value of the consumedOverheadMemory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setConsumedOverheadMemory(Integer value) {
        this.consumedOverheadMemory = value;
    }

    /**
     * Gets the value of the ftLogBandwidth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFtLogBandwidth() {
        return ftLogBandwidth;
    }

    /**
     * Sets the value of the ftLogBandwidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFtLogBandwidth(Integer value) {
        this.ftLogBandwidth = value;
    }

    /**
     * Gets the value of the ftSecondaryLatency property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFtSecondaryLatency() {
        return ftSecondaryLatency;
    }

    /**
     * Sets the value of the ftSecondaryLatency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFtSecondaryLatency(Integer value) {
        this.ftSecondaryLatency = value;
    }

    /**
     * Gets the value of the ftLatencyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public ManagedEntityStatus getFtLatencyStatus() {
        return ftLatencyStatus;
    }

    /**
     * Sets the value of the ftLatencyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public void setFtLatencyStatus(ManagedEntityStatus value) {
        this.ftLatencyStatus = value;
    }

    /**
     * Gets the value of the compressedMemory property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCompressedMemory() {
        return compressedMemory;
    }

    /**
     * Sets the value of the compressedMemory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCompressedMemory(Long value) {
        this.compressedMemory = value;
    }

    /**
     * Gets the value of the uptimeSeconds property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUptimeSeconds() {
        return uptimeSeconds;
    }

    /**
     * Sets the value of the uptimeSeconds property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUptimeSeconds(Integer value) {
        this.uptimeSeconds = value;
    }

    /**
     * Gets the value of the ssdSwappedMemory property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSsdSwappedMemory() {
        return ssdSwappedMemory;
    }

    /**
     * Sets the value of the ssdSwappedMemory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSsdSwappedMemory(Long value) {
        this.ssdSwappedMemory = value;
    }

}
