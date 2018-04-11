
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaultTolerancePrimaryPowerOnNotAttempted complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaultTolerancePrimaryPowerOnNotAttempted">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmFaultToleranceIssue">
 *       &lt;sequence>
 *         &lt;element name="secondaryVm" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="primaryVm" type="{urn:vim25}ManagedObjectReference"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultTolerancePrimaryPowerOnNotAttempted", propOrder = {
    "secondaryVm",
    "primaryVm"
})
public class FaultTolerancePrimaryPowerOnNotAttempted
    extends VmFaultToleranceIssue
{

    @XmlElement(required = true)
    protected ManagedObjectReference secondaryVm;
    @XmlElement(required = true)
    protected ManagedObjectReference primaryVm;

    /**
     * Gets the value of the secondaryVm property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getSecondaryVm() {
        return secondaryVm;
    }

    /**
     * Sets the value of the secondaryVm property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setSecondaryVm(ManagedObjectReference value) {
        this.secondaryVm = value;
    }

    /**
     * Gets the value of the primaryVm property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getPrimaryVm() {
        return primaryVm;
    }

    /**
     * Sets the value of the primaryVm property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setPrimaryVm(ManagedObjectReference value) {
        this.primaryVm = value;
    }

}
