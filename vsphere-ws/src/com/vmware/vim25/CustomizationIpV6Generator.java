
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationIpV6Generator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomizationIpV6Generator">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
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
@XmlType(name = "CustomizationIpV6Generator")
@XmlSeeAlso({
    CustomizationCustomIpV6Generator.class,
    CustomizationStatelessIpV6Generator.class,
    CustomizationUnknownIpV6Generator.class,
    CustomizationFixedIpV6 .class,
    CustomizationDhcpIpV6Generator.class,
    CustomizationAutoIpV6Generator.class
})
public class CustomizationIpV6Generator
    extends DynamicData
{


}
