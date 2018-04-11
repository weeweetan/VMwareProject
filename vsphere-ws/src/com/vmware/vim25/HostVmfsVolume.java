
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostVmfsVolume complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostVmfsVolume">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostFileSystemVolume">
 *       &lt;sequence>
 *         &lt;element name="blockSizeMb" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxBlocks" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="majorVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="extent" type="{urn:vim25}HostScsiDiskPartition" maxOccurs="unbounded"/>
 *         &lt;element name="vmfsUpgradable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="forceMountedInfo" type="{urn:vim25}HostForceMountedInfo" minOccurs="0"/>
 *         &lt;element name="ssd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostVmfsVolume", propOrder = {
    "blockSizeMb",
    "maxBlocks",
    "majorVersion",
    "version",
    "uuid",
    "extent",
    "vmfsUpgradable",
    "forceMountedInfo",
    "ssd"
})
public class HostVmfsVolume
    extends HostFileSystemVolume
{

    protected int blockSizeMb;
    protected int maxBlocks;
    protected int majorVersion;
    @XmlElement(required = true)
    protected String version;
    @XmlElement(required = true)
    protected String uuid;
    @XmlElement(required = true)
    protected List<HostScsiDiskPartition> extent;
    protected boolean vmfsUpgradable;
    protected HostForceMountedInfo forceMountedInfo;
    protected Boolean ssd;

    /**
     * Gets the value of the blockSizeMb property.
     * 
     */
    public int getBlockSizeMb() {
        return blockSizeMb;
    }

    /**
     * Sets the value of the blockSizeMb property.
     * 
     */
    public void setBlockSizeMb(int value) {
        this.blockSizeMb = value;
    }

    /**
     * Gets the value of the maxBlocks property.
     * 
     */
    public int getMaxBlocks() {
        return maxBlocks;
    }

    /**
     * Sets the value of the maxBlocks property.
     * 
     */
    public void setMaxBlocks(int value) {
        this.maxBlocks = value;
    }

    /**
     * Gets the value of the majorVersion property.
     * 
     */
    public int getMajorVersion() {
        return majorVersion;
    }

    /**
     * Sets the value of the majorVersion property.
     * 
     */
    public void setMajorVersion(int value) {
        this.majorVersion = value;
    }

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
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the extent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostScsiDiskPartition }
     * 
     * 
     */
    public List<HostScsiDiskPartition> getExtent() {
        if (extent == null) {
            extent = new ArrayList<HostScsiDiskPartition>();
        }
        return this.extent;
    }

    /**
     * Gets the value of the vmfsUpgradable property.
     * 
     */
    public boolean isVmfsUpgradable() {
        return vmfsUpgradable;
    }

    /**
     * Sets the value of the vmfsUpgradable property.
     * 
     */
    public void setVmfsUpgradable(boolean value) {
        this.vmfsUpgradable = value;
    }

    /**
     * Gets the value of the forceMountedInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostForceMountedInfo }
     *     
     */
    public HostForceMountedInfo getForceMountedInfo() {
        return forceMountedInfo;
    }

    /**
     * Sets the value of the forceMountedInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostForceMountedInfo }
     *     
     */
    public void setForceMountedInfo(HostForceMountedInfo value) {
        this.forceMountedInfo = value;
    }

    /**
     * Gets the value of the ssd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSsd() {
        return ssd;
    }

    /**
     * Sets the value of the ssd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSsd(Boolean value) {
        this.ssd = value;
    }

}
