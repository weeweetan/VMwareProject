
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnlicensedVirtualMachinesEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnlicensedVirtualMachinesEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}LicenseEvent">
 *       &lt;sequence>
 *         &lt;element name="unlicensed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="available" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnlicensedVirtualMachinesEvent", propOrder = {
    "unlicensed",
    "available"
})
public class UnlicensedVirtualMachinesEvent
    extends LicenseEvent
{

    protected int unlicensed;
    protected int available;

    /**
     * Gets the value of the unlicensed property.
     * 
     */
    public int getUnlicensed() {
        return unlicensed;
    }

    /**
     * Sets the value of the unlicensed property.
     * 
     */
    public void setUnlicensed(int value) {
        this.unlicensed = value;
    }

    /**
     * Gets the value of the available property.
     * 
     */
    public int getAvailable() {
        return available;
    }

    /**
     * Sets the value of the available property.
     * 
     */
    public void setAvailable(int value) {
        this.available = value;
    }

}
