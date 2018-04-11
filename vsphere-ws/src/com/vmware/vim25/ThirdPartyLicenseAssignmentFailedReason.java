
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ThirdPartyLicenseAssignmentFailedReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ThirdPartyLicenseAssignmentFailedReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="licenseAssignmentFailed"/>
 *     &lt;enumeration value="moduleNotInstalled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ThirdPartyLicenseAssignmentFailedReason")
@XmlEnum
public enum ThirdPartyLicenseAssignmentFailedReason {

    @XmlEnumValue("licenseAssignmentFailed")
    LICENSE_ASSIGNMENT_FAILED("licenseAssignmentFailed"),
    @XmlEnumValue("moduleNotInstalled")
    MODULE_NOT_INSTALLED("moduleNotInstalled");
    private final String value;

    ThirdPartyLicenseAssignmentFailedReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ThirdPartyLicenseAssignmentFailedReason fromValue(String v) {
        for (ThirdPartyLicenseAssignmentFailedReason c: ThirdPartyLicenseAssignmentFailedReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
