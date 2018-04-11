
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareDVSHealthCheckCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VMwareDVSHealthCheckCapability">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DVSHealthCheckCapability">
 *       &lt;sequence>
 *         &lt;element name="vlanMtuSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="teamingSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMwareDVSHealthCheckCapability", propOrder = {
    "vlanMtuSupported",
    "teamingSupported"
})
public class VMwareDVSHealthCheckCapability
    extends DVSHealthCheckCapability
{

    protected boolean vlanMtuSupported;
    protected boolean teamingSupported;

    /**
     * Gets the value of the vlanMtuSupported property.
     * 
     */
    public boolean isVlanMtuSupported() {
        return vlanMtuSupported;
    }

    /**
     * Sets the value of the vlanMtuSupported property.
     * 
     */
    public void setVlanMtuSupported(boolean value) {
        this.vlanMtuSupported = value;
    }

    /**
     * Gets the value of the teamingSupported property.
     * 
     */
    public boolean isTeamingSupported() {
        return teamingSupported;
    }

    /**
     * Sets the value of the teamingSupported property.
     * 
     */
    public void setTeamingSupported(boolean value) {
        this.teamingSupported = value;
    }

}
