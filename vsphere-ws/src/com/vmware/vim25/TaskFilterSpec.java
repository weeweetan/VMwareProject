
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskFilterSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaskFilterSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="entity" type="{urn:vim25}TaskFilterSpecByEntity" minOccurs="0"/>
 *         &lt;element name="time" type="{urn:vim25}TaskFilterSpecByTime" minOccurs="0"/>
 *         &lt;element name="userName" type="{urn:vim25}TaskFilterSpecByUsername" minOccurs="0"/>
 *         &lt;element name="state" type="{urn:vim25}TaskInfoState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="alarm" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="scheduledTask" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="eventChainId" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="parentTaskKey" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rootTaskKey" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaskFilterSpec", propOrder = {
    "entity",
    "time",
    "userName",
    "state",
    "alarm",
    "scheduledTask",
    "eventChainId",
    "tag",
    "parentTaskKey",
    "rootTaskKey"
})
public class TaskFilterSpec
    extends DynamicData
{

    protected TaskFilterSpecByEntity entity;
    protected TaskFilterSpecByTime time;
    protected TaskFilterSpecByUsername userName;
    protected List<TaskInfoState> state;
    protected ManagedObjectReference alarm;
    protected ManagedObjectReference scheduledTask;
    @XmlElement(type = Integer.class)
    protected List<Integer> eventChainId;
    protected List<String> tag;
    protected List<String> parentTaskKey;
    protected List<String> rootTaskKey;

    /**
     * Gets the value of the entity property.
     * 
     * @return
     *     possible object is
     *     {@link TaskFilterSpecByEntity }
     *     
     */
    public TaskFilterSpecByEntity getEntity() {
        return entity;
    }

    /**
     * Sets the value of the entity property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskFilterSpecByEntity }
     *     
     */
    public void setEntity(TaskFilterSpecByEntity value) {
        this.entity = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link TaskFilterSpecByTime }
     *     
     */
    public TaskFilterSpecByTime getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskFilterSpecByTime }
     *     
     */
    public void setTime(TaskFilterSpecByTime value) {
        this.time = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link TaskFilterSpecByUsername }
     *     
     */
    public TaskFilterSpecByUsername getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskFilterSpecByUsername }
     *     
     */
    public void setUserName(TaskFilterSpecByUsername value) {
        this.userName = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the state property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskInfoState }
     * 
     * 
     */
    public List<TaskInfoState> getState() {
        if (state == null) {
            state = new ArrayList<TaskInfoState>();
        }
        return this.state;
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
     * Gets the value of the eventChainId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventChainId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventChainId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getEventChainId() {
        if (eventChainId == null) {
            eventChainId = new ArrayList<Integer>();
        }
        return this.eventChainId;
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
     * Gets the value of the parentTaskKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parentTaskKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParentTaskKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getParentTaskKey() {
        if (parentTaskKey == null) {
            parentTaskKey = new ArrayList<String>();
        }
        return this.parentTaskKey;
    }

    /**
     * Gets the value of the rootTaskKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rootTaskKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRootTaskKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRootTaskKey() {
        if (rootTaskKey == null) {
            rootTaskKey = new ArrayList<String>();
        }
        return this.rootTaskKey;
    }

}
