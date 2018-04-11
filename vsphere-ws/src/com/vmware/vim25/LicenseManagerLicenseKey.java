
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LicenseManagerLicenseKey.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LicenseManagerLicenseKey">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="esxFull"/>
 *     &lt;enumeration value="esxVmtn"/>
 *     &lt;enumeration value="esxExpress"/>
 *     &lt;enumeration value="san"/>
 *     &lt;enumeration value="iscsi"/>
 *     &lt;enumeration value="nas"/>
 *     &lt;enumeration value="vsmp"/>
 *     &lt;enumeration value="backup"/>
 *     &lt;enumeration value="vc"/>
 *     &lt;enumeration value="vcExpress"/>
 *     &lt;enumeration value="esxHost"/>
 *     &lt;enumeration value="gsxHost"/>
 *     &lt;enumeration value="serverHost"/>
 *     &lt;enumeration value="drsPower"/>
 *     &lt;enumeration value="vmotion"/>
 *     &lt;enumeration value="drs"/>
 *     &lt;enumeration value="das"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LicenseManagerLicenseKey")
@XmlEnum
public enum LicenseManagerLicenseKey {

    @XmlEnumValue("esxFull")
    ESX_FULL("esxFull"),
    @XmlEnumValue("esxVmtn")
    ESX_VMTN("esxVmtn"),
    @XmlEnumValue("esxExpress")
    ESX_EXPRESS("esxExpress"),
    @XmlEnumValue("san")
    SAN("san"),
    @XmlEnumValue("iscsi")
    ISCSI("iscsi"),
    @XmlEnumValue("nas")
    NAS("nas"),
    @XmlEnumValue("vsmp")
    VSMP("vsmp"),
    @XmlEnumValue("backup")
    BACKUP("backup"),
    @XmlEnumValue("vc")
    VC("vc"),
    @XmlEnumValue("vcExpress")
    VC_EXPRESS("vcExpress"),
    @XmlEnumValue("esxHost")
    ESX_HOST("esxHost"),
    @XmlEnumValue("gsxHost")
    GSX_HOST("gsxHost"),
    @XmlEnumValue("serverHost")
    SERVER_HOST("serverHost"),
    @XmlEnumValue("drsPower")
    DRS_POWER("drsPower"),
    @XmlEnumValue("vmotion")
    VMOTION("vmotion"),
    @XmlEnumValue("drs")
    DRS("drs"),
    @XmlEnumValue("das")
    DAS("das");
    private final String value;

    LicenseManagerLicenseKey(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LicenseManagerLicenseKey fromValue(String v) {
        for (LicenseManagerLicenseKey c: LicenseManagerLicenseKey.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
