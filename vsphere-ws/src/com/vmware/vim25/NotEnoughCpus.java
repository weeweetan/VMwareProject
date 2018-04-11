
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NotEnoughCpus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotEnoughCpus">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualHardwareCompatibilityIssue">
 *       &lt;sequence>
 *         &lt;element name="numCpuDest" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "NotEnoughCpus", propOrder = {
    "numCpuDest",
    "numCpuVm"
})
@XmlSeeAlso({
    NotEnoughLogicalCpus.class
})
public class NotEnoughCpus
    extends VirtualHardwareCompatibilityIssue
{

    protected int numCpuDest;
    protected int numCpuVm;

    /**
     * Gets the value of the numCpuDest property.
     * 
     */
    public int getNumCpuDest() {
        return numCpuDest;
    }

    /**
     * Sets the value of the numCpuDest property.
     * 
     */
    public void setNumCpuDest(int value) {
        this.numCpuDest = value;
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
