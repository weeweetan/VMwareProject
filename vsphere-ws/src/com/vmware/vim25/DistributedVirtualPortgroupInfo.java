
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistributedVirtualPortgroupInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributedVirtualPortgroupInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="switchName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="switchUuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portgroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portgroupKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portgroupType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uplinkPortgroup" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="portgroup" type="{urn:vim25}ManagedObjectReference"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributedVirtualPortgroupInfo", propOrder = {
    "switchName",
    "switchUuid",
    "portgroupName",
    "portgroupKey",
    "portgroupType",
    "uplinkPortgroup",
    "portgroup"
})
public class DistributedVirtualPortgroupInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String switchName;
    @XmlElement(required = true)
    protected String switchUuid;
    @XmlElement(required = true)
    protected String portgroupName;
    @XmlElement(required = true)
    protected String portgroupKey;
    @XmlElement(required = true)
    protected String portgroupType;
    protected boolean uplinkPortgroup;
    @XmlElement(required = true)
    protected ManagedObjectReference portgroup;

    /**
     * Gets the value of the switchName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwitchName() {
        return switchName;
    }

    /**
     * Sets the value of the switchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchName(String value) {
        this.switchName = value;
    }

    /**
     * Gets the value of the switchUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwitchUuid() {
        return switchUuid;
    }

    /**
     * Sets the value of the switchUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchUuid(String value) {
        this.switchUuid = value;
    }

    /**
     * Gets the value of the portgroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortgroupName() {
        return portgroupName;
    }

    /**
     * Sets the value of the portgroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortgroupName(String value) {
        this.portgroupName = value;
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
     * Gets the value of the portgroupType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortgroupType() {
        return portgroupType;
    }

    /**
     * Sets the value of the portgroupType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortgroupType(String value) {
        this.portgroupType = value;
    }

    /**
     * Gets the value of the uplinkPortgroup property.
     * 
     */
    public boolean isUplinkPortgroup() {
        return uplinkPortgroup;
    }

    /**
     * Sets the value of the uplinkPortgroup property.
     * 
     */
    public void setUplinkPortgroup(boolean value) {
        this.uplinkPortgroup = value;
    }

    /**
     * Gets the value of the portgroup property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getPortgroup() {
        return portgroup;
    }

    /**
     * Sets the value of the portgroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setPortgroup(ManagedObjectReference value) {
        this.portgroup = value;
    }

}
