
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterDrsFaultsFaultsByVirtualDisk complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterDrsFaultsFaultsByVirtualDisk">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterDrsFaultsFaultsByVm">
 *       &lt;sequence>
 *         &lt;element name="disk" type="{urn:vim25}VirtualDiskId" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterDrsFaultsFaultsByVirtualDisk", propOrder = {
    "disk"
})
public class ClusterDrsFaultsFaultsByVirtualDisk
    extends ClusterDrsFaultsFaultsByVm
{

    protected VirtualDiskId disk;

    /**
     * Gets the value of the disk property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualDiskId }
     *     
     */
    public VirtualDiskId getDisk() {
        return disk;
    }

    /**
     * Sets the value of the disk property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualDiskId }
     *     
     */
    public void setDisk(VirtualDiskId value) {
        this.disk = value;
    }

}
