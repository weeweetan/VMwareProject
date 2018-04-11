
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDevicePciBusSlotInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDevicePciBusSlotInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceBusSlotInfo">
 *       &lt;sequence>
 *         &lt;element name="pciSlotNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDevicePciBusSlotInfo", propOrder = {
    "pciSlotNumber"
})
@XmlSeeAlso({
    VirtualUSBControllerPciBusSlotInfo.class
})
public class VirtualDevicePciBusSlotInfo
    extends VirtualDeviceBusSlotInfo
{

    protected int pciSlotNumber;

    /**
     * Gets the value of the pciSlotNumber property.
     * 
     */
    public int getPciSlotNumber() {
        return pciSlotNumber;
    }

    /**
     * Sets the value of the pciSlotNumber property.
     * 
     */
    public void setPciSlotNumber(int value) {
        this.pciSlotNumber = value;
    }

}
