
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VAppCloneSpecResourceMap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VAppCloneSpecResourceMap">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="source" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="parent" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="resourceSpec" type="{urn:vim25}ResourceConfigSpec" minOccurs="0"/>
 *         &lt;element name="location" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VAppCloneSpecResourceMap", propOrder = {
    "source",
    "parent",
    "resourceSpec",
    "location"
})
public class VAppCloneSpecResourceMap
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference source;
    protected ManagedObjectReference parent;
    protected ResourceConfigSpec resourceSpec;
    protected ManagedObjectReference location;

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setSource(ManagedObjectReference value) {
        this.source = value;
    }

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setParent(ManagedObjectReference value) {
        this.parent = value;
    }

    /**
     * Gets the value of the resourceSpec property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceConfigSpec }
     *     
     */
    public ResourceConfigSpec getResourceSpec() {
        return resourceSpec;
    }

    /**
     * Sets the value of the resourceSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceConfigSpec }
     *     
     */
    public void setResourceSpec(ResourceConfigSpec value) {
        this.resourceSpec = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setLocation(ManagedObjectReference value) {
        this.location = value;
    }

}
