
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecommendationReasonCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RecommendationReasonCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="fairnessCpuAvg"/>
 *     &lt;enumeration value="fairnessMemAvg"/>
 *     &lt;enumeration value="jointAffin"/>
 *     &lt;enumeration value="antiAffin"/>
 *     &lt;enumeration value="hostMaint"/>
 *     &lt;enumeration value="enterStandby"/>
 *     &lt;enumeration value="reservationCpu"/>
 *     &lt;enumeration value="reservationMem"/>
 *     &lt;enumeration value="powerOnVm"/>
 *     &lt;enumeration value="powerSaving"/>
 *     &lt;enumeration value="increaseCapacity"/>
 *     &lt;enumeration value="checkResource"/>
 *     &lt;enumeration value="unreservedCapacity"/>
 *     &lt;enumeration value="vmHostHardAffinity"/>
 *     &lt;enumeration value="vmHostSoftAffinity"/>
 *     &lt;enumeration value="balanceDatastoreSpaceUsage"/>
 *     &lt;enumeration value="balanceDatastoreIOLoad"/>
 *     &lt;enumeration value="datastoreMaint"/>
 *     &lt;enumeration value="virtualDiskJointAffin"/>
 *     &lt;enumeration value="virtualDiskAntiAffin"/>
 *     &lt;enumeration value="datastoreSpaceOutage"/>
 *     &lt;enumeration value="storagePlacement"/>
 *     &lt;enumeration value="iolbDisabledInternal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RecommendationReasonCode")
@XmlEnum
public enum RecommendationReasonCode {

    @XmlEnumValue("fairnessCpuAvg")
    FAIRNESS_CPU_AVG("fairnessCpuAvg"),
    @XmlEnumValue("fairnessMemAvg")
    FAIRNESS_MEM_AVG("fairnessMemAvg"),
    @XmlEnumValue("jointAffin")
    JOINT_AFFIN("jointAffin"),
    @XmlEnumValue("antiAffin")
    ANTI_AFFIN("antiAffin"),
    @XmlEnumValue("hostMaint")
    HOST_MAINT("hostMaint"),
    @XmlEnumValue("enterStandby")
    ENTER_STANDBY("enterStandby"),
    @XmlEnumValue("reservationCpu")
    RESERVATION_CPU("reservationCpu"),
    @XmlEnumValue("reservationMem")
    RESERVATION_MEM("reservationMem"),
    @XmlEnumValue("powerOnVm")
    POWER_ON_VM("powerOnVm"),
    @XmlEnumValue("powerSaving")
    POWER_SAVING("powerSaving"),
    @XmlEnumValue("increaseCapacity")
    INCREASE_CAPACITY("increaseCapacity"),
    @XmlEnumValue("checkResource")
    CHECK_RESOURCE("checkResource"),
    @XmlEnumValue("unreservedCapacity")
    UNRESERVED_CAPACITY("unreservedCapacity"),
    @XmlEnumValue("vmHostHardAffinity")
    VM_HOST_HARD_AFFINITY("vmHostHardAffinity"),
    @XmlEnumValue("vmHostSoftAffinity")
    VM_HOST_SOFT_AFFINITY("vmHostSoftAffinity"),
    @XmlEnumValue("balanceDatastoreSpaceUsage")
    BALANCE_DATASTORE_SPACE_USAGE("balanceDatastoreSpaceUsage"),
    @XmlEnumValue("balanceDatastoreIOLoad")
    BALANCE_DATASTORE_IO_LOAD("balanceDatastoreIOLoad"),
    @XmlEnumValue("datastoreMaint")
    DATASTORE_MAINT("datastoreMaint"),
    @XmlEnumValue("virtualDiskJointAffin")
    VIRTUAL_DISK_JOINT_AFFIN("virtualDiskJointAffin"),
    @XmlEnumValue("virtualDiskAntiAffin")
    VIRTUAL_DISK_ANTI_AFFIN("virtualDiskAntiAffin"),
    @XmlEnumValue("datastoreSpaceOutage")
    DATASTORE_SPACE_OUTAGE("datastoreSpaceOutage"),
    @XmlEnumValue("storagePlacement")
    STORAGE_PLACEMENT("storagePlacement"),
    @XmlEnumValue("iolbDisabledInternal")
    IOLB_DISABLED_INTERNAL("iolbDisabledInternal");
    private final String value;

    RecommendationReasonCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecommendationReasonCode fromValue(String v) {
        for (RecommendationReasonCode c: RecommendationReasonCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
