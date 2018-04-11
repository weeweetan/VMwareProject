
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostLowLevelProvisioningManagerDiskLayoutSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostLowLevelProvisioningManagerDiskLayoutSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostLowLevelProvisioningManagerDiskLayoutSpec" type="{urn:vim25}HostLowLevelProvisioningManagerDiskLayoutSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostLowLevelProvisioningManagerDiskLayoutSpec", propOrder = {
    "hostLowLevelProvisioningManagerDiskLayoutSpec"
})
public class ArrayOfHostLowLevelProvisioningManagerDiskLayoutSpec {

    @XmlElement(name = "HostLowLevelProvisioningManagerDiskLayoutSpec")
    protected List<HostLowLevelProvisioningManagerDiskLayoutSpec> hostLowLevelProvisioningManagerDiskLayoutSpec;

    /**
     * Gets the value of the hostLowLevelProvisioningManagerDiskLayoutSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostLowLevelProvisioningManagerDiskLayoutSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostLowLevelProvisioningManagerDiskLayoutSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostLowLevelProvisioningManagerDiskLayoutSpec }
     * 
     * 
     */
    public List<HostLowLevelProvisioningManagerDiskLayoutSpec> getHostLowLevelProvisioningManagerDiskLayoutSpec() {
        if (hostLowLevelProvisioningManagerDiskLayoutSpec == null) {
            hostLowLevelProvisioningManagerDiskLayoutSpec = new ArrayList<HostLowLevelProvisioningManagerDiskLayoutSpec>();
        }
        return this.hostLowLevelProvisioningManagerDiskLayoutSpec;
    }

}
