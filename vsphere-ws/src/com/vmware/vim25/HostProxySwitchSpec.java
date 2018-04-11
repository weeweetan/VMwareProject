
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostProxySwitchSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostProxySwitchSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="backing" type="{urn:vim25}DistributedVirtualSwitchHostMemberBacking" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostProxySwitchSpec", propOrder = {
    "backing"
})
public class HostProxySwitchSpec
    extends DynamicData
{

    protected DistributedVirtualSwitchHostMemberBacking backing;

    /**
     * Gets the value of the backing property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchHostMemberBacking }
     *     
     */
    public DistributedVirtualSwitchHostMemberBacking getBacking() {
        return backing;
    }

    /**
     * Sets the value of the backing property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchHostMemberBacking }
     *     
     */
    public void setBacking(DistributedVirtualSwitchHostMemberBacking value) {
        this.backing = value;
    }

}
