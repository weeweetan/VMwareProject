
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostCapability">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="recursiveResourcePoolsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cpuMemoryResourceConfigurationSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="rebootSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="shutdownSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vmotionSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="standbySupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ipmiSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="maxSupportedVMs" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxRunningVMs" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxSupportedVcpus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxRegisteredVMs" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="datastorePrincipalSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sanSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nfsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="iscsiSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vlanTaggingSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nicTeamingSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="highGuestMemSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="maintenanceModeSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="suspendedRelocateSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="restrictedSnapshotRelocateSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="perVmSwapFiles" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="localSwapDatastoreSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="unsharedSwapVMotionSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="backgroundSnapshotsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="preAssignedPCIUnitNumbersSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="screenshotSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="scaledScreenshotSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="storageVMotionSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vmotionWithStorageVMotionSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="hbrNicSelectionSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="recordReplaySupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ftSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="replayUnsupportedReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="replayCompatibilityIssues" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ftCompatibilityIssues" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="loginBySSLThumbprintSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cloneFromSnapshotSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="deltaDiskBackingsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="perVMNetworkTrafficShapingSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="tpmSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="supportedCpuFeature" type="{urn:vim25}HostCpuIdInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="virtualExecUsageSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="storageIORMSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vmDirectPathGen2Supported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vmDirectPathGen2UnsupportedReason" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vmDirectPathGen2UnsupportedReasonExtended" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supportedVmfsMajorVersion" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vStorageCapable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="snapshotRelayoutSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="firewallIpRulesSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="servicePackageInfoSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="maxHostRunningVms" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxHostSupportedVcpus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vmfsDatastoreMountCapable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="eightPlusHostVmfsSharedAccessSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nestedHVSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vPMCSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="interVMCommunicationThroughVMCISupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="scheduledHardwareUpgradeSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="featureCapabilitiesSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="latencySensitivitySupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="accel3dSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostCapability", propOrder = {
    "recursiveResourcePoolsSupported",
    "cpuMemoryResourceConfigurationSupported",
    "rebootSupported",
    "shutdownSupported",
    "vmotionSupported",
    "standbySupported",
    "ipmiSupported",
    "maxSupportedVMs",
    "maxRunningVMs",
    "maxSupportedVcpus",
    "maxRegisteredVMs",
    "datastorePrincipalSupported",
    "sanSupported",
    "nfsSupported",
    "iscsiSupported",
    "vlanTaggingSupported",
    "nicTeamingSupported",
    "highGuestMemSupported",
    "maintenanceModeSupported",
    "suspendedRelocateSupported",
    "restrictedSnapshotRelocateSupported",
    "perVmSwapFiles",
    "localSwapDatastoreSupported",
    "unsharedSwapVMotionSupported",
    "backgroundSnapshotsSupported",
    "preAssignedPCIUnitNumbersSupported",
    "screenshotSupported",
    "scaledScreenshotSupported",
    "storageVMotionSupported",
    "vmotionWithStorageVMotionSupported",
    "hbrNicSelectionSupported",
    "recordReplaySupported",
    "ftSupported",
    "replayUnsupportedReason",
    "replayCompatibilityIssues",
    "ftCompatibilityIssues",
    "loginBySSLThumbprintSupported",
    "cloneFromSnapshotSupported",
    "deltaDiskBackingsSupported",
    "perVMNetworkTrafficShapingSupported",
    "tpmSupported",
    "supportedCpuFeature",
    "virtualExecUsageSupported",
    "storageIORMSupported",
    "vmDirectPathGen2Supported",
    "vmDirectPathGen2UnsupportedReason",
    "vmDirectPathGen2UnsupportedReasonExtended",
    "supportedVmfsMajorVersion",
    "vStorageCapable",
    "snapshotRelayoutSupported",
    "firewallIpRulesSupported",
    "servicePackageInfoSupported",
    "maxHostRunningVms",
    "maxHostSupportedVcpus",
    "vmfsDatastoreMountCapable",
    "eightPlusHostVmfsSharedAccessSupported",
    "nestedHVSupported",
    "vpmcSupported",
    "interVMCommunicationThroughVMCISupported",
    "scheduledHardwareUpgradeSupported",
    "featureCapabilitiesSupported",
    "latencySensitivitySupported",
    "accel3DSupported"
})
public class HostCapability
    extends DynamicData
{

    protected boolean recursiveResourcePoolsSupported;
    protected boolean cpuMemoryResourceConfigurationSupported;
    protected boolean rebootSupported;
    protected boolean shutdownSupported;
    protected boolean vmotionSupported;
    protected boolean standbySupported;
    protected Boolean ipmiSupported;
    protected Integer maxSupportedVMs;
    protected Integer maxRunningVMs;
    protected Integer maxSupportedVcpus;
    protected Integer maxRegisteredVMs;
    protected boolean datastorePrincipalSupported;
    protected boolean sanSupported;
    protected boolean nfsSupported;
    protected boolean iscsiSupported;
    protected boolean vlanTaggingSupported;
    protected boolean nicTeamingSupported;
    protected boolean highGuestMemSupported;
    protected boolean maintenanceModeSupported;
    protected boolean suspendedRelocateSupported;
    protected boolean restrictedSnapshotRelocateSupported;
    protected boolean perVmSwapFiles;
    protected boolean localSwapDatastoreSupported;
    protected boolean unsharedSwapVMotionSupported;
    protected boolean backgroundSnapshotsSupported;
    protected boolean preAssignedPCIUnitNumbersSupported;
    protected boolean screenshotSupported;
    protected boolean scaledScreenshotSupported;
    protected Boolean storageVMotionSupported;
    protected Boolean vmotionWithStorageVMotionSupported;
    protected Boolean hbrNicSelectionSupported;
    protected Boolean recordReplaySupported;
    protected Boolean ftSupported;
    protected String replayUnsupportedReason;
    protected List<String> replayCompatibilityIssues;
    protected List<String> ftCompatibilityIssues;
    protected Boolean loginBySSLThumbprintSupported;
    protected Boolean cloneFromSnapshotSupported;
    protected Boolean deltaDiskBackingsSupported;
    protected Boolean perVMNetworkTrafficShapingSupported;
    protected Boolean tpmSupported;
    protected List<HostCpuIdInfo> supportedCpuFeature;
    protected Boolean virtualExecUsageSupported;
    protected Boolean storageIORMSupported;
    protected Boolean vmDirectPathGen2Supported;
    protected List<String> vmDirectPathGen2UnsupportedReason;
    protected String vmDirectPathGen2UnsupportedReasonExtended;
    @XmlElement(type = Integer.class)
    protected List<Integer> supportedVmfsMajorVersion;
    protected Boolean vStorageCapable;
    protected Boolean snapshotRelayoutSupported;
    protected Boolean firewallIpRulesSupported;
    protected Boolean servicePackageInfoSupported;
    protected Integer maxHostRunningVms;
    protected Integer maxHostSupportedVcpus;
    protected Boolean vmfsDatastoreMountCapable;
    protected Boolean eightPlusHostVmfsSharedAccessSupported;
    protected Boolean nestedHVSupported;
    @XmlElement(name = "vPMCSupported")
    protected Boolean vpmcSupported;
    protected Boolean interVMCommunicationThroughVMCISupported;
    protected Boolean scheduledHardwareUpgradeSupported;
    protected Boolean featureCapabilitiesSupported;
    protected Boolean latencySensitivitySupported;
    @XmlElement(name = "accel3dSupported")
    protected Boolean accel3DSupported;

    /**
     * Gets the value of the recursiveResourcePoolsSupported property.
     * 
     */
    public boolean isRecursiveResourcePoolsSupported() {
        return recursiveResourcePoolsSupported;
    }

    /**
     * Sets the value of the recursiveResourcePoolsSupported property.
     * 
     */
    public void setRecursiveResourcePoolsSupported(boolean value) {
        this.recursiveResourcePoolsSupported = value;
    }

    /**
     * Gets the value of the cpuMemoryResourceConfigurationSupported property.
     * 
     */
    public boolean isCpuMemoryResourceConfigurationSupported() {
        return cpuMemoryResourceConfigurationSupported;
    }

    /**
     * Sets the value of the cpuMemoryResourceConfigurationSupported property.
     * 
     */
    public void setCpuMemoryResourceConfigurationSupported(boolean value) {
        this.cpuMemoryResourceConfigurationSupported = value;
    }

    /**
     * Gets the value of the rebootSupported property.
     * 
     */
    public boolean isRebootSupported() {
        return rebootSupported;
    }

    /**
     * Sets the value of the rebootSupported property.
     * 
     */
    public void setRebootSupported(boolean value) {
        this.rebootSupported = value;
    }

    /**
     * Gets the value of the shutdownSupported property.
     * 
     */
    public boolean isShutdownSupported() {
        return shutdownSupported;
    }

    /**
     * Sets the value of the shutdownSupported property.
     * 
     */
    public void setShutdownSupported(boolean value) {
        this.shutdownSupported = value;
    }

    /**
     * Gets the value of the vmotionSupported property.
     * 
     */
    public boolean isVmotionSupported() {
        return vmotionSupported;
    }

    /**
     * Sets the value of the vmotionSupported property.
     * 
     */
    public void setVmotionSupported(boolean value) {
        this.vmotionSupported = value;
    }

    /**
     * Gets the value of the standbySupported property.
     * 
     */
    public boolean isStandbySupported() {
        return standbySupported;
    }

    /**
     * Sets the value of the standbySupported property.
     * 
     */
    public void setStandbySupported(boolean value) {
        this.standbySupported = value;
    }

    /**
     * Gets the value of the ipmiSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIpmiSupported() {
        return ipmiSupported;
    }

    /**
     * Sets the value of the ipmiSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIpmiSupported(Boolean value) {
        this.ipmiSupported = value;
    }

    /**
     * Gets the value of the maxSupportedVMs property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxSupportedVMs() {
        return maxSupportedVMs;
    }

    /**
     * Sets the value of the maxSupportedVMs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxSupportedVMs(Integer value) {
        this.maxSupportedVMs = value;
    }

    /**
     * Gets the value of the maxRunningVMs property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxRunningVMs() {
        return maxRunningVMs;
    }

    /**
     * Sets the value of the maxRunningVMs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRunningVMs(Integer value) {
        this.maxRunningVMs = value;
    }

    /**
     * Gets the value of the maxSupportedVcpus property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxSupportedVcpus() {
        return maxSupportedVcpus;
    }

    /**
     * Sets the value of the maxSupportedVcpus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxSupportedVcpus(Integer value) {
        this.maxSupportedVcpus = value;
    }

    /**
     * Gets the value of the maxRegisteredVMs property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxRegisteredVMs() {
        return maxRegisteredVMs;
    }

    /**
     * Sets the value of the maxRegisteredVMs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRegisteredVMs(Integer value) {
        this.maxRegisteredVMs = value;
    }

    /**
     * Gets the value of the datastorePrincipalSupported property.
     * 
     */
    public boolean isDatastorePrincipalSupported() {
        return datastorePrincipalSupported;
    }

    /**
     * Sets the value of the datastorePrincipalSupported property.
     * 
     */
    public void setDatastorePrincipalSupported(boolean value) {
        this.datastorePrincipalSupported = value;
    }

    /**
     * Gets the value of the sanSupported property.
     * 
     */
    public boolean isSanSupported() {
        return sanSupported;
    }

    /**
     * Sets the value of the sanSupported property.
     * 
     */
    public void setSanSupported(boolean value) {
        this.sanSupported = value;
    }

    /**
     * Gets the value of the nfsSupported property.
     * 
     */
    public boolean isNfsSupported() {
        return nfsSupported;
    }

    /**
     * Sets the value of the nfsSupported property.
     * 
     */
    public void setNfsSupported(boolean value) {
        this.nfsSupported = value;
    }

    /**
     * Gets the value of the iscsiSupported property.
     * 
     */
    public boolean isIscsiSupported() {
        return iscsiSupported;
    }

    /**
     * Sets the value of the iscsiSupported property.
     * 
     */
    public void setIscsiSupported(boolean value) {
        this.iscsiSupported = value;
    }

    /**
     * Gets the value of the vlanTaggingSupported property.
     * 
     */
    public boolean isVlanTaggingSupported() {
        return vlanTaggingSupported;
    }

    /**
     * Sets the value of the vlanTaggingSupported property.
     * 
     */
    public void setVlanTaggingSupported(boolean value) {
        this.vlanTaggingSupported = value;
    }

    /**
     * Gets the value of the nicTeamingSupported property.
     * 
     */
    public boolean isNicTeamingSupported() {
        return nicTeamingSupported;
    }

    /**
     * Sets the value of the nicTeamingSupported property.
     * 
     */
    public void setNicTeamingSupported(boolean value) {
        this.nicTeamingSupported = value;
    }

    /**
     * Gets the value of the highGuestMemSupported property.
     * 
     */
    public boolean isHighGuestMemSupported() {
        return highGuestMemSupported;
    }

    /**
     * Sets the value of the highGuestMemSupported property.
     * 
     */
    public void setHighGuestMemSupported(boolean value) {
        this.highGuestMemSupported = value;
    }

    /**
     * Gets the value of the maintenanceModeSupported property.
     * 
     */
    public boolean isMaintenanceModeSupported() {
        return maintenanceModeSupported;
    }

    /**
     * Sets the value of the maintenanceModeSupported property.
     * 
     */
    public void setMaintenanceModeSupported(boolean value) {
        this.maintenanceModeSupported = value;
    }

    /**
     * Gets the value of the suspendedRelocateSupported property.
     * 
     */
    public boolean isSuspendedRelocateSupported() {
        return suspendedRelocateSupported;
    }

    /**
     * Sets the value of the suspendedRelocateSupported property.
     * 
     */
    public void setSuspendedRelocateSupported(boolean value) {
        this.suspendedRelocateSupported = value;
    }

    /**
     * Gets the value of the restrictedSnapshotRelocateSupported property.
     * 
     */
    public boolean isRestrictedSnapshotRelocateSupported() {
        return restrictedSnapshotRelocateSupported;
    }

    /**
     * Sets the value of the restrictedSnapshotRelocateSupported property.
     * 
     */
    public void setRestrictedSnapshotRelocateSupported(boolean value) {
        this.restrictedSnapshotRelocateSupported = value;
    }

    /**
     * Gets the value of the perVmSwapFiles property.
     * 
     */
    public boolean isPerVmSwapFiles() {
        return perVmSwapFiles;
    }

    /**
     * Sets the value of the perVmSwapFiles property.
     * 
     */
    public void setPerVmSwapFiles(boolean value) {
        this.perVmSwapFiles = value;
    }

    /**
     * Gets the value of the localSwapDatastoreSupported property.
     * 
     */
    public boolean isLocalSwapDatastoreSupported() {
        return localSwapDatastoreSupported;
    }

    /**
     * Sets the value of the localSwapDatastoreSupported property.
     * 
     */
    public void setLocalSwapDatastoreSupported(boolean value) {
        this.localSwapDatastoreSupported = value;
    }

    /**
     * Gets the value of the unsharedSwapVMotionSupported property.
     * 
     */
    public boolean isUnsharedSwapVMotionSupported() {
        return unsharedSwapVMotionSupported;
    }

    /**
     * Sets the value of the unsharedSwapVMotionSupported property.
     * 
     */
    public void setUnsharedSwapVMotionSupported(boolean value) {
        this.unsharedSwapVMotionSupported = value;
    }

    /**
     * Gets the value of the backgroundSnapshotsSupported property.
     * 
     */
    public boolean isBackgroundSnapshotsSupported() {
        return backgroundSnapshotsSupported;
    }

    /**
     * Sets the value of the backgroundSnapshotsSupported property.
     * 
     */
    public void setBackgroundSnapshotsSupported(boolean value) {
        this.backgroundSnapshotsSupported = value;
    }

    /**
     * Gets the value of the preAssignedPCIUnitNumbersSupported property.
     * 
     */
    public boolean isPreAssignedPCIUnitNumbersSupported() {
        return preAssignedPCIUnitNumbersSupported;
    }

    /**
     * Sets the value of the preAssignedPCIUnitNumbersSupported property.
     * 
     */
    public void setPreAssignedPCIUnitNumbersSupported(boolean value) {
        this.preAssignedPCIUnitNumbersSupported = value;
    }

    /**
     * Gets the value of the screenshotSupported property.
     * 
     */
    public boolean isScreenshotSupported() {
        return screenshotSupported;
    }

    /**
     * Sets the value of the screenshotSupported property.
     * 
     */
    public void setScreenshotSupported(boolean value) {
        this.screenshotSupported = value;
    }

    /**
     * Gets the value of the scaledScreenshotSupported property.
     * 
     */
    public boolean isScaledScreenshotSupported() {
        return scaledScreenshotSupported;
    }

    /**
     * Sets the value of the scaledScreenshotSupported property.
     * 
     */
    public void setScaledScreenshotSupported(boolean value) {
        this.scaledScreenshotSupported = value;
    }

    /**
     * Gets the value of the storageVMotionSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStorageVMotionSupported() {
        return storageVMotionSupported;
    }

    /**
     * Sets the value of the storageVMotionSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStorageVMotionSupported(Boolean value) {
        this.storageVMotionSupported = value;
    }

    /**
     * Gets the value of the vmotionWithStorageVMotionSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVmotionWithStorageVMotionSupported() {
        return vmotionWithStorageVMotionSupported;
    }

    /**
     * Sets the value of the vmotionWithStorageVMotionSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVmotionWithStorageVMotionSupported(Boolean value) {
        this.vmotionWithStorageVMotionSupported = value;
    }

    /**
     * Gets the value of the hbrNicSelectionSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHbrNicSelectionSupported() {
        return hbrNicSelectionSupported;
    }

    /**
     * Sets the value of the hbrNicSelectionSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHbrNicSelectionSupported(Boolean value) {
        this.hbrNicSelectionSupported = value;
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
     * Gets the value of the ftSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFtSupported() {
        return ftSupported;
    }

    /**
     * Sets the value of the ftSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFtSupported(Boolean value) {
        this.ftSupported = value;
    }

    /**
     * Gets the value of the replayUnsupportedReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplayUnsupportedReason() {
        return replayUnsupportedReason;
    }

    /**
     * Sets the value of the replayUnsupportedReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplayUnsupportedReason(String value) {
        this.replayUnsupportedReason = value;
    }

    /**
     * Gets the value of the replayCompatibilityIssues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the replayCompatibilityIssues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReplayCompatibilityIssues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getReplayCompatibilityIssues() {
        if (replayCompatibilityIssues == null) {
            replayCompatibilityIssues = new ArrayList<String>();
        }
        return this.replayCompatibilityIssues;
    }

    /**
     * Gets the value of the ftCompatibilityIssues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ftCompatibilityIssues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFtCompatibilityIssues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFtCompatibilityIssues() {
        if (ftCompatibilityIssues == null) {
            ftCompatibilityIssues = new ArrayList<String>();
        }
        return this.ftCompatibilityIssues;
    }

    /**
     * Gets the value of the loginBySSLThumbprintSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLoginBySSLThumbprintSupported() {
        return loginBySSLThumbprintSupported;
    }

    /**
     * Sets the value of the loginBySSLThumbprintSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLoginBySSLThumbprintSupported(Boolean value) {
        this.loginBySSLThumbprintSupported = value;
    }

    /**
     * Gets the value of the cloneFromSnapshotSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCloneFromSnapshotSupported() {
        return cloneFromSnapshotSupported;
    }

    /**
     * Sets the value of the cloneFromSnapshotSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCloneFromSnapshotSupported(Boolean value) {
        this.cloneFromSnapshotSupported = value;
    }

    /**
     * Gets the value of the deltaDiskBackingsSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeltaDiskBackingsSupported() {
        return deltaDiskBackingsSupported;
    }

    /**
     * Sets the value of the deltaDiskBackingsSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeltaDiskBackingsSupported(Boolean value) {
        this.deltaDiskBackingsSupported = value;
    }

    /**
     * Gets the value of the perVMNetworkTrafficShapingSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPerVMNetworkTrafficShapingSupported() {
        return perVMNetworkTrafficShapingSupported;
    }

    /**
     * Sets the value of the perVMNetworkTrafficShapingSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPerVMNetworkTrafficShapingSupported(Boolean value) {
        this.perVMNetworkTrafficShapingSupported = value;
    }

    /**
     * Gets the value of the tpmSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTpmSupported() {
        return tpmSupported;
    }

    /**
     * Sets the value of the tpmSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTpmSupported(Boolean value) {
        this.tpmSupported = value;
    }

    /**
     * Gets the value of the supportedCpuFeature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedCpuFeature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedCpuFeature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostCpuIdInfo }
     * 
     * 
     */
    public List<HostCpuIdInfo> getSupportedCpuFeature() {
        if (supportedCpuFeature == null) {
            supportedCpuFeature = new ArrayList<HostCpuIdInfo>();
        }
        return this.supportedCpuFeature;
    }

    /**
     * Gets the value of the virtualExecUsageSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVirtualExecUsageSupported() {
        return virtualExecUsageSupported;
    }

    /**
     * Sets the value of the virtualExecUsageSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVirtualExecUsageSupported(Boolean value) {
        this.virtualExecUsageSupported = value;
    }

    /**
     * Gets the value of the storageIORMSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStorageIORMSupported() {
        return storageIORMSupported;
    }

    /**
     * Sets the value of the storageIORMSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStorageIORMSupported(Boolean value) {
        this.storageIORMSupported = value;
    }

    /**
     * Gets the value of the vmDirectPathGen2Supported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVmDirectPathGen2Supported() {
        return vmDirectPathGen2Supported;
    }

    /**
     * Sets the value of the vmDirectPathGen2Supported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVmDirectPathGen2Supported(Boolean value) {
        this.vmDirectPathGen2Supported = value;
    }

    /**
     * Gets the value of the vmDirectPathGen2UnsupportedReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmDirectPathGen2UnsupportedReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmDirectPathGen2UnsupportedReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVmDirectPathGen2UnsupportedReason() {
        if (vmDirectPathGen2UnsupportedReason == null) {
            vmDirectPathGen2UnsupportedReason = new ArrayList<String>();
        }
        return this.vmDirectPathGen2UnsupportedReason;
    }

    /**
     * Gets the value of the vmDirectPathGen2UnsupportedReasonExtended property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVmDirectPathGen2UnsupportedReasonExtended() {
        return vmDirectPathGen2UnsupportedReasonExtended;
    }

    /**
     * Sets the value of the vmDirectPathGen2UnsupportedReasonExtended property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVmDirectPathGen2UnsupportedReasonExtended(String value) {
        this.vmDirectPathGen2UnsupportedReasonExtended = value;
    }

    /**
     * Gets the value of the supportedVmfsMajorVersion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedVmfsMajorVersion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedVmfsMajorVersion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getSupportedVmfsMajorVersion() {
        if (supportedVmfsMajorVersion == null) {
            supportedVmfsMajorVersion = new ArrayList<Integer>();
        }
        return this.supportedVmfsMajorVersion;
    }

    /**
     * Gets the value of the vStorageCapable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVStorageCapable() {
        return vStorageCapable;
    }

    /**
     * Sets the value of the vStorageCapable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVStorageCapable(Boolean value) {
        this.vStorageCapable = value;
    }

    /**
     * Gets the value of the snapshotRelayoutSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSnapshotRelayoutSupported() {
        return snapshotRelayoutSupported;
    }

    /**
     * Sets the value of the snapshotRelayoutSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSnapshotRelayoutSupported(Boolean value) {
        this.snapshotRelayoutSupported = value;
    }

    /**
     * Gets the value of the firewallIpRulesSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFirewallIpRulesSupported() {
        return firewallIpRulesSupported;
    }

    /**
     * Sets the value of the firewallIpRulesSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFirewallIpRulesSupported(Boolean value) {
        this.firewallIpRulesSupported = value;
    }

    /**
     * Gets the value of the servicePackageInfoSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isServicePackageInfoSupported() {
        return servicePackageInfoSupported;
    }

    /**
     * Sets the value of the servicePackageInfoSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setServicePackageInfoSupported(Boolean value) {
        this.servicePackageInfoSupported = value;
    }

    /**
     * Gets the value of the maxHostRunningVms property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxHostRunningVms() {
        return maxHostRunningVms;
    }

    /**
     * Sets the value of the maxHostRunningVms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxHostRunningVms(Integer value) {
        this.maxHostRunningVms = value;
    }

    /**
     * Gets the value of the maxHostSupportedVcpus property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxHostSupportedVcpus() {
        return maxHostSupportedVcpus;
    }

    /**
     * Sets the value of the maxHostSupportedVcpus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxHostSupportedVcpus(Integer value) {
        this.maxHostSupportedVcpus = value;
    }

    /**
     * Gets the value of the vmfsDatastoreMountCapable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVmfsDatastoreMountCapable() {
        return vmfsDatastoreMountCapable;
    }

    /**
     * Sets the value of the vmfsDatastoreMountCapable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVmfsDatastoreMountCapable(Boolean value) {
        this.vmfsDatastoreMountCapable = value;
    }

    /**
     * Gets the value of the eightPlusHostVmfsSharedAccessSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEightPlusHostVmfsSharedAccessSupported() {
        return eightPlusHostVmfsSharedAccessSupported;
    }

    /**
     * Sets the value of the eightPlusHostVmfsSharedAccessSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEightPlusHostVmfsSharedAccessSupported(Boolean value) {
        this.eightPlusHostVmfsSharedAccessSupported = value;
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

    /**
     * Gets the value of the interVMCommunicationThroughVMCISupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInterVMCommunicationThroughVMCISupported() {
        return interVMCommunicationThroughVMCISupported;
    }

    /**
     * Sets the value of the interVMCommunicationThroughVMCISupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInterVMCommunicationThroughVMCISupported(Boolean value) {
        this.interVMCommunicationThroughVMCISupported = value;
    }

    /**
     * Gets the value of the scheduledHardwareUpgradeSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isScheduledHardwareUpgradeSupported() {
        return scheduledHardwareUpgradeSupported;
    }

    /**
     * Sets the value of the scheduledHardwareUpgradeSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setScheduledHardwareUpgradeSupported(Boolean value) {
        this.scheduledHardwareUpgradeSupported = value;
    }

    /**
     * Gets the value of the featureCapabilitiesSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFeatureCapabilitiesSupported() {
        return featureCapabilitiesSupported;
    }

    /**
     * Sets the value of the featureCapabilitiesSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFeatureCapabilitiesSupported(Boolean value) {
        this.featureCapabilitiesSupported = value;
    }

    /**
     * Gets the value of the latencySensitivitySupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLatencySensitivitySupported() {
        return latencySensitivitySupported;
    }

    /**
     * Sets the value of the latencySensitivitySupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLatencySensitivitySupported(Boolean value) {
        this.latencySensitivitySupported = value;
    }

    /**
     * Gets the value of the accel3DSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAccel3DSupported() {
        return accel3DSupported;
    }

    /**
     * Sets the value of the accel3DSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAccel3DSupported(Boolean value) {
        this.accel3DSupported = value;
    }

}
