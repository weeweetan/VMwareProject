
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPerfEntityMetricBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPerfEntityMetricBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PerfEntityMetricBase" type="{urn:vim25}PerfEntityMetricBase" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPerfEntityMetricBase", propOrder = {
    "perfEntityMetricBase"
})
public class ArrayOfPerfEntityMetricBase {

    @XmlElement(name = "PerfEntityMetricBase")
    protected List<PerfEntityMetricBase> perfEntityMetricBase;

    /**
     * Gets the value of the perfEntityMetricBase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the perfEntityMetricBase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerfEntityMetricBase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerfEntityMetricBase }
     * 
     * 
     */
    public List<PerfEntityMetricBase> getPerfEntityMetricBase() {
        if (perfEntityMetricBase == null) {
            perfEntityMetricBase = new ArrayList<PerfEntityMetricBase>();
        }
        return this.perfEntityMetricBase;
    }

}
