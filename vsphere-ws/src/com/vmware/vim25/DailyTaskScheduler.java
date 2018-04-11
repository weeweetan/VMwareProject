
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DailyTaskScheduler complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DailyTaskScheduler">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HourlyTaskScheduler">
 *       &lt;sequence>
 *         &lt;element name="hour" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DailyTaskScheduler", propOrder = {
    "hour"
})
@XmlSeeAlso({
    MonthlyTaskScheduler.class,
    WeeklyTaskScheduler.class
})
public class DailyTaskScheduler
    extends HourlyTaskScheduler
{

    protected int hour;

    /**
     * Gets the value of the hour property.
     * 
     */
    public int getHour() {
        return hour;
    }

    /**
     * Sets the value of the hour property.
     * 
     */
    public void setHour(int value) {
        this.hour = value;
    }

}
