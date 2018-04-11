
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostListSummaryQuickStats complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostListSummaryQuickStats">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="overallCpuUsage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="overallMemoryUsage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="distributedCpuFairness" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="distributedMemoryFairness" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="uptime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostListSummaryQuickStats", propOrder = {
    "overallCpuUsage",
    "overallMemoryUsage",
    "distributedCpuFairness",
    "distributedMemoryFairness",
    "uptime"
})
public class HostListSummaryQuickStats
    extends DynamicData
{

    protected Integer overallCpuUsage;
    protected Integer overallMemoryUsage;
    protected Integer distributedCpuFairness;
    protected Integer distributedMemoryFairness;
    protected Integer uptime;

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
     * Gets the value of the overallMemoryUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOverallMemoryUsage() {
        return overallMemoryUsage;
    }

    /**
     * Sets the value of the overallMemoryUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOverallMemoryUsage(Integer value) {
        this.overallMemoryUsage = value;
    }

    /**
     * Gets the value of the distributedCpuFairness property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDistributedCpuFairness() {
        return distributedCpuFairness;
    }

    /**
     * Sets the value of the distributedCpuFairness property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDistributedCpuFairness(Integer value) {
        this.distributedCpuFairness = value;
    }

    /**
     * Gets the value of the distributedMemoryFairness property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDistributedMemoryFairness() {
        return distributedMemoryFairness;
    }

    /**
     * Sets the value of the distributedMemoryFairness property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDistributedMemoryFairness(Integer value) {
        this.distributedMemoryFairness = value;
    }

    /**
     * Gets the value of the uptime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUptime() {
        return uptime;
    }

    /**
     * Sets the value of the uptime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUptime(Integer value) {
        this.uptime = value;
    }

}
