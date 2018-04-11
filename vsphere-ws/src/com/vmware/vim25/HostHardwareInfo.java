
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostHardwareInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostHardwareInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="systemInfo" type="{urn:vim25}HostSystemInfo"/>
 *         &lt;element name="cpuPowerManagementInfo" type="{urn:vim25}HostCpuPowerManagementInfo" minOccurs="0"/>
 *         &lt;element name="cpuInfo" type="{urn:vim25}HostCpuInfo"/>
 *         &lt;element name="cpuPkg" type="{urn:vim25}HostCpuPackage" maxOccurs="unbounded"/>
 *         &lt;element name="memorySize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="numaInfo" type="{urn:vim25}HostNumaInfo" minOccurs="0"/>
 *         &lt;element name="smcPresent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="pciDevice" type="{urn:vim25}HostPciDevice" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cpuFeature" type="{urn:vim25}HostCpuIdInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="biosInfo" type="{urn:vim25}HostBIOSInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostHardwareInfo", propOrder = {
    "systemInfo",
    "cpuPowerManagementInfo",
    "cpuInfo",
    "cpuPkg",
    "memorySize",
    "numaInfo",
    "smcPresent",
    "pciDevice",
    "cpuFeature",
    "biosInfo"
})
public class HostHardwareInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected HostSystemInfo systemInfo;
    protected HostCpuPowerManagementInfo cpuPowerManagementInfo;
    @XmlElement(required = true)
    protected HostCpuInfo cpuInfo;
    @XmlElement(required = true)
    protected List<HostCpuPackage> cpuPkg;
    protected long memorySize;
    protected HostNumaInfo numaInfo;
    protected Boolean smcPresent;
    protected List<HostPciDevice> pciDevice;
    protected List<HostCpuIdInfo> cpuFeature;
    protected HostBIOSInfo biosInfo;

    /**
     * Gets the value of the systemInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostSystemInfo }
     *     
     */
    public HostSystemInfo getSystemInfo() {
        return systemInfo;
    }

    /**
     * Sets the value of the systemInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostSystemInfo }
     *     
     */
    public void setSystemInfo(HostSystemInfo value) {
        this.systemInfo = value;
    }

    /**
     * Gets the value of the cpuPowerManagementInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostCpuPowerManagementInfo }
     *     
     */
    public HostCpuPowerManagementInfo getCpuPowerManagementInfo() {
        return cpuPowerManagementInfo;
    }

    /**
     * Sets the value of the cpuPowerManagementInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostCpuPowerManagementInfo }
     *     
     */
    public void setCpuPowerManagementInfo(HostCpuPowerManagementInfo value) {
        this.cpuPowerManagementInfo = value;
    }

    /**
     * Gets the value of the cpuInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostCpuInfo }
     *     
     */
    public HostCpuInfo getCpuInfo() {
        return cpuInfo;
    }

    /**
     * Sets the value of the cpuInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostCpuInfo }
     *     
     */
    public void setCpuInfo(HostCpuInfo value) {
        this.cpuInfo = value;
    }

    /**
     * Gets the value of the cpuPkg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cpuPkg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCpuPkg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostCpuPackage }
     * 
     * 
     */
    public List<HostCpuPackage> getCpuPkg() {
        if (cpuPkg == null) {
            cpuPkg = new ArrayList<HostCpuPackage>();
        }
        return this.cpuPkg;
    }

    /**
     * Gets the value of the memorySize property.
     * 
     */
    public long getMemorySize() {
        return memorySize;
    }

    /**
     * Sets the value of the memorySize property.
     * 
     */
    public void setMemorySize(long value) {
        this.memorySize = value;
    }

    /**
     * Gets the value of the numaInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostNumaInfo }
     *     
     */
    public HostNumaInfo getNumaInfo() {
        return numaInfo;
    }

    /**
     * Sets the value of the numaInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostNumaInfo }
     *     
     */
    public void setNumaInfo(HostNumaInfo value) {
        this.numaInfo = value;
    }

    /**
     * Gets the value of the smcPresent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSmcPresent() {
        return smcPresent;
    }

    /**
     * Sets the value of the smcPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSmcPresent(Boolean value) {
        this.smcPresent = value;
    }

    /**
     * Gets the value of the pciDevice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pciDevice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPciDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPciDevice }
     * 
     * 
     */
    public List<HostPciDevice> getPciDevice() {
        if (pciDevice == null) {
            pciDevice = new ArrayList<HostPciDevice>();
        }
        return this.pciDevice;
    }

    /**
     * Gets the value of the cpuFeature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cpuFeature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCpuFeature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostCpuIdInfo }
     * 
     * 
     */
    public List<HostCpuIdInfo> getCpuFeature() {
        if (cpuFeature == null) {
            cpuFeature = new ArrayList<HostCpuIdInfo>();
        }
        return this.cpuFeature;
    }

    /**
     * Gets the value of the biosInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostBIOSInfo }
     *     
     */
    public HostBIOSInfo getBiosInfo() {
        return biosInfo;
    }

    /**
     * Sets the value of the biosInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostBIOSInfo }
     *     
     */
    public void setBiosInfo(HostBIOSInfo value) {
        this.biosInfo = value;
    }

}
