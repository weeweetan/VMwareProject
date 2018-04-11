
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualVideoCardOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualVideoCardOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceOption">
 *       &lt;sequence>
 *         &lt;element name="videoRamSizeInKB" type="{urn:vim25}LongOption" minOccurs="0"/>
 *         &lt;element name="numDisplays" type="{urn:vim25}IntOption" minOccurs="0"/>
 *         &lt;element name="useAutoDetect" type="{urn:vim25}BoolOption" minOccurs="0"/>
 *         &lt;element name="support3D" type="{urn:vim25}BoolOption" minOccurs="0"/>
 *         &lt;element name="use3dRendererSupported" type="{urn:vim25}BoolOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualVideoCardOption", propOrder = {
    "videoRamSizeInKB",
    "numDisplays",
    "useAutoDetect",
    "support3D",
    "use3DRendererSupported"
})
public class VirtualVideoCardOption
    extends VirtualDeviceOption
{

    protected LongOption videoRamSizeInKB;
    protected IntOption numDisplays;
    protected BoolOption useAutoDetect;
    protected BoolOption support3D;
    @XmlElement(name = "use3dRendererSupported")
    protected BoolOption use3DRendererSupported;

    /**
     * Gets the value of the videoRamSizeInKB property.
     * 
     * @return
     *     possible object is
     *     {@link LongOption }
     *     
     */
    public LongOption getVideoRamSizeInKB() {
        return videoRamSizeInKB;
    }

    /**
     * Sets the value of the videoRamSizeInKB property.
     * 
     * @param value
     *     allowed object is
     *     {@link LongOption }
     *     
     */
    public void setVideoRamSizeInKB(LongOption value) {
        this.videoRamSizeInKB = value;
    }

    /**
     * Gets the value of the numDisplays property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumDisplays() {
        return numDisplays;
    }

    /**
     * Sets the value of the numDisplays property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumDisplays(IntOption value) {
        this.numDisplays = value;
    }

    /**
     * Gets the value of the useAutoDetect property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getUseAutoDetect() {
        return useAutoDetect;
    }

    /**
     * Sets the value of the useAutoDetect property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setUseAutoDetect(BoolOption value) {
        this.useAutoDetect = value;
    }

    /**
     * Gets the value of the support3D property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getSupport3D() {
        return support3D;
    }

    /**
     * Sets the value of the support3D property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setSupport3D(BoolOption value) {
        this.support3D = value;
    }

    /**
     * Gets the value of the use3DRendererSupported property.
     * 
     * @return
     *     possible object is
     *     {@link BoolOption }
     *     
     */
    public BoolOption getUse3DRendererSupported() {
        return use3DRendererSupported;
    }

    /**
     * Sets the value of the use3DRendererSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoolOption }
     *     
     */
    public void setUse3DRendererSupported(BoolOption value) {
        this.use3DRendererSupported = value;
    }

}
