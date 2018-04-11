
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhysicalNic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PhysicalNic">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="device" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pci" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="driver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linkSpeed" type="{urn:vim25}PhysicalNicLinkInfo" minOccurs="0"/>
 *         &lt;element name="validLinkSpecification" type="{urn:vim25}PhysicalNicLinkInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="spec" type="{urn:vim25}PhysicalNicSpec"/>
 *         &lt;element name="wakeOnLanSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="mac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fcoeConfiguration" type="{urn:vim25}FcoeConfig" minOccurs="0"/>
 *         &lt;element name="vmDirectPathGen2Supported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vmDirectPathGen2SupportedMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resourcePoolSchedulerAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="resourcePoolSchedulerDisallowedReason" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="autoNegotiateSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalNic", propOrder = {
    "key",
    "device",
    "pci",
    "driver",
    "linkSpeed",
    "validLinkSpecification",
    "spec",
    "wakeOnLanSupported",
    "mac",
    "fcoeConfiguration",
    "vmDirectPathGen2Supported",
    "vmDirectPathGen2SupportedMode",
    "resourcePoolSchedulerAllowed",
    "resourcePoolSchedulerDisallowedReason",
    "autoNegotiateSupported"
})
public class PhysicalNic
    extends DynamicData
{

    protected String key;
    @XmlElement(required = true)
    protected String device;
    @XmlElement(required = true)
    protected String pci;
    protected String driver;
    protected PhysicalNicLinkInfo linkSpeed;
    protected List<PhysicalNicLinkInfo> validLinkSpecification;
    @XmlElement(required = true)
    protected PhysicalNicSpec spec;
    protected boolean wakeOnLanSupported;
    @XmlElement(required = true)
    protected String mac;
    protected FcoeConfig fcoeConfiguration;
    protected Boolean vmDirectPathGen2Supported;
    protected String vmDirectPathGen2SupportedMode;
    protected Boolean resourcePoolSchedulerAllowed;
    protected List<String> resourcePoolSchedulerDisallowedReason;
    protected Boolean autoNegotiateSupported;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevice(String value) {
        this.device = value;
    }

    /**
     * Gets the value of the pci property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPci() {
        return pci;
    }

    /**
     * Sets the value of the pci property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPci(String value) {
        this.pci = value;
    }

    /**
     * Gets the value of the driver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriver() {
        return driver;
    }

    /**
     * Sets the value of the driver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriver(String value) {
        this.driver = value;
    }

    /**
     * Gets the value of the linkSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalNicLinkInfo }
     *     
     */
    public PhysicalNicLinkInfo getLinkSpeed() {
        return linkSpeed;
    }

    /**
     * Sets the value of the linkSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalNicLinkInfo }
     *     
     */
    public void setLinkSpeed(PhysicalNicLinkInfo value) {
        this.linkSpeed = value;
    }

    /**
     * Gets the value of the validLinkSpecification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validLinkSpecification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidLinkSpecification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhysicalNicLinkInfo }
     * 
     * 
     */
    public List<PhysicalNicLinkInfo> getValidLinkSpecification() {
        if (validLinkSpecification == null) {
            validLinkSpecification = new ArrayList<PhysicalNicLinkInfo>();
        }
        return this.validLinkSpecification;
    }

    /**
     * Gets the value of the spec property.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalNicSpec }
     *     
     */
    public PhysicalNicSpec getSpec() {
        return spec;
    }

    /**
     * Sets the value of the spec property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalNicSpec }
     *     
     */
    public void setSpec(PhysicalNicSpec value) {
        this.spec = value;
    }

    /**
     * Gets the value of the wakeOnLanSupported property.
     * 
     */
    public boolean isWakeOnLanSupported() {
        return wakeOnLanSupported;
    }

    /**
     * Sets the value of the wakeOnLanSupported property.
     * 
     */
    public void setWakeOnLanSupported(boolean value) {
        this.wakeOnLanSupported = value;
    }

    /**
     * Gets the value of the mac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMac() {
        return mac;
    }

    /**
     * Sets the value of the mac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMac(String value) {
        this.mac = value;
    }

    /**
     * Gets the value of the fcoeConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link FcoeConfig }
     *     
     */
    public FcoeConfig getFcoeConfiguration() {
        return fcoeConfiguration;
    }

    /**
     * Sets the value of the fcoeConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link FcoeConfig }
     *     
     */
    public void setFcoeConfiguration(FcoeConfig value) {
        this.fcoeConfiguration = value;
    }

    /**
     * Gets the value of the vmDirectPathGen2Supported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVmDirectPathGen2Supported() {
        return vmDirectPathGen2Supported;
    }

    /**
     * Sets the value of the vmDirectPathGen2Supported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVmDirectPathGen2Supported(Boolean value) {
        this.vmDirectPathGen2Supported = value;
    }

    /**
     * Gets the value of the vmDirectPathGen2SupportedMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVmDirectPathGen2SupportedMode() {
        return vmDirectPathGen2SupportedMode;
    }

    /**
     * Sets the value of the vmDirectPathGen2SupportedMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVmDirectPathGen2SupportedMode(String value) {
        this.vmDirectPathGen2SupportedMode = value;
    }

    /**
     * Gets the value of the resourcePoolSchedulerAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isResourcePoolSchedulerAllowed() {
        return resourcePoolSchedulerAllowed;
    }

    /**
     * Sets the value of the resourcePoolSchedulerAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setResourcePoolSchedulerAllowed(Boolean value) {
        this.resourcePoolSchedulerAllowed = value;
    }

    /**
     * Gets the value of the resourcePoolSchedulerDisallowedReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourcePoolSchedulerDisallowedReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourcePoolSchedulerDisallowedReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getResourcePoolSchedulerDisallowedReason() {
        if (resourcePoolSchedulerDisallowedReason == null) {
            resourcePoolSchedulerDisallowedReason = new ArrayList<String>();
        }
        return this.resourcePoolSchedulerDisallowedReason;
    }

    /**
     * Gets the value of the autoNegotiateSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoNegotiateSupported() {
        return autoNegotiateSupported;
    }

    /**
     * Sets the value of the autoNegotiateSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoNegotiateSupported(Boolean value) {
        this.autoNegotiateSupported = value;
    }

}
