
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineImportSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineImportSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ImportSpec">
 *       &lt;sequence>
 *         &lt;element name="configSpec" type="{urn:vim25}VirtualMachineConfigSpec"/>
 *         &lt;element name="resPoolEntity" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineImportSpec", propOrder = {
    "configSpec",
    "resPoolEntity"
})
public class VirtualMachineImportSpec
    extends ImportSpec
{

    @XmlElement(required = true)
    protected VirtualMachineConfigSpec configSpec;
    protected ManagedObjectReference resPoolEntity;

    /**
     * Gets the value of the configSpec property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineConfigSpec }
     *     
     */
    public VirtualMachineConfigSpec getConfigSpec() {
        return configSpec;
    }

    /**
     * Sets the value of the configSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineConfigSpec }
     *     
     */
    public void setConfigSpec(VirtualMachineConfigSpec value) {
        this.configSpec = value;
    }

    /**
     * Gets the value of the resPoolEntity property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getResPoolEntity() {
        return resPoolEntity;
    }

    /**
     * Sets the value of the resPoolEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setResPoolEntity(ManagedObjectReference value) {
        this.resPoolEntity = value;
    }

}
