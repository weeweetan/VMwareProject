
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfExport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfExport">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfFault">
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
@XmlType(name = "OvfExport")
@XmlSeeAlso({
    OvfExportFailed.class,
    OvfDuplicatedPropertyIdExport.class,
    ConnectedIso.class,
    OvfDuplicatedPropertyIdImport.class,
    OvfPropertyExport.class,
    OvfPropertyNetworkExport.class,
    OvfHardwareExport.class
})
public class OvfExport
    extends OvfFault
{


}
