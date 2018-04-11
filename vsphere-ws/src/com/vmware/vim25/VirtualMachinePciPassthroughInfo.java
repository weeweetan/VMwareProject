
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachinePciPassthroughInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachinePciPassthroughInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualMachineTargetInfo">
 *       &lt;sequence>
 *         &lt;element name="pciDevice" type="{urn:vim25}HostPciDevice"/>
 *         &lt;element name="systemId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachinePciPassthroughInfo", propOrder = {
    "pciDevice",
    "systemId"
})
public class VirtualMachinePciPassthroughInfo
    extends VirtualMachineTargetInfo
{

    @XmlElement(required = true)
    protected HostPciDevice pciDevice;
    @XmlElement(required = true)
    protected String systemId;

    /**
     * Gets the value of the pciDevice property.
     * 
     * @return
     *     possible object is
     *     {@link HostPciDevice }
     *     
     */
    public HostPciDevice getPciDevice() {
        return pciDevice;
    }

    /**
     * Sets the value of the pciDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostPciDevice }
     *     
     */
    public void setPciDevice(HostPciDevice value) {
        this.pciDevice = value;
    }

    /**
     * Gets the value of the systemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * Sets the value of the systemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemId(String value) {
        this.systemId = value;
    }

}
