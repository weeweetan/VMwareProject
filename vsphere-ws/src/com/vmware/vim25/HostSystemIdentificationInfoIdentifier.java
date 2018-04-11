
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostSystemIdentificationInfoIdentifier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostSystemIdentificationInfoIdentifier">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AssetTag"/>
 *     &lt;enumeration value="ServiceTag"/>
 *     &lt;enumeration value="OemSpecificString"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostSystemIdentificationInfoIdentifier")
@XmlEnum
public enum HostSystemIdentificationInfoIdentifier {

    @XmlEnumValue("AssetTag")
    ASSET_TAG("AssetTag"),
    @XmlEnumValue("ServiceTag")
    SERVICE_TAG("ServiceTag"),
    @XmlEnumValue("OemSpecificString")
    OEM_SPECIFIC_STRING("OemSpecificString");
    private final String value;

    HostSystemIdentificationInfoIdentifier(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostSystemIdentificationInfoIdentifier fromValue(String v) {
        for (HostSystemIdentificationInfoIdentifier c: HostSystemIdentificationInfoIdentifier.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
