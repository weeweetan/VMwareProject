
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClusterFailoverHostAdmissionControlInfoHostStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClusterFailoverHostAdmissionControlInfoHostStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClusterFailoverHostAdmissionControlInfoHostStatus" type="{urn:vim25}ClusterFailoverHostAdmissionControlInfoHostStatus" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClusterFailoverHostAdmissionControlInfoHostStatus", propOrder = {
    "clusterFailoverHostAdmissionControlInfoHostStatus"
})
public class ArrayOfClusterFailoverHostAdmissionControlInfoHostStatus {

    @XmlElement(name = "ClusterFailoverHostAdmissionControlInfoHostStatus")
    protected List<ClusterFailoverHostAdmissionControlInfoHostStatus> clusterFailoverHostAdmissionControlInfoHostStatus;

    /**
     * Gets the value of the clusterFailoverHostAdmissionControlInfoHostStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clusterFailoverHostAdmissionControlInfoHostStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClusterFailoverHostAdmissionControlInfoHostStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterFailoverHostAdmissionControlInfoHostStatus }
     * 
     * 
     */
    public List<ClusterFailoverHostAdmissionControlInfoHostStatus> getClusterFailoverHostAdmissionControlInfoHostStatus() {
        if (clusterFailoverHostAdmissionControlInfoHostStatus == null) {
            clusterFailoverHostAdmissionControlInfoHostStatus = new ArrayList<ClusterFailoverHostAdmissionControlInfoHostStatus>();
        }
        return this.clusterFailoverHostAdmissionControlInfoHostStatus;
    }

}
