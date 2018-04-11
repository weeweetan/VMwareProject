
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistributedVirtualSwitchHostMemberHostComponentState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DistributedVirtualSwitchHostMemberHostComponentState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="up"/>
 *     &lt;enumeration value="pending"/>
 *     &lt;enumeration value="outOfSync"/>
 *     &lt;enumeration value="warning"/>
 *     &lt;enumeration value="disconnected"/>
 *     &lt;enumeration value="down"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DistributedVirtualSwitchHostMemberHostComponentState")
@XmlEnum
public enum DistributedVirtualSwitchHostMemberHostComponentState {

    @XmlEnumValue("up")
    UP("up"),
    @XmlEnumValue("pending")
    PENDING("pending"),
    @XmlEnumValue("outOfSync")
    OUT_OF_SYNC("outOfSync"),
    @XmlEnumValue("warning")
    WARNING("warning"),
    @XmlEnumValue("disconnected")
    DISCONNECTED("disconnected"),
    @XmlEnumValue("down")
    DOWN("down");
    private final String value;

    DistributedVirtualSwitchHostMemberHostComponentState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DistributedVirtualSwitchHostMemberHostComponentState fromValue(String v) {
        for (DistributedVirtualSwitchHostMemberHostComponentState c: DistributedVirtualSwitchHostMemberHostComponentState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
