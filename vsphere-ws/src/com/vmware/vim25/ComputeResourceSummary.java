
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComputeResourceSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComputeResourceSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="totalCpu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalMemory" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="numCpuCores" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="numCpuThreads" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="effectiveCpu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="effectiveMemory" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="numHosts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numEffectiveHosts" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "ComputeResourceSummary", propOrder = {
    "totalCpu",
    "totalMemory",
    "numCpuCores",
    "numCpuThreads",
    "effectiveCpu",
    "effectiveMemory",
    "numHosts",
    "numEffectiveHosts",
    "overallStatus"
})
@XmlSeeAlso({
    ClusterComputeResourceSummary.class
})
public class ComputeResourceSummary
    extends DynamicData
{

    protected int totalCpu;
    protected long totalMemory;
    protected short numCpuCores;
    protected short numCpuThreads;
    protected int effectiveCpu;
    protected long effectiveMemory;
    protected int numHosts;
    protected int numEffectiveHosts;
    @XmlElement(required = true)
    protected ManagedEntityStatus overallStatus;

    /**
     * Gets the value of the totalCpu property.
     * 
     */
    public int getTotalCpu() {
        return totalCpu;
    }

    /**
     * Sets the value of the totalCpu property.
     * 
     */
    public void setTotalCpu(int value) {
        this.totalCpu = value;
    }

    /**
     * Gets the value of the totalMemory property.
     * 
     */
    public long getTotalMemory() {
        return totalMemory;
    }

    /**
     * Sets the value of the totalMemory property.
     * 
     */
    public void setTotalMemory(long value) {
        this.totalMemory = value;
    }

    /**
     * Gets the value of the numCpuCores property.
     * 
     */
    public short getNumCpuCores() {
        return numCpuCores;
    }

    /**
     * Sets the value of the numCpuCores property.
     * 
     */
    public void setNumCpuCores(short value) {
        this.numCpuCores = value;
    }

    /**
     * Gets the value of the numCpuThreads property.
     * 
     */
    public short getNumCpuThreads() {
        return numCpuThreads;
    }

    /**
     * Sets the value of the numCpuThreads property.
     * 
     */
    public void setNumCpuThreads(short value) {
        this.numCpuThreads = value;
    }

    /**
     * Gets the value of the effectiveCpu property.
     * 
     */
    public int getEffectiveCpu() {
        return effectiveCpu;
    }

    /**
     * Sets the value of the effectiveCpu property.
     * 
     */
    public void setEffectiveCpu(int value) {
        this.effectiveCpu = value;
    }

    /**
     * Gets the value of the effectiveMemory property.
     * 
     */
    public long getEffectiveMemory() {
        return effectiveMemory;
    }

    /**
     * Sets the value of the effectiveMemory property.
     * 
     */
    public void setEffectiveMemory(long value) {
        this.effectiveMemory = value;
    }

    /**
     * Gets the value of the numHosts property.
     * 
     */
    public int getNumHosts() {
        return numHosts;
    }

    /**
     * Sets the value of the numHosts property.
     * 
     */
    public void setNumHosts(int value) {
        this.numHosts = value;
    }

    /**
     * Gets the value of the numEffectiveHosts property.
     * 
     */
    public int getNumEffectiveHosts() {
        return numEffectiveHosts;
    }

    /**
     * Sets the value of the numEffectiveHosts property.
     * 
     */
    public void setNumEffectiveHosts(int value) {
        this.numEffectiveHosts = value;
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
