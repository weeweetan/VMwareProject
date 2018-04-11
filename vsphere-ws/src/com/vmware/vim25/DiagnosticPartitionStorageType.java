
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiagnosticPartitionStorageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DiagnosticPartitionStorageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="directAttached"/>
 *     &lt;enumeration value="networkAttached"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DiagnosticPartitionStorageType")
@XmlEnum
public enum DiagnosticPartitionStorageType {

    @XmlEnumValue("directAttached")
    DIRECT_ATTACHED("directAttached"),
    @XmlEnumValue("networkAttached")
    NETWORK_ATTACHED("networkAttached");
    private final String value;

    DiagnosticPartitionStorageType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DiagnosticPartitionStorageType fromValue(String v) {
        for (DiagnosticPartitionStorageType c: DiagnosticPartitionStorageType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
