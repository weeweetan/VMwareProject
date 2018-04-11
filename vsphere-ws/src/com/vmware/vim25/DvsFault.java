
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsFault">
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
@XmlType(name = "DvsFault")
@XmlSeeAlso({
    VspanSameSessionPortConflict.class,
    CollectorAddressUnset.class,
    VspanPortMoveFault.class,
    DvsOperationBulkFault.class,
    BackupBlobReadFailure.class,
    DvsScopeViolated.class,
    RollbackFailure.class,
    SwitchNotInUpgradeMode.class,
    VspanPortConflict.class,
    VspanPortgroupPromiscChangeFault.class,
    ImportOperationBulkFault.class,
    SwitchIpUnset.class,
    VspanPortgroupTypeChangeFault.class,
    VspanPortPromiscChangeFault.class,
    ImportHostAddFailure.class,
    VspanDestPortConflict.class,
    DvsApplyOperationFault.class,
    BackupBlobWriteFailure.class,
    InvalidIpfixConfig.class,
    DvsNotAuthorized.class,
    VspanPromiscuousPortNotSupported.class
})
public class DvsFault
    extends VimFault
{


}
