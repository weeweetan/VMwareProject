
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScheduledTaskEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScheduledTaskEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}Event">
 *       &lt;sequence>
 *         &lt;element name="scheduledTask" type="{urn:vim25}ScheduledTaskEventArgument"/>
 *         &lt;element name="entity" type="{urn:vim25}ManagedEntityEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScheduledTaskEvent", propOrder = {
    "scheduledTask",
    "entity"
})
@XmlSeeAlso({
    ScheduledTaskReconfiguredEvent.class,
    ScheduledTaskFailedEvent.class,
    ScheduledTaskRemovedEvent.class,
    ScheduledTaskEmailCompletedEvent.class,
    ScheduledTaskStartedEvent.class,
    ScheduledTaskEmailFailedEvent.class,
    ScheduledTaskCreatedEvent.class,
    ScheduledTaskCompletedEvent.class
})
public class ScheduledTaskEvent
    extends Event
{

    @XmlElement(required = true)
    protected ScheduledTaskEventArgument scheduledTask;
    @XmlElement(required = true)
    protected ManagedEntityEventArgument entity;

    /**
     * Gets the value of the scheduledTask property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledTaskEventArgument }
     *     
     */
    public ScheduledTaskEventArgument getScheduledTask() {
        return scheduledTask;
    }

    /**
     * Sets the value of the scheduledTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledTaskEventArgument }
     *     
     */
    public void setScheduledTask(ScheduledTaskEventArgument value) {
        this.scheduledTask = value;
    }

    /**
     * Gets the value of the entity property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedEntityEventArgument }
     *     
     */
    public ManagedEntityEventArgument getEntity() {
        return entity;
    }

    /**
     * Sets the value of the entity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedEntityEventArgument }
     *     
     */
    public void setEntity(ManagedEntityEventArgument value) {
        this.entity = value;
    }

}
