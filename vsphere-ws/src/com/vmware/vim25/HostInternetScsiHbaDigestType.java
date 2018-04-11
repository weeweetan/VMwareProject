
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostInternetScsiHbaDigestType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostInternetScsiHbaDigestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="digestProhibited"/>
 *     &lt;enumeration value="digestDiscouraged"/>
 *     &lt;enumeration value="digestPreferred"/>
 *     &lt;enumeration value="digestRequired"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostInternetScsiHbaDigestType")
@XmlEnum
public enum HostInternetScsiHbaDigestType {

    @XmlEnumValue("digestProhibited")
    DIGEST_PROHIBITED("digestProhibited"),
    @XmlEnumValue("digestDiscouraged")
    DIGEST_DISCOURAGED("digestDiscouraged"),
    @XmlEnumValue("digestPreferred")
    DIGEST_PREFERRED("digestPreferred"),
    @XmlEnumValue("digestRequired")
    DIGEST_REQUIRED("digestRequired");
    private final String value;

    HostInternetScsiHbaDigestType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostInternetScsiHbaDigestType fromValue(String v) {
        for (HostInternetScsiHbaDigestType c: HostInternetScsiHbaDigestType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
