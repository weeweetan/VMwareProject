
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyFilterUpdate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyFilterUpdate">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="filter" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="objectSet" type="{urn:vim25}ObjectUpdate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="missingSet" type="{urn:vim25}MissingObject" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyFilterUpdate", propOrder = {
    "filter",
    "objectSet",
    "missingSet"
})
public class PropertyFilterUpdate
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference filter;
    protected List<ObjectUpdate> objectSet;
    protected List<MissingObject> missingSet;

    /**
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setFilter(ManagedObjectReference value) {
        this.filter = value;
    }

    /**
     * Gets the value of the objectSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjectUpdate }
     * 
     * 
     */
    public List<ObjectUpdate> getObjectSet() {
        if (objectSet == null) {
            objectSet = new ArrayList<ObjectUpdate>();
        }
        return this.objectSet;
    }

    /**
     * Gets the value of the missingSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the missingSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMissingSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MissingObject }
     * 
     * 
     */
    public List<MissingObject> getMissingSet() {
        if (missingSet == null) {
            missingSet = new ArrayList<MissingObject>();
        }
        return this.missingSet;
    }

}
