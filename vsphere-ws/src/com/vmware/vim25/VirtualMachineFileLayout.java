
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineFileLayout complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineFileLayout">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="configFile" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="logFile" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="disk" type="{urn:vim25}VirtualMachineFileLayoutDiskLayout" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="snapshot" type="{urn:vim25}VirtualMachineFileLayoutSnapshotLayout" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="swapFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineFileLayout", propOrder = {
    "configFile",
    "logFile",
    "disk",
    "snapshot",
    "swapFile"
})
public class VirtualMachineFileLayout
    extends DynamicData
{

    protected List<String> configFile;
    protected List<String> logFile;
    protected List<VirtualMachineFileLayoutDiskLayout> disk;
    protected List<VirtualMachineFileLayoutSnapshotLayout> snapshot;
    protected String swapFile;

    /**
     * Gets the value of the configFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the configFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfigFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConfigFile() {
        if (configFile == null) {
            configFile = new ArrayList<String>();
        }
        return this.configFile;
    }

    /**
     * Gets the value of the logFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLogFile() {
        if (logFile == null) {
            logFile = new ArrayList<String>();
        }
        return this.logFile;
    }

    /**
     * Gets the value of the disk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFileLayoutDiskLayout }
     * 
     * 
     */
    public List<VirtualMachineFileLayoutDiskLayout> getDisk() {
        if (disk == null) {
            disk = new ArrayList<VirtualMachineFileLayoutDiskLayout>();
        }
        return this.disk;
    }

    /**
     * Gets the value of the snapshot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snapshot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnapshot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualMachineFileLayoutSnapshotLayout }
     * 
     * 
     */
    public List<VirtualMachineFileLayoutSnapshotLayout> getSnapshot() {
        if (snapshot == null) {
            snapshot = new ArrayList<VirtualMachineFileLayoutSnapshotLayout>();
        }
        return this.snapshot;
    }

    /**
     * Gets the value of the swapFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwapFile() {
        return swapFile;
    }

    /**
     * Sets the value of the swapFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwapFile(String value) {
        this.swapFile = value;
    }

}
