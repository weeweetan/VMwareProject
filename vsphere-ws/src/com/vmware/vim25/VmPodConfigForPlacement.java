
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmPodConfigForPlacement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmPodConfigForPlacement">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="storagePod" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="disk" type="{urn:vim25}PodDiskLocator" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vmConfig" type="{urn:vim25}StorageDrsVmConfigInfo" minOccurs="0"/>
 *         &lt;element name="interVmRule" type="{urn:vim25}ClusterRuleInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmPodConfigForPlacement", propOrder = {
    "storagePod",
    "disk",
    "vmConfig",
    "interVmRule"
})
public class VmPodConfigForPlacement
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference storagePod;
    protected List<PodDiskLocator> disk;
    protected StorageDrsVmConfigInfo vmConfig;
    protected List<ClusterRuleInfo> interVmRule;

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

    /**
     * Gets the value of the disk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PodDiskLocator }
     * 
     * 
     */
    public List<PodDiskLocator> getDisk() {
        if (disk == null) {
            disk = new ArrayList<PodDiskLocator>();
        }
        return this.disk;
    }

    /**
     * Gets the value of the vmConfig property.
     * 
     * @return
     *     possible object is
     *     {@link StorageDrsVmConfigInfo }
     *     
     */
    public StorageDrsVmConfigInfo getVmConfig() {
        return vmConfig;
    }

    /**
     * Sets the value of the vmConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageDrsVmConfigInfo }
     *     
     */
    public void setVmConfig(StorageDrsVmConfigInfo value) {
        this.vmConfig = value;
    }

    /**
     * Gets the value of the interVmRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interVmRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterVmRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterRuleInfo }
     * 
     * 
     */
    public List<ClusterRuleInfo> getInterVmRule() {
        if (interVmRule == null) {
            interVmRule = new ArrayList<ClusterRuleInfo>();
        }
        return this.interVmRule;
    }

}
