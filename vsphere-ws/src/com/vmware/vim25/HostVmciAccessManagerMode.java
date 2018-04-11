
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostVmciAccessManagerMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostVmciAccessManagerMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="grant"/>
 *     &lt;enumeration value="replace"/>
 *     &lt;enumeration value="revoke"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostVmciAccessManagerMode")
@XmlEnum
public enum HostVmciAccessManagerMode {

    @XmlEnumValue("grant")
    GRANT("grant"),
    @XmlEnumValue("replace")
    REPLACE("replace"),
    @XmlEnumValue("revoke")
    REVOKE("revoke");
    private final String value;

    HostVmciAccessManagerMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostVmciAccessManagerMode fromValue(String v) {
        for (HostVmciAccessManagerMode c: HostVmciAccessManagerMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
