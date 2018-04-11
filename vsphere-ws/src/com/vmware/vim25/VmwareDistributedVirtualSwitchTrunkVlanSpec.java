
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmwareDistributedVirtualSwitchTrunkVlanSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmwareDistributedVirtualSwitchTrunkVlanSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmwareDistributedVirtualSwitchVlanSpec">
 *       &lt;sequence>
 *         &lt;element name="vlanId" type="{urn:vim25}NumericRange" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmwareDistributedVirtualSwitchTrunkVlanSpec", propOrder = {
    "vlanId"
})
public class VmwareDistributedVirtualSwitchTrunkVlanSpec
    extends VmwareDistributedVirtualSwitchVlanSpec
{

    @XmlElement(required = true)
    protected List<NumericRange> vlanId;

    /**
     * Gets the value of the vlanId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vlanId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVlanId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NumericRange }
     * 
     * 
     */
    public List<NumericRange> getVlanId() {
        if (vlanId == null) {
            vlanId = new ArrayList<NumericRange>();
        }
        return this.vlanId;
    }

}
