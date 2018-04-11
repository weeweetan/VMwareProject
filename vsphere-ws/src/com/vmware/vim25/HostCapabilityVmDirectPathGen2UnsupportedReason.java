
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostCapabilityVmDirectPathGen2UnsupportedReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostCapabilityVmDirectPathGen2UnsupportedReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="hostNptIncompatibleProduct"/>
 *     &lt;enumeration value="hostNptIncompatibleHardware"/>
 *     &lt;enumeration value="hostNptDisabled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostCapabilityVmDirectPathGen2UnsupportedReason")
@XmlEnum
public enum HostCapabilityVmDirectPathGen2UnsupportedReason {

    @XmlEnumValue("hostNptIncompatibleProduct")
    HOST_NPT_INCOMPATIBLE_PRODUCT("hostNptIncompatibleProduct"),
    @XmlEnumValue("hostNptIncompatibleHardware")
    HOST_NPT_INCOMPATIBLE_HARDWARE("hostNptIncompatibleHardware"),
    @XmlEnumValue("hostNptDisabled")
    HOST_NPT_DISABLED("hostNptDisabled");
    private final String value;

    HostCapabilityVmDirectPathGen2UnsupportedReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostCapabilityVmDirectPathGen2UnsupportedReason fromValue(String v) {
        for (HostCapabilityVmDirectPathGen2UnsupportedReason c: HostCapabilityVmDirectPathGen2UnsupportedReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
