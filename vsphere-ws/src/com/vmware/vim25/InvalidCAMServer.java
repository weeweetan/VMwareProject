
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvalidCAMServer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvalidCAMServer">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ActiveDirectoryFault">
 *       &lt;sequence>
 *         &lt;element name="camServer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvalidCAMServer", propOrder = {
    "camServer"
})
@XmlSeeAlso({
    InvalidCAMCertificate.class,
    CAMServerRefusedConnection.class
})
public class InvalidCAMServer
    extends ActiveDirectoryFault
{

    @XmlElement(required = true)
    protected String camServer;

    /**
     * Gets the value of the camServer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCamServer() {
        return camServer;
    }

    /**
     * Sets the value of the camServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCamServer(String value) {
        this.camServer = value;
    }

}
