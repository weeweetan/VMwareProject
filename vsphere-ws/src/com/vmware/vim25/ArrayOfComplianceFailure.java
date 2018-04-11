
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfComplianceFailure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfComplianceFailure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ComplianceFailure" type="{urn:vim25}ComplianceFailure" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfComplianceFailure", propOrder = {
    "complianceFailure"
})
public class ArrayOfComplianceFailure {

    @XmlElement(name = "ComplianceFailure")
    protected List<ComplianceFailure> complianceFailure;

    /**
     * Gets the value of the complianceFailure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complianceFailure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplianceFailure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComplianceFailure }
     * 
     * 
     */
    public List<ComplianceFailure> getComplianceFailure() {
        if (complianceFailure == null) {
            complianceFailure = new ArrayList<ComplianceFailure>();
        }
        return this.complianceFailure;
    }

}
