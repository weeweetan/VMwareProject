
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmBeingCreatedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmBeingCreatedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="configSpec" type="{urn:vim25}VirtualMachineConfigSpec" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmBeingCreatedEvent", propOrder = {
    "configSpec"
})
public class VmBeingCreatedEvent
    extends VmEvent
{

    protected VirtualMachineConfigSpec configSpec;

    /**
     * Gets the value of the configSpec property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineConfigSpec }
     *     
     */
    public VirtualMachineConfigSpec getConfigSpec() {
        return configSpec;
    }

    /**
     * Sets the value of the configSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineConfigSpec }
     *     
     */
    public void setConfigSpec(VirtualMachineConfigSpec value) {
        this.configSpec = value;
    }

}
