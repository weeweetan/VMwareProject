
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterDasFailoverLevelAdvancedRuntimeInfoSlotInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterDasFailoverLevelAdvancedRuntimeInfoSlotInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="numVcpus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cpuMHz" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="memoryMB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterDasFailoverLevelAdvancedRuntimeInfoSlotInfo", propOrder = {
    "numVcpus",
    "cpuMHz",
    "memoryMB"
})
public class ClusterDasFailoverLevelAdvancedRuntimeInfoSlotInfo
    extends DynamicData
{

    protected int numVcpus;
    protected int cpuMHz;
    protected int memoryMB;

    /**
     * Gets the value of the numVcpus property.
     * 
     */
    public int getNumVcpus() {
        return numVcpus;
    }

    /**
     * Sets the value of the numVcpus property.
     * 
     */
    public void setNumVcpus(int value) {
        this.numVcpus = value;
    }

    /**
     * Gets the value of the cpuMHz property.
     * 
     */
    public int getCpuMHz() {
        return cpuMHz;
    }

    /**
     * Sets the value of the cpuMHz property.
     * 
     */
    public void setCpuMHz(int value) {
        this.cpuMHz = value;
    }

    /**
     * Gets the value of the memoryMB property.
     * 
     */
    public int getMemoryMB() {
        return memoryMB;
    }

    /**
     * Sets the value of the memoryMB property.
     * 
     */
    public void setMemoryMB(int value) {
        this.memoryMB = value;
    }

}
