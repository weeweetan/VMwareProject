
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPerfMetricId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPerfMetricId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PerfMetricId" type="{urn:vim25}PerfMetricId" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPerfMetricId", propOrder = {
    "perfMetricId"
})
public class ArrayOfPerfMetricId {

    @XmlElement(name = "PerfMetricId")
    protected List<PerfMetricId> perfMetricId;

    /**
     * Gets the value of the perfMetricId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the perfMetricId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerfMetricId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerfMetricId }
     * 
     * 
     */
    public List<PerfMetricId> getPerfMetricId() {
        if (perfMetricId == null) {
            perfMetricId = new ArrayList<PerfMetricId>();
        }
        return this.perfMetricId;
    }

}
