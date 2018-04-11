
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaultToleranceSecondaryConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaultToleranceSecondaryConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}FaultToleranceConfigInfo">
 *       &lt;sequence>
 *         &lt;element name="primaryVM" type="{urn:vim25}ManagedObjectReference"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultToleranceSecondaryConfigInfo", propOrder = {
    "primaryVM"
})
public class FaultToleranceSecondaryConfigInfo
    extends FaultToleranceConfigInfo
{

    @XmlElement(required = true)
    protected ManagedObjectReference primaryVM;

    /**
     * Gets the value of the primaryVM property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getPrimaryVM() {
        return primaryVM;
    }

    /**
     * Sets the value of the primaryVM property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setPrimaryVM(ManagedObjectReference value) {
        this.primaryVM = value;
    }

}
