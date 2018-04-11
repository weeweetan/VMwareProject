
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LatencySensitivitySensitivityLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LatencySensitivitySensitivityLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="low"/>
 *     &lt;enumeration value="normal"/>
 *     &lt;enumeration value="medium"/>
 *     &lt;enumeration value="high"/>
 *     &lt;enumeration value="custom"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LatencySensitivitySensitivityLevel")
@XmlEnum
public enum LatencySensitivitySensitivityLevel {

    @XmlEnumValue("low")
    LOW("low"),
    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("medium")
    MEDIUM("medium"),
    @XmlEnumValue("high")
    HIGH("high"),
    @XmlEnumValue("custom")
    CUSTOM("custom");
    private final String value;

    LatencySensitivitySensitivityLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LatencySensitivitySensitivityLevel fromValue(String v) {
        for (LatencySensitivitySensitivityLevel c: LatencySensitivitySensitivityLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
