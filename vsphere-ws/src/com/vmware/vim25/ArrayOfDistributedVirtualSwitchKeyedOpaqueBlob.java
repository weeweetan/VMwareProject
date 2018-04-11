
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDistributedVirtualSwitchKeyedOpaqueBlob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDistributedVirtualSwitchKeyedOpaqueBlob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DistributedVirtualSwitchKeyedOpaqueBlob" type="{urn:vim25}DistributedVirtualSwitchKeyedOpaqueBlob" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDistributedVirtualSwitchKeyedOpaqueBlob", propOrder = {
    "distributedVirtualSwitchKeyedOpaqueBlob"
})
public class ArrayOfDistributedVirtualSwitchKeyedOpaqueBlob {

    @XmlElement(name = "DistributedVirtualSwitchKeyedOpaqueBlob")
    protected List<DistributedVirtualSwitchKeyedOpaqueBlob> distributedVirtualSwitchKeyedOpaqueBlob;

    /**
     * Gets the value of the distributedVirtualSwitchKeyedOpaqueBlob property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distributedVirtualSwitchKeyedOpaqueBlob property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistributedVirtualSwitchKeyedOpaqueBlob().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributedVirtualSwitchKeyedOpaqueBlob }
     * 
     * 
     */
    public List<DistributedVirtualSwitchKeyedOpaqueBlob> getDistributedVirtualSwitchKeyedOpaqueBlob() {
        if (distributedVirtualSwitchKeyedOpaqueBlob == null) {
            distributedVirtualSwitchKeyedOpaqueBlob = new ArrayList<DistributedVirtualSwitchKeyedOpaqueBlob>();
        }
        return this.distributedVirtualSwitchKeyedOpaqueBlob;
    }

}
