
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostPortGroupProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostPortGroupProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}PortGroupProfile">
 *       &lt;sequence>
 *         &lt;element name="ipConfig" type="{urn:vim25}IpAddressProfile"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostPortGroupProfile", propOrder = {
    "ipConfig"
})
public class HostPortGroupProfile
    extends PortGroupProfile
{

    @XmlElement(required = true)
    protected IpAddressProfile ipConfig;

    /**
     * Gets the value of the ipConfig property.
     * 
     * @return
     *     possible object is
     *     {@link IpAddressProfile }
     *     
     */
    public IpAddressProfile getIpConfig() {
        return ipConfig;
    }

    /**
     * Sets the value of the ipConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link IpAddressProfile }
     *     
     */
    public void setIpConfig(IpAddressProfile value) {
        this.ipConfig = value;
    }

}
