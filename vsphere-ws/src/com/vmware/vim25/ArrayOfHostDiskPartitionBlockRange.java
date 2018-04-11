
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostDiskPartitionBlockRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostDiskPartitionBlockRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostDiskPartitionBlockRange" type="{urn:vim25}HostDiskPartitionBlockRange" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostDiskPartitionBlockRange", propOrder = {
    "hostDiskPartitionBlockRange"
})
public class ArrayOfHostDiskPartitionBlockRange {

    @XmlElement(name = "HostDiskPartitionBlockRange")
    protected List<HostDiskPartitionBlockRange> hostDiskPartitionBlockRange;

    /**
     * Gets the value of the hostDiskPartitionBlockRange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostDiskPartitionBlockRange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostDiskPartitionBlockRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostDiskPartitionBlockRange }
     * 
     * 
     */
    public List<HostDiskPartitionBlockRange> getHostDiskPartitionBlockRange() {
        if (hostDiskPartitionBlockRange == null) {
            hostDiskPartitionBlockRange = new ArrayList<HostDiskPartitionBlockRange>();
        }
        return this.hostDiskPartitionBlockRange;
    }

}
