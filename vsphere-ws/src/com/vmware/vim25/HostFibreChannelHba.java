
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFibreChannelHba complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostFibreChannelHba">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostHostBusAdapter">
 *       &lt;sequence>
 *         &lt;element name="portWorldWideName" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="nodeWorldWideName" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="portType" type="{urn:vim25}FibreChannelPortType"/>
 *         &lt;element name="speed" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostFibreChannelHba", propOrder = {
    "portWorldWideName",
    "nodeWorldWideName",
    "portType",
    "speed"
})
@XmlSeeAlso({
    HostFibreChannelOverEthernetHba.class
})
public class HostFibreChannelHba
    extends HostHostBusAdapter
{

    protected long portWorldWideName;
    protected long nodeWorldWideName;
    @XmlElement(required = true)
    protected FibreChannelPortType portType;
    protected long speed;

    /**
     * Gets the value of the portWorldWideName property.
     * 
     */
    public long getPortWorldWideName() {
        return portWorldWideName;
    }

    /**
     * Sets the value of the portWorldWideName property.
     * 
     */
    public void setPortWorldWideName(long value) {
        this.portWorldWideName = value;
    }

    /**
     * Gets the value of the nodeWorldWideName property.
     * 
     */
    public long getNodeWorldWideName() {
        return nodeWorldWideName;
    }

    /**
     * Sets the value of the nodeWorldWideName property.
     * 
     */
    public void setNodeWorldWideName(long value) {
        this.nodeWorldWideName = value;
    }

    /**
     * Gets the value of the portType property.
     * 
     * @return
     *     possible object is
     *     {@link FibreChannelPortType }
     *     
     */
    public FibreChannelPortType getPortType() {
        return portType;
    }

    /**
     * Sets the value of the portType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FibreChannelPortType }
     *     
     */
    public void setPortType(FibreChannelPortType value) {
        this.portType = value;
    }

    /**
     * Gets the value of the speed property.
     * 
     */
    public long getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     * 
     */
    public void setSpeed(long value) {
        this.speed = value;
    }

}
