
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDevicePipeBackingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDevicePipeBackingInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceBackingInfo">
 *       &lt;sequence>
 *         &lt;element name="pipeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDevicePipeBackingInfo", propOrder = {
    "pipeName"
})
@XmlSeeAlso({
    VirtualSerialPortPipeBackingInfo.class
})
public class VirtualDevicePipeBackingInfo
    extends VirtualDeviceBackingInfo
{

    @XmlElement(required = true)
    protected String pipeName;

    /**
     * Gets the value of the pipeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPipeName() {
        return pipeName;
    }

    /**
     * Sets the value of the pipeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPipeName(String value) {
        this.pipeName = value;
    }

}
