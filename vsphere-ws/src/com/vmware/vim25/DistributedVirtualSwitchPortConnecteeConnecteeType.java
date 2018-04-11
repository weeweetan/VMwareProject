
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistributedVirtualSwitchPortConnecteeConnecteeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DistributedVirtualSwitchPortConnecteeConnecteeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="pnic"/>
 *     &lt;enumeration value="vmVnic"/>
 *     &lt;enumeration value="hostConsoleVnic"/>
 *     &lt;enumeration value="hostVmkVnic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DistributedVirtualSwitchPortConnecteeConnecteeType")
@XmlEnum
public enum DistributedVirtualSwitchPortConnecteeConnecteeType {

    @XmlEnumValue("pnic")
    PNIC("pnic"),
    @XmlEnumValue("vmVnic")
    VM_VNIC("vmVnic"),
    @XmlEnumValue("hostConsoleVnic")
    HOST_CONSOLE_VNIC("hostConsoleVnic"),
    @XmlEnumValue("hostVmkVnic")
    HOST_VMK_VNIC("hostVmkVnic");
    private final String value;

    DistributedVirtualSwitchPortConnecteeConnecteeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DistributedVirtualSwitchPortConnecteeConnecteeType fromValue(String v) {
        for (DistributedVirtualSwitchPortConnecteeConnecteeType c: DistributedVirtualSwitchPortConnecteeConnecteeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
