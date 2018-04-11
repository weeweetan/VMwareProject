
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScheduledTaskDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScheduledTaskDescription">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="action" type="{urn:vim25}TypeDescription" maxOccurs="unbounded"/>
 *         &lt;element name="schedulerInfo" type="{urn:vim25}ScheduledTaskDetail" maxOccurs="unbounded"/>
 *         &lt;element name="state" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="dayOfWeek" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="weekOfMonth" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScheduledTaskDescription", propOrder = {
    "action",
    "schedulerInfo",
    "state",
    "dayOfWeek",
    "weekOfMonth"
})
public class ScheduledTaskDescription
    extends DynamicData
{

    @XmlElement(required = true)
    protected List<TypeDescription> action;
    @XmlElement(required = true)
    protected List<ScheduledTaskDetail> schedulerInfo;
    @XmlElement(required = true)
    protected List<ElementDescription> state;
    @XmlElement(required = true)
    protected List<ElementDescription> dayOfWeek;
    @XmlElement(required = true)
    protected List<ElementDescription> weekOfMonth;

    /**
     * Gets the value of the action property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the action property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeDescription }
     * 
     * 
     */
    public List<TypeDescription> getAction() {
        if (action == null) {
            action = new ArrayList<TypeDescription>();
        }
        return this.action;
    }

    /**
     * Gets the value of the schedulerInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schedulerInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchedulerInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScheduledTaskDetail }
     * 
     * 
     */
    public List<ScheduledTaskDetail> getSchedulerInfo() {
        if (schedulerInfo == null) {
            schedulerInfo = new ArrayList<ScheduledTaskDetail>();
        }
        return this.schedulerInfo;
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
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getState() {
        if (state == null) {
            state = new ArrayList<ElementDescription>();
        }
        return this.state;
    }

    /**
     * Gets the value of the dayOfWeek property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dayOfWeek property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDayOfWeek().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getDayOfWeek() {
        if (dayOfWeek == null) {
            dayOfWeek = new ArrayList<ElementDescription>();
        }
        return this.dayOfWeek;
    }

    /**
     * Gets the value of the weekOfMonth property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the weekOfMonth property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWeekOfMonth().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getWeekOfMonth() {
        if (weekOfMonth == null) {
            weekOfMonth = new ArrayList<ElementDescription>();
        }
        return this.weekOfMonth;
    }

}
