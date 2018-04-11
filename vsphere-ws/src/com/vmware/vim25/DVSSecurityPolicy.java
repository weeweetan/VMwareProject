
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSSecurityPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSSecurityPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InheritablePolicy">
 *       &lt;sequence>
 *         &lt;element name="allowPromiscuous" type="{urn:vim25}BoolPolicy" minOccurs="0"/>
 *         &lt;element name="macChanges" type="{urn:vim25}BoolPolicy" minOccurs="0"/>
 *         &lt;element name="forgedTransmits" type="{urn:vim25}BoolPolicy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSSecurityPolicy", propOrder = {
    "allowPromiscuous",
    "macChanges",
    "forgedTransmits"
})
public class DVSSecurityPolicy
    extends InheritablePolicy
{

    protected BoolPolicy allowPromiscuous;
    protected BoolPolicy macChanges;
    protected BoolPolicy forgedTransmits;

    /**
     * Gets the value of the allowPromiscuous property.
     * 
     * @return
     *     possible object is
     *     {@link BoolPolicy }
     *     
     */
    public BoolPolicy getAllowPromiscuous() {
        return allowPromiscuous;
    }

    /**
     * Sets the value of the allowPromiscuous property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolPolicy }
     *     
     */
    public void setAllowPromiscuous(BoolPolicy value) {
        this.allowPromiscuous = value;
    }

    /**
     * Gets the value of the macChanges property.
     * 
     * @return
     *     possible object is
     *     {@link BoolPolicy }
     *     
     */
    public BoolPolicy getMacChanges() {
        return macChanges;
    }

    /**
     * Sets the value of the macChanges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolPolicy }
     *     
     */
    public void setMacChanges(BoolPolicy value) {
        this.macChanges = value;
    }

    /**
     * Gets the value of the forgedTransmits property.
     * 
     * @return
     *     possible object is
     *     {@link BoolPolicy }
     *     
     */
    public BoolPolicy getForgedTransmits() {
        return forgedTransmits;
    }

    /**
     * Sets the value of the forgedTransmits property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolPolicy }
     *     
     */
    public void setForgedTransmits(BoolPolicy value) {
        this.forgedTransmits = value;
    }

}
