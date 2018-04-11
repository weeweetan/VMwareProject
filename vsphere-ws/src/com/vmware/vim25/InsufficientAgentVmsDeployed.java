
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InsufficientAgentVmsDeployed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsufficientAgentVmsDeployed">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InsufficientResourcesFault">
 *       &lt;sequence>
 *         &lt;element name="hostName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="requiredNumAgentVms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="currentNumAgentVms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsufficientAgentVmsDeployed", propOrder = {
    "hostName",
    "requiredNumAgentVms",
    "currentNumAgentVms"
})
public class InsufficientAgentVmsDeployed
    extends InsufficientResourcesFault
{

    @XmlElement(required = true)
    protected String hostName;
    protected int requiredNumAgentVms;
    protected int currentNumAgentVms;

    /**
     * Gets the value of the hostName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * Sets the value of the hostName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostName(String value) {
        this.hostName = value;
    }

    /**
     * Gets the value of the requiredNumAgentVms property.
     * 
     */
    public int getRequiredNumAgentVms() {
        return requiredNumAgentVms;
    }

    /**
     * Sets the value of the requiredNumAgentVms property.
     * 
     */
    public void setRequiredNumAgentVms(int value) {
        this.requiredNumAgentVms = value;
    }

    /**
     * Gets the value of the currentNumAgentVms property.
     * 
     */
    public int getCurrentNumAgentVms() {
        return currentNumAgentVms;
    }

    /**
     * Sets the value of the currentNumAgentVms property.
     * 
     */
    public void setCurrentNumAgentVms(int value) {
        this.currentNumAgentVms = value;
    }

}
