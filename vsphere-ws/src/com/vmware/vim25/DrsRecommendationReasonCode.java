
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DrsRecommendationReasonCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DrsRecommendationReasonCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="fairnessCpuAvg"/>
 *     &lt;enumeration value="fairnessMemAvg"/>
 *     &lt;enumeration value="jointAffin"/>
 *     &lt;enumeration value="antiAffin"/>
 *     &lt;enumeration value="hostMaint"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DrsRecommendationReasonCode")
@XmlEnum
public enum DrsRecommendationReasonCode {

    @XmlEnumValue("fairnessCpuAvg")
    FAIRNESS_CPU_AVG("fairnessCpuAvg"),
    @XmlEnumValue("fairnessMemAvg")
    FAIRNESS_MEM_AVG("fairnessMemAvg"),
    @XmlEnumValue("jointAffin")
    JOINT_AFFIN("jointAffin"),
    @XmlEnumValue("antiAffin")
    ANTI_AFFIN("antiAffin"),
    @XmlEnumValue("hostMaint")
    HOST_MAINT("hostMaint");
    private final String value;

    DrsRecommendationReasonCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DrsRecommendationReasonCode fromValue(String v) {
        for (DrsRecommendationReasonCode c: DrsRecommendationReasonCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
