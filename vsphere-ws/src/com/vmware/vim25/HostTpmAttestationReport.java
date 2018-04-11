
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostTpmAttestationReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostTpmAttestationReport">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="tpmPcrValues" type="{urn:vim25}HostTpmDigestInfo" maxOccurs="unbounded"/>
 *         &lt;element name="tpmEvents" type="{urn:vim25}HostTpmEventLogEntry" maxOccurs="unbounded"/>
 *         &lt;element name="tpmLogReliable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostTpmAttestationReport", propOrder = {
    "tpmPcrValues",
    "tpmEvents",
    "tpmLogReliable"
})
public class HostTpmAttestationReport
    extends DynamicData
{

    @XmlElement(required = true)
    protected List<HostTpmDigestInfo> tpmPcrValues;
    @XmlElement(required = true)
    protected List<HostTpmEventLogEntry> tpmEvents;
    protected boolean tpmLogReliable;

    /**
     * Gets the value of the tpmPcrValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tpmPcrValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTpmPcrValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostTpmDigestInfo }
     * 
     * 
     */
    public List<HostTpmDigestInfo> getTpmPcrValues() {
        if (tpmPcrValues == null) {
            tpmPcrValues = new ArrayList<HostTpmDigestInfo>();
        }
        return this.tpmPcrValues;
    }

    /**
     * Gets the value of the tpmEvents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tpmEvents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTpmEvents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostTpmEventLogEntry }
     * 
     * 
     */
    public List<HostTpmEventLogEntry> getTpmEvents() {
        if (tpmEvents == null) {
            tpmEvents = new ArrayList<HostTpmEventLogEntry>();
        }
        return this.tpmEvents;
    }

    /**
     * Gets the value of the tpmLogReliable property.
     * 
     */
    public boolean isTpmLogReliable() {
        return tpmLogReliable;
    }

    /**
     * Sets the value of the tpmLogReliable property.
     * 
     */
    public void setTpmLogReliable(boolean value) {
        this.tpmLogReliable = value;
    }

}
