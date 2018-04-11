
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClusterDrsMigration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClusterDrsMigration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClusterDrsMigration" type="{urn:vim25}ClusterDrsMigration" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClusterDrsMigration", propOrder = {
    "clusterDrsMigration"
})
public class ArrayOfClusterDrsMigration {

    @XmlElement(name = "ClusterDrsMigration")
    protected List<ClusterDrsMigration> clusterDrsMigration;

    /**
     * Gets the value of the clusterDrsMigration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clusterDrsMigration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClusterDrsMigration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterDrsMigration }
     * 
     * 
     */
    public List<ClusterDrsMigration> getClusterDrsMigration() {
        if (clusterDrsMigration == null) {
            clusterDrsMigration = new ArrayList<ClusterDrsMigration>();
        }
        return this.clusterDrsMigration;
    }

}
