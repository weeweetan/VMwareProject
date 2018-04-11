
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestOsDescriptorSupportLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GuestOsDescriptorSupportLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="experimental"/>
 *     &lt;enumeration value="legacy"/>
 *     &lt;enumeration value="terminated"/>
 *     &lt;enumeration value="supported"/>
 *     &lt;enumeration value="unsupported"/>
 *     &lt;enumeration value="deprecated"/>
 *     &lt;enumeration value="techPreview"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GuestOsDescriptorSupportLevel")
@XmlEnum
public enum GuestOsDescriptorSupportLevel {

    @XmlEnumValue("experimental")
    EXPERIMENTAL("experimental"),
    @XmlEnumValue("legacy")
    LEGACY("legacy"),
    @XmlEnumValue("terminated")
    TERMINATED("terminated"),
    @XmlEnumValue("supported")
    SUPPORTED("supported"),
    @XmlEnumValue("unsupported")
    UNSUPPORTED("unsupported"),
    @XmlEnumValue("deprecated")
    DEPRECATED("deprecated"),
    @XmlEnumValue("techPreview")
    TECH_PREVIEW("techPreview");
    private final String value;

    GuestOsDescriptorSupportLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GuestOsDescriptorSupportLevel fromValue(String v) {
        for (GuestOsDescriptorSupportLevel c: GuestOsDescriptorSupportLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
