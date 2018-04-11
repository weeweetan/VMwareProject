
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScsiLunVStorageSupportStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ScsiLunVStorageSupportStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="vStorageSupported"/>
 *     &lt;enumeration value="vStorageUnsupported"/>
 *     &lt;enumeration value="vStorageUnknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScsiLunVStorageSupportStatus")
@XmlEnum
public enum ScsiLunVStorageSupportStatus {

    @XmlEnumValue("vStorageSupported")
    V_STORAGE_SUPPORTED("vStorageSupported"),
    @XmlEnumValue("vStorageUnsupported")
    V_STORAGE_UNSUPPORTED("vStorageUnsupported"),
    @XmlEnumValue("vStorageUnknown")
    V_STORAGE_UNKNOWN("vStorageUnknown");
    private final String value;

    ScsiLunVStorageSupportStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScsiLunVStorageSupportStatus fromValue(String v) {
        for (ScsiLunVStorageSupportStatus c: ScsiLunVStorageSupportStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
