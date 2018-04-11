
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResourcePoolRuntimeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourcePoolRuntimeInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="memory" type="{urn:vim25}ResourcePoolResourceUsage"/>
 *         &lt;element name="cpu" type="{urn:vim25}ResourcePoolResourceUsage"/>
 *         &lt;element name="overallStatus" type="{urn:vim25}ManagedEntityStatus"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourcePoolRuntimeInfo", propOrder = {
    "memory",
    "cpu",
    "overallStatus"
})
public class ResourcePoolRuntimeInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected ResourcePoolResourceUsage memory;
    @XmlElement(required = true)
    protected ResourcePoolResourceUsage cpu;
    @XmlElement(required = true)
    protected ManagedEntityStatus overallStatus;

    /**
     * Gets the value of the memory property.
     * 
     * @return
     *     possible object is
     *     {@link ResourcePoolResourceUsage }
     *     
     */
    public ResourcePoolResourceUsage getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourcePoolResourceUsage }
     *     
     */
    public void setMemory(ResourcePoolResourceUsage value) {
        this.memory = value;
    }

    /**
     * Gets the value of the cpu property.
     * 
     * @return
     *     possible object is
     *     {@link ResourcePoolResourceUsage }
     *     
     */
    public ResourcePoolResourceUsage getCpu() {
        return cpu;
    }

    /**
     * Sets the value of the cpu property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourcePoolResourceUsage }
     *     
     */
    public void setCpu(ResourcePoolResourceUsage value) {
        this.cpu = value;
    }

    /**
     * Gets the value of the overallStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public ManagedEntityStatus getOverallStatus() {
        return overallStatus;
    }

    /**
     * Sets the value of the overallStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public void setOverallStatus(ManagedEntityStatus value) {
        this.overallStatus = value;
    }

}
