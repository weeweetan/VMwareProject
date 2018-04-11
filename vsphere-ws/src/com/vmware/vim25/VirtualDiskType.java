
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDiskType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualDiskType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="preallocated"/>
 *     &lt;enumeration value="thin"/>
 *     &lt;enumeration value="seSparse"/>
 *     &lt;enumeration value="rdm"/>
 *     &lt;enumeration value="rdmp"/>
 *     &lt;enumeration value="raw"/>
 *     &lt;enumeration value="sparse2Gb"/>
 *     &lt;enumeration value="thick2Gb"/>
 *     &lt;enumeration value="eagerZeroedThick"/>
 *     &lt;enumeration value="sparseMonolithic"/>
 *     &lt;enumeration value="flatMonolithic"/>
 *     &lt;enumeration value="thick"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualDiskType")
@XmlEnum
public enum VirtualDiskType {

    @XmlEnumValue("preallocated")
    PREALLOCATED("preallocated"),
    @XmlEnumValue("thin")
    THIN("thin"),
    @XmlEnumValue("seSparse")
    SE_SPARSE("seSparse"),
    @XmlEnumValue("rdm")
    RDM("rdm"),
    @XmlEnumValue("rdmp")
    RDMP("rdmp"),
    @XmlEnumValue("raw")
    RAW("raw"),
    @XmlEnumValue("sparse2Gb")
    SPARSE_2_GB("sparse2Gb"),
    @XmlEnumValue("thick2Gb")
    THICK_2_GB("thick2Gb"),
    @XmlEnumValue("eagerZeroedThick")
    EAGER_ZEROED_THICK("eagerZeroedThick"),
    @XmlEnumValue("sparseMonolithic")
    SPARSE_MONOLITHIC("sparseMonolithic"),
    @XmlEnumValue("flatMonolithic")
    FLAT_MONOLITHIC("flatMonolithic"),
    @XmlEnumValue("thick")
    THICK("thick");
    private final String value;

    VirtualDiskType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualDiskType fromValue(String v) {
        for (VirtualDiskType c: VirtualDiskType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
