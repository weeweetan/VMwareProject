
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LinkDiscoveryProtocolConfigOperationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LinkDiscoveryProtocolConfigOperationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="listen"/>
 *     &lt;enumeration value="advertise"/>
 *     &lt;enumeration value="both"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LinkDiscoveryProtocolConfigOperationType")
@XmlEnum
public enum LinkDiscoveryProtocolConfigOperationType {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("listen")
    LISTEN("listen"),
    @XmlEnumValue("advertise")
    ADVERTISE("advertise"),
    @XmlEnumValue("both")
    BOTH("both");
    private final String value;

    LinkDiscoveryProtocolConfigOperationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LinkDiscoveryProtocolConfigOperationType fromValue(String v) {
        for (LinkDiscoveryProtocolConfigOperationType c: LinkDiscoveryProtocolConfigOperationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
