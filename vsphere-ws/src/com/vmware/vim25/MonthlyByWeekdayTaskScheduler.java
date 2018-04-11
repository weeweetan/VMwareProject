
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MonthlyByWeekdayTaskScheduler complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MonthlyByWeekdayTaskScheduler">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}MonthlyTaskScheduler">
 *       &lt;sequence>
 *         &lt;element name="offset" type="{urn:vim25}WeekOfMonth"/>
 *         &lt;element name="weekday" type="{urn:vim25}DayOfWeek"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MonthlyByWeekdayTaskScheduler", propOrder = {
    "offset",
    "weekday"
})
public class MonthlyByWeekdayTaskScheduler
    extends MonthlyTaskScheduler
{

    @XmlElement(required = true)
    protected WeekOfMonth offset;
    @XmlElement(required = true)
    protected DayOfWeek weekday;

    /**
     * Gets the value of the offset property.
     * 
     * @return
     *     possible object is
     *     {@link WeekOfMonth }
     *     
     */
    public WeekOfMonth getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeekOfMonth }
     *     
     */
    public void setOffset(WeekOfMonth value) {
        this.offset = value;
    }

    /**
     * Gets the value of the weekday property.
     * 
     * @return
     *     possible object is
     *     {@link DayOfWeek }
     *     
     */
    public DayOfWeek getWeekday() {
        return weekday;
    }

    /**
     * Sets the value of the weekday property.
     * 
     * @param value
     *     allowed object is
     *     {@link DayOfWeek }
     *     
     */
    public void setWeekday(DayOfWeek value) {
        this.weekday = value;
    }

}
