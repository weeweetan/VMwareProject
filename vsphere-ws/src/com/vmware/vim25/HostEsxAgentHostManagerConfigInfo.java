
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostEsxAgentHostManagerConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostEsxAgentHostManagerConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="agentVmDatastore" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="agentVmNetwork" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostEsxAgentHostManagerConfigInfo", propOrder = {
    "agentVmDatastore",
    "agentVmNetwork"
})
public class HostEsxAgentHostManagerConfigInfo
    extends DynamicData
{

    protected ManagedObjectReference agentVmDatastore;
    protected ManagedObjectReference agentVmNetwork;

    /**
     * Gets the value of the agentVmDatastore property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getAgentVmDatastore() {
        return agentVmDatastore;
    }

    /**
     * Sets the value of the agentVmDatastore property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setAgentVmDatastore(ManagedObjectReference value) {
        this.agentVmDatastore = value;
    }

    /**
     * Gets the value of the agentVmNetwork property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getAgentVmNetwork() {
        return agentVmNetwork;
    }

    /**
     * Sets the value of the agentVmNetwork property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setAgentVmNetwork(ManagedObjectReference value) {
        this.agentVmNetwork = value;
    }

}
