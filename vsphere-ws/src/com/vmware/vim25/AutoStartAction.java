
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AutoStartAction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AutoStartAction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="systemDefault"/>
 *     &lt;enumeration value="powerOn"/>
 *     &lt;enumeration value="powerOff"/>
 *     &lt;enumeration value="guestShutdown"/>
 *     &lt;enumeration value="suspend"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AutoStartAction")
@XmlEnum
public enum AutoStartAction {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("systemDefault")
    SYSTEM_DEFAULT("systemDefault"),
    @XmlEnumValue("powerOn")
    POWER_ON("powerOn"),
    @XmlEnumValue("powerOff")
    POWER_OFF("powerOff"),
    @XmlEnumValue("guestShutdown")
    GUEST_SHUTDOWN("guestShutdown"),
    @XmlEnumValue("suspend")
    SUSPEND("suspend");
    private final String value;

    AutoStartAction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AutoStartAction fromValue(String v) {
        for (AutoStartAction c: AutoStartAction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
