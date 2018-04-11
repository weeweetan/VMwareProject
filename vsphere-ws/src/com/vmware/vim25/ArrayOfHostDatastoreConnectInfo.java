
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostDatastoreConnectInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostDatastoreConnectInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostDatastoreConnectInfo" type="{urn:vim25}HostDatastoreConnectInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostDatastoreConnectInfo", propOrder = {
    "hostDatastoreConnectInfo"
})
public class ArrayOfHostDatastoreConnectInfo {

    @XmlElement(name = "HostDatastoreConnectInfo")
    protected List<HostDatastoreConnectInfo> hostDatastoreConnectInfo;

    /**
     * Gets the value of the hostDatastoreConnectInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostDatastoreConnectInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostDatastoreConnectInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostDatastoreConnectInfo }
     * 
     * 
     */
    public List<HostDatastoreConnectInfo> getHostDatastoreConnectInfo() {
        if (hostDatastoreConnectInfo == null) {
            hostDatastoreConnectInfo = new ArrayList<HostDatastoreConnectInfo>();
        }
        return this.hostDatastoreConnectInfo;
    }

}
