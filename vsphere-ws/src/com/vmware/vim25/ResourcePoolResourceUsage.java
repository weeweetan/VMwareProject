
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResourcePoolResourceUsage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourcePoolResourceUsage">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="reservationUsed" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="reservationUsedForVm" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="unreservedForPool" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="unreservedForVm" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="overallUsage" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="maxUsage" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourcePoolResourceUsage", propOrder = {
    "reservationUsed",
    "reservationUsedForVm",
    "unreservedForPool",
    "unreservedForVm",
    "overallUsage",
    "maxUsage"
})
public class ResourcePoolResourceUsage
    extends DynamicData
{

    protected long reservationUsed;
    protected long reservationUsedForVm;
    protected long unreservedForPool;
    protected long unreservedForVm;
    protected long overallUsage;
    protected long maxUsage;

    /**
     * Gets the value of the reservationUsed property.
     * 
     */
    public long getReservationUsed() {
        return reservationUsed;
    }

    /**
     * Sets the value of the reservationUsed property.
     * 
     */
    public void setReservationUsed(long value) {
        this.reservationUsed = value;
    }

    /**
     * Gets the value of the reservationUsedForVm property.
     * 
     */
    public long getReservationUsedForVm() {
        return reservationUsedForVm;
    }

    /**
     * Sets the value of the reservationUsedForVm property.
     * 
     */
    public void setReservationUsedForVm(long value) {
        this.reservationUsedForVm = value;
    }

    /**
     * Gets the value of the unreservedForPool property.
     * 
     */
    public long getUnreservedForPool() {
        return unreservedForPool;
    }

    /**
     * Sets the value of the unreservedForPool property.
     * 
     */
    public void setUnreservedForPool(long value) {
        this.unreservedForPool = value;
    }

    /**
     * Gets the value of the unreservedForVm property.
     * 
     */
    public long getUnreservedForVm() {
        return unreservedForVm;
    }

    /**
     * Sets the value of the unreservedForVm property.
     * 
     */
    public void setUnreservedForVm(long value) {
        this.unreservedForVm = value;
    }

    /**
     * Gets the value of the overallUsage property.
     * 
     */
    public long getOverallUsage() {
        return overallUsage;
    }

    /**
     * Sets the value of the overallUsage property.
     * 
     */
    public void setOverallUsage(long value) {
        this.overallUsage = value;
    }

    /**
     * Gets the value of the maxUsage property.
     * 
     */
    public long getMaxUsage() {
        return maxUsage;
    }

    /**
     * Sets the value of the maxUsage property.
     * 
     */
    public void setMaxUsage(long value) {
        this.maxUsage = value;
    }

}
