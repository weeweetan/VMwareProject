
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StoragePerformanceSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StoragePerformanceSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="interval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="percentile" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/>
 *         &lt;element name="datastoreReadLatency" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
 *         &lt;element name="datastoreWriteLatency" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
 *         &lt;element name="datastoreVmLatency" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
 *         &lt;element name="datastoreReadIops" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
 *         &lt;element name="datastoreWriteIops" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
 *         &lt;element name="siocActivityDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoragePerformanceSummary", propOrder = {
    "interval",
    "percentile",
    "datastoreReadLatency",
    "datastoreWriteLatency",
    "datastoreVmLatency",
    "datastoreReadIops",
    "datastoreWriteIops",
    "siocActivityDuration"
})
public class StoragePerformanceSummary
    extends DynamicData
{

    protected int interval;
    @XmlElement(type = Integer.class)
    protected List<Integer> percentile;
    @XmlElement(type = Double.class)
    protected List<Double> datastoreReadLatency;
    @XmlElement(type = Double.class)
    protected List<Double> datastoreWriteLatency;
    @XmlElement(type = Double.class)
    protected List<Double> datastoreVmLatency;
    @XmlElement(type = Double.class)
    protected List<Double> datastoreReadIops;
    @XmlElement(type = Double.class)
    protected List<Double> datastoreWriteIops;
    protected int siocActivityDuration;

    /**
     * Gets the value of the interval property.
     * 
     */
    public int getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     */
    public void setInterval(int value) {
        this.interval = value;
    }

    /**
     * Gets the value of the percentile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the percentile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPercentile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getPercentile() {
        if (percentile == null) {
            percentile = new ArrayList<Integer>();
        }
        return this.percentile;
    }

    /**
     * Gets the value of the datastoreReadLatency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datastoreReadLatency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatastoreReadLatency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getDatastoreReadLatency() {
        if (datastoreReadLatency == null) {
            datastoreReadLatency = new ArrayList<Double>();
        }
        return this.datastoreReadLatency;
    }

    /**
     * Gets the value of the datastoreWriteLatency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datastoreWriteLatency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatastoreWriteLatency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getDatastoreWriteLatency() {
        if (datastoreWriteLatency == null) {
            datastoreWriteLatency = new ArrayList<Double>();
        }
        return this.datastoreWriteLatency;
    }

    /**
     * Gets the value of the datastoreVmLatency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datastoreVmLatency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatastoreVmLatency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getDatastoreVmLatency() {
        if (datastoreVmLatency == null) {
            datastoreVmLatency = new ArrayList<Double>();
        }
        return this.datastoreVmLatency;
    }

    /**
     * Gets the value of the datastoreReadIops property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datastoreReadIops property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatastoreReadIops().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getDatastoreReadIops() {
        if (datastoreReadIops == null) {
            datastoreReadIops = new ArrayList<Double>();
        }
        return this.datastoreReadIops;
    }

    /**
     * Gets the value of the datastoreWriteIops property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datastoreWriteIops property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatastoreWriteIops().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getDatastoreWriteIops() {
        if (datastoreWriteIops == null) {
            datastoreWriteIops = new ArrayList<Double>();
        }
        return this.datastoreWriteIops;
    }

    /**
     * Gets the value of the siocActivityDuration property.
     * 
     */
    public int getSiocActivityDuration() {
        return siocActivityDuration;
    }

    /**
     * Sets the value of the siocActivityDuration property.
     * 
     */
    public void setSiocActivityDuration(int value) {
        this.siocActivityDuration = value;
    }

}
