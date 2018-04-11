
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DisallowedChangeByService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DisallowedChangeByService">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}RuntimeFault">
 *       &lt;sequence>
 *         &lt;element name="serviceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="disallowedChange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisallowedChangeByService", propOrder = {
    "serviceName",
    "disallowedChange"
})
public class DisallowedChangeByService
    extends RuntimeFault
{

    @XmlElement(required = true)
    protected String serviceName;
    protected String disallowedChange;

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Gets the value of the disallowedChange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisallowedChange() {
        return disallowedChange;
    }

    /**
     * Sets the value of the disallowedChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisallowedChange(String value) {
        this.disallowedChange = value;
    }

}
