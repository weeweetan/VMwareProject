
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterDasConfigInfoVmMonitoringState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClusterDasConfigInfoVmMonitoringState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="vmMonitoringDisabled"/>
 *     &lt;enumeration value="vmMonitoringOnly"/>
 *     &lt;enumeration value="vmAndAppMonitoring"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClusterDasConfigInfoVmMonitoringState")
@XmlEnum
public enum ClusterDasConfigInfoVmMonitoringState {

    @XmlEnumValue("vmMonitoringDisabled")
    VM_MONITORING_DISABLED("vmMonitoringDisabled"),
    @XmlEnumValue("vmMonitoringOnly")
    VM_MONITORING_ONLY("vmMonitoringOnly"),
    @XmlEnumValue("vmAndAppMonitoring")
    VM_AND_APP_MONITORING("vmAndAppMonitoring");
    private final String value;

    ClusterDasConfigInfoVmMonitoringState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClusterDasConfigInfoVmMonitoringState fromValue(String v) {
        for (ClusterDasConfigInfoVmMonitoringState c: ClusterDasConfigInfoVmMonitoringState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
