
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationNetBIOSMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomizationNetBIOSMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="enableNetBIOSViaDhcp"/>
 *     &lt;enumeration value="enableNetBIOS"/>
 *     &lt;enumeration value="disableNetBIOS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomizationNetBIOSMode")
@XmlEnum
public enum CustomizationNetBIOSMode {

    @XmlEnumValue("enableNetBIOSViaDhcp")
    ENABLE_NET_BIOS_VIA_DHCP("enableNetBIOSViaDhcp"),
    @XmlEnumValue("enableNetBIOS")
    ENABLE_NET_BIOS("enableNetBIOS"),
    @XmlEnumValue("disableNetBIOS")
    DISABLE_NET_BIOS("disableNetBIOS");
    private final String value;

    CustomizationNetBIOSMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CustomizationNetBIOSMode fromValue(String v) {
        for (CustomizationNetBIOSMode c: CustomizationNetBIOSMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
