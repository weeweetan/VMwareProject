
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostUnresolvedVmfsVolume complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostUnresolvedVmfsVolume">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostUnresolvedVmfsVolume" type="{urn:vim25}HostUnresolvedVmfsVolume" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostUnresolvedVmfsVolume", propOrder = {
    "hostUnresolvedVmfsVolume"
})
public class ArrayOfHostUnresolvedVmfsVolume {

    @XmlElement(name = "HostUnresolvedVmfsVolume")
    protected List<HostUnresolvedVmfsVolume> hostUnresolvedVmfsVolume;

    /**
     * Gets the value of the hostUnresolvedVmfsVolume property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostUnresolvedVmfsVolume property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostUnresolvedVmfsVolume().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostUnresolvedVmfsVolume }
     * 
     * 
     */
    public List<HostUnresolvedVmfsVolume> getHostUnresolvedVmfsVolume() {
        if (hostUnresolvedVmfsVolume == null) {
            hostUnresolvedVmfsVolume = new ArrayList<HostUnresolvedVmfsVolume>();
        }
        return this.hostUnresolvedVmfsVolume;
    }

}
