
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDiskCompatibilityMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualDiskCompatibilityMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="virtualMode"/>
 *     &lt;enumeration value="physicalMode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualDiskCompatibilityMode")
@XmlEnum
public enum VirtualDiskCompatibilityMode {

    @XmlEnumValue("virtualMode")
    VIRTUAL_MODE("virtualMode"),
    @XmlEnumValue("physicalMode")
    PHYSICAL_MODE("physicalMode");
    private final String value;

    VirtualDiskCompatibilityMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualDiskCompatibilityMode fromValue(String v) {
        for (VirtualDiskCompatibilityMode c: VirtualDiskCompatibilityMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
