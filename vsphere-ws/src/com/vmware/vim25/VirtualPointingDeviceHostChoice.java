
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualPointingDeviceHostChoice.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualPointingDeviceHostChoice">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="autodetect"/>
 *     &lt;enumeration value="intellimouseExplorer"/>
 *     &lt;enumeration value="intellimousePs2"/>
 *     &lt;enumeration value="logitechMouseman"/>
 *     &lt;enumeration value="microsoft_serial"/>
 *     &lt;enumeration value="mouseSystems"/>
 *     &lt;enumeration value="mousemanSerial"/>
 *     &lt;enumeration value="ps2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualPointingDeviceHostChoice")
@XmlEnum
public enum VirtualPointingDeviceHostChoice {

    @XmlEnumValue("autodetect")
    AUTODETECT("autodetect"),
    @XmlEnumValue("intellimouseExplorer")
    INTELLIMOUSE_EXPLORER("intellimouseExplorer"),
    @XmlEnumValue("intellimousePs2")
    INTELLIMOUSE_PS_2("intellimousePs2"),
    @XmlEnumValue("logitechMouseman")
    LOGITECH_MOUSEMAN("logitechMouseman"),
    @XmlEnumValue("microsoft_serial")
    MICROSOFT_SERIAL("microsoft_serial"),
    @XmlEnumValue("mouseSystems")
    MOUSE_SYSTEMS("mouseSystems"),
    @XmlEnumValue("mousemanSerial")
    MOUSEMAN_SERIAL("mousemanSerial"),
    @XmlEnumValue("ps2")
    PS_2("ps2");
    private final String value;

    VirtualPointingDeviceHostChoice(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualPointingDeviceHostChoice fromValue(String v) {
        for (VirtualPointingDeviceHostChoice c: VirtualPointingDeviceHostChoice.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
