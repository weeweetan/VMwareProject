
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostAccessRestrictedToManagementServer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostAccessRestrictedToManagementServer">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}NotSupported">
 *       &lt;sequence>
 *         &lt;element name="managementServer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostAccessRestrictedToManagementServer", propOrder = {
    "managementServer"
})
public class HostAccessRestrictedToManagementServer
    extends NotSupported
{

    @XmlElement(required = true)
    protected String managementServer;

    /**
     * Gets the value of the managementServer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagementServer() {
        return managementServer;
    }

    /**
     * Sets the value of the managementServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagementServer(String value) {
        this.managementServer = value;
    }

}
