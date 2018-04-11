
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDistributedVirtualSwitchProductSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDistributedVirtualSwitchProductSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DistributedVirtualSwitchProductSpec" type="{urn:vim25}DistributedVirtualSwitchProductSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDistributedVirtualSwitchProductSpec", propOrder = {
    "distributedVirtualSwitchProductSpec"
})
public class ArrayOfDistributedVirtualSwitchProductSpec {

    @XmlElement(name = "DistributedVirtualSwitchProductSpec")
    protected List<DistributedVirtualSwitchProductSpec> distributedVirtualSwitchProductSpec;

    /**
     * Gets the value of the distributedVirtualSwitchProductSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distributedVirtualSwitchProductSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistributedVirtualSwitchProductSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributedVirtualSwitchProductSpec }
     * 
     * 
     */
    public List<DistributedVirtualSwitchProductSpec> getDistributedVirtualSwitchProductSpec() {
        if (distributedVirtualSwitchProductSpec == null) {
            distributedVirtualSwitchProductSpec = new ArrayList<DistributedVirtualSwitchProductSpec>();
        }
        return this.distributedVirtualSwitchProductSpec;
    }

}
