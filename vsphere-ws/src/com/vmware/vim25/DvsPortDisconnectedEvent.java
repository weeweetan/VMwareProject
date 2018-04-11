
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsPortDisconnectedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsPortDisconnectedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsEvent">
 *       &lt;sequence>
 *         &lt;element name="portKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="connectee" type="{urn:vim25}DistributedVirtualSwitchPortConnectee" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DvsPortDisconnectedEvent", propOrder = {
    "portKey",
    "connectee"
})
public class DvsPortDisconnectedEvent
    extends DvsEvent
{

    @XmlElement(required = true)
    protected String portKey;
    protected DistributedVirtualSwitchPortConnectee connectee;

    /**
     * Gets the value of the portKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortKey() {
        return portKey;
    }

    /**
     * Sets the value of the portKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortKey(String value) {
        this.portKey = value;
    }

    /**
     * Gets the value of the connectee property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchPortConnectee }
     *     
     */
    public DistributedVirtualSwitchPortConnectee getConnectee() {
        return connectee;
    }

    /**
     * Sets the value of the connectee property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchPortConnectee }
     *     
     */
    public void setConnectee(DistributedVirtualSwitchPortConnectee value) {
        this.connectee = value;
    }

}
