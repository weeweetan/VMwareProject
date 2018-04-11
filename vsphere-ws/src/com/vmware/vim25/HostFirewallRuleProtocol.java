
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFirewallRuleProtocol.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostFirewallRuleProtocol">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="tcp"/>
 *     &lt;enumeration value="udp"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostFirewallRuleProtocol")
@XmlEnum
public enum HostFirewallRuleProtocol {

    @XmlEnumValue("tcp")
    TCP("tcp"),
    @XmlEnumValue("udp")
    UDP("udp");
    private final String value;

    HostFirewallRuleProtocol(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostFirewallRuleProtocol fromValue(String v) {
        for (HostFirewallRuleProtocol c: HostFirewallRuleProtocol.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
