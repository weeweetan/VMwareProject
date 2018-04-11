
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScheduledHardwareUpgradeInfoHardwareUpgradeStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ScheduledHardwareUpgradeInfoHardwareUpgradeStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="pending"/>
 *     &lt;enumeration value="success"/>
 *     &lt;enumeration value="failed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScheduledHardwareUpgradeInfoHardwareUpgradeStatus")
@XmlEnum
public enum ScheduledHardwareUpgradeInfoHardwareUpgradeStatus {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("pending")
    PENDING("pending"),
    @XmlEnumValue("success")
    SUCCESS("success"),
    @XmlEnumValue("failed")
    FAILED("failed");
    private final String value;

    ScheduledHardwareUpgradeInfoHardwareUpgradeStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScheduledHardwareUpgradeInfoHardwareUpgradeStatus fromValue(String v) {
        for (ScheduledHardwareUpgradeInfoHardwareUpgradeStatus c: ScheduledHardwareUpgradeInfoHardwareUpgradeStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
