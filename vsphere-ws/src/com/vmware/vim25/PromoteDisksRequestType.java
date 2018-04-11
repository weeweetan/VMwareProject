
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PromoteDisksRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PromoteDisksRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="unlink" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="disks" type="{urn:vim25}VirtualDisk" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PromoteDisksRequestType", propOrder = {
    "_this",
    "unlink",
    "disks"
})
public class PromoteDisksRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    protected boolean unlink;
    protected List<VirtualDisk> disks;

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
     * Gets the value of the unlink property.
     * 
     */
    public boolean isUnlink() {
        return unlink;
    }

    /**
     * Sets the value of the unlink property.
     * 
     */
    public void setUnlink(boolean value) {
        this.unlink = value;
    }

    /**
     * Gets the value of the disks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualDisk }
     * 
     * 
     */
    public List<VirtualDisk> getDisks() {
        if (disks == null) {
            disks = new ArrayList<VirtualDisk>();
        }
        return this.disks;
    }

}
