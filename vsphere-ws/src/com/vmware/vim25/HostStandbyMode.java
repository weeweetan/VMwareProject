
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostStandbyMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostStandbyMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="entering"/>
 *     &lt;enumeration value="exiting"/>
 *     &lt;enumeration value="in"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostStandbyMode")
@XmlEnum
public enum HostStandbyMode {

    @XmlEnumValue("entering")
    ENTERING("entering"),
    @XmlEnumValue("exiting")
    EXITING("exiting"),
    @XmlEnumValue("in")
    IN("in"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    HostStandbyMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostStandbyMode fromValue(String v) {
        for (HostStandbyMode c: HostStandbyMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
