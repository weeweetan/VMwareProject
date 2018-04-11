
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDiskDeltaDiskFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualDiskDeltaDiskFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="redoLogFormat"/>
 *     &lt;enumeration value="nativeFormat"/>
 *     &lt;enumeration value="seSparseFormat"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualDiskDeltaDiskFormat")
@XmlEnum
public enum VirtualDiskDeltaDiskFormat {

    @XmlEnumValue("redoLogFormat")
    REDO_LOG_FORMAT("redoLogFormat"),
    @XmlEnumValue("nativeFormat")
    NATIVE_FORMAT("nativeFormat"),
    @XmlEnumValue("seSparseFormat")
    SE_SPARSE_FORMAT("seSparseFormat");
    private final String value;

    VirtualDiskDeltaDiskFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualDiskDeltaDiskFormat fromValue(String v) {
        for (VirtualDiskDeltaDiskFormat c: VirtualDiskDeltaDiskFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
