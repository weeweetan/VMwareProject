
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostPatchManagerIntegrityStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostPatchManagerIntegrityStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="validated"/>
 *     &lt;enumeration value="keyNotFound"/>
 *     &lt;enumeration value="keyRevoked"/>
 *     &lt;enumeration value="keyExpired"/>
 *     &lt;enumeration value="digestMismatch"/>
 *     &lt;enumeration value="notEnoughSignatures"/>
 *     &lt;enumeration value="validationError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostPatchManagerIntegrityStatus")
@XmlEnum
public enum HostPatchManagerIntegrityStatus {

    @XmlEnumValue("validated")
    VALIDATED("validated"),
    @XmlEnumValue("keyNotFound")
    KEY_NOT_FOUND("keyNotFound"),
    @XmlEnumValue("keyRevoked")
    KEY_REVOKED("keyRevoked"),
    @XmlEnumValue("keyExpired")
    KEY_EXPIRED("keyExpired"),
    @XmlEnumValue("digestMismatch")
    DIGEST_MISMATCH("digestMismatch"),
    @XmlEnumValue("notEnoughSignatures")
    NOT_ENOUGH_SIGNATURES("notEnoughSignatures"),
    @XmlEnumValue("validationError")
    VALIDATION_ERROR("validationError");
    private final String value;

    HostPatchManagerIntegrityStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostPatchManagerIntegrityStatus fromValue(String v) {
        for (HostPatchManagerIntegrityStatus c: HostPatchManagerIntegrityStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
