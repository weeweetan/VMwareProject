
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostConfigChangeMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostConfigChangeMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="modify"/>
 *     &lt;enumeration value="replace"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostConfigChangeMode")
@XmlEnum
public enum HostConfigChangeMode {

    @XmlEnumValue("modify")
    MODIFY("modify"),
    @XmlEnumValue("replace")
    REPLACE("replace");
    private final String value;

    HostConfigChangeMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostConfigChangeMode fromValue(String v) {
        for (HostConfigChangeMode c: HostConfigChangeMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
