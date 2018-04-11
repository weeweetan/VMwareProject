
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LicenseFeatureInfoSourceRestriction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LicenseFeatureInfoSourceRestriction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unrestricted"/>
 *     &lt;enumeration value="served"/>
 *     &lt;enumeration value="file"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LicenseFeatureInfoSourceRestriction")
@XmlEnum
public enum LicenseFeatureInfoSourceRestriction {

    @XmlEnumValue("unrestricted")
    UNRESTRICTED("unrestricted"),
    @XmlEnumValue("served")
    SERVED("served"),
    @XmlEnumValue("file")
    FILE("file");
    private final String value;

    LicenseFeatureInfoSourceRestriction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LicenseFeatureInfoSourceRestriction fromValue(String v) {
        for (LicenseFeatureInfoSourceRestriction c: LicenseFeatureInfoSourceRestriction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
