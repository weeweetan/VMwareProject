
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostNumericSensorHealthState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostNumericSensorHealthState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="green"/>
 *     &lt;enumeration value="yellow"/>
 *     &lt;enumeration value="red"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostNumericSensorHealthState")
@XmlEnum
public enum HostNumericSensorHealthState {

    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),
    @XmlEnumValue("green")
    GREEN("green"),
    @XmlEnumValue("yellow")
    YELLOW("yellow"),
    @XmlEnumValue("red")
    RED("red");
    private final String value;

    HostNumericSensorHealthState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostNumericSensorHealthState fromValue(String v) {
        for (HostNumericSensorHealthState c: HostNumericSensorHealthState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
