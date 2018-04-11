
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhysicalNicVmDirectPathGen2SupportedMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PhysicalNicVmDirectPathGen2SupportedMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="upt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PhysicalNicVmDirectPathGen2SupportedMode")
@XmlEnum
public enum PhysicalNicVmDirectPathGen2SupportedMode {

    @XmlEnumValue("upt")
    UPT("upt");
    private final String value;

    PhysicalNicVmDirectPathGen2SupportedMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PhysicalNicVmDirectPathGen2SupportedMode fromValue(String v) {
        for (PhysicalNicVmDirectPathGen2SupportedMode c: PhysicalNicVmDirectPathGen2SupportedMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
