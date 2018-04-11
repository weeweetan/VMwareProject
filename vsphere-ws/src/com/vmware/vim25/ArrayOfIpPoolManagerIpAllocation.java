
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfIpPoolManagerIpAllocation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfIpPoolManagerIpAllocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IpPoolManagerIpAllocation" type="{urn:vim25}IpPoolManagerIpAllocation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfIpPoolManagerIpAllocation", propOrder = {
    "ipPoolManagerIpAllocation"
})
public class ArrayOfIpPoolManagerIpAllocation {

    @XmlElement(name = "IpPoolManagerIpAllocation")
    protected List<IpPoolManagerIpAllocation> ipPoolManagerIpAllocation;

    /**
     * Gets the value of the ipPoolManagerIpAllocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipPoolManagerIpAllocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIpPoolManagerIpAllocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IpPoolManagerIpAllocation }
     * 
     * 
     */
    public List<IpPoolManagerIpAllocation> getIpPoolManagerIpAllocation() {
        if (ipPoolManagerIpAllocation == null) {
            ipPoolManagerIpAllocation = new ArrayList<IpPoolManagerIpAllocation>();
        }
        return this.ipPoolManagerIpAllocation;
    }

}
