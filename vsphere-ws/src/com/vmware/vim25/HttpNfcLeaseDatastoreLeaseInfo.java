
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HttpNfcLeaseDatastoreLeaseInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HttpNfcLeaseDatastoreLeaseInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="datastoreKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hosts" type="{urn:vim25}HttpNfcLeaseHostInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HttpNfcLeaseDatastoreLeaseInfo", propOrder = {
    "datastoreKey",
    "hosts"
})
public class HttpNfcLeaseDatastoreLeaseInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String datastoreKey;
    @XmlElement(required = true)
    protected List<HttpNfcLeaseHostInfo> hosts;

    /**
     * Gets the value of the datastoreKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatastoreKey() {
        return datastoreKey;
    }

    /**
     * Sets the value of the datastoreKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatastoreKey(String value) {
        this.datastoreKey = value;
    }

    /**
     * Gets the value of the hosts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hosts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHosts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HttpNfcLeaseHostInfo }
     * 
     * 
     */
    public List<HttpNfcLeaseHostInfo> getHosts() {
        if (hosts == null) {
            hosts = new ArrayList<HttpNfcLeaseHostInfo>();
        }
        return this.hosts;
    }

}
