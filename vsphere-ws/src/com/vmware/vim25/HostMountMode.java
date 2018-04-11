
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostMountMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostMountMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="readWrite"/>
 *     &lt;enumeration value="readOnly"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostMountMode")
@XmlEnum
public enum HostMountMode {

    @XmlEnumValue("readWrite")
    READ_WRITE("readWrite"),
    @XmlEnumValue("readOnly")
    READ_ONLY("readOnly");
    private final String value;

    HostMountMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostMountMode fromValue(String v) {
        for (HostMountMode c: HostMountMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
