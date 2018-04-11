
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDigestInfoDigestMethodType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostDigestInfoDigestMethodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SHA1"/>
 *     &lt;enumeration value="MD5"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostDigestInfoDigestMethodType")
@XmlEnum
public enum HostDigestInfoDigestMethodType {

    @XmlEnumValue("SHA1")
    SHA_1("SHA1"),
    @XmlEnumValue("MD5")
    MD_5("MD5");
    private final String value;

    HostDigestInfoDigestMethodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostDigestInfoDigestMethodType fromValue(String v) {
        for (HostDigestInfoDigestMethodType c: HostDigestInfoDigestMethodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
