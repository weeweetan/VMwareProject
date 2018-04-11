
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualPS2ControllerOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualPS2ControllerOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualControllerOption">
 *       &lt;sequence>
 *         &lt;element name="numKeyboards" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numPointingDevices" type="{urn:vim25}IntOption"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualPS2ControllerOption", propOrder = {
    "numKeyboards",
    "numPointingDevices"
})
public class VirtualPS2ControllerOption
    extends VirtualControllerOption
{

    @XmlElement(required = true)
    protected IntOption numKeyboards;
    @XmlElement(required = true)
    protected IntOption numPointingDevices;

    /**
     * Gets the value of the numKeyboards property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumKeyboards() {
        return numKeyboards;
    }

    /**
     * Sets the value of the numKeyboards property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumKeyboards(IntOption value) {
        this.numKeyboards = value;
    }

    /**
     * Gets the value of the numPointingDevices property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumPointingDevices() {
        return numPointingDevices;
    }

    /**
     * Sets the value of the numPointingDevices property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumPointingDevices(IntOption value) {
        this.numPointingDevices = value;
    }

}
