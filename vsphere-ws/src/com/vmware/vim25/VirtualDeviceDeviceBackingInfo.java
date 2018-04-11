
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDeviceDeviceBackingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDeviceDeviceBackingInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceBackingInfo">
 *       &lt;sequence>
 *         &lt;element name="deviceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="useAutoDetect" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDeviceDeviceBackingInfo", propOrder = {
    "deviceName",
    "useAutoDetect"
})
@XmlSeeAlso({
    VirtualSerialPortDeviceBackingInfo.class,
    VirtualEthernetCardLegacyNetworkBackingInfo.class,
    VirtualUSBRemoteHostBackingInfo.class,
    VirtualCdromPassthroughBackingInfo.class,
    VirtualPCIPassthroughDeviceBackingInfo.class,
    VirtualPointingDeviceDeviceBackingInfo.class,
    VirtualFloppyDeviceBackingInfo.class,
    VirtualSCSIPassthroughDeviceBackingInfo.class,
    VirtualUSBUSBBackingInfo.class,
    VirtualSoundCardDeviceBackingInfo.class,
    VirtualEthernetCardNetworkBackingInfo.class,
    VirtualDiskRawDiskVer2BackingInfo.class,
    VirtualCdromAtapiBackingInfo.class,
    VirtualParallelPortDeviceBackingInfo.class
})
public class VirtualDeviceDeviceBackingInfo
    extends VirtualDeviceBackingInfo
{

    @XmlElement(required = true)
    protected String deviceName;
    protected Boolean useAutoDetect;

    /**
     * Gets the value of the deviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Sets the value of the deviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceName(String value) {
        this.deviceName = value;
    }

    /**
     * Gets the value of the useAutoDetect property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseAutoDetect() {
        return useAutoDetect;
    }

    /**
     * Sets the value of the useAutoDetect property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseAutoDetect(Boolean value) {
        this.useAutoDetect = value;
    }

}
