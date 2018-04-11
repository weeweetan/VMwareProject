
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VAppConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VAppConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmConfigInfo">
 *       &lt;sequence>
 *         &lt;element name="entityConfig" type="{urn:vim25}VAppEntityConfigInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="annotation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instanceUuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="managedBy" type="{urn:vim25}ManagedByInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VAppConfigInfo", propOrder = {
    "entityConfig",
    "annotation",
    "instanceUuid",
    "managedBy"
})
public class VAppConfigInfo
    extends VmConfigInfo
{

    protected List<VAppEntityConfigInfo> entityConfig;
    @XmlElement(required = true)
    protected String annotation;
    protected String instanceUuid;
    protected ManagedByInfo managedBy;

    /**
     * Gets the value of the entityConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entityConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntityConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VAppEntityConfigInfo }
     * 
     * 
     */
    public List<VAppEntityConfigInfo> getEntityConfig() {
        if (entityConfig == null) {
            entityConfig = new ArrayList<VAppEntityConfigInfo>();
        }
        return this.entityConfig;
    }

    /**
     * Gets the value of the annotation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnotation(String value) {
        this.annotation = value;
    }

    /**
     * Gets the value of the instanceUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceUuid() {
        return instanceUuid;
    }

    /**
     * Sets the value of the instanceUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceUuid(String value) {
        this.instanceUuid = value;
    }

    /**
     * Gets the value of the managedBy property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedByInfo }
     *     
     */
    public ManagedByInfo getManagedBy() {
        return managedBy;
    }

    /**
     * Sets the value of the managedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedByInfo }
     *     
     */
    public void setManagedBy(ManagedByInfo value) {
        this.managedBy = value;
    }

}
