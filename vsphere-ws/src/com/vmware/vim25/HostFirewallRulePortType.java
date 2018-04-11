
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFirewallRulePortType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostFirewallRulePortType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="src"/>
 *     &lt;enumeration value="dst"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostFirewallRulePortType")
@XmlEnum
public enum HostFirewallRulePortType {

    @XmlEnumValue("src")
    SRC("src"),
    @XmlEnumValue("dst")
    DST("dst");
    private final String value;

    HostFirewallRulePortType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostFirewallRulePortType fromValue(String v) {
        for (HostFirewallRulePortType c: HostFirewallRulePortType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
