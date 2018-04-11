
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDeviceOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDeviceOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="connectOption" type="{urn:vim25}VirtualDeviceConnectOption" minOccurs="0"/>
 *         &lt;element name="busSlotOption" type="{urn:vim25}VirtualDeviceBusSlotOption" minOccurs="0"/>
 *         &lt;element name="controllerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="autoAssignController" type="{urn:vim25}BoolOption" minOccurs="0"/>
 *         &lt;element name="backingOption" type="{urn:vim25}VirtualDeviceBackingOption" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="defaultBackingOptionIndex" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="licensingLimit" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deprecated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="plugAndPlay" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hotRemoveSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDeviceOption", propOrder = {
    "type",
    "connectOption",
    "busSlotOption",
    "controllerType",
    "autoAssignController",
    "backingOption",
    "defaultBackingOptionIndex",
    "licensingLimit",
    "deprecated",
    "plugAndPlay",
    "hotRemoveSupported"
})
@XmlSeeAlso({
    VirtualKeyboardOption.class,
    VirtualSerialPortOption.class,
    VirtualVMIROMOption.class,
    VirtualParallelPortOption.class,
    VirtualVideoCardOption.class,
    VirtualFloppyOption.class,
    VirtualMachineVMCIDeviceOption.class,
    VirtualPointingDeviceOption.class,
    VirtualCdromOption.class,
    VirtualUSBOption.class,
    VirtualPCIPassthroughOption.class,
    VirtualEthernetCardOption.class,
    VirtualDiskOption.class,
    VirtualSCSIPassthroughOption.class,
    VirtualSoundCardOption.class,
    VirtualControllerOption.class
})
public class VirtualDeviceOption
    extends DynamicData
{

    @XmlElement(required = true)
    protected String type;
    protected VirtualDeviceConnectOption connectOption;
    protected VirtualDeviceBusSlotOption busSlotOption;
    protected String controllerType;
    protected BoolOption autoAssignController;
    protected List<VirtualDeviceBackingOption> backingOption;
    protected Integer defaultBackingOptionIndex;
    protected List<String> licensingLimit;
    protected boolean deprecated;
    protected boolean plugAndPlay;
    protected Boolean hotRemoveSupported;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the connectOption property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualDeviceConnectOption }
     *     
     */
    public VirtualDeviceConnectOption getConnectOption() {
        return connectOption;
    }

    /**
     * Sets the value of the connectOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualDeviceConnectOption }
     *     
     */
    public void setConnectOption(VirtualDeviceConnectOption value) {
        this.connectOption = value;
    }

    /**
     * Gets the value of the busSlotOption property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualDeviceBusSlotOption }
     *     
     */
    public VirtualDeviceBusSlotOption getBusSlotOption() {
        return busSlotOption;
    }

    /**
     * Sets the value of the busSlotOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualDeviceBusSlotOption }
     *     
     */
    public void setBusSlotOption(VirtualDeviceBusSlotOption value) {
        this.busSlotOption = value;
    }

    /**
     * Gets the value of the controllerType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControllerType() {
        return controllerType;
    }

    /**
     * Sets the value of the controllerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControllerType(String value) {
        this.controllerType = value;
    }

    /**
     * Gets the value of the autoAssignController property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getAutoAssignController() {
        return autoAssignController;
    }

    /**
     * Sets the value of the autoAssignController property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setAutoAssignController(BoolOption value) {
        this.autoAssignController = value;
    }

    /**
     * Gets the value of the backingOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the backingOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBackingOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualDeviceBackingOption }
     * 
     * 
     */
    public List<VirtualDeviceBackingOption> getBackingOption() {
        if (backingOption == null) {
            backingOption = new ArrayList<VirtualDeviceBackingOption>();
        }
        return this.backingOption;
    }

    /**
     * Gets the value of the defaultBackingOptionIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultBackingOptionIndex() {
        return defaultBackingOptionIndex;
    }

    /**
     * Sets the value of the defaultBackingOptionIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultBackingOptionIndex(Integer value) {
        this.defaultBackingOptionIndex = value;
    }

    /**
     * Gets the value of the licensingLimit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the licensingLimit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLicensingLimit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLicensingLimit() {
        if (licensingLimit == null) {
            licensingLimit = new ArrayList<String>();
        }
        return this.licensingLimit;
    }

    /**
     * Gets the value of the deprecated property.
     * 
     */
    public boolean isDeprecated() {
        return deprecated;
    }

    /**
     * Sets the value of the deprecated property.
     * 
     */
    public void setDeprecated(boolean value) {
        this.deprecated = value;
    }

    /**
     * Gets the value of the plugAndPlay property.
     * 
     */
    public boolean isPlugAndPlay() {
        return plugAndPlay;
    }

    /**
     * Sets the value of the plugAndPlay property.
     * 
     */
    public void setPlugAndPlay(boolean value) {
        this.plugAndPlay = value;
    }

    /**
     * Gets the value of the hotRemoveSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHotRemoveSupported() {
        return hotRemoveSupported;
    }

    /**
     * Sets the value of the hotRemoveSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHotRemoveSupported(Boolean value) {
        this.hotRemoveSupported = value;
    }

}
