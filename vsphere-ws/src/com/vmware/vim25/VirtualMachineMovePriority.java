
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineMovePriority.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineMovePriority">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="lowPriority"/>
 *     &lt;enumeration value="highPriority"/>
 *     &lt;enumeration value="defaultPriority"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineMovePriority")
@XmlEnum
public enum VirtualMachineMovePriority {

    @XmlEnumValue("lowPriority")
    LOW_PRIORITY("lowPriority"),
    @XmlEnumValue("highPriority")
    HIGH_PRIORITY("highPriority"),
    @XmlEnumValue("defaultPriority")
    DEFAULT_PRIORITY("defaultPriority");
    private final String value;

    VirtualMachineMovePriority(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineMovePriority fromValue(String v) {
        for (VirtualMachineMovePriority c: VirtualMachineMovePriority.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
