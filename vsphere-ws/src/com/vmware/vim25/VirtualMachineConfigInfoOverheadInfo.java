
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineConfigInfoOverheadInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineConfigInfoOverheadInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="initialMemoryReservation" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="initialSwapReservation" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineConfigInfoOverheadInfo", propOrder = {
    "initialMemoryReservation",
    "initialSwapReservation"
})
public class VirtualMachineConfigInfoOverheadInfo
    extends DynamicData
{

    protected Long initialMemoryReservation;
    protected Long initialSwapReservation;

    /**
     * Gets the value of the initialMemoryReservation property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInitialMemoryReservation() {
        return initialMemoryReservation;
    }

    /**
     * Sets the value of the initialMemoryReservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInitialMemoryReservation(Long value) {
        this.initialMemoryReservation = value;
    }

    /**
     * Gets the value of the initialSwapReservation property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInitialSwapReservation() {
        return initialSwapReservation;
    }

    /**
     * Sets the value of the initialSwapReservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInitialSwapReservation(Long value) {
        this.initialSwapReservation = value;
    }

}
