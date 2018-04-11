
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostPciDevice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostPciDevice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostPciDevice" type="{urn:vim25}HostPciDevice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostPciDevice", propOrder = {
    "hostPciDevice"
})
public class ArrayOfHostPciDevice {

    @XmlElement(name = "HostPciDevice")
    protected List<HostPciDevice> hostPciDevice;

    /**
     * Gets the value of the hostPciDevice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostPciDevice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostPciDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPciDevice }
     * 
     * 
     */
    public List<HostPciDevice> getHostPciDevice() {
        if (hostPciDevice == null) {
            hostPciDevice = new ArrayList<HostPciDevice>();
        }
        return this.hostPciDevice;
    }

}
