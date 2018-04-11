
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDistributedVirtualSwitchHostMemberConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDistributedVirtualSwitchHostMemberConfigSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DistributedVirtualSwitchHostMemberConfigSpec" type="{urn:vim25}DistributedVirtualSwitchHostMemberConfigSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDistributedVirtualSwitchHostMemberConfigSpec", propOrder = {
    "distributedVirtualSwitchHostMemberConfigSpec"
})
public class ArrayOfDistributedVirtualSwitchHostMemberConfigSpec {

    @XmlElement(name = "DistributedVirtualSwitchHostMemberConfigSpec")
    protected List<DistributedVirtualSwitchHostMemberConfigSpec> distributedVirtualSwitchHostMemberConfigSpec;

    /**
     * Gets the value of the distributedVirtualSwitchHostMemberConfigSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distributedVirtualSwitchHostMemberConfigSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistributedVirtualSwitchHostMemberConfigSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributedVirtualSwitchHostMemberConfigSpec }
     * 
     * 
     */
    public List<DistributedVirtualSwitchHostMemberConfigSpec> getDistributedVirtualSwitchHostMemberConfigSpec() {
        if (distributedVirtualSwitchHostMemberConfigSpec == null) {
            distributedVirtualSwitchHostMemberConfigSpec = new ArrayList<DistributedVirtualSwitchHostMemberConfigSpec>();
        }
        return this.distributedVirtualSwitchHostMemberConfigSpec;
    }

}
