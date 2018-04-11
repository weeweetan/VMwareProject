
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterEnterMaintenanceResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterEnterMaintenanceResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="recommendations" type="{urn:vim25}ClusterRecommendation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fault" type="{urn:vim25}ClusterDrsFaults" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterEnterMaintenanceResult", propOrder = {
    "recommendations",
    "fault"
})
public class ClusterEnterMaintenanceResult
    extends DynamicData
{

    protected List<ClusterRecommendation> recommendations;
    protected ClusterDrsFaults fault;

    /**
     * Gets the value of the recommendations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recommendations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecommendations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterRecommendation }
     * 
     * 
     */
    public List<ClusterRecommendation> getRecommendations() {
        if (recommendations == null) {
            recommendations = new ArrayList<ClusterRecommendation>();
        }
        return this.recommendations;
    }

    /**
     * Gets the value of the fault property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterDrsFaults }
     *     
     */
    public ClusterDrsFaults getFault() {
        return fault;
    }

    /**
     * Sets the value of the fault property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterDrsFaults }
     *     
     */
    public void setFault(ClusterDrsFaults value) {
        this.fault = value;
    }

}
