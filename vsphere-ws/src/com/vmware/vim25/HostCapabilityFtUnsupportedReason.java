
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostCapabilityFtUnsupportedReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostCapabilityFtUnsupportedReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="vMotionNotLicensed"/>
 *     &lt;enumeration value="missingVMotionNic"/>
 *     &lt;enumeration value="missingFTLoggingNic"/>
 *     &lt;enumeration value="ftNotLicensed"/>
 *     &lt;enumeration value="haAgentIssue"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostCapabilityFtUnsupportedReason")
@XmlEnum
public enum HostCapabilityFtUnsupportedReason {

    @XmlEnumValue("vMotionNotLicensed")
    V_MOTION_NOT_LICENSED("vMotionNotLicensed"),
    @XmlEnumValue("missingVMotionNic")
    MISSING_V_MOTION_NIC("missingVMotionNic"),
    @XmlEnumValue("missingFTLoggingNic")
    MISSING_FT_LOGGING_NIC("missingFTLoggingNic"),
    @XmlEnumValue("ftNotLicensed")
    FT_NOT_LICENSED("ftNotLicensed"),
    @XmlEnumValue("haAgentIssue")
    HA_AGENT_ISSUE("haAgentIssue");
    private final String value;

    HostCapabilityFtUnsupportedReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostCapabilityFtUnsupportedReason fromValue(String v) {
        for (HostCapabilityFtUnsupportedReason c: HostCapabilityFtUnsupportedReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
