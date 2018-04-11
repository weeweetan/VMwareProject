
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfCreateImportSpecParamsDiskProvisioningType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OvfCreateImportSpecParamsDiskProvisioningType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="monolithicSparse"/>
 *     &lt;enumeration value="monolithicFlat"/>
 *     &lt;enumeration value="twoGbMaxExtentSparse"/>
 *     &lt;enumeration value="twoGbMaxExtentFlat"/>
 *     &lt;enumeration value="thin"/>
 *     &lt;enumeration value="thick"/>
 *     &lt;enumeration value="seSparse"/>
 *     &lt;enumeration value="eagerZeroedThick"/>
 *     &lt;enumeration value="sparse"/>
 *     &lt;enumeration value="flat"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OvfCreateImportSpecParamsDiskProvisioningType")
@XmlEnum
public enum OvfCreateImportSpecParamsDiskProvisioningType {

    @XmlEnumValue("monolithicSparse")
    MONOLITHIC_SPARSE("monolithicSparse"),
    @XmlEnumValue("monolithicFlat")
    MONOLITHIC_FLAT("monolithicFlat"),
    @XmlEnumValue("twoGbMaxExtentSparse")
    TWO_GB_MAX_EXTENT_SPARSE("twoGbMaxExtentSparse"),
    @XmlEnumValue("twoGbMaxExtentFlat")
    TWO_GB_MAX_EXTENT_FLAT("twoGbMaxExtentFlat"),
    @XmlEnumValue("thin")
    THIN("thin"),
    @XmlEnumValue("thick")
    THICK("thick"),
    @XmlEnumValue("seSparse")
    SE_SPARSE("seSparse"),
    @XmlEnumValue("eagerZeroedThick")
    EAGER_ZEROED_THICK("eagerZeroedThick"),
    @XmlEnumValue("sparse")
    SPARSE("sparse"),
    @XmlEnumValue("flat")
    FLAT("flat");
    private final String value;

    OvfCreateImportSpecParamsDiskProvisioningType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OvfCreateImportSpecParamsDiskProvisioningType fromValue(String v) {
        for (OvfCreateImportSpecParamsDiskProvisioningType c: OvfCreateImportSpecParamsDiskProvisioningType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
