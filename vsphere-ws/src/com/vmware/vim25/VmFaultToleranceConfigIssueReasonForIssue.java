
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmFaultToleranceConfigIssueReasonForIssue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VmFaultToleranceConfigIssueReasonForIssue">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="haNotEnabled"/>
 *     &lt;enumeration value="moreThanOneSecondary"/>
 *     &lt;enumeration value="recordReplayNotSupported"/>
 *     &lt;enumeration value="replayNotSupported"/>
 *     &lt;enumeration value="templateVm"/>
 *     &lt;enumeration value="multipleVCPU"/>
 *     &lt;enumeration value="hostInactive"/>
 *     &lt;enumeration value="ftUnsupportedHardware"/>
 *     &lt;enumeration value="ftUnsupportedProduct"/>
 *     &lt;enumeration value="missingVMotionNic"/>
 *     &lt;enumeration value="missingFTLoggingNic"/>
 *     &lt;enumeration value="thinDisk"/>
 *     &lt;enumeration value="verifySSLCertificateFlagNotSet"/>
 *     &lt;enumeration value="hasSnapshots"/>
 *     &lt;enumeration value="noConfig"/>
 *     &lt;enumeration value="ftSecondaryVm"/>
 *     &lt;enumeration value="hasLocalDisk"/>
 *     &lt;enumeration value="esxAgentVm"/>
 *     &lt;enumeration value="video3dEnabled"/>
 *     &lt;enumeration value="hasUnsupportedDisk"/>
 *     &lt;enumeration value="hasNestedHVConfiguration"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VmFaultToleranceConfigIssueReasonForIssue")
@XmlEnum
public enum VmFaultToleranceConfigIssueReasonForIssue {

    @XmlEnumValue("haNotEnabled")
    HA_NOT_ENABLED("haNotEnabled"),
    @XmlEnumValue("moreThanOneSecondary")
    MORE_THAN_ONE_SECONDARY("moreThanOneSecondary"),
    @XmlEnumValue("recordReplayNotSupported")
    RECORD_REPLAY_NOT_SUPPORTED("recordReplayNotSupported"),
    @XmlEnumValue("replayNotSupported")
    REPLAY_NOT_SUPPORTED("replayNotSupported"),
    @XmlEnumValue("templateVm")
    TEMPLATE_VM("templateVm"),
    @XmlEnumValue("multipleVCPU")
    MULTIPLE_VCPU("multipleVCPU"),
    @XmlEnumValue("hostInactive")
    HOST_INACTIVE("hostInactive"),
    @XmlEnumValue("ftUnsupportedHardware")
    FT_UNSUPPORTED_HARDWARE("ftUnsupportedHardware"),
    @XmlEnumValue("ftUnsupportedProduct")
    FT_UNSUPPORTED_PRODUCT("ftUnsupportedProduct"),
    @XmlEnumValue("missingVMotionNic")
    MISSING_V_MOTION_NIC("missingVMotionNic"),
    @XmlEnumValue("missingFTLoggingNic")
    MISSING_FT_LOGGING_NIC("missingFTLoggingNic"),
    @XmlEnumValue("thinDisk")
    THIN_DISK("thinDisk"),
    @XmlEnumValue("verifySSLCertificateFlagNotSet")
    VERIFY_SSL_CERTIFICATE_FLAG_NOT_SET("verifySSLCertificateFlagNotSet"),
    @XmlEnumValue("hasSnapshots")
    HAS_SNAPSHOTS("hasSnapshots"),
    @XmlEnumValue("noConfig")
    NO_CONFIG("noConfig"),
    @XmlEnumValue("ftSecondaryVm")
    FT_SECONDARY_VM("ftSecondaryVm"),
    @XmlEnumValue("hasLocalDisk")
    HAS_LOCAL_DISK("hasLocalDisk"),
    @XmlEnumValue("esxAgentVm")
    ESX_AGENT_VM("esxAgentVm"),
    @XmlEnumValue("video3dEnabled")
    VIDEO_3_D_ENABLED("video3dEnabled"),
    @XmlEnumValue("hasUnsupportedDisk")
    HAS_UNSUPPORTED_DISK("hasUnsupportedDisk"),
    @XmlEnumValue("hasNestedHVConfiguration")
    HAS_NESTED_HV_CONFIGURATION("hasNestedHVConfiguration");
    private final String value;

    VmFaultToleranceConfigIssueReasonForIssue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VmFaultToleranceConfigIssueReasonForIssue fromValue(String v) {
        for (VmFaultToleranceConfigIssueReasonForIssue c: VmFaultToleranceConfigIssueReasonForIssue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
