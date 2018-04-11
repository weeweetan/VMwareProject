
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostConfigFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostConfigFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VimFault">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostConfigFault")
@XmlSeeAlso({
    BlockedByFirewall.class,
    HostInDomain.class,
    HostConfigFailed.class,
    AdminNotDisabled.class,
    NoVirtualNic.class,
    InvalidHostName.class,
    ClockSkew.class,
    PlatformConfigFault.class,
    NoGateway.class,
    DisableAdminNotSupported.class,
    NasConfigFault.class,
    VmfsMountFault.class,
    AdminDisabled.class
})
public class HostConfigFault
    extends VimFault
{


}
