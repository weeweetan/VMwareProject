
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineDeviceRuntimeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineDeviceRuntimeInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="runtimeState" type="{urn:vim25}VirtualMachineDeviceRuntimeInfoDeviceRuntimeState"/>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineDeviceRuntimeInfo", propOrder = {
    "runtimeState",
    "key"
})
public class VirtualMachineDeviceRuntimeInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected VirtualMachineDeviceRuntimeInfoDeviceRuntimeState runtimeState;
    protected int key;

    /**
     * Gets the value of the runtimeState property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineDeviceRuntimeInfoDeviceRuntimeState }
     *     
     */
    public VirtualMachineDeviceRuntimeInfoDeviceRuntimeState getRuntimeState() {
        return runtimeState;
    }

    /**
     * Sets the value of the runtimeState property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineDeviceRuntimeInfoDeviceRuntimeState }
     *     
     */
    public void setRuntimeState(VirtualMachineDeviceRuntimeInfoDeviceRuntimeState value) {
        this.runtimeState = value;
    }

    /**
     * Gets the value of the key property.
     * 
     */
    public int getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     */
    public void setKey(int value) {
        this.key = value;
    }

}
