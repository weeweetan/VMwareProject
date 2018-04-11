
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvalidIpmiMacAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvalidIpmiMacAddress">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VimFault">
 *       &lt;sequence>
 *         &lt;element name="userProvidedMacAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="observedMacAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvalidIpmiMacAddress", propOrder = {
    "userProvidedMacAddress",
    "observedMacAddress"
})
public class InvalidIpmiMacAddress
    extends VimFault
{

    @XmlElement(required = true)
    protected String userProvidedMacAddress;
    @XmlElement(required = true)
    protected String observedMacAddress;

    /**
     * Gets the value of the userProvidedMacAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserProvidedMacAddress() {
        return userProvidedMacAddress;
    }

    /**
     * Sets the value of the userProvidedMacAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserProvidedMacAddress(String value) {
        this.userProvidedMacAddress = value;
    }

    /**
     * Gets the value of the observedMacAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservedMacAddress() {
        return observedMacAddress;
    }

    /**
     * Sets the value of the observedMacAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservedMacAddress(String value) {
        this.observedMacAddress = value;
    }

}
