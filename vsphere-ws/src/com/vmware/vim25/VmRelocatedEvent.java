
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmRelocatedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmRelocatedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmRelocateSpecEvent">
 *       &lt;sequence>
 *         &lt;element name="sourceHost" type="{urn:vim25}HostEventArgument"/>
 *         &lt;element name="sourceDatacenter" type="{urn:vim25}DatacenterEventArgument" minOccurs="0"/>
 *         &lt;element name="sourceDatastore" type="{urn:vim25}DatastoreEventArgument" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmRelocatedEvent", propOrder = {
    "sourceHost",
    "sourceDatacenter",
    "sourceDatastore"
})
public class VmRelocatedEvent
    extends VmRelocateSpecEvent
{

    @XmlElement(required = true)
    protected HostEventArgument sourceHost;
    protected DatacenterEventArgument sourceDatacenter;
    protected DatastoreEventArgument sourceDatastore;

    /**
     * Gets the value of the sourceHost property.
     * 
     * @return
     *     possible object is
     *     {@link HostEventArgument }
     *     
     */
    public HostEventArgument getSourceHost() {
        return sourceHost;
    }

    /**
     * Sets the value of the sourceHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostEventArgument }
     *     
     */
    public void setSourceHost(HostEventArgument value) {
        this.sourceHost = value;
    }

    /**
     * Gets the value of the sourceDatacenter property.
     * 
     * @return
     *     possible object is
     *     {@link DatacenterEventArgument }
     *     
     */
    public DatacenterEventArgument getSourceDatacenter() {
        return sourceDatacenter;
    }

    /**
     * Sets the value of the sourceDatacenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatacenterEventArgument }
     *     
     */
    public void setSourceDatacenter(DatacenterEventArgument value) {
        this.sourceDatacenter = value;
    }

    /**
     * Gets the value of the sourceDatastore property.
     * 
     * @return
     *     possible object is
     *     {@link DatastoreEventArgument }
     *     
     */
    public DatastoreEventArgument getSourceDatastore() {
        return sourceDatastore;
    }

    /**
     * Sets the value of the sourceDatastore property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatastoreEventArgument }
     *     
     */
    public void setSourceDatastore(DatastoreEventArgument value) {
        this.sourceDatastore = value;
    }

}
