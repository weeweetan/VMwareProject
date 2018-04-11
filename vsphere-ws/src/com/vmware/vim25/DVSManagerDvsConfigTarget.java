
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSManagerDvsConfigTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSManagerDvsConfigTarget">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="distributedVirtualPortgroup" type="{urn:vim25}DistributedVirtualPortgroupInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="distributedVirtualSwitch" type="{urn:vim25}DistributedVirtualSwitchInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSManagerDvsConfigTarget", propOrder = {
    "distributedVirtualPortgroup",
    "distributedVirtualSwitch"
})
public class DVSManagerDvsConfigTarget
    extends DynamicData
{

    protected List<DistributedVirtualPortgroupInfo> distributedVirtualPortgroup;
    protected List<DistributedVirtualSwitchInfo> distributedVirtualSwitch;

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

}
