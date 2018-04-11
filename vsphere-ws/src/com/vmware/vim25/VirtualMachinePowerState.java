
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachinePowerState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachinePowerState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="poweredOff"/>
 *     &lt;enumeration value="poweredOn"/>
 *     &lt;enumeration value="suspended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachinePowerState")
@XmlEnum
public enum VirtualMachinePowerState {

    @XmlEnumValue("poweredOff")
    POWERED_OFF("poweredOff"),
    @XmlEnumValue("poweredOn")
    POWERED_ON("poweredOn"),
    @XmlEnumValue("suspended")
    SUSPENDED("suspended");
    private final String value;

    VirtualMachinePowerState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachinePowerState fromValue(String v) {
        for (VirtualMachinePowerState c: VirtualMachinePowerState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
