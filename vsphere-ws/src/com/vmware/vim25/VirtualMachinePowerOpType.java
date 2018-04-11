
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachinePowerOpType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachinePowerOpType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="soft"/>
 *     &lt;enumeration value="hard"/>
 *     &lt;enumeration value="preset"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachinePowerOpType")
@XmlEnum
public enum VirtualMachinePowerOpType {

    @XmlEnumValue("soft")
    SOFT("soft"),
    @XmlEnumValue("hard")
    HARD("hard"),
    @XmlEnumValue("preset")
    PRESET("preset");
    private final String value;

    VirtualMachinePowerOpType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachinePowerOpType fromValue(String v) {
        for (VirtualMachinePowerOpType c: VirtualMachinePowerOpType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
