
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskInfoState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaskInfoState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="queued"/>
 *     &lt;enumeration value="running"/>
 *     &lt;enumeration value="success"/>
 *     &lt;enumeration value="error"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaskInfoState")
@XmlEnum
public enum TaskInfoState {

    @XmlEnumValue("queued")
    QUEUED("queued"),
    @XmlEnumValue("running")
    RUNNING("running"),
    @XmlEnumValue("success")
    SUCCESS("success"),
    @XmlEnumValue("error")
    ERROR("error");
    private final String value;

    TaskInfoState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskInfoState fromValue(String v) {
        for (TaskInfoState c: TaskInfoState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
