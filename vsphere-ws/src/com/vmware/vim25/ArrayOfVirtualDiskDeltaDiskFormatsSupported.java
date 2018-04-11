
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualDiskDeltaDiskFormatsSupported complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualDiskDeltaDiskFormatsSupported">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualDiskDeltaDiskFormatsSupported" type="{urn:vim25}VirtualDiskDeltaDiskFormatsSupported" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualDiskDeltaDiskFormatsSupported", propOrder = {
    "virtualDiskDeltaDiskFormatsSupported"
})
public class ArrayOfVirtualDiskDeltaDiskFormatsSupported {

    @XmlElement(name = "VirtualDiskDeltaDiskFormatsSupported")
    protected List<VirtualDiskDeltaDiskFormatsSupported> virtualDiskDeltaDiskFormatsSupported;

    /**
     * Gets the value of the virtualDiskDeltaDiskFormatsSupported property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualDiskDeltaDiskFormatsSupported property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualDiskDeltaDiskFormatsSupported().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualDiskDeltaDiskFormatsSupported }
     * 
     * 
     */
    public List<VirtualDiskDeltaDiskFormatsSupported> getVirtualDiskDeltaDiskFormatsSupported() {
        if (virtualDiskDeltaDiskFormatsSupported == null) {
            virtualDiskDeltaDiskFormatsSupported = new ArrayList<VirtualDiskDeltaDiskFormatsSupported>();
        }
        return this.virtualDiskDeltaDiskFormatsSupported;
    }

}
