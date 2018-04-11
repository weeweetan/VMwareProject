
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPerformanceManagerCounterLevelMapping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPerformanceManagerCounterLevelMapping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PerformanceManagerCounterLevelMapping" type="{urn:vim25}PerformanceManagerCounterLevelMapping" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPerformanceManagerCounterLevelMapping", propOrder = {
    "performanceManagerCounterLevelMapping"
})
public class ArrayOfPerformanceManagerCounterLevelMapping {

    @XmlElement(name = "PerformanceManagerCounterLevelMapping")
    protected List<PerformanceManagerCounterLevelMapping> performanceManagerCounterLevelMapping;

    /**
     * Gets the value of the performanceManagerCounterLevelMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the performanceManagerCounterLevelMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerformanceManagerCounterLevelMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerformanceManagerCounterLevelMapping }
     * 
     * 
     */
    public List<PerformanceManagerCounterLevelMapping> getPerformanceManagerCounterLevelMapping() {
        if (performanceManagerCounterLevelMapping == null) {
            performanceManagerCounterLevelMapping = new ArrayList<PerformanceManagerCounterLevelMapping>();
        }
        return this.performanceManagerCounterLevelMapping;
    }

}
