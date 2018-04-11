
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageDrsVmConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageDrsVmConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="vm" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="behavior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intraVmAffinity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="intraVmAntiAffinity" type="{urn:vim25}VirtualDiskAntiAffinityRuleSpec" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageDrsVmConfigInfo", propOrder = {
    "vm",
    "enabled",
    "behavior",
    "intraVmAffinity",
    "intraVmAntiAffinity"
})
public class StorageDrsVmConfigInfo
    extends DynamicData
{

    protected ManagedObjectReference vm;
    protected Boolean enabled;
    protected String behavior;
    protected Boolean intraVmAffinity;
    protected VirtualDiskAntiAffinityRuleSpec intraVmAntiAffinity;

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
     * Gets the value of the enabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the behavior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBehavior() {
        return behavior;
    }

    /**
     * Sets the value of the behavior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBehavior(String value) {
        this.behavior = value;
    }

    /**
     * Gets the value of the intraVmAffinity property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIntraVmAffinity() {
        return intraVmAffinity;
    }

    /**
     * Sets the value of the intraVmAffinity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIntraVmAffinity(Boolean value) {
        this.intraVmAffinity = value;
    }

    /**
     * Gets the value of the intraVmAntiAffinity property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualDiskAntiAffinityRuleSpec }
     *     
     */
    public VirtualDiskAntiAffinityRuleSpec getIntraVmAntiAffinity() {
        return intraVmAntiAffinity;
    }

    /**
     * Sets the value of the intraVmAntiAffinity property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualDiskAntiAffinityRuleSpec }
     *     
     */
    public void setIntraVmAntiAffinity(VirtualDiskAntiAffinityRuleSpec value) {
        this.intraVmAntiAffinity = value;
    }

}
