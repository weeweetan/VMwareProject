
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineUsbInfoSpeed.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineUsbInfoSpeed">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="low"/>
 *     &lt;enumeration value="full"/>
 *     &lt;enumeration value="high"/>
 *     &lt;enumeration value="superSpeed"/>
 *     &lt;enumeration value="unknownSpeed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineUsbInfoSpeed")
@XmlEnum
public enum VirtualMachineUsbInfoSpeed {

    @XmlEnumValue("low")
    LOW("low"),
    @XmlEnumValue("full")
    FULL("full"),
    @XmlEnumValue("high")
    HIGH("high"),
    @XmlEnumValue("superSpeed")
    SUPER_SPEED("superSpeed"),
    @XmlEnumValue("unknownSpeed")
    UNKNOWN_SPEED("unknownSpeed");
    private final String value;

    VirtualMachineUsbInfoSpeed(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineUsbInfoSpeed fromValue(String v) {
        for (VirtualMachineUsbInfoSpeed c: VirtualMachineUsbInfoSpeed.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
