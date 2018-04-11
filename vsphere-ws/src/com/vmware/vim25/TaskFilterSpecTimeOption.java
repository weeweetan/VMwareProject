
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskFilterSpecTimeOption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaskFilterSpecTimeOption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="queuedTime"/>
 *     &lt;enumeration value="startedTime"/>
 *     &lt;enumeration value="completedTime"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaskFilterSpecTimeOption")
@XmlEnum
public enum TaskFilterSpecTimeOption {

    @XmlEnumValue("queuedTime")
    QUEUED_TIME("queuedTime"),
    @XmlEnumValue("startedTime")
    STARTED_TIME("startedTime"),
    @XmlEnumValue("completedTime")
    COMPLETED_TIME("completedTime");
    private final String value;

    TaskFilterSpecTimeOption(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskFilterSpecTimeOption fromValue(String v) {
        for (TaskFilterSpecTimeOption c: TaskFilterSpecTimeOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
