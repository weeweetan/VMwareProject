
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostIpConfigIpV6AddressStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostIpConfigIpV6AddressStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="preferred"/>
 *     &lt;enumeration value="deprecated"/>
 *     &lt;enumeration value="invalid"/>
 *     &lt;enumeration value="inaccessible"/>
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="tentative"/>
 *     &lt;enumeration value="duplicate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostIpConfigIpV6AddressStatus")
@XmlEnum
public enum HostIpConfigIpV6AddressStatus {

    @XmlEnumValue("preferred")
    PREFERRED("preferred"),
    @XmlEnumValue("deprecated")
    DEPRECATED("deprecated"),
    @XmlEnumValue("invalid")
    INVALID("invalid"),
    @XmlEnumValue("inaccessible")
    INACCESSIBLE("inaccessible"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),
    @XmlEnumValue("tentative")
    TENTATIVE("tentative"),
    @XmlEnumValue("duplicate")
    DUPLICATE("duplicate");
    private final String value;

    HostIpConfigIpV6AddressStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostIpConfigIpV6AddressStatus fromValue(String v) {
        for (HostIpConfigIpV6AddressStatus c: HostIpConfigIpV6AddressStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
