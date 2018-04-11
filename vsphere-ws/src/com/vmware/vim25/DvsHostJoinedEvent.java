
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsHostJoinedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsHostJoinedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsEvent">
 *       &lt;sequence>
 *         &lt;element name="hostJoined" type="{urn:vim25}HostEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DvsHostJoinedEvent", propOrder = {
    "hostJoined"
})
public class DvsHostJoinedEvent
    extends DvsEvent
{

    @XmlElement(required = true)
    protected HostEventArgument hostJoined;

    /**
     * Gets the value of the hostJoined property.
     * 
     * @return
     *     possible object is
     *     {@link HostEventArgument }
     *     
     */
    public HostEventArgument getHostJoined() {
        return hostJoined;
    }

    /**
     * Sets the value of the hostJoined property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostEventArgument }
     *     
     */
    public void setHostJoined(HostEventArgument value) {
        this.hostJoined = value;
    }

}
