
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PodStorageDrsEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PodStorageDrsEntry">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="storageDrsConfig" type="{urn:vim25}StorageDrsConfigInfo"/>
 *         &lt;element name="recommendation" type="{urn:vim25}ClusterRecommendation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="drsFault" type="{urn:vim25}ClusterDrsFaults" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="actionHistory" type="{urn:vim25}ClusterActionHistory" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PodStorageDrsEntry", propOrder = {
    "storageDrsConfig",
    "recommendation",
    "drsFault",
    "actionHistory"
})
public class PodStorageDrsEntry
    extends DynamicData
{

    @XmlElement(required = true)
    protected StorageDrsConfigInfo storageDrsConfig;
    protected List<ClusterRecommendation> recommendation;
    protected List<ClusterDrsFaults> drsFault;
    protected List<ClusterActionHistory> actionHistory;

    /**
     * Gets the value of the storageDrsConfig property.
     * 
     * @return
     *     possible object is
     *     {@link StorageDrsConfigInfo }
     *     
     */
    public StorageDrsConfigInfo getStorageDrsConfig() {
        return storageDrsConfig;
    }

    /**
     * Sets the value of the storageDrsConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageDrsConfigInfo }
     *     
     */
    public void setStorageDrsConfig(StorageDrsConfigInfo value) {
        this.storageDrsConfig = value;
    }

    /**
     * Gets the value of the recommendation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recommendation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecommendation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterRecommendation }
     * 
     * 
     */
    public List<ClusterRecommendation> getRecommendation() {
        if (recommendation == null) {
            recommendation = new ArrayList<ClusterRecommendation>();
        }
        return this.recommendation;
    }

    /**
     * Gets the value of the drsFault property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the drsFault property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDrsFault().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterDrsFaults }
     * 
     * 
     */
    public List<ClusterDrsFaults> getDrsFault() {
        if (drsFault == null) {
            drsFault = new ArrayList<ClusterDrsFaults>();
        }
        return this.drsFault;
    }

    /**
     * Gets the value of the actionHistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actionHistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActionHistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterActionHistory }
     * 
     * 
     */
    public List<ClusterActionHistory> getActionHistory() {
        if (actionHistory == null) {
            actionHistory = new ArrayList<ClusterActionHistory>();
        }
        return this.actionHistory;
    }

}
