
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostApplyProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostApplyProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ApplyProfile">
 *       &lt;sequence>
 *         &lt;element name="memory" type="{urn:vim25}HostMemoryProfile" minOccurs="0"/>
 *         &lt;element name="storage" type="{urn:vim25}StorageProfile" minOccurs="0"/>
 *         &lt;element name="network" type="{urn:vim25}NetworkProfile" minOccurs="0"/>
 *         &lt;element name="datetime" type="{urn:vim25}DateTimeProfile" minOccurs="0"/>
 *         &lt;element name="firewall" type="{urn:vim25}FirewallProfile" minOccurs="0"/>
 *         &lt;element name="security" type="{urn:vim25}SecurityProfile" minOccurs="0"/>
 *         &lt;element name="service" type="{urn:vim25}ServiceProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="option" type="{urn:vim25}OptionProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userAccount" type="{urn:vim25}UserProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usergroupAccount" type="{urn:vim25}UserGroupProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="authentication" type="{urn:vim25}AuthenticationProfile" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostApplyProfile", propOrder = {
    "memory",
    "storage",
    "network",
    "datetime",
    "firewall",
    "security",
    "service",
    "option",
    "userAccount",
    "usergroupAccount",
    "authentication"
})
public class HostApplyProfile
    extends ApplyProfile
{

    protected HostMemoryProfile memory;
    protected StorageProfile storage;
    protected NetworkProfile network;
    protected DateTimeProfile datetime;
    protected FirewallProfile firewall;
    protected SecurityProfile security;
    protected List<ServiceProfile> service;
    protected List<OptionProfile> option;
    protected List<UserProfile> userAccount;
    protected List<UserGroupProfile> usergroupAccount;
    protected AuthenticationProfile authentication;

    /**
     * Gets the value of the memory property.
     * 
     * @return
     *     possible object is
     *     {@link HostMemoryProfile }
     *     
     */
    public HostMemoryProfile getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostMemoryProfile }
     *     
     */
    public void setMemory(HostMemoryProfile value) {
        this.memory = value;
    }

    /**
     * Gets the value of the storage property.
     * 
     * @return
     *     possible object is
     *     {@link StorageProfile }
     *     
     */
    public StorageProfile getStorage() {
        return storage;
    }

    /**
     * Sets the value of the storage property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageProfile }
     *     
     */
    public void setStorage(StorageProfile value) {
        this.storage = value;
    }

    /**
     * Gets the value of the network property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkProfile }
     *     
     */
    public NetworkProfile getNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkProfile }
     *     
     */
    public void setNetwork(NetworkProfile value) {
        this.network = value;
    }

    /**
     * Gets the value of the datetime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeProfile }
     *     
     */
    public DateTimeProfile getDatetime() {
        return datetime;
    }

    /**
     * Sets the value of the datetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeProfile }
     *     
     */
    public void setDatetime(DateTimeProfile value) {
        this.datetime = value;
    }

    /**
     * Gets the value of the firewall property.
     * 
     * @return
     *     possible object is
     *     {@link FirewallProfile }
     *     
     */
    public FirewallProfile getFirewall() {
        return firewall;
    }

    /**
     * Sets the value of the firewall property.
     * 
     * @param value
     *     allowed object is
     *     {@link FirewallProfile }
     *     
     */
    public void setFirewall(FirewallProfile value) {
        this.firewall = value;
    }

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityProfile }
     *     
     */
    public SecurityProfile getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityProfile }
     *     
     */
    public void setSecurity(SecurityProfile value) {
        this.security = value;
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
     * {@link ServiceProfile }
     * 
     * 
     */
    public List<ServiceProfile> getService() {
        if (service == null) {
            service = new ArrayList<ServiceProfile>();
        }
        return this.service;
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
     * {@link OptionProfile }
     * 
     * 
     */
    public List<OptionProfile> getOption() {
        if (option == null) {
            option = new ArrayList<OptionProfile>();
        }
        return this.option;
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
     * {@link UserProfile }
     * 
     * 
     */
    public List<UserProfile> getUserAccount() {
        if (userAccount == null) {
            userAccount = new ArrayList<UserProfile>();
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
     * {@link UserGroupProfile }
     * 
     * 
     */
    public List<UserGroupProfile> getUsergroupAccount() {
        if (usergroupAccount == null) {
            usergroupAccount = new ArrayList<UserGroupProfile>();
        }
        return this.usergroupAccount;
    }

    /**
     * Gets the value of the authentication property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationProfile }
     *     
     */
    public AuthenticationProfile getAuthentication() {
        return authentication;
    }

    /**
     * Sets the value of the authentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationProfile }
     *     
     */
    public void setAuthentication(AuthenticationProfile value) {
        this.authentication = value;
    }

}
