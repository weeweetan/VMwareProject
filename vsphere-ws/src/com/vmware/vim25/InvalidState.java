
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvalidState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvalidState">
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
@XmlType(name = "InvalidState")
@XmlSeeAlso({
    OvfConsumerPowerOnFault.class,
    NoActiveHostInCluster.class,
    QuestionPending.class,
    MksConnectionLimitReached.class,
    InvalidPowerState.class,
    VmPowerOnDisabled.class,
    CannotPowerOffVmInCluster.class,
    InvalidHostState.class,
    InvalidDatastoreState.class
})
public class InvalidState
    extends VimFault
{


}
