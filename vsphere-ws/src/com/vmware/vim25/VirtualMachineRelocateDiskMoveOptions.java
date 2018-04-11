
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineRelocateDiskMoveOptions.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineRelocateDiskMoveOptions">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="moveAllDiskBackingsAndAllowSharing"/>
 *     &lt;enumeration value="moveAllDiskBackingsAndDisallowSharing"/>
 *     &lt;enumeration value="moveChildMostDiskBacking"/>
 *     &lt;enumeration value="createNewChildDiskBacking"/>
 *     &lt;enumeration value="moveAllDiskBackingsAndConsolidate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineRelocateDiskMoveOptions")
@XmlEnum
public enum VirtualMachineRelocateDiskMoveOptions {

    @XmlEnumValue("moveAllDiskBackingsAndAllowSharing")
    MOVE_ALL_DISK_BACKINGS_AND_ALLOW_SHARING("moveAllDiskBackingsAndAllowSharing"),
    @XmlEnumValue("moveAllDiskBackingsAndDisallowSharing")
    MOVE_ALL_DISK_BACKINGS_AND_DISALLOW_SHARING("moveAllDiskBackingsAndDisallowSharing"),
    @XmlEnumValue("moveChildMostDiskBacking")
    MOVE_CHILD_MOST_DISK_BACKING("moveChildMostDiskBacking"),
    @XmlEnumValue("createNewChildDiskBacking")
    CREATE_NEW_CHILD_DISK_BACKING("createNewChildDiskBacking"),
    @XmlEnumValue("moveAllDiskBackingsAndConsolidate")
    MOVE_ALL_DISK_BACKINGS_AND_CONSOLIDATE("moveAllDiskBackingsAndConsolidate");
    private final String value;

    VirtualMachineRelocateDiskMoveOptions(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineRelocateDiskMoveOptions fromValue(String v) {
        for (VirtualMachineRelocateDiskMoveOptions c: VirtualMachineRelocateDiskMoveOptions.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
