
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostReplayUnsupportedReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostReplayUnsupportedReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="incompatibleProduct"/>
 *     &lt;enumeration value="incompatibleCpu"/>
 *     &lt;enumeration value="hvDisabled"/>
 *     &lt;enumeration value="cpuidLimitSet"/>
 *     &lt;enumeration value="oldBIOS"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostReplayUnsupportedReason")
@XmlEnum
public enum HostReplayUnsupportedReason {

    @XmlEnumValue("incompatibleProduct")
    INCOMPATIBLE_PRODUCT("incompatibleProduct"),
    @XmlEnumValue("incompatibleCpu")
    INCOMPATIBLE_CPU("incompatibleCpu"),
    @XmlEnumValue("hvDisabled")
    HV_DISABLED("hvDisabled"),
    @XmlEnumValue("cpuidLimitSet")
    CPUID_LIMIT_SET("cpuidLimitSet"),
    @XmlEnumValue("oldBIOS")
    OLD_BIOS("oldBIOS"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    HostReplayUnsupportedReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostReplayUnsupportedReason fromValue(String v) {
        for (HostReplayUnsupportedReason c: HostReplayUnsupportedReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
