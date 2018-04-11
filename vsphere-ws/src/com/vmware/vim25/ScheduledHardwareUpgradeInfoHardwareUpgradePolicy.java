
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScheduledHardwareUpgradeInfoHardwareUpgradePolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ScheduledHardwareUpgradeInfoHardwareUpgradePolicy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="never"/>
 *     &lt;enumeration value="onSoftPowerOff"/>
 *     &lt;enumeration value="always"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScheduledHardwareUpgradeInfoHardwareUpgradePolicy")
@XmlEnum
public enum ScheduledHardwareUpgradeInfoHardwareUpgradePolicy {

    @XmlEnumValue("never")
    NEVER("never"),
    @XmlEnumValue("onSoftPowerOff")
    ON_SOFT_POWER_OFF("onSoftPowerOff"),
    @XmlEnumValue("always")
    ALWAYS("always");
    private final String value;

    ScheduledHardwareUpgradeInfoHardwareUpgradePolicy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScheduledHardwareUpgradeInfoHardwareUpgradePolicy fromValue(String v) {
        for (ScheduledHardwareUpgradeInfoHardwareUpgradePolicy c: ScheduledHardwareUpgradeInfoHardwareUpgradePolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
