
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmDiskFileInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmDiskFileInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}FileInfo">
 *       &lt;sequence>
 *         &lt;element name="diskType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capacityKb" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="hardwareVersion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="controllerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diskExtents" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="thin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmDiskFileInfo", propOrder = {
    "diskType",
    "capacityKb",
    "hardwareVersion",
    "controllerType",
    "diskExtents",
    "thin"
})
public class VmDiskFileInfo
    extends FileInfo
{

    protected String diskType;
    protected Long capacityKb;
    protected Integer hardwareVersion;
    protected String controllerType;
    protected List<String> diskExtents;
    protected Boolean thin;

    /**
     * Gets the value of the diskType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskType() {
        return diskType;
    }

    /**
     * Sets the value of the diskType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskType(String value) {
        this.diskType = value;
    }

    /**
     * Gets the value of the capacityKb property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCapacityKb() {
        return capacityKb;
    }

    /**
     * Sets the value of the capacityKb property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCapacityKb(Long value) {
        this.capacityKb = value;
    }

    /**
     * Gets the value of the hardwareVersion property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHardwareVersion() {
        return hardwareVersion;
    }

    /**
     * Sets the value of the hardwareVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHardwareVersion(Integer value) {
        this.hardwareVersion = value;
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
     * Gets the value of the diskExtents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the diskExtents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiskExtents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDiskExtents() {
        if (diskExtents == null) {
            diskExtents = new ArrayList<String>();
        }
        return this.diskExtents;
    }

    /**
     * Gets the value of the thin property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isThin() {
        return thin;
    }

    /**
     * Sets the value of the thin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setThin(Boolean value) {
        this.thin = value;
    }

}
