
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineFileInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineFileInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="vmPathName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="snapshotDirectory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="suspendDirectory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logDirectory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineFileInfo", propOrder = {
    "vmPathName",
    "snapshotDirectory",
    "suspendDirectory",
    "logDirectory"
})
public class VirtualMachineFileInfo
    extends DynamicData
{

    protected String vmPathName;
    protected String snapshotDirectory;
    protected String suspendDirectory;
    protected String logDirectory;

    /**
     * Gets the value of the vmPathName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVmPathName() {
        return vmPathName;
    }

    /**
     * Sets the value of the vmPathName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVmPathName(String value) {
        this.vmPathName = value;
    }

    /**
     * Gets the value of the snapshotDirectory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSnapshotDirectory() {
        return snapshotDirectory;
    }

    /**
     * Sets the value of the snapshotDirectory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSnapshotDirectory(String value) {
        this.snapshotDirectory = value;
    }

    /**
     * Gets the value of the suspendDirectory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuspendDirectory() {
        return suspendDirectory;
    }

    /**
     * Sets the value of the suspendDirectory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuspendDirectory(String value) {
        this.suspendDirectory = value;
    }

    /**
     * Gets the value of the logDirectory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogDirectory() {
        return logDirectory;
    }

    /**
     * Sets the value of the logDirectory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogDirectory(String value) {
        this.logDirectory = value;
    }

}
