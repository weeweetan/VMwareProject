
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmReloadFromPathFailedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmReloadFromPathFailedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="configPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmReloadFromPathFailedEvent", propOrder = {
    "configPath"
})
public class VmReloadFromPathFailedEvent
    extends VmEvent
{

    @XmlElement(required = true)
    protected String configPath;

    /**
     * Gets the value of the configPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigPath() {
        return configPath;
    }

    /**
     * Sets the value of the configPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigPath(String value) {
        this.configPath = value;
    }

}
