
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostNumericSensorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostNumericSensorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="fan"/>
 *     &lt;enumeration value="power"/>
 *     &lt;enumeration value="temperature"/>
 *     &lt;enumeration value="voltage"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostNumericSensorType")
@XmlEnum
public enum HostNumericSensorType {

    @XmlEnumValue("fan")
    FAN("fan"),
    @XmlEnumValue("power")
    POWER("power"),
    @XmlEnumValue("temperature")
    TEMPERATURE("temperature"),
    @XmlEnumValue("voltage")
    VOLTAGE("voltage"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    HostNumericSensorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostNumericSensorType fromValue(String v) {
        for (HostNumericSensorType c: HostNumericSensorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
