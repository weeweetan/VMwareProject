
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerformanceDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerformanceDescription">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="counterType" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="statsType" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerformanceDescription", propOrder = {
    "counterType",
    "statsType"
})
public class PerformanceDescription
    extends DynamicData
{

    @XmlElement(required = true)
    protected List<ElementDescription> counterType;
    @XmlElement(required = true)
    protected List<ElementDescription> statsType;

    /**
     * Gets the value of the counterType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the counterType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCounterType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getCounterType() {
        if (counterType == null) {
            counterType = new ArrayList<ElementDescription>();
        }
        return this.counterType;
    }

    /**
     * Gets the value of the statsType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statsType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatsType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getStatsType() {
        if (statsType == null) {
            statsType = new ArrayList<ElementDescription>();
        }
        return this.statsType;
    }

}
