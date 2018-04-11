
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDiskFlatVer1BackingOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDiskFlatVer1BackingOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceFileBackingOption">
 *       &lt;sequence>
 *         &lt;element name="diskMode" type="{urn:vim25}ChoiceOption"/>
 *         &lt;element name="split" type="{urn:vim25}BoolOption"/>
 *         &lt;element name="writeThrough" type="{urn:vim25}BoolOption"/>
 *         &lt;element name="growable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDiskFlatVer1BackingOption", propOrder = {
    "diskMode",
    "split",
    "writeThrough",
    "growable"
})
public class VirtualDiskFlatVer1BackingOption
    extends VirtualDeviceFileBackingOption
{

    @XmlElement(required = true)
    protected ChoiceOption diskMode;
    @XmlElement(required = true)
    protected BoolOption split;
    @XmlElement(required = true)
    protected BoolOption writeThrough;
    protected boolean growable;

    /**
     * Gets the value of the diskMode property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOption }
     *     
     */
    public ChoiceOption getDiskMode() {
        return diskMode;
    }

    /**
     * Sets the value of the diskMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOption }
     *     
     */
    public void setDiskMode(ChoiceOption value) {
        this.diskMode = value;
    }

    /**
     * Gets the value of the split property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getSplit() {
        return split;
    }

    /**
     * Sets the value of the split property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setSplit(BoolOption value) {
        this.split = value;
    }

    /**
     * Gets the value of the writeThrough property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getWriteThrough() {
        return writeThrough;
    }

    /**
     * Sets the value of the writeThrough property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setWriteThrough(BoolOption value) {
        this.writeThrough = value;
    }

    /**
     * Gets the value of the growable property.
     * 
     */
    public boolean isGrowable() {
        return growable;
    }

    /**
     * Sets the value of the growable property.
     * 
     */
    public void setGrowable(boolean value) {
        this.growable = value;
    }

}
