
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostUnresolvedVmfsExtentUnresolvedReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostUnresolvedVmfsExtentUnresolvedReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="diskIdMismatch"/>
 *     &lt;enumeration value="uuidConflict"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostUnresolvedVmfsExtentUnresolvedReason")
@XmlEnum
public enum HostUnresolvedVmfsExtentUnresolvedReason {

    @XmlEnumValue("diskIdMismatch")
    DISK_ID_MISMATCH("diskIdMismatch"),
    @XmlEnumValue("uuidConflict")
    UUID_CONFLICT("uuidConflict");
    private final String value;

    HostUnresolvedVmfsExtentUnresolvedReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostUnresolvedVmfsExtentUnresolvedReason fromValue(String v) {
        for (HostUnresolvedVmfsExtentUnresolvedReason c: HostUnresolvedVmfsExtentUnresolvedReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
