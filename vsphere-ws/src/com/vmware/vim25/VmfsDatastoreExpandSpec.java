
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmfsDatastoreExpandSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmfsDatastoreExpandSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmfsDatastoreSpec">
 *       &lt;sequence>
 *         &lt;element name="partition" type="{urn:vim25}HostDiskPartitionSpec"/>
 *         &lt;element name="extent" type="{urn:vim25}HostScsiDiskPartition"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmfsDatastoreExpandSpec", propOrder = {
    "partition",
    "extent"
})
public class VmfsDatastoreExpandSpec
    extends VmfsDatastoreSpec
{

    @XmlElement(required = true)
    protected HostDiskPartitionSpec partition;
    @XmlElement(required = true)
    protected HostScsiDiskPartition extent;

    /**
     * Gets the value of the partition property.
     * 
     * @return
     *     possible object is
     *     {@link HostDiskPartitionSpec }
     *     
     */
    public HostDiskPartitionSpec getPartition() {
        return partition;
    }

    /**
     * Sets the value of the partition property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostDiskPartitionSpec }
     *     
     */
    public void setPartition(HostDiskPartitionSpec value) {
        this.partition = value;
    }

    /**
     * Gets the value of the extent property.
     * 
     * @return
     *     possible object is
     *     {@link HostScsiDiskPartition }
     *     
     */
    public HostScsiDiskPartition getExtent() {
        return extent;
    }

    /**
     * Sets the value of the extent property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostScsiDiskPartition }
     *     
     */
    public void setExtent(HostScsiDiskPartition value) {
        this.extent = value;
    }

}
