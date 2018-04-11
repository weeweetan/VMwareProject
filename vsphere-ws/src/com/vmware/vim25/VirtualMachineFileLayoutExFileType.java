
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineFileLayoutExFileType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineFileLayoutExFileType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="config"/>
 *     &lt;enumeration value="extendedConfig"/>
 *     &lt;enumeration value="diskDescriptor"/>
 *     &lt;enumeration value="diskExtent"/>
 *     &lt;enumeration value="digestDescriptor"/>
 *     &lt;enumeration value="digestExtent"/>
 *     &lt;enumeration value="diskReplicationState"/>
 *     &lt;enumeration value="log"/>
 *     &lt;enumeration value="stat"/>
 *     &lt;enumeration value="namespaceData"/>
 *     &lt;enumeration value="nvram"/>
 *     &lt;enumeration value="snapshotData"/>
 *     &lt;enumeration value="snapshotList"/>
 *     &lt;enumeration value="snapshotManifestList"/>
 *     &lt;enumeration value="suspend"/>
 *     &lt;enumeration value="swap"/>
 *     &lt;enumeration value="uwswap"/>
 *     &lt;enumeration value="core"/>
 *     &lt;enumeration value="screenshot"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineFileLayoutExFileType")
@XmlEnum
public enum VirtualMachineFileLayoutExFileType {

    @XmlEnumValue("config")
    CONFIG("config"),
    @XmlEnumValue("extendedConfig")
    EXTENDED_CONFIG("extendedConfig"),
    @XmlEnumValue("diskDescriptor")
    DISK_DESCRIPTOR("diskDescriptor"),
    @XmlEnumValue("diskExtent")
    DISK_EXTENT("diskExtent"),
    @XmlEnumValue("digestDescriptor")
    DIGEST_DESCRIPTOR("digestDescriptor"),
    @XmlEnumValue("digestExtent")
    DIGEST_EXTENT("digestExtent"),
    @XmlEnumValue("diskReplicationState")
    DISK_REPLICATION_STATE("diskReplicationState"),
    @XmlEnumValue("log")
    LOG("log"),
    @XmlEnumValue("stat")
    STAT("stat"),
    @XmlEnumValue("namespaceData")
    NAMESPACE_DATA("namespaceData"),
    @XmlEnumValue("nvram")
    NVRAM("nvram"),
    @XmlEnumValue("snapshotData")
    SNAPSHOT_DATA("snapshotData"),
    @XmlEnumValue("snapshotList")
    SNAPSHOT_LIST("snapshotList"),
    @XmlEnumValue("snapshotManifestList")
    SNAPSHOT_MANIFEST_LIST("snapshotManifestList"),
    @XmlEnumValue("suspend")
    SUSPEND("suspend"),
    @XmlEnumValue("swap")
    SWAP("swap"),
    @XmlEnumValue("uwswap")
    UWSWAP("uwswap"),
    @XmlEnumValue("core")
    CORE("core"),
    @XmlEnumValue("screenshot")
    SCREENSHOT("screenshot");
    private final String value;

    VirtualMachineFileLayoutExFileType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineFileLayoutExFileType fromValue(String v) {
        for (VirtualMachineFileLayoutExFileType c: VirtualMachineFileLayoutExFileType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
