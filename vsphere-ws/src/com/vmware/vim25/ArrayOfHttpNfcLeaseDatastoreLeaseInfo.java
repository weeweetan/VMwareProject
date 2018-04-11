
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHttpNfcLeaseDatastoreLeaseInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHttpNfcLeaseDatastoreLeaseInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HttpNfcLeaseDatastoreLeaseInfo" type="{urn:vim25}HttpNfcLeaseDatastoreLeaseInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHttpNfcLeaseDatastoreLeaseInfo", propOrder = {
    "httpNfcLeaseDatastoreLeaseInfo"
})
public class ArrayOfHttpNfcLeaseDatastoreLeaseInfo {

    @XmlElement(name = "HttpNfcLeaseDatastoreLeaseInfo")
    protected List<HttpNfcLeaseDatastoreLeaseInfo> httpNfcLeaseDatastoreLeaseInfo;

    /**
     * Gets the value of the httpNfcLeaseDatastoreLeaseInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the httpNfcLeaseDatastoreLeaseInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHttpNfcLeaseDatastoreLeaseInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HttpNfcLeaseDatastoreLeaseInfo }
     * 
     * 
     */
    public List<HttpNfcLeaseDatastoreLeaseInfo> getHttpNfcLeaseDatastoreLeaseInfo() {
        if (httpNfcLeaseDatastoreLeaseInfo == null) {
            httpNfcLeaseDatastoreLeaseInfo = new ArrayList<HttpNfcLeaseDatastoreLeaseInfo>();
        }
        return this.httpNfcLeaseDatastoreLeaseInfo;
    }

}
