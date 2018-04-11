
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostUnresolvedVmfsResolutionSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostUnresolvedVmfsResolutionSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostUnresolvedVmfsResolutionSpec" type="{urn:vim25}HostUnresolvedVmfsResolutionSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostUnresolvedVmfsResolutionSpec", propOrder = {
    "hostUnresolvedVmfsResolutionSpec"
})
public class ArrayOfHostUnresolvedVmfsResolutionSpec {

    @XmlElement(name = "HostUnresolvedVmfsResolutionSpec")
    protected List<HostUnresolvedVmfsResolutionSpec> hostUnresolvedVmfsResolutionSpec;

    /**
     * Gets the value of the hostUnresolvedVmfsResolutionSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostUnresolvedVmfsResolutionSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostUnresolvedVmfsResolutionSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostUnresolvedVmfsResolutionSpec }
     * 
     * 
     */
    public List<HostUnresolvedVmfsResolutionSpec> getHostUnresolvedVmfsResolutionSpec() {
        if (hostUnresolvedVmfsResolutionSpec == null) {
            hostUnresolvedVmfsResolutionSpec = new ArrayList<HostUnresolvedVmfsResolutionSpec>();
        }
        return this.hostUnresolvedVmfsResolutionSpec;
    }

}
