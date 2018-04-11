
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StoragePlacementResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StoragePlacementResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="recommendations" type="{urn:vim25}ClusterRecommendation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="drsFault" type="{urn:vim25}ClusterDrsFaults" minOccurs="0"/>
 *         &lt;element name="task" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoragePlacementResult", propOrder = {
    "recommendations",
    "drsFault",
    "task"
})
public class StoragePlacementResult
    extends DynamicData
{

    protected List<ClusterRecommendation> recommendations;
    protected ClusterDrsFaults drsFault;
    protected ManagedObjectReference task;

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
     * Gets the value of the drsFault property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterDrsFaults }
     *     
     */
    public ClusterDrsFaults getDrsFault() {
        return drsFault;
    }

    /**
     * Sets the value of the drsFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterDrsFaults }
     *     
     */
    public void setDrsFault(ClusterDrsFaults value) {
        this.drsFault = value;
    }

    /**
     * Gets the value of the task property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getTask() {
        return task;
    }

    /**
     * Sets the value of the task property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setTask(ManagedObjectReference value) {
        this.task = value;
    }

}
