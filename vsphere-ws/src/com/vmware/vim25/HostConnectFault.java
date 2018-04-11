
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostConnectFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostConnectFault">
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
@XmlType(name = "HostConnectFault")
@XmlSeeAlso({
    CannotAddHostWithFTVmToDifferentCluster.class,
    SSLVerifyFault.class,
    CannotAddHostWithFTVmAsStandalone.class,
    TooManyHosts.class,
    SSLDisabledFault.class,
    ReadHostResourcePoolTreeFailed.class,
    AlreadyConnected.class,
    CannotAddHostWithFTVmToNonHACluster.class,
    NoHost.class,
    AgentInstallFailed.class,
    MultipleCertificatesVerifyFault.class,
    AlreadyBeingManaged.class,
    NotSupportedHost.class,
    NoPermissionOnHost.class
})
public class HostConnectFault
    extends VimFault
{


}
