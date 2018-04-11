
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostPciPassthruInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostPciPassthruInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostPciPassthruInfo" type="{urn:vim25}HostPciPassthruInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostPciPassthruInfo", propOrder = {
    "hostPciPassthruInfo"
})
public class ArrayOfHostPciPassthruInfo {

    @XmlElement(name = "HostPciPassthruInfo")
    protected List<HostPciPassthruInfo> hostPciPassthruInfo;

    /**
     * Gets the value of the hostPciPassthruInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostPciPassthruInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostPciPassthruInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPciPassthruInfo }
     * 
     * 
     */
    public List<HostPciPassthruInfo> getHostPciPassthruInfo() {
        if (hostPciPassthruInfo == null) {
            hostPciPassthruInfo = new ArrayList<HostPciPassthruInfo>();
        }
        return this.hostPciPassthruInfo;
    }

}
