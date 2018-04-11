
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostActiveDirectoryInfoDomainMembershipStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostActiveDirectoryInfoDomainMembershipStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="ok"/>
 *     &lt;enumeration value="noServers"/>
 *     &lt;enumeration value="clientTrustBroken"/>
 *     &lt;enumeration value="serverTrustBroken"/>
 *     &lt;enumeration value="inconsistentTrust"/>
 *     &lt;enumeration value="otherProblem"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostActiveDirectoryInfoDomainMembershipStatus")
@XmlEnum
public enum HostActiveDirectoryInfoDomainMembershipStatus {

    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),
    @XmlEnumValue("ok")
    OK("ok"),
    @XmlEnumValue("noServers")
    NO_SERVERS("noServers"),
    @XmlEnumValue("clientTrustBroken")
    CLIENT_TRUST_BROKEN("clientTrustBroken"),
    @XmlEnumValue("serverTrustBroken")
    SERVER_TRUST_BROKEN("serverTrustBroken"),
    @XmlEnumValue("inconsistentTrust")
    INCONSISTENT_TRUST("inconsistentTrust"),
    @XmlEnumValue("otherProblem")
    OTHER_PROBLEM("otherProblem");
    private final String value;

    HostActiveDirectoryInfoDomainMembershipStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostActiveDirectoryInfoDomainMembershipStatus fromValue(String v) {
        for (HostActiveDirectoryInfoDomainMembershipStatus c: HostActiveDirectoryInfoDomainMembershipStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
