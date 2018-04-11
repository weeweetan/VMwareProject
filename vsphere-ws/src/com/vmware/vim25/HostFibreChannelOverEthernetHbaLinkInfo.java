
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFibreChannelOverEthernetHbaLinkInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostFibreChannelOverEthernetHbaLinkInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="vnportMac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fcfMac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vlanId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostFibreChannelOverEthernetHbaLinkInfo", propOrder = {
    "vnportMac",
    "fcfMac",
    "vlanId"
})
public class HostFibreChannelOverEthernetHbaLinkInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String vnportMac;
    @XmlElement(required = true)
    protected String fcfMac;
    protected int vlanId;

    /**
     * Gets the value of the vnportMac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVnportMac() {
        return vnportMac;
    }

    /**
     * Sets the value of the vnportMac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVnportMac(String value) {
        this.vnportMac = value;
    }

    /**
     * Gets the value of the fcfMac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcfMac() {
        return fcfMac;
    }

    /**
     * Sets the value of the fcfMac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcfMac(String value) {
        this.fcfMac = value;
    }

    /**
     * Gets the value of the vlanId property.
     * 
     */
    public int getVlanId() {
        return vlanId;
    }

    /**
     * Sets the value of the vlanId property.
     * 
     */
    public void setVlanId(int value) {
        this.vlanId = value;
    }

}
