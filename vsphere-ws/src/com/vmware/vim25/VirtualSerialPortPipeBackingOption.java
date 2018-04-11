
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualSerialPortPipeBackingOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualSerialPortPipeBackingOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDevicePipeBackingOption">
 *       &lt;sequence>
 *         &lt;element name="endpoint" type="{urn:vim25}ChoiceOption"/>
 *         &lt;element name="noRxLoss" type="{urn:vim25}BoolOption"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualSerialPortPipeBackingOption", propOrder = {
    "endpoint",
    "noRxLoss"
})
public class VirtualSerialPortPipeBackingOption
    extends VirtualDevicePipeBackingOption
{

    @XmlElement(required = true)
    protected ChoiceOption endpoint;
    @XmlElement(required = true)
    protected BoolOption noRxLoss;

    /**
     * Gets the value of the endpoint property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOption }
     *     
     */
    public ChoiceOption getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the value of the endpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOption }
     *     
     */
    public void setEndpoint(ChoiceOption value) {
        this.endpoint = value;
    }

    /**
     * Gets the value of the noRxLoss property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getNoRxLoss() {
        return noRxLoss;
    }

    /**
     * Sets the value of the noRxLoss property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setNoRxLoss(BoolOption value) {
        this.noRxLoss = value;
    }

}
