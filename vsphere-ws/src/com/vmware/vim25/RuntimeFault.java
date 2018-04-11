
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RuntimeFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RuntimeFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}MethodFault">
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
@XmlType(name = "RuntimeFault")
@XmlSeeAlso({
    ManagedObjectNotFound.class,
    CannotDisableDrsOnClustersWithVApps.class,
    LicenseAssignmentFailed.class,
    MethodDisabled.class,
    InvalidProfileReferenceHost.class,
    NotImplemented.class,
    MethodAlreadyDisabledFault.class,
    UnexpectedFault.class,
    RequestCanceled.class,
    DisallowedOperationOnFailoverHost.class,
    VAppOperationInProgress.class,
    InvalidRequest.class,
    ConflictingDatastoreFound.class,
    DatabaseError.class,
    FailToLockFaultToleranceVMs.class,
    OperationDisallowedOnHost.class,
    ThirdPartyLicenseAssignmentFailed.class,
    HostCommunication.class,
    DisallowedChangeByService.class,
    NotSupported.class,
    SystemError.class,
    NotEnoughLicenses.class,
    InvalidArgument.class,
    SecurityError.class
})
public class RuntimeFault
    extends MethodFault
{


}
