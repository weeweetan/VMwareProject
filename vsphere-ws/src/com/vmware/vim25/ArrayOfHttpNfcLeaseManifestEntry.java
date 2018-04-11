
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHttpNfcLeaseManifestEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHttpNfcLeaseManifestEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HttpNfcLeaseManifestEntry" type="{urn:vim25}HttpNfcLeaseManifestEntry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHttpNfcLeaseManifestEntry", propOrder = {
    "httpNfcLeaseManifestEntry"
})
public class ArrayOfHttpNfcLeaseManifestEntry {

    @XmlElement(name = "HttpNfcLeaseManifestEntry")
    protected List<HttpNfcLeaseManifestEntry> httpNfcLeaseManifestEntry;

    /**
     * Gets the value of the httpNfcLeaseManifestEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the httpNfcLeaseManifestEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHttpNfcLeaseManifestEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HttpNfcLeaseManifestEntry }
     * 
     * 
     */
    public List<HttpNfcLeaseManifestEntry> getHttpNfcLeaseManifestEntry() {
        if (httpNfcLeaseManifestEntry == null) {
            httpNfcLeaseManifestEntry = new ArrayList<HttpNfcLeaseManifestEntry>();
        }
        return this.httpNfcLeaseManifestEntry;
    }

}
