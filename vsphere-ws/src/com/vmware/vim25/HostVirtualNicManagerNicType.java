
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostVirtualNicManagerNicType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostVirtualNicManagerNicType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="vmotion"/>
 *     &lt;enumeration value="faultToleranceLogging"/>
 *     &lt;enumeration value="vSphereReplication"/>
 *     &lt;enumeration value="management"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostVirtualNicManagerNicType")
@XmlEnum
public enum HostVirtualNicManagerNicType {

    @XmlEnumValue("vmotion")
    VMOTION("vmotion"),
    @XmlEnumValue("faultToleranceLogging")
    FAULT_TOLERANCE_LOGGING("faultToleranceLogging"),
    @XmlEnumValue("vSphereReplication")
    V_SPHERE_REPLICATION("vSphereReplication"),
    @XmlEnumValue("management")
    MANAGEMENT("management");
    private final String value;

    HostVirtualNicManagerNicType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostVirtualNicManagerNicType fromValue(String v) {
        for (HostVirtualNicManagerNicType c: HostVirtualNicManagerNicType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
