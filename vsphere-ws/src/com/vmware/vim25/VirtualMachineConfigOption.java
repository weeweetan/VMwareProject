
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineConfigOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineConfigOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="guestOSDescriptor" type="{urn:vim25}GuestOsDescriptor" maxOccurs="unbounded"/>
 *         &lt;element name="guestOSDefaultIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hardwareOptions" type="{urn:vim25}VirtualHardwareOption"/>
 *         &lt;element name="capabilities" type="{urn:vim25}VirtualMachineCapability"/>
 *         &lt;element name="datastore" type="{urn:vim25}DatastoreOption"/>
 *         &lt;element name="defaultDevice" type="{urn:vim25}VirtualDevice" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="supportedMonitorType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="supportedOvfEnvironmentTransport" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="supportedOvfInstallTransport" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineConfigOption", propOrder = {
    "version",
    "description",
    "guestOSDescriptor",
    "guestOSDefaultIndex",
    "hardwareOptions",
    "capabilities",
    "datastore",
    "defaultDevice",
    "supportedMonitorType",
    "supportedOvfEnvironmentTransport",
    "supportedOvfInstallTransport"
})
public class VirtualMachineConfigOption
    extends DynamicData
{

    @XmlElement(required = true)
    protected String version;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected List<GuestOsDescriptor> guestOSDescriptor;
    protected int guestOSDefaultIndex;
    @XmlElement(required = true)
    protected VirtualHardwareOption hardwareOptions;
    @XmlElement(required = true)
    protected VirtualMachineCapability capabilities;
    @XmlElement(required = true)
    protected DatastoreOption datastore;
    protected List<VirtualDevice> defaultDevice;
    @XmlElement(required = true)
    protected List<String> supportedMonitorType;
    protected List<String> supportedOvfEnvironmentTransport;
    protected List<String> supportedOvfInstallTransport;

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
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
     * Gets the value of the guestOSDescriptor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the guestOSDescriptor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuestOSDescriptor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuestOsDescriptor }
     * 
     * 
     */
    public List<GuestOsDescriptor> getGuestOSDescriptor() {
        if (guestOSDescriptor == null) {
            guestOSDescriptor = new ArrayList<GuestOsDescriptor>();
        }
        return this.guestOSDescriptor;
    }

    /**
     * Gets the value of the guestOSDefaultIndex property.
     * 
     */
    public int getGuestOSDefaultIndex() {
        return guestOSDefaultIndex;
    }

    /**
     * Sets the value of the guestOSDefaultIndex property.
     * 
     */
    public void setGuestOSDefaultIndex(int value) {
        this.guestOSDefaultIndex = value;
    }

    /**
     * Gets the value of the hardwareOptions property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualHardwareOption }
     *     
     */
    public VirtualHardwareOption getHardwareOptions() {
        return hardwareOptions;
    }

    /**
     * Sets the value of the hardwareOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualHardwareOption }
     *     
     */
    public void setHardwareOptions(VirtualHardwareOption value) {
        this.hardwareOptions = value;
    }

    /**
     * Gets the value of the capabilities property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineCapability }
     *     
     */
    public VirtualMachineCapability getCapabilities() {
        return capabilities;
    }

    /**
     * Sets the value of the capabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineCapability }
     *     
     */
    public void setCapabilities(VirtualMachineCapability value) {
        this.capabilities = value;
    }

    /**
     * Gets the value of the datastore property.
     * 
     * @return
     *     possible object is
     *     {@link DatastoreOption }
     *     
     */
    public DatastoreOption getDatastore() {
        return datastore;
    }

    /**
     * Sets the value of the datastore property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatastoreOption }
     *     
     */
    public void setDatastore(DatastoreOption value) {
        this.datastore = value;
    }

    /**
     * Gets the value of the defaultDevice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the defaultDevice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDefaultDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualDevice }
     * 
     * 
     */
    public List<VirtualDevice> getDefaultDevice() {
        if (defaultDevice == null) {
            defaultDevice = new ArrayList<VirtualDevice>();
        }
        return this.defaultDevice;
    }

    /**
     * Gets the value of the supportedMonitorType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedMonitorType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedMonitorType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedMonitorType() {
        if (supportedMonitorType == null) {
            supportedMonitorType = new ArrayList<String>();
        }
        return this.supportedMonitorType;
    }

    /**
     * Gets the value of the supportedOvfEnvironmentTransport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedOvfEnvironmentTransport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedOvfEnvironmentTransport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedOvfEnvironmentTransport() {
        if (supportedOvfEnvironmentTransport == null) {
            supportedOvfEnvironmentTransport = new ArrayList<String>();
        }
        return this.supportedOvfEnvironmentTransport;
    }

    /**
     * Gets the value of the supportedOvfInstallTransport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedOvfInstallTransport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedOvfInstallTransport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedOvfInstallTransport() {
        if (supportedOvfInstallTransport == null) {
            supportedOvfInstallTransport = new ArrayList<String>();
        }
        return this.supportedOvfInstallTransport;
    }

}
