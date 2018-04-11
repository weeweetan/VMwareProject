
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="changeVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="instanceUuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="npivNodeWorldWideName" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="npivPortWorldWideName" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="npivWorldWideNameType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="npivDesiredNodeWwns" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="npivDesiredPortWwns" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="npivTemporaryDisabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="npivOnNonRdmDisks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="npivWorldWideNameOp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="locationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alternateGuestName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annotation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="files" type="{urn:vim25}VirtualMachineFileInfo" minOccurs="0"/>
 *         &lt;element name="tools" type="{urn:vim25}ToolsConfigInfo" minOccurs="0"/>
 *         &lt;element name="flags" type="{urn:vim25}VirtualMachineFlagInfo" minOccurs="0"/>
 *         &lt;element name="consolePreferences" type="{urn:vim25}VirtualMachineConsolePreferences" minOccurs="0"/>
 *         &lt;element name="powerOpInfo" type="{urn:vim25}VirtualMachineDefaultPowerOpInfo" minOccurs="0"/>
 *         &lt;element name="numCPUs" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numCoresPerSocket" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="memoryMB" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="memoryHotAddEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cpuHotAddEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cpuHotRemoveEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="virtualICH7MPresent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="virtualSMCPresent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="deviceChange" type="{urn:vim25}VirtualDeviceConfigSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cpuAllocation" type="{urn:vim25}ResourceAllocationInfo" minOccurs="0"/>
 *         &lt;element name="memoryAllocation" type="{urn:vim25}ResourceAllocationInfo" minOccurs="0"/>
 *         &lt;element name="latencySensitivity" type="{urn:vim25}LatencySensitivity" minOccurs="0"/>
 *         &lt;element name="cpuAffinity" type="{urn:vim25}VirtualMachineAffinityInfo" minOccurs="0"/>
 *         &lt;element name="memoryAffinity" type="{urn:vim25}VirtualMachineAffinityInfo" minOccurs="0"/>
 *         &lt;element name="networkShaper" type="{urn:vim25}VirtualMachineNetworkShaperInfo" minOccurs="0"/>
 *         &lt;element name="cpuFeatureMask" type="{urn:vim25}VirtualMachineCpuIdInfoSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="extraConfig" type="{urn:vim25}OptionValue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="swapPlacement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bootOptions" type="{urn:vim25}VirtualMachineBootOptions" minOccurs="0"/>
 *         &lt;element name="vAppConfig" type="{urn:vim25}VmConfigSpec" minOccurs="0"/>
 *         &lt;element name="ftInfo" type="{urn:vim25}FaultToleranceConfigInfo" minOccurs="0"/>
 *         &lt;element name="vAppConfigRemoved" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vAssertsEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="changeTrackingEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="firmware" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxMksConnections" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="guestAutoLockEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="managedBy" type="{urn:vim25}ManagedByInfo" minOccurs="0"/>
 *         &lt;element name="memoryReservationLockedToMax" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nestedHVEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vPMCEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="scheduledHardwareUpgradeInfo" type="{urn:vim25}ScheduledHardwareUpgradeInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineConfigSpec", propOrder = {
    "changeVersion",
    "name",
    "version",
    "uuid",
    "instanceUuid",
    "npivNodeWorldWideName",
    "npivPortWorldWideName",
    "npivWorldWideNameType",
    "npivDesiredNodeWwns",
    "npivDesiredPortWwns",
    "npivTemporaryDisabled",
    "npivOnNonRdmDisks",
    "npivWorldWideNameOp",
    "locationId",
    "guestId",
    "alternateGuestName",
    "annotation",
    "files",
    "tools",
    "flags",
    "consolePreferences",
    "powerOpInfo",
    "numCPUs",
    "numCoresPerSocket",
    "memoryMB",
    "memoryHotAddEnabled",
    "cpuHotAddEnabled",
    "cpuHotRemoveEnabled",
    "virtualICH7MPresent",
    "virtualSMCPresent",
    "deviceChange",
    "cpuAllocation",
    "memoryAllocation",
    "latencySensitivity",
    "cpuAffinity",
    "memoryAffinity",
    "networkShaper",
    "cpuFeatureMask",
    "extraConfig",
    "swapPlacement",
    "bootOptions",
    "vAppConfig",
    "ftInfo",
    "vAppConfigRemoved",
    "vAssertsEnabled",
    "changeTrackingEnabled",
    "firmware",
    "maxMksConnections",
    "guestAutoLockEnabled",
    "managedBy",
    "memoryReservationLockedToMax",
    "nestedHVEnabled",
    "vpmcEnabled",
    "scheduledHardwareUpgradeInfo"
})
public class VirtualMachineConfigSpec
    extends DynamicData
{

    protected String changeVersion;
    protected String name;
    protected String version;
    protected String uuid;
    protected String instanceUuid;
    @XmlElement(type = Long.class)
    protected List<Long> npivNodeWorldWideName;
    @XmlElement(type = Long.class)
    protected List<Long> npivPortWorldWideName;
    protected String npivWorldWideNameType;
    protected Short npivDesiredNodeWwns;
    protected Short npivDesiredPortWwns;
    protected Boolean npivTemporaryDisabled;
    protected Boolean npivOnNonRdmDisks;
    protected String npivWorldWideNameOp;
    protected String locationId;
    protected String guestId;
    protected String alternateGuestName;
    protected String annotation;
    protected VirtualMachineFileInfo files;
    protected ToolsConfigInfo tools;
    protected VirtualMachineFlagInfo flags;
    protected VirtualMachineConsolePreferences consolePreferences;
    protected VirtualMachineDefaultPowerOpInfo powerOpInfo;
    protected Integer numCPUs;
    protected Integer numCoresPerSocket;
    protected Long memoryMB;
    protected Boolean memoryHotAddEnabled;
    protected Boolean cpuHotAddEnabled;
    protected Boolean cpuHotRemoveEnabled;
    protected Boolean virtualICH7MPresent;
    protected Boolean virtualSMCPresent;
    protected List<VirtualDeviceConfigSpec> deviceChange;
    protected ResourceAllocationInfo cpuAllocation;
    protected ResourceAllocationInfo memoryAllocation;
    protected LatencySensitivity latencySensitivity;
    protected VirtualMachineAffinityInfo cpuAffinity;
    protected VirtualMachineAffinityInfo memoryAffinity;
    protected VirtualMachineNetworkShaperInfo networkShaper;
    protected List<VirtualMachineCpuIdInfoSpec> cpuFeatureMask;
    protected List<OptionValue> extraConfig;
    protected String swapPlacement;
    protected VirtualMachineBootOptions bootOptions;
    protected VmConfigSpec vAppConfig;
    protected FaultToleranceConfigInfo ftInfo;
    protected Boolean vAppConfigRemoved;
    protected Boolean vAssertsEnabled;
    protected Boolean changeTrackingEnabled;
    protected String firmware;
    protected Integer maxMksConnections;
    protected Boolean guestAutoLockEnabled;
    protected ManagedByInfo managedBy;
    protected Boolean memoryReservationLockedToMax;
    protected Boolean nestedHVEnabled;
    @XmlElement(name = "vPMCEnabled")
    protected Boolean vpmcEnabled;
    protected ScheduledHardwareUpgradeInfo scheduledHardwareUpgradeInfo;

    /**
     * Gets the value of the changeVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeVersion() {
        return changeVersion;
    }

    /**
     * Sets the value of the changeVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeVersion(String value) {
        this.changeVersion = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the instanceUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceUuid() {
        return instanceUuid;
    }

    /**
     * Sets the value of the instanceUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceUuid(String value) {
        this.instanceUuid = value;
    }

    /**
     * Gets the value of the npivNodeWorldWideName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the npivNodeWorldWideName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNpivNodeWorldWideName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getNpivNodeWorldWideName() {
        if (npivNodeWorldWideName == null) {
            npivNodeWorldWideName = new ArrayList<Long>();
        }
        return this.npivNodeWorldWideName;
    }

    /**
     * Gets the value of the npivPortWorldWideName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the npivPortWorldWideName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNpivPortWorldWideName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getNpivPortWorldWideName() {
        if (npivPortWorldWideName == null) {
            npivPortWorldWideName = new ArrayList<Long>();
        }
        return this.npivPortWorldWideName;
    }

    /**
     * Gets the value of the npivWorldWideNameType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNpivWorldWideNameType() {
        return npivWorldWideNameType;
    }

    /**
     * Sets the value of the npivWorldWideNameType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNpivWorldWideNameType(String value) {
        this.npivWorldWideNameType = value;
    }

    /**
     * Gets the value of the npivDesiredNodeWwns property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNpivDesiredNodeWwns() {
        return npivDesiredNodeWwns;
    }

    /**
     * Sets the value of the npivDesiredNodeWwns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNpivDesiredNodeWwns(Short value) {
        this.npivDesiredNodeWwns = value;
    }

    /**
     * Gets the value of the npivDesiredPortWwns property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNpivDesiredPortWwns() {
        return npivDesiredPortWwns;
    }

    /**
     * Sets the value of the npivDesiredPortWwns property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNpivDesiredPortWwns(Short value) {
        this.npivDesiredPortWwns = value;
    }

    /**
     * Gets the value of the npivTemporaryDisabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNpivTemporaryDisabled() {
        return npivTemporaryDisabled;
    }

    /**
     * Sets the value of the npivTemporaryDisabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNpivTemporaryDisabled(Boolean value) {
        this.npivTemporaryDisabled = value;
    }

    /**
     * Gets the value of the npivOnNonRdmDisks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNpivOnNonRdmDisks() {
        return npivOnNonRdmDisks;
    }

    /**
     * Sets the value of the npivOnNonRdmDisks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNpivOnNonRdmDisks(Boolean value) {
        this.npivOnNonRdmDisks = value;
    }

    /**
     * Gets the value of the npivWorldWideNameOp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNpivWorldWideNameOp() {
        return npivWorldWideNameOp;
    }

    /**
     * Sets the value of the npivWorldWideNameOp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNpivWorldWideNameOp(String value) {
        this.npivWorldWideNameOp = value;
    }

    /**
     * Gets the value of the locationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * Sets the value of the locationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationId(String value) {
        this.locationId = value;
    }

    /**
     * Gets the value of the guestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestId() {
        return guestId;
    }

    /**
     * Sets the value of the guestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestId(String value) {
        this.guestId = value;
    }

    /**
     * Gets the value of the alternateGuestName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternateGuestName() {
        return alternateGuestName;
    }

    /**
     * Sets the value of the alternateGuestName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternateGuestName(String value) {
        this.alternateGuestName = value;
    }

    /**
     * Gets the value of the annotation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnotation(String value) {
        this.annotation = value;
    }

    /**
     * Gets the value of the files property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineFileInfo }
     *     
     */
    public VirtualMachineFileInfo getFiles() {
        return files;
    }

    /**
     * Sets the value of the files property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineFileInfo }
     *     
     */
    public void setFiles(VirtualMachineFileInfo value) {
        this.files = value;
    }

    /**
     * Gets the value of the tools property.
     * 
     * @return
     *     possible object is
     *     {@link ToolsConfigInfo }
     *     
     */
    public ToolsConfigInfo getTools() {
        return tools;
    }

    /**
     * Sets the value of the tools property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToolsConfigInfo }
     *     
     */
    public void setTools(ToolsConfigInfo value) {
        this.tools = value;
    }

    /**
     * Gets the value of the flags property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineFlagInfo }
     *     
     */
    public VirtualMachineFlagInfo getFlags() {
        return flags;
    }

    /**
     * Sets the value of the flags property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineFlagInfo }
     *     
     */
    public void setFlags(VirtualMachineFlagInfo value) {
        this.flags = value;
    }

    /**
     * Gets the value of the consolePreferences property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineConsolePreferences }
     *     
     */
    public VirtualMachineConsolePreferences getConsolePreferences() {
        return consolePreferences;
    }

    /**
     * Sets the value of the consolePreferences property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineConsolePreferences }
     *     
     */
    public void setConsolePreferences(VirtualMachineConsolePreferences value) {
        this.consolePreferences = value;
    }

    /**
     * Gets the value of the powerOpInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineDefaultPowerOpInfo }
     *     
     */
    public VirtualMachineDefaultPowerOpInfo getPowerOpInfo() {
        return powerOpInfo;
    }

    /**
     * Sets the value of the powerOpInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineDefaultPowerOpInfo }
     *     
     */
    public void setPowerOpInfo(VirtualMachineDefaultPowerOpInfo value) {
        this.powerOpInfo = value;
    }

    /**
     * Gets the value of the numCPUs property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumCPUs() {
        return numCPUs;
    }

    /**
     * Sets the value of the numCPUs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumCPUs(Integer value) {
        this.numCPUs = value;
    }

    /**
     * Gets the value of the numCoresPerSocket property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumCoresPerSocket() {
        return numCoresPerSocket;
    }

    /**
     * Sets the value of the numCoresPerSocket property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumCoresPerSocket(Integer value) {
        this.numCoresPerSocket = value;
    }

    /**
     * Gets the value of the memoryMB property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMemoryMB() {
        return memoryMB;
    }

    /**
     * Sets the value of the memoryMB property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMemoryMB(Long value) {
        this.memoryMB = value;
    }

    /**
     * Gets the value of the memoryHotAddEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMemoryHotAddEnabled() {
        return memoryHotAddEnabled;
    }

    /**
     * Sets the value of the memoryHotAddEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMemoryHotAddEnabled(Boolean value) {
        this.memoryHotAddEnabled = value;
    }

    /**
     * Gets the value of the cpuHotAddEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCpuHotAddEnabled() {
        return cpuHotAddEnabled;
    }

    /**
     * Sets the value of the cpuHotAddEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCpuHotAddEnabled(Boolean value) {
        this.cpuHotAddEnabled = value;
    }

    /**
     * Gets the value of the cpuHotRemoveEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCpuHotRemoveEnabled() {
        return cpuHotRemoveEnabled;
    }

    /**
     * Sets the value of the cpuHotRemoveEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCpuHotRemoveEnabled(Boolean value) {
        this.cpuHotRemoveEnabled = value;
    }

    /**
     * Gets the value of the virtualICH7MPresent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVirtualICH7MPresent() {
        return virtualICH7MPresent;
    }

    /**
     * Sets the value of the virtualICH7MPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVirtualICH7MPresent(Boolean value) {
        this.virtualICH7MPresent = value;
    }

    /**
     * Gets the value of the virtualSMCPresent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVirtualSMCPresent() {
        return virtualSMCPresent;
    }

    /**
     * Sets the value of the virtualSMCPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVirtualSMCPresent(Boolean value) {
        this.virtualSMCPresent = value;
    }

    /**
     * Gets the value of the deviceChange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deviceChange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeviceChange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualDeviceConfigSpec }
     * 
     * 
     */
    public List<VirtualDeviceConfigSpec> getDeviceChange() {
        if (deviceChange == null) {
            deviceChange = new ArrayList<VirtualDeviceConfigSpec>();
        }
        return this.deviceChange;
    }

    /**
     * Gets the value of the cpuAllocation property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAllocationInfo }
     *     
     */
    public ResourceAllocationInfo getCpuAllocation() {
        return cpuAllocation;
    }

    /**
     * Sets the value of the cpuAllocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAllocationInfo }
     *     
     */
    public void setCpuAllocation(ResourceAllocationInfo value) {
        this.cpuAllocation = value;
    }

    /**
     * Gets the value of the memoryAllocation property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAllocationInfo }
     *     
     */
    public ResourceAllocationInfo getMemoryAllocation() {
        return memoryAllocation;
    }

    /**
     * Sets the value of the memoryAllocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAllocationInfo }
     *     
     */
    public void setMemoryAllocation(ResourceAllocationInfo value) {
        this.memoryAllocation = value;
    }

    /**
     * Gets the value of the latencySensitivity property.
     * 
     * @return
     *     possible object is
     *     {@link LatencySensitivity }
     *     
     */
    public LatencySensitivity getLatencySensitivity() {
        return latencySensitivity;
    }

    /**
     * Sets the value of the latencySensitivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link LatencySensitivity }
     *     
     */
    public void setLatencySensitivity(LatencySensitivity value) {
        this.latencySensitivity = value;
    }

    /**
     * Gets the value of the cpuAffinity property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineAffinityInfo }
     *     
     */
    public VirtualMachineAffinityInfo getCpuAffinity() {
        return cpuAffinity;
    }

    /**
     * Sets the value of the cpuAffinity property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineAffinityInfo }
     *     
     */
    public void setCpuAffinity(VirtualMachineAffinityInfo value) {
        this.cpuAffinity = value;
    }

    /**
     * Gets the value of the memoryAffinity property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineAffinityInfo }
     *     
     */
    public VirtualMachineAffinityInfo getMemoryAffinity() {
        return memoryAffinity;
    }

    /**
     * Sets the value of the memoryAffinity property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineAffinityInfo }
     *     
     */
    public void setMemoryAffinity(VirtualMachineAffinityInfo value) {
        this.memoryAffinity = value;
    }

    /**
     * Gets the value of the networkShaper property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineNetworkShaperInfo }
     *     
     */
    public VirtualMachineNetworkShaperInfo getNetworkShaper() {
        return networkShaper;
    }

    /**
     * Sets the value of the networkShaper property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineNetworkShaperInfo }
     *     
     */
    public void setNetworkShaper(VirtualMachineNetworkShaperInfo value) {
        this.networkShaper = value;
    }

    /**
     * Gets the value of the cpuFeatureMask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cpuFeatureMask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCpuFeatureMask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineCpuIdInfoSpec }
     * 
     * 
     */
    public List<VirtualMachineCpuIdInfoSpec> getCpuFeatureMask() {
        if (cpuFeatureMask == null) {
            cpuFeatureMask = new ArrayList<VirtualMachineCpuIdInfoSpec>();
        }
        return this.cpuFeatureMask;
    }

    /**
     * Gets the value of the extraConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extraConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtraConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionValue }
     * 
     * 
     */
    public List<OptionValue> getExtraConfig() {
        if (extraConfig == null) {
            extraConfig = new ArrayList<OptionValue>();
        }
        return this.extraConfig;
    }

    /**
     * Gets the value of the swapPlacement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwapPlacement() {
        return swapPlacement;
    }

    /**
     * Sets the value of the swapPlacement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwapPlacement(String value) {
        this.swapPlacement = value;
    }

    /**
     * Gets the value of the bootOptions property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineBootOptions }
     *     
     */
    public VirtualMachineBootOptions getBootOptions() {
        return bootOptions;
    }

    /**
     * Sets the value of the bootOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineBootOptions }
     *     
     */
    public void setBootOptions(VirtualMachineBootOptions value) {
        this.bootOptions = value;
    }

    /**
     * Gets the value of the vAppConfig property.
     * 
     * @return
     *     possible object is
     *     {@link VmConfigSpec }
     *     
     */
    public VmConfigSpec getVAppConfig() {
        return vAppConfig;
    }

    /**
     * Sets the value of the vAppConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link VmConfigSpec }
     *     
     */
    public void setVAppConfig(VmConfigSpec value) {
        this.vAppConfig = value;
    }

    /**
     * Gets the value of the ftInfo property.
     * 
     * @return
     *     possible object is
     *     {@link FaultToleranceConfigInfo }
     *     
     */
    public FaultToleranceConfigInfo getFtInfo() {
        return ftInfo;
    }

    /**
     * Sets the value of the ftInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FaultToleranceConfigInfo }
     *     
     */
    public void setFtInfo(FaultToleranceConfigInfo value) {
        this.ftInfo = value;
    }

    /**
     * Gets the value of the vAppConfigRemoved property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVAppConfigRemoved() {
        return vAppConfigRemoved;
    }

    /**
     * Sets the value of the vAppConfigRemoved property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVAppConfigRemoved(Boolean value) {
        this.vAppConfigRemoved = value;
    }

    /**
     * Gets the value of the vAssertsEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVAssertsEnabled() {
        return vAssertsEnabled;
    }

    /**
     * Sets the value of the vAssertsEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVAssertsEnabled(Boolean value) {
        this.vAssertsEnabled = value;
    }

    /**
     * Gets the value of the changeTrackingEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChangeTrackingEnabled() {
        return changeTrackingEnabled;
    }

    /**
     * Sets the value of the changeTrackingEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChangeTrackingEnabled(Boolean value) {
        this.changeTrackingEnabled = value;
    }

    /**
     * Gets the value of the firmware property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmware() {
        return firmware;
    }

    /**
     * Sets the value of the firmware property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmware(String value) {
        this.firmware = value;
    }

    /**
     * Gets the value of the maxMksConnections property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxMksConnections() {
        return maxMksConnections;
    }

    /**
     * Sets the value of the maxMksConnections property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxMksConnections(Integer value) {
        this.maxMksConnections = value;
    }

    /**
     * Gets the value of the guestAutoLockEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGuestAutoLockEnabled() {
        return guestAutoLockEnabled;
    }

    /**
     * Sets the value of the guestAutoLockEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGuestAutoLockEnabled(Boolean value) {
        this.guestAutoLockEnabled = value;
    }

    /**
     * Gets the value of the managedBy property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedByInfo }
     *     
     */
    public ManagedByInfo getManagedBy() {
        return managedBy;
    }

    /**
     * Sets the value of the managedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedByInfo }
     *     
     */
    public void setManagedBy(ManagedByInfo value) {
        this.managedBy = value;
    }

    /**
     * Gets the value of the memoryReservationLockedToMax property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMemoryReservationLockedToMax() {
        return memoryReservationLockedToMax;
    }

    /**
     * Sets the value of the memoryReservationLockedToMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMemoryReservationLockedToMax(Boolean value) {
        this.memoryReservationLockedToMax = value;
    }

    /**
     * Gets the value of the nestedHVEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNestedHVEnabled() {
        return nestedHVEnabled;
    }

    /**
     * Sets the value of the nestedHVEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNestedHVEnabled(Boolean value) {
        this.nestedHVEnabled = value;
    }

    /**
     * Gets the value of the vpmcEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVPMCEnabled() {
        return vpmcEnabled;
    }

    /**
     * Sets the value of the vpmcEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVPMCEnabled(Boolean value) {
        this.vpmcEnabled = value;
    }

    /**
     * Gets the value of the scheduledHardwareUpgradeInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledHardwareUpgradeInfo }
     *     
     */
    public ScheduledHardwareUpgradeInfo getScheduledHardwareUpgradeInfo() {
        return scheduledHardwareUpgradeInfo;
    }

    /**
     * Sets the value of the scheduledHardwareUpgradeInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledHardwareUpgradeInfo }
     *     
     */
    public void setScheduledHardwareUpgradeInfo(ScheduledHardwareUpgradeInfo value) {
        this.scheduledHardwareUpgradeInfo = value;
    }

}
