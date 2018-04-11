
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDiskPartitionInfoType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostDiskPartitionInfoType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="vmfs"/>
 *     &lt;enumeration value="linuxNative"/>
 *     &lt;enumeration value="linuxSwap"/>
 *     &lt;enumeration value="extended"/>
 *     &lt;enumeration value="ntfs"/>
 *     &lt;enumeration value="vmkDiagnostic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostDiskPartitionInfoType")
@XmlEnum
public enum HostDiskPartitionInfoType {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("vmfs")
    VMFS("vmfs"),
    @XmlEnumValue("linuxNative")
    LINUX_NATIVE("linuxNative"),
    @XmlEnumValue("linuxSwap")
    LINUX_SWAP("linuxSwap"),
    @XmlEnumValue("extended")
    EXTENDED("extended"),
    @XmlEnumValue("ntfs")
    NTFS("ntfs"),
    @XmlEnumValue("vmkDiagnostic")
    VMK_DIAGNOSTIC("vmkDiagnostic");
    private final String value;

    HostDiskPartitionInfoType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostDiskPartitionInfoType fromValue(String v) {
        for (HostDiskPartitionInfoType c: HostDiskPartitionInfoType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
