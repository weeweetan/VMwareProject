
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostVirtualNicConnection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostVirtualNicConnection">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="portgroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dvPort" type="{urn:vim25}DistributedVirtualSwitchPortConnection" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostVirtualNicConnection", propOrder = {
    "portgroup",
    "dvPort"
})
public class HostVirtualNicConnection
    extends DynamicData
{

    protected String portgroup;
    protected DistributedVirtualSwitchPortConnection dvPort;

    /**
     * Gets the value of the portgroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortgroup() {
        return portgroup;
    }

    /**
     * Sets the value of the portgroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortgroup(String value) {
        this.portgroup = value;
    }

    /**
     * Gets the value of the dvPort property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchPortConnection }
     *     
     */
    public DistributedVirtualSwitchPortConnection getDvPort() {
        return dvPort;
    }

    /**
     * Sets the value of the dvPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchPortConnection }
     *     
     */
    public void setDvPort(DistributedVirtualSwitchPortConnection value) {
        this.dvPort = value;
    }

}
