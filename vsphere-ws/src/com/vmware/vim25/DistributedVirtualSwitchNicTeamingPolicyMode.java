
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistributedVirtualSwitchNicTeamingPolicyMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DistributedVirtualSwitchNicTeamingPolicyMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="loadbalance_ip"/>
 *     &lt;enumeration value="loadbalance_srcmac"/>
 *     &lt;enumeration value="loadbalance_srcid"/>
 *     &lt;enumeration value="failover_explicit"/>
 *     &lt;enumeration value="loadbalance_loadbased"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DistributedVirtualSwitchNicTeamingPolicyMode")
@XmlEnum
public enum DistributedVirtualSwitchNicTeamingPolicyMode {

    @XmlEnumValue("loadbalance_ip")
    LOADBALANCE_IP("loadbalance_ip"),
    @XmlEnumValue("loadbalance_srcmac")
    LOADBALANCE_SRCMAC("loadbalance_srcmac"),
    @XmlEnumValue("loadbalance_srcid")
    LOADBALANCE_SRCID("loadbalance_srcid"),
    @XmlEnumValue("failover_explicit")
    FAILOVER_EXPLICIT("failover_explicit"),
    @XmlEnumValue("loadbalance_loadbased")
    LOADBALANCE_LOADBASED("loadbalance_loadbased");
    private final String value;

    DistributedVirtualSwitchNicTeamingPolicyMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DistributedVirtualSwitchNicTeamingPolicyMode fromValue(String v) {
        for (DistributedVirtualSwitchNicTeamingPolicyMode c: DistributedVirtualSwitchNicTeamingPolicyMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
