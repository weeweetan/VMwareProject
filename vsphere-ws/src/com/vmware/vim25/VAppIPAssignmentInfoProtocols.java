
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VAppIPAssignmentInfoProtocols.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VAppIPAssignmentInfoProtocols">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IPv4"/>
 *     &lt;enumeration value="IPv6"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VAppIPAssignmentInfoProtocols")
@XmlEnum
public enum VAppIPAssignmentInfoProtocols {

    @XmlEnumValue("IPv4")
    I_PV_4("IPv4"),
    @XmlEnumValue("IPv6")
    I_PV_6("IPv6");
    private final String value;

    VAppIPAssignmentInfoProtocols(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VAppIPAssignmentInfoProtocols fromValue(String v) {
        for (VAppIPAssignmentInfoProtocols c: VAppIPAssignmentInfoProtocols.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
