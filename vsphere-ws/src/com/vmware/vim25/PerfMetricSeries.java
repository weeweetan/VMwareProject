
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerfMetricSeries complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerfMetricSeries">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="id" type="{urn:vim25}PerfMetricId"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerfMetricSeries", propOrder = {
    "id"
})
@XmlSeeAlso({
    PerfMetricIntSeries.class,
    PerfMetricSeriesCSV.class
})
public class PerfMetricSeries
    extends DynamicData
{

    @XmlElement(required = true)
    protected PerfMetricId id;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link PerfMetricId }
     *     
     */
    public PerfMetricId getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerfMetricId }
     *     
     */
    public void setId(PerfMetricId value) {
        this.id = value;
    }

}
