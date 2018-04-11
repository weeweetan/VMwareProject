
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmwareDistributedVirtualSwitchVlanIdSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmwareDistributedVirtualSwitchVlanIdSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmwareDistributedVirtualSwitchVlanSpec">
 *       &lt;sequence>
 *         &lt;element name="vlanId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmwareDistributedVirtualSwitchVlanIdSpec", propOrder = {
    "vlanId"
})
public class VmwareDistributedVirtualSwitchVlanIdSpec
    extends VmwareDistributedVirtualSwitchVlanSpec
{

    protected int vlanId;

    /**
     * Gets the value of the vlanId property.
     * 
     */
    public int getVlanId() {
        return vlanId;
    }

    /**
     * Sets the value of the vlanId property.
     * 
     */
    public void setVlanId(int value) {
        this.vlanId = value;
    }

}
