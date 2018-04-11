
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileBackedVirtualDiskSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileBackedVirtualDiskSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDiskSpec">
 *       &lt;sequence>
 *         &lt;element name="capacityKb" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileBackedVirtualDiskSpec", propOrder = {
    "capacityKb"
})
@XmlSeeAlso({
    SeSparseVirtualDiskSpec.class
})
public class FileBackedVirtualDiskSpec
    extends VirtualDiskSpec
{

    protected long capacityKb;

    /**
     * Gets the value of the capacityKb property.
     * 
     */
    public long getCapacityKb() {
        return capacityKb;
    }

    /**
     * Sets the value of the capacityKb property.
     * 
     */
    public void setCapacityKb(long value) {
        this.capacityKb = value;
    }

}
