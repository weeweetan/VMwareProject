
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareIpfixConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VMwareIpfixConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="collectorIpAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="collectorPort" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="activeFlowTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idleFlowTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="samplingRate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="internalFlowsOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMwareIpfixConfig", propOrder = {
    "collectorIpAddress",
    "collectorPort",
    "activeFlowTimeout",
    "idleFlowTimeout",
    "samplingRate",
    "internalFlowsOnly"
})
public class VMwareIpfixConfig
    extends DynamicData
{

    protected String collectorIpAddress;
    protected Integer collectorPort;
    protected int activeFlowTimeout;
    protected int idleFlowTimeout;
    protected int samplingRate;
    protected boolean internalFlowsOnly;

    /**
     * Gets the value of the collectorIpAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectorIpAddress() {
        return collectorIpAddress;
    }

    /**
     * Sets the value of the collectorIpAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectorIpAddress(String value) {
        this.collectorIpAddress = value;
    }

    /**
     * Gets the value of the collectorPort property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCollectorPort() {
        return collectorPort;
    }

    /**
     * Sets the value of the collectorPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCollectorPort(Integer value) {
        this.collectorPort = value;
    }

    /**
     * Gets the value of the activeFlowTimeout property.
     * 
     */
    public int getActiveFlowTimeout() {
        return activeFlowTimeout;
    }

    /**
     * Sets the value of the activeFlowTimeout property.
     * 
     */
    public void setActiveFlowTimeout(int value) {
        this.activeFlowTimeout = value;
    }

    /**
     * Gets the value of the idleFlowTimeout property.
     * 
     */
    public int getIdleFlowTimeout() {
        return idleFlowTimeout;
    }

    /**
     * Sets the value of the idleFlowTimeout property.
     * 
     */
    public void setIdleFlowTimeout(int value) {
        this.idleFlowTimeout = value;
    }

    /**
     * Gets the value of the samplingRate property.
     * 
     */
    public int getSamplingRate() {
        return samplingRate;
    }

    /**
     * Sets the value of the samplingRate property.
     * 
     */
    public void setSamplingRate(int value) {
        this.samplingRate = value;
    }

    /**
     * Gets the value of the internalFlowsOnly property.
     * 
     */
    public boolean isInternalFlowsOnly() {
        return internalFlowsOnly;
    }

    /**
     * Sets the value of the internalFlowsOnly property.
     * 
     */
    public void setInternalFlowsOnly(boolean value) {
        this.internalFlowsOnly = value;
    }

}
