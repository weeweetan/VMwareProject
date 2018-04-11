
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots" type="{urn:vim25}ClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots", propOrder = {
    "clusterDasFailoverLevelAdvancedRuntimeInfoVmSlots"
})
public class ArrayOfClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots {

    @XmlElement(name = "ClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots")
    protected List<ClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots> clusterDasFailoverLevelAdvancedRuntimeInfoVmSlots;

    /**
     * Gets the value of the clusterDasFailoverLevelAdvancedRuntimeInfoVmSlots property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clusterDasFailoverLevelAdvancedRuntimeInfoVmSlots property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots }
     * 
     * 
     */
    public List<ClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots> getClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots() {
        if (clusterDasFailoverLevelAdvancedRuntimeInfoVmSlots == null) {
            clusterDasFailoverLevelAdvancedRuntimeInfoVmSlots = new ArrayList<ClusterDasFailoverLevelAdvancedRuntimeInfoVmSlots>();
        }
        return this.clusterDasFailoverLevelAdvancedRuntimeInfoVmSlots;
    }

}
