
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AutoStartWaitHeartbeatSetting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AutoStartWaitHeartbeatSetting">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="yes"/>
 *     &lt;enumeration value="no"/>
 *     &lt;enumeration value="systemDefault"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AutoStartWaitHeartbeatSetting")
@XmlEnum
public enum AutoStartWaitHeartbeatSetting {

    @XmlEnumValue("yes")
    YES("yes"),
    @XmlEnumValue("no")
    NO("no"),
    @XmlEnumValue("systemDefault")
    SYSTEM_DEFAULT("systemDefault");
    private final String value;

    AutoStartWaitHeartbeatSetting(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AutoStartWaitHeartbeatSetting fromValue(String v) {
        for (AutoStartWaitHeartbeatSetting c: AutoStartWaitHeartbeatSetting.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
