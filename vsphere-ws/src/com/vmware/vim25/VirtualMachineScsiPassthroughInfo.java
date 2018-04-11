
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineScsiPassthroughInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineScsiPassthroughInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualMachineTargetInfo">
 *       &lt;sequence>
 *         &lt;element name="scsiClass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vendor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="physicalUnitNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineScsiPassthroughInfo", propOrder = {
    "scsiClass",
    "vendor",
    "physicalUnitNumber"
})
public class VirtualMachineScsiPassthroughInfo
    extends VirtualMachineTargetInfo
{

    @XmlElement(required = true)
    protected String scsiClass;
    @XmlElement(required = true)
    protected String vendor;
    protected int physicalUnitNumber;

    /**
     * Gets the value of the scsiClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScsiClass() {
        return scsiClass;
    }

    /**
     * Sets the value of the scsiClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScsiClass(String value) {
        this.scsiClass = value;
    }

    /**
     * Gets the value of the vendor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendor(String value) {
        this.vendor = value;
    }

    /**
     * Gets the value of the physicalUnitNumber property.
     * 
     */
    public int getPhysicalUnitNumber() {
        return physicalUnitNumber;
    }

    /**
     * Sets the value of the physicalUnitNumber property.
     * 
     */
    public void setPhysicalUnitNumber(int value) {
        this.physicalUnitNumber = value;
    }

}
