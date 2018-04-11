
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineUsbInfoFamily.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineUsbInfoFamily">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="audio"/>
 *     &lt;enumeration value="hid"/>
 *     &lt;enumeration value="hid_bootable"/>
 *     &lt;enumeration value="physical"/>
 *     &lt;enumeration value="communication"/>
 *     &lt;enumeration value="imaging"/>
 *     &lt;enumeration value="printer"/>
 *     &lt;enumeration value="storage"/>
 *     &lt;enumeration value="hub"/>
 *     &lt;enumeration value="smart_card"/>
 *     &lt;enumeration value="security"/>
 *     &lt;enumeration value="video"/>
 *     &lt;enumeration value="wireless"/>
 *     &lt;enumeration value="bluetooth"/>
 *     &lt;enumeration value="wusb"/>
 *     &lt;enumeration value="pda"/>
 *     &lt;enumeration value="vendor_specific"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="unknownFamily"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineUsbInfoFamily")
@XmlEnum
public enum VirtualMachineUsbInfoFamily {

    @XmlEnumValue("audio")
    AUDIO("audio"),
    @XmlEnumValue("hid")
    HID("hid"),
    @XmlEnumValue("hid_bootable")
    HID_BOOTABLE("hid_bootable"),
    @XmlEnumValue("physical")
    PHYSICAL("physical"),
    @XmlEnumValue("communication")
    COMMUNICATION("communication"),
    @XmlEnumValue("imaging")
    IMAGING("imaging"),
    @XmlEnumValue("printer")
    PRINTER("printer"),
    @XmlEnumValue("storage")
    STORAGE("storage"),
    @XmlEnumValue("hub")
    HUB("hub"),
    @XmlEnumValue("smart_card")
    SMART_CARD("smart_card"),
    @XmlEnumValue("security")
    SECURITY("security"),
    @XmlEnumValue("video")
    VIDEO("video"),
    @XmlEnumValue("wireless")
    WIRELESS("wireless"),
    @XmlEnumValue("bluetooth")
    BLUETOOTH("bluetooth"),
    @XmlEnumValue("wusb")
    WUSB("wusb"),
    @XmlEnumValue("pda")
    PDA("pda"),
    @XmlEnumValue("vendor_specific")
    VENDOR_SPECIFIC("vendor_specific"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("unknownFamily")
    UNKNOWN_FAMILY("unknownFamily");
    private final String value;

    VirtualMachineUsbInfoFamily(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineUsbInfoFamily fromValue(String v) {
        for (VirtualMachineUsbInfoFamily c: VirtualMachineUsbInfoFamily.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
