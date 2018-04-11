
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmfsDatastoreCreateSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmfsDatastoreCreateSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmfsDatastoreSpec">
 *       &lt;sequence>
 *         &lt;element name="partition" type="{urn:vim25}HostDiskPartitionSpec"/>
 *         &lt;element name="vmfs" type="{urn:vim25}HostVmfsSpec"/>
 *         &lt;element name="extent" type="{urn:vim25}HostScsiDiskPartition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmfsDatastoreCreateSpec", propOrder = {
    "partition",
    "vmfs",
    "extent"
})
public class VmfsDatastoreCreateSpec
    extends VmfsDatastoreSpec
{

    @XmlElement(required = true)
    protected HostDiskPartitionSpec partition;
    @XmlElement(required = true)
    protected HostVmfsSpec vmfs;
    protected List<HostScsiDiskPartition> extent;

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
     * Gets the value of the vmfs property.
     * 
     * @return
     *     possible object is
     *     {@link HostVmfsSpec }
     *     
     */
    public HostVmfsSpec getVmfs() {
        return vmfs;
    }

    /**
     * Sets the value of the vmfs property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostVmfsSpec }
     *     
     */
    public void setVmfs(HostVmfsSpec value) {
        this.vmfs = value;
    }

    /**
     * Gets the value of the extent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostScsiDiskPartition }
     * 
     * 
     */
    public List<HostScsiDiskPartition> getExtent() {
        if (extent == null) {
            extent = new ArrayList<HostScsiDiskPartition>();
        }
        return this.extent;
    }

}
