
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReplicationDiskConfigFaultReasonForFault.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReplicationDiskConfigFaultReasonForFault">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="diskNotFound"/>
 *     &lt;enumeration value="diskTypeNotSupported"/>
 *     &lt;enumeration value="invalidDiskKey"/>
 *     &lt;enumeration value="invalidDiskReplicationId"/>
 *     &lt;enumeration value="duplicateDiskReplicationId"/>
 *     &lt;enumeration value="invalidPersistentFilePath"/>
 *     &lt;enumeration value="reconfigureDiskReplicationIdNotAllowed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReplicationDiskConfigFaultReasonForFault")
@XmlEnum
public enum ReplicationDiskConfigFaultReasonForFault {

    @XmlEnumValue("diskNotFound")
    DISK_NOT_FOUND("diskNotFound"),
    @XmlEnumValue("diskTypeNotSupported")
    DISK_TYPE_NOT_SUPPORTED("diskTypeNotSupported"),
    @XmlEnumValue("invalidDiskKey")
    INVALID_DISK_KEY("invalidDiskKey"),
    @XmlEnumValue("invalidDiskReplicationId")
    INVALID_DISK_REPLICATION_ID("invalidDiskReplicationId"),
    @XmlEnumValue("duplicateDiskReplicationId")
    DUPLICATE_DISK_REPLICATION_ID("duplicateDiskReplicationId"),
    @XmlEnumValue("invalidPersistentFilePath")
    INVALID_PERSISTENT_FILE_PATH("invalidPersistentFilePath"),
    @XmlEnumValue("reconfigureDiskReplicationIdNotAllowed")
    RECONFIGURE_DISK_REPLICATION_ID_NOT_ALLOWED("reconfigureDiskReplicationIdNotAllowed");
    private final String value;

    ReplicationDiskConfigFaultReasonForFault(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReplicationDiskConfigFaultReasonForFault fromValue(String v) {
        for (ReplicationDiskConfigFaultReasonForFault c: ReplicationDiskConfigFaultReasonForFault.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
