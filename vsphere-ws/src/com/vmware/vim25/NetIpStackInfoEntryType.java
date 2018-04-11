
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetIpStackInfoEntryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NetIpStackInfoEntryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="invalid"/>
 *     &lt;enumeration value="dynamic"/>
 *     &lt;enumeration value="manual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NetIpStackInfoEntryType")
@XmlEnum
public enum NetIpStackInfoEntryType {

    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("invalid")
    INVALID("invalid"),
    @XmlEnumValue("dynamic")
    DYNAMIC("dynamic"),
    @XmlEnumValue("manual")
    MANUAL("manual");
    private final String value;

    NetIpStackInfoEntryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NetIpStackInfoEntryType fromValue(String v) {
        for (NetIpStackInfoEntryType c: NetIpStackInfoEntryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
