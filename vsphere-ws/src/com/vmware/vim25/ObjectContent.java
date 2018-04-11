
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObjectContent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObjectContent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="obj" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="propSet" type="{urn:vim25}DynamicProperty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="missingSet" type="{urn:vim25}MissingProperty" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectContent", propOrder = {
    "obj",
    "propSet",
    "missingSet"
})
public class ObjectContent
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference obj;
    protected List<DynamicProperty> propSet;
    protected List<MissingProperty> missingSet;

    /**
     * Gets the value of the obj property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getObj() {
        return obj;
    }

    /**
     * Sets the value of the obj property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setObj(ManagedObjectReference value) {
        this.obj = value;
    }

    /**
     * Gets the value of the propSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DynamicProperty }
     * 
     * 
     */
    public List<DynamicProperty> getPropSet() {
        if (propSet == null) {
            propSet = new ArrayList<DynamicProperty>();
        }
        return this.propSet;
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
     * {@link MissingProperty }
     * 
     * 
     */
    public List<MissingProperty> getMissingSet() {
        if (missingSet == null) {
            missingSet = new ArrayList<MissingProperty>();
        }
        return this.missingSet;
    }

}
