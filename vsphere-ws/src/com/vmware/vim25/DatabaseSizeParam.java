
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatabaseSizeParam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatabaseSizeParam">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="inventoryDesc" type="{urn:vim25}InventoryDescription"/>
 *         &lt;element name="perfStatsDesc" type="{urn:vim25}PerformanceStatisticsDescription" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatabaseSizeParam", propOrder = {
    "inventoryDesc",
    "perfStatsDesc"
})
public class DatabaseSizeParam
    extends DynamicData
{

    @XmlElement(required = true)
    protected InventoryDescription inventoryDesc;
    protected PerformanceStatisticsDescription perfStatsDesc;

    /**
     * Gets the value of the inventoryDesc property.
     * 
     * @return
     *     possible object is
     *     {@link InventoryDescription }
     *     
     */
    public InventoryDescription getInventoryDesc() {
        return inventoryDesc;
    }

    /**
     * Sets the value of the inventoryDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link InventoryDescription }
     *     
     */
    public void setInventoryDesc(InventoryDescription value) {
        this.inventoryDesc = value;
    }

    /**
     * Gets the value of the perfStatsDesc property.
     * 
     * @return
     *     possible object is
     *     {@link PerformanceStatisticsDescription }
     *     
     */
    public PerformanceStatisticsDescription getPerfStatsDesc() {
        return perfStatsDesc;
    }

    /**
     * Sets the value of the perfStatsDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerformanceStatisticsDescription }
     *     
     */
    public void setPerfStatsDesc(PerformanceStatisticsDescription value) {
        this.perfStatsDesc = value;
    }

}
