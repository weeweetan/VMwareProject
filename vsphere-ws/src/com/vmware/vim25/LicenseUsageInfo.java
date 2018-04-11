
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LicenseUsageInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LicenseUsageInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="source" type="{urn:vim25}LicenseSource"/>
 *         &lt;element name="sourceAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="reservationInfo" type="{urn:vim25}LicenseReservationInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="featureInfo" type="{urn:vim25}LicenseFeatureInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LicenseUsageInfo", propOrder = {
    "source",
    "sourceAvailable",
    "reservationInfo",
    "featureInfo"
})
public class LicenseUsageInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected LicenseSource source;
    protected boolean sourceAvailable;
    protected List<LicenseReservationInfo> reservationInfo;
    protected List<LicenseFeatureInfo> featureInfo;

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseSource }
     *     
     */
    public LicenseSource getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseSource }
     *     
     */
    public void setSource(LicenseSource value) {
        this.source = value;
    }

    /**
     * Gets the value of the sourceAvailable property.
     * 
     */
    public boolean isSourceAvailable() {
        return sourceAvailable;
    }

    /**
     * Sets the value of the sourceAvailable property.
     * 
     */
    public void setSourceAvailable(boolean value) {
        this.sourceAvailable = value;
    }

    /**
     * Gets the value of the reservationInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reservationInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReservationInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LicenseReservationInfo }
     * 
     * 
     */
    public List<LicenseReservationInfo> getReservationInfo() {
        if (reservationInfo == null) {
            reservationInfo = new ArrayList<LicenseReservationInfo>();
        }
        return this.reservationInfo;
    }

    /**
     * Gets the value of the featureInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LicenseFeatureInfo }
     * 
     * 
     */
    public List<LicenseFeatureInfo> getFeatureInfo() {
        if (featureInfo == null) {
            featureInfo = new ArrayList<LicenseFeatureInfo>();
        }
        return this.featureInfo;
    }

}
