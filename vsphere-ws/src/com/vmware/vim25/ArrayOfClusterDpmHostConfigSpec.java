
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClusterDpmHostConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClusterDpmHostConfigSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClusterDpmHostConfigSpec" type="{urn:vim25}ClusterDpmHostConfigSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClusterDpmHostConfigSpec", propOrder = {
    "clusterDpmHostConfigSpec"
})
public class ArrayOfClusterDpmHostConfigSpec {

    @XmlElement(name = "ClusterDpmHostConfigSpec")
    protected List<ClusterDpmHostConfigSpec> clusterDpmHostConfigSpec;

    /**
     * Gets the value of the clusterDpmHostConfigSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clusterDpmHostConfigSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClusterDpmHostConfigSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterDpmHostConfigSpec }
     * 
     * 
     */
    public List<ClusterDpmHostConfigSpec> getClusterDpmHostConfigSpec() {
        if (clusterDpmHostConfigSpec == null) {
            clusterDpmHostConfigSpec = new ArrayList<ClusterDpmHostConfigSpec>();
        }
        return this.clusterDpmHostConfigSpec;
    }

}
