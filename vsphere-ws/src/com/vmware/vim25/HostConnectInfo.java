
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostConnectInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostConnectInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="serverIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inDasCluster" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="host" type="{urn:vim25}HostListSummary"/>
 *         &lt;element name="vm" type="{urn:vim25}VirtualMachineSummary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vimAccountNameRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="clusterSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="network" type="{urn:vim25}HostConnectInfoNetworkInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="datastore" type="{urn:vim25}HostDatastoreConnectInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="license" type="{urn:vim25}HostLicenseConnectInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostConnectInfo", propOrder = {
    "serverIp",
    "inDasCluster",
    "host",
    "vm",
    "vimAccountNameRequired",
    "clusterSupported",
    "network",
    "datastore",
    "license"
})
public class HostConnectInfo
    extends DynamicData
{

    protected String serverIp;
    protected Boolean inDasCluster;
    @XmlElement(required = true)
    protected HostListSummary host;
    protected List<VirtualMachineSummary> vm;
    protected Boolean vimAccountNameRequired;
    protected Boolean clusterSupported;
    protected List<HostConnectInfoNetworkInfo> network;
    protected List<HostDatastoreConnectInfo> datastore;
    protected HostLicenseConnectInfo license;

    /**
     * Gets the value of the serverIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * Sets the value of the serverIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerIp(String value) {
        this.serverIp = value;
    }

    /**
     * Gets the value of the inDasCluster property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInDasCluster() {
        return inDasCluster;
    }

    /**
     * Sets the value of the inDasCluster property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInDasCluster(Boolean value) {
        this.inDasCluster = value;
    }

    /**
     * Gets the value of the host property.
     * 
     * @return
     *     possible object is
     *     {@link HostListSummary }
     *     
     */
    public HostListSummary getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostListSummary }
     *     
     */
    public void setHost(HostListSummary value) {
        this.host = value;
    }

    /**
     * Gets the value of the vm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineSummary }
     * 
     * 
     */
    public List<VirtualMachineSummary> getVm() {
        if (vm == null) {
            vm = new ArrayList<VirtualMachineSummary>();
        }
        return this.vm;
    }

    /**
     * Gets the value of the vimAccountNameRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVimAccountNameRequired() {
        return vimAccountNameRequired;
    }

    /**
     * Sets the value of the vimAccountNameRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVimAccountNameRequired(Boolean value) {
        this.vimAccountNameRequired = value;
    }

    /**
     * Gets the value of the clusterSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isClusterSupported() {
        return clusterSupported;
    }

    /**
     * Sets the value of the clusterSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setClusterSupported(Boolean value) {
        this.clusterSupported = value;
    }

    /**
     * Gets the value of the network property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the network property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetwork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostConnectInfoNetworkInfo }
     * 
     * 
     */
    public List<HostConnectInfoNetworkInfo> getNetwork() {
        if (network == null) {
            network = new ArrayList<HostConnectInfoNetworkInfo>();
        }
        return this.network;
    }

    /**
     * Gets the value of the datastore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datastore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatastore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostDatastoreConnectInfo }
     * 
     * 
     */
    public List<HostDatastoreConnectInfo> getDatastore() {
        if (datastore == null) {
            datastore = new ArrayList<HostDatastoreConnectInfo>();
        }
        return this.datastore;
    }

    /**
     * Gets the value of the license property.
     * 
     * @return
     *     possible object is
     *     {@link HostLicenseConnectInfo }
     *     
     */
    public HostLicenseConnectInfo getLicense() {
        return license;
    }

    /**
     * Sets the value of the license property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostLicenseConnectInfo }
     *     
     */
    public void setLicense(HostLicenseConnectInfo value) {
        this.license = value;
    }

}
