
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostStorageElementInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostStorageElementInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostStorageElementInfo" type="{urn:vim25}HostStorageElementInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostStorageElementInfo", propOrder = {
    "hostStorageElementInfo"
})
public class ArrayOfHostStorageElementInfo {

    @XmlElement(name = "HostStorageElementInfo")
    protected List<HostStorageElementInfo> hostStorageElementInfo;

    /**
     * Gets the value of the hostStorageElementInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostStorageElementInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostStorageElementInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostStorageElementInfo }
     * 
     * 
     */
    public List<HostStorageElementInfo> getHostStorageElementInfo() {
        if (hostStorageElementInfo == null) {
            hostStorageElementInfo = new ArrayList<HostStorageElementInfo>();
        }
        return this.hostStorageElementInfo;
    }

}
