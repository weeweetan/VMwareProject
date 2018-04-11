
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostMemberUplinkHealthCheckResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostMemberUplinkHealthCheckResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostMemberHealthCheckResult">
 *       &lt;sequence>
 *         &lt;element name="uplinkPortKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostMemberUplinkHealthCheckResult", propOrder = {
    "uplinkPortKey"
})
@XmlSeeAlso({
    VMwareDVSVlanHealthCheckResult.class,
    VMwareDVSMtuHealthCheckResult.class
})
public class HostMemberUplinkHealthCheckResult
    extends HostMemberHealthCheckResult
{

    @XmlElement(required = true)
    protected String uplinkPortKey;

    /**
     * Gets the value of the uplinkPortKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUplinkPortKey() {
        return uplinkPortKey;
    }

    /**
     * Sets the value of the uplinkPortKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUplinkPortKey(String value) {
        this.uplinkPortKey = value;
    }

}
