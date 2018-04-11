
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSFeatureCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSFeatureCapability">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="networkResourceManagementSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vmDirectPathGen2Supported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nicTeamingPolicy" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="networkResourcePoolHighShareValue" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="networkResourceManagementCapability" type="{urn:vim25}DVSNetworkResourceManagementCapability" minOccurs="0"/>
 *         &lt;element name="healthCheckCapability" type="{urn:vim25}DVSHealthCheckCapability" minOccurs="0"/>
 *         &lt;element name="rollbackCapability" type="{urn:vim25}DVSRollbackCapability" minOccurs="0"/>
 *         &lt;element name="backupRestoreCapability" type="{urn:vim25}DVSBackupRestoreCapability" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSFeatureCapability", propOrder = {
    "networkResourceManagementSupported",
    "vmDirectPathGen2Supported",
    "nicTeamingPolicy",
    "networkResourcePoolHighShareValue",
    "networkResourceManagementCapability",
    "healthCheckCapability",
    "rollbackCapability",
    "backupRestoreCapability"
})
@XmlSeeAlso({
    VMwareDVSFeatureCapability.class
})
public class DVSFeatureCapability
    extends DynamicData
{

    protected boolean networkResourceManagementSupported;
    protected boolean vmDirectPathGen2Supported;
    protected List<String> nicTeamingPolicy;
    protected Integer networkResourcePoolHighShareValue;
    protected DVSNetworkResourceManagementCapability networkResourceManagementCapability;
    protected DVSHealthCheckCapability healthCheckCapability;
    protected DVSRollbackCapability rollbackCapability;
    protected DVSBackupRestoreCapability backupRestoreCapability;

    /**
     * Gets the value of the networkResourceManagementSupported property.
     * 
     */
    public boolean isNetworkResourceManagementSupported() {
        return networkResourceManagementSupported;
    }

    /**
     * Sets the value of the networkResourceManagementSupported property.
     * 
     */
    public void setNetworkResourceManagementSupported(boolean value) {
        this.networkResourceManagementSupported = value;
    }

    /**
     * Gets the value of the vmDirectPathGen2Supported property.
     * 
     */
    public boolean isVmDirectPathGen2Supported() {
        return vmDirectPathGen2Supported;
    }

    /**
     * Sets the value of the vmDirectPathGen2Supported property.
     * 
     */
    public void setVmDirectPathGen2Supported(boolean value) {
        this.vmDirectPathGen2Supported = value;
    }

    /**
     * Gets the value of the nicTeamingPolicy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nicTeamingPolicy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNicTeamingPolicy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNicTeamingPolicy() {
        if (nicTeamingPolicy == null) {
            nicTeamingPolicy = new ArrayList<String>();
        }
        return this.nicTeamingPolicy;
    }

    /**
     * Gets the value of the networkResourcePoolHighShareValue property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNetworkResourcePoolHighShareValue() {
        return networkResourcePoolHighShareValue;
    }

    /**
     * Sets the value of the networkResourcePoolHighShareValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNetworkResourcePoolHighShareValue(Integer value) {
        this.networkResourcePoolHighShareValue = value;
    }

    /**
     * Gets the value of the networkResourceManagementCapability property.
     * 
     * @return
     *     possible object is
     *     {@link DVSNetworkResourceManagementCapability }
     *     
     */
    public DVSNetworkResourceManagementCapability getNetworkResourceManagementCapability() {
        return networkResourceManagementCapability;
    }

    /**
     * Sets the value of the networkResourceManagementCapability property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVSNetworkResourceManagementCapability }
     *     
     */
    public void setNetworkResourceManagementCapability(DVSNetworkResourceManagementCapability value) {
        this.networkResourceManagementCapability = value;
    }

    /**
     * Gets the value of the healthCheckCapability property.
     * 
     * @return
     *     possible object is
     *     {@link DVSHealthCheckCapability }
     *     
     */
    public DVSHealthCheckCapability getHealthCheckCapability() {
        return healthCheckCapability;
    }

    /**
     * Sets the value of the healthCheckCapability property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVSHealthCheckCapability }
     *     
     */
    public void setHealthCheckCapability(DVSHealthCheckCapability value) {
        this.healthCheckCapability = value;
    }

    /**
     * Gets the value of the rollbackCapability property.
     * 
     * @return
     *     possible object is
     *     {@link DVSRollbackCapability }
     *     
     */
    public DVSRollbackCapability getRollbackCapability() {
        return rollbackCapability;
    }

    /**
     * Sets the value of the rollbackCapability property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVSRollbackCapability }
     *     
     */
    public void setRollbackCapability(DVSRollbackCapability value) {
        this.rollbackCapability = value;
    }

    /**
     * Gets the value of the backupRestoreCapability property.
     * 
     * @return
     *     possible object is
     *     {@link DVSBackupRestoreCapability }
     *     
     */
    public DVSBackupRestoreCapability getBackupRestoreCapability() {
        return backupRestoreCapability;
    }

    /**
     * Sets the value of the backupRestoreCapability property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVSBackupRestoreCapability }
     *     
     */
    public void setBackupRestoreCapability(DVSBackupRestoreCapability value) {
        this.backupRestoreCapability = value;
    }

}
