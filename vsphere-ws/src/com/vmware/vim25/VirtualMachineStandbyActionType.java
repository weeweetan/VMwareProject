
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineStandbyActionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineStandbyActionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="checkpoint"/>
 *     &lt;enumeration value="powerOnSuspend"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineStandbyActionType")
@XmlEnum
public enum VirtualMachineStandbyActionType {

    @XmlEnumValue("checkpoint")
    CHECKPOINT("checkpoint"),
    @XmlEnumValue("powerOnSuspend")
    POWER_ON_SUSPEND("powerOnSuspend");
    private final String value;

    VirtualMachineStandbyActionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineStandbyActionType fromValue(String v) {
        for (VirtualMachineStandbyActionType c: VirtualMachineStandbyActionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
