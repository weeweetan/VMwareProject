
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPerfMetricSeries complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPerfMetricSeries">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PerfMetricSeries" type="{urn:vim25}PerfMetricSeries" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPerfMetricSeries", propOrder = {
    "perfMetricSeries"
})
public class ArrayOfPerfMetricSeries {

    @XmlElement(name = "PerfMetricSeries")
    protected List<PerfMetricSeries> perfMetricSeries;

    /**
     * Gets the value of the perfMetricSeries property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the perfMetricSeries property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerfMetricSeries().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerfMetricSeries }
     * 
     * 
     */
    public List<PerfMetricSeries> getPerfMetricSeries() {
        if (perfMetricSeries == null) {
            perfMetricSeries = new ArrayList<PerfMetricSeries>();
        }
        return this.perfMetricSeries;
    }

}
