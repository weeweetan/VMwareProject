
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestAuthenticationChallenge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuestAuthenticationChallenge">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}GuestOperationsFault">
 *       &lt;sequence>
 *         &lt;element name="serverChallenge" type="{urn:vim25}GuestAuthentication"/>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestAuthenticationChallenge", propOrder = {
    "serverChallenge",
    "sessionID"
})
public class GuestAuthenticationChallenge
    extends GuestOperationsFault
{

    @XmlElement(required = true)
    protected GuestAuthentication serverChallenge;
    protected long sessionID;

    /**
     * Gets the value of the serverChallenge property.
     * 
     * @return
     *     possible object is
     *     {@link GuestAuthentication }
     *     
     */
    public GuestAuthentication getServerChallenge() {
        return serverChallenge;
    }

    /**
     * Sets the value of the serverChallenge property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuestAuthentication }
     *     
     */
    public void setServerChallenge(GuestAuthentication value) {
        this.serverChallenge = value;
    }

    /**
     * Gets the value of the sessionID property.
     * 
     */
    public long getSessionID() {
        return sessionID;
    }

    /**
     * Sets the value of the sessionID property.
     * 
     */
    public void setSessionID(long value) {
        this.sessionID = value;
    }

}
