
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClusterDpmHostConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClusterDpmHostConfigInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClusterDpmHostConfigInfo" type="{urn:vim25}ClusterDpmHostConfigInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClusterDpmHostConfigInfo", propOrder = {
    "clusterDpmHostConfigInfo"
})
public class ArrayOfClusterDpmHostConfigInfo {

    @XmlElement(name = "ClusterDpmHostConfigInfo")
    protected List<ClusterDpmHostConfigInfo> clusterDpmHostConfigInfo;

    /**
     * Gets the value of the clusterDpmHostConfigInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clusterDpmHostConfigInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClusterDpmHostConfigInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterDpmHostConfigInfo }
     * 
     * 
     */
    public List<ClusterDpmHostConfigInfo> getClusterDpmHostConfigInfo() {
        if (clusterDpmHostConfigInfo == null) {
            clusterDpmHostConfigInfo = new ArrayList<ClusterDpmHostConfigInfo>();
        }
        return this.clusterDpmHostConfigInfo;
    }

}
