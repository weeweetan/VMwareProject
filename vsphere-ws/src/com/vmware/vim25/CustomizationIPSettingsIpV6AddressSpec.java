
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationIPSettingsIpV6AddressSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomizationIPSettingsIpV6AddressSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="ip" type="{urn:vim25}CustomizationIpV6Generator" maxOccurs="unbounded"/>
 *         &lt;element name="gateway" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomizationIPSettingsIpV6AddressSpec", propOrder = {
    "ip",
    "gateway"
})
public class CustomizationIPSettingsIpV6AddressSpec
    extends DynamicData
{

    @XmlElement(required = true)
    protected List<CustomizationIpV6Generator> ip;
    protected List<String> gateway;

    /**
     * Gets the value of the ip property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ip property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomizationIpV6Generator }
     * 
     * 
     */
    public List<CustomizationIpV6Generator> getIp() {
        if (ip == null) {
            ip = new ArrayList<CustomizationIpV6Generator>();
        }
        return this.ip;
    }

    /**
     * Gets the value of the gateway property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gateway property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGateway().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGateway() {
        if (gateway == null) {
            gateway = new ArrayList<String>();
        }
        return this.gateway;
    }

}
