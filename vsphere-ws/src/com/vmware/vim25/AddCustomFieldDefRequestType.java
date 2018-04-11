
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddCustomFieldDefRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddCustomFieldDefRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="moType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fieldDefPolicy" type="{urn:vim25}PrivilegePolicyDef" minOccurs="0"/>
 *         &lt;element name="fieldPolicy" type="{urn:vim25}PrivilegePolicyDef" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddCustomFieldDefRequestType", propOrder = {
    "_this",
    "name",
    "moType",
    "fieldDefPolicy",
    "fieldPolicy"
})
public class AddCustomFieldDefRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected String name;
    protected String moType;
    protected PrivilegePolicyDef fieldDefPolicy;
    protected PrivilegePolicyDef fieldPolicy;

    /**
     * Gets the value of the this property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getThis() {
        return _this;
    }

    /**
     * Sets the value of the this property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setThis(ManagedObjectReference value) {
        this._this = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the moType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoType() {
        return moType;
    }

    /**
     * Sets the value of the moType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoType(String value) {
        this.moType = value;
    }

    /**
     * Gets the value of the fieldDefPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link PrivilegePolicyDef }
     *     
     */
    public PrivilegePolicyDef getFieldDefPolicy() {
        return fieldDefPolicy;
    }

    /**
     * Sets the value of the fieldDefPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivilegePolicyDef }
     *     
     */
    public void setFieldDefPolicy(PrivilegePolicyDef value) {
        this.fieldDefPolicy = value;
    }

    /**
     * Gets the value of the fieldPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link PrivilegePolicyDef }
     *     
     */
    public PrivilegePolicyDef getFieldPolicy() {
        return fieldPolicy;
    }

    /**
     * Sets the value of the fieldPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivilegePolicyDef }
     *     
     */
    public void setFieldPolicy(PrivilegePolicyDef value) {
        this.fieldPolicy = value;
    }

}
