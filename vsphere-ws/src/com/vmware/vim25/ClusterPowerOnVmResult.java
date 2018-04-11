
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterPowerOnVmResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterPowerOnVmResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="attempted" type="{urn:vim25}ClusterAttemptedVmInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="notAttempted" type="{urn:vim25}ClusterNotAttemptedVmInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="recommendations" type="{urn:vim25}ClusterRecommendation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterPowerOnVmResult", propOrder = {
    "attempted",
    "notAttempted",
    "recommendations"
})
public class ClusterPowerOnVmResult
    extends DynamicData
{

    protected List<ClusterAttemptedVmInfo> attempted;
    protected List<ClusterNotAttemptedVmInfo> notAttempted;
    protected List<ClusterRecommendation> recommendations;

    /**
     * Gets the value of the attempted property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attempted property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttempted().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterAttemptedVmInfo }
     * 
     * 
     */
    public List<ClusterAttemptedVmInfo> getAttempted() {
        if (attempted == null) {
            attempted = new ArrayList<ClusterAttemptedVmInfo>();
        }
        return this.attempted;
    }

    /**
     * Gets the value of the notAttempted property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notAttempted property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotAttempted().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterNotAttemptedVmInfo }
     * 
     * 
     */
    public List<ClusterNotAttemptedVmInfo> getNotAttempted() {
        if (notAttempted == null) {
            notAttempted = new ArrayList<ClusterNotAttemptedVmInfo>();
        }
        return this.notAttempted;
    }

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

}
