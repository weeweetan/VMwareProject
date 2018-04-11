
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMultipleCertificatesVerifyFaultThumbprintData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMultipleCertificatesVerifyFaultThumbprintData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MultipleCertificatesVerifyFaultThumbprintData" type="{urn:vim25}MultipleCertificatesVerifyFaultThumbprintData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMultipleCertificatesVerifyFaultThumbprintData", propOrder = {
    "multipleCertificatesVerifyFaultThumbprintData"
})
public class ArrayOfMultipleCertificatesVerifyFaultThumbprintData {

    @XmlElement(name = "MultipleCertificatesVerifyFaultThumbprintData")
    protected List<MultipleCertificatesVerifyFaultThumbprintData> multipleCertificatesVerifyFaultThumbprintData;

    /**
     * Gets the value of the multipleCertificatesVerifyFaultThumbprintData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the multipleCertificatesVerifyFaultThumbprintData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMultipleCertificatesVerifyFaultThumbprintData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultipleCertificatesVerifyFaultThumbprintData }
     * 
     * 
     */
    public List<MultipleCertificatesVerifyFaultThumbprintData> getMultipleCertificatesVerifyFaultThumbprintData() {
        if (multipleCertificatesVerifyFaultThumbprintData == null) {
            multipleCertificatesVerifyFaultThumbprintData = new ArrayList<MultipleCertificatesVerifyFaultThumbprintData>();
        }
        return this.multipleCertificatesVerifyFaultThumbprintData;
    }

}
