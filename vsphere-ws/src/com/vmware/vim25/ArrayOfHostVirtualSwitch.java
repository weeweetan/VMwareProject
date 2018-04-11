
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostVirtualSwitch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostVirtualSwitch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostVirtualSwitch" type="{urn:vim25}HostVirtualSwitch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostVirtualSwitch", propOrder = {
    "hostVirtualSwitch"
})
public class ArrayOfHostVirtualSwitch {

    @XmlElement(name = "HostVirtualSwitch")
    protected List<HostVirtualSwitch> hostVirtualSwitch;

    /**
     * Gets the value of the hostVirtualSwitch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostVirtualSwitch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostVirtualSwitch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostVirtualSwitch }
     * 
     * 
     */
    public List<HostVirtualSwitch> getHostVirtualSwitch() {
        if (hostVirtualSwitch == null) {
            hostVirtualSwitch = new ArrayList<HostVirtualSwitch>();
        }
        return this.hostVirtualSwitch;
    }

}
