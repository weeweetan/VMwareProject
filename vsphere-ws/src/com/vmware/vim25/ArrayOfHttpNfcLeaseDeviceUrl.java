
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHttpNfcLeaseDeviceUrl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHttpNfcLeaseDeviceUrl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HttpNfcLeaseDeviceUrl" type="{urn:vim25}HttpNfcLeaseDeviceUrl" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHttpNfcLeaseDeviceUrl", propOrder = {
    "httpNfcLeaseDeviceUrl"
})
public class ArrayOfHttpNfcLeaseDeviceUrl {

    @XmlElement(name = "HttpNfcLeaseDeviceUrl")
    protected List<HttpNfcLeaseDeviceUrl> httpNfcLeaseDeviceUrl;

    /**
     * Gets the value of the httpNfcLeaseDeviceUrl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the httpNfcLeaseDeviceUrl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHttpNfcLeaseDeviceUrl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HttpNfcLeaseDeviceUrl }
     * 
     * 
     */
    public List<HttpNfcLeaseDeviceUrl> getHttpNfcLeaseDeviceUrl() {
        if (httpNfcLeaseDeviceUrl == null) {
            httpNfcLeaseDeviceUrl = new ArrayList<HttpNfcLeaseDeviceUrl>();
        }
        return this.httpNfcLeaseDeviceUrl;
    }

}
