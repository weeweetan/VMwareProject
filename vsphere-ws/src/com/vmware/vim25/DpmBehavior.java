
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DpmBehavior.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DpmBehavior">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="manual"/>
 *     &lt;enumeration value="automated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DpmBehavior")
@XmlEnum
public enum DpmBehavior {

    @XmlEnumValue("manual")
    MANUAL("manual"),
    @XmlEnumValue("automated")
    AUTOMATED("automated");
    private final String value;

    DpmBehavior(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DpmBehavior fromValue(String v) {
        for (DpmBehavior c: DpmBehavior.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
