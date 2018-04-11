
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostScsiTopologyLun complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostScsiTopologyLun">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostScsiTopologyLun" type="{urn:vim25}HostScsiTopologyLun" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostScsiTopologyLun", propOrder = {
    "hostScsiTopologyLun"
})
public class ArrayOfHostScsiTopologyLun {

    @XmlElement(name = "HostScsiTopologyLun")
    protected List<HostScsiTopologyLun> hostScsiTopologyLun;

    /**
     * Gets the value of the hostScsiTopologyLun property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostScsiTopologyLun property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostScsiTopologyLun().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostScsiTopologyLun }
     * 
     * 
     */
    public List<HostScsiTopologyLun> getHostScsiTopologyLun() {
        if (hostScsiTopologyLun == null) {
            hostScsiTopologyLun = new ArrayList<HostScsiTopologyLun>();
        }
        return this.hostScsiTopologyLun;
    }

}
