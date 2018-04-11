
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmBeingMigratedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmBeingMigratedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="destHost" type="{urn:vim25}HostEventArgument"/>
 *         &lt;element name="destDatacenter" type="{urn:vim25}DatacenterEventArgument" minOccurs="0"/>
 *         &lt;element name="destDatastore" type="{urn:vim25}DatastoreEventArgument" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmBeingMigratedEvent", propOrder = {
    "destHost",
    "destDatacenter",
    "destDatastore"
})
public class VmBeingMigratedEvent
    extends VmEvent
{

    @XmlElement(required = true)
    protected HostEventArgument destHost;
    protected DatacenterEventArgument destDatacenter;
    protected DatastoreEventArgument destDatastore;

    /**
     * Gets the value of the destHost property.
     * 
     * @return
     *     possible object is
     *     {@link HostEventArgument }
     *     
     */
    public HostEventArgument getDestHost() {
        return destHost;
    }

    /**
     * Sets the value of the destHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostEventArgument }
     *     
     */
    public void setDestHost(HostEventArgument value) {
        this.destHost = value;
    }

    /**
     * Gets the value of the destDatacenter property.
     * 
     * @return
     *     possible object is
     *     {@link DatacenterEventArgument }
     *     
     */
    public DatacenterEventArgument getDestDatacenter() {
        return destDatacenter;
    }

    /**
     * Sets the value of the destDatacenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatacenterEventArgument }
     *     
     */
    public void setDestDatacenter(DatacenterEventArgument value) {
        this.destDatacenter = value;
    }

    /**
     * Gets the value of the destDatastore property.
     * 
     * @return
     *     possible object is
     *     {@link DatastoreEventArgument }
     *     
     */
    public DatastoreEventArgument getDestDatastore() {
        return destDatastore;
    }

    /**
     * Sets the value of the destDatastore property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatastoreEventArgument }
     *     
     */
    public void setDestDatastore(DatastoreEventArgument value) {
        this.destDatastore = value;
    }

}
