
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareDVSVspanSessionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VMwareDVSVspanSessionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="mixedDestMirror"/>
 *     &lt;enumeration value="dvPortMirror"/>
 *     &lt;enumeration value="remoteMirrorSource"/>
 *     &lt;enumeration value="remoteMirrorDest"/>
 *     &lt;enumeration value="encapsulatedRemoteMirrorSource"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VMwareDVSVspanSessionType")
@XmlEnum
public enum VMwareDVSVspanSessionType {

    @XmlEnumValue("mixedDestMirror")
    MIXED_DEST_MIRROR("mixedDestMirror"),
    @XmlEnumValue("dvPortMirror")
    DV_PORT_MIRROR("dvPortMirror"),
    @XmlEnumValue("remoteMirrorSource")
    REMOTE_MIRROR_SOURCE("remoteMirrorSource"),
    @XmlEnumValue("remoteMirrorDest")
    REMOTE_MIRROR_DEST("remoteMirrorDest"),
    @XmlEnumValue("encapsulatedRemoteMirrorSource")
    ENCAPSULATED_REMOTE_MIRROR_SOURCE("encapsulatedRemoteMirrorSource");
    private final String value;

    VMwareDVSVspanSessionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VMwareDVSVspanSessionType fromValue(String v) {
        for (VMwareDVSVspanSessionType c: VMwareDVSVspanSessionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
