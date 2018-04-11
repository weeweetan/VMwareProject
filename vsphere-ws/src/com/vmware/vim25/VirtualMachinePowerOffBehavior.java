
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachinePowerOffBehavior.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachinePowerOffBehavior">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="powerOff"/>
 *     &lt;enumeration value="revert"/>
 *     &lt;enumeration value="prompt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachinePowerOffBehavior")
@XmlEnum
public enum VirtualMachinePowerOffBehavior {

    @XmlEnumValue("powerOff")
    POWER_OFF("powerOff"),
    @XmlEnumValue("revert")
    REVERT("revert"),
    @XmlEnumValue("prompt")
    PROMPT("prompt");
    private final String value;

    VirtualMachinePowerOffBehavior(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachinePowerOffBehavior fromValue(String v) {
        for (VirtualMachinePowerOffBehavior c: VirtualMachinePowerOffBehavior.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
