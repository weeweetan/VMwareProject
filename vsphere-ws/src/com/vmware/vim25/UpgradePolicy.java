
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpgradePolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UpgradePolicy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="manual"/>
 *     &lt;enumeration value="upgradeAtPowerCycle"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UpgradePolicy")
@XmlEnum
public enum UpgradePolicy {

    @XmlEnumValue("manual")
    MANUAL("manual"),
    @XmlEnumValue("upgradeAtPowerCycle")
    UPGRADE_AT_POWER_CYCLE("upgradeAtPowerCycle");
    private final String value;

    UpgradePolicy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UpgradePolicy fromValue(String v) {
        for (UpgradePolicy c: UpgradePolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
