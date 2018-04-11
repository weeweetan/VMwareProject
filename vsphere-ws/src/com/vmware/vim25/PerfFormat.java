
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerfFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PerfFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="normal"/>
 *     &lt;enumeration value="csv"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PerfFormat")
@XmlEnum
public enum PerfFormat {

    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("csv")
    CSV("csv");
    private final String value;

    PerfFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PerfFormat fromValue(String v) {
        for (PerfFormat c: PerfFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
