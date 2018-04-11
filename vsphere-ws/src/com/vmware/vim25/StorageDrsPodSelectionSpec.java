
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageDrsPodSelectionSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageDrsPodSelectionSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="initialVmConfig" type="{urn:vim25}VmPodConfigForPlacement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="storagePod" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageDrsPodSelectionSpec", propOrder = {
    "initialVmConfig",
    "storagePod"
})
public class StorageDrsPodSelectionSpec
    extends DynamicData
{

    protected List<VmPodConfigForPlacement> initialVmConfig;
    protected ManagedObjectReference storagePod;

    /**
     * Gets the value of the initialVmConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the initialVmConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInitialVmConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmPodConfigForPlacement }
     * 
     * 
     */
    public List<VmPodConfigForPlacement> getInitialVmConfig() {
        if (initialVmConfig == null) {
            initialVmConfig = new ArrayList<VmPodConfigForPlacement>();
        }
        return this.initialVmConfig;
    }

    /**
     * Gets the value of the storagePod property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getStoragePod() {
        return storagePod;
    }

    /**
     * Sets the value of the storagePod property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setStoragePod(ManagedObjectReference value) {
        this.storagePod = value;
    }

}
