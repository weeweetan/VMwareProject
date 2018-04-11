
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostIpConfigIpV6Address complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostIpConfigIpV6Address">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostIpConfigIpV6Address" type="{urn:vim25}HostIpConfigIpV6Address" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostIpConfigIpV6Address", propOrder = {
    "hostIpConfigIpV6Address"
})
public class ArrayOfHostIpConfigIpV6Address {

    @XmlElement(name = "HostIpConfigIpV6Address")
    protected List<HostIpConfigIpV6Address> hostIpConfigIpV6Address;

    /**
     * Gets the value of the hostIpConfigIpV6Address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostIpConfigIpV6Address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostIpConfigIpV6Address().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostIpConfigIpV6Address }
     * 
     * 
     */
    public List<HostIpConfigIpV6Address> getHostIpConfigIpV6Address() {
        if (hostIpConfigIpV6Address == null) {
            hostIpConfigIpV6Address = new ArrayList<HostIpConfigIpV6Address>();
        }
        return this.hostIpConfigIpV6Address;
    }

}
