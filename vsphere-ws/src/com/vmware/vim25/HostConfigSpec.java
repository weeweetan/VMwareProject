
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="nasDatastore" type="{urn:vim25}HostNasVolumeConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="network" type="{urn:vim25}HostNetworkConfig" minOccurs="0"/>
 *         &lt;element name="nicTypeSelection" type="{urn:vim25}HostVirtualNicManagerNicTypeSelection" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="service" type="{urn:vim25}HostServiceConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="firewall" type="{urn:vim25}HostFirewallConfig" minOccurs="0"/>
 *         &lt;element name="option" type="{urn:vim25}OptionValue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="datastorePrincipal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datastorePrincipalPasswd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datetime" type="{urn:vim25}HostDateTimeConfig" minOccurs="0"/>
 *         &lt;element name="storageDevice" type="{urn:vim25}HostStorageDeviceInfo" minOccurs="0"/>
 *         &lt;element name="license" type="{urn:vim25}HostLicenseSpec" minOccurs="0"/>
 *         &lt;element name="security" type="{urn:vim25}HostSecuritySpec" minOccurs="0"/>
 *         &lt;element name="userAccount" type="{urn:vim25}HostAccountSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usergroupAccount" type="{urn:vim25}HostAccountSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="memory" type="{urn:vim25}HostMemorySpec" minOccurs="0"/>
 *         &lt;element name="activeDirectory" type="{urn:vim25}HostActiveDirectory" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="genericConfig" type="{urn:vim25}KeyAnyValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostConfigSpec", propOrder = {
    "nasDatastore",
    "network",
    "nicTypeSelection",
    "service",
    "firewall",
    "option",
    "datastorePrincipal",
    "datastorePrincipalPasswd",
    "datetime",
    "storageDevice",
    "license",
    "security",
    "userAccount",
    "usergroupAccount",
    "memory",
    "activeDirectory",
    "genericConfig"
})
public class HostConfigSpec
    extends DynamicData
{

    protected List<HostNasVolumeConfig> nasDatastore;
    protected HostNetworkConfig network;
    protected List<HostVirtualNicManagerNicTypeSelection> nicTypeSelection;
    protected List<HostServiceConfig> service;
    protected HostFirewallConfig firewall;
    protected List<OptionValue> option;
    protected String datastorePrincipal;
    protected String datastorePrincipalPasswd;
    protected HostDateTimeConfig datetime;
    protected HostStorageDeviceInfo storageDevice;
    protected HostLicenseSpec license;
    protected HostSecuritySpec security;
    protected List<HostAccountSpec> userAccount;
    protected List<HostAccountSpec> usergroupAccount;
    protected HostMemorySpec memory;
    protected List<HostActiveDirectory> activeDirectory;
    protected List<KeyAnyValue> genericConfig;

    /**
     * Gets the value of the nasDatastore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nasDatastore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNasDatastore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostNasVolumeConfig }
     * 
     * 
     */
    public List<HostNasVolumeConfig> getNasDatastore() {
        if (nasDatastore == null) {
            nasDatastore = new ArrayList<HostNasVolumeConfig>();
        }
        return this.nasDatastore;
    }

    /**
     * Gets the value of the network property.
     * 
     * @return
     *     possible object is
     *     {@link HostNetworkConfig }
     *     
     */
    public HostNetworkConfig getNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostNetworkConfig }
     *     
     */
    public void setNetwork(HostNetworkConfig value) {
        this.network = value;
    }

    /**
     * Gets the value of the nicTypeSelection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nicTypeSelection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNicTypeSelection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostVirtualNicManagerNicTypeSelection }
     * 
     * 
     */
    public List<HostVirtualNicManagerNicTypeSelection> getNicTypeSelection() {
        if (nicTypeSelection == null) {
            nicTypeSelection = new ArrayList<HostVirtualNicManagerNicTypeSelection>();
        }
        return this.nicTypeSelection;
    }

    /**
     * Gets the value of the service property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the service property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostServiceConfig }
     * 
     * 
     */
    public List<HostServiceConfig> getService() {
        if (service == null) {
            service = new ArrayList<HostServiceConfig>();
        }
        return this.service;
    }

    /**
     * Gets the value of the firewall property.
     * 
     * @return
     *     possible object is
     *     {@link HostFirewallConfig }
     *     
     */
    public HostFirewallConfig getFirewall() {
        return firewall;
    }

    /**
     * Sets the value of the firewall property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostFirewallConfig }
     *     
     */
    public void setFirewall(HostFirewallConfig value) {
        this.firewall = value;
    }

    /**
     * Gets the value of the option property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the option property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionValue }
     * 
     * 
     */
    public List<OptionValue> getOption() {
        if (option == null) {
            option = new ArrayList<OptionValue>();
        }
        return this.option;
    }

    /**
     * Gets the value of the datastorePrincipal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatastorePrincipal() {
        return datastorePrincipal;
    }

    /**
     * Sets the value of the datastorePrincipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatastorePrincipal(String value) {
        this.datastorePrincipal = value;
    }

    /**
     * Gets the value of the datastorePrincipalPasswd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatastorePrincipalPasswd() {
        return datastorePrincipalPasswd;
    }

    /**
     * Sets the value of the datastorePrincipalPasswd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatastorePrincipalPasswd(String value) {
        this.datastorePrincipalPasswd = value;
    }

    /**
     * Gets the value of the datetime property.
     * 
     * @return
     *     possible object is
     *     {@link HostDateTimeConfig }
     *     
     */
    public HostDateTimeConfig getDatetime() {
        return datetime;
    }

    /**
     * Sets the value of the datetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostDateTimeConfig }
     *     
     */
    public void setDatetime(HostDateTimeConfig value) {
        this.datetime = value;
    }

    /**
     * Gets the value of the storageDevice property.
     * 
     * @return
     *     possible object is
     *     {@link HostStorageDeviceInfo }
     *     
     */
    public HostStorageDeviceInfo getStorageDevice() {
        return storageDevice;
    }

    /**
     * Sets the value of the storageDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostStorageDeviceInfo }
     *     
     */
    public void setStorageDevice(HostStorageDeviceInfo value) {
        this.storageDevice = value;
    }

    /**
     * Gets the value of the license property.
     * 
     * @return
     *     possible object is
     *     {@link HostLicenseSpec }
     *     
     */
    public HostLicenseSpec getLicense() {
        return license;
    }

    /**
     * Sets the value of the license property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostLicenseSpec }
     *     
     */
    public void setLicense(HostLicenseSpec value) {
        this.license = value;
    }

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link HostSecuritySpec }
     *     
     */
    public HostSecuritySpec getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostSecuritySpec }
     *     
     */
    public void setSecurity(HostSecuritySpec value) {
        this.security = value;
    }

    /**
     * Gets the value of the userAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostAccountSpec }
     * 
     * 
     */
    public List<HostAccountSpec> getUserAccount() {
        if (userAccount == null) {
            userAccount = new ArrayList<HostAccountSpec>();
        }
        return this.userAccount;
    }

    /**
     * Gets the value of the usergroupAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usergroupAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsergroupAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostAccountSpec }
     * 
     * 
     */
    public List<HostAccountSpec> getUsergroupAccount() {
        if (usergroupAccount == null) {
            usergroupAccount = new ArrayList<HostAccountSpec>();
        }
        return this.usergroupAccount;
    }

    /**
     * Gets the value of the memory property.
     * 
     * @return
     *     possible object is
     *     {@link HostMemorySpec }
     *     
     */
    public HostMemorySpec getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostMemorySpec }
     *     
     */
    public void setMemory(HostMemorySpec value) {
        this.memory = value;
    }

    /**
     * Gets the value of the activeDirectory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activeDirectory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActiveDirectory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostActiveDirectory }
     * 
     * 
     */
    public List<HostActiveDirectory> getActiveDirectory() {
        if (activeDirectory == null) {
            activeDirectory = new ArrayList<HostActiveDirectory>();
        }
        return this.activeDirectory;
    }

    /**
     * Gets the value of the genericConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyAnyValue }
     * 
     * 
     */
    public List<KeyAnyValue> getGenericConfig() {
        if (genericConfig == null) {
            genericConfig = new ArrayList<KeyAnyValue>();
        }
        return this.genericConfig;
    }

}
