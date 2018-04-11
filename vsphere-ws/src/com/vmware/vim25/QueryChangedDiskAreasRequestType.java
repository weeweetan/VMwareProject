
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryChangedDiskAreasRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryChangedDiskAreasRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="snapshot" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="deviceKey" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startOffset" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="changeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryChangedDiskAreasRequestType", propOrder = {
    "_this",
    "snapshot",
    "deviceKey",
    "startOffset",
    "changeId"
})
public class QueryChangedDiskAreasRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    protected ManagedObjectReference snapshot;
    protected int deviceKey;
    protected long startOffset;
    @XmlElement(required = true)
    protected String changeId;

    /**
     * Gets the value of the this property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getThis() {
        return _this;
    }

    /**
     * Sets the value of the this property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setThis(ManagedObjectReference value) {
        this._this = value;
    }

    /**
     * Gets the value of the snapshot property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getSnapshot() {
        return snapshot;
    }

    /**
     * Sets the value of the snapshot property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setSnapshot(ManagedObjectReference value) {
        this.snapshot = value;
    }

    /**
     * Gets the value of the deviceKey property.
     * 
     */
    public int getDeviceKey() {
        return deviceKey;
    }

    /**
     * Sets the value of the deviceKey property.
     * 
     */
    public void setDeviceKey(int value) {
        this.deviceKey = value;
    }

    /**
     * Gets the value of the startOffset property.
     * 
     */
    public long getStartOffset() {
        return startOffset;
    }

    /**
     * Sets the value of the startOffset property.
     * 
     */
    public void setStartOffset(long value) {
        this.startOffset = value;
    }

    /**
     * Gets the value of the changeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeId() {
        return changeId;
    }

    /**
     * Sets the value of the changeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeId(String value) {
        this.changeId = value;
    }

}
