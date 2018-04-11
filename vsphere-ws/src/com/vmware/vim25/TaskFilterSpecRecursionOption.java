
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskFilterSpecRecursionOption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaskFilterSpecRecursionOption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="self"/>
 *     &lt;enumeration value="children"/>
 *     &lt;enumeration value="all"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaskFilterSpecRecursionOption")
@XmlEnum
public enum TaskFilterSpecRecursionOption {

    @XmlEnumValue("self")
    SELF("self"),
    @XmlEnumValue("children")
    CHILDREN("children"),
    @XmlEnumValue("all")
    ALL("all");
    private final String value;

    TaskFilterSpecRecursionOption(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskFilterSpecRecursionOption fromValue(String v) {
        for (TaskFilterSpecRecursionOption c: TaskFilterSpecRecursionOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
