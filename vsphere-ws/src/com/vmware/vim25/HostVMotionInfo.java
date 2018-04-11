
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostVMotionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostVMotionInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="netConfig" type="{urn:vim25}HostVMotionNetConfig" minOccurs="0"/>
 *         &lt;element name="ipConfig" type="{urn:vim25}HostIpConfig" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostVMotionInfo", propOrder = {
    "netConfig",
    "ipConfig"
})
public class HostVMotionInfo
    extends DynamicData
{

    protected HostVMotionNetConfig netConfig;
    protected HostIpConfig ipConfig;

    /**
     * Gets the value of the netConfig property.
     * 
     * @return
     *     possible object is
     *     {@link HostVMotionNetConfig }
     *     
     */
    public HostVMotionNetConfig getNetConfig() {
        return netConfig;
    }

    /**
     * Sets the value of the netConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostVMotionNetConfig }
     *     
     */
    public void setNetConfig(HostVMotionNetConfig value) {
        this.netConfig = value;
    }

    /**
     * Gets the value of the ipConfig property.
     * 
     * @return
     *     possible object is
     *     {@link HostIpConfig }
     *     
     */
    public HostIpConfig getIpConfig() {
        return ipConfig;
    }

    /**
     * Sets the value of the ipConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostIpConfig }
     *     
     */
    public void setIpConfig(HostIpConfig value) {
        this.ipConfig = value;
    }

}
