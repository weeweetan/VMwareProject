
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="numCpus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numCpuCores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numNumaNodes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="smcPresent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="datastore" type="{urn:vim25}VirtualMachineDatastoreInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="network" type="{urn:vim25}VirtualMachineNetworkInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="distributedVirtualPortgroup" type="{urn:vim25}DistributedVirtualPortgroupInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="distributedVirtualSwitch" type="{urn:vim25}DistributedVirtualSwitchInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cdRom" type="{urn:vim25}VirtualMachineCdromInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="serial" type="{urn:vim25}VirtualMachineSerialInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="parallel" type="{urn:vim25}VirtualMachineParallelInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sound" type="{urn:vim25}VirtualMachineSoundInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usb" type="{urn:vim25}VirtualMachineUsbInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="floppy" type="{urn:vim25}VirtualMachineFloppyInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="legacyNetworkInfo" type="{urn:vim25}VirtualMachineLegacyNetworkSwitchInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="scsiPassthrough" type="{urn:vim25}VirtualMachineScsiPassthroughInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="scsiDisk" type="{urn:vim25}VirtualMachineScsiDiskDeviceInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ideDisk" type="{urn:vim25}VirtualMachineIdeDiskDeviceInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="maxMemMBOptimalPerf" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="resourcePool" type="{urn:vim25}ResourcePoolRuntimeInfo" minOccurs="0"/>
 *         &lt;element name="autoVmotion" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="pciPassthrough" type="{urn:vim25}VirtualMachinePciPassthroughInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigTarget", propOrder = {
    "numCpus",
    "numCpuCores",
    "numNumaNodes",
    "smcPresent",
    "datastore",
    "network",
    "distributedVirtualPortgroup",
    "distributedVirtualSwitch",
    "cdRom",
    "serial",
    "parallel",
    "sound",
    "usb",
    "floppy",
    "legacyNetworkInfo",
    "scsiPassthrough",
    "scsiDisk",
    "ideDisk",
    "maxMemMBOptimalPerf",
    "resourcePool",
    "autoVmotion",
    "pciPassthrough"
})
public class ConfigTarget
    extends DynamicData
{

    protected int numCpus;
    protected int numCpuCores;
    protected int numNumaNodes;
    protected Boolean smcPresent;
    protected List<VirtualMachineDatastoreInfo> datastore;
    protected List<VirtualMachineNetworkInfo> network;
    protected List<DistributedVirtualPortgroupInfo> distributedVirtualPortgroup;
    protected List<DistributedVirtualSwitchInfo> distributedVirtualSwitch;
    protected List<VirtualMachineCdromInfo> cdRom;
    protected List<VirtualMachineSerialInfo> serial;
    protected List<VirtualMachineParallelInfo> parallel;
    protected List<VirtualMachineSoundInfo> sound;
    protected List<VirtualMachineUsbInfo> usb;
    protected List<VirtualMachineFloppyInfo> floppy;
    protected List<VirtualMachineLegacyNetworkSwitchInfo> legacyNetworkInfo;
    protected List<VirtualMachineScsiPassthroughInfo> scsiPassthrough;
    protected List<VirtualMachineScsiDiskDeviceInfo> scsiDisk;
    protected List<VirtualMachineIdeDiskDeviceInfo> ideDisk;
    protected int maxMemMBOptimalPerf;
    protected ResourcePoolRuntimeInfo resourcePool;
    protected Boolean autoVmotion;
    protected List<VirtualMachinePciPassthroughInfo> pciPassthrough;

    /**
     * Gets the value of the numCpus property.
     * 
     */
    public int getNumCpus() {
        return numCpus;
    }

    /**
     * Sets the value of the numCpus property.
     * 
     */
    public void setNumCpus(int value) {
        this.numCpus = value;
    }

    /**
     * Gets the value of the numCpuCores property.
     * 
     */
    public int getNumCpuCores() {
        return numCpuCores;
    }

    /**
     * Sets the value of the numCpuCores property.
     * 
     */
    public void setNumCpuCores(int value) {
        this.numCpuCores = value;
    }

    /**
     * Gets the value of the numNumaNodes property.
     * 
     */
    public int getNumNumaNodes() {
        return numNumaNodes;
    }

    /**
     * Sets the value of the numNumaNodes property.
     * 
     */
    public void setNumNumaNodes(int value) {
        this.numNumaNodes = value;
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
     * Gets the value of the datastore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datastore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatastore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineDatastoreInfo }
     * 
     * 
     */
    public List<VirtualMachineDatastoreInfo> getDatastore() {
        if (datastore == null) {
            datastore = new ArrayList<VirtualMachineDatastoreInfo>();
        }
        return this.datastore;
    }

    /**
     * Gets the value of the network property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the network property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetwork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineNetworkInfo }
     * 
     * 
     */
    public List<VirtualMachineNetworkInfo> getNetwork() {
        if (network == null) {
            network = new ArrayList<VirtualMachineNetworkInfo>();
        }
        return this.network;
    }

    /**
     * Gets the value of the distributedVirtualPortgroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distributedVirtualPortgroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistributedVirtualPortgroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributedVirtualPortgroupInfo }
     * 
     * 
     */
    public List<DistributedVirtualPortgroupInfo> getDistributedVirtualPortgroup() {
        if (distributedVirtualPortgroup == null) {
            distributedVirtualPortgroup = new ArrayList<DistributedVirtualPortgroupInfo>();
        }
        return this.distributedVirtualPortgroup;
    }

    /**
     * Gets the value of the distributedVirtualSwitch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distributedVirtualSwitch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistributedVirtualSwitch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributedVirtualSwitchInfo }
     * 
     * 
     */
    public List<DistributedVirtualSwitchInfo> getDistributedVirtualSwitch() {
        if (distributedVirtualSwitch == null) {
            distributedVirtualSwitch = new ArrayList<DistributedVirtualSwitchInfo>();
        }
        return this.distributedVirtualSwitch;
    }

    /**
     * Gets the value of the cdRom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cdRom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCdRom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineCdromInfo }
     * 
     * 
     */
    public List<VirtualMachineCdromInfo> getCdRom() {
        if (cdRom == null) {
            cdRom = new ArrayList<VirtualMachineCdromInfo>();
        }
        return this.cdRom;
    }

    /**
     * Gets the value of the serial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSerial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineSerialInfo }
     * 
     * 
     */
    public List<VirtualMachineSerialInfo> getSerial() {
        if (serial == null) {
            serial = new ArrayList<VirtualMachineSerialInfo>();
        }
        return this.serial;
    }

    /**
     * Gets the value of the parallel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parallel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParallel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineParallelInfo }
     * 
     * 
     */
    public List<VirtualMachineParallelInfo> getParallel() {
        if (parallel == null) {
            parallel = new ArrayList<VirtualMachineParallelInfo>();
        }
        return this.parallel;
    }

    /**
     * Gets the value of the sound property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sound property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSound().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineSoundInfo }
     * 
     * 
     */
    public List<VirtualMachineSoundInfo> getSound() {
        if (sound == null) {
            sound = new ArrayList<VirtualMachineSoundInfo>();
        }
        return this.sound;
    }

    /**
     * Gets the value of the usb property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usb property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsb().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineUsbInfo }
     * 
     * 
     */
    public List<VirtualMachineUsbInfo> getUsb() {
        if (usb == null) {
            usb = new ArrayList<VirtualMachineUsbInfo>();
        }
        return this.usb;
    }

    /**
     * Gets the value of the floppy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the floppy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFloppy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFloppyInfo }
     * 
     * 
     */
    public List<VirtualMachineFloppyInfo> getFloppy() {
        if (floppy == null) {
            floppy = new ArrayList<VirtualMachineFloppyInfo>();
        }
        return this.floppy;
    }

    /**
     * Gets the value of the legacyNetworkInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legacyNetworkInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegacyNetworkInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineLegacyNetworkSwitchInfo }
     * 
     * 
     */
    public List<VirtualMachineLegacyNetworkSwitchInfo> getLegacyNetworkInfo() {
        if (legacyNetworkInfo == null) {
            legacyNetworkInfo = new ArrayList<VirtualMachineLegacyNetworkSwitchInfo>();
        }
        return this.legacyNetworkInfo;
    }

    /**
     * Gets the value of the scsiPassthrough property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scsiPassthrough property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScsiPassthrough().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineScsiPassthroughInfo }
     * 
     * 
     */
    public List<VirtualMachineScsiPassthroughInfo> getScsiPassthrough() {
        if (scsiPassthrough == null) {
            scsiPassthrough = new ArrayList<VirtualMachineScsiPassthroughInfo>();
        }
        return this.scsiPassthrough;
    }

    /**
     * Gets the value of the scsiDisk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scsiDisk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScsiDisk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineScsiDiskDeviceInfo }
     * 
     * 
     */
    public List<VirtualMachineScsiDiskDeviceInfo> getScsiDisk() {
        if (scsiDisk == null) {
            scsiDisk = new ArrayList<VirtualMachineScsiDiskDeviceInfo>();
        }
        return this.scsiDisk;
    }

    /**
     * Gets the value of the ideDisk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ideDisk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdeDisk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineIdeDiskDeviceInfo }
     * 
     * 
     */
    public List<VirtualMachineIdeDiskDeviceInfo> getIdeDisk() {
        if (ideDisk == null) {
            ideDisk = new ArrayList<VirtualMachineIdeDiskDeviceInfo>();
        }
        return this.ideDisk;
    }

    /**
     * Gets the value of the maxMemMBOptimalPerf property.
     * 
     */
    public int getMaxMemMBOptimalPerf() {
        return maxMemMBOptimalPerf;
    }

    /**
     * Sets the value of the maxMemMBOptimalPerf property.
     * 
     */
    public void setMaxMemMBOptimalPerf(int value) {
        this.maxMemMBOptimalPerf = value;
    }

    /**
     * Gets the value of the resourcePool property.
     * 
     * @return
     *     possible object is
     *     {@link ResourcePoolRuntimeInfo }
     *     
     */
    public ResourcePoolRuntimeInfo getResourcePool() {
        return resourcePool;
    }

    /**
     * Sets the value of the resourcePool property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourcePoolRuntimeInfo }
     *     
     */
    public void setResourcePool(ResourcePoolRuntimeInfo value) {
        this.resourcePool = value;
    }

    /**
     * Gets the value of the autoVmotion property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoVmotion() {
        return autoVmotion;
    }

    /**
     * Sets the value of the autoVmotion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoVmotion(Boolean value) {
        this.autoVmotion = value;
    }

    /**
     * Gets the value of the pciPassthrough property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pciPassthrough property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPciPassthrough().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachinePciPassthroughInfo }
     * 
     * 
     */
    public List<VirtualMachinePciPassthroughInfo> getPciPassthrough() {
        if (pciPassthrough == null) {
            pciPassthrough = new ArrayList<VirtualMachinePciPassthroughInfo>();
        }
        return this.pciPassthrough;
    }

}
