
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareDVSTeamingHealthCheckResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VMwareDVSTeamingHealthCheckResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostMemberHealthCheckResult">
 *       &lt;sequence>
 *         &lt;element name="teamingStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMwareDVSTeamingHealthCheckResult", propOrder = {
    "teamingStatus"
})
public class VMwareDVSTeamingHealthCheckResult
    extends HostMemberHealthCheckResult
{

    @XmlElement(required = true)
    protected String teamingStatus;

    /**
     * Gets the value of the teamingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamingStatus() {
        return teamingStatus;
    }

    /**
     * Sets the value of the teamingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamingStatus(String value) {
        this.teamingStatus = value;
    }

}
