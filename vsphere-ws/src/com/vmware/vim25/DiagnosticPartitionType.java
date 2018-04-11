
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiagnosticPartitionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DiagnosticPartitionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="singleHost"/>
 *     &lt;enumeration value="multiHost"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DiagnosticPartitionType")
@XmlEnum
public enum DiagnosticPartitionType {

    @XmlEnumValue("singleHost")
    SINGLE_HOST("singleHost"),
    @XmlEnumValue("multiHost")
    MULTI_HOST("multiHost");
    private final String value;

    DiagnosticPartitionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DiagnosticPartitionType fromValue(String v) {
        for (DiagnosticPartitionType c: DiagnosticPartitionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
