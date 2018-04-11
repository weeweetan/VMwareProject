
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfCreateImportSpecParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfCreateImportSpecParams">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfManagerCommonParams">
 *       &lt;sequence>
 *         &lt;element name="entityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hostSystem" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="networkMapping" type="{urn:vim25}OvfNetworkMapping" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ipAllocationPolicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipProtocol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="propertyMapping" type="{urn:vim25}KeyValue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="resourceMapping" type="{urn:vim25}OvfResourceMap" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="diskProvisioning" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="instantiationOst" type="{urn:vim25}OvfConsumerOstNode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfCreateImportSpecParams", propOrder = {
    "entityName",
    "hostSystem",
    "networkMapping",
    "ipAllocationPolicy",
    "ipProtocol",
    "propertyMapping",
    "resourceMapping",
    "diskProvisioning",
    "instantiationOst"
})
public class OvfCreateImportSpecParams
    extends OvfManagerCommonParams
{

    @XmlElement(required = true)
    protected String entityName;
    protected ManagedObjectReference hostSystem;
    protected List<OvfNetworkMapping> networkMapping;
    protected String ipAllocationPolicy;
    protected String ipProtocol;
    protected List<KeyValue> propertyMapping;
    protected List<OvfResourceMap> resourceMapping;
    protected String diskProvisioning;
    protected OvfConsumerOstNode instantiationOst;

    /**
     * Gets the value of the entityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * Sets the value of the entityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityName(String value) {
        this.entityName = value;
    }

    /**
     * Gets the value of the hostSystem property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getHostSystem() {
        return hostSystem;
    }

    /**
     * Sets the value of the hostSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setHostSystem(ManagedObjectReference value) {
        this.hostSystem = value;
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
     * {@link OvfNetworkMapping }
     * 
     * 
     */
    public List<OvfNetworkMapping> getNetworkMapping() {
        if (networkMapping == null) {
            networkMapping = new ArrayList<OvfNetworkMapping>();
        }
        return this.networkMapping;
    }

    /**
     * Gets the value of the ipAllocationPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpAllocationPolicy() {
        return ipAllocationPolicy;
    }

    /**
     * Sets the value of the ipAllocationPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpAllocationPolicy(String value) {
        this.ipAllocationPolicy = value;
    }

    /**
     * Gets the value of the ipProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpProtocol() {
        return ipProtocol;
    }

    /**
     * Sets the value of the ipProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpProtocol(String value) {
        this.ipProtocol = value;
    }

    /**
     * Gets the value of the propertyMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValue }
     * 
     * 
     */
    public List<KeyValue> getPropertyMapping() {
        if (propertyMapping == null) {
            propertyMapping = new ArrayList<KeyValue>();
        }
        return this.propertyMapping;
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
     * {@link OvfResourceMap }
     * 
     * 
     */
    public List<OvfResourceMap> getResourceMapping() {
        if (resourceMapping == null) {
            resourceMapping = new ArrayList<OvfResourceMap>();
        }
        return this.resourceMapping;
    }

    /**
     * Gets the value of the diskProvisioning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskProvisioning() {
        return diskProvisioning;
    }

    /**
     * Sets the value of the diskProvisioning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskProvisioning(String value) {
        this.diskProvisioning = value;
    }

    /**
     * Gets the value of the instantiationOst property.
     * 
     * @return
     *     possible object is
     *     {@link OvfConsumerOstNode }
     *     
     */
    public OvfConsumerOstNode getInstantiationOst() {
        return instantiationOst;
    }

    /**
     * Sets the value of the instantiationOst property.
     * 
     * @param value
     *     allowed object is
     *     {@link OvfConsumerOstNode }
     *     
     */
    public void setInstantiationOst(OvfConsumerOstNode value) {
        this.instantiationOst = value;
    }

}
