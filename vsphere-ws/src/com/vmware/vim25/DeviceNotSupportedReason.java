
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceNotSupportedReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeviceNotSupportedReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="host"/>
 *     &lt;enumeration value="guest"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeviceNotSupportedReason")
@XmlEnum
public enum DeviceNotSupportedReason {

    @XmlEnumValue("host")
    HOST("host"),
    @XmlEnumValue("guest")
    GUEST("guest");
    private final String value;

    DeviceNotSupportedReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeviceNotSupportedReason fromValue(String v) {
        for (DeviceNotSupportedReason c: DeviceNotSupportedReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
