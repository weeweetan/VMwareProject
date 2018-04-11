
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineRuntimeInfoDasProtectionState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineRuntimeInfoDasProtectionState">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="dasProtected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineRuntimeInfoDasProtectionState", propOrder = {
    "dasProtected"
})
public class VirtualMachineRuntimeInfoDasProtectionState
    extends DynamicData
{

    protected boolean dasProtected;

    /**
     * Gets the value of the dasProtected property.
     * 
     */
    public boolean isDasProtected() {
        return dasProtected;
    }

    /**
     * Sets the value of the dasProtected property.
     * 
     */
    public void setDasProtected(boolean value) {
        this.dasProtected = value;
    }

}
