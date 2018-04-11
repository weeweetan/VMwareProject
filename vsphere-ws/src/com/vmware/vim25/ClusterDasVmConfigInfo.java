
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterDasVmConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterDasVmConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="restartPriority" type="{urn:vim25}DasVmPriority" minOccurs="0"/>
 *         &lt;element name="powerOffOnIsolation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dasSettings" type="{urn:vim25}ClusterDasVmSettings" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterDasVmConfigInfo", propOrder = {
    "key",
    "restartPriority",
    "powerOffOnIsolation",
    "dasSettings"
})
public class ClusterDasVmConfigInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference key;
    protected DasVmPriority restartPriority;
    protected Boolean powerOffOnIsolation;
    protected ClusterDasVmSettings dasSettings;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setKey(ManagedObjectReference value) {
        this.key = value;
    }

    /**
     * Gets the value of the restartPriority property.
     * 
     * @return
     *     possible object is
     *     {@link DasVmPriority }
     *     
     */
    public DasVmPriority getRestartPriority() {
        return restartPriority;
    }

    /**
     * Sets the value of the restartPriority property.
     * 
     * @param value
     *     allowed object is
     *     {@link DasVmPriority }
     *     
     */
    public void setRestartPriority(DasVmPriority value) {
        this.restartPriority = value;
    }

    /**
     * Gets the value of the powerOffOnIsolation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPowerOffOnIsolation() {
        return powerOffOnIsolation;
    }

    /**
     * Sets the value of the powerOffOnIsolation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPowerOffOnIsolation(Boolean value) {
        this.powerOffOnIsolation = value;
    }

    /**
     * Gets the value of the dasSettings property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterDasVmSettings }
     *     
     */
    public ClusterDasVmSettings getDasSettings() {
        return dasSettings;
    }

    /**
     * Sets the value of the dasSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterDasVmSettings }
     *     
     */
    public void setDasSettings(ClusterDasVmSettings value) {
        this.dasSettings = value;
    }

}
