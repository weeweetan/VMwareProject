
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultipathState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MultipathState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="standby"/>
 *     &lt;enumeration value="active"/>
 *     &lt;enumeration value="disabled"/>
 *     &lt;enumeration value="dead"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MultipathState")
@XmlEnum
public enum MultipathState {

    @XmlEnumValue("standby")
    STANDBY("standby"),
    @XmlEnumValue("active")
    ACTIVE("active"),
    @XmlEnumValue("disabled")
    DISABLED("disabled"),
    @XmlEnumValue("dead")
    DEAD("dead"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    MultipathState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MultipathState fromValue(String v) {
        for (MultipathState c: MultipathState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
