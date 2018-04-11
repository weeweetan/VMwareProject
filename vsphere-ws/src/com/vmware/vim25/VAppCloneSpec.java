
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VAppCloneSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VAppCloneSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="location" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="host" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="resourceSpec" type="{urn:vim25}ResourceConfigSpec" minOccurs="0"/>
 *         &lt;element name="vmFolder" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="networkMapping" type="{urn:vim25}VAppCloneSpecNetworkMappingPair" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="property" type="{urn:vim25}KeyValue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="resourceMapping" type="{urn:vim25}VAppCloneSpecResourceMap" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="provisioning" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VAppCloneSpec", propOrder = {
    "location",
    "host",
    "resourceSpec",
    "vmFolder",
    "networkMapping",
    "property",
    "resourceMapping",
    "provisioning"
})
public class VAppCloneSpec
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference location;
    protected ManagedObjectReference host;
    protected ResourceConfigSpec resourceSpec;
    protected ManagedObjectReference vmFolder;
    protected List<VAppCloneSpecNetworkMappingPair> networkMapping;
    protected List<KeyValue> property;
    protected List<VAppCloneSpecResourceMap> resourceMapping;
    protected String provisioning;

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

    /**
     * Gets the value of the host property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setHost(ManagedObjectReference value) {
        this.host = value;
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
     * Gets the value of the vmFolder property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getVmFolder() {
        return vmFolder;
    }

    /**
     * Sets the value of the vmFolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setVmFolder(ManagedObjectReference value) {
        this.vmFolder = value;
    }

    /**
     * Gets the value of the networkMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the networkMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetworkMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VAppCloneSpecNetworkMappingPair }
     * 
     * 
     */
    public List<VAppCloneSpecNetworkMappingPair> getNetworkMapping() {
        if (networkMapping == null) {
            networkMapping = new ArrayList<VAppCloneSpecNetworkMappingPair>();
        }
        return this.networkMapping;
    }

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValue }
     * 
     * 
     */
    public List<KeyValue> getProperty() {
        if (property == null) {
            property = new ArrayList<KeyValue>();
        }
        return this.property;
    }

    /**
     * Gets the value of the resourceMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourceMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VAppCloneSpecResourceMap }
     * 
     * 
     */
    public List<VAppCloneSpecResourceMap> getResourceMapping() {
        if (resourceMapping == null) {
            resourceMapping = new ArrayList<VAppCloneSpecResourceMap>();
        }
        return this.resourceMapping;
    }

    /**
     * Gets the value of the provisioning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvisioning() {
        return provisioning;
    }

    /**
     * Sets the value of the provisioning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvisioning(String value) {
        this.provisioning = value;
    }

}
