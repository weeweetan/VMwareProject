
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatastoreCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatastoreCapability">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="directoryHierarchySupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="rawDiskMappingsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="perFileThinProvisioningSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="storageIORMSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nativeSnapshotSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatastoreCapability", propOrder = {
    "directoryHierarchySupported",
    "rawDiskMappingsSupported",
    "perFileThinProvisioningSupported",
    "storageIORMSupported",
    "nativeSnapshotSupported"
})
public class DatastoreCapability
    extends DynamicData
{

    protected boolean directoryHierarchySupported;
    protected boolean rawDiskMappingsSupported;
    protected boolean perFileThinProvisioningSupported;
    protected Boolean storageIORMSupported;
    protected Boolean nativeSnapshotSupported;

    /**
     * Gets the value of the directoryHierarchySupported property.
     * 
     */
    public boolean isDirectoryHierarchySupported() {
        return directoryHierarchySupported;
    }

    /**
     * Sets the value of the directoryHierarchySupported property.
     * 
     */
    public void setDirectoryHierarchySupported(boolean value) {
        this.directoryHierarchySupported = value;
    }

    /**
     * Gets the value of the rawDiskMappingsSupported property.
     * 
     */
    public boolean isRawDiskMappingsSupported() {
        return rawDiskMappingsSupported;
    }

    /**
     * Sets the value of the rawDiskMappingsSupported property.
     * 
     */
    public void setRawDiskMappingsSupported(boolean value) {
        this.rawDiskMappingsSupported = value;
    }

    /**
     * Gets the value of the perFileThinProvisioningSupported property.
     * 
     */
    public boolean isPerFileThinProvisioningSupported() {
        return perFileThinProvisioningSupported;
    }

    /**
     * Sets the value of the perFileThinProvisioningSupported property.
     * 
     */
    public void setPerFileThinProvisioningSupported(boolean value) {
        this.perFileThinProvisioningSupported = value;
    }

    /**
     * Gets the value of the storageIORMSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStorageIORMSupported() {
        return storageIORMSupported;
    }

    /**
     * Sets the value of the storageIORMSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStorageIORMSupported(Boolean value) {
        this.storageIORMSupported = value;
    }

    /**
     * Gets the value of the nativeSnapshotSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNativeSnapshotSupported() {
        return nativeSnapshotSupported;
    }

    /**
     * Sets the value of the nativeSnapshotSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNativeSnapshotSupported(Boolean value) {
        this.nativeSnapshotSupported = value;
    }

}
