
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostSystemPowerState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostSystemPowerState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="poweredOn"/>
 *     &lt;enumeration value="poweredOff"/>
 *     &lt;enumeration value="standBy"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostSystemPowerState")
@XmlEnum
public enum HostSystemPowerState {

    @XmlEnumValue("poweredOn")
    POWERED_ON("poweredOn"),
    @XmlEnumValue("poweredOff")
    POWERED_OFF("poweredOff"),
    @XmlEnumValue("standBy")
    STAND_BY("standBy"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    HostSystemPowerState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostSystemPowerState fromValue(String v) {
        for (HostSystemPowerState c: HostSystemPowerState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
