
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineCapability">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="snapshotOperationsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="multipleSnapshotsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="snapshotConfigSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="poweredOffSnapshotsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="memorySnapshotsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="revertToSnapshotSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="quiescedSnapshotsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="disableSnapshotsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lockSnapshotsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="consolePreferencesSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cpuFeatureMaskSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="s1AcpiManagementSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="settingScreenResolutionSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="toolsAutoUpdateSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vmNpivWwnSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="npivWwnOnNonRdmVmSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vmNpivWwnDisableSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vmNpivWwnUpdateSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="swapPlacementSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="toolsSyncTimeSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="virtualMmuUsageSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="diskSharesSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bootOptionsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bootRetryOptionsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="settingVideoRamSizeSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="settingDisplayTopologySupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="recordReplaySupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="changeTrackingSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="multipleCoresPerSocketSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="hostBasedReplicationSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="guestAutoLockSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="memoryReservationLockSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="featureRequirementSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="poweredOnMonitorTypeChangeSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="seSparseDiskSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nestedHVSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vPMCSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineCapability", propOrder = {
    "snapshotOperationsSupported",
    "multipleSnapshotsSupported",
    "snapshotConfigSupported",
    "poweredOffSnapshotsSupported",
    "memorySnapshotsSupported",
    "revertToSnapshotSupported",
    "quiescedSnapshotsSupported",
    "disableSnapshotsSupported",
    "lockSnapshotsSupported",
    "consolePreferencesSupported",
    "cpuFeatureMaskSupported",
    "s1AcpiManagementSupported",
    "settingScreenResolutionSupported",
    "toolsAutoUpdateSupported",
    "vmNpivWwnSupported",
    "npivWwnOnNonRdmVmSupported",
    "vmNpivWwnDisableSupported",
    "vmNpivWwnUpdateSupported",
    "swapPlacementSupported",
    "toolsSyncTimeSupported",
    "virtualMmuUsageSupported",
    "diskSharesSupported",
    "bootOptionsSupported",
    "bootRetryOptionsSupported",
    "settingVideoRamSizeSupported",
    "settingDisplayTopologySupported",
    "recordReplaySupported",
    "changeTrackingSupported",
    "multipleCoresPerSocketSupported",
    "hostBasedReplicationSupported",
    "guestAutoLockSupported",
    "memoryReservationLockSupported",
    "featureRequirementSupported",
    "poweredOnMonitorTypeChangeSupported",
    "seSparseDiskSupported",
    "nestedHVSupported",
    "vpmcSupported"
})
public class VirtualMachineCapability
    extends DynamicData
{

    protected boolean snapshotOperationsSupported;
    protected boolean multipleSnapshotsSupported;
    protected boolean snapshotConfigSupported;
    protected boolean poweredOffSnapshotsSupported;
    protected boolean memorySnapshotsSupported;
    protected boolean revertToSnapshotSupported;
    protected boolean quiescedSnapshotsSupported;
    protected boolean disableSnapshotsSupported;
    protected boolean lockSnapshotsSupported;
    protected boolean consolePreferencesSupported;
    protected boolean cpuFeatureMaskSupported;
    protected boolean s1AcpiManagementSupported;
    protected boolean settingScreenResolutionSupported;
    protected boolean toolsAutoUpdateSupported;
    protected boolean vmNpivWwnSupported;
    protected boolean npivWwnOnNonRdmVmSupported;
    protected Boolean vmNpivWwnDisableSupported;
    protected Boolean vmNpivWwnUpdateSupported;
    protected boolean swapPlacementSupported;
    protected boolean toolsSyncTimeSupported;
    protected boolean virtualMmuUsageSupported;
    protected boolean diskSharesSupported;
    protected boolean bootOptionsSupported;
    protected Boolean bootRetryOptionsSupported;
    protected boolean settingVideoRamSizeSupported;
    protected Boolean settingDisplayTopologySupported;
    protected Boolean recordReplaySupported;
    protected Boolean changeTrackingSupported;
    protected Boolean multipleCoresPerSocketSupported;
    protected Boolean hostBasedReplicationSupported;
    protected Boolean guestAutoLockSupported;
    protected Boolean memoryReservationLockSupported;
    protected Boolean featureRequirementSupported;
    protected Boolean poweredOnMonitorTypeChangeSupported;
    protected Boolean seSparseDiskSupported;
    protected Boolean nestedHVSupported;
    @XmlElement(name = "vPMCSupported")
    protected Boolean vpmcSupported;

    /**
     * Gets the value of the snapshotOperationsSupported property.
     * 
     */
    public boolean isSnapshotOperationsSupported() {
        return snapshotOperationsSupported;
    }

    /**
     * Sets the value of the snapshotOperationsSupported property.
     * 
     */
    public void setSnapshotOperationsSupported(boolean value) {
        this.snapshotOperationsSupported = value;
    }

    /**
     * Gets the value of the multipleSnapshotsSupported property.
     * 
     */
    public boolean isMultipleSnapshotsSupported() {
        return multipleSnapshotsSupported;
    }

    /**
     * Sets the value of the multipleSnapshotsSupported property.
     * 
     */
    public void setMultipleSnapshotsSupported(boolean value) {
        this.multipleSnapshotsSupported = value;
    }

    /**
     * Gets the value of the snapshotConfigSupported property.
     * 
     */
    public boolean isSnapshotConfigSupported() {
        return snapshotConfigSupported;
    }

    /**
     * Sets the value of the snapshotConfigSupported property.
     * 
     */
    public void setSnapshotConfigSupported(boolean value) {
        this.snapshotConfigSupported = value;
    }

    /**
     * Gets the value of the poweredOffSnapshotsSupported property.
     * 
     */
    public boolean isPoweredOffSnapshotsSupported() {
        return poweredOffSnapshotsSupported;
    }

    /**
     * Sets the value of the poweredOffSnapshotsSupported property.
     * 
     */
    public void setPoweredOffSnapshotsSupported(boolean value) {
        this.poweredOffSnapshotsSupported = value;
    }

    /**
     * Gets the value of the memorySnapshotsSupported property.
     * 
     */
    public boolean isMemorySnapshotsSupported() {
        return memorySnapshotsSupported;
    }

    /**
     * Sets the value of the memorySnapshotsSupported property.
     * 
     */
    public void setMemorySnapshotsSupported(boolean value) {
        this.memorySnapshotsSupported = value;
    }

    /**
     * Gets the value of the revertToSnapshotSupported property.
     * 
     */
    public boolean isRevertToSnapshotSupported() {
        return revertToSnapshotSupported;
    }

    /**
     * Sets the value of the revertToSnapshotSupported property.
     * 
     */
    public void setRevertToSnapshotSupported(boolean value) {
        this.revertToSnapshotSupported = value;
    }

    /**
     * Gets the value of the quiescedSnapshotsSupported property.
     * 
     */
    public boolean isQuiescedSnapshotsSupported() {
        return quiescedSnapshotsSupported;
    }

    /**
     * Sets the value of the quiescedSnapshotsSupported property.
     * 
     */
    public void setQuiescedSnapshotsSupported(boolean value) {
        this.quiescedSnapshotsSupported = value;
    }

    /**
     * Gets the value of the disableSnapshotsSupported property.
     * 
     */
    public boolean isDisableSnapshotsSupported() {
        return disableSnapshotsSupported;
    }

    /**
     * Sets the value of the disableSnapshotsSupported property.
     * 
     */
    public void setDisableSnapshotsSupported(boolean value) {
        this.disableSnapshotsSupported = value;
    }

    /**
     * Gets the value of the lockSnapshotsSupported property.
     * 
     */
    public boolean isLockSnapshotsSupported() {
        return lockSnapshotsSupported;
    }

    /**
     * Sets the value of the lockSnapshotsSupported property.
     * 
     */
    public void setLockSnapshotsSupported(boolean value) {
        this.lockSnapshotsSupported = value;
    }

    /**
     * Gets the value of the consolePreferencesSupported property.
     * 
     */
    public boolean isConsolePreferencesSupported() {
        return consolePreferencesSupported;
    }

    /**
     * Sets the value of the consolePreferencesSupported property.
     * 
     */
    public void setConsolePreferencesSupported(boolean value) {
        this.consolePreferencesSupported = value;
    }

    /**
     * Gets the value of the cpuFeatureMaskSupported property.
     * 
     */
    public boolean isCpuFeatureMaskSupported() {
        return cpuFeatureMaskSupported;
    }

    /**
     * Sets the value of the cpuFeatureMaskSupported property.
     * 
     */
    public void setCpuFeatureMaskSupported(boolean value) {
        this.cpuFeatureMaskSupported = value;
    }

    /**
     * Gets the value of the s1AcpiManagementSupported property.
     * 
     */
    public boolean isS1AcpiManagementSupported() {
        return s1AcpiManagementSupported;
    }

    /**
     * Sets the value of the s1AcpiManagementSupported property.
     * 
     */
    public void setS1AcpiManagementSupported(boolean value) {
        this.s1AcpiManagementSupported = value;
    }

    /**
     * Gets the value of the settingScreenResolutionSupported property.
     * 
     */
    public boolean isSettingScreenResolutionSupported() {
        return settingScreenResolutionSupported;
    }

    /**
     * Sets the value of the settingScreenResolutionSupported property.
     * 
     */
    public void setSettingScreenResolutionSupported(boolean value) {
        this.settingScreenResolutionSupported = value;
    }

    /**
     * Gets the value of the toolsAutoUpdateSupported property.
     * 
     */
    public boolean isToolsAutoUpdateSupported() {
        return toolsAutoUpdateSupported;
    }

    /**
     * Sets the value of the toolsAutoUpdateSupported property.
     * 
     */
    public void setToolsAutoUpdateSupported(boolean value) {
        this.toolsAutoUpdateSupported = value;
    }

    /**
     * Gets the value of the vmNpivWwnSupported property.
     * 
     */
    public boolean isVmNpivWwnSupported() {
        return vmNpivWwnSupported;
    }

    /**
     * Sets the value of the vmNpivWwnSupported property.
     * 
     */
    public void setVmNpivWwnSupported(boolean value) {
        this.vmNpivWwnSupported = value;
    }

    /**
     * Gets the value of the npivWwnOnNonRdmVmSupported property.
     * 
     */
    public boolean isNpivWwnOnNonRdmVmSupported() {
        return npivWwnOnNonRdmVmSupported;
    }

    /**
     * Sets the value of the npivWwnOnNonRdmVmSupported property.
     * 
     */
    public void setNpivWwnOnNonRdmVmSupported(boolean value) {
        this.npivWwnOnNonRdmVmSupported = value;
    }

    /**
     * Gets the value of the vmNpivWwnDisableSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVmNpivWwnDisableSupported() {
        return vmNpivWwnDisableSupported;
    }

    /**
     * Sets the value of the vmNpivWwnDisableSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVmNpivWwnDisableSupported(Boolean value) {
        this.vmNpivWwnDisableSupported = value;
    }

    /**
     * Gets the value of the vmNpivWwnUpdateSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVmNpivWwnUpdateSupported() {
        return vmNpivWwnUpdateSupported;
    }

    /**
     * Sets the value of the vmNpivWwnUpdateSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVmNpivWwnUpdateSupported(Boolean value) {
        this.vmNpivWwnUpdateSupported = value;
    }

    /**
     * Gets the value of the swapPlacementSupported property.
     * 
     */
    public boolean isSwapPlacementSupported() {
        return swapPlacementSupported;
    }

    /**
     * Sets the value of the swapPlacementSupported property.
     * 
     */
    public void setSwapPlacementSupported(boolean value) {
        this.swapPlacementSupported = value;
    }

    /**
     * Gets the value of the toolsSyncTimeSupported property.
     * 
     */
    public boolean isToolsSyncTimeSupported() {
        return toolsSyncTimeSupported;
    }

    /**
     * Sets the value of the toolsSyncTimeSupported property.
     * 
     */
    public void setToolsSyncTimeSupported(boolean value) {
        this.toolsSyncTimeSupported = value;
    }

    /**
     * Gets the value of the virtualMmuUsageSupported property.
     * 
     */
    public boolean isVirtualMmuUsageSupported() {
        return virtualMmuUsageSupported;
    }

    /**
     * Sets the value of the virtualMmuUsageSupported property.
     * 
     */
    public void setVirtualMmuUsageSupported(boolean value) {
        this.virtualMmuUsageSupported = value;
    }

    /**
     * Gets the value of the diskSharesSupported property.
     * 
     */
    public boolean isDiskSharesSupported() {
        return diskSharesSupported;
    }

    /**
     * Sets the value of the diskSharesSupported property.
     * 
     */
    public void setDiskSharesSupported(boolean value) {
        this.diskSharesSupported = value;
    }

    /**
     * Gets the value of the bootOptionsSupported property.
     * 
     */
    public boolean isBootOptionsSupported() {
        return bootOptionsSupported;
    }

    /**
     * Sets the value of the bootOptionsSupported property.
     * 
     */
    public void setBootOptionsSupported(boolean value) {
        this.bootOptionsSupported = value;
    }

    /**
     * Gets the value of the bootRetryOptionsSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBootRetryOptionsSupported() {
        return bootRetryOptionsSupported;
    }

    /**
     * Sets the value of the bootRetryOptionsSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBootRetryOptionsSupported(Boolean value) {
        this.bootRetryOptionsSupported = value;
    }

    /**
     * Gets the value of the settingVideoRamSizeSupported property.
     * 
     */
    public boolean isSettingVideoRamSizeSupported() {
        return settingVideoRamSizeSupported;
    }

    /**
     * Sets the value of the settingVideoRamSizeSupported property.
     * 
     */
    public void setSettingVideoRamSizeSupported(boolean value) {
        this.settingVideoRamSizeSupported = value;
    }

    /**
     * Gets the value of the settingDisplayTopologySupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSettingDisplayTopologySupported() {
        return settingDisplayTopologySupported;
    }

    /**
     * Sets the value of the settingDisplayTopologySupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSettingDisplayTopologySupported(Boolean value) {
        this.settingDisplayTopologySupported = value;
    }

    /**
     * Gets the value of the recordReplaySupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecordReplaySupported() {
        return recordReplaySupported;
    }

    /**
     * Sets the value of the recordReplaySupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecordReplaySupported(Boolean value) {
        this.recordReplaySupported = value;
    }

    /**
     * Gets the value of the changeTrackingSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChangeTrackingSupported() {
        return changeTrackingSupported;
    }

    /**
     * Sets the value of the changeTrackingSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChangeTrackingSupported(Boolean value) {
        this.changeTrackingSupported = value;
    }

    /**
     * Gets the value of the multipleCoresPerSocketSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMultipleCoresPerSocketSupported() {
        return multipleCoresPerSocketSupported;
    }

    /**
     * Sets the value of the multipleCoresPerSocketSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMultipleCoresPerSocketSupported(Boolean value) {
        this.multipleCoresPerSocketSupported = value;
    }

    /**
     * Gets the value of the hostBasedReplicationSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHostBasedReplicationSupported() {
        return hostBasedReplicationSupported;
    }

    /**
     * Sets the value of the hostBasedReplicationSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHostBasedReplicationSupported(Boolean value) {
        this.hostBasedReplicationSupported = value;
    }

    /**
     * Gets the value of the guestAutoLockSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGuestAutoLockSupported() {
        return guestAutoLockSupported;
    }

    /**
     * Sets the value of the guestAutoLockSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGuestAutoLockSupported(Boolean value) {
        this.guestAutoLockSupported = value;
    }

    /**
     * Gets the value of the memoryReservationLockSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMemoryReservationLockSupported() {
        return memoryReservationLockSupported;
    }

    /**
     * Sets the value of the memoryReservationLockSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMemoryReservationLockSupported(Boolean value) {
        this.memoryReservationLockSupported = value;
    }

    /**
     * Gets the value of the featureRequirementSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFeatureRequirementSupported() {
        return featureRequirementSupported;
    }

    /**
     * Sets the value of the featureRequirementSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFeatureRequirementSupported(Boolean value) {
        this.featureRequirementSupported = value;
    }

    /**
     * Gets the value of the poweredOnMonitorTypeChangeSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPoweredOnMonitorTypeChangeSupported() {
        return poweredOnMonitorTypeChangeSupported;
    }

    /**
     * Sets the value of the poweredOnMonitorTypeChangeSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPoweredOnMonitorTypeChangeSupported(Boolean value) {
        this.poweredOnMonitorTypeChangeSupported = value;
    }

    /**
     * Gets the value of the seSparseDiskSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSeSparseDiskSupported() {
        return seSparseDiskSupported;
    }

    /**
     * Sets the value of the seSparseDiskSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSeSparseDiskSupported(Boolean value) {
        this.seSparseDiskSupported = value;
    }

    /**
     * Gets the value of the nestedHVSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNestedHVSupported() {
        return nestedHVSupported;
    }

    /**
     * Sets the value of the nestedHVSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNestedHVSupported(Boolean value) {
        this.nestedHVSupported = value;
    }

    /**
     * Gets the value of the vpmcSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVPMCSupported() {
        return vpmcSupported;
    }

    /**
     * Sets the value of the vpmcSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVPMCSupported(Boolean value) {
        this.vpmcSupported = value;
    }

}
