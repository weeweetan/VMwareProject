
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerfEntityMetricCSV complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerfEntityMetricCSV">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}PerfEntityMetricBase">
 *       &lt;sequence>
 *         &lt;element name="sampleInfoCSV" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="value" type="{urn:vim25}PerfMetricSeriesCSV" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerfEntityMetricCSV", propOrder = {
    "sampleInfoCSV",
    "value"
})
public class PerfEntityMetricCSV
    extends PerfEntityMetricBase
{

    @XmlElement(required = true)
    protected String sampleInfoCSV;
    protected List<PerfMetricSeriesCSV> value;

    /**
     * Gets the value of the sampleInfoCSV property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSampleInfoCSV() {
        return sampleInfoCSV;
    }

    /**
     * Sets the value of the sampleInfoCSV property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSampleInfoCSV(String value) {
        this.sampleInfoCSV = value;
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
     * {@link PerfMetricSeriesCSV }
     * 
     * 
     */
    public List<PerfMetricSeriesCSV> getValue() {
        if (value == null) {
            value = new ArrayList<PerfMetricSeriesCSV>();
        }
        return this.value;
    }

}
