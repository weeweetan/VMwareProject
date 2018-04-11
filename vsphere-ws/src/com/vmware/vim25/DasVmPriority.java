
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DasVmPriority.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DasVmPriority">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="disabled"/>
 *     &lt;enumeration value="low"/>
 *     &lt;enumeration value="medium"/>
 *     &lt;enumeration value="high"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DasVmPriority")
@XmlEnum
public enum DasVmPriority {

    @XmlEnumValue("disabled")
    DISABLED("disabled"),
    @XmlEnumValue("low")
    LOW("low"),
    @XmlEnumValue("medium")
    MEDIUM("medium"),
    @XmlEnumValue("high")
    HIGH("high");
    private final String value;

    DasVmPriority(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DasVmPriority fromValue(String v) {
        for (DasVmPriority c: DasVmPriority.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
