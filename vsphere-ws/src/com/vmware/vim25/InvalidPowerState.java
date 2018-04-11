
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvalidPowerState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvalidPowerState">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InvalidState">
 *       &lt;sequence>
 *         &lt;element name="requestedState" type="{urn:vim25}VirtualMachinePowerState" minOccurs="0"/>
 *         &lt;element name="existingState" type="{urn:vim25}VirtualMachinePowerState"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvalidPowerState", propOrder = {
    "requestedState",
    "existingState"
})
public class InvalidPowerState
    extends InvalidState
{

    protected VirtualMachinePowerState requestedState;
    @XmlElement(required = true)
    protected VirtualMachinePowerState existingState;

    /**
     * Gets the value of the requestedState property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachinePowerState }
     *     
     */
    public VirtualMachinePowerState getRequestedState() {
        return requestedState;
    }

    /**
     * Sets the value of the requestedState property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachinePowerState }
     *     
     */
    public void setRequestedState(VirtualMachinePowerState value) {
        this.requestedState = value;
    }

    /**
     * Gets the value of the existingState property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachinePowerState }
     *     
     */
    public VirtualMachinePowerState getExistingState() {
        return existingState;
    }

    /**
     * Sets the value of the existingState property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachinePowerState }
     *     
     */
    public void setExistingState(VirtualMachinePowerState value) {
        this.existingState = value;
    }

}
