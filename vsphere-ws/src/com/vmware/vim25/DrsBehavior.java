
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DrsBehavior.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DrsBehavior">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="manual"/>
 *     &lt;enumeration value="partiallyAutomated"/>
 *     &lt;enumeration value="fullyAutomated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DrsBehavior")
@XmlEnum
public enum DrsBehavior {

    @XmlEnumValue("manual")
    MANUAL("manual"),
    @XmlEnumValue("partiallyAutomated")
    PARTIALLY_AUTOMATED("partiallyAutomated"),
    @XmlEnumValue("fullyAutomated")
    FULLY_AUTOMATED("fullyAutomated");
    private final String value;

    DrsBehavior(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DrsBehavior fromValue(String v) {
        for (DrsBehavior c: DrsBehavior.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
