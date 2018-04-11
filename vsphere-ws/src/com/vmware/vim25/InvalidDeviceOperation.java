
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvalidDeviceOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvalidDeviceOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InvalidDeviceSpec">
 *       &lt;sequence>
 *         &lt;element name="badOp" type="{urn:vim25}VirtualDeviceConfigSpecOperation" minOccurs="0"/>
 *         &lt;element name="badFileOp" type="{urn:vim25}VirtualDeviceConfigSpecFileOperation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvalidDeviceOperation", propOrder = {
    "badOp",
    "badFileOp"
})
public class InvalidDeviceOperation
    extends InvalidDeviceSpec
{

    protected VirtualDeviceConfigSpecOperation badOp;
    protected VirtualDeviceConfigSpecFileOperation badFileOp;

    /**
     * Gets the value of the badOp property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualDeviceConfigSpecOperation }
     *     
     */
    public VirtualDeviceConfigSpecOperation getBadOp() {
        return badOp;
    }

    /**
     * Sets the value of the badOp property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualDeviceConfigSpecOperation }
     *     
     */
    public void setBadOp(VirtualDeviceConfigSpecOperation value) {
        this.badOp = value;
    }

    /**
     * Gets the value of the badFileOp property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualDeviceConfigSpecFileOperation }
     *     
     */
    public VirtualDeviceConfigSpecFileOperation getBadFileOp() {
        return badFileOp;
    }

    /**
     * Sets the value of the badFileOp property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualDeviceConfigSpecFileOperation }
     *     
     */
    public void setBadFileOp(VirtualDeviceConfigSpecFileOperation value) {
        this.badFileOp = value;
    }

}
