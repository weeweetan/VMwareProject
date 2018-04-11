
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerfSummaryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PerfSummaryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="average"/>
 *     &lt;enumeration value="maximum"/>
 *     &lt;enumeration value="minimum"/>
 *     &lt;enumeration value="latest"/>
 *     &lt;enumeration value="summation"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PerfSummaryType")
@XmlEnum
public enum PerfSummaryType {

    @XmlEnumValue("average")
    AVERAGE("average"),
    @XmlEnumValue("maximum")
    MAXIMUM("maximum"),
    @XmlEnumValue("minimum")
    MINIMUM("minimum"),
    @XmlEnumValue("latest")
    LATEST("latest"),
    @XmlEnumValue("summation")
    SUMMATION("summation"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    PerfSummaryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PerfSummaryType fromValue(String v) {
        for (PerfSummaryType c: PerfSummaryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
