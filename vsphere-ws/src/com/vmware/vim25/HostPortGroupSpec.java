
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostPortGroupSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostPortGroupSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vlanId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="vswitchName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="policy" type="{urn:vim25}HostNetworkPolicy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostPortGroupSpec", propOrder = {
    "name",
    "vlanId",
    "vswitchName",
    "policy"
})
public class HostPortGroupSpec
    extends DynamicData
{

    @XmlElement(required = true)
    protected String name;
    protected int vlanId;
    @XmlElement(required = true)
    protected String vswitchName;
    @XmlElement(required = true)
    protected HostNetworkPolicy policy;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the vlanId property.
     * 
     */
    public int getVlanId() {
        return vlanId;
    }

    /**
     * Sets the value of the vlanId property.
     * 
     */
    public void setVlanId(int value) {
        this.vlanId = value;
    }

    /**
     * Gets the value of the vswitchName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVswitchName() {
        return vswitchName;
    }

    /**
     * Sets the value of the vswitchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVswitchName(String value) {
        this.vswitchName = value;
    }

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link HostNetworkPolicy }
     *     
     */
    public HostNetworkPolicy getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostNetworkPolicy }
     *     
     */
    public void setPolicy(HostNetworkPolicy value) {
        this.policy = value;
    }

}
