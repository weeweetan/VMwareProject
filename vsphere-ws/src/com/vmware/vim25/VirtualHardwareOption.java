
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualHardwareOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualHardwareOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="hwVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="virtualDeviceOption" type="{urn:vim25}VirtualDeviceOption" maxOccurs="unbounded"/>
 *         &lt;element name="deviceListReadonly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="numCPU" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/>
 *         &lt;element name="numCoresPerSocket" type="{urn:vim25}IntOption" minOccurs="0"/>
 *         &lt;element name="numCpuReadonly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="memoryMB" type="{urn:vim25}LongOption"/>
 *         &lt;element name="numPCIControllers" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numIDEControllers" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numUSBControllers" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numUSBXHCIControllers" type="{urn:vim25}IntOption" minOccurs="0"/>
 *         &lt;element name="numSIOControllers" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numPS2Controllers" type="{urn:vim25}IntOption"/>
 *         &lt;element name="licensingLimit" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numSupportedWwnPorts" type="{urn:vim25}IntOption" minOccurs="0"/>
 *         &lt;element name="numSupportedWwnNodes" type="{urn:vim25}IntOption" minOccurs="0"/>
 *         &lt;element name="resourceConfigOption" type="{urn:vim25}ResourceConfigOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualHardwareOption", propOrder = {
    "hwVersion",
    "virtualDeviceOption",
    "deviceListReadonly",
    "numCPU",
    "numCoresPerSocket",
    "numCpuReadonly",
    "memoryMB",
    "numPCIControllers",
    "numIDEControllers",
    "numUSBControllers",
    "numUSBXHCIControllers",
    "numSIOControllers",
    "numPS2Controllers",
    "licensingLimit",
    "numSupportedWwnPorts",
    "numSupportedWwnNodes",
    "resourceConfigOption"
})
public class VirtualHardwareOption
    extends DynamicData
{

    protected int hwVersion;
    @XmlElement(required = true)
    protected List<VirtualDeviceOption> virtualDeviceOption;
    protected boolean deviceListReadonly;
    @XmlElement(type = Integer.class)
    protected List<Integer> numCPU;
    protected IntOption numCoresPerSocket;
    protected boolean numCpuReadonly;
    @XmlElement(required = true)
    protected LongOption memoryMB;
    @XmlElement(required = true)
    protected IntOption numPCIControllers;
    @XmlElement(required = true)
    protected IntOption numIDEControllers;
    @XmlElement(required = true)
    protected IntOption numUSBControllers;
    protected IntOption numUSBXHCIControllers;
    @XmlElement(required = true)
    protected IntOption numSIOControllers;
    @XmlElement(required = true)
    protected IntOption numPS2Controllers;
    protected List<String> licensingLimit;
    protected IntOption numSupportedWwnPorts;
    protected IntOption numSupportedWwnNodes;
    protected ResourceConfigOption resourceConfigOption;

    /**
     * Gets the value of the hwVersion property.
     * 
     */
    public int getHwVersion() {
        return hwVersion;
    }

    /**
     * Sets the value of the hwVersion property.
     * 
     */
    public void setHwVersion(int value) {
        this.hwVersion = value;
    }

    /**
     * Gets the value of the virtualDeviceOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualDeviceOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualDeviceOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualDeviceOption }
     * 
     * 
     */
    public List<VirtualDeviceOption> getVirtualDeviceOption() {
        if (virtualDeviceOption == null) {
            virtualDeviceOption = new ArrayList<VirtualDeviceOption>();
        }
        return this.virtualDeviceOption;
    }

    /**
     * Gets the value of the deviceListReadonly property.
     * 
     */
    public boolean isDeviceListReadonly() {
        return deviceListReadonly;
    }

    /**
     * Sets the value of the deviceListReadonly property.
     * 
     */
    public void setDeviceListReadonly(boolean value) {
        this.deviceListReadonly = value;
    }

    /**
     * Gets the value of the numCPU property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the numCPU property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNumCPU().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getNumCPU() {
        if (numCPU == null) {
            numCPU = new ArrayList<Integer>();
        }
        return this.numCPU;
    }

    /**
     * Gets the value of the numCoresPerSocket property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumCoresPerSocket() {
        return numCoresPerSocket;
    }

    /**
     * Sets the value of the numCoresPerSocket property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumCoresPerSocket(IntOption value) {
        this.numCoresPerSocket = value;
    }

    /**
     * Gets the value of the numCpuReadonly property.
     * 
     */
    public boolean isNumCpuReadonly() {
        return numCpuReadonly;
    }

    /**
     * Sets the value of the numCpuReadonly property.
     * 
     */
    public void setNumCpuReadonly(boolean value) {
        this.numCpuReadonly = value;
    }

    /**
     * Gets the value of the memoryMB property.
     * 
     * @return
     *     possible object is
     *     {@link LongOption }
     *     
     */
    public LongOption getMemoryMB() {
        return memoryMB;
    }

    /**
     * Sets the value of the memoryMB property.
     * 
     * @param value
     *     allowed object is
     *     {@link LongOption }
     *     
     */
    public void setMemoryMB(LongOption value) {
        this.memoryMB = value;
    }

    /**
     * Gets the value of the numPCIControllers property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumPCIControllers() {
        return numPCIControllers;
    }

    /**
     * Sets the value of the numPCIControllers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumPCIControllers(IntOption value) {
        this.numPCIControllers = value;
    }

    /**
     * Gets the value of the numIDEControllers property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumIDEControllers() {
        return numIDEControllers;
    }

    /**
     * Sets the value of the numIDEControllers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumIDEControllers(IntOption value) {
        this.numIDEControllers = value;
    }

    /**
     * Gets the value of the numUSBControllers property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumUSBControllers() {
        return numUSBControllers;
    }

    /**
     * Sets the value of the numUSBControllers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumUSBControllers(IntOption value) {
        this.numUSBControllers = value;
    }

    /**
     * Gets the value of the numUSBXHCIControllers property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumUSBXHCIControllers() {
        return numUSBXHCIControllers;
    }

    /**
     * Sets the value of the numUSBXHCIControllers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumUSBXHCIControllers(IntOption value) {
        this.numUSBXHCIControllers = value;
    }

    /**
     * Gets the value of the numSIOControllers property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumSIOControllers() {
        return numSIOControllers;
    }

    /**
     * Sets the value of the numSIOControllers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumSIOControllers(IntOption value) {
        this.numSIOControllers = value;
    }

    /**
     * Gets the value of the numPS2Controllers property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumPS2Controllers() {
        return numPS2Controllers;
    }

    /**
     * Sets the value of the numPS2Controllers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumPS2Controllers(IntOption value) {
        this.numPS2Controllers = value;
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
     * Gets the value of the numSupportedWwnPorts property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumSupportedWwnPorts() {
        return numSupportedWwnPorts;
    }

    /**
     * Sets the value of the numSupportedWwnPorts property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumSupportedWwnPorts(IntOption value) {
        this.numSupportedWwnPorts = value;
    }

    /**
     * Gets the value of the numSupportedWwnNodes property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumSupportedWwnNodes() {
        return numSupportedWwnNodes;
    }

    /**
     * Sets the value of the numSupportedWwnNodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumSupportedWwnNodes(IntOption value) {
        this.numSupportedWwnNodes = value;
    }

    /**
     * Gets the value of the resourceConfigOption property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceConfigOption }
     *     
     */
    public ResourceConfigOption getResourceConfigOption() {
        return resourceConfigOption;
    }

    /**
     * Sets the value of the resourceConfigOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceConfigOption }
     *     
     */
    public void setResourceConfigOption(ResourceConfigOption value) {
        this.resourceConfigOption = value;
    }

}
