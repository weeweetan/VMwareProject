
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots" type="{urn:vim25}ClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots", propOrder = {
    "clusterDasFailoverLevelAdvancedRuntimeInfoHostSlots"
})
public class ArrayOfClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots {

    @XmlElement(name = "ClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots")
    protected List<ClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots> clusterDasFailoverLevelAdvancedRuntimeInfoHostSlots;

    /**
     * Gets the value of the clusterDasFailoverLevelAdvancedRuntimeInfoHostSlots property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clusterDasFailoverLevelAdvancedRuntimeInfoHostSlots property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots }
     * 
     * 
     */
    public List<ClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots> getClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots() {
        if (clusterDasFailoverLevelAdvancedRuntimeInfoHostSlots == null) {
            clusterDasFailoverLevelAdvancedRuntimeInfoHostSlots = new ArrayList<ClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots>();
        }
        return this.clusterDasFailoverLevelAdvancedRuntimeInfoHostSlots;
    }

}
