
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostServicePolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostServicePolicy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="on"/>
 *     &lt;enumeration value="automatic"/>
 *     &lt;enumeration value="off"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostServicePolicy")
@XmlEnum
public enum HostServicePolicy {

    @XmlEnumValue("on")
    ON("on"),
    @XmlEnumValue("automatic")
    AUTOMATIC("automatic"),
    @XmlEnumValue("off")
    OFF("off");
    private final String value;

    HostServicePolicy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostServicePolicy fromValue(String v) {
        for (HostServicePolicy c: HostServicePolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
