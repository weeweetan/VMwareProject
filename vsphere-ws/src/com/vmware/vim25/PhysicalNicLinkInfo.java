
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhysicalNicLinkInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PhysicalNicLinkInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="speedMb" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="duplex" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalNicLinkInfo", propOrder = {
    "speedMb",
    "duplex"
})
public class PhysicalNicLinkInfo
    extends DynamicData
{

    protected int speedMb;
    protected boolean duplex;

    /**
     * Gets the value of the speedMb property.
     * 
     */
    public int getSpeedMb() {
        return speedMb;
    }

    /**
     * Sets the value of the speedMb property.
     * 
     */
    public void setSpeedMb(int value) {
        this.speedMb = value;
    }

    /**
     * Gets the value of the duplex property.
     * 
     */
    public boolean isDuplex() {
        return duplex;
    }

    /**
     * Sets the value of the duplex property.
     * 
     */
    public void setDuplex(boolean value) {
        this.duplex = value;
    }

}
