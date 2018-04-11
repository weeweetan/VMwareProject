
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfSystemFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfSystemFault">
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
@XmlType(name = "OvfSystemFault")
@XmlSeeAlso({
    OvfUnsupportedDeviceBackingOption.class,
    OvfToXmlUnsupportedElement.class,
    OvfUnknownEntity.class,
    OvfUnknownDevice.class,
    OvfInternalError.class,
    OvfHostValueNotParsed.class,
    OvfUnsupportedDeviceBackingInfo.class,
    OvfDiskMappingNotFound.class
})
public class OvfSystemFault
    extends OvfFault
{


}
