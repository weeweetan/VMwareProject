
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestOsDescriptor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuestOsDescriptor">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="supportedMaxCPUs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numSupportedPhysicalSockets" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numSupportedCoresPerSocket" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="supportedMinMemMB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="supportedMaxMemMB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recommendedMemMB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recommendedColorDepth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="supportedDiskControllerList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="recommendedSCSIController" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recommendedDiskController" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="supportedNumDisks" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recommendedDiskSizeMB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="supportedEthernetCard" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="recommendedEthernetCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supportsSlaveDisk" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cpuFeatureMask" type="{urn:vim25}HostCpuIdInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="smcRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="supportsWakeOnLan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="supportsVMI" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="supportsMemoryHotAdd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="supportsCpuHotAdd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="supportsCpuHotRemove" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="supportedFirmware" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="recommendedFirmware" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supportedUSBControllerList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="recommendedUSBController" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supports3D" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="recommended3D" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="smcRecommended" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ich7mRecommended" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="usbRecommended" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="supportLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supportedForCreate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vRAMSizeInKB" type="{urn:vim25}IntOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestOsDescriptor", propOrder = {
    "id",
    "family",
    "fullName",
    "supportedMaxCPUs",
    "numSupportedPhysicalSockets",
    "numSupportedCoresPerSocket",
    "supportedMinMemMB",
    "supportedMaxMemMB",
    "recommendedMemMB",
    "recommendedColorDepth",
    "supportedDiskControllerList",
    "recommendedSCSIController",
    "recommendedDiskController",
    "supportedNumDisks",
    "recommendedDiskSizeMB",
    "supportedEthernetCard",
    "recommendedEthernetCard",
    "supportsSlaveDisk",
    "cpuFeatureMask",
    "smcRequired",
    "supportsWakeOnLan",
    "supportsVMI",
    "supportsMemoryHotAdd",
    "supportsCpuHotAdd",
    "supportsCpuHotRemove",
    "supportedFirmware",
    "recommendedFirmware",
    "supportedUSBControllerList",
    "recommendedUSBController",
    "supports3D",
    "recommended3D",
    "smcRecommended",
    "ich7MRecommended",
    "usbRecommended",
    "supportLevel",
    "supportedForCreate",
    "vramSizeInKB"
})
public class GuestOsDescriptor
    extends DynamicData
{

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String family;
    @XmlElement(required = true)
    protected String fullName;
    protected int supportedMaxCPUs;
    protected Integer numSupportedPhysicalSockets;
    protected Integer numSupportedCoresPerSocket;
    protected int supportedMinMemMB;
    protected int supportedMaxMemMB;
    protected int recommendedMemMB;
    protected int recommendedColorDepth;
    @XmlElement(required = true)
    protected List<String> supportedDiskControllerList;
    protected String recommendedSCSIController;
    @XmlElement(required = true)
    protected String recommendedDiskController;
    protected int supportedNumDisks;
    protected int recommendedDiskSizeMB;
    @XmlElement(required = true)
    protected List<String> supportedEthernetCard;
    protected String recommendedEthernetCard;
    protected Boolean supportsSlaveDisk;
    protected List<HostCpuIdInfo> cpuFeatureMask;
    protected Boolean smcRequired;
    protected boolean supportsWakeOnLan;
    protected Boolean supportsVMI;
    protected Boolean supportsMemoryHotAdd;
    protected Boolean supportsCpuHotAdd;
    protected Boolean supportsCpuHotRemove;
    protected List<String> supportedFirmware;
    protected String recommendedFirmware;
    protected List<String> supportedUSBControllerList;
    protected String recommendedUSBController;
    protected Boolean supports3D;
    protected Boolean recommended3D;
    protected Boolean smcRecommended;
    @XmlElement(name = "ich7mRecommended")
    protected Boolean ich7MRecommended;
    protected Boolean usbRecommended;
    protected String supportLevel;
    protected Boolean supportedForCreate;
    @XmlElement(name = "vRAMSizeInKB")
    protected IntOption vramSizeInKB;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the family property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamily() {
        return family;
    }

    /**
     * Sets the value of the family property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamily(String value) {
        this.family = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the supportedMaxCPUs property.
     * 
     */
    public int getSupportedMaxCPUs() {
        return supportedMaxCPUs;
    }

    /**
     * Sets the value of the supportedMaxCPUs property.
     * 
     */
    public void setSupportedMaxCPUs(int value) {
        this.supportedMaxCPUs = value;
    }

    /**
     * Gets the value of the numSupportedPhysicalSockets property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumSupportedPhysicalSockets() {
        return numSupportedPhysicalSockets;
    }

    /**
     * Sets the value of the numSupportedPhysicalSockets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumSupportedPhysicalSockets(Integer value) {
        this.numSupportedPhysicalSockets = value;
    }

    /**
     * Gets the value of the numSupportedCoresPerSocket property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumSupportedCoresPerSocket() {
        return numSupportedCoresPerSocket;
    }

    /**
     * Sets the value of the numSupportedCoresPerSocket property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumSupportedCoresPerSocket(Integer value) {
        this.numSupportedCoresPerSocket = value;
    }

    /**
     * Gets the value of the supportedMinMemMB property.
     * 
     */
    public int getSupportedMinMemMB() {
        return supportedMinMemMB;
    }

    /**
     * Sets the value of the supportedMinMemMB property.
     * 
     */
    public void setSupportedMinMemMB(int value) {
        this.supportedMinMemMB = value;
    }

    /**
     * Gets the value of the supportedMaxMemMB property.
     * 
     */
    public int getSupportedMaxMemMB() {
        return supportedMaxMemMB;
    }

    /**
     * Sets the value of the supportedMaxMemMB property.
     * 
     */
    public void setSupportedMaxMemMB(int value) {
        this.supportedMaxMemMB = value;
    }

    /**
     * Gets the value of the recommendedMemMB property.
     * 
     */
    public int getRecommendedMemMB() {
        return recommendedMemMB;
    }

    /**
     * Sets the value of the recommendedMemMB property.
     * 
     */
    public void setRecommendedMemMB(int value) {
        this.recommendedMemMB = value;
    }

    /**
     * Gets the value of the recommendedColorDepth property.
     * 
     */
    public int getRecommendedColorDepth() {
        return recommendedColorDepth;
    }

    /**
     * Sets the value of the recommendedColorDepth property.
     * 
     */
    public void setRecommendedColorDepth(int value) {
        this.recommendedColorDepth = value;
    }

    /**
     * Gets the value of the supportedDiskControllerList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedDiskControllerList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedDiskControllerList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedDiskControllerList() {
        if (supportedDiskControllerList == null) {
            supportedDiskControllerList = new ArrayList<String>();
        }
        return this.supportedDiskControllerList;
    }

    /**
     * Gets the value of the recommendedSCSIController property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecommendedSCSIController() {
        return recommendedSCSIController;
    }

    /**
     * Sets the value of the recommendedSCSIController property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecommendedSCSIController(String value) {
        this.recommendedSCSIController = value;
    }

    /**
     * Gets the value of the recommendedDiskController property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecommendedDiskController() {
        return recommendedDiskController;
    }

    /**
     * Sets the value of the recommendedDiskController property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecommendedDiskController(String value) {
        this.recommendedDiskController = value;
    }

    /**
     * Gets the value of the supportedNumDisks property.
     * 
     */
    public int getSupportedNumDisks() {
        return supportedNumDisks;
    }

    /**
     * Sets the value of the supportedNumDisks property.
     * 
     */
    public void setSupportedNumDisks(int value) {
        this.supportedNumDisks = value;
    }

    /**
     * Gets the value of the recommendedDiskSizeMB property.
     * 
     */
    public int getRecommendedDiskSizeMB() {
        return recommendedDiskSizeMB;
    }

    /**
     * Sets the value of the recommendedDiskSizeMB property.
     * 
     */
    public void setRecommendedDiskSizeMB(int value) {
        this.recommendedDiskSizeMB = value;
    }

    /**
     * Gets the value of the supportedEthernetCard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedEthernetCard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedEthernetCard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedEthernetCard() {
        if (supportedEthernetCard == null) {
            supportedEthernetCard = new ArrayList<String>();
        }
        return this.supportedEthernetCard;
    }

    /**
     * Gets the value of the recommendedEthernetCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecommendedEthernetCard() {
        return recommendedEthernetCard;
    }

    /**
     * Sets the value of the recommendedEthernetCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecommendedEthernetCard(String value) {
        this.recommendedEthernetCard = value;
    }

    /**
     * Gets the value of the supportsSlaveDisk property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsSlaveDisk() {
        return supportsSlaveDisk;
    }

    /**
     * Sets the value of the supportsSlaveDisk property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsSlaveDisk(Boolean value) {
        this.supportsSlaveDisk = value;
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
     * {@link HostCpuIdInfo }
     * 
     * 
     */
    public List<HostCpuIdInfo> getCpuFeatureMask() {
        if (cpuFeatureMask == null) {
            cpuFeatureMask = new ArrayList<HostCpuIdInfo>();
        }
        return this.cpuFeatureMask;
    }

    /**
     * Gets the value of the smcRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSmcRequired() {
        return smcRequired;
    }

    /**
     * Sets the value of the smcRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSmcRequired(Boolean value) {
        this.smcRequired = value;
    }

    /**
     * Gets the value of the supportsWakeOnLan property.
     * 
     */
    public boolean isSupportsWakeOnLan() {
        return supportsWakeOnLan;
    }

    /**
     * Sets the value of the supportsWakeOnLan property.
     * 
     */
    public void setSupportsWakeOnLan(boolean value) {
        this.supportsWakeOnLan = value;
    }

    /**
     * Gets the value of the supportsVMI property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsVMI() {
        return supportsVMI;
    }

    /**
     * Sets the value of the supportsVMI property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsVMI(Boolean value) {
        this.supportsVMI = value;
    }

    /**
     * Gets the value of the supportsMemoryHotAdd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsMemoryHotAdd() {
        return supportsMemoryHotAdd;
    }

    /**
     * Sets the value of the supportsMemoryHotAdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsMemoryHotAdd(Boolean value) {
        this.supportsMemoryHotAdd = value;
    }

    /**
     * Gets the value of the supportsCpuHotAdd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsCpuHotAdd() {
        return supportsCpuHotAdd;
    }

    /**
     * Sets the value of the supportsCpuHotAdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsCpuHotAdd(Boolean value) {
        this.supportsCpuHotAdd = value;
    }

    /**
     * Gets the value of the supportsCpuHotRemove property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportsCpuHotRemove() {
        return supportsCpuHotRemove;
    }

    /**
     * Sets the value of the supportsCpuHotRemove property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportsCpuHotRemove(Boolean value) {
        this.supportsCpuHotRemove = value;
    }

    /**
     * Gets the value of the supportedFirmware property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedFirmware property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedFirmware().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedFirmware() {
        if (supportedFirmware == null) {
            supportedFirmware = new ArrayList<String>();
        }
        return this.supportedFirmware;
    }

    /**
     * Gets the value of the recommendedFirmware property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecommendedFirmware() {
        return recommendedFirmware;
    }

    /**
     * Sets the value of the recommendedFirmware property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecommendedFirmware(String value) {
        this.recommendedFirmware = value;
    }

    /**
     * Gets the value of the supportedUSBControllerList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedUSBControllerList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedUSBControllerList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedUSBControllerList() {
        if (supportedUSBControllerList == null) {
            supportedUSBControllerList = new ArrayList<String>();
        }
        return this.supportedUSBControllerList;
    }

    /**
     * Gets the value of the recommendedUSBController property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecommendedUSBController() {
        return recommendedUSBController;
    }

    /**
     * Sets the value of the recommendedUSBController property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecommendedUSBController(String value) {
        this.recommendedUSBController = value;
    }

    /**
     * Gets the value of the supports3D property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupports3D() {
        return supports3D;
    }

    /**
     * Sets the value of the supports3D property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupports3D(Boolean value) {
        this.supports3D = value;
    }

    /**
     * Gets the value of the recommended3D property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecommended3D() {
        return recommended3D;
    }

    /**
     * Sets the value of the recommended3D property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecommended3D(Boolean value) {
        this.recommended3D = value;
    }

    /**
     * Gets the value of the smcRecommended property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSmcRecommended() {
        return smcRecommended;
    }

    /**
     * Sets the value of the smcRecommended property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSmcRecommended(Boolean value) {
        this.smcRecommended = value;
    }

    /**
     * Gets the value of the ich7MRecommended property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIch7MRecommended() {
        return ich7MRecommended;
    }

    /**
     * Sets the value of the ich7MRecommended property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIch7MRecommended(Boolean value) {
        this.ich7MRecommended = value;
    }

    /**
     * Gets the value of the usbRecommended property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUsbRecommended() {
        return usbRecommended;
    }

    /**
     * Sets the value of the usbRecommended property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUsbRecommended(Boolean value) {
        this.usbRecommended = value;
    }

    /**
     * Gets the value of the supportLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportLevel() {
        return supportLevel;
    }

    /**
     * Sets the value of the supportLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportLevel(String value) {
        this.supportLevel = value;
    }

    /**
     * Gets the value of the supportedForCreate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSupportedForCreate() {
        return supportedForCreate;
    }

    /**
     * Sets the value of the supportedForCreate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSupportedForCreate(Boolean value) {
        this.supportedForCreate = value;
    }

    /**
     * Gets the value of the vramSizeInKB property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getVRAMSizeInKB() {
        return vramSizeInKB;
    }

    /**
     * Sets the value of the vramSizeInKB property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setVRAMSizeInKB(IntOption value) {
        this.vramSizeInKB = value;
    }

}
