
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestOperationsFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuestOperationsFault">
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
@XmlType(name = "GuestOperationsFault")
@XmlSeeAlso({
    GuestPermissionDenied.class,
    InvalidGuestLogin.class,
    GuestComponentsOutOfDate.class,
    TooManyGuestLogons.class,
    OperationNotSupportedByGuest.class,
    OperationDisabledByGuest.class,
    GuestAuthenticationChallenge.class,
    GuestProcessNotFound.class,
    GuestOperationsUnavailable.class
})
public class GuestOperationsFault
    extends VimFault
{


}
