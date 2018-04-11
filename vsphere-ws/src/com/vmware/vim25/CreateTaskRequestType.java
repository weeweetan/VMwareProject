
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateTaskRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateTaskRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="obj" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="taskTypeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="initiatedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cancelable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="parentTaskKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateTaskRequestType", propOrder = {
    "_this",
    "obj",
    "taskTypeId",
    "initiatedBy",
    "cancelable",
    "parentTaskKey"
})
public class CreateTaskRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected ManagedObjectReference obj;
    @XmlElement(required = true)
    protected String taskTypeId;
    protected String initiatedBy;
    protected boolean cancelable;
    protected String parentTaskKey;

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
     * Gets the value of the taskTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskTypeId() {
        return taskTypeId;
    }

    /**
     * Sets the value of the taskTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskTypeId(String value) {
        this.taskTypeId = value;
    }

    /**
     * Gets the value of the initiatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitiatedBy() {
        return initiatedBy;
    }

    /**
     * Sets the value of the initiatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitiatedBy(String value) {
        this.initiatedBy = value;
    }

    /**
     * Gets the value of the cancelable property.
     * 
     */
    public boolean isCancelable() {
        return cancelable;
    }

    /**
     * Sets the value of the cancelable property.
     * 
     */
    public void setCancelable(boolean value) {
        this.cancelable = value;
    }

    /**
     * Gets the value of the parentTaskKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentTaskKey() {
        return parentTaskKey;
    }

    /**
     * Sets the value of the parentTaskKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentTaskKey(String value) {
        this.parentTaskKey = value;
    }

}
