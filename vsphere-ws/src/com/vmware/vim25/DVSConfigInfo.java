
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DVSConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numStandalonePorts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numPorts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxPorts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="uplinkPortPolicy" type="{urn:vim25}DVSUplinkPortPolicy"/>
 *         &lt;element name="uplinkPortgroup" type="{urn:vim25}ManagedObjectReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="defaultPortConfig" type="{urn:vim25}DVPortSetting"/>
 *         &lt;element name="host" type="{urn:vim25}DistributedVirtualSwitchHostMember" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productInfo" type="{urn:vim25}DistributedVirtualSwitchProductSpec"/>
 *         &lt;element name="targetInfo" type="{urn:vim25}DistributedVirtualSwitchProductSpec" minOccurs="0"/>
 *         &lt;element name="extensionKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vendorSpecificConfig" type="{urn:vim25}DistributedVirtualSwitchKeyedOpaqueBlob" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="policy" type="{urn:vim25}DVSPolicy" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="configVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contact" type="{urn:vim25}DVSContactInfo"/>
 *         &lt;element name="switchIpAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="networkResourceManagementEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="defaultProxySwitchMaxNumPorts" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="healthCheckConfig" type="{urn:vim25}DVSHealthCheckConfig" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSConfigInfo", propOrder = {
    "uuid",
    "name",
    "numStandalonePorts",
    "numPorts",
    "maxPorts",
    "uplinkPortPolicy",
    "uplinkPortgroup",
    "defaultPortConfig",
    "host",
    "productInfo",
    "targetInfo",
    "extensionKey",
    "vendorSpecificConfig",
    "policy",
    "description",
    "configVersion",
    "contact",
    "switchIpAddress",
    "createTime",
    "networkResourceManagementEnabled",
    "defaultProxySwitchMaxNumPorts",
    "healthCheckConfig"
})
@XmlSeeAlso({
    VMwareDVSConfigInfo.class
})
public class DVSConfigInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String uuid;
    @XmlElement(required = true)
    protected String name;
    protected int numStandalonePorts;
    protected int numPorts;
    protected int maxPorts;
    @XmlElement(required = true)
    protected DVSUplinkPortPolicy uplinkPortPolicy;
    protected List<ManagedObjectReference> uplinkPortgroup;
    @XmlElement(required = true)
    protected DVPortSetting defaultPortConfig;
    protected List<DistributedVirtualSwitchHostMember> host;
    @XmlElement(required = true)
    protected DistributedVirtualSwitchProductSpec productInfo;
    protected DistributedVirtualSwitchProductSpec targetInfo;
    protected String extensionKey;
    protected List<DistributedVirtualSwitchKeyedOpaqueBlob> vendorSpecificConfig;
    protected DVSPolicy policy;
    protected String description;
    @XmlElement(required = true)
    protected String configVersion;
    @XmlElement(required = true)
    protected DVSContactInfo contact;
    protected String switchIpAddress;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    protected Boolean networkResourceManagementEnabled;
    protected Integer defaultProxySwitchMaxNumPorts;
    protected List<DVSHealthCheckConfig> healthCheckConfig;

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the numStandalonePorts property.
     * 
     */
    public int getNumStandalonePorts() {
        return numStandalonePorts;
    }

    /**
     * Sets the value of the numStandalonePorts property.
     * 
     */
    public void setNumStandalonePorts(int value) {
        this.numStandalonePorts = value;
    }

    /**
     * Gets the value of the numPorts property.
     * 
     */
    public int getNumPorts() {
        return numPorts;
    }

    /**
     * Sets the value of the numPorts property.
     * 
     */
    public void setNumPorts(int value) {
        this.numPorts = value;
    }

    /**
     * Gets the value of the maxPorts property.
     * 
     */
    public int getMaxPorts() {
        return maxPorts;
    }

    /**
     * Sets the value of the maxPorts property.
     * 
     */
    public void setMaxPorts(int value) {
        this.maxPorts = value;
    }

    /**
     * Gets the value of the uplinkPortPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link DVSUplinkPortPolicy }
     *     
     */
    public DVSUplinkPortPolicy getUplinkPortPolicy() {
        return uplinkPortPolicy;
    }

    /**
     * Sets the value of the uplinkPortPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVSUplinkPortPolicy }
     *     
     */
    public void setUplinkPortPolicy(DVSUplinkPortPolicy value) {
        this.uplinkPortPolicy = value;
    }

    /**
     * Gets the value of the uplinkPortgroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uplinkPortgroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUplinkPortgroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ManagedObjectReference }
     * 
     * 
     */
    public List<ManagedObjectReference> getUplinkPortgroup() {
        if (uplinkPortgroup == null) {
            uplinkPortgroup = new ArrayList<ManagedObjectReference>();
        }
        return this.uplinkPortgroup;
    }

    /**
     * Gets the value of the defaultPortConfig property.
     * 
     * @return
     *     possible object is
     *     {@link DVPortSetting }
     *     
     */
    public DVPortSetting getDefaultPortConfig() {
        return defaultPortConfig;
    }

    /**
     * Sets the value of the defaultPortConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVPortSetting }
     *     
     */
    public void setDefaultPortConfig(DVPortSetting value) {
        this.defaultPortConfig = value;
    }

    /**
     * Gets the value of the host property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the host property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributedVirtualSwitchHostMember }
     * 
     * 
     */
    public List<DistributedVirtualSwitchHostMember> getHost() {
        if (host == null) {
            host = new ArrayList<DistributedVirtualSwitchHostMember>();
        }
        return this.host;
    }

    /**
     * Gets the value of the productInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchProductSpec }
     *     
     */
    public DistributedVirtualSwitchProductSpec getProductInfo() {
        return productInfo;
    }

    /**
     * Sets the value of the productInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchProductSpec }
     *     
     */
    public void setProductInfo(DistributedVirtualSwitchProductSpec value) {
        this.productInfo = value;
    }

    /**
     * Gets the value of the targetInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchProductSpec }
     *     
     */
    public DistributedVirtualSwitchProductSpec getTargetInfo() {
        return targetInfo;
    }

    /**
     * Sets the value of the targetInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchProductSpec }
     *     
     */
    public void setTargetInfo(DistributedVirtualSwitchProductSpec value) {
        this.targetInfo = value;
    }

    /**
     * Gets the value of the extensionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtensionKey() {
        return extensionKey;
    }

    /**
     * Sets the value of the extensionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtensionKey(String value) {
        this.extensionKey = value;
    }

    /**
     * Gets the value of the vendorSpecificConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vendorSpecificConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVendorSpecificConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributedVirtualSwitchKeyedOpaqueBlob }
     * 
     * 
     */
    public List<DistributedVirtualSwitchKeyedOpaqueBlob> getVendorSpecificConfig() {
        if (vendorSpecificConfig == null) {
            vendorSpecificConfig = new ArrayList<DistributedVirtualSwitchKeyedOpaqueBlob>();
        }
        return this.vendorSpecificConfig;
    }

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link DVSPolicy }
     *     
     */
    public DVSPolicy getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVSPolicy }
     *     
     */
    public void setPolicy(DVSPolicy value) {
        this.policy = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the configVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigVersion() {
        return configVersion;
    }

    /**
     * Sets the value of the configVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigVersion(String value) {
        this.configVersion = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link DVSContactInfo }
     *     
     */
    public DVSContactInfo getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVSContactInfo }
     *     
     */
    public void setContact(DVSContactInfo value) {
        this.contact = value;
    }

    /**
     * Gets the value of the switchIpAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwitchIpAddress() {
        return switchIpAddress;
    }

    /**
     * Sets the value of the switchIpAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchIpAddress(String value) {
        this.switchIpAddress = value;
    }

    /**
     * Gets the value of the createTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * Sets the value of the createTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
    }

    /**
     * Gets the value of the networkResourceManagementEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNetworkResourceManagementEnabled() {
        return networkResourceManagementEnabled;
    }

    /**
     * Sets the value of the networkResourceManagementEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNetworkResourceManagementEnabled(Boolean value) {
        this.networkResourceManagementEnabled = value;
    }

    /**
     * Gets the value of the defaultProxySwitchMaxNumPorts property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultProxySwitchMaxNumPorts() {
        return defaultProxySwitchMaxNumPorts;
    }

    /**
     * Sets the value of the defaultProxySwitchMaxNumPorts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultProxySwitchMaxNumPorts(Integer value) {
        this.defaultProxySwitchMaxNumPorts = value;
    }

    /**
     * Gets the value of the healthCheckConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the healthCheckConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHealthCheckConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DVSHealthCheckConfig }
     * 
     * 
     */
    public List<DVSHealthCheckConfig> getHealthCheckConfig() {
        if (healthCheckConfig == null) {
            healthCheckConfig = new ArrayList<DVSHealthCheckConfig>();
        }
        return this.healthCheckConfig;
    }

}
