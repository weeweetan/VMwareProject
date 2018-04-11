
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EventFilterSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventFilterSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="entity" type="{urn:vim25}EventFilterSpecByEntity" minOccurs="0"/>
 *         &lt;element name="time" type="{urn:vim25}EventFilterSpecByTime" minOccurs="0"/>
 *         &lt;element name="userName" type="{urn:vim25}EventFilterSpecByUsername" minOccurs="0"/>
 *         &lt;element name="eventChainId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="alarm" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="scheduledTask" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="disableFullMessage" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="eventTypeId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventFilterSpec", propOrder = {
    "entity",
    "time",
    "userName",
    "eventChainId",
    "alarm",
    "scheduledTask",
    "disableFullMessage",
    "category",
    "type",
    "tag",
    "eventTypeId"
})
public class EventFilterSpec
    extends DynamicData
{

    protected EventFilterSpecByEntity entity;
    protected EventFilterSpecByTime time;
    protected EventFilterSpecByUsername userName;
    protected Integer eventChainId;
    protected ManagedObjectReference alarm;
    protected ManagedObjectReference scheduledTask;
    protected Boolean disableFullMessage;
    protected List<String> category;
    protected List<String> type;
    protected List<String> tag;
    protected List<String> eventTypeId;

    /**
     * Gets the value of the entity property.
     * 
     * @return
     *     possible object is
     *     {@link EventFilterSpecByEntity }
     *     
     */
    public EventFilterSpecByEntity getEntity() {
        return entity;
    }

    /**
     * Sets the value of the entity property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventFilterSpecByEntity }
     *     
     */
    public void setEntity(EventFilterSpecByEntity value) {
        this.entity = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link EventFilterSpecByTime }
     *     
     */
    public EventFilterSpecByTime getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventFilterSpecByTime }
     *     
     */
    public void setTime(EventFilterSpecByTime value) {
        this.time = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link EventFilterSpecByUsername }
     *     
     */
    public EventFilterSpecByUsername getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventFilterSpecByUsername }
     *     
     */
    public void setUserName(EventFilterSpecByUsername value) {
        this.userName = value;
    }

    /**
     * Gets the value of the eventChainId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEventChainId() {
        return eventChainId;
    }

    /**
     * Sets the value of the eventChainId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEventChainId(Integer value) {
        this.eventChainId = value;
    }

    /**
     * Gets the value of the alarm property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getAlarm() {
        return alarm;
    }

    /**
     * Sets the value of the alarm property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setAlarm(ManagedObjectReference value) {
        this.alarm = value;
    }

    /**
     * Gets the value of the scheduledTask property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getScheduledTask() {
        return scheduledTask;
    }

    /**
     * Sets the value of the scheduledTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setScheduledTask(ManagedObjectReference value) {
        this.scheduledTask = value;
    }

    /**
     * Gets the value of the disableFullMessage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisableFullMessage() {
        return disableFullMessage;
    }

    /**
     * Sets the value of the disableFullMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisableFullMessage(Boolean value) {
        this.disableFullMessage = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the category property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCategory() {
        if (category == null) {
            category = new ArrayList<String>();
        }
        return this.category;
    }

    /**
     * Gets the value of the type property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the type property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getType() {
        if (type == null) {
            type = new ArrayList<String>();
        }
        return this.type;
    }

    /**
     * Gets the value of the tag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTag().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTag() {
        if (tag == null) {
            tag = new ArrayList<String>();
        }
        return this.tag;
    }

    /**
     * Gets the value of the eventTypeId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventTypeId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventTypeId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEventTypeId() {
        if (eventTypeId == null) {
            eventTypeId = new ArrayList<String>();
        }
        return this.eventTypeId;
    }

}
