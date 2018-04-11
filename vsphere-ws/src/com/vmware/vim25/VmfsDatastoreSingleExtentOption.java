
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmfsDatastoreSingleExtentOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmfsDatastoreSingleExtentOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmfsDatastoreBaseOption">
 *       &lt;sequence>
 *         &lt;element name="vmfsExtent" type="{urn:vim25}HostDiskPartitionBlockRange"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmfsDatastoreSingleExtentOption", propOrder = {
    "vmfsExtent"
})
@XmlSeeAlso({
    VmfsDatastoreAllExtentOption.class
})
public class VmfsDatastoreSingleExtentOption
    extends VmfsDatastoreBaseOption
{

    @XmlElement(required = true)
    protected HostDiskPartitionBlockRange vmfsExtent;

    /**
     * Gets the value of the vmfsExtent property.
     * 
     * @return
     *     possible object is
     *     {@link HostDiskPartitionBlockRange }
     *     
     */
    public HostDiskPartitionBlockRange getVmfsExtent() {
        return vmfsExtent;
    }

    /**
     * Sets the value of the vmfsExtent property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostDiskPartitionBlockRange }
     *     
     */
    public void setVmfsExtent(HostDiskPartitionBlockRange value) {
        this.vmfsExtent = value;
    }

}
