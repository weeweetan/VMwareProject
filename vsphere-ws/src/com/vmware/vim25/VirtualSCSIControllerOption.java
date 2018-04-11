
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualSCSIControllerOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualSCSIControllerOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualControllerOption">
 *       &lt;sequence>
 *         &lt;element name="numSCSIDisks" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numSCSICdroms" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numSCSIPassthrough" type="{urn:vim25}IntOption"/>
 *         &lt;element name="sharing" type="{urn:vim25}VirtualSCSISharing" maxOccurs="unbounded"/>
 *         &lt;element name="defaultSharedIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hotAddRemove" type="{urn:vim25}BoolOption"/>
 *         &lt;element name="scsiCtlrUnitNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualSCSIControllerOption", propOrder = {
    "numSCSIDisks",
    "numSCSICdroms",
    "numSCSIPassthrough",
    "sharing",
    "defaultSharedIndex",
    "hotAddRemove",
    "scsiCtlrUnitNumber"
})
@XmlSeeAlso({
    ParaVirtualSCSIControllerOption.class,
    VirtualLsiLogicSASControllerOption.class,
    VirtualLsiLogicControllerOption.class,
    VirtualBusLogicControllerOption.class
})
public class VirtualSCSIControllerOption
    extends VirtualControllerOption
{

    @XmlElement(required = true)
    protected IntOption numSCSIDisks;
    @XmlElement(required = true)
    protected IntOption numSCSICdroms;
    @XmlElement(required = true)
    protected IntOption numSCSIPassthrough;
    @XmlElement(required = true)
    protected List<VirtualSCSISharing> sharing;
    protected int defaultSharedIndex;
    @XmlElement(required = true)
    protected BoolOption hotAddRemove;
    protected int scsiCtlrUnitNumber;

    /**
     * Gets the value of the numSCSIDisks property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumSCSIDisks() {
        return numSCSIDisks;
    }

    /**
     * Sets the value of the numSCSIDisks property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumSCSIDisks(IntOption value) {
        this.numSCSIDisks = value;
    }

    /**
     * Gets the value of the numSCSICdroms property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumSCSICdroms() {
        return numSCSICdroms;
    }

    /**
     * Sets the value of the numSCSICdroms property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumSCSICdroms(IntOption value) {
        this.numSCSICdroms = value;
    }

    /**
     * Gets the value of the numSCSIPassthrough property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumSCSIPassthrough() {
        return numSCSIPassthrough;
    }

    /**
     * Sets the value of the numSCSIPassthrough property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumSCSIPassthrough(IntOption value) {
        this.numSCSIPassthrough = value;
    }

    /**
     * Gets the value of the sharing property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sharing property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSharing().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualSCSISharing }
     * 
     * 
     */
    public List<VirtualSCSISharing> getSharing() {
        if (sharing == null) {
            sharing = new ArrayList<VirtualSCSISharing>();
        }
        return this.sharing;
    }

    /**
     * Gets the value of the defaultSharedIndex property.
     * 
     */
    public int getDefaultSharedIndex() {
        return defaultSharedIndex;
    }

    /**
     * Sets the value of the defaultSharedIndex property.
     * 
     */
    public void setDefaultSharedIndex(int value) {
        this.defaultSharedIndex = value;
    }

    /**
     * Gets the value of the hotAddRemove property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getHotAddRemove() {
        return hotAddRemove;
    }

    /**
     * Sets the value of the hotAddRemove property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setHotAddRemove(BoolOption value) {
        this.hotAddRemove = value;
    }

    /**
     * Gets the value of the scsiCtlrUnitNumber property.
     * 
     */
    public int getScsiCtlrUnitNumber() {
        return scsiCtlrUnitNumber;
    }

    /**
     * Sets the value of the scsiCtlrUnitNumber property.
     * 
     */
    public void setScsiCtlrUnitNumber(int value) {
        this.scsiCtlrUnitNumber = value;
    }

}
