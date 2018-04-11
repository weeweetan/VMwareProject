
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerfCompositeMetric complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerfCompositeMetric">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="entity" type="{urn:vim25}PerfEntityMetricBase" minOccurs="0"/>
 *         &lt;element name="childEntity" type="{urn:vim25}PerfEntityMetricBase" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerfCompositeMetric", propOrder = {
    "entity",
    "childEntity"
})
public class PerfCompositeMetric
    extends DynamicData
{

    protected PerfEntityMetricBase entity;
    protected List<PerfEntityMetricBase> childEntity;

    /**
     * Gets the value of the entity property.
     * 
     * @return
     *     possible object is
     *     {@link PerfEntityMetricBase }
     *     
     */
    public PerfEntityMetricBase getEntity() {
        return entity;
    }

    /**
     * Sets the value of the entity property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerfEntityMetricBase }
     *     
     */
    public void setEntity(PerfEntityMetricBase value) {
        this.entity = value;
    }

    /**
     * Gets the value of the childEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerfEntityMetricBase }
     * 
     * 
     */
    public List<PerfEntityMetricBase> getChildEntity() {
        if (childEntity == null) {
            childEntity = new ArrayList<PerfEntityMetricBase>();
        }
        return this.childEntity;
    }

}
