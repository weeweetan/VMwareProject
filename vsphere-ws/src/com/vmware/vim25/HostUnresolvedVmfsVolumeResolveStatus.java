
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostUnresolvedVmfsVolumeResolveStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostUnresolvedVmfsVolumeResolveStatus">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="resolvable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="incompleteExtents" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="multipleCopies" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostUnresolvedVmfsVolumeResolveStatus", propOrder = {
    "resolvable",
    "incompleteExtents",
    "multipleCopies"
})
public class HostUnresolvedVmfsVolumeResolveStatus
    extends DynamicData
{

    protected boolean resolvable;
    protected Boolean incompleteExtents;
    protected Boolean multipleCopies;

    /**
     * Gets the value of the resolvable property.
     * 
     */
    public boolean isResolvable() {
        return resolvable;
    }

    /**
     * Sets the value of the resolvable property.
     * 
     */
    public void setResolvable(boolean value) {
        this.resolvable = value;
    }

    /**
     * Gets the value of the incompleteExtents property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncompleteExtents() {
        return incompleteExtents;
    }

    /**
     * Sets the value of the incompleteExtents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncompleteExtents(Boolean value) {
        this.incompleteExtents = value;
    }

    /**
     * Gets the value of the multipleCopies property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMultipleCopies() {
        return multipleCopies;
    }

    /**
     * Sets the value of the multipleCopies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMultipleCopies(Boolean value) {
        this.multipleCopies = value;
    }

}
