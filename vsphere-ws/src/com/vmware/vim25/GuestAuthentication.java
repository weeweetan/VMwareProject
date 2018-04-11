
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestAuthentication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuestAuthentication">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="interactiveSession" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestAuthentication", propOrder = {
    "interactiveSession"
})
@XmlSeeAlso({
    NamePasswordAuthentication.class,
    SSPIAuthentication.class,
    TicketedSessionAuthentication.class
})
public class GuestAuthentication
    extends DynamicData
{

    protected boolean interactiveSession;

    /**
     * Gets the value of the interactiveSession property.
     * 
     */
    public boolean isInteractiveSession() {
        return interactiveSession;
    }

    /**
     * Sets the value of the interactiveSession property.
     * 
     */
    public void setInteractiveSession(boolean value) {
        this.interactiveSession = value;
    }

}
