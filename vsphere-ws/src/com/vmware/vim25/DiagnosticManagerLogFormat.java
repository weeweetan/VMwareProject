
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiagnosticManagerLogFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DiagnosticManagerLogFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="plain"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DiagnosticManagerLogFormat")
@XmlEnum
public enum DiagnosticManagerLogFormat {

    @XmlEnumValue("plain")
    PLAIN("plain");
    private final String value;

    DiagnosticManagerLogFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DiagnosticManagerLogFormat fromValue(String v) {
        for (DiagnosticManagerLogFormat c: DiagnosticManagerLogFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
