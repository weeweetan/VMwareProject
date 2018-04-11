
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDiskSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDiskSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="diskType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adapterType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDiskSpec", propOrder = {
    "diskType",
    "adapterType"
})
@XmlSeeAlso({
    DeviceBackedVirtualDiskSpec.class,
    FileBackedVirtualDiskSpec.class
})
public class VirtualDiskSpec
    extends DynamicData
{

    @XmlElement(required = true)
    protected String diskType;
    @XmlElement(required = true)
    protected String adapterType;

    /**
     * Gets the value of the diskType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskType() {
        return diskType;
    }

    /**
     * Sets the value of the diskType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskType(String value) {
        this.diskType = value;
    }

    /**
     * Gets the value of the adapterType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdapterType() {
        return adapterType;
    }

    /**
     * Sets the value of the adapterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdapterType(String value) {
        this.adapterType = value;
    }

}
