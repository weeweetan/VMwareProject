
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostUnresolvedVmfsExtent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostUnresolvedVmfsExtent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostUnresolvedVmfsExtent" type="{urn:vim25}HostUnresolvedVmfsExtent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostUnresolvedVmfsExtent", propOrder = {
    "hostUnresolvedVmfsExtent"
})
public class ArrayOfHostUnresolvedVmfsExtent {

    @XmlElement(name = "HostUnresolvedVmfsExtent")
    protected List<HostUnresolvedVmfsExtent> hostUnresolvedVmfsExtent;

    /**
     * Gets the value of the hostUnresolvedVmfsExtent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostUnresolvedVmfsExtent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostUnresolvedVmfsExtent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostUnresolvedVmfsExtent }
     * 
     * 
     */
    public List<HostUnresolvedVmfsExtent> getHostUnresolvedVmfsExtent() {
        if (hostUnresolvedVmfsExtent == null) {
            hostUnresolvedVmfsExtent = new ArrayList<HostUnresolvedVmfsExtent>();
        }
        return this.hostUnresolvedVmfsExtent;
    }

}
