
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HttpNfcLeaseInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HttpNfcLeaseInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="lease" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="entity" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="deviceUrl" type="{urn:vim25}HttpNfcLeaseDeviceUrl" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="totalDiskCapacityInKB" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="leaseTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hostMap" type="{urn:vim25}HttpNfcLeaseDatastoreLeaseInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HttpNfcLeaseInfo", propOrder = {
    "lease",
    "entity",
    "deviceUrl",
    "totalDiskCapacityInKB",
    "leaseTimeout",
    "hostMap"
})
public class HttpNfcLeaseInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference lease;
    @XmlElement(required = true)
    protected ManagedObjectReference entity;
    protected List<HttpNfcLeaseDeviceUrl> deviceUrl;
    protected long totalDiskCapacityInKB;
    protected int leaseTimeout;
    protected List<HttpNfcLeaseDatastoreLeaseInfo> hostMap;

    /**
     * Gets the value of the lease property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getLease() {
        return lease;
    }

    /**
     * Sets the value of the lease property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setLease(ManagedObjectReference value) {
        this.lease = value;
    }

    /**
     * Gets the value of the entity property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getEntity() {
        return entity;
    }

    /**
     * Sets the value of the entity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setEntity(ManagedObjectReference value) {
        this.entity = value;
    }

    /**
     * Gets the value of the deviceUrl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deviceUrl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeviceUrl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HttpNfcLeaseDeviceUrl }
     * 
     * 
     */
    public List<HttpNfcLeaseDeviceUrl> getDeviceUrl() {
        if (deviceUrl == null) {
            deviceUrl = new ArrayList<HttpNfcLeaseDeviceUrl>();
        }
        return this.deviceUrl;
    }

    /**
     * Gets the value of the totalDiskCapacityInKB property.
     * 
     */
    public long getTotalDiskCapacityInKB() {
        return totalDiskCapacityInKB;
    }

    /**
     * Sets the value of the totalDiskCapacityInKB property.
     * 
     */
    public void setTotalDiskCapacityInKB(long value) {
        this.totalDiskCapacityInKB = value;
    }

    /**
     * Gets the value of the leaseTimeout property.
     * 
     */
    public int getLeaseTimeout() {
        return leaseTimeout;
    }

    /**
     * Sets the value of the leaseTimeout property.
     * 
     */
    public void setLeaseTimeout(int value) {
        this.leaseTimeout = value;
    }

    /**
     * Gets the value of the hostMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HttpNfcLeaseDatastoreLeaseInfo }
     * 
     * 
     */
    public List<HttpNfcLeaseDatastoreLeaseInfo> getHostMap() {
        if (hostMap == null) {
            hostMap = new ArrayList<HttpNfcLeaseDatastoreLeaseInfo>();
        }
        return this.hostMap;
    }

}
