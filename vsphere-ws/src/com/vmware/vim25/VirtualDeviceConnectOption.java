
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDeviceConnectOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDeviceConnectOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="startConnected" type="{urn:vim25}BoolOption"/>
 *         &lt;element name="allowGuestControl" type="{urn:vim25}BoolOption"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDeviceConnectOption", propOrder = {
    "startConnected",
    "allowGuestControl"
})
public class VirtualDeviceConnectOption
    extends DynamicData
{

    @XmlElement(required = true)
    protected BoolOption startConnected;
    @XmlElement(required = true)
    protected BoolOption allowGuestControl;

    /**
     * Gets the value of the startConnected property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getStartConnected() {
        return startConnected;
    }

    /**
     * Sets the value of the startConnected property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setStartConnected(BoolOption value) {
        this.startConnected = value;
    }

    /**
     * Gets the value of the allowGuestControl property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getAllowGuestControl() {
        return allowGuestControl;
    }

    /**
     * Sets the value of the allowGuestControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setAllowGuestControl(BoolOption value) {
        this.allowGuestControl = value;
    }

}
