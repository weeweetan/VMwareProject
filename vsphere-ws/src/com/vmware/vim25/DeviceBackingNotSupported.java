
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceBackingNotSupported complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceBackingNotSupported">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DeviceNotSupported">
 *       &lt;sequence>
 *         &lt;element name="backing" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceBackingNotSupported", propOrder = {
    "backing"
})
@XmlSeeAlso({
    DVPortNotSupported.class,
    UnusedVirtualDiskBlocksNotScrubbed.class,
    VirtualDiskBlocksNotFullyProvisioned.class
})
public class DeviceBackingNotSupported
    extends DeviceNotSupported
{

    @XmlElement(required = true)
    protected String backing;

    /**
     * Gets the value of the backing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBacking() {
        return backing;
    }

    /**
     * Sets the value of the backing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBacking(String value) {
        this.backing = value;
    }

}
