
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IscsiPortInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IscsiPortInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="vnicDevice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vnic" type="{urn:vim25}HostVirtualNic" minOccurs="0"/>
 *         &lt;element name="pnicDevice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pnic" type="{urn:vim25}PhysicalNic" minOccurs="0"/>
 *         &lt;element name="switchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="switchUuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="portgroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="portgroupKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="portKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="complianceStatus" type="{urn:vim25}IscsiStatus" minOccurs="0"/>
 *         &lt;element name="pathStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IscsiPortInfo", propOrder = {
    "vnicDevice",
    "vnic",
    "pnicDevice",
    "pnic",
    "switchName",
    "switchUuid",
    "portgroupName",
    "portgroupKey",
    "portKey",
    "complianceStatus",
    "pathStatus"
})
public class IscsiPortInfo
    extends DynamicData
{

    protected String vnicDevice;
    protected HostVirtualNic vnic;
    protected String pnicDevice;
    protected PhysicalNic pnic;
    protected String switchName;
    protected String switchUuid;
    protected String portgroupName;
    protected String portgroupKey;
    protected String portKey;
    protected IscsiStatus complianceStatus;
    protected String pathStatus;

    /**
     * Gets the value of the vnicDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVnicDevice() {
        return vnicDevice;
    }

    /**
     * Sets the value of the vnicDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVnicDevice(String value) {
        this.vnicDevice = value;
    }

    /**
     * Gets the value of the vnic property.
     * 
     * @return
     *     possible object is
     *     {@link HostVirtualNic }
     *     
     */
    public HostVirtualNic getVnic() {
        return vnic;
    }

    /**
     * Sets the value of the vnic property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostVirtualNic }
     *     
     */
    public void setVnic(HostVirtualNic value) {
        this.vnic = value;
    }

    /**
     * Gets the value of the pnicDevice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPnicDevice() {
        return pnicDevice;
    }

    /**
     * Sets the value of the pnicDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPnicDevice(String value) {
        this.pnicDevice = value;
    }

    /**
     * Gets the value of the pnic property.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalNic }
     *     
     */
    public PhysicalNic getPnic() {
        return pnic;
    }

    /**
     * Sets the value of the pnic property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalNic }
     *     
     */
    public void setPnic(PhysicalNic value) {
        this.pnic = value;
    }

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
     * Gets the value of the portKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortKey() {
        return portKey;
    }

    /**
     * Sets the value of the portKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortKey(String value) {
        this.portKey = value;
    }

    /**
     * Gets the value of the complianceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link IscsiStatus }
     *     
     */
    public IscsiStatus getComplianceStatus() {
        return complianceStatus;
    }

    /**
     * Sets the value of the complianceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IscsiStatus }
     *     
     */
    public void setComplianceStatus(IscsiStatus value) {
        this.complianceStatus = value;
    }

    /**
     * Gets the value of the pathStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathStatus() {
        return pathStatus;
    }

    /**
     * Sets the value of the pathStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathStatus(String value) {
        this.pathStatus = value;
    }

}
