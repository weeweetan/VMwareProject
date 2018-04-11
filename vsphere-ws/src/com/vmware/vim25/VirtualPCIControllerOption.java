
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualPCIControllerOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualPCIControllerOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualControllerOption">
 *       &lt;sequence>
 *         &lt;element name="numSCSIControllers" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numEthernetCards" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numVideoCards" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numSoundCards" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numVmiRoms" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numVmciDevices" type="{urn:vim25}IntOption" minOccurs="0"/>
 *         &lt;element name="numPCIPassthroughDevices" type="{urn:vim25}IntOption" minOccurs="0"/>
 *         &lt;element name="numSasSCSIControllers" type="{urn:vim25}IntOption" minOccurs="0"/>
 *         &lt;element name="numVmxnet3EthernetCards" type="{urn:vim25}IntOption" minOccurs="0"/>
 *         &lt;element name="numParaVirtualSCSIControllers" type="{urn:vim25}IntOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualPCIControllerOption", propOrder = {
    "numSCSIControllers",
    "numEthernetCards",
    "numVideoCards",
    "numSoundCards",
    "numVmiRoms",
    "numVmciDevices",
    "numPCIPassthroughDevices",
    "numSasSCSIControllers",
    "numVmxnet3EthernetCards",
    "numParaVirtualSCSIControllers"
})
public class VirtualPCIControllerOption
    extends VirtualControllerOption
{

    @XmlElement(required = true)
    protected IntOption numSCSIControllers;
    @XmlElement(required = true)
    protected IntOption numEthernetCards;
    @XmlElement(required = true)
    protected IntOption numVideoCards;
    @XmlElement(required = true)
    protected IntOption numSoundCards;
    @XmlElement(required = true)
    protected IntOption numVmiRoms;
    protected IntOption numVmciDevices;
    protected IntOption numPCIPassthroughDevices;
    protected IntOption numSasSCSIControllers;
    protected IntOption numVmxnet3EthernetCards;
    protected IntOption numParaVirtualSCSIControllers;

    /**
     * Gets the value of the numSCSIControllers property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumSCSIControllers() {
        return numSCSIControllers;
    }

    /**
     * Sets the value of the numSCSIControllers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumSCSIControllers(IntOption value) {
        this.numSCSIControllers = value;
    }

    /**
     * Gets the value of the numEthernetCards property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumEthernetCards() {
        return numEthernetCards;
    }

    /**
     * Sets the value of the numEthernetCards property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumEthernetCards(IntOption value) {
        this.numEthernetCards = value;
    }

    /**
     * Gets the value of the numVideoCards property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumVideoCards() {
        return numVideoCards;
    }

    /**
     * Sets the value of the numVideoCards property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumVideoCards(IntOption value) {
        this.numVideoCards = value;
    }

    /**
     * Gets the value of the numSoundCards property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumSoundCards() {
        return numSoundCards;
    }

    /**
     * Sets the value of the numSoundCards property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumSoundCards(IntOption value) {
        this.numSoundCards = value;
    }

    /**
     * Gets the value of the numVmiRoms property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumVmiRoms() {
        return numVmiRoms;
    }

    /**
     * Sets the value of the numVmiRoms property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumVmiRoms(IntOption value) {
        this.numVmiRoms = value;
    }

    /**
     * Gets the value of the numVmciDevices property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumVmciDevices() {
        return numVmciDevices;
    }

    /**
     * Sets the value of the numVmciDevices property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumVmciDevices(IntOption value) {
        this.numVmciDevices = value;
    }

    /**
     * Gets the value of the numPCIPassthroughDevices property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumPCIPassthroughDevices() {
        return numPCIPassthroughDevices;
    }

    /**
     * Sets the value of the numPCIPassthroughDevices property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumPCIPassthroughDevices(IntOption value) {
        this.numPCIPassthroughDevices = value;
    }

    /**
     * Gets the value of the numSasSCSIControllers property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumSasSCSIControllers() {
        return numSasSCSIControllers;
    }

    /**
     * Sets the value of the numSasSCSIControllers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumSasSCSIControllers(IntOption value) {
        this.numSasSCSIControllers = value;
    }

    /**
     * Gets the value of the numVmxnet3EthernetCards property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumVmxnet3EthernetCards() {
        return numVmxnet3EthernetCards;
    }

    /**
     * Sets the value of the numVmxnet3EthernetCards property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumVmxnet3EthernetCards(IntOption value) {
        this.numVmxnet3EthernetCards = value;
    }

    /**
     * Gets the value of the numParaVirtualSCSIControllers property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumParaVirtualSCSIControllers() {
        return numParaVirtualSCSIControllers;
    }

    /**
     * Sets the value of the numParaVirtualSCSIControllers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumParaVirtualSCSIControllers(IntOption value) {
        this.numParaVirtualSCSIControllers = value;
    }

}
