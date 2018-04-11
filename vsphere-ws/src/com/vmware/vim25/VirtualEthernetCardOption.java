
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualEthernetCardOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualEthernetCardOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceOption">
 *       &lt;sequence>
 *         &lt;element name="supportedOUI" type="{urn:vim25}ChoiceOption"/>
 *         &lt;element name="macType" type="{urn:vim25}ChoiceOption"/>
 *         &lt;element name="wakeOnLanEnabled" type="{urn:vim25}BoolOption"/>
 *         &lt;element name="vmDirectPathGen2Supported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualEthernetCardOption", propOrder = {
    "supportedOUI",
    "macType",
    "wakeOnLanEnabled",
    "vmDirectPathGen2Supported"
})
@XmlSeeAlso({
    VirtualPCNet32Option.class,
    VirtualE1000EOption.class,
    VirtualE1000Option.class,
    VirtualVmxnetOption.class
})
public class VirtualEthernetCardOption
    extends VirtualDeviceOption
{

    @XmlElement(required = true)
    protected ChoiceOption supportedOUI;
    @XmlElement(required = true)
    protected ChoiceOption macType;
    @XmlElement(required = true)
    protected BoolOption wakeOnLanEnabled;
    protected Boolean vmDirectPathGen2Supported;

    /**
     * Gets the value of the supportedOUI property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOption }
     *     
     */
    public ChoiceOption getSupportedOUI() {
        return supportedOUI;
    }

    /**
     * Sets the value of the supportedOUI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOption }
     *     
     */
    public void setSupportedOUI(ChoiceOption value) {
        this.supportedOUI = value;
    }

    /**
     * Gets the value of the macType property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOption }
     *     
     */
    public ChoiceOption getMacType() {
        return macType;
    }

    /**
     * Sets the value of the macType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOption }
     *     
     */
    public void setMacType(ChoiceOption value) {
        this.macType = value;
    }

    /**
     * Gets the value of the wakeOnLanEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getWakeOnLanEnabled() {
        return wakeOnLanEnabled;
    }

    /**
     * Sets the value of the wakeOnLanEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setWakeOnLanEnabled(BoolOption value) {
        this.wakeOnLanEnabled = value;
    }

    /**
     * Gets the value of the vmDirectPathGen2Supported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVmDirectPathGen2Supported() {
        return vmDirectPathGen2Supported;
    }

    /**
     * Sets the value of the vmDirectPathGen2Supported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVmDirectPathGen2Supported(Boolean value) {
        this.vmDirectPathGen2Supported = value;
    }

}
