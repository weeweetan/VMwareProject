
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostScsiDisk complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostScsiDisk">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostScsiDisk" type="{urn:vim25}HostScsiDisk" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostScsiDisk", propOrder = {
    "hostScsiDisk"
})
public class ArrayOfHostScsiDisk {

    @XmlElement(name = "HostScsiDisk")
    protected List<HostScsiDisk> hostScsiDisk;

    /**
     * Gets the value of the hostScsiDisk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostScsiDisk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostScsiDisk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostScsiDisk }
     * 
     * 
     */
    public List<HostScsiDisk> getHostScsiDisk() {
        if (hostScsiDisk == null) {
            hostScsiDisk = new ArrayList<HostScsiDisk>();
        }
        return this.hostScsiDisk;
    }

}
