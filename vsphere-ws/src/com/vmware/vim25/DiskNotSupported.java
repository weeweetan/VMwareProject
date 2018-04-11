
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiskNotSupported complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiskNotSupported">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualHardwareCompatibilityIssue">
 *       &lt;sequence>
 *         &lt;element name="disk" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiskNotSupported", propOrder = {
    "disk"
})
@XmlSeeAlso({
    IDEDiskNotSupported.class
})
public class DiskNotSupported
    extends VirtualHardwareCompatibilityIssue
{

    protected int disk;

    /**
     * Gets the value of the disk property.
     * 
     */
    public int getDisk() {
        return disk;
    }

    /**
     * Sets the value of the disk property.
     * 
     */
    public void setDisk(int value) {
        this.disk = value;
    }

}
