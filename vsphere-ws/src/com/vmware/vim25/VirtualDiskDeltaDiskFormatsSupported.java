
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDiskDeltaDiskFormatsSupported complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDiskDeltaDiskFormatsSupported">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="datastoreType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deltaDiskFormat" type="{urn:vim25}ChoiceOption"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDiskDeltaDiskFormatsSupported", propOrder = {
    "datastoreType",
    "deltaDiskFormat"
})
public class VirtualDiskDeltaDiskFormatsSupported
    extends DynamicData
{

    @XmlElement(required = true)
    protected String datastoreType;
    @XmlElement(required = true)
    protected ChoiceOption deltaDiskFormat;

    /**
     * Gets the value of the datastoreType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatastoreType() {
        return datastoreType;
    }

    /**
     * Sets the value of the datastoreType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatastoreType(String value) {
        this.datastoreType = value;
    }

    /**
     * Gets the value of the deltaDiskFormat property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOption }
     *     
     */
    public ChoiceOption getDeltaDiskFormat() {
        return deltaDiskFormat;
    }

    /**
     * Sets the value of the deltaDiskFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOption }
     *     
     */
    public void setDeltaDiskFormat(ChoiceOption value) {
        this.deltaDiskFormat = value;
    }

}
