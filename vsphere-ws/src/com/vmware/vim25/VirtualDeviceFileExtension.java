
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDeviceFileExtension.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualDeviceFileExtension">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="iso"/>
 *     &lt;enumeration value="flp"/>
 *     &lt;enumeration value="vmdk"/>
 *     &lt;enumeration value="dsk"/>
 *     &lt;enumeration value="rdm"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualDeviceFileExtension")
@XmlEnum
public enum VirtualDeviceFileExtension {

    @XmlEnumValue("iso")
    ISO("iso"),
    @XmlEnumValue("flp")
    FLP("flp"),
    @XmlEnumValue("vmdk")
    VMDK("vmdk"),
    @XmlEnumValue("dsk")
    DSK("dsk"),
    @XmlEnumValue("rdm")
    RDM("rdm");
    private final String value;

    VirtualDeviceFileExtension(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualDeviceFileExtension fromValue(String v) {
        for (VirtualDeviceFileExtension c: VirtualDeviceFileExtension.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
