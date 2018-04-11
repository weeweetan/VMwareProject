
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeState">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualMachineDeviceRuntimeInfoDeviceRuntimeState">
 *       &lt;sequence>
 *         &lt;element name="vmDirectPathGen2Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vmDirectPathGen2InactiveReasonVm" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vmDirectPathGen2InactiveReasonOther" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vmDirectPathGen2InactiveReasonExtended" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeState", propOrder = {
    "vmDirectPathGen2Active",
    "vmDirectPathGen2InactiveReasonVm",
    "vmDirectPathGen2InactiveReasonOther",
    "vmDirectPathGen2InactiveReasonExtended"
})
public class VirtualMachineDeviceRuntimeInfoVirtualEthernetCardRuntimeState
    extends VirtualMachineDeviceRuntimeInfoDeviceRuntimeState
{

    protected boolean vmDirectPathGen2Active;
    protected List<String> vmDirectPathGen2InactiveReasonVm;
    protected List<String> vmDirectPathGen2InactiveReasonOther;
    protected String vmDirectPathGen2InactiveReasonExtended;

    /**
     * Gets the value of the vmDirectPathGen2Active property.
     * 
     */
    public boolean isVmDirectPathGen2Active() {
        return vmDirectPathGen2Active;
    }

    /**
     * Sets the value of the vmDirectPathGen2Active property.
     * 
     */
    public void setVmDirectPathGen2Active(boolean value) {
        this.vmDirectPathGen2Active = value;
    }

    /**
     * Gets the value of the vmDirectPathGen2InactiveReasonVm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmDirectPathGen2InactiveReasonVm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmDirectPathGen2InactiveReasonVm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVmDirectPathGen2InactiveReasonVm() {
        if (vmDirectPathGen2InactiveReasonVm == null) {
            vmDirectPathGen2InactiveReasonVm = new ArrayList<String>();
        }
        return this.vmDirectPathGen2InactiveReasonVm;
    }

    /**
     * Gets the value of the vmDirectPathGen2InactiveReasonOther property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmDirectPathGen2InactiveReasonOther property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmDirectPathGen2InactiveReasonOther().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVmDirectPathGen2InactiveReasonOther() {
        if (vmDirectPathGen2InactiveReasonOther == null) {
            vmDirectPathGen2InactiveReasonOther = new ArrayList<String>();
        }
        return this.vmDirectPathGen2InactiveReasonOther;
    }

    /**
     * Gets the value of the vmDirectPathGen2InactiveReasonExtended property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVmDirectPathGen2InactiveReasonExtended() {
        return vmDirectPathGen2InactiveReasonExtended;
    }

    /**
     * Sets the value of the vmDirectPathGen2InactiveReasonExtended property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVmDirectPathGen2InactiveReasonExtended(String value) {
        this.vmDirectPathGen2InactiveReasonExtended = value;
    }

}
