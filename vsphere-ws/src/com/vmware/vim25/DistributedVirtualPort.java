
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DistributedVirtualPort complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributedVirtualPort">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="config" type="{urn:vim25}DVPortConfigInfo"/>
 *         &lt;element name="dvsUuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portgroupKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proxyHost" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="connectee" type="{urn:vim25}DistributedVirtualSwitchPortConnectee" minOccurs="0"/>
 *         &lt;element name="conflict" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="conflictPortKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{urn:vim25}DVPortState" minOccurs="0"/>
 *         &lt;element name="connectionCookie" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lastStatusChange" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="hostLocalPort" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributedVirtualPort", propOrder = {
    "key",
    "config",
    "dvsUuid",
    "portgroupKey",
    "proxyHost",
    "connectee",
    "conflict",
    "conflictPortKey",
    "state",
    "connectionCookie",
    "lastStatusChange",
    "hostLocalPort"
})
public class DistributedVirtualPort
    extends DynamicData
{

    @XmlElement(required = true)
    protected String key;
    @XmlElement(required = true)
    protected DVPortConfigInfo config;
    @XmlElement(required = true)
    protected String dvsUuid;
    protected String portgroupKey;
    protected ManagedObjectReference proxyHost;
    protected DistributedVirtualSwitchPortConnectee connectee;
    protected boolean conflict;
    protected String conflictPortKey;
    protected DVPortState state;
    protected Integer connectionCookie;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastStatusChange;
    protected Boolean hostLocalPort;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the config property.
     * 
     * @return
     *     possible object is
     *     {@link DVPortConfigInfo }
     *     
     */
    public DVPortConfigInfo getConfig() {
        return config;
    }

    /**
     * Sets the value of the config property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVPortConfigInfo }
     *     
     */
    public void setConfig(DVPortConfigInfo value) {
        this.config = value;
    }

    /**
     * Gets the value of the dvsUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDvsUuid() {
        return dvsUuid;
    }

    /**
     * Sets the value of the dvsUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDvsUuid(String value) {
        this.dvsUuid = value;
    }

    /**
     * Gets the value of the portgroupKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortgroupKey() {
        return portgroupKey;
    }

    /**
     * Sets the value of the portgroupKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortgroupKey(String value) {
        this.portgroupKey = value;
    }

    /**
     * Gets the value of the proxyHost property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getProxyHost() {
        return proxyHost;
    }

    /**
     * Sets the value of the proxyHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setProxyHost(ManagedObjectReference value) {
        this.proxyHost = value;
    }

    /**
     * Gets the value of the connectee property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchPortConnectee }
     *     
     */
    public DistributedVirtualSwitchPortConnectee getConnectee() {
        return connectee;
    }

    /**
     * Sets the value of the connectee property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchPortConnectee }
     *     
     */
    public void setConnectee(DistributedVirtualSwitchPortConnectee value) {
        this.connectee = value;
    }

    /**
     * Gets the value of the conflict property.
     * 
     */
    public boolean isConflict() {
        return conflict;
    }

    /**
     * Sets the value of the conflict property.
     * 
     */
    public void setConflict(boolean value) {
        this.conflict = value;
    }

    /**
     * Gets the value of the conflictPortKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConflictPortKey() {
        return conflictPortKey;
    }

    /**
     * Sets the value of the conflictPortKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConflictPortKey(String value) {
        this.conflictPortKey = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link DVPortState }
     *     
     */
    public DVPortState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVPortState }
     *     
     */
    public void setState(DVPortState value) {
        this.state = value;
    }

    /**
     * Gets the value of the connectionCookie property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getConnectionCookie() {
        return connectionCookie;
    }

    /**
     * Sets the value of the connectionCookie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setConnectionCookie(Integer value) {
        this.connectionCookie = value;
    }

    /**
     * Gets the value of the lastStatusChange property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastStatusChange() {
        return lastStatusChange;
    }

    /**
     * Sets the value of the lastStatusChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastStatusChange(XMLGregorianCalendar value) {
        this.lastStatusChange = value;
    }

    /**
     * Gets the value of the hostLocalPort property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHostLocalPort() {
        return hostLocalPort;
    }

    /**
     * Sets the value of the hostLocalPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHostLocalPort(Boolean value) {
        this.hostLocalPort = value;
    }

}
