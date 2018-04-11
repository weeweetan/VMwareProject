
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsNotAuthorized complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsNotAuthorized">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsFault">
 *       &lt;sequence>
 *         &lt;element name="sessionExtensionKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dvsExtensionKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DvsNotAuthorized", propOrder = {
    "sessionExtensionKey",
    "dvsExtensionKey"
})
public class DvsNotAuthorized
    extends DvsFault
{

    protected String sessionExtensionKey;
    protected String dvsExtensionKey;

    /**
     * Gets the value of the sessionExtensionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionExtensionKey() {
        return sessionExtensionKey;
    }

    /**
     * Sets the value of the sessionExtensionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionExtensionKey(String value) {
        this.sessionExtensionKey = value;
    }

    /**
     * Gets the value of the dvsExtensionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDvsExtensionKey() {
        return dvsExtensionKey;
    }

    /**
     * Sets the value of the dvsExtensionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDvsExtensionKey(String value) {
        this.dvsExtensionKey = value;
    }

}
