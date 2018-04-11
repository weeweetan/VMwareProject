
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetBIOSConfigInfoMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NetBIOSConfigInfoMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="enabled"/>
 *     &lt;enumeration value="disabled"/>
 *     &lt;enumeration value="enabledViaDHCP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NetBIOSConfigInfoMode")
@XmlEnum
public enum NetBIOSConfigInfoMode {

    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),
    @XmlEnumValue("enabled")
    ENABLED("enabled"),
    @XmlEnumValue("disabled")
    DISABLED("disabled"),
    @XmlEnumValue("enabledViaDHCP")
    ENABLED_VIA_DHCP("enabledViaDHCP");
    private final String value;

    NetBIOSConfigInfoMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NetBIOSConfigInfoMode fromValue(String v) {
        for (NetBIOSConfigInfoMode c: NetBIOSConfigInfoMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
