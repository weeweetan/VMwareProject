
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDiskPartitionLayout complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDiskPartitionLayout">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="total" type="{urn:vim25}HostDiskDimensionsLba" minOccurs="0"/>
 *         &lt;element name="partition" type="{urn:vim25}HostDiskPartitionBlockRange" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDiskPartitionLayout", propOrder = {
    "total",
    "partition"
})
public class HostDiskPartitionLayout
    extends DynamicData
{

    protected HostDiskDimensionsLba total;
    @XmlElement(required = true)
    protected List<HostDiskPartitionBlockRange> partition;

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link HostDiskDimensionsLba }
     *     
     */
    public HostDiskDimensionsLba getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostDiskDimensionsLba }
     *     
     */
    public void setTotal(HostDiskDimensionsLba value) {
        this.total = value;
    }

    /**
     * Gets the value of the partition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostDiskPartitionBlockRange }
     * 
     * 
     */
    public List<HostDiskPartitionBlockRange> getPartition() {
        if (partition == null) {
            partition = new ArrayList<HostDiskPartitionBlockRange>();
        }
        return this.partition;
    }

}
