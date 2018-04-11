
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostFileSystemMountInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostFileSystemMountInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostFileSystemMountInfo" type="{urn:vim25}HostFileSystemMountInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostFileSystemMountInfo", propOrder = {
    "hostFileSystemMountInfo"
})
public class ArrayOfHostFileSystemMountInfo {

    @XmlElement(name = "HostFileSystemMountInfo")
    protected List<HostFileSystemMountInfo> hostFileSystemMountInfo;

    /**
     * Gets the value of the hostFileSystemMountInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostFileSystemMountInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostFileSystemMountInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostFileSystemMountInfo }
     * 
     * 
     */
    public List<HostFileSystemMountInfo> getHostFileSystemMountInfo() {
        if (hostFileSystemMountInfo == null) {
            hostFileSystemMountInfo = new ArrayList<HostFileSystemMountInfo>();
        }
        return this.hostFileSystemMountInfo;
    }

}
