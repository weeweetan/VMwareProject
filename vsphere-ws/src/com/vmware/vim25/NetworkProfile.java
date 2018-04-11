
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetworkProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NetworkProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ApplyProfile">
 *       &lt;sequence>
 *         &lt;element name="vswitch" type="{urn:vim25}VirtualSwitchProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vmPortGroup" type="{urn:vim25}VmPortGroupProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hostPortGroup" type="{urn:vim25}HostPortGroupProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="serviceConsolePortGroup" type="{urn:vim25}ServiceConsolePortGroupProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dnsConfig" type="{urn:vim25}NetworkProfileDnsConfigProfile" minOccurs="0"/>
 *         &lt;element name="ipRouteConfig" type="{urn:vim25}IpRouteProfile" minOccurs="0"/>
 *         &lt;element name="consoleIpRouteConfig" type="{urn:vim25}IpRouteProfile" minOccurs="0"/>
 *         &lt;element name="pnic" type="{urn:vim25}PhysicalNicProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dvswitch" type="{urn:vim25}DvsProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dvsServiceConsoleNic" type="{urn:vim25}DvsServiceConsoleVNicProfile" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dvsHostNic" type="{urn:vim25}DvsHostVNicProfile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkProfile", propOrder = {
    "vswitch",
    "vmPortGroup",
    "hostPortGroup",
    "serviceConsolePortGroup",
    "dnsConfig",
    "ipRouteConfig",
    "consoleIpRouteConfig",
    "pnic",
    "dvswitch",
    "dvsServiceConsoleNic",
    "dvsHostNic"
})
public class NetworkProfile
    extends ApplyProfile
{

    protected List<VirtualSwitchProfile> vswitch;
    protected List<VmPortGroupProfile> vmPortGroup;
    protected List<HostPortGroupProfile> hostPortGroup;
    protected List<ServiceConsolePortGroupProfile> serviceConsolePortGroup;
    protected NetworkProfileDnsConfigProfile dnsConfig;
    protected IpRouteProfile ipRouteConfig;
    protected IpRouteProfile consoleIpRouteConfig;
    protected List<PhysicalNicProfile> pnic;
    protected List<DvsProfile> dvswitch;
    protected List<DvsServiceConsoleVNicProfile> dvsServiceConsoleNic;
    protected List<DvsHostVNicProfile> dvsHostNic;

    /**
     * Gets the value of the vswitch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vswitch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVswitch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualSwitchProfile }
     * 
     * 
     */
    public List<VirtualSwitchProfile> getVswitch() {
        if (vswitch == null) {
            vswitch = new ArrayList<VirtualSwitchProfile>();
        }
        return this.vswitch;
    }

    /**
     * Gets the value of the vmPortGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmPortGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmPortGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmPortGroupProfile }
     * 
     * 
     */
    public List<VmPortGroupProfile> getVmPortGroup() {
        if (vmPortGroup == null) {
            vmPortGroup = new ArrayList<VmPortGroupProfile>();
        }
        return this.vmPortGroup;
    }

    /**
     * Gets the value of the hostPortGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostPortGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostPortGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPortGroupProfile }
     * 
     * 
     */
    public List<HostPortGroupProfile> getHostPortGroup() {
        if (hostPortGroup == null) {
            hostPortGroup = new ArrayList<HostPortGroupProfile>();
        }
        return this.hostPortGroup;
    }

    /**
     * Gets the value of the serviceConsolePortGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceConsolePortGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceConsolePortGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceConsolePortGroupProfile }
     * 
     * 
     */
    public List<ServiceConsolePortGroupProfile> getServiceConsolePortGroup() {
        if (serviceConsolePortGroup == null) {
            serviceConsolePortGroup = new ArrayList<ServiceConsolePortGroupProfile>();
        }
        return this.serviceConsolePortGroup;
    }

    /**
     * Gets the value of the dnsConfig property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkProfileDnsConfigProfile }
     *     
     */
    public NetworkProfileDnsConfigProfile getDnsConfig() {
        return dnsConfig;
    }

    /**
     * Sets the value of the dnsConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkProfileDnsConfigProfile }
     *     
     */
    public void setDnsConfig(NetworkProfileDnsConfigProfile value) {
        this.dnsConfig = value;
    }

    /**
     * Gets the value of the ipRouteConfig property.
     * 
     * @return
     *     possible object is
     *     {@link IpRouteProfile }
     *     
     */
    public IpRouteProfile getIpRouteConfig() {
        return ipRouteConfig;
    }

    /**
     * Sets the value of the ipRouteConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link IpRouteProfile }
     *     
     */
    public void setIpRouteConfig(IpRouteProfile value) {
        this.ipRouteConfig = value;
    }

    /**
     * Gets the value of the consoleIpRouteConfig property.
     * 
     * @return
     *     possible object is
     *     {@link IpRouteProfile }
     *     
     */
    public IpRouteProfile getConsoleIpRouteConfig() {
        return consoleIpRouteConfig;
    }

    /**
     * Sets the value of the consoleIpRouteConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link IpRouteProfile }
     *     
     */
    public void setConsoleIpRouteConfig(IpRouteProfile value) {
        this.consoleIpRouteConfig = value;
    }

    /**
     * Gets the value of the pnic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pnic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPnic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhysicalNicProfile }
     * 
     * 
     */
    public List<PhysicalNicProfile> getPnic() {
        if (pnic == null) {
            pnic = new ArrayList<PhysicalNicProfile>();
        }
        return this.pnic;
    }

    /**
     * Gets the value of the dvswitch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dvswitch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDvswitch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DvsProfile }
     * 
     * 
     */
    public List<DvsProfile> getDvswitch() {
        if (dvswitch == null) {
            dvswitch = new ArrayList<DvsProfile>();
        }
        return this.dvswitch;
    }

    /**
     * Gets the value of the dvsServiceConsoleNic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dvsServiceConsoleNic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDvsServiceConsoleNic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DvsServiceConsoleVNicProfile }
     * 
     * 
     */
    public List<DvsServiceConsoleVNicProfile> getDvsServiceConsoleNic() {
        if (dvsServiceConsoleNic == null) {
            dvsServiceConsoleNic = new ArrayList<DvsServiceConsoleVNicProfile>();
        }
        return this.dvsServiceConsoleNic;
    }

    /**
     * Gets the value of the dvsHostNic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dvsHostNic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDvsHostNic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DvsHostVNicProfile }
     * 
     * 
     */
    public List<DvsHostVNicProfile> getDvsHostNic() {
        if (dvsHostNic == null) {
            dvsHostNic = new ArrayList<DvsHostVNicProfile>();
        }
        return this.dvsHostNic;
    }

}
