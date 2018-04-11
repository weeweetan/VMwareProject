
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostPatchManagerReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostPatchManagerReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="obsoleted"/>
 *     &lt;enumeration value="missingPatch"/>
 *     &lt;enumeration value="missingLib"/>
 *     &lt;enumeration value="hasDependentPatch"/>
 *     &lt;enumeration value="conflictPatch"/>
 *     &lt;enumeration value="conflictLib"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostPatchManagerReason")
@XmlEnum
public enum HostPatchManagerReason {

    @XmlEnumValue("obsoleted")
    OBSOLETED("obsoleted"),
    @XmlEnumValue("missingPatch")
    MISSING_PATCH("missingPatch"),
    @XmlEnumValue("missingLib")
    MISSING_LIB("missingLib"),
    @XmlEnumValue("hasDependentPatch")
    HAS_DEPENDENT_PATCH("hasDependentPatch"),
    @XmlEnumValue("conflictPatch")
    CONFLICT_PATCH("conflictPatch"),
    @XmlEnumValue("conflictLib")
    CONFLICT_LIB("conflictLib");
    private final String value;

    HostPatchManagerReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostPatchManagerReason fromValue(String v) {
        for (HostPatchManagerReason c: HostPatchManagerReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
