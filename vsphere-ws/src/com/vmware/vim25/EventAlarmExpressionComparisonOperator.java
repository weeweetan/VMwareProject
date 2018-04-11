
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EventAlarmExpressionComparisonOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EventAlarmExpressionComparisonOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="equals"/>
 *     &lt;enumeration value="notEqualTo"/>
 *     &lt;enumeration value="startsWith"/>
 *     &lt;enumeration value="doesNotStartWith"/>
 *     &lt;enumeration value="endsWith"/>
 *     &lt;enumeration value="doesNotEndWith"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EventAlarmExpressionComparisonOperator")
@XmlEnum
public enum EventAlarmExpressionComparisonOperator {

    @XmlEnumValue("equals")
    EQUALS("equals"),
    @XmlEnumValue("notEqualTo")
    NOT_EQUAL_TO("notEqualTo"),
    @XmlEnumValue("startsWith")
    STARTS_WITH("startsWith"),
    @XmlEnumValue("doesNotStartWith")
    DOES_NOT_START_WITH("doesNotStartWith"),
    @XmlEnumValue("endsWith")
    ENDS_WITH("endsWith"),
    @XmlEnumValue("doesNotEndWith")
    DOES_NOT_END_WITH("doesNotEndWith");
    private final String value;

    EventAlarmExpressionComparisonOperator(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EventAlarmExpressionComparisonOperator fromValue(String v) {
        for (EventAlarmExpressionComparisonOperator c: EventAlarmExpressionComparisonOperator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
