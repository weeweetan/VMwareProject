
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostProfileSerializedHostProfileSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostProfileSerializedHostProfileSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ProfileSerializedCreateSpec">
 *       &lt;sequence>
 *         &lt;element name="validatorHost" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostProfileSerializedHostProfileSpec", propOrder = {
    "validatorHost"
})
public class HostProfileSerializedHostProfileSpec
    extends ProfileSerializedCreateSpec
{

    protected ManagedObjectReference validatorHost;

    /**
     * Gets the value of the validatorHost property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getValidatorHost() {
        return validatorHost;
    }

    /**
     * Sets the value of the validatorHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setValidatorHost(ManagedObjectReference value) {
        this.validatorHost = value;
    }

}
