
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareDVSHealthCheckConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VMwareDVSHealthCheckConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DVSHealthCheckConfig">
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
@XmlType(name = "VMwareDVSHealthCheckConfig")
@XmlSeeAlso({
    VMwareDVSTeamingHealthCheckConfig.class,
    VMwareDVSVlanMtuHealthCheckConfig.class
})
public class VMwareDVSHealthCheckConfig
    extends DVSHealthCheckConfig
{


}
