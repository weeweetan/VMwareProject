
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDnsConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDnsConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostDnsConfig">
 *       &lt;sequence>
 *         &lt;element name="virtualNicConnection" type="{urn:vim25}HostVirtualNicConnection" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDnsConfigSpec", propOrder = {
    "virtualNicConnection"
})
public class HostDnsConfigSpec
    extends HostDnsConfig
{

    protected HostVirtualNicConnection virtualNicConnection;

    /**
     * Gets the value of the virtualNicConnection property.
     * 
     * @return
     *     possible object is
     *     {@link HostVirtualNicConnection }
     *     
     */
    public HostVirtualNicConnection getVirtualNicConnection() {
        return virtualNicConnection;
    }

    /**
     * Sets the value of the virtualNicConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostVirtualNicConnection }
     *     
     */
    public void setVirtualNicConnection(HostVirtualNicConnection value) {
        this.virtualNicConnection = value;
    }

}
