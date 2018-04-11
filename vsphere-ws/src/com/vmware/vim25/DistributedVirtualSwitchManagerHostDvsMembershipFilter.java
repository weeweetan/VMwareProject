
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistributedVirtualSwitchManagerHostDvsMembershipFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributedVirtualSwitchManagerHostDvsMembershipFilter">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DistributedVirtualSwitchManagerHostDvsFilterSpec">
 *       &lt;sequence>
 *         &lt;element name="distributedVirtualSwitch" type="{urn:vim25}ManagedObjectReference"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributedVirtualSwitchManagerHostDvsMembershipFilter", propOrder = {
    "distributedVirtualSwitch"
})
public class DistributedVirtualSwitchManagerHostDvsMembershipFilter
    extends DistributedVirtualSwitchManagerHostDvsFilterSpec
{

    @XmlElement(required = true)
    protected ManagedObjectReference distributedVirtualSwitch;

    /**
     * Gets the value of the distributedVirtualSwitch property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getDistributedVirtualSwitch() {
        return distributedVirtualSwitch;
    }

    /**
     * Sets the value of the distributedVirtualSwitch property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setDistributedVirtualSwitch(ManagedObjectReference value) {
        this.distributedVirtualSwitch = value;
    }

}
