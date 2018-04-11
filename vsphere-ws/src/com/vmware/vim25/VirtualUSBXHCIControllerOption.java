
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualUSBXHCIControllerOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualUSBXHCIControllerOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualControllerOption">
 *       &lt;sequence>
 *         &lt;element name="autoConnectDevices" type="{urn:vim25}BoolOption"/>
 *         &lt;element name="supportedSpeeds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualUSBXHCIControllerOption", propOrder = {
    "autoConnectDevices",
    "supportedSpeeds"
})
public class VirtualUSBXHCIControllerOption
    extends VirtualControllerOption
{

    @XmlElement(required = true)
    protected BoolOption autoConnectDevices;
    @XmlElement(required = true)
    protected List<String> supportedSpeeds;

    /**
     * Gets the value of the autoConnectDevices property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getAutoConnectDevices() {
        return autoConnectDevices;
    }

    /**
     * Sets the value of the autoConnectDevices property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setAutoConnectDevices(BoolOption value) {
        this.autoConnectDevices = value;
    }

    /**
     * Gets the value of the supportedSpeeds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedSpeeds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedSpeeds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedSpeeds() {
        if (supportedSpeeds == null) {
            supportedSpeeds = new ArrayList<String>();
        }
        return this.supportedSpeeds;
    }

}
