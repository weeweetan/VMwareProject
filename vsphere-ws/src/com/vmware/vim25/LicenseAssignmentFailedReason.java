
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LicenseAssignmentFailedReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LicenseAssignmentFailedReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="keyEntityMismatch"/>
 *     &lt;enumeration value="downgradeDisallowed"/>
 *     &lt;enumeration value="inventoryNotManageableByVirtualCenter"/>
 *     &lt;enumeration value="hostsUnmanageableByVirtualCenterWithoutLicenseServer"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LicenseAssignmentFailedReason")
@XmlEnum
public enum LicenseAssignmentFailedReason {

    @XmlEnumValue("keyEntityMismatch")
    KEY_ENTITY_MISMATCH("keyEntityMismatch"),
    @XmlEnumValue("downgradeDisallowed")
    DOWNGRADE_DISALLOWED("downgradeDisallowed"),
    @XmlEnumValue("inventoryNotManageableByVirtualCenter")
    INVENTORY_NOT_MANAGEABLE_BY_VIRTUAL_CENTER("inventoryNotManageableByVirtualCenter"),
    @XmlEnumValue("hostsUnmanageableByVirtualCenterWithoutLicenseServer")
    HOSTS_UNMANAGEABLE_BY_VIRTUAL_CENTER_WITHOUT_LICENSE_SERVER("hostsUnmanageableByVirtualCenterWithoutLicenseServer");
    private final String value;

    LicenseAssignmentFailedReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LicenseAssignmentFailedReason fromValue(String v) {
        for (LicenseAssignmentFailedReason c: LicenseAssignmentFailedReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
