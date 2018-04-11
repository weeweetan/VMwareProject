
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostSnmpAgentCapability.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostSnmpAgentCapability">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COMPLETE"/>
 *     &lt;enumeration value="DIAGNOSTICS"/>
 *     &lt;enumeration value="CONFIGURATION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostSnmpAgentCapability")
@XmlEnum
public enum HostSnmpAgentCapability {

    COMPLETE,
    DIAGNOSTICS,
    CONFIGURATION;

    public String value() {
        return name();
    }

    public static HostSnmpAgentCapability fromValue(String v) {
        return valueOf(v);
    }

}
