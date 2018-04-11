
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageIORMThresholdMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StorageIORMThresholdMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="automatic"/>
 *     &lt;enumeration value="manual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StorageIORMThresholdMode")
@XmlEnum
public enum StorageIORMThresholdMode {

    @XmlEnumValue("automatic")
    AUTOMATIC("automatic"),
    @XmlEnumValue("manual")
    MANUAL("manual");
    private final String value;

    StorageIORMThresholdMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StorageIORMThresholdMode fromValue(String v) {
        for (StorageIORMThresholdMode c: StorageIORMThresholdMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
