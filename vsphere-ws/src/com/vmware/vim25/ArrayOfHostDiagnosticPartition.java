
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostDiagnosticPartition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostDiagnosticPartition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostDiagnosticPartition" type="{urn:vim25}HostDiagnosticPartition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostDiagnosticPartition", propOrder = {
    "hostDiagnosticPartition"
})
public class ArrayOfHostDiagnosticPartition {

    @XmlElement(name = "HostDiagnosticPartition")
    protected List<HostDiagnosticPartition> hostDiagnosticPartition;

    /**
     * Gets the value of the hostDiagnosticPartition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostDiagnosticPartition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostDiagnosticPartition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostDiagnosticPartition }
     * 
     * 
     */
    public List<HostDiagnosticPartition> getHostDiagnosticPartition() {
        if (hostDiagnosticPartition == null) {
            hostDiagnosticPartition = new ArrayList<HostDiagnosticPartition>();
        }
        return this.hostDiagnosticPartition;
    }

}
