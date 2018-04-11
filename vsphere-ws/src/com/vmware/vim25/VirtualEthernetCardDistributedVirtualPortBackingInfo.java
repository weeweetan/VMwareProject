
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualEthernetCardDistributedVirtualPortBackingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualEthernetCardDistributedVirtualPortBackingInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceBackingInfo">
 *       &lt;sequence>
 *         &lt;element name="port" type="{urn:vim25}DistributedVirtualSwitchPortConnection"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualEthernetCardDistributedVirtualPortBackingInfo", propOrder = {
    "port"
})
public class VirtualEthernetCardDistributedVirtualPortBackingInfo
    extends VirtualDeviceBackingInfo
{

    @XmlElement(required = true)
    protected DistributedVirtualSwitchPortConnection port;

    /**
     * Gets the value of the port property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchPortConnection }
     *     
     */
    public DistributedVirtualSwitchPortConnection getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchPortConnection }
     *     
     */
    public void setPort(DistributedVirtualSwitchPortConnection value) {
        this.port = value;
    }

}
