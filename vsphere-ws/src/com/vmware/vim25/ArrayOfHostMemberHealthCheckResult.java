
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostMemberHealthCheckResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostMemberHealthCheckResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostMemberHealthCheckResult" type="{urn:vim25}HostMemberHealthCheckResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostMemberHealthCheckResult", propOrder = {
    "hostMemberHealthCheckResult"
})
public class ArrayOfHostMemberHealthCheckResult {

    @XmlElement(name = "HostMemberHealthCheckResult")
    protected List<HostMemberHealthCheckResult> hostMemberHealthCheckResult;

    /**
     * Gets the value of the hostMemberHealthCheckResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostMemberHealthCheckResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostMemberHealthCheckResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostMemberHealthCheckResult }
     * 
     * 
     */
    public List<HostMemberHealthCheckResult> getHostMemberHealthCheckResult() {
        if (hostMemberHealthCheckResult == null) {
            hostMemberHealthCheckResult = new ArrayList<HostMemberHealthCheckResult>();
        }
        return this.hostMemberHealthCheckResult;
    }

}
