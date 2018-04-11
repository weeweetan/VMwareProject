
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StateAlarmOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StateAlarmOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="isEqual"/>
 *     &lt;enumeration value="isUnequal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StateAlarmOperator")
@XmlEnum
public enum StateAlarmOperator {

    @XmlEnumValue("isEqual")
    IS_EQUAL("isEqual"),
    @XmlEnumValue("isUnequal")
    IS_UNEQUAL("isUnequal");
    private final String value;

    StateAlarmOperator(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StateAlarmOperator fromValue(String v) {
        for (StateAlarmOperator c: StateAlarmOperator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
