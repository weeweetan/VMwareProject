
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerfEntityMetric complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerfEntityMetric">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}PerfEntityMetricBase">
 *       &lt;sequence>
 *         &lt;element name="sampleInfo" type="{urn:vim25}PerfSampleInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="value" type="{urn:vim25}PerfMetricSeries" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerfEntityMetric", propOrder = {
    "sampleInfo",
    "value"
})
public class PerfEntityMetric
    extends PerfEntityMetricBase
{

    protected List<PerfSampleInfo> sampleInfo;
    protected List<PerfMetricSeries> value;

    /**
     * Gets the value of the sampleInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sampleInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSampleInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerfSampleInfo }
     * 
     * 
     */
    public List<PerfSampleInfo> getSampleInfo() {
        if (sampleInfo == null) {
            sampleInfo = new ArrayList<PerfSampleInfo>();
        }
        return this.sampleInfo;
    }

    /**
     * Gets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerfMetricSeries }
     * 
     * 
     */
    public List<PerfMetricSeries> getValue() {
        if (value == null) {
            value = new ArrayList<PerfMetricSeries>();
        }
        return this.value;
    }

}
