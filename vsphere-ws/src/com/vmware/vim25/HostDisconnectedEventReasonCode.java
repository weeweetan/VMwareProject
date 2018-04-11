
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDisconnectedEventReasonCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostDisconnectedEventReasonCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="sslThumbprintVerifyFailed"/>
 *     &lt;enumeration value="licenseExpired"/>
 *     &lt;enumeration value="agentUpgrade"/>
 *     &lt;enumeration value="userRequest"/>
 *     &lt;enumeration value="insufficientLicenses"/>
 *     &lt;enumeration value="agentOutOfDate"/>
 *     &lt;enumeration value="passwordDecryptFailure"/>
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="vcVRAMCapacityExceeded"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostDisconnectedEventReasonCode")
@XmlEnum
public enum HostDisconnectedEventReasonCode {

    @XmlEnumValue("sslThumbprintVerifyFailed")
    SSL_THUMBPRINT_VERIFY_FAILED("sslThumbprintVerifyFailed"),
    @XmlEnumValue("licenseExpired")
    LICENSE_EXPIRED("licenseExpired"),
    @XmlEnumValue("agentUpgrade")
    AGENT_UPGRADE("agentUpgrade"),
    @XmlEnumValue("userRequest")
    USER_REQUEST("userRequest"),
    @XmlEnumValue("insufficientLicenses")
    INSUFFICIENT_LICENSES("insufficientLicenses"),
    @XmlEnumValue("agentOutOfDate")
    AGENT_OUT_OF_DATE("agentOutOfDate"),
    @XmlEnumValue("passwordDecryptFailure")
    PASSWORD_DECRYPT_FAILURE("passwordDecryptFailure"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),
    @XmlEnumValue("vcVRAMCapacityExceeded")
    VC_VRAM_CAPACITY_EXCEEDED("vcVRAMCapacityExceeded");
    private final String value;

    HostDisconnectedEventReasonCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostDisconnectedEventReasonCode fromValue(String v) {
        for (HostDisconnectedEventReasonCode c: HostDisconnectedEventReasonCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
