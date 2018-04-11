
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterVmToolsMonitoringSettings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterVmToolsMonitoringSettings">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vmMonitoring" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clusterSettings" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="failureInterval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="minUpTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxFailures" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxFailureWindow" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterVmToolsMonitoringSettings", propOrder = {
    "enabled",
    "vmMonitoring",
    "clusterSettings",
    "failureInterval",
    "minUpTime",
    "maxFailures",
    "maxFailureWindow"
})
public class ClusterVmToolsMonitoringSettings
    extends DynamicData
{

    protected Boolean enabled;
    protected String vmMonitoring;
    protected Boolean clusterSettings;
    protected Integer failureInterval;
    protected Integer minUpTime;
    protected Integer maxFailures;
    protected Integer maxFailureWindow;

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
     * Gets the value of the vmMonitoring property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVmMonitoring() {
        return vmMonitoring;
    }

    /**
     * Sets the value of the vmMonitoring property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVmMonitoring(String value) {
        this.vmMonitoring = value;
    }

    /**
     * Gets the value of the clusterSettings property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isClusterSettings() {
        return clusterSettings;
    }

    /**
     * Sets the value of the clusterSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setClusterSettings(Boolean value) {
        this.clusterSettings = value;
    }

    /**
     * Gets the value of the failureInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFailureInterval() {
        return failureInterval;
    }

    /**
     * Sets the value of the failureInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFailureInterval(Integer value) {
        this.failureInterval = value;
    }

    /**
     * Gets the value of the minUpTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinUpTime() {
        return minUpTime;
    }

    /**
     * Sets the value of the minUpTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinUpTime(Integer value) {
        this.minUpTime = value;
    }

    /**
     * Gets the value of the maxFailures property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxFailures() {
        return maxFailures;
    }

    /**
     * Sets the value of the maxFailures property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxFailures(Integer value) {
        this.maxFailures = value;
    }

    /**
     * Gets the value of the maxFailureWindow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxFailureWindow() {
        return maxFailureWindow;
    }

    /**
     * Sets the value of the maxFailureWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxFailureWindow(Integer value) {
        this.maxFailureWindow = value;
    }

}
