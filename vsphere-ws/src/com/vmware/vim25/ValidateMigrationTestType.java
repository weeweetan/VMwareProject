
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidateMigrationTestType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ValidateMigrationTestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="sourceTests"/>
 *     &lt;enumeration value="compatibilityTests"/>
 *     &lt;enumeration value="diskAccessibilityTests"/>
 *     &lt;enumeration value="resourceTests"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ValidateMigrationTestType")
@XmlEnum
public enum ValidateMigrationTestType {

    @XmlEnumValue("sourceTests")
    SOURCE_TESTS("sourceTests"),
    @XmlEnumValue("compatibilityTests")
    COMPATIBILITY_TESTS("compatibilityTests"),
    @XmlEnumValue("diskAccessibilityTests")
    DISK_ACCESSIBILITY_TESTS("diskAccessibilityTests"),
    @XmlEnumValue("resourceTests")
    RESOURCE_TESTS("resourceTests");
    private final String value;

    ValidateMigrationTestType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValidateMigrationTestType fromValue(String v) {
        for (ValidateMigrationTestType c: ValidateMigrationTestType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
