
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for VirtualMachineRuntimeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineRuntimeInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="device" type="{urn:vim25}VirtualMachineDeviceRuntimeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="host" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="connectionState" type="{urn:vim25}VirtualMachineConnectionState"/>
 *         &lt;element name="powerState" type="{urn:vim25}VirtualMachinePowerState"/>
 *         &lt;element name="faultToleranceState" type="{urn:vim25}VirtualMachineFaultToleranceState" minOccurs="0"/>
 *         &lt;element name="dasVmProtection" type="{urn:vim25}VirtualMachineRuntimeInfoDasProtectionState" minOccurs="0"/>
 *         &lt;element name="toolsInstallerMounted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="suspendTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="bootTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="suspendInterval" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="question" type="{urn:vim25}VirtualMachineQuestionInfo" minOccurs="0"/>
 *         &lt;element name="memoryOverhead" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="maxCpuUsage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxMemoryUsage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numMksConnections" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recordReplayState" type="{urn:vim25}VirtualMachineRecordReplayState" minOccurs="0"/>
 *         &lt;element name="cleanPowerOff" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="needSecondaryReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="onlineStandby" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="minRequiredEVCModeKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consolidationNeeded" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="offlineFeatureRequirement" type="{urn:vim25}VirtualMachineFeatureRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="featureRequirement" type="{urn:vim25}VirtualMachineFeatureRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="featureMask" type="{urn:vim25}HostFeatureMask" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineRuntimeInfo", propOrder = {
    "device",
    "host",
    "connectionState",
    "powerState",
    "faultToleranceState",
    "dasVmProtection",
    "toolsInstallerMounted",
    "suspendTime",
    "bootTime",
    "suspendInterval",
    "question",
    "memoryOverhead",
    "maxCpuUsage",
    "maxMemoryUsage",
    "numMksConnections",
    "recordReplayState",
    "cleanPowerOff",
    "needSecondaryReason",
    "onlineStandby",
    "minRequiredEVCModeKey",
    "consolidationNeeded",
    "offlineFeatureRequirement",
    "featureRequirement",
    "featureMask"
})
public class VirtualMachineRuntimeInfo
    extends DynamicData
{

    protected List<VirtualMachineDeviceRuntimeInfo> device;
    protected ManagedObjectReference host;
    @XmlElement(required = true)
    protected VirtualMachineConnectionState connectionState;
    @XmlElement(required = true)
    protected VirtualMachinePowerState powerState;
    protected VirtualMachineFaultToleranceState faultToleranceState;
    protected VirtualMachineRuntimeInfoDasProtectionState dasVmProtection;
    protected boolean toolsInstallerMounted;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar suspendTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar bootTime;
    protected Long suspendInterval;
    protected VirtualMachineQuestionInfo question;
    protected Long memoryOverhead;
    protected Integer maxCpuUsage;
    protected Integer maxMemoryUsage;
    protected int numMksConnections;
    protected VirtualMachineRecordReplayState recordReplayState;
    protected Boolean cleanPowerOff;
    protected String needSecondaryReason;
    protected Boolean onlineStandby;
    protected String minRequiredEVCModeKey;
    protected Boolean consolidationNeeded;
    protected List<VirtualMachineFeatureRequirement> offlineFeatureRequirement;
    protected List<VirtualMachineFeatureRequirement> featureRequirement;
    protected List<HostFeatureMask> featureMask;

    /**
     * Gets the value of the device property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the device property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineDeviceRuntimeInfo }
     * 
     * 
     */
    public List<VirtualMachineDeviceRuntimeInfo> getDevice() {
        if (device == null) {
            device = new ArrayList<VirtualMachineDeviceRuntimeInfo>();
        }
        return this.device;
    }

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
     * Gets the value of the connectionState property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineConnectionState }
     *     
     */
    public VirtualMachineConnectionState getConnectionState() {
        return connectionState;
    }

    /**
     * Sets the value of the connectionState property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineConnectionState }
     *     
     */
    public void setConnectionState(VirtualMachineConnectionState value) {
        this.connectionState = value;
    }

    /**
     * Gets the value of the powerState property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachinePowerState }
     *     
     */
    public VirtualMachinePowerState getPowerState() {
        return powerState;
    }

    /**
     * Sets the value of the powerState property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachinePowerState }
     *     
     */
    public void setPowerState(VirtualMachinePowerState value) {
        this.powerState = value;
    }

    /**
     * Gets the value of the faultToleranceState property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineFaultToleranceState }
     *     
     */
    public VirtualMachineFaultToleranceState getFaultToleranceState() {
        return faultToleranceState;
    }

    /**
     * Sets the value of the faultToleranceState property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineFaultToleranceState }
     *     
     */
    public void setFaultToleranceState(VirtualMachineFaultToleranceState value) {
        this.faultToleranceState = value;
    }

    /**
     * Gets the value of the dasVmProtection property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineRuntimeInfoDasProtectionState }
     *     
     */
    public VirtualMachineRuntimeInfoDasProtectionState getDasVmProtection() {
        return dasVmProtection;
    }

    /**
     * Sets the value of the dasVmProtection property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineRuntimeInfoDasProtectionState }
     *     
     */
    public void setDasVmProtection(VirtualMachineRuntimeInfoDasProtectionState value) {
        this.dasVmProtection = value;
    }

    /**
     * Gets the value of the toolsInstallerMounted property.
     * 
     */
    public boolean isToolsInstallerMounted() {
        return toolsInstallerMounted;
    }

    /**
     * Sets the value of the toolsInstallerMounted property.
     * 
     */
    public void setToolsInstallerMounted(boolean value) {
        this.toolsInstallerMounted = value;
    }

    /**
     * Gets the value of the suspendTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSuspendTime() {
        return suspendTime;
    }

    /**
     * Sets the value of the suspendTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSuspendTime(XMLGregorianCalendar value) {
        this.suspendTime = value;
    }

    /**
     * Gets the value of the bootTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBootTime() {
        return bootTime;
    }

    /**
     * Sets the value of the bootTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBootTime(XMLGregorianCalendar value) {
        this.bootTime = value;
    }

    /**
     * Gets the value of the suspendInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSuspendInterval() {
        return suspendInterval;
    }

    /**
     * Sets the value of the suspendInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSuspendInterval(Long value) {
        this.suspendInterval = value;
    }

    /**
     * Gets the value of the question property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineQuestionInfo }
     *     
     */
    public VirtualMachineQuestionInfo getQuestion() {
        return question;
    }

    /**
     * Sets the value of the question property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineQuestionInfo }
     *     
     */
    public void setQuestion(VirtualMachineQuestionInfo value) {
        this.question = value;
    }

    /**
     * Gets the value of the memoryOverhead property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMemoryOverhead() {
        return memoryOverhead;
    }

    /**
     * Sets the value of the memoryOverhead property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMemoryOverhead(Long value) {
        this.memoryOverhead = value;
    }

    /**
     * Gets the value of the maxCpuUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxCpuUsage() {
        return maxCpuUsage;
    }

    /**
     * Sets the value of the maxCpuUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxCpuUsage(Integer value) {
        this.maxCpuUsage = value;
    }

    /**
     * Gets the value of the maxMemoryUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxMemoryUsage() {
        return maxMemoryUsage;
    }

    /**
     * Sets the value of the maxMemoryUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxMemoryUsage(Integer value) {
        this.maxMemoryUsage = value;
    }

    /**
     * Gets the value of the numMksConnections property.
     * 
     */
    public int getNumMksConnections() {
        return numMksConnections;
    }

    /**
     * Sets the value of the numMksConnections property.
     * 
     */
    public void setNumMksConnections(int value) {
        this.numMksConnections = value;
    }

    /**
     * Gets the value of the recordReplayState property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineRecordReplayState }
     *     
     */
    public VirtualMachineRecordReplayState getRecordReplayState() {
        return recordReplayState;
    }

    /**
     * Sets the value of the recordReplayState property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineRecordReplayState }
     *     
     */
    public void setRecordReplayState(VirtualMachineRecordReplayState value) {
        this.recordReplayState = value;
    }

    /**
     * Gets the value of the cleanPowerOff property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCleanPowerOff() {
        return cleanPowerOff;
    }

    /**
     * Sets the value of the cleanPowerOff property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCleanPowerOff(Boolean value) {
        this.cleanPowerOff = value;
    }

    /**
     * Gets the value of the needSecondaryReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNeedSecondaryReason() {
        return needSecondaryReason;
    }

    /**
     * Sets the value of the needSecondaryReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNeedSecondaryReason(String value) {
        this.needSecondaryReason = value;
    }

    /**
     * Gets the value of the onlineStandby property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnlineStandby() {
        return onlineStandby;
    }

    /**
     * Sets the value of the onlineStandby property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnlineStandby(Boolean value) {
        this.onlineStandby = value;
    }

    /**
     * Gets the value of the minRequiredEVCModeKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinRequiredEVCModeKey() {
        return minRequiredEVCModeKey;
    }

    /**
     * Sets the value of the minRequiredEVCModeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinRequiredEVCModeKey(String value) {
        this.minRequiredEVCModeKey = value;
    }

    /**
     * Gets the value of the consolidationNeeded property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConsolidationNeeded() {
        return consolidationNeeded;
    }

    /**
     * Sets the value of the consolidationNeeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConsolidationNeeded(Boolean value) {
        this.consolidationNeeded = value;
    }

    /**
     * Gets the value of the offlineFeatureRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offlineFeatureRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOfflineFeatureRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFeatureRequirement }
     * 
     * 
     */
    public List<VirtualMachineFeatureRequirement> getOfflineFeatureRequirement() {
        if (offlineFeatureRequirement == null) {
            offlineFeatureRequirement = new ArrayList<VirtualMachineFeatureRequirement>();
        }
        return this.offlineFeatureRequirement;
    }

    /**
     * Gets the value of the featureRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFeatureRequirement }
     * 
     * 
     */
    public List<VirtualMachineFeatureRequirement> getFeatureRequirement() {
        if (featureRequirement == null) {
            featureRequirement = new ArrayList<VirtualMachineFeatureRequirement>();
        }
        return this.featureRequirement;
    }

    /**
     * Gets the value of the featureMask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureMask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureMask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostFeatureMask }
     * 
     * 
     */
    public List<HostFeatureMask> getFeatureMask() {
        if (featureMask == null) {
            featureMask = new ArrayList<HostFeatureMask>();
        }
        return this.featureMask;
    }

}
