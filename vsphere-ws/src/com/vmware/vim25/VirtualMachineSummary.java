
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="vm" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="runtime" type="{urn:vim25}VirtualMachineRuntimeInfo"/>
 *         &lt;element name="guest" type="{urn:vim25}VirtualMachineGuestSummary" minOccurs="0"/>
 *         &lt;element name="config" type="{urn:vim25}VirtualMachineConfigSummary"/>
 *         &lt;element name="storage" type="{urn:vim25}VirtualMachineStorageSummary" minOccurs="0"/>
 *         &lt;element name="quickStats" type="{urn:vim25}VirtualMachineQuickStats"/>
 *         &lt;element name="overallStatus" type="{urn:vim25}ManagedEntityStatus"/>
 *         &lt;element name="customValue" type="{urn:vim25}CustomFieldValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineSummary", propOrder = {
    "vm",
    "runtime",
    "guest",
    "config",
    "storage",
    "quickStats",
    "overallStatus",
    "customValue"
})
public class VirtualMachineSummary
    extends DynamicData
{

    protected ManagedObjectReference vm;
    @XmlElement(required = true)
    protected VirtualMachineRuntimeInfo runtime;
    protected VirtualMachineGuestSummary guest;
    @XmlElement(required = true)
    protected VirtualMachineConfigSummary config;
    protected VirtualMachineStorageSummary storage;
    @XmlElement(required = true)
    protected VirtualMachineQuickStats quickStats;
    @XmlElement(required = true)
    protected ManagedEntityStatus overallStatus;
    protected List<CustomFieldValue> customValue;

    /**
     * Gets the value of the vm property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getVm() {
        return vm;
    }

    /**
     * Sets the value of the vm property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setVm(ManagedObjectReference value) {
        this.vm = value;
    }

    /**
     * Gets the value of the runtime property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineRuntimeInfo }
     *     
     */
    public VirtualMachineRuntimeInfo getRuntime() {
        return runtime;
    }

    /**
     * Sets the value of the runtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineRuntimeInfo }
     *     
     */
    public void setRuntime(VirtualMachineRuntimeInfo value) {
        this.runtime = value;
    }

    /**
     * Gets the value of the guest property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineGuestSummary }
     *     
     */
    public VirtualMachineGuestSummary getGuest() {
        return guest;
    }

    /**
     * Sets the value of the guest property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineGuestSummary }
     *     
     */
    public void setGuest(VirtualMachineGuestSummary value) {
        this.guest = value;
    }

    /**
     * Gets the value of the config property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineConfigSummary }
     *     
     */
    public VirtualMachineConfigSummary getConfig() {
        return config;
    }

    /**
     * Sets the value of the config property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineConfigSummary }
     *     
     */
    public void setConfig(VirtualMachineConfigSummary value) {
        this.config = value;
    }

    /**
     * Gets the value of the storage property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineStorageSummary }
     *     
     */
    public VirtualMachineStorageSummary getStorage() {
        return storage;
    }

    /**
     * Sets the value of the storage property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineStorageSummary }
     *     
     */
    public void setStorage(VirtualMachineStorageSummary value) {
        this.storage = value;
    }

    /**
     * Gets the value of the quickStats property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineQuickStats }
     *     
     */
    public VirtualMachineQuickStats getQuickStats() {
        return quickStats;
    }

    /**
     * Sets the value of the quickStats property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineQuickStats }
     *     
     */
    public void setQuickStats(VirtualMachineQuickStats value) {
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

}
