
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineTargetInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineTargetInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="configurationTag" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineTargetInfo", propOrder = {
    "name",
    "configurationTag"
})
@XmlSeeAlso({
    VirtualMachineCdromInfo.class,
    VirtualMachineFloppyInfo.class,
    VirtualMachineScsiPassthroughInfo.class,
    VirtualMachineSoundInfo.class,
    VirtualMachineDiskDeviceInfo.class,
    VirtualMachineParallelInfo.class,
    VirtualMachineUsbInfo.class,
    VirtualMachineDatastoreInfo.class,
    VirtualMachineSerialInfo.class,
    VirtualMachineNetworkInfo.class,
    VirtualMachinePciPassthroughInfo.class
})
public class VirtualMachineTargetInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String name;
    protected List<String> configurationTag;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the configurationTag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the configurationTag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfigurationTag().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConfigurationTag() {
        if (configurationTag == null) {
            configurationTag = new ArrayList<String>();
        }
        return this.configurationTag;
    }

}
