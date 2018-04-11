
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualSerialPort complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualSerialPort">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDevice">
 *       &lt;sequence>
 *         &lt;element name="yieldOnPoll" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualSerialPort", propOrder = {
    "yieldOnPoll"
})
public class VirtualSerialPort
    extends VirtualDevice
{

    protected boolean yieldOnPoll;

    /**
     * Gets the value of the yieldOnPoll property.
     * 
     */
    public boolean isYieldOnPoll() {
        return yieldOnPoll;
    }

    /**
     * Sets the value of the yieldOnPoll property.
     * 
     */
    public void setYieldOnPoll(boolean value) {
        this.yieldOnPoll = value;
    }

}
