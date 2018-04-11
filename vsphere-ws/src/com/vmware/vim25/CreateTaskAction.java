
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateTaskAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateTaskAction">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}Action">
 *       &lt;sequence>
 *         &lt;element name="taskTypeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cancelable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateTaskAction", propOrder = {
    "taskTypeId",
    "cancelable"
})
public class CreateTaskAction
    extends Action
{

    @XmlElement(required = true)
    protected String taskTypeId;
    protected boolean cancelable;

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

}
