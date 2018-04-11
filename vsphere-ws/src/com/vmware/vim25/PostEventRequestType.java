
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PostEventRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostEventRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="eventToPost" type="{urn:vim25}Event"/>
 *         &lt;element name="taskInfo" type="{urn:vim25}TaskInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostEventRequestType", propOrder = {
    "_this",
    "eventToPost",
    "taskInfo"
})
public class PostEventRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected Event eventToPost;
    protected TaskInfo taskInfo;

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
     * Gets the value of the eventToPost property.
     * 
     * @return
     *     possible object is
     *     {@link Event }
     *     
     */
    public Event getEventToPost() {
        return eventToPost;
    }

    /**
     * Sets the value of the eventToPost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Event }
     *     
     */
    public void setEventToPost(Event value) {
        this.eventToPost = value;
    }

    /**
     * Gets the value of the taskInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TaskInfo }
     *     
     */
    public TaskInfo getTaskInfo() {
        return taskInfo;
    }

    /**
     * Sets the value of the taskInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskInfo }
     *     
     */
    public void setTaskInfo(TaskInfo value) {
        this.taskInfo = value;
    }

}
