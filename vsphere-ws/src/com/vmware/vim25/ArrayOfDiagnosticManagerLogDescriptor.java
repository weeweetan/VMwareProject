
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDiagnosticManagerLogDescriptor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDiagnosticManagerLogDescriptor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DiagnosticManagerLogDescriptor" type="{urn:vim25}DiagnosticManagerLogDescriptor" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDiagnosticManagerLogDescriptor", propOrder = {
    "diagnosticManagerLogDescriptor"
})
public class ArrayOfDiagnosticManagerLogDescriptor {

    @XmlElement(name = "DiagnosticManagerLogDescriptor")
    protected List<DiagnosticManagerLogDescriptor> diagnosticManagerLogDescriptor;

    /**
     * Gets the value of the diagnosticManagerLogDescriptor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the diagnosticManagerLogDescriptor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiagnosticManagerLogDescriptor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiagnosticManagerLogDescriptor }
     * 
     * 
     */
    public List<DiagnosticManagerLogDescriptor> getDiagnosticManagerLogDescriptor() {
        if (diagnosticManagerLogDescriptor == null) {
            diagnosticManagerLogDescriptor = new ArrayList<DiagnosticManagerLogDescriptor>();
        }
        return this.diagnosticManagerLogDescriptor;
    }

}
