
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhysicalNicResourcePoolSchedulerDisallowedReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PhysicalNicResourcePoolSchedulerDisallowedReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="userOptOut"/>
 *     &lt;enumeration value="hardwareUnsupported"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PhysicalNicResourcePoolSchedulerDisallowedReason")
@XmlEnum
public enum PhysicalNicResourcePoolSchedulerDisallowedReason {

    @XmlEnumValue("userOptOut")
    USER_OPT_OUT("userOptOut"),
    @XmlEnumValue("hardwareUnsupported")
    HARDWARE_UNSUPPORTED("hardwareUnsupported");
    private final String value;

    PhysicalNicResourcePoolSchedulerDisallowedReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PhysicalNicResourcePoolSchedulerDisallowedReason fromValue(String v) {
        for (PhysicalNicResourcePoolSchedulerDisallowedReason c: PhysicalNicResourcePoolSchedulerDisallowedReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
