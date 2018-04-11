
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MigrationHostErrorEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MigrationHostErrorEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}MigrationEvent">
 *       &lt;sequence>
 *         &lt;element name="dstHost" type="{urn:vim25}HostEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MigrationHostErrorEvent", propOrder = {
    "dstHost"
})
public class MigrationHostErrorEvent
    extends MigrationEvent
{

    @XmlElement(required = true)
    protected HostEventArgument dstHost;

    /**
     * Gets the value of the dstHost property.
     * 
     * @return
     *     possible object is
     *     {@link HostEventArgument }
     *     
     */
    public HostEventArgument getDstHost() {
        return dstHost;
    }

    /**
     * Sets the value of the dstHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostEventArgument }
     *     
     */
    public void setDstHost(HostEventArgument value) {
        this.dstHost = value;
    }

}
