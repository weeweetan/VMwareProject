
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmFaultToleranceStateChangedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmFaultToleranceStateChangedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="oldState" type="{urn:vim25}VirtualMachineFaultToleranceState"/>
 *         &lt;element name="newState" type="{urn:vim25}VirtualMachineFaultToleranceState"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmFaultToleranceStateChangedEvent", propOrder = {
    "oldState",
    "newState"
})
public class VmFaultToleranceStateChangedEvent
    extends VmEvent
{

    @XmlElement(required = true)
    protected VirtualMachineFaultToleranceState oldState;
    @XmlElement(required = true)
    protected VirtualMachineFaultToleranceState newState;

    /**
     * Gets the value of the oldState property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineFaultToleranceState }
     *     
     */
    public VirtualMachineFaultToleranceState getOldState() {
        return oldState;
    }

    /**
     * Sets the value of the oldState property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineFaultToleranceState }
     *     
     */
    public void setOldState(VirtualMachineFaultToleranceState value) {
        this.oldState = value;
    }

    /**
     * Gets the value of the newState property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineFaultToleranceState }
     *     
     */
    public VirtualMachineFaultToleranceState getNewState() {
        return newState;
    }

    /**
     * Sets the value of the newState property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineFaultToleranceState }
     *     
     */
    public void setNewState(VirtualMachineFaultToleranceState value) {
        this.newState = value;
    }

}
