
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostListSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostListSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="host" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="hardware" type="{urn:vim25}HostHardwareSummary" minOccurs="0"/>
 *         &lt;element name="runtime" type="{urn:vim25}HostRuntimeInfo" minOccurs="0"/>
 *         &lt;element name="config" type="{urn:vim25}HostConfigSummary"/>
 *         &lt;element name="quickStats" type="{urn:vim25}HostListSummaryQuickStats"/>
 *         &lt;element name="overallStatus" type="{urn:vim25}ManagedEntityStatus"/>
 *         &lt;element name="rebootRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="customValue" type="{urn:vim25}CustomFieldValue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="managementServerIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxEVCModeKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentEVCModeKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostListSummary", propOrder = {
    "host",
    "hardware",
    "runtime",
    "config",
    "quickStats",
    "overallStatus",
    "rebootRequired",
    "customValue",
    "managementServerIp",
    "maxEVCModeKey",
    "currentEVCModeKey"
})
public class HostListSummary
    extends DynamicData
{

    protected ManagedObjectReference host;
    protected HostHardwareSummary hardware;
    protected HostRuntimeInfo runtime;
    @XmlElement(required = true)
    protected HostConfigSummary config;
    @XmlElement(required = true)
    protected HostListSummaryQuickStats quickStats;
    @XmlElement(required = true)
    protected ManagedEntityStatus overallStatus;
    protected boolean rebootRequired;
    protected List<CustomFieldValue> customValue;
    protected String managementServerIp;
    protected String maxEVCModeKey;
    protected String currentEVCModeKey;

    /**
     * Gets the value of the host property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setHost(ManagedObjectReference value) {
        this.host = value;
    }

    /**
     * Gets the value of the hardware property.
     * 
     * @return
     *     possible object is
     *     {@link HostHardwareSummary }
     *     
     */
    public HostHardwareSummary getHardware() {
        return hardware;
    }

    /**
     * Sets the value of the hardware property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostHardwareSummary }
     *     
     */
    public void setHardware(HostHardwareSummary value) {
        this.hardware = value;
    }

    /**
     * Gets the value of the runtime property.
     * 
     * @return
     *     possible object is
     *     {@link HostRuntimeInfo }
     *     
     */
    public HostRuntimeInfo getRuntime() {
        return runtime;
    }

    /**
     * Sets the value of the runtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostRuntimeInfo }
     *     
     */
    public void setRuntime(HostRuntimeInfo value) {
        this.runtime = value;
    }

    /**
     * Gets the value of the config property.
     * 
     * @return
     *     possible object is
     *     {@link HostConfigSummary }
     *     
     */
    public HostConfigSummary getConfig() {
        return config;
    }

    /**
     * Sets the value of the config property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostConfigSummary }
     *     
     */
    public void setConfig(HostConfigSummary value) {
        this.config = value;
    }

    /**
     * Gets the value of the quickStats property.
     * 
     * @return
     *     possible object is
     *     {@link HostListSummaryQuickStats }
     *     
     */
    public HostListSummaryQuickStats getQuickStats() {
        return quickStats;
    }

    /**
     * Sets the value of the quickStats property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostListSummaryQuickStats }
     *     
     */
    public void setQuickStats(HostListSummaryQuickStats value) {
        this.quickStats = value;
    }

    /**
     * Gets the value of the overallStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public ManagedEntityStatus getOverallStatus() {
        return overallStatus;
    }

    /**
     * Sets the value of the overallStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public void setOverallStatus(ManagedEntityStatus value) {
        this.overallStatus = value;
    }

    /**
     * Gets the value of the rebootRequired property.
     * 
     */
    public boolean isRebootRequired() {
        return rebootRequired;
    }

    /**
     * Sets the value of the rebootRequired property.
     * 
     */
    public void setRebootRequired(boolean value) {
        this.rebootRequired = value;
    }

    /**
     * Gets the value of the customValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomFieldValue }
     * 
     * 
     */
    public List<CustomFieldValue> getCustomValue() {
        if (customValue == null) {
            customValue = new ArrayList<CustomFieldValue>();
        }
        return this.customValue;
    }

    /**
     * Gets the value of the managementServerIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagementServerIp() {
        return managementServerIp;
    }

    /**
     * Sets the value of the managementServerIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagementServerIp(String value) {
        this.managementServerIp = value;
    }

    /**
     * Gets the value of the maxEVCModeKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxEVCModeKey() {
        return maxEVCModeKey;
    }

    /**
     * Sets the value of the maxEVCModeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxEVCModeKey(String value) {
        this.maxEVCModeKey = value;
    }

    /**
     * Gets the value of the currentEVCModeKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentEVCModeKey() {
        return currentEVCModeKey;
    }

    /**
     * Sets the value of the currentEVCModeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentEVCModeKey(String value) {
        this.currentEVCModeKey = value;
    }

}
