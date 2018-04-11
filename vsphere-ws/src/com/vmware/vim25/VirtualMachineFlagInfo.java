
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineFlagInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineFlagInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="disableAcceleration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="enableLogging" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="useToe" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="runWithDebugInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="monitorType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="htSharing" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="snapshotDisabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="snapshotLocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="diskUuidEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="virtualMmuUsage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="virtualExecUsage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="snapshotPowerOffBehavior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recordReplayEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineFlagInfo", propOrder = {
    "disableAcceleration",
    "enableLogging",
    "useToe",
    "runWithDebugInfo",
    "monitorType",
    "htSharing",
    "snapshotDisabled",
    "snapshotLocked",
    "diskUuidEnabled",
    "virtualMmuUsage",
    "virtualExecUsage",
    "snapshotPowerOffBehavior",
    "recordReplayEnabled"
})
public class VirtualMachineFlagInfo
    extends DynamicData
{

    protected Boolean disableAcceleration;
    protected Boolean enableLogging;
    protected Boolean useToe;
    protected Boolean runWithDebugInfo;
    protected String monitorType;
    protected String htSharing;
    protected Boolean snapshotDisabled;
    protected Boolean snapshotLocked;
    protected Boolean diskUuidEnabled;
    protected String virtualMmuUsage;
    protected String virtualExecUsage;
    protected String snapshotPowerOffBehavior;
    protected Boolean recordReplayEnabled;

    /**
     * Gets the value of the disableAcceleration property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisableAcceleration() {
        return disableAcceleration;
    }

    /**
     * Sets the value of the disableAcceleration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisableAcceleration(Boolean value) {
        this.disableAcceleration = value;
    }

    /**
     * Gets the value of the enableLogging property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnableLogging() {
        return enableLogging;
    }

    /**
     * Sets the value of the enableLogging property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnableLogging(Boolean value) {
        this.enableLogging = value;
    }

    /**
     * Gets the value of the useToe property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseToe() {
        return useToe;
    }

    /**
     * Sets the value of the useToe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseToe(Boolean value) {
        this.useToe = value;
    }

    /**
     * Gets the value of the runWithDebugInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRunWithDebugInfo() {
        return runWithDebugInfo;
    }

    /**
     * Sets the value of the runWithDebugInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRunWithDebugInfo(Boolean value) {
        this.runWithDebugInfo = value;
    }

    /**
     * Gets the value of the monitorType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonitorType() {
        return monitorType;
    }

    /**
     * Sets the value of the monitorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonitorType(String value) {
        this.monitorType = value;
    }

    /**
     * Gets the value of the htSharing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHtSharing() {
        return htSharing;
    }

    /**
     * Sets the value of the htSharing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHtSharing(String value) {
        this.htSharing = value;
    }

    /**
     * Gets the value of the snapshotDisabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSnapshotDisabled() {
        return snapshotDisabled;
    }

    /**
     * Sets the value of the snapshotDisabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSnapshotDisabled(Boolean value) {
        this.snapshotDisabled = value;
    }

    /**
     * Gets the value of the snapshotLocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSnapshotLocked() {
        return snapshotLocked;
    }

    /**
     * Sets the value of the snapshotLocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSnapshotLocked(Boolean value) {
        this.snapshotLocked = value;
    }

    /**
     * Gets the value of the diskUuidEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDiskUuidEnabled() {
        return diskUuidEnabled;
    }

    /**
     * Sets the value of the diskUuidEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDiskUuidEnabled(Boolean value) {
        this.diskUuidEnabled = value;
    }

    /**
     * Gets the value of the virtualMmuUsage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVirtualMmuUsage() {
        return virtualMmuUsage;
    }

    /**
     * Sets the value of the virtualMmuUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVirtualMmuUsage(String value) {
        this.virtualMmuUsage = value;
    }

    /**
     * Gets the value of the virtualExecUsage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVirtualExecUsage() {
        return virtualExecUsage;
    }

    /**
     * Sets the value of the virtualExecUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVirtualExecUsage(String value) {
        this.virtualExecUsage = value;
    }

    /**
     * Gets the value of the snapshotPowerOffBehavior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSnapshotPowerOffBehavior() {
        return snapshotPowerOffBehavior;
    }

    /**
     * Sets the value of the snapshotPowerOffBehavior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSnapshotPowerOffBehavior(String value) {
        this.snapshotPowerOffBehavior = value;
    }

    /**
     * Gets the value of the recordReplayEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecordReplayEnabled() {
        return recordReplayEnabled;
    }

    /**
     * Sets the value of the recordReplayEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecordReplayEnabled(Boolean value) {
        this.recordReplayEnabled = value;
    }

}
