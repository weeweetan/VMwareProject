
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineGuestOsIdentifier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirtualMachineGuestOsIdentifier">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="dosGuest"/>
 *     &lt;enumeration value="win31Guest"/>
 *     &lt;enumeration value="win95Guest"/>
 *     &lt;enumeration value="win98Guest"/>
 *     &lt;enumeration value="winMeGuest"/>
 *     &lt;enumeration value="winNTGuest"/>
 *     &lt;enumeration value="win2000ProGuest"/>
 *     &lt;enumeration value="win2000ServGuest"/>
 *     &lt;enumeration value="win2000AdvServGuest"/>
 *     &lt;enumeration value="winXPHomeGuest"/>
 *     &lt;enumeration value="winXPProGuest"/>
 *     &lt;enumeration value="winXPPro64Guest"/>
 *     &lt;enumeration value="winNetWebGuest"/>
 *     &lt;enumeration value="winNetStandardGuest"/>
 *     &lt;enumeration value="winNetEnterpriseGuest"/>
 *     &lt;enumeration value="winNetDatacenterGuest"/>
 *     &lt;enumeration value="winNetBusinessGuest"/>
 *     &lt;enumeration value="winNetStandard64Guest"/>
 *     &lt;enumeration value="winNetEnterprise64Guest"/>
 *     &lt;enumeration value="winLonghornGuest"/>
 *     &lt;enumeration value="winLonghorn64Guest"/>
 *     &lt;enumeration value="winNetDatacenter64Guest"/>
 *     &lt;enumeration value="winVistaGuest"/>
 *     &lt;enumeration value="winVista64Guest"/>
 *     &lt;enumeration value="windows7Guest"/>
 *     &lt;enumeration value="windows7_64Guest"/>
 *     &lt;enumeration value="windows7Server64Guest"/>
 *     &lt;enumeration value="windows8Guest"/>
 *     &lt;enumeration value="windows8_64Guest"/>
 *     &lt;enumeration value="windows8Server64Guest"/>
 *     &lt;enumeration value="freebsdGuest"/>
 *     &lt;enumeration value="freebsd64Guest"/>
 *     &lt;enumeration value="redhatGuest"/>
 *     &lt;enumeration value="rhel2Guest"/>
 *     &lt;enumeration value="rhel3Guest"/>
 *     &lt;enumeration value="rhel3_64Guest"/>
 *     &lt;enumeration value="rhel4Guest"/>
 *     &lt;enumeration value="rhel4_64Guest"/>
 *     &lt;enumeration value="rhel5Guest"/>
 *     &lt;enumeration value="rhel5_64Guest"/>
 *     &lt;enumeration value="rhel6Guest"/>
 *     &lt;enumeration value="rhel6_64Guest"/>
 *     &lt;enumeration value="centosGuest"/>
 *     &lt;enumeration value="centos64Guest"/>
 *     &lt;enumeration value="oracleLinuxGuest"/>
 *     &lt;enumeration value="oracleLinux64Guest"/>
 *     &lt;enumeration value="suseGuest"/>
 *     &lt;enumeration value="suse64Guest"/>
 *     &lt;enumeration value="slesGuest"/>
 *     &lt;enumeration value="sles64Guest"/>
 *     &lt;enumeration value="sles10Guest"/>
 *     &lt;enumeration value="sles10_64Guest"/>
 *     &lt;enumeration value="sles11Guest"/>
 *     &lt;enumeration value="sles11_64Guest"/>
 *     &lt;enumeration value="nld9Guest"/>
 *     &lt;enumeration value="oesGuest"/>
 *     &lt;enumeration value="sjdsGuest"/>
 *     &lt;enumeration value="mandrivaGuest"/>
 *     &lt;enumeration value="mandriva64Guest"/>
 *     &lt;enumeration value="turboLinuxGuest"/>
 *     &lt;enumeration value="turboLinux64Guest"/>
 *     &lt;enumeration value="ubuntuGuest"/>
 *     &lt;enumeration value="ubuntu64Guest"/>
 *     &lt;enumeration value="debian4Guest"/>
 *     &lt;enumeration value="debian4_64Guest"/>
 *     &lt;enumeration value="debian5Guest"/>
 *     &lt;enumeration value="debian5_64Guest"/>
 *     &lt;enumeration value="debian6Guest"/>
 *     &lt;enumeration value="debian6_64Guest"/>
 *     &lt;enumeration value="asianux3Guest"/>
 *     &lt;enumeration value="asianux3_64Guest"/>
 *     &lt;enumeration value="asianux4Guest"/>
 *     &lt;enumeration value="asianux4_64Guest"/>
 *     &lt;enumeration value="opensuseGuest"/>
 *     &lt;enumeration value="opensuse64Guest"/>
 *     &lt;enumeration value="fedoraGuest"/>
 *     &lt;enumeration value="fedora64Guest"/>
 *     &lt;enumeration value="other24xLinuxGuest"/>
 *     &lt;enumeration value="other26xLinuxGuest"/>
 *     &lt;enumeration value="otherLinuxGuest"/>
 *     &lt;enumeration value="other24xLinux64Guest"/>
 *     &lt;enumeration value="other26xLinux64Guest"/>
 *     &lt;enumeration value="otherLinux64Guest"/>
 *     &lt;enumeration value="solaris6Guest"/>
 *     &lt;enumeration value="solaris7Guest"/>
 *     &lt;enumeration value="solaris8Guest"/>
 *     &lt;enumeration value="solaris9Guest"/>
 *     &lt;enumeration value="solaris10Guest"/>
 *     &lt;enumeration value="solaris10_64Guest"/>
 *     &lt;enumeration value="solaris11_64Guest"/>
 *     &lt;enumeration value="os2Guest"/>
 *     &lt;enumeration value="eComStationGuest"/>
 *     &lt;enumeration value="eComStation2Guest"/>
 *     &lt;enumeration value="netware4Guest"/>
 *     &lt;enumeration value="netware5Guest"/>
 *     &lt;enumeration value="netware6Guest"/>
 *     &lt;enumeration value="openServer5Guest"/>
 *     &lt;enumeration value="openServer6Guest"/>
 *     &lt;enumeration value="unixWare7Guest"/>
 *     &lt;enumeration value="darwinGuest"/>
 *     &lt;enumeration value="darwin64Guest"/>
 *     &lt;enumeration value="darwin10Guest"/>
 *     &lt;enumeration value="darwin10_64Guest"/>
 *     &lt;enumeration value="darwin11Guest"/>
 *     &lt;enumeration value="darwin11_64Guest"/>
 *     &lt;enumeration value="vmkernelGuest"/>
 *     &lt;enumeration value="vmkernel5Guest"/>
 *     &lt;enumeration value="otherGuest"/>
 *     &lt;enumeration value="otherGuest64"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirtualMachineGuestOsIdentifier")
@XmlEnum
public enum VirtualMachineGuestOsIdentifier {

    @XmlEnumValue("dosGuest")
    DOS_GUEST("dosGuest"),
    @XmlEnumValue("win31Guest")
    WIN_31_GUEST("win31Guest"),
    @XmlEnumValue("win95Guest")
    WIN_95_GUEST("win95Guest"),
    @XmlEnumValue("win98Guest")
    WIN_98_GUEST("win98Guest"),
    @XmlEnumValue("winMeGuest")
    WIN_ME_GUEST("winMeGuest"),
    @XmlEnumValue("winNTGuest")
    WIN_NT_GUEST("winNTGuest"),
    @XmlEnumValue("win2000ProGuest")
    WIN_2000_PRO_GUEST("win2000ProGuest"),
    @XmlEnumValue("win2000ServGuest")
    WIN_2000_SERV_GUEST("win2000ServGuest"),
    @XmlEnumValue("win2000AdvServGuest")
    WIN_2000_ADV_SERV_GUEST("win2000AdvServGuest"),
    @XmlEnumValue("winXPHomeGuest")
    WIN_XP_HOME_GUEST("winXPHomeGuest"),
    @XmlEnumValue("winXPProGuest")
    WIN_XP_PRO_GUEST("winXPProGuest"),
    @XmlEnumValue("winXPPro64Guest")
    WIN_XP_PRO_64_GUEST("winXPPro64Guest"),
    @XmlEnumValue("winNetWebGuest")
    WIN_NET_WEB_GUEST("winNetWebGuest"),
    @XmlEnumValue("winNetStandardGuest")
    WIN_NET_STANDARD_GUEST("winNetStandardGuest"),
    @XmlEnumValue("winNetEnterpriseGuest")
    WIN_NET_ENTERPRISE_GUEST("winNetEnterpriseGuest"),
    @XmlEnumValue("winNetDatacenterGuest")
    WIN_NET_DATACENTER_GUEST("winNetDatacenterGuest"),
    @XmlEnumValue("winNetBusinessGuest")
    WIN_NET_BUSINESS_GUEST("winNetBusinessGuest"),
    @XmlEnumValue("winNetStandard64Guest")
    WIN_NET_STANDARD_64_GUEST("winNetStandard64Guest"),
    @XmlEnumValue("winNetEnterprise64Guest")
    WIN_NET_ENTERPRISE_64_GUEST("winNetEnterprise64Guest"),
    @XmlEnumValue("winLonghornGuest")
    WIN_LONGHORN_GUEST("winLonghornGuest"),
    @XmlEnumValue("winLonghorn64Guest")
    WIN_LONGHORN_64_GUEST("winLonghorn64Guest"),
    @XmlEnumValue("winNetDatacenter64Guest")
    WIN_NET_DATACENTER_64_GUEST("winNetDatacenter64Guest"),
    @XmlEnumValue("winVistaGuest")
    WIN_VISTA_GUEST("winVistaGuest"),
    @XmlEnumValue("winVista64Guest")
    WIN_VISTA_64_GUEST("winVista64Guest"),
    @XmlEnumValue("windows7Guest")
    WINDOWS_7_GUEST("windows7Guest"),
    @XmlEnumValue("windows7_64Guest")
    WINDOWS_7_64_GUEST("windows7_64Guest"),
    @XmlEnumValue("windows7Server64Guest")
    WINDOWS_7_SERVER_64_GUEST("windows7Server64Guest"),
    @XmlEnumValue("windows8Guest")
    WINDOWS_8_GUEST("windows8Guest"),
    @XmlEnumValue("windows8_64Guest")
    WINDOWS_8_64_GUEST("windows8_64Guest"),
    @XmlEnumValue("windows8Server64Guest")
    WINDOWS_8_SERVER_64_GUEST("windows8Server64Guest"),
    @XmlEnumValue("freebsdGuest")
    FREEBSD_GUEST("freebsdGuest"),
    @XmlEnumValue("freebsd64Guest")
    FREEBSD_64_GUEST("freebsd64Guest"),
    @XmlEnumValue("redhatGuest")
    REDHAT_GUEST("redhatGuest"),
    @XmlEnumValue("rhel2Guest")
    RHEL_2_GUEST("rhel2Guest"),
    @XmlEnumValue("rhel3Guest")
    RHEL_3_GUEST("rhel3Guest"),
    @XmlEnumValue("rhel3_64Guest")
    RHEL_3_64_GUEST("rhel3_64Guest"),
    @XmlEnumValue("rhel4Guest")
    RHEL_4_GUEST("rhel4Guest"),
    @XmlEnumValue("rhel4_64Guest")
    RHEL_4_64_GUEST("rhel4_64Guest"),
    @XmlEnumValue("rhel5Guest")
    RHEL_5_GUEST("rhel5Guest"),
    @XmlEnumValue("rhel5_64Guest")
    RHEL_5_64_GUEST("rhel5_64Guest"),
    @XmlEnumValue("rhel6Guest")
    RHEL_6_GUEST("rhel6Guest"),
    @XmlEnumValue("rhel6_64Guest")
    RHEL_6_64_GUEST("rhel6_64Guest"),
    @XmlEnumValue("centosGuest")
    CENTOS_GUEST("centosGuest"),
    @XmlEnumValue("centos64Guest")
    CENTOS_64_GUEST("centos64Guest"),
    @XmlEnumValue("oracleLinuxGuest")
    ORACLE_LINUX_GUEST("oracleLinuxGuest"),
    @XmlEnumValue("oracleLinux64Guest")
    ORACLE_LINUX_64_GUEST("oracleLinux64Guest"),
    @XmlEnumValue("suseGuest")
    SUSE_GUEST("suseGuest"),
    @XmlEnumValue("suse64Guest")
    SUSE_64_GUEST("suse64Guest"),
    @XmlEnumValue("slesGuest")
    SLES_GUEST("slesGuest"),
    @XmlEnumValue("sles64Guest")
    SLES_64_GUEST("sles64Guest"),
    @XmlEnumValue("sles10Guest")
    SLES_10_GUEST("sles10Guest"),
    @XmlEnumValue("sles10_64Guest")
    SLES_10_64_GUEST("sles10_64Guest"),
    @XmlEnumValue("sles11Guest")
    SLES_11_GUEST("sles11Guest"),
    @XmlEnumValue("sles11_64Guest")
    SLES_11_64_GUEST("sles11_64Guest"),
    @XmlEnumValue("nld9Guest")
    NLD_9_GUEST("nld9Guest"),
    @XmlEnumValue("oesGuest")
    OES_GUEST("oesGuest"),
    @XmlEnumValue("sjdsGuest")
    SJDS_GUEST("sjdsGuest"),
    @XmlEnumValue("mandrivaGuest")
    MANDRIVA_GUEST("mandrivaGuest"),
    @XmlEnumValue("mandriva64Guest")
    MANDRIVA_64_GUEST("mandriva64Guest"),
    @XmlEnumValue("turboLinuxGuest")
    TURBO_LINUX_GUEST("turboLinuxGuest"),
    @XmlEnumValue("turboLinux64Guest")
    TURBO_LINUX_64_GUEST("turboLinux64Guest"),
    @XmlEnumValue("ubuntuGuest")
    UBUNTU_GUEST("ubuntuGuest"),
    @XmlEnumValue("ubuntu64Guest")
    UBUNTU_64_GUEST("ubuntu64Guest"),
    @XmlEnumValue("debian4Guest")
    DEBIAN_4_GUEST("debian4Guest"),
    @XmlEnumValue("debian4_64Guest")
    DEBIAN_4_64_GUEST("debian4_64Guest"),
    @XmlEnumValue("debian5Guest")
    DEBIAN_5_GUEST("debian5Guest"),
    @XmlEnumValue("debian5_64Guest")
    DEBIAN_5_64_GUEST("debian5_64Guest"),
    @XmlEnumValue("debian6Guest")
    DEBIAN_6_GUEST("debian6Guest"),
    @XmlEnumValue("debian6_64Guest")
    DEBIAN_6_64_GUEST("debian6_64Guest"),
    @XmlEnumValue("asianux3Guest")
    ASIANUX_3_GUEST("asianux3Guest"),
    @XmlEnumValue("asianux3_64Guest")
    ASIANUX_3_64_GUEST("asianux3_64Guest"),
    @XmlEnumValue("asianux4Guest")
    ASIANUX_4_GUEST("asianux4Guest"),
    @XmlEnumValue("asianux4_64Guest")
    ASIANUX_4_64_GUEST("asianux4_64Guest"),
    @XmlEnumValue("opensuseGuest")
    OPENSUSE_GUEST("opensuseGuest"),
    @XmlEnumValue("opensuse64Guest")
    OPENSUSE_64_GUEST("opensuse64Guest"),
    @XmlEnumValue("fedoraGuest")
    FEDORA_GUEST("fedoraGuest"),
    @XmlEnumValue("fedora64Guest")
    FEDORA_64_GUEST("fedora64Guest"),
    @XmlEnumValue("other24xLinuxGuest")
    OTHER_24_X_LINUX_GUEST("other24xLinuxGuest"),
    @XmlEnumValue("other26xLinuxGuest")
    OTHER_26_X_LINUX_GUEST("other26xLinuxGuest"),
    @XmlEnumValue("otherLinuxGuest")
    OTHER_LINUX_GUEST("otherLinuxGuest"),
    @XmlEnumValue("other24xLinux64Guest")
    OTHER_24_X_LINUX_64_GUEST("other24xLinux64Guest"),
    @XmlEnumValue("other26xLinux64Guest")
    OTHER_26_X_LINUX_64_GUEST("other26xLinux64Guest"),
    @XmlEnumValue("otherLinux64Guest")
    OTHER_LINUX_64_GUEST("otherLinux64Guest"),
    @XmlEnumValue("solaris6Guest")
    SOLARIS_6_GUEST("solaris6Guest"),
    @XmlEnumValue("solaris7Guest")
    SOLARIS_7_GUEST("solaris7Guest"),
    @XmlEnumValue("solaris8Guest")
    SOLARIS_8_GUEST("solaris8Guest"),
    @XmlEnumValue("solaris9Guest")
    SOLARIS_9_GUEST("solaris9Guest"),
    @XmlEnumValue("solaris10Guest")
    SOLARIS_10_GUEST("solaris10Guest"),
    @XmlEnumValue("solaris10_64Guest")
    SOLARIS_10_64_GUEST("solaris10_64Guest"),
    @XmlEnumValue("solaris11_64Guest")
    SOLARIS_11_64_GUEST("solaris11_64Guest"),
    @XmlEnumValue("os2Guest")
    OS_2_GUEST("os2Guest"),
    @XmlEnumValue("eComStationGuest")
    E_COM_STATION_GUEST("eComStationGuest"),
    @XmlEnumValue("eComStation2Guest")
    E_COM_STATION_2_GUEST("eComStation2Guest"),
    @XmlEnumValue("netware4Guest")
    NETWARE_4_GUEST("netware4Guest"),
    @XmlEnumValue("netware5Guest")
    NETWARE_5_GUEST("netware5Guest"),
    @XmlEnumValue("netware6Guest")
    NETWARE_6_GUEST("netware6Guest"),
    @XmlEnumValue("openServer5Guest")
    OPEN_SERVER_5_GUEST("openServer5Guest"),
    @XmlEnumValue("openServer6Guest")
    OPEN_SERVER_6_GUEST("openServer6Guest"),
    @XmlEnumValue("unixWare7Guest")
    UNIX_WARE_7_GUEST("unixWare7Guest"),
    @XmlEnumValue("darwinGuest")
    DARWIN_GUEST("darwinGuest"),
    @XmlEnumValue("darwin64Guest")
    DARWIN_64_GUEST("darwin64Guest"),
    @XmlEnumValue("darwin10Guest")
    DARWIN_10_GUEST("darwin10Guest"),
    @XmlEnumValue("darwin10_64Guest")
    DARWIN_10_64_GUEST("darwin10_64Guest"),
    @XmlEnumValue("darwin11Guest")
    DARWIN_11_GUEST("darwin11Guest"),
    @XmlEnumValue("darwin11_64Guest")
    DARWIN_11_64_GUEST("darwin11_64Guest"),
    @XmlEnumValue("vmkernelGuest")
    VMKERNEL_GUEST("vmkernelGuest"),
    @XmlEnumValue("vmkernel5Guest")
    VMKERNEL_5_GUEST("vmkernel5Guest"),
    @XmlEnumValue("otherGuest")
    OTHER_GUEST("otherGuest"),
    @XmlEnumValue("otherGuest64")
    OTHER_GUEST_64("otherGuest64");
    private final String value;

    VirtualMachineGuestOsIdentifier(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirtualMachineGuestOsIdentifier fromValue(String v) {
        for (VirtualMachineGuestOsIdentifier c: VirtualMachineGuestOsIdentifier.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
