
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostUnresolvedVmfsResolutionResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostUnresolvedVmfsResolutionResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostUnresolvedVmfsResolutionResult" type="{urn:vim25}HostUnresolvedVmfsResolutionResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostUnresolvedVmfsResolutionResult", propOrder = {
    "hostUnresolvedVmfsResolutionResult"
})
public class ArrayOfHostUnresolvedVmfsResolutionResult {

    @XmlElement(name = "HostUnresolvedVmfsResolutionResult")
    protected List<HostUnresolvedVmfsResolutionResult> hostUnresolvedVmfsResolutionResult;

    /**
     * Gets the value of the hostUnresolvedVmfsResolutionResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostUnresolvedVmfsResolutionResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostUnresolvedVmfsResolutionResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostUnresolvedVmfsResolutionResult }
     * 
     * 
     */
    public List<HostUnresolvedVmfsResolutionResult> getHostUnresolvedVmfsResolutionResult() {
        if (hostUnresolvedVmfsResolutionResult == null) {
            hostUnresolvedVmfsResolutionResult = new ArrayList<HostUnresolvedVmfsResolutionResult>();
        }
        return this.hostUnresolvedVmfsResolutionResult;
    }

}
