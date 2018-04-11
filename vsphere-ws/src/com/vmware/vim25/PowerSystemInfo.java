
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PowerSystemInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PowerSystemInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="currentPolicy" type="{urn:vim25}HostPowerPolicy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerSystemInfo", propOrder = {
    "currentPolicy"
})
public class PowerSystemInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected HostPowerPolicy currentPolicy;

    /**
     * Gets the value of the currentPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link HostPowerPolicy }
     *     
     */
    public HostPowerPolicy getCurrentPolicy() {
        return currentPolicy;
    }

    /**
     * Sets the value of the currentPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostPowerPolicy }
     *     
     */
    public void setCurrentPolicy(HostPowerPolicy value) {
        this.currentPolicy = value;
    }

}
