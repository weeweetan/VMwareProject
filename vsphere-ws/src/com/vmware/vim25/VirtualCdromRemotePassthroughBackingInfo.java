
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualCdromRemotePassthroughBackingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualCdromRemotePassthroughBackingInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceRemoteDeviceBackingInfo">
 *       &lt;sequence>
 *         &lt;element name="exclusive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualCdromRemotePassthroughBackingInfo", propOrder = {
    "exclusive"
})
public class VirtualCdromRemotePassthroughBackingInfo
    extends VirtualDeviceRemoteDeviceBackingInfo
{

    protected boolean exclusive;

    /**
     * Gets the value of the exclusive property.
     * 
     */
    public boolean isExclusive() {
        return exclusive;
    }

    /**
     * Sets the value of the exclusive property.
     * 
     */
    public void setExclusive(boolean value) {
        this.exclusive = value;
    }

}
