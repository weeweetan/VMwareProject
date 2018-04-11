
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResourceConfigOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceConfigOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="cpuAllocationOption" type="{urn:vim25}ResourceAllocationOption"/>
 *         &lt;element name="memoryAllocationOption" type="{urn:vim25}ResourceAllocationOption"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceConfigOption", propOrder = {
    "cpuAllocationOption",
    "memoryAllocationOption"
})
public class ResourceConfigOption
    extends DynamicData
{

    @XmlElement(required = true)
    protected ResourceAllocationOption cpuAllocationOption;
    @XmlElement(required = true)
    protected ResourceAllocationOption memoryAllocationOption;

    /**
     * Gets the value of the cpuAllocationOption property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAllocationOption }
     *     
     */
    public ResourceAllocationOption getCpuAllocationOption() {
        return cpuAllocationOption;
    }

    /**
     * Sets the value of the cpuAllocationOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAllocationOption }
     *     
     */
    public void setCpuAllocationOption(ResourceAllocationOption value) {
        this.cpuAllocationOption = value;
    }

    /**
     * Gets the value of the memoryAllocationOption property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceAllocationOption }
     *     
     */
    public ResourceAllocationOption getMemoryAllocationOption() {
        return memoryAllocationOption;
    }

    /**
     * Sets the value of the memoryAllocationOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceAllocationOption }
     *     
     */
    public void setMemoryAllocationOption(ResourceAllocationOption value) {
        this.memoryAllocationOption = value;
    }

}
