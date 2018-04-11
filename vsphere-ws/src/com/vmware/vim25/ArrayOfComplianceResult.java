
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfComplianceResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfComplianceResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ComplianceResult" type="{urn:vim25}ComplianceResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfComplianceResult", propOrder = {
    "complianceResult"
})
public class ArrayOfComplianceResult {

    @XmlElement(name = "ComplianceResult")
    protected List<ComplianceResult> complianceResult;

    /**
     * Gets the value of the complianceResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complianceResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplianceResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComplianceResult }
     * 
     * 
     */
    public List<ComplianceResult> getComplianceResult() {
        if (complianceResult == null) {
            complianceResult = new ArrayList<ComplianceResult>();
        }
        return this.complianceResult;
    }

}
