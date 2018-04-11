
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineVMCIDeviceOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineVMCIDeviceOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceOption">
 *       &lt;sequence>
 *         &lt;element name="allowUnrestrictedCommunication" type="{urn:vim25}BoolOption"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineVMCIDeviceOption", propOrder = {
    "allowUnrestrictedCommunication"
})
public class VirtualMachineVMCIDeviceOption
    extends VirtualDeviceOption
{

    @XmlElement(required = true)
    protected BoolOption allowUnrestrictedCommunication;

    /**
     * Gets the value of the allowUnrestrictedCommunication property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getAllowUnrestrictedCommunication() {
        return allowUnrestrictedCommunication;
    }

    /**
     * Sets the value of the allowUnrestrictedCommunication property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setAllowUnrestrictedCommunication(BoolOption value) {
        this.allowUnrestrictedCommunication = value;
    }

}
