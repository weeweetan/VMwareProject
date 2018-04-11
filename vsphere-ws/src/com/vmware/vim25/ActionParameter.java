
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActionParameter.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActionParameter">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="targetName"/>
 *     &lt;enumeration value="alarmName"/>
 *     &lt;enumeration value="oldStatus"/>
 *     &lt;enumeration value="newStatus"/>
 *     &lt;enumeration value="triggeringSummary"/>
 *     &lt;enumeration value="declaringSummary"/>
 *     &lt;enumeration value="eventDescription"/>
 *     &lt;enumeration value="target"/>
 *     &lt;enumeration value="alarm"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActionParameter")
@XmlEnum
public enum ActionParameter {

    @XmlEnumValue("targetName")
    TARGET_NAME("targetName"),
    @XmlEnumValue("alarmName")
    ALARM_NAME("alarmName"),
    @XmlEnumValue("oldStatus")
    OLD_STATUS("oldStatus"),
    @XmlEnumValue("newStatus")
    NEW_STATUS("newStatus"),
    @XmlEnumValue("triggeringSummary")
    TRIGGERING_SUMMARY("triggeringSummary"),
    @XmlEnumValue("declaringSummary")
    DECLARING_SUMMARY("declaringSummary"),
    @XmlEnumValue("eventDescription")
    EVENT_DESCRIPTION("eventDescription"),
    @XmlEnumValue("target")
    TARGET("target"),
    @XmlEnumValue("alarm")
    ALARM("alarm");
    private final String value;

    ActionParameter(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActionParameter fromValue(String v) {
        for (ActionParameter c: ActionParameter.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
