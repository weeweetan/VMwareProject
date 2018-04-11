
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostUnresolvedVmfsResolutionSpecVmfsUuidResolution.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostUnresolvedVmfsResolutionSpecVmfsUuidResolution">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="resignature"/>
 *     &lt;enumeration value="forceMount"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostUnresolvedVmfsResolutionSpecVmfsUuidResolution")
@XmlEnum
public enum HostUnresolvedVmfsResolutionSpecVmfsUuidResolution {

    @XmlEnumValue("resignature")
    RESIGNATURE("resignature"),
    @XmlEnumValue("forceMount")
    FORCE_MOUNT("forceMount");
    private final String value;

    HostUnresolvedVmfsResolutionSpecVmfsUuidResolution(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostUnresolvedVmfsResolutionSpecVmfsUuidResolution fromValue(String v) {
        for (HostUnresolvedVmfsResolutionSpecVmfsUuidResolution c: HostUnresolvedVmfsResolutionSpecVmfsUuidResolution.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
