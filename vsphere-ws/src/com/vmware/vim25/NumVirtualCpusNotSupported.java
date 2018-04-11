
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NumVirtualCpusNotSupported complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NumVirtualCpusNotSupported">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualHardwareCompatibilityIssue">
 *       &lt;sequence>
 *         &lt;element name="maxSupportedVcpusDest" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numCpuVm" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumVirtualCpusNotSupported", propOrder = {
    "maxSupportedVcpusDest",
    "numCpuVm"
})
public class NumVirtualCpusNotSupported
    extends VirtualHardwareCompatibilityIssue
{

    protected int maxSupportedVcpusDest;
    protected int numCpuVm;

    /**
     * Gets the value of the maxSupportedVcpusDest property.
     * 
     */
    public int getMaxSupportedVcpusDest() {
        return maxSupportedVcpusDest;
    }

    /**
     * Sets the value of the maxSupportedVcpusDest property.
     * 
     */
    public void setMaxSupportedVcpusDest(int value) {
        this.maxSupportedVcpusDest = value;
    }

    /**
     * Gets the value of the numCpuVm property.
     * 
     */
    public int getNumCpuVm() {
        return numCpuVm;
    }

    /**
     * Sets the value of the numCpuVm property.
     * 
     */
    public void setNumCpuVm(int value) {
        this.numCpuVm = value;
    }

}
