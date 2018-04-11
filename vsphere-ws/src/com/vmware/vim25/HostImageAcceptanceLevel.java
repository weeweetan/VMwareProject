
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostImageAcceptanceLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostImageAcceptanceLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="vmware_certified"/>
 *     &lt;enumeration value="vmware_accepted"/>
 *     &lt;enumeration value="partner"/>
 *     &lt;enumeration value="community"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostImageAcceptanceLevel")
@XmlEnum
public enum HostImageAcceptanceLevel {

    @XmlEnumValue("vmware_certified")
    VMWARE_CERTIFIED("vmware_certified"),
    @XmlEnumValue("vmware_accepted")
    VMWARE_ACCEPTED("vmware_accepted"),
    @XmlEnumValue("partner")
    PARTNER("partner"),
    @XmlEnumValue("community")
    COMMUNITY("community");
    private final String value;

    HostImageAcceptanceLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostImageAcceptanceLevel fromValue(String v) {
        for (HostImageAcceptanceLevel c: HostImageAcceptanceLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
