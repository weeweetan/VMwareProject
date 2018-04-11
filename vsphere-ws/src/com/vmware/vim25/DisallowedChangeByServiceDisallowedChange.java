
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DisallowedChangeByServiceDisallowedChange.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DisallowedChangeByServiceDisallowedChange">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="hotExtendDisk"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DisallowedChangeByServiceDisallowedChange")
@XmlEnum
public enum DisallowedChangeByServiceDisallowedChange {

    @XmlEnumValue("hotExtendDisk")
    HOT_EXTEND_DISK("hotExtendDisk");
    private final String value;

    DisallowedChangeByServiceDisallowedChange(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DisallowedChangeByServiceDisallowedChange fromValue(String v) {
        for (DisallowedChangeByServiceDisallowedChange c: DisallowedChangeByServiceDisallowedChange.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
