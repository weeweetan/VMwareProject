
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostPowerOperationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostPowerOperationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="powerOn"/>
 *     &lt;enumeration value="powerOff"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostPowerOperationType")
@XmlEnum
public enum HostPowerOperationType {

    @XmlEnumValue("powerOn")
    POWER_ON("powerOn"),
    @XmlEnumValue("powerOff")
    POWER_OFF("powerOff");
    private final String value;

    HostPowerOperationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostPowerOperationType fromValue(String v) {
        for (HostPowerOperationType c: HostPowerOperationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
