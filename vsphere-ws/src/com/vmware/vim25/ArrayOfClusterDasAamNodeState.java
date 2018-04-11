
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClusterDasAamNodeState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClusterDasAamNodeState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClusterDasAamNodeState" type="{urn:vim25}ClusterDasAamNodeState" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClusterDasAamNodeState", propOrder = {
    "clusterDasAamNodeState"
})
public class ArrayOfClusterDasAamNodeState {

    @XmlElement(name = "ClusterDasAamNodeState")
    protected List<ClusterDasAamNodeState> clusterDasAamNodeState;

    /**
     * Gets the value of the clusterDasAamNodeState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clusterDasAamNodeState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClusterDasAamNodeState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterDasAamNodeState }
     * 
     * 
     */
    public List<ClusterDasAamNodeState> getClusterDasAamNodeState() {
        if (clusterDasAamNodeState == null) {
            clusterDasAamNodeState = new ArrayList<ClusterDasAamNodeState>();
        }
        return this.clusterDasAamNodeState;
    }

}
