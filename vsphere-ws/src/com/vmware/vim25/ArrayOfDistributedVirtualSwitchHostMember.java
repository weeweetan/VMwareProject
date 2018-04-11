
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDistributedVirtualSwitchHostMember complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDistributedVirtualSwitchHostMember">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DistributedVirtualSwitchHostMember" type="{urn:vim25}DistributedVirtualSwitchHostMember" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDistributedVirtualSwitchHostMember", propOrder = {
    "distributedVirtualSwitchHostMember"
})
public class ArrayOfDistributedVirtualSwitchHostMember {

    @XmlElement(name = "DistributedVirtualSwitchHostMember")
    protected List<DistributedVirtualSwitchHostMember> distributedVirtualSwitchHostMember;

    /**
     * Gets the value of the distributedVirtualSwitchHostMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distributedVirtualSwitchHostMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistributedVirtualSwitchHostMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributedVirtualSwitchHostMember }
     * 
     * 
     */
    public List<DistributedVirtualSwitchHostMember> getDistributedVirtualSwitchHostMember() {
        if (distributedVirtualSwitchHostMember == null) {
            distributedVirtualSwitchHostMember = new ArrayList<DistributedVirtualSwitchHostMember>();
        }
        return this.distributedVirtualSwitchHostMember;
    }

}
