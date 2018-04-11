
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterFailoverHostAdmissionControlInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterFailoverHostAdmissionControlInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterDasAdmissionControlInfo">
 *       &lt;sequence>
 *         &lt;element name="hostStatus" type="{urn:vim25}ClusterFailoverHostAdmissionControlInfoHostStatus" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterFailoverHostAdmissionControlInfo", propOrder = {
    "hostStatus"
})
public class ClusterFailoverHostAdmissionControlInfo
    extends ClusterDasAdmissionControlInfo
{

    protected List<ClusterFailoverHostAdmissionControlInfoHostStatus> hostStatus;

    /**
     * Gets the value of the hostStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterFailoverHostAdmissionControlInfoHostStatus }
     * 
     * 
     */
    public List<ClusterFailoverHostAdmissionControlInfoHostStatus> getHostStatus() {
        if (hostStatus == null) {
            hostStatus = new ArrayList<ClusterFailoverHostAdmissionControlInfoHostStatus>();
        }
        return this.hostStatus;
    }

}
