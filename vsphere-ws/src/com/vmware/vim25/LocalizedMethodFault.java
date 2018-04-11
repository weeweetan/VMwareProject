
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LocalizedMethodFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocalizedMethodFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="fault" type="{urn:vim25}MethodFault"/>
 *         &lt;element name="localizedMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalizedMethodFault", propOrder = {
    "fault",
    "localizedMessage"
})
public class LocalizedMethodFault
    extends DynamicData
{

    @XmlElement(required = true)
    protected MethodFault fault;
    protected String localizedMessage;

    /**
     * Gets the value of the fault property.
     * 
     * @return
     *     possible object is
     *     {@link MethodFault }
     *     
     */
    public MethodFault getFault() {
        return fault;
    }

    /**
     * Sets the value of the fault property.
     * 
     * @param value
     *     allowed object is
     *     {@link MethodFault }
     *     
     */
    public void setFault(MethodFault value) {
        this.fault = value;
    }

    /**
     * Gets the value of the localizedMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalizedMessage() {
        return localizedMessage;
    }

    /**
     * Sets the value of the localizedMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalizedMessage(String value) {
        this.localizedMessage = value;
    }

}
