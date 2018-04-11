
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AgentInstallFailedReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AgentInstallFailedReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotEnoughSpaceOnDevice"/>
 *     &lt;enumeration value="PrepareToUpgradeFailed"/>
 *     &lt;enumeration value="AgentNotRunning"/>
 *     &lt;enumeration value="AgentNotReachable"/>
 *     &lt;enumeration value="InstallTimedout"/>
 *     &lt;enumeration value="SignatureVerificationFailed"/>
 *     &lt;enumeration value="AgentUploadFailed"/>
 *     &lt;enumeration value="AgentUploadTimedout"/>
 *     &lt;enumeration value="UnknownInstallerError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AgentInstallFailedReason")
@XmlEnum
public enum AgentInstallFailedReason {

    @XmlEnumValue("NotEnoughSpaceOnDevice")
    NOT_ENOUGH_SPACE_ON_DEVICE("NotEnoughSpaceOnDevice"),
    @XmlEnumValue("PrepareToUpgradeFailed")
    PREPARE_TO_UPGRADE_FAILED("PrepareToUpgradeFailed"),
    @XmlEnumValue("AgentNotRunning")
    AGENT_NOT_RUNNING("AgentNotRunning"),
    @XmlEnumValue("AgentNotReachable")
    AGENT_NOT_REACHABLE("AgentNotReachable"),
    @XmlEnumValue("InstallTimedout")
    INSTALL_TIMEDOUT("InstallTimedout"),
    @XmlEnumValue("SignatureVerificationFailed")
    SIGNATURE_VERIFICATION_FAILED("SignatureVerificationFailed"),
    @XmlEnumValue("AgentUploadFailed")
    AGENT_UPLOAD_FAILED("AgentUploadFailed"),
    @XmlEnumValue("AgentUploadTimedout")
    AGENT_UPLOAD_TIMEDOUT("AgentUploadTimedout"),
    @XmlEnumValue("UnknownInstallerError")
    UNKNOWN_INSTALLER_ERROR("UnknownInstallerError");
    private final String value;

    AgentInstallFailedReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AgentInstallFailedReason fromValue(String v) {
        for (AgentInstallFailedReason c: AgentInstallFailedReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
