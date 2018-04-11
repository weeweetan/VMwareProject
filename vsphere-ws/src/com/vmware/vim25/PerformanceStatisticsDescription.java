
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerformanceStatisticsDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerformanceStatisticsDescription">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="intervals" type="{urn:vim25}PerfInterval" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerformanceStatisticsDescription", propOrder = {
    "intervals"
})
public class PerformanceStatisticsDescription
    extends DynamicData
{

    protected List<PerfInterval> intervals;

    /**
     * Gets the value of the intervals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intervals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntervals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerfInterval }
     * 
     * 
     */
    public List<PerfInterval> getIntervals() {
        if (intervals == null) {
            intervals = new ArrayList<PerfInterval>();
        }
        return this.intervals;
    }

}
