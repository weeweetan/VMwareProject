
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostTpmEventLogEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostTpmEventLogEntry">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="pcrIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="eventDetails" type="{urn:vim25}HostTpmEventDetails"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostTpmEventLogEntry", propOrder = {
    "pcrIndex",
    "eventDetails"
})
public class HostTpmEventLogEntry
    extends DynamicData
{

    protected int pcrIndex;
    @XmlElement(required = true)
    protected HostTpmEventDetails eventDetails;

    /**
     * Gets the value of the pcrIndex property.
     * 
     */
    public int getPcrIndex() {
        return pcrIndex;
    }

    /**
     * Sets the value of the pcrIndex property.
     * 
     */
    public void setPcrIndex(int value) {
        this.pcrIndex = value;
    }

    /**
     * Gets the value of the eventDetails property.
     * 
     * @return
     *     possible object is
     *     {@link HostTpmEventDetails }
     *     
     */
    public HostTpmEventDetails getEventDetails() {
        return eventDetails;
    }

    /**
     * Sets the value of the eventDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostTpmEventDetails }
     *     
     */
    public void setEventDetails(HostTpmEventDetails value) {
        this.eventDetails = value;
    }

}
