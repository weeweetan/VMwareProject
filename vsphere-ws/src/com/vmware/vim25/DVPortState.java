
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVPortState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVPortState">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="runtimeInfo" type="{urn:vim25}DVPortStatus" minOccurs="0"/>
 *         &lt;element name="stats" type="{urn:vim25}DistributedVirtualSwitchPortStatistics"/>
 *         &lt;element name="vendorSpecificState" type="{urn:vim25}DistributedVirtualSwitchKeyedOpaqueBlob" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVPortState", propOrder = {
    "runtimeInfo",
    "stats",
    "vendorSpecificState"
})
public class DVPortState
    extends DynamicData
{

    protected DVPortStatus runtimeInfo;
    @XmlElement(required = true)
    protected DistributedVirtualSwitchPortStatistics stats;
    protected List<DistributedVirtualSwitchKeyedOpaqueBlob> vendorSpecificState;

    /**
     * Gets the value of the runtimeInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DVPortStatus }
     *     
     */
    public DVPortStatus getRuntimeInfo() {
        return runtimeInfo;
    }

    /**
     * Sets the value of the runtimeInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVPortStatus }
     *     
     */
    public void setRuntimeInfo(DVPortStatus value) {
        this.runtimeInfo = value;
    }

    /**
     * Gets the value of the stats property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchPortStatistics }
     *     
     */
    public DistributedVirtualSwitchPortStatistics getStats() {
        return stats;
    }

    /**
     * Sets the value of the stats property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchPortStatistics }
     *     
     */
    public void setStats(DistributedVirtualSwitchPortStatistics value) {
        this.stats = value;
    }

    /**
     * Gets the value of the vendorSpecificState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vendorSpecificState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVendorSpecificState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributedVirtualSwitchKeyedOpaqueBlob }
     * 
     * 
     */
    public List<DistributedVirtualSwitchKeyedOpaqueBlob> getVendorSpecificState() {
        if (vendorSpecificState == null) {
            vendorSpecificState = new ArrayList<DistributedVirtualSwitchKeyedOpaqueBlob>();
        }
        return this.vendorSpecificState;
    }

}
