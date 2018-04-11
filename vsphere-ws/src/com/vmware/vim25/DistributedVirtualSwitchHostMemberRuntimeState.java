
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistributedVirtualSwitchHostMemberRuntimeState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributedVirtualSwitchHostMemberRuntimeState">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="currentMaxProxySwitchPorts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributedVirtualSwitchHostMemberRuntimeState", propOrder = {
    "currentMaxProxySwitchPorts"
})
public class DistributedVirtualSwitchHostMemberRuntimeState
    extends DynamicData
{

    protected int currentMaxProxySwitchPorts;

    /**
     * Gets the value of the currentMaxProxySwitchPorts property.
     * 
     */
    public int getCurrentMaxProxySwitchPorts() {
        return currentMaxProxySwitchPorts;
    }

    /**
     * Sets the value of the currentMaxProxySwitchPorts property.
     * 
     */
    public void setCurrentMaxProxySwitchPorts(int value) {
        this.currentMaxProxySwitchPorts = value;
    }

}
