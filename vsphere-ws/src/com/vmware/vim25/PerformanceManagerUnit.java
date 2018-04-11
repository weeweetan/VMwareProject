
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerformanceManagerUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PerformanceManagerUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="percent"/>
 *     &lt;enumeration value="kiloBytes"/>
 *     &lt;enumeration value="megaBytes"/>
 *     &lt;enumeration value="megaHertz"/>
 *     &lt;enumeration value="number"/>
 *     &lt;enumeration value="microsecond"/>
 *     &lt;enumeration value="millisecond"/>
 *     &lt;enumeration value="second"/>
 *     &lt;enumeration value="kiloBytesPerSecond"/>
 *     &lt;enumeration value="megaBytesPerSecond"/>
 *     &lt;enumeration value="watt"/>
 *     &lt;enumeration value="joule"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PerformanceManagerUnit")
@XmlEnum
public enum PerformanceManagerUnit {

    @XmlEnumValue("percent")
    PERCENT("percent"),
    @XmlEnumValue("kiloBytes")
    KILO_BYTES("kiloBytes"),
    @XmlEnumValue("megaBytes")
    MEGA_BYTES("megaBytes"),
    @XmlEnumValue("megaHertz")
    MEGA_HERTZ("megaHertz"),
    @XmlEnumValue("number")
    NUMBER("number"),
    @XmlEnumValue("microsecond")
    MICROSECOND("microsecond"),
    @XmlEnumValue("millisecond")
    MILLISECOND("millisecond"),
    @XmlEnumValue("second")
    SECOND("second"),
    @XmlEnumValue("kiloBytesPerSecond")
    KILO_BYTES_PER_SECOND("kiloBytesPerSecond"),
    @XmlEnumValue("megaBytesPerSecond")
    MEGA_BYTES_PER_SECOND("megaBytesPerSecond"),
    @XmlEnumValue("watt")
    WATT("watt"),
    @XmlEnumValue("joule")
    JOULE("joule");
    private final String value;

    PerformanceManagerUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PerformanceManagerUnit fromValue(String v) {
        for (PerformanceManagerUnit c: PerformanceManagerUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
