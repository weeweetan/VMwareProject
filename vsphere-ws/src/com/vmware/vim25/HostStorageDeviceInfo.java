
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostStorageDeviceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostStorageDeviceInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="hostBusAdapter" type="{urn:vim25}HostHostBusAdapter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="scsiLun" type="{urn:vim25}ScsiLun" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="scsiTopology" type="{urn:vim25}HostScsiTopology" minOccurs="0"/>
 *         &lt;element name="multipathInfo" type="{urn:vim25}HostMultipathInfo" minOccurs="0"/>
 *         &lt;element name="plugStoreTopology" type="{urn:vim25}HostPlugStoreTopology" minOccurs="0"/>
 *         &lt;element name="softwareInternetScsiEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostStorageDeviceInfo", propOrder = {
    "hostBusAdapter",
    "scsiLun",
    "scsiTopology",
    "multipathInfo",
    "plugStoreTopology",
    "softwareInternetScsiEnabled"
})
public class HostStorageDeviceInfo
    extends DynamicData
{

    protected List<HostHostBusAdapter> hostBusAdapter;
    protected List<ScsiLun> scsiLun;
    protected HostScsiTopology scsiTopology;
    protected HostMultipathInfo multipathInfo;
    protected HostPlugStoreTopology plugStoreTopology;
    protected boolean softwareInternetScsiEnabled;

    /**
     * Gets the value of the hostBusAdapter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostBusAdapter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostBusAdapter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostHostBusAdapter }
     * 
     * 
     */
    public List<HostHostBusAdapter> getHostBusAdapter() {
        if (hostBusAdapter == null) {
            hostBusAdapter = new ArrayList<HostHostBusAdapter>();
        }
        return this.hostBusAdapter;
    }

    /**
     * Gets the value of the scsiLun property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scsiLun property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScsiLun().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScsiLun }
     * 
     * 
     */
    public List<ScsiLun> getScsiLun() {
        if (scsiLun == null) {
            scsiLun = new ArrayList<ScsiLun>();
        }
        return this.scsiLun;
    }

    /**
     * Gets the value of the scsiTopology property.
     * 
     * @return
     *     possible object is
     *     {@link HostScsiTopology }
     *     
     */
    public HostScsiTopology getScsiTopology() {
        return scsiTopology;
    }

    /**
     * Sets the value of the scsiTopology property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostScsiTopology }
     *     
     */
    public void setScsiTopology(HostScsiTopology value) {
        this.scsiTopology = value;
    }

    /**
     * Gets the value of the multipathInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostMultipathInfo }
     *     
     */
    public HostMultipathInfo getMultipathInfo() {
        return multipathInfo;
    }

    /**
     * Sets the value of the multipathInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostMultipathInfo }
     *     
     */
    public void setMultipathInfo(HostMultipathInfo value) {
        this.multipathInfo = value;
    }

    /**
     * Gets the value of the plugStoreTopology property.
     * 
     * @return
     *     possible object is
     *     {@link HostPlugStoreTopology }
     *     
     */
    public HostPlugStoreTopology getPlugStoreTopology() {
        return plugStoreTopology;
    }

    /**
     * Sets the value of the plugStoreTopology property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostPlugStoreTopology }
     *     
     */
    public void setPlugStoreTopology(HostPlugStoreTopology value) {
        this.plugStoreTopology = value;
    }

    /**
     * Gets the value of the softwareInternetScsiEnabled property.
     * 
     */
    public boolean isSoftwareInternetScsiEnabled() {
        return softwareInternetScsiEnabled;
    }

    /**
     * Sets the value of the softwareInternetScsiEnabled property.
     * 
     */
    public void setSoftwareInternetScsiEnabled(boolean value) {
        this.softwareInternetScsiEnabled = value;
    }

}
