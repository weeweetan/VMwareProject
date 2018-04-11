
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for HostRuntimeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostRuntimeInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="connectionState" type="{urn:vim25}HostSystemConnectionState"/>
 *         &lt;element name="powerState" type="{urn:vim25}HostSystemPowerState"/>
 *         &lt;element name="standbyMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inMaintenanceMode" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bootTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="healthSystemRuntime" type="{urn:vim25}HealthSystemRuntime" minOccurs="0"/>
 *         &lt;element name="dasHostState" type="{urn:vim25}ClusterDasFdmHostState" minOccurs="0"/>
 *         &lt;element name="tpmPcrValues" type="{urn:vim25}HostTpmDigestInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostRuntimeInfo", propOrder = {
    "connectionState",
    "powerState",
    "standbyMode",
    "inMaintenanceMode",
    "bootTime",
    "healthSystemRuntime",
    "dasHostState",
    "tpmPcrValues"
})
public class HostRuntimeInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected HostSystemConnectionState connectionState;
    @XmlElement(required = true)
    protected HostSystemPowerState powerState;
    protected String standbyMode;
    protected boolean inMaintenanceMode;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar bootTime;
    protected HealthSystemRuntime healthSystemRuntime;
    protected ClusterDasFdmHostState dasHostState;
    protected List<HostTpmDigestInfo> tpmPcrValues;

    /**
     * Gets the value of the connectionState property.
     * 
     * @return
     *     possible object is
     *     {@link HostSystemConnectionState }
     *     
     */
    public HostSystemConnectionState getConnectionState() {
        return connectionState;
    }

    /**
     * Sets the value of the connectionState property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostSystemConnectionState }
     *     
     */
    public void setConnectionState(HostSystemConnectionState value) {
        this.connectionState = value;
    }

    /**
     * Gets the value of the powerState property.
     * 
     * @return
     *     possible object is
     *     {@link HostSystemPowerState }
     *     
     */
    public HostSystemPowerState getPowerState() {
        return powerState;
    }

    /**
     * Sets the value of the powerState property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostSystemPowerState }
     *     
     */
    public void setPowerState(HostSystemPowerState value) {
        this.powerState = value;
    }

    /**
     * Gets the value of the standbyMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandbyMode() {
        return standbyMode;
    }

    /**
     * Sets the value of the standbyMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandbyMode(String value) {
        this.standbyMode = value;
    }

    /**
     * Gets the value of the inMaintenanceMode property.
     * 
     */
    public boolean isInMaintenanceMode() {
        return inMaintenanceMode;
    }

    /**
     * Sets the value of the inMaintenanceMode property.
     * 
     */
    public void setInMaintenanceMode(boolean value) {
        this.inMaintenanceMode = value;
    }

    /**
     * Gets the value of the bootTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBootTime() {
        return bootTime;
    }

    /**
     * Sets the value of the bootTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBootTime(XMLGregorianCalendar value) {
        this.bootTime = value;
    }

    /**
     * Gets the value of the healthSystemRuntime property.
     * 
     * @return
     *     possible object is
     *     {@link HealthSystemRuntime }
     *     
     */
    public HealthSystemRuntime getHealthSystemRuntime() {
        return healthSystemRuntime;
    }

    /**
     * Sets the value of the healthSystemRuntime property.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthSystemRuntime }
     *     
     */
    public void setHealthSystemRuntime(HealthSystemRuntime value) {
        this.healthSystemRuntime = value;
    }

    /**
     * Gets the value of the dasHostState property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterDasFdmHostState }
     *     
     */
    public ClusterDasFdmHostState getDasHostState() {
        return dasHostState;
    }

    /**
     * Sets the value of the dasHostState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterDasFdmHostState }
     *     
     */
    public void setDasHostState(ClusterDasFdmHostState value) {
        this.dasHostState = value;
    }

    /**
     * Gets the value of the tpmPcrValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tpmPcrValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTpmPcrValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostTpmDigestInfo }
     * 
     * 
     */
    public List<HostTpmDigestInfo> getTpmPcrValues() {
        if (tpmPcrValues == null) {
            tpmPcrValues = new ArrayList<HostTpmDigestInfo>();
        }
        return this.tpmPcrValues;
    }

}
