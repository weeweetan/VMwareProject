
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostDiskPartitionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostDiskPartitionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostDiskPartitionInfo" type="{urn:vim25}HostDiskPartitionInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostDiskPartitionInfo", propOrder = {
    "hostDiskPartitionInfo"
})
public class ArrayOfHostDiskPartitionInfo {

    @XmlElement(name = "HostDiskPartitionInfo")
    protected List<HostDiskPartitionInfo> hostDiskPartitionInfo;

    /**
     * Gets the value of the hostDiskPartitionInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostDiskPartitionInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostDiskPartitionInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostDiskPartitionInfo }
     * 
     * 
     */
    public List<HostDiskPartitionInfo> getHostDiskPartitionInfo() {
        if (hostDiskPartitionInfo == null) {
            hostDiskPartitionInfo = new ArrayList<HostDiskPartitionInfo>();
        }
        return this.hostDiskPartitionInfo;
    }

}
