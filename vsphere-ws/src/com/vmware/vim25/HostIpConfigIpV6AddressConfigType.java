
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostIpConfigIpV6AddressConfigType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostIpConfigIpV6AddressConfigType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="manual"/>
 *     &lt;enumeration value="dhcp"/>
 *     &lt;enumeration value="linklayer"/>
 *     &lt;enumeration value="random"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostIpConfigIpV6AddressConfigType")
@XmlEnum
public enum HostIpConfigIpV6AddressConfigType {

    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("manual")
    MANUAL("manual"),
    @XmlEnumValue("dhcp")
    DHCP("dhcp"),
    @XmlEnumValue("linklayer")
    LINKLAYER("linklayer"),
    @XmlEnumValue("random")
    RANDOM("random");
    private final String value;

    HostIpConfigIpV6AddressConfigType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostIpConfigIpV6AddressConfigType fromValue(String v) {
        for (HostIpConfigIpV6AddressConfigType c: HostIpConfigIpV6AddressConfigType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
