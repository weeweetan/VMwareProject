
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmDiskFailedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmDiskFailedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="disk" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reason" type="{urn:vim25}LocalizedMethodFault"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmDiskFailedEvent", propOrder = {
    "disk",
    "reason"
})
public class VmDiskFailedEvent
    extends VmEvent
{

    @XmlElement(required = true)
    protected String disk;
    @XmlElement(required = true)
    protected LocalizedMethodFault reason;

    /**
     * Gets the value of the disk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisk() {
        return disk;
    }

    /**
     * Sets the value of the disk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisk(String value) {
        this.disk = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link LocalizedMethodFault }
     *     
     */
    public LocalizedMethodFault getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalizedMethodFault }
     *     
     */
    public void setReason(LocalizedMethodFault value) {
        this.reason = value;
    }

}
