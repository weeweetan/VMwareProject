
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfNetIpConfigInfoIpAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfNetIpConfigInfoIpAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NetIpConfigInfoIpAddress" type="{urn:vim25}NetIpConfigInfoIpAddress" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfNetIpConfigInfoIpAddress", propOrder = {
    "netIpConfigInfoIpAddress"
})
public class ArrayOfNetIpConfigInfoIpAddress {

    @XmlElement(name = "NetIpConfigInfoIpAddress")
    protected List<NetIpConfigInfoIpAddress> netIpConfigInfoIpAddress;

    /**
     * Gets the value of the netIpConfigInfoIpAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the netIpConfigInfoIpAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetIpConfigInfoIpAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NetIpConfigInfoIpAddress }
     * 
     * 
     */
    public List<NetIpConfigInfoIpAddress> getNetIpConfigInfoIpAddress() {
        if (netIpConfigInfoIpAddress == null) {
            netIpConfigInfoIpAddress = new ArrayList<NetIpConfigInfoIpAddress>();
        }
        return this.netIpConfigInfoIpAddress;
    }

}
