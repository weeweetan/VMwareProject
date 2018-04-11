
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualSIOControllerOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualSIOControllerOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualControllerOption">
 *       &lt;sequence>
 *         &lt;element name="numFloppyDrives" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numSerialPorts" type="{urn:vim25}IntOption"/>
 *         &lt;element name="numParallelPorts" type="{urn:vim25}IntOption"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualSIOControllerOption", propOrder = {
    "numFloppyDrives",
    "numSerialPorts",
    "numParallelPorts"
})
public class VirtualSIOControllerOption
    extends VirtualControllerOption
{

    @XmlElement(required = true)
    protected IntOption numFloppyDrives;
    @XmlElement(required = true)
    protected IntOption numSerialPorts;
    @XmlElement(required = true)
    protected IntOption numParallelPorts;

    /**
     * Gets the value of the numFloppyDrives property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumFloppyDrives() {
        return numFloppyDrives;
    }

    /**
     * Sets the value of the numFloppyDrives property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumFloppyDrives(IntOption value) {
        this.numFloppyDrives = value;
    }

    /**
     * Gets the value of the numSerialPorts property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumSerialPorts() {
        return numSerialPorts;
    }

    /**
     * Sets the value of the numSerialPorts property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumSerialPorts(IntOption value) {
        this.numSerialPorts = value;
    }

    /**
     * Gets the value of the numParallelPorts property.
     * 
     * @return
     *     possible object is
     *     {@link IntOption }
     *     
     */
    public IntOption getNumParallelPorts() {
        return numParallelPorts;
    }

    /**
     * Sets the value of the numParallelPorts property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntOption }
     *     
     */
    public void setNumParallelPorts(IntOption value) {
        this.numParallelPorts = value;
    }

}
