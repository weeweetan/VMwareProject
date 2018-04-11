
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostBootDevice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostBootDevice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostBootDevice" type="{urn:vim25}HostBootDevice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostBootDevice", propOrder = {
    "hostBootDevice"
})
public class ArrayOfHostBootDevice {

    @XmlElement(name = "HostBootDevice")
    protected List<HostBootDevice> hostBootDevice;

    /**
     * Gets the value of the hostBootDevice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostBootDevice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostBootDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostBootDevice }
     * 
     * 
     */
    public List<HostBootDevice> getHostBootDevice() {
        if (hostBootDevice == null) {
            hostBootDevice = new ArrayList<HostBootDevice>();
        }
        return this.hostBootDevice;
    }

}
