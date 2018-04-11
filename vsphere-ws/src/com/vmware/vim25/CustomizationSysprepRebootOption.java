
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationSysprepRebootOption.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomizationSysprepRebootOption">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="reboot"/>
 *     &lt;enumeration value="noreboot"/>
 *     &lt;enumeration value="shutdown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomizationSysprepRebootOption")
@XmlEnum
public enum CustomizationSysprepRebootOption {

    @XmlEnumValue("reboot")
    REBOOT("reboot"),
    @XmlEnumValue("noreboot")
    NOREBOOT("noreboot"),
    @XmlEnumValue("shutdown")
    SHUTDOWN("shutdown");
    private final String value;

    CustomizationSysprepRebootOption(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CustomizationSysprepRebootOption fromValue(String v) {
        for (CustomizationSysprepRebootOption c: CustomizationSysprepRebootOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
